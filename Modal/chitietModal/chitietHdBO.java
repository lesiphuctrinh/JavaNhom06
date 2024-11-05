package chitietModal;

import java.sql.SQLException;

public class chitietHdBO {
	chitietHdDAO ctdao = new chitietHdDAO();
	public int ThemCTHD (String MaSach, long SoLuongMua, long MaHoaDon) throws SQLException, ClassNotFoundException {
		return ctdao.ThemCTHD(MaSach, SoLuongMua, MaHoaDon);
	}
}
