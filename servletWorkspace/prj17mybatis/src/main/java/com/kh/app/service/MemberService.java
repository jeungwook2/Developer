package com.kh.app.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {

	public int join(MemberVo vo) throws Exception {
		int result = 0;
		SqlSession ss =null;
		try {
			 ss= JDBCTemplate.getSqlSession();
			
			
			MemberDao dao = new MemberDao();
			result = dao.join(vo,ss);
			
			if(result ==1) {
				ss.commit();
			}else {
				ss.rollback();
			}
		}finally{
			
			ss.close();
		}
		return result;
	}

	public MemberVo login(MemberVo vo) throws Exception {
		SqlSession ss = null;
		MemberVo loginVo = null;
		try {
			ss = JDBCTemplate.getSqlSession();
			
			MemberDao dao = new MemberDao();
			
			loginVo = dao.login(vo,ss);

		}finally {
			
			ss.close();
		}		
		return loginVo;
	}

}
