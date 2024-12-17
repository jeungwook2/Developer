package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import db.JDBCTemplate;

public class BoardController {
	
	private Scanner sc;
	
	public BoardController() {
		sc = new Scanner(System.in);
	}
	
	// 메뉴
	public void menu() throws Exception {
		System.out.println("----- menu -----");
		
		System.out.println("1. 작성하기");
		System.out.println("2. 수정하기");
		System.out.println("3. 삭제하기");
		System.out.println("4. 상세조회하기");
		System.out.println("5. 목록조회하기");

		System.out.print("원하시는 메뉴 번호를 입력하세요 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : write(); break;
		case "2" : edit(); break;
		case "3" : delete(); break;
		case "4" : findBoardByNo(); break;
		case "5" : findBoardAll(); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	// 작성
	public void write() throws Exception {
		System.out.println("----- write -----");
		
		//data
		System.out.print("title : ");
		String title = sc.nextLine();
		System.out.print("content : ");
		String content = sc.nextLine();
		
		//data -> obj
		BoardVo vo = new BoardVo(null, title, content, null);
		
		//save (DB)
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = "INSERT INTO BOARD(NO,TITLE,CONTENT) VALUES (SEQ_BOARD.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		
		int result = pstmt.executeUpdate();
		
		
		if(result == 1) {
			System.out.println("게시글 작성 성공 !");
		}else {
			System.out.println("게시글 작성 실패 !");
		}
	}
	
	// 수정
	public void edit() throws Exception {
		System.out.println("----- edit -----");
		
		// data
		System.out.print("수정할 게시글 번호 : ");
		String no = sc.nextLine();
		System.out.print("수정할 제목 : ");
		String title = sc.nextLine();
		System.out.print("수정할 내용 : ");
		String content = sc.nextLine();
		
		// update
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				UPDATE BOARD
					SET
				    	TITLE = ?
				    	, CONTENT = ?
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, no);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("수정 성공 !");
		}else {
			System.out.println("수정 실패...");
		}
	}
	
	// 삭제
	public void delete() throws Exception {
		System.out.println("----- delete -----");
		
		//data
		System.out.println("삭제할 게시글 번호 : ");
		String num = sc.nextLine();
		
		// delete
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				DELETE BOARD
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("삭제 성공 !");
		}else {
			System.out.println("삭제 실패...");
		}
		
	}
	
	// 상세조회
	public void findBoardByNo() throws Exception {
		System.out.println("----- 상세조회 -----");
		
		//data
		System.out.print("조회할 게시글 번호 : ");
		String num = sc.nextLine();
		
		//select
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				SELECT * FROM BOARD
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, num);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			BoardVo vo = new BoardVo(no, title, content, enrollDate);
			System.out.println(vo);
			
		}else {
			System.out.println("상세조회 실패");
		}
		
	}
	
	// 목록조회
	public void findBoardAll() throws Exception {
		System.out.println("----- 목록조회 -----");
		
		// select
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				SELECT * FROM BOARD ORDER BY NO DESC
				""";
		PreparedStatement 
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
			
			BoardVo vo = new BoardVo(no, title, content, enrollDate);
			System.out.println(vo);
		}
	}
	
	// 검색(제목)
	public void search() {}
	
	// 검색(내용)
	public void searchc() {}
	
}
