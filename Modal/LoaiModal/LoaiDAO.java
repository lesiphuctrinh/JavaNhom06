package LoaiModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import ketnoiModal.KetNoi;

public class LoaiDAO {
	public ArrayList<Loai> getLoai() throws Exception{
		ArrayList<Loai> ds = new ArrayList<>();
		//b1: kết nối
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//b2: tạo câu lệnh sql
		String sql = "select * from loai";
		//b3: thực hiện câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		//b4: Duyệt qua rs để chuyển dữ liệu sang mang: maping
		while(rs.next()) {
			String maloai = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			ds.add(new Loai(maloai, tenloai));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
}
