package com.kh.app.memberdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.app.connection.JDBCTemplate;
import com.kh.app.member.controller.MemberVo;

public class MemberDao {

	public int join(MemberVo vo, Connection conn) throws Exception {
		String sql = "INSERT INTO MEMBER(NO,ID,PWD,NICK) VALUES(SEQ_MEMBER.NEXTVAL,?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		return result;
	}

}
