package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sachAdminModal.sachAdmin;
import sachAdminModal.sachAdminBO;

/**
 * Servlet implementation class xoaSachController
 */
@WebServlet("/xoaSachController")
public class xoaSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoaSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maSach = request.getParameter("maSach"); // Lấy mã sách từ URL
        String tenSach = request.getParameter("tenSach");
        sachAdminBO sachBO = new sachAdminBO();
        
        try {
            boolean isDeleted = sachBO.xoaSach(maSach); // Gọi hàm xóa sách
            if (isDeleted) {
                request.setAttribute("message", "Xóa thành công sách: " + tenSach);
            }
        } catch (Exception e) {
            //
        }

        // Chuyển hướng về trang danh sách
        RequestDispatcher rd = request.getRequestDispatcher("sachAdminController");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    			doGet(request, response);
    }

}
