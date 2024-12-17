package com.kh.app.subway;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subway")
public class SubwayController extends HttpServlet {
	
	//화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/subway.jsp").forward(req, resp);
	}
	
	//처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String age_ = req.getParameter("age");
		int age = Integer.parseInt(age_);
		
		String price = "";
		if(age < 8) {
			price = "무료";
		}else if(age < 20) {
			price = "청소년(800원)";
		}else if(age < 65){
			price ="성인(1000원)";
		}else {
			price ="노인(경로우대)";
		}
		
		req.setAttribute("age", age_);
		req.setAttribute("price", price);
		req.getRequestDispatcher("/WEB-INF/views/price.jsp").forward(req, resp);
		
	}

}