<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>헬로월드</title>


</head>
<body>
    <table border=1>
    <thead>
        <tr>
            <th>순번</th>
            <th>제목</th>
            <th>작가</th>
            <th>가격</th>
            <th>등록일자</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${voList}" var="vo">
    	 <tr>
    	 <td>${vo.no}</td>
    	 <td>${vo.title}</td>
    	 <td>${vo.writer}</td>
    	 <td>${vo.price}</td>
    	 <td>${vo.publishedDate}</td>
         </tr>
        </c:forEach>
    </tbody>


    </table>


</body>
</html>