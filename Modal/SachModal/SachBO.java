package SachModal;

import java.sql.SQLException;
import java.util.ArrayList;

public class SachBO {
    SachDAO sdao = new SachDAO();

    public ArrayList<Sach> getSach(String searchValue, int page, int pageSize) throws ClassNotFoundException, SQLException {
        return sdao.getSach(searchValue, page, pageSize);
    }

    // Tìm kiếm theo mã loại
    public ArrayList<Sach> TimMaLoai(String maloai) throws ClassNotFoundException, SQLException {
        return sdao.TimMaLoai(maloai); // Phương thức này sẽ trả về danh sách sách theo mã loại
    }

    public int getTongSach(String searchValue) throws ClassNotFoundException, SQLException {
        return sdao.getTongSach(searchValue); // Lấy tổng số sách tùy theo tìm kiếm
    }
}
