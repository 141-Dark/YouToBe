<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/13
  Time: 0:28
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
    <style type="text/css">
        .c{
            width: 500px;
            margin-left: 35%;
        }

    </style>
</head>
<body class="b">
<form method="post" action="${pageContext.request.contextPath}/CourseServlet">
    <input type="hidden" name="method" value="add_selects_answer">

    <h2 align="center">${cname}考试</h2>
    <h5 align="center">考试时间为1小时，请掌握好时间</h5>

<c:forEach items="${pb.beanList}" var="v" varStatus="status">
    <div class="c">
        <input type="hidden" name="number" value="${status.index+1}">
        <input type="hidden" name="cname" value="${cname}">
        <input type="hidden" name="customer_id" value="${customer_id}">
        第${status.index+1}题(${v.s_score}分)、${v.s_title}
        <input type="hidden" name="title" value="${v.s_title}">
        <br>
            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="checkbox" name="yanswer" value="A">A、${v.a}

            &emsp;&emsp;<input type="checkbox" name="yanswer" value="B">B、${v.b}

            &emsp;&emsp;<input type="checkbox" name="yanswer" value="C">C、${v.c}

            &emsp;&emsp;<input type="checkbox" name="yanswer" value="D">D、${v.d}


        <hr>
    </div>

</c:forEach>
    <div class="c">
        <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
        <input class="btn btn6" value="重置" type="reset" id="reset">
        <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
    </div>

</form>
</body>
</html>
