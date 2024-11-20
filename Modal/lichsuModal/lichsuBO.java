package lichsuModal;

import java.sql.SQLException;
import java.util.ArrayList;

public class lichsuBO {
	lichsuDAO lsdao = new lichsuDAO();
	public ArrayList<lichsu> getLichSu(long makh) throws SQLException, ClassNotFoundException {
		return lsdao.getLichSu(makh);
	}
}
