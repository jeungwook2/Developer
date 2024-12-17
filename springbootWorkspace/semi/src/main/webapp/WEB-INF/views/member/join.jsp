<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEMI</title>

<link rel="stylesheet" href="/css/common/body.css">
<script defer src="/js/member/join.js"></script>
</head>
<body>
    <%@ include file="/WEB-INF/views/common/asideLeft.jsp" %>

    <main>
        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/nav.jsp" %>
        <h1>회원가입</h1>
        <form action="/member/join" method="post" enctype="multipart/form-data">
            <input type="text" name="id" placeholder="아이디" oninput="disableSubmitBtn();">
            <input type="button" value="중복검사" class="kh-btn-blue" onclick="checkDupId();">
            <br>
            <input type="password" name="pwd" placeholder="비밀번호">
            <br>
            <input type="text" name="nick" placeholder="닉네임">
            <br>
            <label>프로필 사진 :</label>
            <input type="file" name="f" accept=".png,.jpg,.jpeg,.svg">
            <br>
            <input type="submit" value="회원가입" disabled="ture">
        </form>
    </main> 

    <%@ include file="/WEB-INF/views/common/asideRight.jsp" %>
   
</body>
</html>