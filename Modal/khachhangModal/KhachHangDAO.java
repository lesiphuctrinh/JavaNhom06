package khachhangModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import ketnoiModal.KetNoi;

public class KhachHangDAO {
	public KhachHang ktdangnhap(String tendn, String pass) throws ClassNotFoundException, SQLException {
		
		// b1: kết nối
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: tạo câu lệnh sql
		String sql = "select * from KhachHang where tendn = ? and  pass = ?";
		// b3: thực hiện câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		
		ResultSet rs = cmd.executeQuery();
		KhachHang kh = null;
		if(rs.next()) { // đăng nhập đúng
			// tạo ra khách hàng
			long makh = rs.getLong("makh");
			String hoten = rs.getString("hoten");
			String diachi = rs.getString("diachi");
			String sodt = rs.getString("sodt");
			String email = rs.getString("email");
			
			kh = new KhachHang(makh, hoten, diachi, sodt, email, tendn, pass);
		}
		rs.close();
		kn.cn.close();
		return kh;

	}
	public KhachHang ktdangky(String hoten, String email, String tendn, String pass) throws ClassNotFoundException, SQLException {
        // B1: Kết nối
        KetNoi kn = new KetNoi();
        kn.ketnoi();

        // B2: Tạo câu lệnh SQL để thêm khách hàng vào bảng KhachHang
        String sqlInsertKhachHang = "INSERT INTO KhachHang (hoten, email, tendn, pass) VALUES (?, ?, ?, ?)";
        PreparedStatement pskh = kn.cn.prepareStatement(sqlInsertKhachHang, PreparedStatement.RETURN_GENERATED_KEYS);
        pskh.setString(1, hoten);
        pskh.setString(2, email);
        pskh.setString(3, tendn);
        pskh.setString(4, pass);

        int khachHangResult = pskh.executeUpdate();
        ResultSet generatedKeys = pskh.getGeneratedKeys();

        long makh = -1;
        if (generatedKeys.next()) {
            makh = generatedKeys.getLong(1); // Lấy khóa chính được sinh ra cho khách hàng mới
        }

        // B3: Tạo câu lệnh SQL để thêm thông tin đăng nhập vào bảng DangNhap
        String sqlInsertDangNhap = "INSERT INTO DangNhap (TenDangNhap, MatKhau, Quyen) VALUES (?, ?, ?)";
        PreparedStatement psdn = kn.cn.prepareStatement(sqlInsertDangNhap);
        psdn.setString(1, tendn);
        psdn.setString(2, pass);
        psdn.setInt(3, 1); // Giả sử 1 là quyền người dùng mặc định

        int dangNhapResult = psdn.executeUpdate();

        // Đóng tài nguyên
        pskh.close();
        psdn.close();
        kn.cn.close();

        // Nếu cả hai lệnh đều thành công, trả về đối tượng KhachHang mới
        if (khachHangResult > 0 && dangNhapResult > 0) {
            return new KhachHang(makh, hoten, null, null, email, tendn, pass);
        }

        // Nếu không thành công, trả về null
        return null;
    }
}
