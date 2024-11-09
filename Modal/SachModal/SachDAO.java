package SachModal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import LoaiModal.Loai;
import ketnoiModal.KetNoi;

public class SachDAO {

    // Lấy danh sách sách với phân trang và tìm kiếm từ khóa
    public ArrayList<Sach> getSach(String searchValue, int page, int pageSize) throws ClassNotFoundException, SQLException {
        ArrayList<Sach> ds = new ArrayList<>();
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
            ds.add(new Sach(masach, tensach, tacgia, soluong, gia, anh, maloai));
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

    // Tìm sách theo mã loại
    public ArrayList<Sach> TimMaLoai(String maloai) throws ClassNotFoundException, SQLException {
        ArrayList<Sach> ds = new ArrayList<>();
        KetNoi kn = new KetNoi();
        kn.ketnoi();

        String sql = "SELECT * FROM sach WHERE maloai = ?";
        PreparedStatement cmd = kn.cn.prepareStatement(sql);
        cmd.setString(1, maloai); // Tìm theo mã loại

        ResultSet rs = cmd.executeQuery();
        while (rs.next()) {
            String masach = rs.getString("masach");
            String tensach = rs.getString("tensach");
            String tacgia = rs.getString("tacgia");
            Long soluong = rs.getLong("soluong");
            Long gia = rs.getLong("gia");
            String anh = rs.getString("anh");
            ds.add(new Sach(masach, tensach, tacgia, soluong, gia, anh, maloai));
        }
        rs.close();
        kn.cn.close();
        return ds;
    }

}
