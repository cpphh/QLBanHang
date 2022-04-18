package DAO;

import java.sql.*;

import BEAN.Account;
import DB.DBConnection;

public class LoginDAO {
	public static Account checkLogin(String user, String pass) {
		String sql = "select *from account where username = ? and password = ?";
		try {
			Connection conn = DBConnection.CreateConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullname = rs.getString("fullname");
				int admin = rs.getInt("admin");
				return new Account(username, password, fullname, admin);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
