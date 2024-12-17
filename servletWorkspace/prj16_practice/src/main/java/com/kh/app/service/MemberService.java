package com.kh.app.service;

import java.sql.Connection;

import com.kh.app.connection.JDBCTemplate;
import com.kh.app.member.controller.MemberVo;
import com.kh.app.memberdao.MemberDao;

public class MemberService {

	public int join(MemberVo vo) throws Exception {
		
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		int result = dao.join(vo,conn);
		
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

}
