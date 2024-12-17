<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String x = (String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>에러페이지</h1>
	
	<h2> <% out.write(x); %> </h2>
	<hr>
	<h3> <%= x %> </h3>
	<hr>
	<!-- ${x}는 안됨 ${requestScope.msg}는 가능 -->
	<h4> ${msg} </h4>
	<h4> ${sessionScope.msg} </h4>
	<h4> ${requestScope.msg} </h4>

</body>
</html>