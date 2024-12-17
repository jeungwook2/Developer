<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEMI</title>

<link rel="stylesheet" href="/css/common/body.css">
<link rel="stylesheet" href="/css/board/list.css">
<script defer src="/js/board/list.js"></script>

</head>
<body>
    <%@ include file="/WEB-INF/views/common/asideLeft.jsp" %>

    <main>
        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <%@ include file="/WEB-INF/views/common/nav.jsp" %>
        <h1>게시글 목록조회</h1>


        <div class="search-area">
            <form action="/board/list?pno=1" onsubmit="return submitSearchForm();">
                <select name="searchType" onchange="handleSearchType(this);">
                    <option value="title">제목</option>
                    <option value="category">카테고리</option>
                </select>
                <input type="text" name="searchValue" placeholder="검색할 제목">
                <select name="searchValue" disabled>
                    <c:forEach items="${cateVolist}" var="cateVo">
                        <option value="${cateVo.no}">${cateVo.name}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="검색">
            </form>
        </div>




        <div class="tb-area">

        <table border="1">
            <thead>
                <tr>
                    <th>제목</th>
                    <th>카테고리</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일시</th>
                </tr>
            </thead>
            <tbody>
                <td>로딩중.....</td>
            </tbody>
        </table> 
             
        </div>                
        <div class="main-bottom-area">
            <button onclick="location.href='/board/write'">게시글 작성</button>
        </div>
        <div class="page-area"></div>       
    </main>

    <%@ include file="/WEB-INF/views/common/asideRight.jsp" %>

</body>
</html>