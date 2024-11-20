package lichsuModal;

public class lichsu {
    private long makh;         
    private String hoten;            
    private String ngayMua;      
    private int soLuong;         
    private double gia;          
    private double thanhTien;    
    private String tenSach; 
    private boolean daMua;

    
    public lichsu() {
        super();
    }


	public lichsu(long makh, String hoten, String ngayMua, int soLuong, double gia, double thanhTien, String tenSach,
			boolean daMua) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.ngayMua = ngayMua;
		this.soLuong = soLuong;
		this.gia = gia;
		this.thanhTien = thanhTien;
		this.tenSach = tenSach;
		this.daMua = daMua;
	}


	public long getMakh() {
		return makh;
	}


	public void setMakh(long makh) {
		this.makh = makh;
	}


	public String getHoten() {
		return hoten;
	}


	public void setHoten(String hoten) {
		this.hoten = hoten;
	}


	public String getNgayMua() {
		return ngayMua;
	}


	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public double getGia() {
		return gia;
	}


	public void setGia(double gia) {
		this.gia = gia;
	}


	public double getThanhTien() {
		return thanhTien;
	}


	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}


	public String getTenSach() {
		return tenSach;
	}


	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}


	public boolean isDaMua() {
		return daMua;
	}


	public void setDaMua(boolean daMua) {
		this.daMua = daMua;
	}

   
}
