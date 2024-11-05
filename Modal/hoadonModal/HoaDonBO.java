package hoadonModal;

import java.sql.SQLException;

public class HoaDonBO {
	HoaDonDAO hddao = new HoaDonDAO();
	public int Them(long makh) throws ClassNotFoundException, SQLException {
		return hddao.Them(makh);
	}
	public long GetMaxHD() throws ClassNotFoundException, SQLException {
		return hddao.GetMaxHD();
	}
}
