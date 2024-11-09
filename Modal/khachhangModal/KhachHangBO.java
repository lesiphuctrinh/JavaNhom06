package khachhangModal;

import java.sql.SQLException;

public class KhachHangBO {
	KhachHangDAO khdao = new KhachHangDAO();
	
	public KhachHang ktdangnhap(String tendn, String pass) throws ClassNotFoundException, SQLException {
		return khdao.ktdangnhap(tendn, pass);
	}
	public KhachHang ktdangky(String hoten, String email, String tendn, String pass) throws ClassNotFoundException, SQLException {
		return khdao.ktdangky(hoten, email, tendn, pass);
	}
}
