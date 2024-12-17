<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>홈페이지</title>
</head>
<body>
    <h1>작성하기 페이지!</h1>
    <p>This is a basic HTML document.</p>

        <form action="/board/insert" method="post">
            <input type="text" name="title" placeholder="제목">
            <br>
            <textarea name="content" placeholder="내용"></textarea>
            <br>
            <input type="submit" value="작성하기">
        </form>
</body>
</html>