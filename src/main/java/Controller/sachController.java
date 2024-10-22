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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // Chuyển đổi sang tiếng việt
		response.setCharacterEncoding("UTF-8");
		
		// Lấy loại về
		LoaiBO lbo = new LoaiBO();
		
		//Chuyển dsloại sang home.jsp để hiển thị
		request.setAttribute("dsloai", lbo.getLoai());
		SachBO sbo = new SachBO();
		ArrayList<Sach> ds = sbo.getSach();
		
		String ml = request.getParameter("ml"); //tìm kiếm mã loại
		String key = request.getParameter("txttk"); // tìm kiếm sách
		
		if (ml != null)
			ds = sbo.TimMa(ml);
		else if (key != null)
			ds = sbo.Tim(key);
		
		request.setAttribute("dssach", ds);
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
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
