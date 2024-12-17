package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/write")
public class BoardInsertController extends HttpServlet{

	// 게시글 작성 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
		
	}
	
	// 게시글 작성 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//DB(출력문으로 대체,,,)
		System.out.println(title);
		System.out.println(content);
		int result = 0; //무조건 성공이라고 가정
		
		//result
		if(result == 1) {
			resp.sendRedirect("/app11/board/list");
		}else {
			req.setAttribute("msg", "게시글 작성 실패...(리퀘스트 영역)");
			req.getSession().setAttribute("msg", "게시글 작성 실패...(세션 영역)");
			req.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(req, resp);
		}
		
	}
	
}
