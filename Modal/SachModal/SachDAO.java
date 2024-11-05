package SachModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LoaiModal.Loai;
import ketnoiModal.KetNoi;

public class SachDAO {
	public ArrayList<Sach> getSach() throws ClassNotFoundException, SQLException {
		ArrayList<Sach> ds = new ArrayList<>();
		// b1: kết nối
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		// b2: tạo câu lệnh sql
		String sql = "select * from sach";
		// b3: thực hiện câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		// b4: Duyệt qua rs để chuyển dữ liệu sang mang: maping
		while (rs.next()) {
			String masach = rs.getString("masach");
			String tensach = rs.getString("tensach");
			String tacgia = rs.getString("tacgia");
			Long soluong = rs.getLong("soluong");
			Long gia = rs.getLong("gia");
			String anh = rs.getString("anh");
			String maloai = rs.getString("maloai");
			ds.add(new Sach(masach,tensach,tacgia,soluong, gia, anh, maloai));
		}
		rs.close();
		kn.cn.close();
		return ds;

	}
}