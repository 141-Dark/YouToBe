<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2019/12/26
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Title</title>
    <style type="text/css">
        .li5 {
            color:aliceblue;
            margin-left:80px;
            font-size:20px;
            list-style-type:none;
            display:inline;
        }
        .ul2 {
            margin-top:40px;
            margin-left:22%;
            float:left;
            display:block;
            padding:8px;
        }
        .d1{
            margin-left: 40%;
            margin-top: 20px;
        }
        .d2{
            margin-top: 40px;
            height: 600px;
        }
        .i1{
            height: 600px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 d1"><h1>网上考试系统</h1></div>
        <div class="col-md-12">
            <ul class="ul2">
                <li class="li5"><a href="CustomerManage/add_customers.jsp" target="1"><span class="glyphicon glyphicon-home"></span>添加学生</a></li>
                <li class="li5"><a href="<c:url value="/CustomerServlet?method=findAll"/>" target="1"><span class="glyphicon glyphicon-shopping-cart"></span>查询客户</a></li>
                <li class="li5"><a href="CustomerManage/query.jsp" target="1"><span class="glyphicon glyphicon-flag"></span>高级搜索</a></li>
                </br>
                <li class="li5"><a href="FileOperation/upload.jsp" target="1"><span class="glyphicon glyphicon-flag"></span>作业文件</a></li>
                <li class="li5"><a href="TestOnline1/add_course.jsp" target="1"><span class="glyphicon glyphicon-flag"></span>添加课程</a></li>
                <li class="li5"><a href="CustomerManage/notice.jsp" target="1"><span class="glyphicon glyphicon-flag"></span>发布公告</a></li>
            </ul>

        </div>

        <div class="col-md-12 d2">
            <iframe class="col-md-12 i1" name="1"></iframe>
        </div>
    </div>
</div>

</body>
</html>