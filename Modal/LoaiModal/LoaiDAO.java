package LoaiModal;

import java.util.ArrayList;

public class LoaiDAO {
	public ArrayList<Loai> getLoai(){
		ArrayList<Loai> ds = new ArrayList<>();
		ds.add(new Loai("ct", "Chinh tri"));
		ds.add(new Loai("cntt", "Cong nghe thong tin"));
		ds.add(new Loai("toan", "Sach toan"));
		ds.add(new Loai("ly", "Vat ly"));
		ds.add(new Loai("sinh", "Cong nghe sinh hoc"));
		return ds;
	}
}
