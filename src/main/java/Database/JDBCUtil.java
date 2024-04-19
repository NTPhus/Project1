package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			// Đăng kí MySQL với DriverManager
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//Các thông số
			String url = "jdbc:mySQL://localhost:3306/bookshop";
			String username = "root";
			String password = "";
			//tạo kết nối
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
