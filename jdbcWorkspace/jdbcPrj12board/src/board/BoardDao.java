package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	
	public int insertBoard(Connection conn, BoardVo vo) throws Exception {
	
		String sql = "INSERT INTO BOARD(NO,TITLE,CONTENT) VALUES (SEQ_BOARD.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	public int updateBoard(Connection conn, BoardVo vo) throws Exception {
		
		String sql = """
				UPDATE BOARD
				    SET
				        TITLE = ?
				        , CONTENT = ?
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getNo());
		int result = pstmt.executeUpdate();
		
		return result;
	}
	
	public int deleteBoardByNo(Connection conn, String no) throws Exception {
		
		String sql = """
				DELETE BOARD
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		return result;
		
	}

	public BoardVo selectBoardByNo(Connection conn, String no) throws Exception {

		String sql = """
				SELECT * FROM BOARD
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		BoardVo vo = null;
		
		if(rs.next()) {
//			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");
			String enrollDate = rs.getString("ENROLL_DATE");
		
			vo = new BoardVo(no, title, content, enrollDate);
		}//if

		rs.close();
		pstmt.close();
		
		return vo;
	
	}//method

	public List<BoardVo> selectBoardList(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM BOARD";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> voList = new ArrayList<BoardVo>();

		while(rs.next()) {
			String no =rs.getString("NO");
			String title =rs.getString("TITLE");
			String content =rs.getString("CONTENT");
			String enrollDate =rs.getString("ENROLL_DATE");
			
			BoardVo vo = new BoardVo(no, title, content, enrollDate);
			voList.add(vo);
		}
		
		rs.close();
		pstmt.close();
		
		return voList;
		
	}//method
	
}//class
