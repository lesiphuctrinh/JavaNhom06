package lichsuModal;

import java.security.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import ketnoiModal.KetNoi;

public class lichsuDAO {
	public ArrayList<lichsu> getLichSu(long maKhachHang) throws SQLException, ClassNotFoundException {
        ArrayList<lichsu> ds = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketnoi();  // Kết nối đến cơ sở dữ liệu

        String sql = "SELECT * FROM VLichSu WHERE makh = ?  Order by NgayMua desc";  // Câu lệnh SQL lấy dữ liệu lịch sử mua hàng
        PreparedStatement stmt = kn.cn.prepareStatement(sql);
        stmt.setLong(1, maKhachHang);
        
        ResultSet rs = stmt.executeQuery();  // Thực thi câu lệnh SQL

        // Duyệt qua các kết quả và tạo đối tượng LichSu
        while (rs.next()) {
            String tenSach = rs.getString("TenSach");
            int soLuongMua = rs.getInt("SoLuongMua");
            double gia = rs.getDouble("Gia");
            double thanhTien = rs.getDouble("ThanhTien");
            String hoTen = rs.getString("hoten"); 
            
            // Lấy cả ngày và giờ
            java.sql.Timestamp ngayMuaTimestamp = rs.getTimestamp("NgayMua");
            Date ngayMua = ngayMuaTimestamp != null ? new Date(ngayMuaTimestamp.getTime()) : null;
            
            boolean daMua = rs.getBoolean("damua");

            // Tạo đối tượng lichsu và thêm vào danh sách
            lichsu ls = new lichsu(maKhachHang, hoTen, ngayMua, soLuongMua, gia, thanhTien, tenSach, daMua);
            ds.add(ls);  // Thêm đối tượng vào danh sách
        }
        rs.close();
        stmt.close();
        kn.cn.close();
        return ds;
	}
}
