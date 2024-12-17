package com.kh.app.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{

	//회원가입 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	//회원가입 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			// data
			String userId = req.getParameter("userId");
			String userPwd = req.getParameter("userPwd");
			String userNick = req.getParameter("userNick");
			
			// conn
			Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "C##KH";
			String pwd = "1234";
			conn = DriverManager.getConnection(url, id, pwd);
			
			// SQL
			String sql = "INSERT INTO MEMBER(NO,ID,PWD,NICK) VALUES(SEQ_MEMBER.NEXTVAL,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			pstmt.setString(3, userNick);
			int result = pstmt.executeUpdate();
			
			// result
			if(result == 1) {
				resp.sendRedirect("/app/home");
			}else {
				resp.sendRedirect("/app/common/error");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
