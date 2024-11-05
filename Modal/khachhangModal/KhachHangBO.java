package khachhangModal;

import java.sql.SQLException;

public class KhachHangBO {
	KhachHangDAO khdao = new KhachHangDAO();
	
	public KhachHang ktdangnhap(String tendn, String pass) throws ClassNotFoundException, SQLException {
		return khdao.ktdangnhap(tendn, pass);
	}
}
