<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	List<BoardVo> voList = (List<BoardVo>)request.getAttribute("voList");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>게시글 목록</h1>
	
	<%
	for(BoardVo vo : voList){
		out.write("<h3>" + vo + "</h3>");
	}	
	%>
	
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>내용</td>
			</tr>
		</thead>
		<tbody>
			<% for(BoardVo vo : voList){ %>
			<% pageContext.setAttribute("x", vo);  %>
			<tr>
				<td> ${x.no} </td>
				<td> ${x.title} </td>
				<td> ${x.content} </td>
			</tr>			
			<%}%>
		</tbody>
	</table>
	
	
</body>
</html>