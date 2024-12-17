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

	public List<BoardVo> getBoardList(SqlSession ss, PageVo pvo,Map<String,String> searchMap) {
//		받아와서
		int offset=pvo.getOffset();
		int limit=pvo.getBoardLimit();
		RowBounds rb = new RowBounds(offset,limit);
		return ss.selectList("BoardMapper.findlist",searchMap,rb);
		// 객체로써 넘겨줄 데이터를 Map으로 넘기고 
		
	}

	public int getBoardCount(SqlSession ss) {
		
		return ss.selectOne("BoardMapper.getBoardCount");
	}

	public int delete(SqlSession ss, String[] delNoArr) {
		
		return ss.delete("BoardMapper.deleteboard",delNoArr);
	}

}
