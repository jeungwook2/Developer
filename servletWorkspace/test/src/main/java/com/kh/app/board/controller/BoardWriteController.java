package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/write.jsp").forward(req, resp);
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
		try {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writerNo = "1";
			
			BoardVo vo = new BoardVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setWriterNo(writerNo);
			
			
			BoardService service = new BoardService();
			int result = service.write(vo);
			
			if(result ==1) {
				resp.sendRedirect("/board/list");
			}else {
				throw new Exception("작성하기 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/home");
		}
	}
}

