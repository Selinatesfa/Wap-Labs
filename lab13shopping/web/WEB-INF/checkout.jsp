<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: selina 
  Date: 11/14/2018
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>checkout info</title>
</head>
<body>
<h1>products available in cart with price</h1>
<c:forEach items="${products}" var="pro" >
    Name: ${pro.name} , Price: ${pro.price} <br>
</c:forEach>
<br>
<fieldset>
    <legend>shipping address</legend>
    Street:<input name="s"/>
    city <input name=""/>
    state<input name="" />
    zipcode<input name=""/>
</fieldset>
<fieldset>
    <legend>billing address</legend>
    Street:<input name="s"/>
    city <input name=""/>
    state<input name="" />
    zipcode<input name=""/>
</fieldset>
<fieldset>
    <legend>payment info</legend>
    credit/debit card:<input name="s"/>
    expiration date <input name=""/>
    cvc code<input name="" />
    card number<input name=""/>
</fieldset>
<br>
<a href="/Logout" >Purchase</a>
</body>
</html>
