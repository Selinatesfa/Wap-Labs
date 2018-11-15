<%--
  Created by IntelliJ IDEA.
  User: selina 
  Date: 11/14/2018
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login form</title>
</head>
<body>
<form action="/display" method="post">

User Name: <input type="text" name="un" value="${cookie.username.value}"/><br>
Password: <input type="text" name="pw"  value="${cookie.password.value}" /><br>
    <label> Remember me<input type="checkbox" name="rm"></label><br>
<input type="submit" value="Login" name="btn"/>
</form>
</body>
</html>
