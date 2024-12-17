<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>목록보기</h1>
	<hr>
	<form action="/board/list" method ="get">
	<input type="hidden" name="pno" value = "1" readonly="readonly">
	<select name="searchType">
		<option value="title">제목</option>
		<option value="content">내용</option>
	</select>
	<input type="search" name ="searchValue" placeholder ="검색할 내용 입력">
	<input type="submit" value ="검색">
	</form>
	
	<form action="/board/delete" method="get">
	<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>상세조회</th>
			<th>삭제하기</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list}" var="x">
		<tr>
			<td>${x.no}</td>
			<td>${x.title}</td>
			<td>${x.content}</td>
			<td>${x.writerNick}</td>
			<td>${x.enrollDate}</td>
			<td><a href="/board/listOne?no=${x.no}">상세조회</a></td>
			<td><input type ="checkbox" name ="del" value="${x.no}"></td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	<input type ="submit" value="삭제하기">
	</form>
	<div id = "page-area">
	<c:if test="${pvo.startPage != 1}">
	<a href="/board/list?pno=${pvo.startPage-1}">이전</a>
	</c:if>
	<c:forEach begin="${pvo.startPage}" end="${pvo.endPage}" step="1" var="i">
		<a href="/board/list?pno=${i}">${i}</a>	
	</c:forEach>
	<c:if test="${pvo.endPage < pvo.maxPage}">
	<a href="/board/list?pno=${pvo.endPage+1}">다음</a>
	</c:if>
			</div>
</body>
</html>