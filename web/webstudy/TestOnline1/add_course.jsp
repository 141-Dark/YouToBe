<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/10
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>

<style type="text/css">
    .main{
        width: 900px;
    }
</style>

<body class="main">
<form method="post" action="${pageContext.request.contextPath}/CourseServlet" method="post">
    <input type="hidden" name="method" value="addcourse">
    <input type="hidden" name ="cid" value="${qt_type}"/>
    <h3 align="center">添加课程</h3>
    <table class="table table-hover" border="0" align="center" width="40%" style="margin-left: 20%">
        <tr>
            <td>课程名称</td>
            <td><input type="text"  ID="TextBox1" class="form-control control-label ID" Width="100px"  placeholder="课程名称" name="cname" title="课程名"></td>
            <td>设置题型</td>
            <td>
                <select name="qt_type" id="catid" class="required">
                    <option value="0">请选择出题类型</option>
                    <option value="单选题">选择题</option>
                    <option value="填空题">填空题</option>
                </select>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <input type="submit" class="btn  btn-primary" value="添加">
                <input type="reset" class="btn  btn-primary" value="重置">
            </td>
        </tr>
    </table>

</form>

</body>
</html>
