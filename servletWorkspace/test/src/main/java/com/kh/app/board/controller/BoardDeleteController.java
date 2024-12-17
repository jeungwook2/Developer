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
			String[] delarr = req.getParameterValues("del");
			
			for(String x : delarr) {
				
				System.out.println(x);
			}
			
			BoardService service = new BoardService();
			
			int result = service.delete(delarr);
			
			if(result>=1) {
				resp.sendRedirect("/board/list");
			}
		}catch(Exception e) {e.printStackTrace();}
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
