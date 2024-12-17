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

	<h1>HOME ~ !</h1>
	<c:if test="${not empty sessionScope.loginVo}">
        <!-- 로그인한 사용자만 보이는 콘텐츠 -->
         <img src ="http://127.0.0.1:8888/${loginVo.profile}">
         <form action ="" method ="get">
         <input type ="submit" value = "로그아웃">
         </form>
    </c:if>

    <c:if test="${empty sessionScope.loginVo}">
        <!-- 로그인하지 않은 사용자만 보이는 콘텐츠 -->
        <p>Please log in to continue.</p>
    </c:if>
</body>
</html>