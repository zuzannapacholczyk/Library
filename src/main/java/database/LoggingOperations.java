package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.User;

public class LoggingOperations {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	User user = null;

	public User getUserByLoginAndPassword(String login, String password) {
		try {
			Database db = new Database();

			con = db.startAdminConnection();
			String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
			st = con.prepareStatement(sql);
			st.setString(1, login);
			st.setString(2, password);
			rs = st.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setRights(rs.getString("rights"));
			}
			return user;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;

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
}
