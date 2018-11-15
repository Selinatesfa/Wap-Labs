<%--
  Created by IntelliJ IDEA.
  User: selina 
  Date: 11/14/2018
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Welcome : ${sessionScope.username.name}<br>
<a href="/logout" > Logout</a>
</body>
</html>
