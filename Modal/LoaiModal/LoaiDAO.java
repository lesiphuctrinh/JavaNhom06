package LoaiModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import ketnoiModal.KetNoi;
import sachAdminModal.sachAdmin;

public class LoaiDAO {
	public ArrayList<Loai> getLoai() throws Exception{
		ArrayList<Loai> ds = new ArrayList<>();
		//b1: kết nối
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		//b2: tạo câu lệnh sql
		String sql = "select * from loai";
		//b3: thực hiện câu lệnh
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		//b4: Duyệt qua rs để chuyển dữ liệu sang mang: maping
		while(rs.next()) {
			String maloai = rs.getString("maloai");
			String tenloai = rs.getString("tenloai");
			
			// Lấy cả ngày và giờ
            java.sql.Timestamp ngayNhapTimestamp = rs.getTimestamp("ngaynhap");
            Date ngayNhap = ngayNhapTimestamp != null ? new Date(ngayNhapTimestamp.getTime()) : null;
            
			ds.add(new Loai(maloai, tenloai, ngayNhap));
		}
		rs.close();
		kn.cn.close();
		return ds;
	}
	public ArrayList<Loai> getLoaiPhanTrang(String searchValue, int page, int pageSize) throws ClassNotFoundException, SQLException {
        ArrayList<Loai> ds = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketnoi();

        String sql = "SELECT * FROM (" +
                     "SELECT *, ROW_NUMBER() OVER(ORDER BY tenloai) AS RowNumber " +
                     "FROM loai " +
                     "WHERE tenloai LIKE ?" +
                     ") AS t " +
                     "WHERE (? = 0) OR (t.RowNumber BETWEEN (? - 1) * ? + 1 AND ? * ?)" +
                     "ORDER BY RowNumber";

        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, "%" + searchValue + "%");
        cmd.setInt(2, pageSize);
        cmd.setInt(3, page);
        cmd.setInt(4, pageSize);
        cmd.setInt(5, page);
        cmd.setInt(6, pageSize);

        ResultSet rs = cmd.executeQuery();
        while (rs.next()) {
            String maloai = rs.getString("maloai");
            String tenloai = rs.getString("tenloai");

         // Lấy cả ngày và giờ
            java.sql.Timestamp ngayNhapTimestamp = rs.getTimestamp("ngaynhap");
            Date ngayNhap = ngayNhapTimestamp != null ? new Date(ngayNhapTimestamp.getTime()) : null;
            
            ds.add(new Loai(maloai, tenloai, ngayNhap));
        }
        rs.close();
        kn.cn.close();
        return ds;
    }
 // Lấy tổng số loại theo từ khóa
    public int getTongLoai(String searchValue) throws ClassNotFoundException, SQLException {
    	int sum = 0;
    	KetNoi kn = new KetNoi();
        kn.ketnoi();
        String sql = "SELECT COUNT(*) AS total FROM loai WHERE tenloai LIKE ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, "%" + searchValue + "%");
        ResultSet rs = cmd.executeQuery();
        if (rs.next()) {
            sum = rs.getInt("total");
        }
        rs.close();
        kn.cn.close();
        return sum;
    }
  //bổ sung loại
    public boolean boSungLoai(String maLoai, String tenLoai) throws ClassNotFoundException, SQLException {
        KetNoi kn = new KetNoi(); // Tạo đối tượng kết nối
        kn.ketnoi(); // Gọi phương thức kết nối

        String sql = "INSERT INTO loai(maloai, tenloai, ngaynhap) VALUES (?, ?, GETDATE())";

        PreparedStatement cmd = kn.cn.prepareStatement(sql);

        // Gán giá trị cho các tham số
        cmd.setString(1, maLoai);
        cmd.setString(2, tenLoai);

        // Thực thi câu lệnh
        int rowsInserted = cmd.executeUpdate();

        // Đóng kết nối
        cmd.close();
        kn.cn.close();

        // Trả về kết quả (true nếu thêm thành công)
        return rowsInserted > 0;
    }
    //cập nhật loai
    public boolean capNhatLoai(String maLoai, String tenLoai) throws ClassNotFoundException, SQLException {
        KetNoi kn = new KetNoi(); // Tạo đối tượng kết nối
        kn.ketnoi(); // Gọi phương thức kết nối

        String sql = "UPDATE loai " +
                     "SET tenloai = ?, ngaynhap = GETDATE() " +
                     "WHERE maloai = ?";

        PreparedStatement cmd = kn.cn.prepareStatement(sql);

        // Gán giá trị cho các tham số
        cmd.setString(1, tenLoai);
        cmd.setString(2, maLoai);

        // Thực thi câu lệnh
        int rowsUpdated = cmd.executeUpdate();

        // Đóng kết nối
        cmd.close();
        kn.cn.close();

        // Trả về kết quả (true nếu cập nhật thành công)
        return rowsUpdated > 0;
    }
    // xóa loại
    public boolean xoaLoai(String maLoai) throws ClassNotFoundException, SQLException {

    	// Kết nối đến cơ sở dữ liệu
        KetNoi kn = new KetNoi();
        kn.ketnoi();

        // Xóa sách
        String sqlSach = "DELETE FROM sach WHERE maloai = ?";
        PreparedStatement cmdSach = kn.cn.prepareStatement(sqlSach);
        cmdSach.setString(1, maLoai);
        cmdSach.executeUpdate(); // Thực thi lệnh xóa sách
        cmdSach.close();

        // Xóa loại
        String sqlLoai = "DELETE FROM loai WHERE maloai = ?";
        PreparedStatement cmdLoai = kn.cn.prepareStatement(sqlLoai);
        cmdLoai.setString(1, maLoai);
        int rowsDeleted = cmdLoai.executeUpdate(); // Thực thi lệnh xóa loại
        cmdLoai.close();

        // Đóng kết nối
        kn.cn.close();

        // Trả về kết quả (true nếu xóa loại thành công)
        return rowsDeleted > 0;
    }
  //kiểm tra mã sách trùng khi bổ sung
    public boolean kiemTraMa(String maLoai) throws ClassNotFoundException, SQLException {
    	KetNoi kn = new KetNoi();
    	kn.ketnoi();
    	String sql = "SELECT COUNT(*) AS count FROM loai WHERE maloai = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);

        cmd.setString(1, maLoai);

        ResultSet rs = cmd.executeQuery();
        boolean dem = false;
        if (rs.next()) {
            dem = rs.getInt("count") > 0; // Kiểm tra số lượng sách có mã đã tồn tại
        }

        // Đóng kết nối
        rs.close();
        cmd.close();
        kn.cn.close();

        return dem;
    }
}
