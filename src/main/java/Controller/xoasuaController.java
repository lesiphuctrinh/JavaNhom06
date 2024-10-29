package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import giohangModal.giohangbo;

/**
 * Servlet implementation class xoasuaController
 */
@WebServlet("/xoasuaController")
public class xoasuaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xoasuaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		giohangbo gh = (giohangbo) session.getAttribute("gh");
		String[] gtck = request.getParameterValues("ck");
		if (request.getParameter("xoachon") != null) {//Can xoa cac sach da chon
			for (String ms : gtck)
				gh.xoa(ms);
		}
		
		String xoamot = request.getParameter("msxoa"); // xoa mot sach
		if(xoamot != null){
			gh.xoa(xoamot);
		}
		
		String mssua = request.getParameter("butsuasl");
		String slsua = request.getParameter(mssua);
		if (mssua != null) {//Can sua sl
			gh.Them(mssua, "", (long) 0, Long.parseLong(slsua));
		}
		session.setAttribute("gh", gh);
		response.sendRedirect("htgioController");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
