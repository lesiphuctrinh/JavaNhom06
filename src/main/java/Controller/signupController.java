package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khachhangModal.KhachHang;
import khachhangModal.KhachHangDAO;

/**
 * Servlet implementation class signupController
 */
@WebServlet("/signupController")
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển hướng đến trang đăng ký khi có yêu cầu GET
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	request.setCharacterEncoding("UTF-8"); // Chuyển đổi sang tiếng việt
        response.setCharacterEncoding("UTF-8");
    	// Lấy dữ liệu từ form đăng ký
        String hoten = request.getParameter("hoten");
        String email = request.getParameter("email");
        String tendn = request.getParameter("tendn");
        String matkhau = request.getParameter("matkhau");
        String confirmMatkhau = request.getParameter("confirm_matkhau");

        // Kiểm tra xem mật khẩu và xác nhận mật khẩu có khớp không
        if (!matkhau.equals(confirmMatkhau)) {
            request.setAttribute("errorMessage", "Mật khẩu không khớp!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        // Gọi phương thức ktdangky từ KhachHangDAO để thực hiện đăng ký
        KhachHangDAO khachHangDAO = new KhachHangDAO();
        try {
            // Thực hiện đăng ký
            KhachHang kh = khachHangDAO.ktdangky(hoten, email, tendn, matkhau);
            if (kh != null) {
                // Nếu đăng ký thành công, chuyển hướng đến trang đăng nhập
                response.sendRedirect("loginController");
            } else {
                // Nếu đăng ký thất bại (ví dụ, tên đăng nhập đã tồn tại), hiển thị lỗi
                request.setAttribute("errorMessage", "Đăng ký không thành công, vui lòng thử lại!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Xử lý lỗi khi kết nối hoặc thực hiện thao tác SQL
            e.printStackTrace();
            request.setAttribute("errorMessage", "Có lỗi xảy ra, vui lòng thử lại sau!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }

}
