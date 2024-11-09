package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import giohangModal.giohangbo;

/**
 * Servlet implementation class giohangController
 */
@WebServlet("/giohangController")
public class giohangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	String masach = request.getParameter("ms");
	        String tensach = request.getParameter("ts");
	        String gia = request.getParameter("gia");

	        if (masach != null && tensach != null && gia != null) {
	            giohangbo gh = null;
	            HttpSession session = request.getSession();
	            if (session.getAttribute("gh") == null) {
	                gh = new giohangbo();
	                session.setAttribute("gh", gh);
	            }
	            gh = (giohangbo) session.getAttribute("gh");
	            gh.Them(masach, tensach, Long.parseLong(gia), (long) 1);
	            session.setAttribute("gh", gh);

	            // Cập nhật số lượng giỏ hàng vào session (số lượng sản phẩm trong giỏ)
	            session.setAttribute("giohangCount", gh.getSoluong());

	            response.sendRedirect("htgioController");
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
