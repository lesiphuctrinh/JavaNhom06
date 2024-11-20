package lichsuModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ketnoiModal.KetNoi;

public class lichsuDAO {
	public ArrayList<lichsu> getLichSu(long maKhachHang) throws SQLException, ClassNotFoundException {
        ArrayList<lichsu> ds = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketnoi();  // Kết nối đến cơ sở dữ liệu

        String sql = "SELECT * FROM VLichSu WHERE makh = ?";  // Câu lệnh SQL lấy dữ liệu lịch sử mua hàng
        PreparedStatement stmt = kn.cn.prepareStatement(sql);
        stmt.setLong(1, maKhachHang);
        
        ResultSet rs = stmt.executeQuery();  // Thực thi câu lệnh SQL

        // Duyệt qua các kết quả và tạo đối tượng LichSu
        while (rs.next()) {
            String tenSach = rs.getString("TenSach");
            int soLuong = rs.getInt("SoLuong");
            double gia = rs.getDouble("Gia");
            double thanhTien = rs.getDouble("ThanhTien");
            String hoTen = rs.getString("hoten");    
            String ngayMua = rs.getString("NgayMua");
            boolean daMua = rs.getBoolean("damua");

            // Tạo đối tượng lichsu và thêm vào danh sách
            lichsu ls = new lichsu(maKhachHang, hoTen, ngayMua, soLuong, gia, thanhTien, tenSach, daMua);
            ds.add(ls);  // Thêm đối tượng vào danh sách
        }
        rs.close();
        stmt.close();
        kn.cn.close();
        return ds;
	}
}
