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
}
