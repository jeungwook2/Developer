<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>지하철 요금 안내</h1>
	
	<a href="/app10/home">홈페이지로 이동</a>
	
	<%
		String price = (String)request.getAttribute("price");
		String age = (String)request.getAttribute("age");
		out.write("<h2>나이 : " + age + "</h2>");
		out.write("<h2>요금 : " + price + "</h2>");
	%>
	
</body>
</html>