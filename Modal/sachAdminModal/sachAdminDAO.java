package sachAdminModal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ketnoiModal.KetNoi;

public class sachAdminDAO {
	 public ArrayList<sachAdmin> getSach(String searchValue, int page, int pageSize) throws ClassNotFoundException, SQLException {
	        ArrayList<sachAdmin> ds = new ArrayList<>();
	        KetNoi kn = new KetNoi();
	        kn.ketnoi();

	        String sql = "SELECT * FROM (" +
	                     "SELECT *, ROW_NUMBER() OVER(ORDER BY tensach) AS RowNumber " +
	                     "FROM sach " +
	                     "WHERE tensach LIKE ?" +
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
	            String masach = rs.getString("masach");
	            String tensach = rs.getString("tensach");
	            String tacgia = rs.getString("tacgia");
	            Long soluong = rs.getLong("soluong");
	            Long gia = rs.getLong("gia");
	            String anh = rs.getString("anh");
	            String maloai = rs.getString("maloai");
	         // Lấy cả ngày và giờ
	            java.sql.Timestamp ngayNhapTimestamp = rs.getTimestamp("ngaynhap");
	            Date ngayNhap = ngayNhapTimestamp != null ? new Date(ngayNhapTimestamp.getTime()) : null;
	            ds.add(new sachAdmin(masach, tensach, tacgia, soluong, gia, anh, maloai, ngayNhap));
	        }
	        rs.close();
	        kn.cn.close();
	        return ds;
	    }
	 // Lấy tổng số sách theo từ khóa
	    public int getTongSach(String searchValue) throws ClassNotFoundException, SQLException {
	    	int sum = 0;
	    	KetNoi kn = new KetNoi();
	        kn.ketnoi();
	        String sql = "SELECT COUNT(*) AS total FROM sach WHERE tensach LIKE ?";
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
	    
	    //bổ sung sách
	    public boolean getBoSung(String maSach, String tenSach, String tacGia, long soLuong, long gia, String anh, String maLoai) throws ClassNotFoundException, SQLException {
	        KetNoi kn = new KetNoi(); // Tạo đối tượng kết nối
	        kn.ketnoi(); // Gọi phương thức kết nối

	        String sql = "INSERT INTO sach (masach, tensach, tacgia, soluong, gia, anh, maloai, ngaynhap) VALUES (?, ?, ?, ?, ?, ?, ?, GETDATE())";

	        PreparedStatement cmd = kn.cn.prepareStatement(sql);

	        // Gán giá trị cho các tham số
	        cmd.setString(1, maSach);
	        cmd.setString(2, tenSach);
	        cmd.setString(3, tacGia);
	        cmd.setLong(4, soLuong);
	        cmd.setLong(5, gia);
	        cmd.setString(6, anh);
	        cmd.setString(7, maLoai);

	        // Thực thi câu lệnh
	        int rowsInserted = cmd.executeUpdate();

	        // Đóng kết nối
	        cmd.close();
	        kn.cn.close();

	        // Trả về kết quả (true nếu thêm thành công)
	        return rowsInserted > 0;
	    }
	    //cập nhật sách
	    public boolean capNhatSach(String maSach, String tenSach, String tacGia, long soLuong, long gia, String anh, String maLoai) throws ClassNotFoundException, SQLException {
	        KetNoi kn = new KetNoi(); // Tạo đối tượng kết nối
	        kn.ketnoi(); // Gọi phương thức kết nối

	        String sql = "UPDATE sach " +
	                     "SET tensach = ?, tacgia = ?, soluong = ?, gia = ?, anh = ?, maloai = ?, ngaynhap = GETDATE() " +
	                     "WHERE masach = ?";

	        PreparedStatement cmd = kn.cn.prepareStatement(sql);

	        // Gán giá trị cho các tham số
	        cmd.setString(1, tenSach);
	        cmd.setString(2, tacGia);
	        cmd.setLong(3, soLuong);
	        cmd.setLong(4, gia);
	        cmd.setString(5, anh);
	        cmd.setString(6, maLoai);
	        cmd.setString(7, maSach);

	        // Thực thi câu lệnh
	        int rowsUpdated = cmd.executeUpdate();

	        // Đóng kết nối
	        cmd.close();
	        kn.cn.close();

	        // Trả về kết quả (true nếu cập nhật thành công)
	        return rowsUpdated > 0;
	    }
	    
	    // xóa sách
	    public boolean xoaSach(String maSach) throws ClassNotFoundException, SQLException {

	        KetNoi kn = new KetNoi(); // Tạo đối tượng kết nối
	        kn.ketnoi(); // Gọi phương thức kết nối

	        String sql = "DELETE FROM sach WHERE masach = ?";

	        PreparedStatement cmd = kn.cn.prepareStatement(sql);

	        // Gán giá trị cho tham số
	        cmd.setString(1, maSach);

	        // Thực thi câu lệnh
	        int rowsDeleted = cmd.executeUpdate();

	        // Đóng kết nối
	        cmd.close();
	        kn.cn.close();

	        // Trả về kết quả (true nếu xóa thành công)
	        return rowsDeleted > 0;
	    }
	    //kiểm tra mã sách trùng khi bổ sung
	    public boolean kiemTraMa(String maSach) throws ClassNotFoundException, SQLException {
	    	KetNoi kn = new KetNoi();
	    	kn.ketnoi();
	    	String sql = "SELECT COUNT(*) AS count FROM sach WHERE masach = ?";
	        PreparedStatement cmd = kn.cn.prepareStatement(sql);

	        cmd.setString(1, maSach);

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
