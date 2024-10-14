package SachModal;

import java.util.ArrayList;

public class SachBO {
	SachDAO sdao = new SachDAO();
	ArrayList<Sach> ds;
	public ArrayList<Sach> getSach(){
		ds = sdao.getSach();
		return ds;
	}
	public ArrayList<Sach> TimMa(String maloai){
		ArrayList<Sach> tam = new ArrayList<Sach>();
		for (Sach sach : ds) {
			if(sach.getMaLoai().toLowerCase().trim().equals(maloai.toLowerCase().trim())) {
				tam.add(sach);
			}
		}
		return tam;
	}
	public ArrayList<Sach> Tim(String key){
		ArrayList<Sach> tam = new ArrayList<>();
		for (Sach sach : ds){
			if(sach.getTenSach().toLowerCase().trim().contains(key.toLowerCase().trim()) || 
					sach.getTacGia().toLowerCase().trim().contains(key.toLowerCase().trim())) {
				tam.add(sach);
			}
		}
		return tam;
	}
}
