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
		SqlSession ss= JDBCTemplate.createSqlSession();
		int result = 0;
		try {
			 
			
			BoardDao dao = new BoardDao();
			 result = dao.write(vo,ss);
			
			if(result == 1) {
				ss.commit();
			}else {
				ss.rollback();
			}
		}finally {
			ss.close();
		}
		
		return result;
		
	}

	public List<BoardVo> list(Map<String,String> map,PageVo pvo) throws Exception {
		SqlSession ss = JDBCTemplate.createSqlSession();
		List<BoardVo> list = new ArrayList<>();
		try {

			BoardDao dao = new BoardDao();
			list = dao.list(ss,map,pvo);
			
		}finally {
			ss.close();
		}
		
		
		return list;
	}

	public BoardVo listOne(int no) throws Exception {
		SqlSession ss = JDBCTemplate.createSqlSession();
		
		BoardDao dao = new BoardDao();
		BoardVo vo = dao.listOne(ss,no);
		
		ss.close();
		return vo;
	}

	public int boardCount() throws Exception {
		SqlSession ss = JDBCTemplate.createSqlSession();
		
		BoardDao dao = new BoardDao();
		int result = dao.boardCount(ss);
		
		ss.close();
		return result;
	}

	public int delete(String[] delarr) throws Exception {
		SqlSession ss = JDBCTemplate.createSqlSession();
		
		BoardDao dao = new BoardDao();
		int result = dao.delete(ss,delarr);
		
		if(result >=1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

}
