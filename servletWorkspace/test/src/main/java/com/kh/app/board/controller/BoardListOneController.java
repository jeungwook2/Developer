package com.kh.app.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;

@WebServlet("/board/listOne")
public class BoardListOneController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		try {
			String strno = req.getParameter("no");
			BoardVo vo = new BoardVo();
			BoardService service = new BoardService();
			int no = Integer.parseInt(strno);
			vo = service.listOne(no);
			System.out.println(vo);
			if (vo != null) {
				req.setAttribute("vo", vo);
				req.getRequestDispatcher("/WEB-INF/views/board/listOne.jsp").forward(req, resp);
			} else {
				throw new Exception("상세조회 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/common/error");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
