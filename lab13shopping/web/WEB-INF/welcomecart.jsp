<%--
  Created by IntelliJ IDEA.
  User: selina 
  Date: 11/14/2018
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>welcome</title>
</head>
<body>
<h1>welcome: </h1>
<dir>
        <form action="/productadded" method="post">
<span>
    product name:<input name="pro" value="samsung galaxy" readonly/>
    price: <input name="pr" value="$678" readonly />
    <input type="submit" value="ADDTOCART"/>
</span>
    </form>

    <form action="/productadded" method="post">
<span>
    product name:<input name="pro" value="sony xperia" readonly/>
    price: <input name="pr" value="$998" readonly/>
    <input type="submit" value="ADDTOCART"/>
</span>
    </form>
    <form action="/productadded" method="post">
<span>
    product name:<input name="pro" value="iphone" readonly/>
    price: <input name="pr" value="$1978" readonly/>
    <input type="submit" value="ADDTOCART"/>
</span>
    </form><br>
    <form action="/Login" method="post">
    <input type="submit" value="CHECKOUT"/>
</form>
</dir>
</body>
</html>
