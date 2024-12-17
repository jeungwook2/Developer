package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("insert ~~~");
		
		// lib
		
		// conn
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		// SQL
		Scanner sc = new Scanner(System.in);
		System.out.print("제목 : ");
		String a = sc.nextLine();
		System.out.print("내용 : ");
		String b = sc.nextLine();
		String sql = "INSERT INTO BOARD(TITLE,CONTENT) VALUES(?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,a);
		pstmt.setString(2,b);
		int result = pstmt.executeUpdate();

		if( result == 1 ) {
			System.out.println("insert 성공 ~~~ !");
		}
	}

}
