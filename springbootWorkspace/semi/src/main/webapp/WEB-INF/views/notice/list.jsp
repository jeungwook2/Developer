<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>SEMI</title>

            <link rel="stylesheet" href="/css/common/body.css">
            <link rel="stylesheet" href="/css/notice/list.css">
            <script defer src="/js/notice/list.js"></script>

        </head>

        <body>
            <%@ include file="/WEB-INF/views/common/asideLeft.jsp" %>

                <main>
                    <%@ include file="/WEB-INF/views/common/header.jsp" %>
                        <%@ include file="/WEB-INF/views/common/nav.jsp" %>
                            <h1>공지사항 조회</h1>
                            <c:if test="${loginAdminVo != null}">
                                <button onclick="location.href='/notice/write'">작성하기</button>
                                <button onclick="deleteNotice();">삭제하기</button>
                            </c:if>
                            <div class="search-area">
                                <form action="/notice/list" method="get">
                                    <input type="text" placeholder="제목검색" name="searchValue" value="${searchValue}">
                                    <input type="submit" value="검색">
                                </form>
                            </div>
                            <div class="table-area">
                                <table border="1">
                                    <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>조회수</th>
                                            <th>작성일시</th>
                                            <c:if test="${loginAdminVo !=null}">
                                                <th><input type="checkbox" onclick="handleCheckBox(this);"></th>
                                            </c:if>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${voList}" var="vo">
                                            <tr>
                                                <td>${vo.no}</td>
                                                <td>${vo.title}</td>
                                                <td>${vo.writerNick}</td>
                                                <td>${vo.hit}</td>
                                                <td>${vo.createDate}</td>
                                                <c:if test="${loginAdminVo !=null}">
                                                    <td class="checkbox-td"><input type="checkbox" name="delete" value="${vo.no}"></td>
                                                </c:if>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="page-area">
                                <c:if test="${pvo.startPage != 1}">
                                    <a href="/notice/list?pno=${pvo.startPage-1}&searchValue=${searchValue}">이전</a>
                                </c:if>
                                <c:forEach begin="${pvo.startPage}" end="${pvo.endPage}" var="i" step="1">
                                    <a href="/notice/list?pno=${i}&searchValue=${searchValue}">${i}</a>
                                </c:forEach>
                                <c:if test="${pvo.endPage != pvo.maxPage}">
                                    <a href="/notice/list?pno=${pvo.endPage+1}&searchValue=${searchValue}">다음</a>
                                </c:if>
                            </div>
                </main>

                <%@ include file="/WEB-INF/views/common/asideRight.jsp" %>

        </body>

        </html>