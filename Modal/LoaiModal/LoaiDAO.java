package LoaiModal;

import java.util.ArrayList;

public class LoaiDAO {
	public ArrayList<Loai> getLoai(){
		ArrayList<Loai> ds = new ArrayList<>();
		ds.add(new Loai("ct", "Chính trị"));
		ds.add(new Loai("cntt", "Công nghệ thông tin"));
		ds.add(new Loai("toan", "Sách toán"));
		ds.add(new Loai("ly", "Vật lý"));
		ds.add(new Loai("sinh", "Công nghệ sinh học"));
		return ds;
	}
}
