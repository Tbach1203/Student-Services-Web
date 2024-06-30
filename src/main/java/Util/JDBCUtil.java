package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			  String url = System.getenv("DB_URL");
			  String username = System.getenv("DB_USERNAME"); 
			  String password = System.getenv("DB_PASSWORD");
			 

			conn = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Connection Error...");
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		getConnection();
	}
}