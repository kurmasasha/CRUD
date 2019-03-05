<%--
  Created by IntelliJ IDEA.
  User: sankur
  Date: 2019-03-03
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>UserDelete</title>
</head>
<body>
<form method="get" action="/delete" accept-charset="UTF-8">
<table>
    <tr>
        <td>Удалить ${user.id} ${user.firstName} ${user.lastName} ?</td>

        <td style="text-align: center">
            <a href="/users">Омена</a>
        </td>
        <td style="text-align: center">
            <a href="/delete?del=yiudfgdffg">Удалить</a>
        </td>
    </tr>
</table>
</form>
<form method="post" action="/delete">
    <input type="" name="del" value="yes">
</form>
</body>
</html>
