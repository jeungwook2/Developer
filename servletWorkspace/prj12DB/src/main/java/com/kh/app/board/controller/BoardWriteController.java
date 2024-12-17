package com.kh.app.board.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{
		
		// 게시글 작성 화면
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
		}
		
		// 게시글 작성 처리
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// data
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			// conn
			Connection conn = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String id = "C##KH";
				String pwd = "1234";
				conn = DriverManager.getConnection(url, id, pwd);								
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			// SQL
			int result = 0;
			try {
				String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT) VALUES(SEQ_BOARD.NEXTVAL, ?, ?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// result
			if(result == 1) {
				resp.sendRedirect("/prj12DB/board/list");
			}else {
				resp.sendRedirect("/prj12DB/common/error");
			}
		}
}
