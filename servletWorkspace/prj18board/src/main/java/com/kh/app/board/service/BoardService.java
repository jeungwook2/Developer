package com.kh.app.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.dao.BoardDao;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.db.JDBCTemplate;
import com.kh.app.page.PageVo;

public class BoardService {

	public int write(BoardVo vo) throws Exception {
		int result = 0;
		SqlSession ss = JDBCTemplate.getSqlSession();
		try {
			BoardDao dao = new BoardDao();
			result = dao.write(vo,ss);
			
			if(result ==1) {
				ss.commit();
			}else {
				ss.rollback();
			}
		}finally {
			ss.close();
		}
		return result;
	}

	public List<BoardVo> getBoardlist(PageVo pvo,Map<String,String> searchMap) throws Exception {
		
		SqlSession ss = JDBCTemplate.getSqlSession();
		List<BoardVo> list = new ArrayList<>();
		BoardDao dao = new BoardDao();
		list = dao.getBoardList(ss,pvo,searchMap);
		
		ss.close();
		return list;
	}

	public int getBoardCount() throws Exception {
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		BoardDao boardDao = new BoardDao();
		int result = boardDao.getBoardCount(ss);
		
		ss.close();
		return result ;
	}

	public int delete(String[] delNoArr) throws Exception {
		SqlSession ss = JDBCTemplate.getSqlSession();
		BoardDao dao = new BoardDao();
		int result = dao.delete(ss,delNoArr);
		
		if(result >0) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

	

}
