<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/6
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body>
<form method="post" action="<c:url value="/CustomerServlet"/>">
    <input type="hidden" name="method" value="Edit"/>
    <input type="hidden" name ="cid" value="${cstm.cid}"/>

    <h3 align="center">编辑学生</h3>
    <table class="table table-hover" border="0" align="center" width="40%" style="margin-left: 20%">
        <tr>
            <td>学生姓名</td>
            <td><input type="text" value="${cstm.cname}" ID="TextBox1" class="form-control control-label ID" Width="100px"  placeholder="输入姓名" name="cname" title="客户名"></td>
        </tr>

        <tr>
            <td>学生手机</td>
            <td><input type="tel" value="${cstm.cellphone}" ID="TextBox4" class="form-control control-label ID" Width="100px"  placeholder="输入手机" name="cellphone" title="手机号码"></td>
        </tr>

        <tr>
            <td>添加寄语</td>
            <td><textarea name="description"  cols="30" rows="3" class="form-control control-label" title="寄语">${cstm.description}</textarea></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" class="btn  btn-primary" value="提交修改">
                <input type="reset" class="btn  btn-primary" value="重置">
            </td>
        </tr>
    </table>

</form>
</body>
</html>
