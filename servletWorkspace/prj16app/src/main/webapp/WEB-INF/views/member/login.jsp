<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/WEB-INF/views/common/header.jsp" %>
	
	<form action="" method="post">
	<input type ="text" name ="userId" placeholder="아이디.."><br>
	<input type ="password" name ="userPwd" placeholder="비밀번호.."><br>
	<input type = "submit" value= "로그인">
	</form>
	
</body>
</html>