package SachModal;

import java.util.ArrayList;

public class SachDAO {
	public ArrayList<Sach> getSach(){
		ArrayList<Sach> ds = new ArrayList<>();
		ds.add(new Sach("ma01", "Toán đại", "Nguyễn Gia Định", (long)10, (long)89000, "image_sach/c6.jpg", "toan"));
		ds.add(new Sach("ma02", "Công nghệ thông tin", "Nguyễn Hoàng Hà", (long)70, (long)189000, "image_sach/c1.jpg", "cntt"));
		ds.add(new Sach("ma03", "Công nghệ thông tin", "Nguyễn Hoàng Hà", (long)70, (long)189000, "image_sach/c1.jpg", "cntt"));
		ds.add(new Sach("ma04", "Công nghệ thông tin", "Nguyễn Hoàng Hà", (long)70, (long)189000, "image_sach/c1.jpg", "cntt"));
		ds.add(new Sach("ma05", "Chính trị", "Mác Lê-nin", (long)30, (long)59000, "image_sach/b25.jpg", "ct"));
		ds.add(new Sach("ma06", "Công nghệ sinh học", "Xuân linh", (long)60, (long)69000, "image_sach/c8.jpg", "sinh"));
		ds.add(new Sach("ma07", "Vật lý", "Gia Hân", (long)110, (long)49000, "image_sach/c2.jpg", "ly"));
		ds.add(new Sach("ma08", "Toán hình", "Nguyễn Ngọc Thiện", (long)110, (long)78000, "image_sach/c11.jpg", "toan"));
		ds.add(new Sach("ma09", "Công nghệ vi phân", "Nguyễn Bính", (long)60, (long)99000, "image_sach/c12.jpg", "sinh"));
		ds.add(new Sach("ma10", "Phương pháp tính", "Nguyễn Hải", (long)60, (long)119000, "image_sach/c9.jpg", "toan"));
		return ds;
		
	}
}
