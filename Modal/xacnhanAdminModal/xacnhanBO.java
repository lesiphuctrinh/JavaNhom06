package xacnhanAdminModal;

import java.sql.SQLException;
import java.util.ArrayList;

public class xacnhanBO {
	xacnhanDAO dao = new xacnhanDAO();
	 public ArrayList<xacnhan> getXacNhan(String searchValue, int page, int pageSize) throws ClassNotFoundException, SQLException {
		 return dao.getXacNhan(searchValue, page, pageSize);
	 }
	 public int getTongDonHang(String searchValue) throws ClassNotFoundException, SQLException {
		 return dao.getTongDonHang(searchValue);
	 }

}
