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
	
	public User getUserByLogin(String login, String rights) {
		try {
			User user = null;
			createAppropriateConnection(rights);
			String sql = "SELECT * FROM users WHERE login = ? ";
			st = con.prepareStatement(sql);
			st.setString(1, login);
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
	
	public boolean addUser(User user, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "INSERT INTO Users VALUES (?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			
				st.setString(1, user.getLogin());
				st.setString(2, user.getPassword());
				st.setString(3, user.getName());
				st.setString(4, user.getSurname());
				st.setString(5, user.getRights());
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
	
	public boolean removeUser(String login, String password, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "DELETE FROM Users WHERE login = ? AND password = ?";
			st = con.prepareStatement(sql);
			
				st.setString(1,login);
				st.setString(2, password);
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
	
	public boolean updateUser(User user, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "UPDATE Users SET password = ?, name = ?, surname = ?, rights = ? WHERE login = ?";
			st = con.prepareStatement(sql);
			
				st.setString(1,user.getPassword());
				st.setString(2, user.getName());
				st.setString(3, user.getSurname());
				st.setString(4, user.getRights());
				st.setString(5, user.getLogin());
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
