
<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/10
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <title>Title</title>
</head>

<style type="text/css">
    .main{
        width: 900px;
    }
</style>
<body class="main">
<form  enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/UploadServlet">
    <input type="hidden" name="method" value="doost">
    <h3 align="center">考试文件上传</h3>
    <table class="table table-hover" border="0" align="center" width="40%" style="margin-left: 20%">

        <tr>
            <td>选择文件</td>
            <td><input type="file" value="${cstm.cellphone}" ID="TextBox4" class="form-control control-label ID" Width="100px" name="cellphone" title="手机号码"></td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" class="btn  btn-primary" value="上传">
                <input type="reset" class="btn  btn-primary" value="重置">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
