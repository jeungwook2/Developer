package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("===== update =====");
		
		// lib
		
		// conn
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 게시글 번호 : ");
		String c = sc.nextLine();
		System.out.print("수정할 제목 : ");
		String a = sc.nextLine();
		System.out.print("수정할 내용 : ");
		String b = sc.nextLine();
		
		// SQL
		String sql = """
				UPDATE BOARD
				    SET
				        TITLE = ?
				        , CONTENT = ?
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, a);
		pstmt.setString(2, b);
		pstmt.setString(3, c);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("update 성공 !");
		}
		
	}

}
