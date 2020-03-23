<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/11
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<style type="text/css">
    .main{
        width: 900px;
    }
</style>
<body class="main">
<form action="${pageContext.request.contextPath}/CustomerServlet" method="post">
    <!--向servlet传递一个名为method（根据BaseServlet）的参数，指明要调用的方法-->
    <input type="hidden" name="method" value="notice">
    <h3 align="center">发布公告</h3>
    <table class="table table-hover" border="0" align="center" width="40%" style="margin-left: 20%">
        <tr>
            <td>公告内容</td>
            <td><textarea name="description" cols="30" rows="3" class="form-control control-label" title="描述"></textarea></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" class="btn  btn-primary" value="发布">
                <input type="reset" class="btn  btn-primary" value="重置">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
