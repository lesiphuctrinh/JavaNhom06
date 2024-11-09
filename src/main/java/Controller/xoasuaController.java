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

        // Lấy danh sách các sản phẩm đã chọn để xóa
        String[] gtck = request.getParameterValues("ck");
        if (request.getParameter("xoachon") != null && gtck != null) { // Nếu chọn xóa sản phẩm đã chọn
            for (String ms : gtck) {
                gh.xoa(ms); // Gọi phương thức xoa trong giohangbo để xóa sản phẩm
            }
        }

        // Xóa một sản phẩm cụ thể theo mã sách
        String xoamot = request.getParameter("msxoa");
        if (xoamot != null) {
            gh.xoa(xoamot); // Gọi phương thức xoa trong giohangbo để xóa sản phẩm
        }

        // Cập nhật số lượng sản phẩm khi người dùng thay đổi số lượng
        String mssua = request.getParameter("butsuasl");
        if (mssua != null) {
            String slsua = request.getParameter(mssua); // Lấy số lượng mới
            if (slsua != null) {
                gh.Them(mssua, "", (long) 0, Long.parseLong(slsua)); // Cập nhật lại số lượng
            }
        }

        // Cập nhật lại giỏ hàng trong session
        session.setAttribute("gh", gh);

        // Cập nhật số lượng giỏ hàng trong session (để hiển thị ở navbar)
        session.setAttribute("giohangCount", gh.getSoluong());

        // Quay lại trang giỏ hàng
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
