<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<a href="/app13/home">홈으로</a>
	
	<hr>
	
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
			
			<c:forEach items="${voList}" var="vo">
				<tr>
					<td> ${vo.no} </td>
					<td> ${vo.title} </td>
					<td> ${vo.content} </td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>

</body>
</html>