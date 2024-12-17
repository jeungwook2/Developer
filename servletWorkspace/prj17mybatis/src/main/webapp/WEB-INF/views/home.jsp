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
	<%@ include file ="/WEB-INF/views/common/header.jsp" %>
	<hr>
	
	<c:if test="${not empty loginVo}">
		<h2>${loginVo.nick}님 환영합니다</h2>
	</c:if>
	<c:if test="${empty loginVo}">	
		<h2>게스트님 환영합니다</h2>
	</c:if>
	 
</body>
</html>