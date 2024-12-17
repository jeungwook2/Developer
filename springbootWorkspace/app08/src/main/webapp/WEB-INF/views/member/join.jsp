
    <%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>헬로월드</title>



    </head>
    <body>
    	<h1>회원가입 ~ !</h1>
    	    <form action="/member/join" method="post" enctype="multipart/form-data">
                <input type="text" name="id" placeholder="아이디">
                <br>
                <input type="password" name="pwd" placeholder="비밀번호">
                <br>
                <input type="text" name="nick" placeholder="닉네임">
                <br>
                <input type ="file" name ="f">
                <br>
                <input type="submit" value="회원가입">
            </form>
    </body>
    </html>