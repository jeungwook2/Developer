package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		System.out.println("===== INSERT =====");
		
		// lib
		
		// conn
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd); // 글자 기울어짐 -> 스태틱 메서드
		
		Scanner sc = new Scanner(System.in);
		System.out.print("TITLE : ");
		String a = sc.nextLine();
		System.out.print("CONTENT : ");
		String b = sc.nextLine();
		
		// SQL
		String sql = "INSERT INTO BOARD(NO,TITLE,CONTENT) VALUES (SEQ_BOARD.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, a);
		pstmt.setString(2, b);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("insert 성공 !");
		}
		
	}

}
