<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>UserEdit</title>
</head>
<body>
<form method="post" action="/admin/edit" accept-charset="UTF-8">
    <table>
        <tr>
            <td>Текущее имя </td>
        </tr>
        <tr>
            <td><label for="FirstName">Имя</label></td>
            <td><input id="FirstName" type="text" name="FirstName" value="${user.firstName}"></td>
        </tr>
        <tr>
            <td><label for="LastName">Фамилия</label></td>
            <td><input id="LastName" type="text" name="LastName" value="${user.lastName}"></td>
        </tr>
        <tr>
            <td><label for="Role">Роль</label></td>
            <td><select name="Role" id="Role">
                <option value="admin">admin</option>
                <option value="user">user</option>
            </select> </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center"><input type="submit" value="Редактировать"></td>
        </tr>
    </table>
</form>

</body>
</html>
