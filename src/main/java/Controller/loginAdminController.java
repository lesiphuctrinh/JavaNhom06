package Controller;

import java.io.IOException;
import java.rmi.Remote;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import LoginAdminModal.loginAdminBO;
import khachhangModal.KhachHang;
import khachhangModal.KhachHangBO;
import nl.captcha.Captcha;

/**
 * Servlet implementation class loginAdminController
 */
@WebServlet("/loginAdminController")
public class loginAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			
			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			request.setCharacterEncoding("UTF-8");
			String answer = request.getParameter("answer");
			
			String username = request.getParameter("dangnhap");
			String password = request.getParameter("matkhau");
			
				if(session.getAttribute("dem") != null) {
					int d = (int)session.getAttribute("dem");
					if(answer != null) {
						if(d >= 3 && !captcha.isCorrect(answer)) {
							RequestDispatcher rd = request.getRequestDispatcher("loginAdmin.jsp");
							rd.forward(request, response);
						}
					}
				}
				
				if(username != null && password != null){
					loginAdminBO dnbo = new loginAdminBO();
					String kh = dnbo.ktdangnhap(username, password);
					
					if (kh != null) {
						//Xử lý
						session.setAttribute("dnadmin", kh);
				        response.sendRedirect("adminController");
				        return;
				    }  
					else
						if(session.getAttribute("dem") == null) {
							session.setAttribute("dem", (int) 0);
						}
						int d = (int) session.getAttribute("dem");
						d++;
						session.setAttribute("dem", d);
				    	request.setAttribute("tb", "Đăng nhập sai. Vui lòng nhập lại!");
				}
				RequestDispatcher rd = request.getRequestDispatcher("loginAdmin.jsp");
				rd.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
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
