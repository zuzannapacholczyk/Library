package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import entities.Department;

public class DepartmentOperations {
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public boolean addDepartment(String name, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "INSERT INTO departments(name) VALUES(?)";
			st = con.prepareStatement(sql);

			st.setString(1, name);
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

	public boolean deleteDepartmentById(int departmentId, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "DELETE FROM Departments WHERE id = ?";
			st = con.prepareStatement(sql);

			st.setInt(1, departmentId);
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

	public boolean deleteDepartmentByName(String name, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "DELETE FROM Departments WHERE name = ?";
			st = con.prepareStatement(sql);

			st.setString(1, name);
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

	public List<Department> getDepartments(String rights) {
		try {
			List<Department> resultList = new ArrayList<Department>();
			createAppropriateConnection(rights);

			String sql = "SELECT * FROM Departments";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Department department = new Department();
				department.setId(rs.getInt("id"));
				department.setName(rs.getString("name"));
				resultList.add(department);
			}

			return resultList;

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

	public int findDepartmentIdByName(String name, String rights) {
		try {
			createAppropriateConnection(rights);

			String sql = "SELECT id FROM Departments WHERE LOWER(name) = ?";
			st = con.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt("id");
			}
			return -1;

		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(Database.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return -1;
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
