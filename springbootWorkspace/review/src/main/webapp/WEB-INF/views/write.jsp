<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>



</head>
<body>
	<h1>등록하기 ~ !</h1>
	 <form action="/book/write" method ="post">
     제목<input type="text" name ="title">
     <br>
     작가<input type="text" name ="writer">
     <br>
     가격<input type="text" name ="price">
     <br>
     출판일<input type="text" name ="publishedDate">
     <br>

     <input type="submit" value ="등록하기">
     </form>
</body>
</html>