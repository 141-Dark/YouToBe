<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/11
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style type="text/css">
    .iframe1 {
        height:680px;
        background-color:cornflowerblue;
        width:98%;
    }
    .d2{
        margin-top: 100px;
        height: 600px;
    }
    .i1{
        height: 500px;
    }
</style>
<body>
<h1 align="center">在线考试系统</h1>
<form id="form1" runat="server">
    <h3 align="center">${customer_name},欢迎你</h3>
    <ul id="myTab" class="nav nav-tabs">
        <li class="active">
            <a href="#" data-toggle="tab">
                <span class="glyphicon glyphicon-home"></span>主页
            </a>
        </li>

        <li><a href="#View_Boook" data-toggle="tab" target="1"><span class="glyphicon glyphicon-tags"></span>在线考试</a></li>

        <li class="dropdown">
            <a href="#" id="myTabDrop1" class="dropdown-toggle"  data-toggle="dropdown"><span class="glyphicon glyphicon-fire"></span>其他操作<b class="caret"></b></a>
            <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
                <li><a href="<c:url value="/CustomerServlet?method=view_notice"/>"  target="1"><span class="glyphicon glyphicon-eye-open"></span>查看公告</a></li>
                <li><a href="#jmeter" tabindex="-1" data-toggle="tab" target="1"><span class="glyphicon glyphicon-heart-empty"></span>查看成绩</a></li>
                <li><a href="#ejb" tabindex="-1" data-toggle="tab" target="1"><span class="glyphicon glyphicon-thumbs-up"></span>教师寄语</a></li>
            </ul>
        </li>
    </ul>

    <div id="myTabContent" class="tab-content back_size">

        <div class="tab-pane fade" id="View_Boook">
            <a href="<c:url value="/CourseServlet?method=choosesubject"/>" target="1"><span class="glyphicon glyphicon-shopping-cart"></span>点击选择考试科目</a>
        </div>

        <div class="tab-pane fade size" id="cart">
            <p>显示购物车内的所有东西，并加入订单</p>
        </div>


        <div class="tab-pane fade" id="jmeter">
            <a href="<c:url value="/CourseServlet?method=show_score"/>" target="1"><span class="glyphicon glyphicon-shopping-cart"></span>点击查看考试成绩</a>
        </div>
        <div class="tab-pane fade size" id="ejb">
            <p>愿你学有所成，加油！</p>
        </div>
    </div>

    <div class="col-md-12 d2">
        <iframe class="col-md-12 i1" name="1"></iframe>
    </div>
</form>
</body>
</html>
