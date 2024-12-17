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
		try {
			
			Map<String , String> searchMap = new HashMap<>();
			BoardService service = new BoardService();
			String searchType = req.getParameter("searchType");
			String searchValue = req.getParameter("searchValue");
			//화면에 입력받은 값을 2개가져와서 Map으로 만들어주고
			
			searchMap.put("st", searchType);
			searchMap.put("sv", searchValue);
			
			String pno = req.getParameter("pno");
			if(pno == null) {
				pno = "1";
			}
			int listCount = service.getBoardCount();
			//79
			int currentPage = Integer.parseInt(pno);
			
			int pageLimit = 5;
			int boardLimit = 10;
			
			
			PageVo pageVo = new PageVo(listCount,currentPage,pageLimit,boardLimit);
			List<BoardVo> list = new ArrayList<>();
			list = service.getBoardlist(pageVo,searchMap);
			req.setAttribute("pvo", pageVo);
//			리스트에 같이 넘겨주며
			req.setAttribute("volist", list);
			req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req,resp);
	}
}
