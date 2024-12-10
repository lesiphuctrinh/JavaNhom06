package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sachAdminModal.sachAdmin;
import sachAdminModal.sachAdminBO;
import xacnhanAdminModal.xacnhan;
import xacnhanAdminModal.xacnhanBO;

/**
 * Servlet implementation class xacnhanAdminController
 */
@WebServlet("/xacnhanAdminController")
public class xacnhanAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8"); // Đảm bảo encoding tiếng Việt
            response.setCharacterEncoding("UTF-8");

            // Khởi tạo SachAdminBO
            xacnhanBO sbo = new xacnhanBO();

            // Nhận giá trị tìm kiếm
            String searchValue = request.getParameter("timKhachHang") != null ? request.getParameter("timKhachHang") : ""; // Tìm kiếm từ khóa

            // Khởi tạo giá trị mặc định cho phân trang
            int page = 1; // Trang mặc định
            int pageSize = 5; // Số sách mỗi trang
            ArrayList<xacnhan> ds = new ArrayList<>();

            // Lấy số trang từ tham số "page"
            try {
                page = Integer.parseInt(request.getParameter("page"));
                if (page < 1) {
                    page = 1; // Không cho phép giá trị âm hoặc 0
                }
            } catch (NumberFormatException e) {
                page = 1; // Nếu không hợp lệ, mặc định là trang 1
            }

            // Lấy danh sách sách theo từ khóa với phân trang
            ds = sbo.getXacNhan(searchValue, page, pageSize);

            // Tính tổng số sách và tổng số trang
            int totalItems = sbo.getTongDonHang(searchValue); // Tổng số sách theo từ khóa
            int totalPages = (int) Math.ceil((double) totalItems / pageSize); // Tổng số trang

            // Đảm bảo trang hiện tại không vượt quá tổng số trang
            if (page > totalPages) {
                page = totalPages;
                ds = sbo.getXacNhan(searchValue, page, pageSize); // Lấy lại danh sách cho trang cuối
            }

            // Set thuộc tính cho request
            request.setAttribute("dsdonhang", ds);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);

            // Forward sang giao diện JSP
            RequestDispatcher rd = request.getRequestDispatcher("xacnhanAdmin.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(); // Ghi log lỗi (tùy chỉnh nếu cần)
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra trong hệ thống");
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
