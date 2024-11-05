package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import chitietModal.chitietHdBO;
import chitietModal.chitietHdDAO;
import giohangModal.giohangbo;
import giohangModal.hang;
import hoadonModal.HoaDonBO;
import khachhangModal.KhachHang;

/**
 * Servlet implementation class xacnhanController
 */
@WebServlet("/xacnhanController")
public class xacnhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacnhanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			if(session.getAttribute("dn") == null)
				response.sendRedirect("loginController");
			else {
				giohangbo gh = (giohangbo)session.getAttribute("gh");
				KhachHang kh = (KhachHang)session.getAttribute("dn");
				
				HoaDonBO hdbo = new HoaDonBO();
				hdbo.Them(kh.getMakh()); // Thêm 1 hóa đơn
				long maxhd = hdbo.GetMaxHD();
				chitietHdBO ctbo = new chitietHdBO();
				
				for(hang h: gh.ds) // thêm vào chi tiết hóa đơn
					ctbo.ThemCTHD(h.getMasach(), h.getSoluong(), maxhd);
				//xóa giỏ hàng
				session.removeAttribute("gh");
				response.sendRedirect("lichsuController");
			}
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
