package book;

import java.sql.Connection;
import static util.JDBCTemplate.*;
import java.util.List;


public class BookService {

	public int insertBook(BookVo vo) throws Exception {
		
		Connection conn = null;
		int result = 0;
		
		try {
			
			//biz
			if(vo.getTitle().length() < 1) {
				throw new Exception("title 을 1글자 이상 입력해주세요.");
			}
			
			if(Integer.parseInt(vo.getPrice()) < 100) {
				throw new Exception("가격은 100원 이상이여야 합니다.");
			}
			
			//DAO
			conn = getConnection();
			BookDao dao = new BookDao();
			result = dao.insertBook(conn, vo);
			
			//tx
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}finally {
			//close
			close(conn);
			
		}
		
		return result;
		
	}

	public int editPrice(BookVo vo) throws Exception {
		
		Connection conn = null;
		int result = 0;
		
		try {
			
			//biz			
			if(Integer.parseInt(vo.getPrice()) < 100) {
				throw new Exception("가격은 100원 이상이여야 합니다.");
			}
			
			//DAO
			conn = getConnection();
			BookDao dao = new BookDao();
			result = dao.editPrice(conn, vo);
			
			//tx
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}finally {
			//close
			close(conn);
			
		}
		
		return result;
		
	}

	public int deleteBook(String no) throws Exception {
		
		Connection conn = null;
		int result = 0;
		
		try {
			
			conn = getConnection();
			//DAO
			BookDao dao = new BookDao();
			result = dao.deleteBook(conn, no);
			
			//tx
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
		}finally {
			//close
			close(conn);
		}
		
	
		return result;
	
	}

	public BookVo selectBookByNo(String no) throws Exception {
		
		Connection conn = null;
		BookVo vo = null;
		
		try {
			
			//DAO
			conn = getConnection();
			BookDao dao = new BookDao();
			vo = dao.selectBookByNo(conn, no);
			
		}finally {
			//close
			close(conn);
		}
	
		return vo;
		
	}

	public List<BookVo> selectBookAll() throws Exception {

		Connection conn = null;
		List<BookVo> voList = null;
		
		try {
			// DAO
			BookDao dao = new BookDao();
			conn = getConnection();
			voList = dao.selectBoardList(conn);
		}finally {
			// close
			close(conn);
		}
		
		return voList;
	
	}

}
