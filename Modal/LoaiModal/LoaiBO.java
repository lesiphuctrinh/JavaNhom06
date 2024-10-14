package LoaiModal;

import java.util.ArrayList;

public class LoaiBO {
	LoaiDAO ldao = new LoaiDAO();
	public ArrayList<Loai> getLoai(){
		return ldao.getLoai();
	}
}
