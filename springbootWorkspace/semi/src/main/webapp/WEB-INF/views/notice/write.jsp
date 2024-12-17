<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEMI</title>

<link rel="stylesheet" href="/css/common/body.css">


</head>
<body>
    <%@ include file="/WEB-INF/views/common/asideLeft.jsp" %>

    <main>
        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/nav.jsp" %>
        <h1>공지사항 작성하기</h1>
        <form action="/notice/write" method="post">
            <input type="text" name="title" placeholder="제목">
            <br>
            <textarea name="content" placeholder="내용"></textarea>
            <br>
            <input type="submit" value="작성하기">
        </form>

    </main> 

    <%@ include file="/WEB-INF/views/common/asideRight.jsp" %>
   
</body>
</html>