<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>

</head>
<body>
	<h1>게시글 목록조회</h1>
	<hr>
	<c:forEach var="item" items="${list}">
        <h2>${item}</h2>
    </c:forEach>
</body>
</html>