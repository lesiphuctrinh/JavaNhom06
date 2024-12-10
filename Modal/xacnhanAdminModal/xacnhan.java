package xacnhanAdminModal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class xacnhan {
	private long makh;
	private long macthd;
	private String hoten;            
    private Date ngayMua;      
    private long soLuongMua;         
    private double gia;          
    private double thanhTien;    
    private String tenSach; 
    private boolean daMua;



	public xacnhan() {
		super();
	}

	public xacnhan(long makh, long macthd, String hoten, Date ngayMua, long soLuongMua, double gia, double thanhTien,
			String tenSach, boolean daMua) {
		super();
		this.makh = makh;
		this.macthd = macthd;
		this.hoten = hoten;
		this.ngayMua = ngayMua;
		this.soLuongMua = soLuongMua;
		this.gia = gia;
		this.thanhTien = thanhTien;
		this.tenSach = tenSach;
		this.daMua = daMua;
	}

	public long getMacthd() {
		return macthd;
	}



	public void setMacthd(long macthd) {
		this.macthd = macthd;
	}


	public long getSoLuongMua() {
		return soLuongMua;
	}

	public void setSoLuongMua(long soLuongMua) {
		this.soLuongMua = soLuongMua;
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


	public Date getNgayMua() {
        return ngayMua;
    }



	public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    // Phương thức để lấy ngayMuadưới dạng chuỗi đã định dạng
    public String getNgayMuaFormat() {
        if (ngayMua != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return sdf.format(ngayMua);
        }
        return null;
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
