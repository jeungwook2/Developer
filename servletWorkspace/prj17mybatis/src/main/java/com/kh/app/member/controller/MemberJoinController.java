package com.kh.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.service.MemberService;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet{
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
			
			MemberService memberService = new MemberService();
			int result = memberService.join(vo);
			
			if(result == 1) {
				resp.sendRedirect("/home");
			}else {
				throw new Exception("회원가입 오류 ");
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
