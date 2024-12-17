package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("zzz");
		
		//conn 준비
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String db_id = "C##KH";
		String db_pw = "1234";
		Connection conn = DriverManager.getConnection(db_url, db_id, db_pw);
		
		//SQL 작성
		String s = """
				CREATE TABLE BOARD(
					TITLE		VARCHAR2(100)
					, CONTENT	VARCHAR2(100)
				)
				""";
		
		//SQL 실행
		Statement stmt = conn.createStatement();
		stmt.execute(s);
		
	}

}
