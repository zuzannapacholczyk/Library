package database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SynchronizerOperations {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	CallableStatement proc = null;

	public void countPunishments() {
		try {
			Database db = new Database();
			con = db.startLibrarianConnection();
			proc = con.prepareCall("{ call update_punishments() }");
			proc.execute();
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			try {
				if (proc != null) {
					proc.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException ex) {
				Logger lgr = Logger.getLogger(Database.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
	}
}
