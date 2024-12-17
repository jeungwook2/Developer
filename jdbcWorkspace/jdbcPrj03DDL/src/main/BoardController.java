package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class BoardController {

	public void createBoard() throws Exception {
		// conn
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url,username,pwd);
		// SQL
		String query = """
				CREATE TABLE BOARD(
					TITLE		VARCHAR2(100)
					, CONTENT	VARCHAR2(100)
				)
				""";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.execute();
	}
	
	public void dropBoard() throws Exception {
		// conn
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url,username,pwd);
		// SQL
		String query = """
				DROP TABLE BOARD
				""";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.execute();
	}
	
	public void getConn() {
		
	}
	
}
