package book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import db.JDBCTemplate;

public class BookController {

	private Scanner sc;
	
	public BookController() {
		this.sc = new Scanner(System.in);
	}
	
	//메뉴
	public void menu() throws Exception {
		System.out.println("----- 메뉴 -----");
		
		System.out.println("1. 작성하기");
		System.out.println("2. 수정하기(가격변경)");
		System.out.println("3. 대여하기");
		System.out.println("4. 반납하기");
		System.out.println("5. 삭제하기");
		System.out.println("6. 상세조회");
		System.out.println("7. 목록조회 (최신순)");
		System.out.println("8. 도서검색 (제목)");
		System.out.println("9. 도서검색 (가격)");
		
		System.out.print("원하는 메뉴 번호 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : insert(); break;
		case "2" : updatePrice(); break;
		case "3" : rentBook(); break;
		case "4" : returnBook(); break;
		case "5" : deleteBook(); break;
		case "6" : findBookOneByNo(); break;
		case "7" : findBookAll(); break;
		case "8" : findBookByTitle(); break;
		case "9" : findBookByPrice(); break;
		default : System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	//작성하기
	private void insert() throws Exception {
		System.out.println("----- 도서 등록 -----");
		
		// data
		System.out.print("title : ");
		String title = sc.nextLine();
		System.out.print("genre : ");
		String genre = sc.nextLine();
		System.out.print("author : ");
		String author = sc.nextLine();
		System.out.print("price : ");
		String price = sc.nextLine();
		
		// save (oracle DB)
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				INSERT INTO BOOK
				(
				    NO
				    , TITLE
				    , GENRE
				    , AUTHOR
				    , PRICE
				) 
				VALUES
				(
				    SEQ_BOOK.NEXTVAL
				    , ?
				    , ?
				    , ?
				    , ?
				)
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, genre);
		pstmt.setString(3, author);
		pstmt.setString(4, price);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("도서 등록 성공 !");
		}else {
			System.out.println("도서 등록 실패 ...");
		}
	}
	
	//수정하기 (가격변경)
	private void updatePrice() throws Exception {
		System.out.println("----- 도서 가격 변경 -----");
		
		// data
		System.out.print("no : ");
		String no = sc.nextLine();
		System.out.print("price : ");
		String price = sc.nextLine();
		
		// update
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				UPDATE BOOK
			    SET
			        PRICE = ?
			    WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, price);
		pstmt.setString(2, no);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("가격 수정 완료 !");
		}else {
			System.out.println("가격 수정 실패 ...");
		}
		
	}
	
	//대여하기 == 수정하기 (렌탈여부)
	private void rentBook() throws Exception {
		System.out.println("----- 대여하기 -----");
		
		// data
		System.out.print("대여할 책 번호 : ");
		String no = sc.nextLine();
		
		// update
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				UPDATE BOOK
			    SET
			        RENTAL_YN = 'N'
			    WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("대여 성공 !");
		}else {
			System.out.println("대여 실패 ...");
		}
		
	}
	
	//반납하기 == 수정하기 (렌탈여부)
	private void returnBook() throws Exception {
		System.out.println("----- 반납하기 -----");
		
		// data
		System.out.print("반납할 책 번호 : ");
		String no = sc.nextLine();
		
		// update
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				UPDATE BOOK
			    SET
			        RENTAL_YN = 'Y'
			    WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("반납 성공 !");
		}else {
			System.out.println("반납 실패 ...");
		}
		
	}
		
	//삭제하기
	private void deleteBook() throws Exception {
		System.out.println("----- 도서 삭제 -----");
		
		// data
		System.out.print("삭제할 도서 번호 : ");
		String no = sc.nextLine();
		
		// delete
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				DELETE BOOK
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("삭제 성공 !");
		}else {
			System.out.println("삭제 실패 ...");
		}
		
	}
	
	//상세조회
	private void findBookOneByNo() throws Exception {
		System.out.println("----- 상세 조회 -----");
		
		// data
		System.out.print("조회할 도서 번호 : "); 
		String no = sc.nextLine();
		
		// select
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				SELECT *
				FROM BOOK
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String title = rs.getString("TITLE");
			String genre = rs.getString("GENRE");
			String author = rs.getString("AUTHOR");
			String price = rs.getString("PRICE");
			String rentalYn = rs.getString("RENTAL_YN");
			String publicationDate = rs.getString("PUBLICATION_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			
			BookVo vo = new BookVo(no, title, genre, author, price, rentalYn, publicationDate, modifyDate);
			System.out.println(vo);
		}else {
			System.out.println("상세 조회 실패 ...");
		}
		
	}
	
	//목록조회 (최신순)
	private void findBookAll() throws Exception {
		System.out.println("----- 목록조회 -----");
		
		// select
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				SELECT *
				FROM BOOK
				ORDER BY NO DESC
				""";
		PreparedStatement 
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");

			System.out.println(no + " / " + title);
		}
	}

	//검색 (제목)
	private void findBookByTitle() throws Exception {
		System.out.println("----- 도서 검색(제목) -----");
		
		// data
		System.out.print("찾고싶은 책 제목 : ");
		String searchValue = sc.nextLine();
		
		// select
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				SELECT *
				FROM BOOK
				WHERE TITLE LIKE '%' || ? || '%'
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			System.out.println(no + " / " + title);
		}

	}
	
	//검색 (가격 범위 설정)
	private void findBookByPrice() throws Exception {
		System.out.println("----- 도서 검색(가격) -----");
		
		// data
		System.out.print("가격 최소값 : ");
		String priceStart = sc.nextLine();
		System.out.print("가격 최대값 : ");
		String priceEnd = sc.nextLine();
		
		// select
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				SELECT *
				FROM BOOK
				WHERE PRICE BETWEEN ? AND ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, priceStart);
		pstmt.setString(2, priceEnd);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String price = rs.getString("PRICE");
			System.out.println(no + " / " + title + " / " + price);
		}

	}
	
	//검색 (지은이)
	
	//검색 (장르)
	
	//검색 (출판일 범위 설정)
}
