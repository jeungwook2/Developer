<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>SEMI</title>

            <link rel="stylesheet" href="/css/common/body.css">
            <script src="/js/member/mypage.js" defer></script>
        </head>

        <body>
            <%@ include file="/WEB-INF/views/common/asideLeft.jsp" %>

                <main>
                    <%@ include file="/WEB-INF/views/common/header.jsp" %>
                        <%@ include file="/WEB-INF/views/common/nav.jsp" %>
                            <h1>마이페이지</h1>
                            <form action="/member/edit" id="edit-form" method="post">
                                <input disabled type="text" name="id" placeholder="아이디" value="${loginMemberVo.id}">
                                <br>
                                <input  type="password" name="pwd" placeholder="비밀번호">
                                <br>
                                <input disabled type="text" name="nick" placeholder="닉네임" value="${loginMemberVo.nick}">
                                <br>
                                <input type="button" value="수정하기" >
                                <input type="button" value="탈퇴하기" onclick="location.href='/member/quit'">
                            </form>
                </main>

                <%@ include file="/WEB-INF/views/common/asideRight.jsp" %>

        </body>

        </html>