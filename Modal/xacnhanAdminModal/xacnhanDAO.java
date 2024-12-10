package xacnhanAdminModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import SachModal.Sach;
import ketnoiModal.KetNoi;

public class xacnhanDAO {
	// Lấy danh sách đơn hàng với phân trang và tìm kiếm từ khóa
    public ArrayList<xacnhan> getXacNhan(String searchValue, int page, int pageSize) throws ClassNotFoundException, SQLException {
        ArrayList<xacnhan> ds = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketnoi();

        String sql = "SELECT * FROM (" +
                     "SELECT *, ROW_NUMBER() OVER(ORDER BY hoten) AS RowNumber " +
                     "FROM VLichSu " +
                     "WHERE hoten LIKE ?" +
                     ") AS t " +
                     "WHERE (? = 0) OR (t.RowNumber BETWEEN (? - 1) * ? + 1 AND ? * ?)" +
                     "ORDER BY RowNumber desc";

        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, "%" + searchValue + "%");
        cmd.setInt(2, pageSize);
        cmd.setInt(3, page);
        cmd.setInt(4, pageSize);
        cmd.setInt(5, page);
        cmd.setInt(6, pageSize);

        ResultSet rs = cmd.executeQuery();
        while (rs.next()) {
        	long makh = rs.getLong("makh"); 
        	long macthd = rs.getLong("MaChiTietHD");
        	String hoten = rs.getString("hoten"); 
        	long soLuongMua = rs.getLong("soLuongMua"); 
        	double gia = rs.getDouble("gia"); 
        	double thanhTien = rs.getDouble("thanhTien"); 
        	String tenSach = rs.getString("tenSach"); 
        	boolean daMua = rs.getBoolean("daMua");
        	
        	// Lấy cả ngày và giờ
            java.sql.Timestamp ngayMuaTimestamp = rs.getTimestamp("ngayMua");
            Date ngayMua = ngayMuaTimestamp != null ? new Date(ngayMuaTimestamp.getTime()) : null;
            
        	ds.add(new xacnhan(makh,macthd, hoten, ngayMua, soLuongMua, gia, thanhTien, tenSach, daMua));
        }
        rs.close();
        kn.cn.close();
        return ds;
    }

    // Lấy tổng số đơn hàng theo từ khóa
    public int getTongDonHang(String searchValue) throws ClassNotFoundException, SQLException {
    	int sum = 0;
    	KetNoi kn = new KetNoi();
        kn.ketnoi();
        String sql = "SELECT COUNT(*) AS total FROM VLichSu WHERE hoten LIKE ?";
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
    
 
}
