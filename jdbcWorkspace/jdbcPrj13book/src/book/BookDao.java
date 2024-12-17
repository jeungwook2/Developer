package book;

import static util.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

	public int insertBook(Connection conn, BookVo vo) throws Exception {

		PreparedStatement pstmt = null;

		int result = 0;
		try {
			
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getGenre());
			pstmt.setString(3, vo.getAuthor());
			pstmt.setString(4, vo.getPrice());

			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int editPrice(Connection conn, BookVo vo) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = """
					UPDATE BOOK
				    SET
				        PRICE = ?
				    WHERE NO = ?
				    AND DEL_YN = 'N'
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPrice());
			pstmt.setString(2, vo.getNo());

			result = pstmt.executeUpdate();
		}finally {
			close(pstmt);
		}
		
		return result;
	
	}

	public int deleteBook(Connection conn, String no) throws Exception {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = """
					UPDATE BOOK
					    SET DEL_YN = 'Y'
					WHERE NO = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	
	}

	public BookVo selectBookByNo(Connection conn, String no) throws Exception {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookVo vo = null;
		
		try {
			
			String sql = """
					SELECT *
					FROM BOOK
					WHERE NO = ?
					AND DEL_YN = 'N'
					""";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String title = rs.getString("TITLE");
				String genre = rs.getString("GENRE");
				String author = rs.getString("AUTHOR");
				String price = rs.getString("PRICE");
				String rental_yn = rs.getString("RENTAL_YN");
				String publicationDate = rs.getString("PUBLICATION_DATE");
				String modifyDate = rs.getString("MODIFY_DATE");
				String delYn = rs.getString("DEL_YN");
				
				vo = new BookVo(no, title, genre, author, price, rental_yn, publicationDate, modifyDate);
				
				}
			
		}finally {
			close(rs);
			close(pstmt);
		}
	
		return vo;
		
	}

	public List<BookVo> selectBoardList(Connection conn) throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BookVo vo = null;
		List<BookVo> voList = null;
		
		
		try {
			
			String sql = """
					SELECT 	
						NO
						, TITLE
						, AUTHOR
						, CASE
							WHEN RENTAL_YN = 'Y' THEN '대여가능'
							WHEN RENTAL_YN = 'N' THEN '대여불가능'
							END  AS "RENTAL_YN"
					FROM BOOK
					WHERE DEL_YN = 'N'
					ORDER BY NO DESC
					""";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			voList = new ArrayList<BookVo>();

			while(rs.next()) {
				String no =rs.getString("NO");
				String title =rs.getString("TITLE");
				String author =rs.getString("AUTHOR");
				String rentalYn =rs.getString("RENTAL_YN");
				
				vo = new BookVo(no, title, null, author, null, rentalYn, null, null);
				voList.add(vo);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return voList;
		
	}

}