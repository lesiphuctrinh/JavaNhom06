package LoginAdminModal;

import java.sql.SQLException;

public class loginAdminBO {
	loginAdminDAO dao = new loginAdminDAO();
	public String ktdangnhap(String tendn, String pass) throws ClassNotFoundException, SQLException {
		return dao.ktdangnhap(tendn, pass);
	}
}
