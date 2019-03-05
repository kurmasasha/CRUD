<%--
  Created by IntelliJ IDEA.
  User: SanKur
  Date: 02.03.2019
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>UserEdit</title>
</head>
<body>
<form method="post" action="/edit" accept-charset="UTF-8">
    <table>
        <tr>
            <td>Текущее имя </td>
        </tr>
        <tr>
            <td><label for="FirstName">Имя</label></td>
            <td><input id="FirstName" type="text" name="FirstName"></td>
        </tr>
        <tr>
            <td><label for="LastName">Фамилия</label></td>
            <td><input id="LastName" type="text" name="LastName"></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="Редактировать"></td>
        </tr>
    </table>
</form>

</body>
</html>
