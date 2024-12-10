package LoaiModal;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoaiBO {
	LoaiDAO ldao = new LoaiDAO();
	public ArrayList<Loai> getLoai()throws Exception{
		return ldao.getLoai();
	}
	public ArrayList<Loai> getLoaiPhanTrang(String searchValue, int page, int pageSize) throws ClassNotFoundException, SQLException {
		return ldao.getLoaiPhanTrang(searchValue, page, pageSize);
	}
	 public int getTongLoai(String searchValue) throws ClassNotFoundException, SQLException {
		 return ldao.getTongLoai(searchValue);
	 }

	public boolean boSungLoai(String maLoai, String tenLoai) throws ClassNotFoundException, SQLException {
		return ldao.boSungLoai(maLoai, tenLoai);
	}

	public boolean capNhatLoai(String maLoai, String tenLoai) throws ClassNotFoundException, SQLException {
		return ldao.capNhatLoai(maLoai, tenLoai);
	}
	 public boolean xoaLoai(String maLoai) throws ClassNotFoundException, SQLException {
		 return ldao.xoaLoai(maLoai);
	 }
	 public boolean kiemTraMa(String maLoai) throws ClassNotFoundException, SQLException {
		 return ldao.kiemTraMa(maLoai);
	 }
}
