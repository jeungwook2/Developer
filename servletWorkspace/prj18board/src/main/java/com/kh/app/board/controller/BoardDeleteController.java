package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			try {
				 String[] delNoArr = req.getParameterValues("delNo");
				 
				 for(String x : delNoArr) {
					 System.out.println(x);
				 }
				 
				 BoardService service = new BoardService();
				 int result = service.delete(delNoArr);
				 
				 if(result > 0) {
					 resp.sendRedirect("/board/list");
				 }else {
					throw new Exception("게시글 삭제 실패..");
				 }
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	}
}
