<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/11
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="webstudy/TestOnline2/css/teacher_common.css" />
    <link rel="stylesheet" type="text/css" href="webstudy/TestOnline2/css/teacher_main.css" />
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/CourseServlet" method="post" id="myform" name="myform">
    <input type="hidden" name="method" value="add_blanks"/>
    <table class="insert-tab" width="100%">
        <tbody>
        <tr>
            <th><i class="require-red">*</i>题目：</th>
            <td id="titleTd">
                <input class="form-control control-label ID"  name="title" size="50" value="" type="text">
            </td>
        </tr>
        <tr id="answerTr">
            <th>答案：</th>
            <td><textarea name="answer" class="form-control control-label ID" id="answerTxt" cols="5" rows="1" style="width: 60px"></textarea></td>
        </tr>
        <tr>
            <th>答案解析：</th>
            <td><textarea name="parsing" class="form-control control-label" id="explainationTxt" cols="30" style="width: 98%;" rows="10"></textarea></td>
        </tr>
        <tr>
            <th><i class="require-red">*</i>分值：</th>
            <td>
                <input class="common-text required" id="title" name="score" size="50" value="" type="text">
            </td>
        </tr>
        <tr>
            <td>
                <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                <input class="btn btn6" value="重置" type="reset" id="reset">
                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
