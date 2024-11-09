package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoaiModal.LoaiBO;
import SachModal.Sach;
import SachModal.SachBO;

/**
 * Servlet implementation class sachController
 */
@WebServlet("/sachController")
public class sachController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public sachController() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8"); // Chuyển đổi sang tiếng Việt
            response.setCharacterEncoding("UTF-8");

            // Lấy danh sách loại sách
            LoaiBO lbo = new LoaiBO();
            request.setAttribute("dsloai", lbo.getLoai());

            // Khởi tạo SachBO
            SachBO sbo = new SachBO();

            // Nhận giá trị tìm kiếm
            String searchValue = request.getParameter("txttk") != null ? request.getParameter("txttk") : ""; // Tìm theo từ khóa
            String ml = request.getParameter("ml"); // Tìm theo mã loại

            // Khởi tạo danh sách sách
            ArrayList<Sach> ds = new ArrayList<>();
            int page = 1;
            
            // Tạo danh sách sách tùy theo mã loại hoặc từ khóa
            if (ml != null && !ml.isEmpty()) {
                ds = sbo.TimMaLoai(ml); // Tìm kiếm theo mã loại
            } else {
                // Phân trang
                try {
                    page = Integer.parseInt(request.getParameter("page"));
                    if (page < 1) page = 1;
                } catch (NumberFormatException e) {
                    page = 1;
                }
                
                // Lấy danh sách sách theo từ khóa với phân trang
                int PageSize = 6; // Số sách mỗi trang
                ds = sbo.getSach(searchValue, page, PageSize); // Tìm sách với từ khóa và phân trang
            }

            // Tính tổng số sách và tổng số trang
            int totalItems = sbo.getTongSach(searchValue); // Lấy tổng số sách tùy theo tìm kiếm
            int totalPages = (int) Math.ceil((double) totalItems / 6); // Tính tổng số trang

            // Lấy danh sách sách cho trang hiện tại
            request.setAttribute("dssach", ds);
            request.setAttribute("currentPage", page);
            request.setAttribute("totalPages", totalPages);

            RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}