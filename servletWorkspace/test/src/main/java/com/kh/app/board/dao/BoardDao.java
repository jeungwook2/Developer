package com.kh.app.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.PageVo;

public class BoardDao {

	public int write(BoardVo vo, SqlSession ss) {
		int result = ss.insert("BoardMapper.write",vo);
		return result;
	}

	public List<BoardVo> list(SqlSession ss,Map<String,String> map ,PageVo pvo) {
		int offset = pvo.getOffset();
		int limit = pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset,limit);
		return ss.selectList("BoardMapper.list",map,rb);
	}

	public BoardVo listOne(SqlSession ss,int no) {
		
		return ss.selectOne("BoardMapper.listOne",no);
	}

	public int boardCount(SqlSession ss) {
		
		return ss.selectOne("BoardMapper.boardcount");
	}

	public int delete(SqlSession ss, String[] delarr) {
		
		return ss.update("BoardMapper.deleteBoard",delarr);
	}

	
}
