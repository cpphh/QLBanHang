package DB;

import java.sql.*;

public class DBConnection {
	public static Connection CreateConnection() {
		Connection conn = null;
		//String url="jdbc:mysql://localhost:3306/qlbh";
		//String url = "jdbc:mysql://node30904-env-2285989.proen.app.ruk-com.cloud:3306/qlbh";
		//String username = "root";
		//String password = "";
		
		
		String url ="jdbc:mysql://db4free.net:3306/ror17233db";
		String username = "ror17233";
		String password = "ror17233@zwoho.com";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
