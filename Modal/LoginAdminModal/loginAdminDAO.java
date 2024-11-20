package LoginAdminModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ketnoiModal.KetNoi;
import khachhangModal.KhachHang;

public class loginAdminDAO {
	public String ktdangnhap(String tendn, String pass) throws ClassNotFoundException, SQLException {
		
		// b1: kết nối
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: tạo câu lệnh sql
		String sql = "select * from DangNhap where TenDangNhap = ? and  MatKhau = ?";
		// b3: thực hiện câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, tendn);
		cmd.setString(2, pass);
		
		ResultSet rs = cmd.executeQuery();
		String kt = null;
		if(rs.next()) { // đăng nhập đúng
			kt = tendn;	
		}
		rs.close();
		kn.cn.close();
		return kt;

	}
}
