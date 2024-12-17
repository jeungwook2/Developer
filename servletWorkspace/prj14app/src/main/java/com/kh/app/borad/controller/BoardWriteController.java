package com.kh.app.borad.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.vo.MemberVo;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			//data
			String title = req.getParameter("title");
			String content = req.getParameter("content");
					
			HttpSession session = req.getSession();
			MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
			String writerNo = loginMemberVo.getNo();
			
			//conn
			Connection conn = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "C##KH";
			String pwd = "1234";
			conn = DriverManager.getConnection(url, id, pwd);
			
			//SQL
			String sql = "INSERT INTO BOARD(NO,TITLE,CONTENT,WRITER_NO) VALUES(SEQ_BOARD.NEXTVAL,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writerNo);
			int result = pstmt.executeUpdate();
			
			//result
			if(result == 1) {
				resp.sendRedirect("/app/home");
			}else {
				resp.sendRedirect("/app/common/error");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
	}
}
