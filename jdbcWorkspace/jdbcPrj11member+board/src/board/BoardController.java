package board;

import static util.KhUtil.sc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.JDBCTemplate;
import main.Main;

public class BoardController {
	
	//메뉴
	public void menu() throws Exception {
		System.out.println("----- MENU -----");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 제목 수정");
		System.out.println("3. 게시글 내용 수정");
		System.out.println("4. 게시글 삭제");
		System.out.println("5. 게시글 목록 조회");
		System.out.println("6. 게시글 상세 조회");
		System.out.println("7. 게시글 검색(제목)");
		System.out.println("8. 게시글 검색(내용)");
		System.out.println("9. 게시글 검색(작성자)");
		
		System.out.print("원하는 메뉴 번호 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : insertBoard(); break;
		case "2" : updateTitle(); break;
		case "3" : updateContent(); break;
		case "4" : deleteBoard(); break;
		case "5" : selectBoardList(); break;
		case "6" : selectBoardOneByNo(); break;
		case "7" : searchBoardByTitle(); break;
		case "8" : searchBoardByContent(); break;
		case "9" : searchBoardByWriter(); break;
		default : System.out.println("잘못된 번호입니다.");
		}
	}
	
	//게시글 작성
	public void insertBoard() throws Exception {
		System.out.println("----- insertBoard -----");
		
		if(Main.loginMember == null) {
			System.out.println("로그인 하고오세요");
			return;
		}
		
		//data
		System.out.print("title : ");
		String title = sc.nextLine();
		System.out.print("content: ");
		String content = sc.nextLine();
		String writerNo = Main.loginMember.getNo();
		
		//biz
		if(title.contains("18")) {
			throw new Exception("부적절한 제목입니다.");
		}
		
		//db
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				INSERT INTO BOARD
				(
				    NO
				    ,TITLE
				    ,CONTENT
				    ,WRITER_NO
				)
				VALUES
				(
				    SEQ_BOARD.NEXTVAL
				    ,?
				    ,?
				    ,?
				)
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, content);
		pstmt.setString(3, writerNo);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("게시글 작성 성공 !");
		}else {
			System.out.println("게시글 작성 실패 ...");
		}
	}
	
	//게시글 제목 수정
	public void updateTitle() throws Exception {
		System.out.println("----- updateTitle -----");
		
		//data
		System.out.print("수정할 게시글 번호 : ");
		String no = sc.nextLine();
		System.out.print("수정할 제목 : ");
		String title = sc.nextLine();
		String writerNo = Main.loginMember.getNo();
		
		//biz
		if(title.contains("18")) {
			throw new Exception("부적절한 제목입니다.");
		}
		
		//db
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				UPDATE BOARD
				    SET
				        TITLE = ?
				        , MODIFY_DATE = SYSDATE
				WHERE NO = ?
				AND WRITER_NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, no);
		pstmt.setString(3, writerNo);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("제목 변경 성공 !");
		}else {
			System.out.println("제목 변경 실패 ...");
		}
		
	}
	
	
	//게시글 내용 수정
	public void updateContent() throws Exception {
		System.out.println("----- updaetContent -----");

		//data
		System.out.print("수정할 게시글 번호 : ");
		String no = sc.nextLine();
		System.out.print("수정할 내용 : ");
		String content = sc.nextLine();
		String writerNo = Main.loginMember.getNo();
		
		//biz
		if(content.contains("18")) {
			throw new Exception("욕ㄴㄴ");
		}
		//db
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				UPDATE BOARD
				    SET
				        CONTENT = ?
				        , MODIFY_DATE = SYSDATE
				WHERE NO = ?
				AND WRITER_NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, content);
		pstmt.setString(2, no);
		pstmt.setString(3, writerNo);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("내용 수정 성공 !");
		}else {
			System.out.println("내용 수정 실패 ...");
		}
	}
	
	//게시글 삭제
	public void deleteBoard() throws Exception {
		System.out.println("----- deleteBoard -----");
		//data
		System.out.print("삭제할 게시글 번호 : ");
		String no = sc.nextLine();
		String writerNo = Main.loginMember.getNo();
		//biz
		//db
		Connection conn = JDBCTemplate.getConnection();
		String sql = """
				UPDATE BOARD
				    SET
				        DEL_YN = 'Y'
				        , MODIFY_DATE = SYSDATE
				WHERE NO = ?
				AND WRITER_NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		pstmt.setString(2, writerNo);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("게시글 삭제 성공 !");
		}else {
			System.out.println("게시글 삭제 실패 ...");
		}
	}
	
	//게시글 조회수 증가
	public int increaseHit(Connection conn, String no) throws Exception {
		String sql = """
				UPDATE BOARD
				    SET 
				        HIT = HIT+1
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		return result;
	}
	
	//게시글 목록 조회
	public void selectBoardList() throws Exception {
		System.out.println("----- selectBoardList -----");
		
		//data
		//biz
		//db
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				SELECT 
				    B.NO
				    , B.TITLE
				    , B.CONTENT
				    , B.WRITER_NO
				    , B.HIT
				    , B.ENROLL_DATE
				    , B.MODIFY_DATE
				    , B.DEL_YN
				    , M.NICK		AS WRITER_NICK
				FROM BOARD  B
				JOIN MEMBER M ON ( B.WRITER_NO = M.NO )
				WHERE B.DEL_YN = 'N'
				ORDER BY B.NO DESC
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		System.out.print("번호");
		System.out.print(" | ");
		System.out.print("제목");
		System.out.print(" | ");
		System.out.print("작성자");
		System.out.println();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String writerNick = rs.getString("WRITER_NICK");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			BoardVo vo = new BoardVo(no, title, content, writerNo, writerNick, hit, enrollDate, modifyDate, delYn);
			System.out.print(vo.getNo());
			System.out.print(" | ");
			System.out.print(vo.getTitle());
			System.out.print(" | ");
			System.out.print(vo.getWriterNick());
			System.out.println();
		}
	}
	
	//게시글 상세 조회
	public void selectBoardOneByNo() throws Exception {
		System.out.println("----- selectBoardOneByNo -----");
		
		//data
		System.out.print("조회할 게시글 번호 : ");
		String no = sc.nextLine();
		
		//biz
		
		Connection conn = JDBCTemplate.getConnection();
		//db (update)
		int increaseResult = increaseHit(conn , no);
		
		if(increaseResult != 1) {
			throw new Exception("조회수 증가 실패 ...");
		}
		
		//db (select)
		
		String sql = """
				SELECT *
				FROM BOARD
				WHERE NO = ?
				AND DEL_YN = 'N'
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		if( rs.next() ) {
//			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			BoardVo vo = new BoardVo(no, title, content, writerNo, null, hit, enrollDate, modifyDate, delYn);
			System.out.println(vo);
		}
	}
	
	//게시글 검색(제목)
	public void searchBoardByTitle() throws Exception {
		System.out.println("----- searchBoardByTitle -----");
		
		//data
		System.out.print("검색할 제목 : ");
		String searchValue = sc.nextLine();
		
		//biz
		if(searchValue.length() < 2) {
			throw new Exception("검색어는 2글자 이상 입력해주세요");
		}
		
		//db
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				SELECT *
				FROM BOARD
				WHERE TITLE LIKE '%' || ? || '%'
				AND DEL_YN = 'N'
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			BoardVo vo = new BoardVo(no, title, content, writerNo, null, hit, enrollDate, modifyDate, delYn);
			System.out.println(vo);
		}
	}
	
	//게시글 검색(내용)
	public void searchBoardByContent() throws Exception {
		System.out.println("----- searchBoardByTitle -----");
		
		//data
		System.out.print("검색할 내용 : ");
		String searchValue = sc.nextLine();
		
		//biz
		if(searchValue.length() < 2) {
			throw new Exception("검색어는 2글자 이상 입력해주세요");
		}
		
		//db
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				SELECT *
				FROM BOARD
				WHERE CONTENT LIKE '%' || ? || '%'
				AND DEL_YN = 'N'
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, searchValue);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			BoardVo vo = new BoardVo(no, title, content, writerNo, null, hit, enrollDate, modifyDate, delYn);
			System.out.println(vo);
		}
	}
	//게시글 검색(작성자)
	public void searchBoardByWriter() throws Exception {
		System.out.println("----- searchBoardByTitle -----");
		
		//data
		System.out.print("검색할 작성자 닉네임 : ");
		String searchValue = sc.nextLine();
		
		//db
		Connection conn = JDBCTemplate.getConnection();

		//닉네임 주고 번호 얻기
		String memberNo = selectMemberNoByNick(conn , searchValue);
		
		String sql = """
				SELECT *
				FROM BOARD
				WHERE WRITER_NO = ?
				AND DEL_YN = 'N'
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, memberNo);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String writerNo = rs.getString("WRITER_NO");
			String hit = rs.getString("HIT");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			BoardVo vo = new BoardVo(no, title, content, writerNo, null, hit, enrollDate, modifyDate, delYn);
			System.out.println(vo);
		}
	}
	
	//닉네임 으로 번호 얻기
	public String selectMemberNoByNick( Connection conn , String nick ) throws Exception{
		String sql = """
				SELECT 
				    NO
				FROM MEMBER
				WHERE NICK = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nick);
		ResultSet rs = pstmt.executeQuery();
		
		String no = null;
		if( rs.next() ) {
			no = rs.getString("NO");
		}
		return no;
	}
	
}//class
