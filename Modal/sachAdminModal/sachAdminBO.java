package sachAdminModal;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class sachAdminBO {
	sachAdminDAO sdao = new sachAdminDAO();
	public ArrayList<sachAdmin> getSach(String searchValue, int page, int pageSize) throws ClassNotFoundException, SQLException {
		return sdao.getSach(searchValue, page, pageSize);
	}
	 public int getTongSach(String searchValue) throws ClassNotFoundException, SQLException {
		 return sdao.getTongSach(searchValue);
	 }
	 public boolean boSungSach(String maSach, String tenSach, String tacGia, long soLuong, long gia, String anh, String maLoai) throws ClassNotFoundException, SQLException {
		 return sdao.getBoSung(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai);
	 }
	 public boolean capNhatSach(String maSach, String tenSach, String tacGia, long soLuong, long gia, String anh, String maLoai) throws ClassNotFoundException, SQLException {
		 return sdao.capNhatSach(maSach, tenSach, tacGia, soLuong, gia, anh, maLoai);
	 }
	 public boolean xoaSach(String maSach) throws ClassNotFoundException, SQLException {
		 return sdao.xoaSach(maSach);
	 }
	 public boolean kiemTraMa(String maSach) throws ClassNotFoundException, SQLException {
		 return sdao.kiemTraMa(maSach);
	 }
}
