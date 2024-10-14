package SachModal;

import java.util.ArrayList;

public class SachDAO {
	public ArrayList<Sach> getSach(){
		ArrayList<Sach> ds = new ArrayList<>();
		ds.add(new Sach("ma01", "ToanDai", "Nguyen Gia Dinh", (long)10, (long)89000, "image_sach/b3.jpg", "toan"));
		ds.add(new Sach("ma02", "Cong nghe thong tin", "Nguyen Hoang Ha", (long)70, (long)189000, "image_sach/b1.jpg", "cntt"));
		ds.add(new Sach("ma03", "Cong nghe thong tin", "Nguyen Hoang Ha", (long)70, (long)189000, "image_sach/b1.jpg", "cntt"));
		ds.add(new Sach("ma04", "Cong nghe thong tin", "Nguyen Hoang Ha", (long)70, (long)189000, "image_sach/b1.jpg", "cntt"));
		ds.add(new Sach("ma05", "Chinh tri", "Mac Le-nin", (long)30, (long)59000, "image_sach/b25.jpg", "ct"));
		ds.add(new Sach("ma06", "Cong nghe sinh hoc", "Xuan Linh", (long)60, (long)69000, "image_sach/b18.jpg", "sinh"));
		ds.add(new Sach("ma07", "Vat ly", "Gia Han", (long)110, (long)49000, "image_sach/b2.jpg", "ly"));
		return ds;
		
	}
}
