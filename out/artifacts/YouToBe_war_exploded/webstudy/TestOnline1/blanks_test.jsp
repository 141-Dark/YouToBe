<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/11
  Time: 19:17
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
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/CourseServlet">
    <input type="hidden" name="method" value="add_blanks_answer">

    <h2 align="center">${cname}考试</h2>
    <h5 align="center">考试时间为1小时，请掌握好时间</h5>
    <table border="1" align="center" class="table table-striped">
        <tr>
            <th style="width: 20%">题号</th>
            <th style="width: 30%">题目</th>
            <th style="width: 30%">你的答案</th>
            <th style="width: 20%">各题分值</th>
        </tr>

            <c:forEach items="${pb.beanList}" var="v" varStatus="status">
                <input type="hidden" name="cname" value="${cname}">
                <input type="hidden" name="customer_id" value="${customer_id}">
                <tr>
                    <td>${status.index+1}
                        <input type="hidden" name="number" value="${status.index+1}">
                    </td>

                    <td>${v.title}
                        <input type="hidden" name="title" value="${v.title}">
                    </td>

                    <td><input type="text"  ID="TextBox1" class="form-control control-label ID" style="width: 140px"  placeholder="请给出你的答案" name="yanswer" title="答案">
                    </td>

                    <td>${v.score}
                    </td>
                </tr>
            </c:forEach>
    </table>
    <table align="center">
        <tr>
            <td>
                <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                <input class="btn btn6" value="重置" type="reset" id="reset">
                <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
            </td>
        </tr>
    </table>
    <time class="countdown-alt-1" datetime="PT01H28M00S"><span class="item item-hh"><span class="hh-1">0</span><span class="hh-2">1</span><span class="label label-hh"></span></span><span class="separator">:</span><span class="item item-mm"><span class="mm-1">2</span><span class="mm-2">8</span><span class="label label-mm"></span></span><span class="separator">:</span><span class="item item-ss"><span class="ss-1">0</span><span class="ss-2">0</span><span class="label label-ss"></span></span></time>
</form>
</body>
</html>
