package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import khachhangModal.KhachHang;
import khachhangModal.KhachHangBO;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String username = request.getParameter("dangnhap");
			 String password = request.getParameter("matkhau");
				if(username != null && password != null){
					KhachHangBO khbo = new KhachHangBO();
					KhachHang kh = khbo.ktdangnhap(username, password);
					
					if (kh != null) {
						HttpSession session = request.getSession();
						session.setAttribute("dn", kh);
				        response.sendRedirect("sachController");
				        return;
				    }  
					else
				    	request.setAttribute("tb", "Đăng nhập sai. Vui lòng nhập lại!");
				}
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
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
