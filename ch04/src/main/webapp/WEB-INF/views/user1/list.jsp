<%--
  Created by IntelliJ IDEA.
  User: lotte6
  Date: 2025-03-11
  Time: 오전 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>user1::list</title>
</head>
<body>
<h3>user1 목록</h3>
<a href="/ch04">처음으로</a>
<a href="/ch04/user1/register">등록하기</a>
<table border="1">
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>휴대폰</th>
        <th>나이</th>
        <th>관리</th>
    </tr>
    <c:forEach var="user1" items="${user1List}">
        <tr>
            <td>${user1.uid}</td>
            <td>${user1.name}</td>
            <td>${user1.hp}</td>
            <td>${user1.age}</td>
            <td>
                <a href="/ch04/user1/modify?uid=${user1.uid}">수정</a>
                <a href="/ch04/user1/remove">삭제</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
