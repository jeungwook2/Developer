package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		// conn
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "C##KH";
		String pwd = "1234";
		Connection conn = DriverManager.getConnection(url, id, pwd);

		Scanner sc = new Scanner(System.in);
		System.out.print("조회할 게시글 번호 : ");
		String num = sc.nextLine();
		
		// SQL
		String sql = """
				SELECT * FROM BOARD
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("Title");
			String content = rs.getString("Content");
			String enrollDate = rs.getString("Enroll_Date");
			
			BoardVo vo = new BoardVo(no, title, content, enrollDate);
		
			System.out.println(vo);
		}
		
		
	}

}
