package com.kh.app.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class MemberDao {
	public int join(MemberVo vo ,SqlSession ss) throws Exception {
		
		   
	     //sql
//	       String sql = "INSERT INTO MEMBER(NO,ID,PWD,NICK)VALUES(SEQ_MEMBER.NEXTVAL,?,?,?)";
//	       PreparedStatement pstmt = conn.prepareStatement(sql);
//	       pstmt.setString(1, vo.getId());
//	       pstmt.setString(2, vo.getPwd());
//	       pstmt.setString(3, vo.getNick());
//	       int result = pstmt.executeUpdate();
//	       
//	       JDBCTemplate.close(pstmt);
		
		//작성해놓으면 위와 동일하다.
			int result = ss.insert("Member.join",vo);
	       return result;
	       
	       
	}

	public MemberVo login(MemberVo vo, SqlSession ss) throws Exception {
//			String sql="SELECT * FROM MEMBER WHERE ID = ? AND PWD =?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, vo.getId());
//			pstmt.setString(2, vo.getPwd());
//			ResultSet rs = pstmt.executeQuery();
//			MemberVo memberVo = new MemberVo();
//			if(rs.next()) {
//				String no = rs.getString("NO");
//				String id = rs.getString("ID");
//				String pwd = rs.getString("PWD");
//				String nick = rs.getString("NICK");
//				String enrollDate = rs.getString("ENROLL_DATE");
//				String modifyDate = rs.getString("MODIFY_DATE");
//				String delYn = rs.getString("DEL_YN");
//				
//				memberVo.setNo(no);
//				memberVo.setId(id);
//				memberVo.setPwd(pwd);
//				memberVo.setNick(nick);
//				memberVo.setEnrollDate(enrollDate);
//				memberVo.setModifyDate(modifyDate);
//				memberVo.setDelYn(delYn);
//				
//			}
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(pstmt);
			
			
			
			
			
			
		return ss.selectOne("Member.login",vo);
	}

}
