package com.kh.app.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join/view")
public class MemberJoinViewController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		  out.write("<html>");
		  out.write("<head>");
		  out.write("<style>");
		  out.write("h1{");
		  out.write("background-color:black;");
		  out.write("color:white;");
		  out.write("}");
		  out.write("</style>");
		  out.write("</head>");
		  out.write("<body>");
		  out.write("<h1>");
		  out.write("USER JOIN");
		  out.write("</h1>");
		  out.write("<form action=\"/prac02/join/insert\">");
		  out.write("<input type=\"text\" name=\"userId\" placeholder=\"USER ID\">");
		  out.write("<br>");
		  out.write("<input type=\"password\" name=\"userPwd\" placeholder=\"USER PWD\">");
		  out.write("<br>");
		  out.write("<input type=\"text\" name=\"userNick\" placeholder=\"USER NICK\">");
		  out.write("<br>");
		  out.write("<input type=\"submit\" value=\"join!!!\">");
		  out.write("</form>");
		  out.write("</body>");
		  out.write("</html>");
	}
}
