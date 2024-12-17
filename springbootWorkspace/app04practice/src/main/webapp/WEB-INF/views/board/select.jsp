<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>홈페이지</title>
</head>
<body>
    <h1>Hello, World!</h1>
    <p>This is a basic HTML document.</p>
    <c:forEach var="board" items="${list}">
                <tr>
                    <td>${board.no}
                    <td>${board.title}</td>
                    <td>${board.content}</td>
                    <td>${board.writerNo}</td>
                </tr>
            </c:forEach>
</body>
</html>