package giohangModal;

import java.util.ArrayList;

public class giohangbo {
	public ArrayList<hang> ds= new ArrayList<hang>();
	  public void Them(String masach, String tensach, long gia, long soluong) {
		 for(hang h: ds)
			 if(h.getMasach().equals(masach)) {
				 h.setSoluong(h.getSoluong()+soluong);
				 return;
			 }
		  ds.add(new hang(masach, tensach, gia, soluong));
	  }
	  public void xoa(String masach) {
		  for(hang h: ds)
				 if(h.getMasach().equals(masach)) {
					 ds.remove(h);break;
				 }
	  }
	  public long Tong() {
		  long s=0;
		  for(hang h: ds) s=s+h.getThanhtien();
		  return s;
	  }
	  public long getSoluong() {
	        int soluong = 0;
	        for (hang h : ds) {
	            soluong += h.getSoluong();
	        }
	        return soluong;
	    }
}
