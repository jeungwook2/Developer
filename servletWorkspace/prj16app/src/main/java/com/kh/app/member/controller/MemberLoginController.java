package com.kh.app.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userId = req.getParameter("userId");
			String userPwd = req.getParameter("userPwd");
			
			
			MemberVo vo = new MemberVo();
			vo.setId(userId);
			vo.setPwd(userPwd);
			
			MemberService service = new MemberService();
			MemberVo loginvo = service.login(vo);
			
			
			if(loginvo != null) {
				req.getSession().setAttribute("loginVo", loginvo);
				resp.sendRedirect("/home");
			}else{
				throw new Exception("로그인 오류");
			}
		}catch(Exception e) {
			e.printStackTrace();
			resp.sendRedirect("/common/error");
		}
		
		
		
	}
}
