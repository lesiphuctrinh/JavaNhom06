package chitietModal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ketnoiModal.KetNoi;

public class chitietHdDAO {
	public int ThemCTHD (String MaSach, long SoLuongMua, long MaHoaDon) throws SQLException, ClassNotFoundException {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql ="insert into ChiTietHoaDon(MaSach, SoLuongMua, MaHoaDon) values(?, ?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MaSach);
		cmd.setLong(2, SoLuongMua);
		cmd.setLong(3, MaHoaDon);
		int kq = cmd.executeUpdate();
		
		cmd.close();
		kn.cn.close();
		return kq;
	}
}
