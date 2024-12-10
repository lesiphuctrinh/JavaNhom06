package chitietModal;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ketnoiModal.KetNoi;

public class chitietHdDAO {
	public int ThemCTHD (String MaSach, long SoLuongMua, long MaHoaDon) throws SQLException, ClassNotFoundException {
		KetNoi kn = new KetNoi();
		kn.ketnoi();
		String sql ="insert into ChiTietHoaDon(MaSach, SoLuongMua, MaHoaDon) values(?, ?, ?)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MaSach);
		cmd.setLong(2, SoLuongMua);
		cmd.setLong(3, MaHoaDon);
		int kq = cmd.executeUpdate();
		
		cmd.close();
		kn.cn.close();
		return kq;
	}
	//cập nhật đơn hàng
    public boolean capNhatDonHang(long macthd) throws ClassNotFoundException, SQLException {
        KetNoi kn = new KetNoi(); // Tạo đối tượng kết nối
        kn.ketnoi(); // Gọi phương thức kết nối

        String sql = "UPDATE ChiTietHoaDon " +
	        		"SET damua = 1 " +
	        		"WHERE MaChiTietHD = ?";

        PreparedStatement cmd = kn.cn.prepareStatement(sql);

        // Gán giá trị cho các tham số
        cmd.setLong(1, macthd);
        
        // Thực thi câu lệnh
        int rowsUpdated = cmd.executeUpdate();

        // Đóng kết nối
        cmd.close();
        kn.cn.close();

        // Trả về kết quả (true nếu cập nhật thành công)
        return rowsUpdated > 0;
    }
}
