
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEMI</title>

<link rel="stylesheet" href="/css/common/body.css">
<link rel="stylesheet" href="/css/board/detail.css">

</head>
<body>
    <%@ include file="/WEB-INF/views/common/asideLeft.jsp" %>

    <main>
        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/nav.jsp" %>
        <h1>게시글 상세조회</h1>
      
        <!-- <label for="">게시글 번호  </label><input type="text" value="${vo.no}" disabled="false">
        <br>
        <label for="">게시글 제목  </label><input type="text" value="${vo.title}" disabled="false">
        <br>
        <label for="">게시글 내용  </label><input type="text" value="${vo.content}" disabled="false">
        <br>
        <label for="">게시글 카테고리  </label><input type="text" value="${vo.categoryName}" disabled="false">
        <br>
        <label for="">게시글 작성자  </label><input type="text" value="${vo.writerNick}" disabled="false">
        <br>
        <label for="">게시글 조회수  </label><input type="text" value="${vo.hit}" disabled="false">
        <br>
        <label for="">게시글 작성일자  </label><input type="text" value="${vo.createDate}" disabled="false">
        <br> -->

        <div id="board-area">
            <div id="title-area">${vo.title}</div>
            <div>${vo.writerNick}</div>
            <div>${vo.createDate}</div>
            <div>${vo.categoryName}</div>
            <div>${vo.hit}</div>
            <div id="content-area">${vo.content}</div>
            <div class="board-img-area">
                <c:forEach items="${attachmentVoList}" var="attachVo">
                    <img src="/img/board/attachment/${attachVo.changeName}" alt="${attachVo.originName}" width="100px" height="100px">
                </c:forEach >
            </div>
        </div>
        
        <c:if test="${loginMemberVo.no == vo.writerNo}">
            <div class="main-footer">
                <button onclick="location.href='/board/edit?bno=${vo.no}'">수정</button>
                <button onclick="location.href='/board/delete?bno=${vo.no}'">삭제</button>
            </div>
        </c:if>
        
        
        
    </main> 

    <%@ include file="/WEB-INF/views/common/asideRight.jsp" %>
   
</body>
</html>