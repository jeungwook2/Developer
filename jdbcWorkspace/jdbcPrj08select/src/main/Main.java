package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		// lib
		
		// conn
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("조회하려는 게시글 번호 : ");
//		String num = sc.nextLine();
		
		// SQL
		String sql = """
				SELECT * FROM BOARD
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, num);
		ResultSet rs = pstmt.executeQuery();
		
//		rs 커서 한칸 내리세요
//		rs.next();
		
//		rs 현재 커서가 가리키는 행 중에서 타이틀 칼럼 가져오세요
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");

			BoardVo vo = new BoardVo(no, title, content, enrollDate);
			
			System.out.println(vo);
		}
		
		
	}

}
