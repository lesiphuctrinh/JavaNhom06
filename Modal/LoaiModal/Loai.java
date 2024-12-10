package LoaiModal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Loai {
	private String maLoai;
	private String tenLoai;
	private Date ngayNhap;
	
	//phát sinh hàm tạo get, set và hàm tạo
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public Loai() {
		super();
	}
	public Loai(String maLoai, String tenLoai, Date ngayNhap) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.ngayNhap= ngayNhap;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	// Phương thức để lấy ngayNhap dưới dạng chuỗi đã định dạng
    public String getNgayNhapFormat() {
        if (ngayNhap != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            return sdf.format(ngayNhap);
        }
        return null;
    }
}
