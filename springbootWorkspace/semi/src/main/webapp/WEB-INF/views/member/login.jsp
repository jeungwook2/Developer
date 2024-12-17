<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEMI</title>

<link rel="stylesheet" href="/css/common/body.css">
<script defer src="/js/member/login.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/views/common/asideLeft.jsp" %>

    <main>
        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/nav.jsp" %>
        <h1>로그인</h1>
        <form action="/member/login" method="post">
            <input type="text" name="id"  placeholder="아이디">
            <br>
            <input type="password" name="pwd" placeholder="비밀번호">
            <br>
            <input type="submit" value="로그인">
        </form>
    </main> 

    <%@ include file="/WEB-INF/views/common/asideRight.jsp" %>
   
</body>
</html>