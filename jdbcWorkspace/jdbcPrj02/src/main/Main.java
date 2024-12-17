package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("===== JDBC =====");
		
		//lib
		
		//conn
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "C##KH";
		String password = "1234";
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//SQL
		String s = """
				DROP TABLE BOARD
				""";
		
		Statement stmt = conn.createStatement();
		stmt.execute(s);
		
	}

}
