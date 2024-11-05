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
            request.setCharacterEncoding("UTF-8"); // Chuyển đổi sang tiếng việt
            response.setCharacterEncoding("UTF-8");

            // Lấy loại về
            LoaiBO lbo = new LoaiBO();
            request.setAttribute("dsloai", lbo.getLoai());

            // Khởi tạo SachBO và lấy danh sách sách
            SachBO sbo = new SachBO();
            ArrayList<Sach> ds = sbo.getSach();

            String ml = request.getParameter("ml"); // Tìm kiếm mã loại
            String key = request.getParameter("txttk"); // Tìm kiếm sách

            // Lọc sách theo loại hoặc theo từ khóa
            if (ml != null) {
                ds = sbo.TimMa(ml);
            } else if (key != null) {
                ds = sbo.Tim(key);
            }

            // Phân trang
            int totalItems = ds.size(); // Tổng số sách
            int itemsPerPage = 6; // Số sách mỗi trang
            int currentPage = request.getParameter("page") != null ? Integer.parseInt(request.getParameter("page")) : 1;
            int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
            int startIndex = (currentPage - 1) * itemsPerPage;
            int endIndex = Math.min(startIndex + itemsPerPage, totalItems);

            // Lấy danh sách sách cho trang hiện tại
            ArrayList<Sach> paginatedList = new ArrayList<>(ds.subList(startIndex, endIndex));

            request.setAttribute("dssach", paginatedList);
            request.setAttribute("currentPage", currentPage);
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