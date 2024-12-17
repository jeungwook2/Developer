package com.kh.app.member.service;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	public int join(MemberVo vo) throws Exception {
//		Connection conn = JDBCTemplate.getConnetcion();
		SqlSession ss = JDBCTemplate.getSqlSession();
		//tx
//	     SqlSession 가지고와서 처리한다
	      MemberDao memberDao = new MemberDao();
	       int result = memberDao.join(vo,ss);
	       

	       if(result ==1) {
//	    	   JDBCTemplate.commit(conn);
	    	  ss.commit();
	       }else {
//	    	   JDBCTemplate.rollback(conn);
	    	   ss.rollback();
	       }
//	       JDBCTemplate.close(conn);
	       ss.close();
	       return result;
	}

	public MemberVo login(MemberVo vo) throws Exception {
//		Connection conn = JDBCTemplate.getConnetcion();
		SqlSession ss = JDBCTemplate.getSqlSession();
		
		MemberDao dao = new MemberDao();
		MemberVo loginVo = dao.login(vo,ss);
//		JDBCTemplate.commit(conn);
		ss.close();
//		if(loginVo !=  null) {
////			JDBCTemplate.commit(conn);
//			ss.commit();
//		}else {
////			JDBCTemplate.rollback(conn);
//			ss.rollback();
//		}
			return loginVo;
	}

	
}
