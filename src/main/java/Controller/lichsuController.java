package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LoaiModal.LoaiBO;
import khachhangModal.KhachHang;
import lichsuModal.lichsu;
import lichsuModal.lichsuBO;

/**
 * Servlet implementation class lichsuController
 */
@WebServlet("/lichsuController")
public class lichsuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // Chuyển đổi sang tiếng Việt
        response.setCharacterEncoding("UTF-8");
        try {
        	HttpSession session = request.getSession();

             if(session.getAttribute("dn") == null) {
             	response.sendRedirect("loginController");
             } 
             else {
             	KhachHang kh = (KhachHang) session.getAttribute("dn");
             	lichsuBO bo = new lichsuBO();
     			request.setAttribute("dslichsu", bo.getLichSu(kh.getMakh()));
             	LoaiBO lbo = new LoaiBO();
         		request.setAttribute("dsloai", lbo.getLoai());
     				
     			request.getRequestDispatcher("lichsu.jsp").forward(request, response);
             }
        }catch (Exception e) {
			// TODO: handle exception
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
