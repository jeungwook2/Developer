<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	nav{
		display:grid;
		grid-template-rows:1fr;
		grid-template-columns:1fr 1fr 1fr 1fr; 
		width: 80vw;
		height:40px;
		margin : auto;
		border : 3px solid black;
		background-color: gray;
		color:white;
		font-size:2em;
		font-weight: 900;
	}
   
	nav > a {
		text-decoration-line: none;
	}
</style>
</head>
<body>

	<h1>KH 정보교육원</h1>
	
	<hr>
	
	<nav>
		<a href="/app/member/join">회원가입</a>
		<a href="/app/member/login">로그인</a>
		<a href="/app/board/write">게시글 작성</a>
		<a href="/app/board/list">게시글 목록</a>
	</nav>
	
	<hr>
	
    <form action="/app/board/write" method="post">
        <input type="text" name="title" placeholder="제목">
        <br>
        <textarea name="content" placeholder="내용"></textarea>
        <br>
        <input type="submit" value="작성하기">
    </form>

</body>
</html>