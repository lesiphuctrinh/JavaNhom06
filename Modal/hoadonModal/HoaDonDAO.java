package hoadonModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ketnoiModal.KetNoi;

public class HoaDonDAO {
	public int Them(long makh) throws ClassNotFoundException, SQLException {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "insert into hoadon(makh, NgayMua, damua) values(?, GETDATE(), 0)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		int kq = cmd.executeUpdate();
		
		cmd.close();
		kn.cn.close();
		return kq;
	}
	public long GetMaxHD() throws ClassNotFoundException, SQLException {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql = "select max(MaHoaDon) as MaxHD from hoadon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		long max = 0;
		if(rs.next()) {
			max = rs.getLong("MaxHD");
		}
		rs.close();
		kn.cn.close();
		return max;
	}
}
