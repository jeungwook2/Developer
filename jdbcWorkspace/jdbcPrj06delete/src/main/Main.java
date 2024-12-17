package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("===== delete =====");
		
		//lib
		
		
		//conn
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 게시글 번호 : ");
		String x = sc.nextLine();
		
		//SQL
		String sql = """
				DELETE BOARD
				WHERE NO = ?	
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, x);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("delete 성공 !");
		}
	}

}
