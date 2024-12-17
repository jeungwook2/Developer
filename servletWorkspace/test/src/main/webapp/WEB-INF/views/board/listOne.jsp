<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상세조회 페이지</h1>
	
	<a href="/board/list">목록으로</a>
	<table border="1">
		<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일자</th>
			<th>수정일자</th>
			<th>삭제여부</th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td>${vo.no}</td>
			<td>${vo.title}</td>
			<td>${vo.content}</td>
			<td>${vo.writerNick}</td>
			<td>${vo.hit}</td>
			<td>${vo.enrollDate}</td>
			<td>${vo.modifyDate}</td>
			<td>${vo.delYn}</td>
		</tr>
		
		</tbody>
	</table>
</body>
</html>