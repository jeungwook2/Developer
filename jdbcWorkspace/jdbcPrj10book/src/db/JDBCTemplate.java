package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTemplate {
	
	// conn
	public static Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##kh";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		return conn;
	}
}
