package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BorrowingOperations {
	Connection con = null;
	PreparedStatement st = null;

	public boolean borrowBook(int bookId, int readerId, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "INSERT INTO borrowings(copy_id, reader_id) VALUES(?, ?)";
			st = con.prepareStatement(sql);
			
				st.setInt(1, bookId);
				st.setInt(2, readerId);
				st.executeUpdate();
				return true;
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return false;

		} finally {
			try {
				if (st != null) {
					st.close();
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
	
	private void createAppropriateConnection(String rights) {
		Database db = new Database();
		if (rights.equals("l")) {
			con = db.startLibrarianConnection();
		} else if (rights.equals("a"))
			con = db.startAdminConnection();
		else
			con = db.startReaderConnection();

	}
	

}
