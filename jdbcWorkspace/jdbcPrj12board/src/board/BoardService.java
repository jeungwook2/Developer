package board;

import java.sql.Connection;
import java.util.List;

import db.JDBCTemplate;

public class BoardService {

	public int insertBoard(BoardVo vo) throws Exception {
		
		if(vo.getTitle().contains("18")) {
			throw new Exception("욕 ㄴㄴ");
		}
		
		Connection conn = null;
		int result = 0;
		
		try {
			// db
			conn = JDBCTemplate.getConnection();
			BoardDao dao = new BoardDao();
			result = dao.insertBoard(conn, vo);
			
			// 트랜잭션 처리
			if(result == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}finally {
			conn.close();
		}
		
		return result;
	}
	
	public int updateBoard(BoardVo vo) throws Exception {
		
		if(vo.getTitle().contains("18")) {
			throw new Exception("욕 ㄴㄴ");
		}
		
		Connection conn = null;
		int result = 0;
		
		try {
			// db
			conn = JDBCTemplate.getConnection();
			BoardDao dao = new BoardDao();
			result = dao.updateBoard(conn, vo);
			
			// 트랜잭션 처리
			if(result == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}finally {
			conn.close();
		}
		
		return result;
	}
	
	public int deleteBoardByNo(String no) throws Exception {
		
		//DAO
		Connection conn = null;
		int result = 0;
		
		try {
			conn = JDBCTemplate.getConnection();
			BoardDao dao = new BoardDao();
			result = dao.deleteBoardByNo(conn, no);
			
			// 트랜잭션 처리
			if(result == 1) {
				conn.commit();
			}else {
				conn.rollback();
			}
		}finally {
			conn.close();
		}
		
		return result;
		
	}

	public BoardVo selectBoardByNo(String no) throws Exception {
		
		Connection conn = null;
		BoardVo vo = null;
		
		try {
			BoardDao dao = new BoardDao();
			conn = JDBCTemplate.getConnection();
			vo = dao.selectBoardByNo(conn, no);
		}finally {
			conn.close();
		}
	
		
		return vo;
	}

	public List<BoardVo> selectBoardList() throws Exception {
		
		Connection conn = null;
		List<BoardVo> voList = null;
		
		try {
			// DAO
			BoardDao dao = new BoardDao();
			conn = JDBCTemplate.getConnection();
			voList = dao.selectBoardList(conn);
		}finally {
			// close
			conn.close();
		}
		
		return voList;
		
	}
	
}//class
