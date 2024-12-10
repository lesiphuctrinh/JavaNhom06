package sachAdminModal;

import java.text.SimpleDateFormat;
import java.util.Date;

public class sachAdmin {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private long soLuong;
    private long gia;
    private String anh;
    private String maLoai;
    private Date ngayNhap; // Đổi kiểu dữ liệu từ String sang Date

    public sachAdmin() {
        super();
    }

    public sachAdmin(String maSach, String tenSach, String tacGia, long soLuong, long gia, String anh, String maLoai,
            Date ngayNhap) {
        super();
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.soLuong = soLuong;
        this.gia = gia;
        this.anh = anh;
        this.maLoai = maLoai;
        this.ngayNhap = ngayNhap;
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

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(long soLuong) {
        this.soLuong = soLuong;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }
}
