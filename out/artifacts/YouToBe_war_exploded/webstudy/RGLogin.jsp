<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/3
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/RGLogin">
    <input type="text" name="username"></br>
    <input type="password" name="password"></br>
    <input type="submit" value="登录">
</form>
</body>
</html>
