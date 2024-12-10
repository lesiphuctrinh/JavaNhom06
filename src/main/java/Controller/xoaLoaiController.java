package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LoaiModal.LoaiBO;
import sachAdminModal.sachAdminBO;

/**
 * Servlet implementation class xoaLoaiController
 */
@WebServlet("/xoaLoaiController")
public class xoaLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoaLoaiController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maLoai = request.getParameter("maLoai"); // Lấy mã sách từ URL
        String tenLoai = request.getParameter("tenLoai");
        LoaiBO lBO = new LoaiBO();
        
        try {
            boolean isDeleted = lBO.xoaLoai(maLoai); // Gọi hàm xóa loại
            if (isDeleted) {
                request.setAttribute("message", "Xóa thành công loại: " + tenLoai);
            }
        } catch (Exception e) {
            //
        }

        // Chuyển hướng về trang danh sách
        RequestDispatcher rd = request.getRequestDispatcher("loaiAdminController");
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
