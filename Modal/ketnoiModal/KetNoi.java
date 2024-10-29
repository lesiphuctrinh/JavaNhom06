package ketnoiModal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoi {
	public Connection cn;
	public void ketnoi() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String sql = "jdbc:sqlserver://PHUCTRINH\\SQLEXPRESS:1433;databaseName=QlSach;user=sa; password=12345";
		cn = DriverManager.getConnection(sql);
		System.out.println("ket noi thanh cong");
	}
}
