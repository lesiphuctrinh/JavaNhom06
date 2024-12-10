package giohangModal;

public class hang {
	private String masach;
    private String tensach;
    private long gia;
    private long soluong;
    private long thanhtien;
	public hang(String masach, String tensach, long gia, long soluong) {
		super();
		this.masach = masach;
		this.tensach = tensach;
		this.gia = gia;
		this.soluong = soluong;
		this.thanhtien=soluong*gia;
	}
	public String getMasach() {
		return masach;
	}
	public void setMasach(String masach) {
		this.masach = masach;
	}
	public String getTensach() {
		return tensach;
	}
	public void setTensach(String tensach) {
		this.tensach = tensach;
	}
	public Long getGia() {
		return gia;
	}
	public void setGia(Long gia) {
		this.gia = gia;
	}
	public long getSoluong() {
		return soluong;
	}
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	public Long getThanhtien() {
		return soluong*gia;
	}
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
}
