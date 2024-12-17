<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEMI</title>

<link rel = "stylesheet" href = "/css/common/body.css">


</head>
<body>
    <%@ include file="/WEB-INF/views/common/asideLeft.jsp" %>

    <main>
        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/nav.jsp" %>
        <h1>공지사항 수정하기</h1>
        <form action="/notice/edit" method="post">
            <input type="hidden" name="no" value="${vo.no}">
            <input type="hidden" name="writerNo" value="${vo.writerNo}">
            <label>제목 : </label>
            <input type="text" name="title" value="${vo.title}">
            <br>
            <label>내용</label>
            <br>
            <textarea name="content">${vo.content}</textarea>
            <br>
            <input type="submit" value="수정하기">
        </form>
        
    </main>

   

    <%@ include file="/WEB-INF/views/common/asideRight.jsp" %>
</body>
</html>