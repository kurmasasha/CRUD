<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserAdd</title>
</head>
<body>
    <form method="post" action="/useradd" accept-charset="UTF-8">
        <table>
            <tr>
                <td><label for="FirstName">Имя</label></td>
                <td><input id="FirstName" type="text" name="FirstName"></td>
            </tr>
            <tr>
                <td><label for="LastName">Фамилия</label></td>
                <td><input id="LastName" type="text" name="LastName"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input type="submit" value="Добавить"></td>
            </tr>
        </table>
    </form>
</body>
</html>
