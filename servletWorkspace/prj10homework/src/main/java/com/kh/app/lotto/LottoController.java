package com.kh.app.lotto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto")
public class LottoController extends HttpServlet{

	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/lottoPrev.jsp").forward(req, resp);
	}
	
	//처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num_ = req.getParameter("num");
		int num = Integer.parseInt(num_);
		
		req.setAttribute("num", num_);
		req.getRequestDispatcher("/WEB-INF/views/lotto.jsp").forward(req, resp);
	}

	
}
