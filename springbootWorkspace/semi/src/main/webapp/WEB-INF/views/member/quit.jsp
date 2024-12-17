<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEMI</title>

<link rel="stylesheet" href="/css/common/body.css">
<link rel="stylesheet" href="/css/member/quit.css">
</head>
<body>
    <%@ include file="/WEB-INF/views/common/asideLeft.jsp" %>

    <main>
        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/nav.jsp" %>
        <h1>회원 탈퇴</h1>
        <form id="quit-form" action="/member/quit" method="post" onsubmit="return confirm('정말 탈퇴 하시겠습니까?')">
        <label>현재비밀번호</label>
        <input type="password" placeholder="현재비밀 번호를 입력하세요" name="pwd"><br>
        <input type="submit" value="탈퇴하기">
        </form>
    </main> 

    <%@ include file="/WEB-INF/views/common/asideRight.jsp" %>
   
</body>
</html>