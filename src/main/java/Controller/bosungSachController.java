package Controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import LoaiModal.LoaiBO;
import sachAdminModal.sachAdminBO;
import sachAdminModal.sachAdminDAO;

/**
 * Servlet implementation class bosungSachController
 */
@WebServlet("/bosungSachController")
public class bosungSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bosungSachController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean isSuccess = true; // Trạng thái xử lý
        String errorMessage = null; // Lưu trữ thông báo lỗi nếu có

        if (ServletFileUpload.isMultipartContent(request)) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            String dirUrl = request.getServletContext().getRealPath("") + File.separator + "images";
            File dir = new File(dirUrl);
            if (!dir.exists()) {
                dir.mkdir();
            }

            try {
                List<FileItem> fileItems = upload.parseRequest(request);

                // Khởi tạo các biến để nhận dữ liệu từ form
                String maSach = null, tenSach = null, tacGia = null, maLoai = null, anh = null;
                Long soLuong = null, gia = null;

                for (FileItem fileItem : fileItems) {
                    if (!fileItem.isFormField()) { // Nếu là file
                        String fileName = fileItem.getName();
                        if (!fileName.equals("")) {
                            String filePath = dirUrl + File.separator + fileName;
                            File file = new File(filePath);
                            fileItem.write(file); // Lưu file vào thư mục
                            anh = "images/" + fileName; // Đường dẫn để lưu vào cơ sở dữ liệu
                        }
                    } else { // Nếu là các trường form
                        String fieldName = fileItem.getFieldName();
                        String value = fileItem.getString("UTF-8");

                        switch (fieldName) {
                            case "maSach": maSach = value; break;
                            case "tenSach": tenSach = value; break;
                            case "tacGia": tacGia = value; break;
                            case "soLuong": soLuong = Long.parseLong(value); break;
                            case "gia": gia = Long.parseLong(value); break;
                            case "maLoai": maLoai = value; break;
                        }
                    }
                }
                //Kiểm tra thông tin đầu vào
                if (maSach == null || maSach.trim().isEmpty()) {
                    request.setAttribute("errorMessage", "Mã sách không được để trống!");
                    RequestDispatcher rd = request.getRequestDispatcher("BoSungSach.jsp");
                    rd.forward(request, response);
                    return;
                }
                if (tenSach == null || tenSach.trim().isEmpty()) {
                    request.setAttribute("errorMessage", "Tên sách không được để trống!");
                    RequestDispatcher rd = request.getRequestDispatcher("BoSungSach.jsp");
                    rd.forward(request, response);
                    return;
                }
                if (tacGia == null || tacGia.trim().isEmpty()) {
                    request.setAttribute("errorMessage", "Tác giả không được để trống!");
                    RequestDispatcher rd = request.getRequestDispatcher("BoSungSach.jsp");
                    rd.forward(request, response);
                    return;
                }
                if (anh == null || anh.trim().isEmpty()) {
                    request.setAttribute("errorMessage", "Ảnh không được để trống!");
                    RequestDispatcher rd = request.getRequestDispatcher("BoSungSach.jsp");
                    rd.forward(request, response);
                    return;
                }                
                if (maLoai == null || maLoai.trim().isEmpty()) {
                    request.setAttribute("errorMessage", "Mã loại không được để trống!");
                    RequestDispatcher rd = request.getRequestDispatcher("BoSungSach.jsp");
                    rd.forward(request, response);
                    return;
                }
                if (soLuong <= 0) {
                    request.setAttribute("errorMessage", "Số lượng phải lớn hơn 0!");
                    RequestDispatcher rd = request.getRequestDispatcher("BoSungSach.jsp");
                    rd.forward(request, response);
                    return;
                }
                if (gia <= 0) {
                    request.setAttribute("errorMessage", "Giá phải lớn hơn 0!");
                    RequestDispatcher rd = request.getRequestDispatcher("BoSungSach.jsp");
                    rd.forward(request, response);
                    return;
                }
             // Kiểm tra mã sách trùng
                sachAdminBO sachBo = new sachAdminBO();
                if (sachBo.kiemTraMa(maSach)) {
                    isSuccess = false;
                    errorMessage = "Mã sách bị trùng!";
                } else {
                    // Gọi business logic để thêm sách
                    isSuccess = sachBo.boSungSach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai);
                }
                
                
            } catch (FileUploadException | NumberFormatException e) {
                e.printStackTrace();
                isSuccess = false;
                errorMessage = "Đã xảy ra lỗi khi tải dữ liệu lên: " + e.getMessage();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                isSuccess = false;
                errorMessage = "Lỗi cơ sở dữ liệu: " + e.getMessage();
            } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        if (isSuccess) {
            response.sendRedirect("sachAdminController"); // Thành công: chuyển đến trang quản lý
        } else {
            request.setAttribute("errorMessage", errorMessage != null ? errorMessage : "Thêm sách thất bại. Vui lòng kiểm tra lại!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("BoSungSach.jsp");
            dispatcher.forward(request, response); // Thất bại: giữ lại trang bổ sung sách
        }
    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy danh sách loại sách
        LoaiBO lbo = new LoaiBO();
        try {
			request.setAttribute("dsloai", lbo.getLoai());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	// Chuyển đến trang thêm sách
        request.getRequestDispatcher("BoSungSach.jsp").forward(request, response);
    }

}
