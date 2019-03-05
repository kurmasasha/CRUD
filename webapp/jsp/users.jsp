<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
    <table>
        <tr>
            <td>ID</td>
            <td>Имя</td>
            <td>Фамилия</td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>
                    <a href="/edit?id=${user.id}">Редактировать</a>
                </td>
                <td>
                    <a href="/delete?id=${user.id}">Удалить</a>
                </td>
            </tr>
        </c:forEach>
    </table>
<div>
    <form method="get">
        <a href="/useradd">Добавить</a>
    </form>
</div>
</body>
</html>
