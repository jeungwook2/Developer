<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>생성 갯수</h1>

	<form action="/app10/lotto" method="post">
		<input type="number" name="num" placeholder="생성할 번호 추천 수">
		<input type="submit" value="추천수">
	</form>

</body>
</html>