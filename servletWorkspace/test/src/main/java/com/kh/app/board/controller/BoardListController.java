package com.kh.app.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.board.service.BoardService;
import com.kh.app.board.vo.BoardVo;
import com.kh.app.page.PageVo;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("UTF-8");
		try {
			BoardService service = new BoardService();
			Map<String, String> searchMap = new HashMap<>();
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			List<BoardVo> list = new ArrayList<>();
			searchMap.put("st", searchType);
			searchMap.put("sv", searchValue);
			
			String pno = req.getParameter("pno");
			if(pno == null) {
				pno = "1";
			}
			int listCount = service.boardCount();
			int currentPage = Integer.parseInt(pno);
			
			int pageLimit = 5;
			int boardLimit = 10;
			PageVo pageVo = new PageVo(listCount,currentPage,pageLimit,boardLimit);
			list = service.list(searchMap,pageVo);
			
			for(BoardVo vo : list) {
				System.out.println(vo);
			}
			req.setAttribute("pvo", pageVo);
			req.setAttribute("list", list);
			
			if(list != null) {
				req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
			}else {
				throw new Exception("읽어오기 실패");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
		
		
	}

}
