package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import chitietModal.chitietHdBO;
import sachAdminModal.sachAdminBO;
import xacnhanAdminModal.xacnhan;
import xacnhanAdminModal.xacnhanBO;

/**
 * Servlet implementation class xacnhanChiTietController
 */
@WebServlet("/xacnhanChiTietController")
public class xacnhanChiTietController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanChiTietController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            // Kiểm tra nếu có tham số mactdh (xác nhận đơn hàng)
            String mactdhParam = request.getParameter("mactdh");
            if (mactdhParam != null) {
                Long mactdh = Long.parseLong(mactdhParam);
                chitietHdBO bo = new chitietHdBO();
                boolean isUpdated = bo.capNhatDonHang(mactdh);  // Cập nhật đơn hàng
                if (isUpdated) {
                	request.setAttribute("Message", "Xác nhận thành công đơn hàng!");
                }
            }

            // Phần xử lý phân trang và hiển thị danh sách đơn hàng
            xacnhanBO sbo = new xacnhanBO();
            String searchValue = request.getParameter("timKhachHang") != null ? request.getParameter("timKhachHang") : ""; // Tìm kiếm từ khóa

            int page = 1;
            int pageSize = 5;
            ArrayList<xacnhan> ds = new ArrayList<>();

            try {
                page = Integer.parseInt(request.getParameter("page"));
                if (page < 1) {
                    page = 1;
                }
            } catch (NumberFormatException e) {
                page = 1;
            }

            ds = sbo.getXacNhan(searchValue, page, pageSize);

            int totalItems = sbo.getTongDonHang(searchValue);
            int totalPages = (int) Math.ceil((double) totalItems / pageSize);

            if (page > totalPages) {
                page = totalPages;
                ds = sbo.getXacNhan(searchValue, page, pageSize);
            }

            request.setAttribute("dsdonhang", ds);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);

            RequestDispatcher rd = request.getRequestDispatcher("xacnhanAdmin.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra trong hệ thống");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response); // Gọi lại doGet vì các xử lý giống nhau
    }


}
