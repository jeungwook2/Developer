package com.kh.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join/insert")
public class MemberJoinController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		String userNick = req.getParameter("userNick");
	
		System.out.println(userId);
		System.out.println(userPwd);
		System.out.println(userNick);
		
		PrintWriter out = resp.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>join success ~ !</h1>");
		out.write("<script>");
		out.write("alert('join success!!!');");
		out.write("</script>");
		out.write("</body>");
		out.write("</html>");
		
	}
}
