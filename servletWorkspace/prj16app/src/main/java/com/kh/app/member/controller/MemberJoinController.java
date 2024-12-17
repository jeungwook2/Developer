package com.kh.app.member.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userId = req.getParameter("userId");
			String userPwd = req.getParameter("userPwd");
			String userNick = req.getParameter("userNick");
			
			
			MemberVo vo = new MemberVo();
			vo.setId(userId);
			vo.setPwd(userPwd);
			vo.setNick(userNick);
			//conn
		      MemberService service = new MemberService();
		      int result = service.join(vo);
		      
		      if(result ==1) {
		    	   resp.sendRedirect("/home");
		       }else {
		    	   throw new Exception("회원가입 중 에러발생..");
		       }
		      
		       
		       
		       
		    //
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/common/error");
		}
		
	}
}
