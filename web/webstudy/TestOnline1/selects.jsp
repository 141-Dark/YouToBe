<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/11
  Time: 10:56
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
        .d{
            width: 400px;
            margin-left:35%;
        }
    </style>
</head>
<body>

<div class="d" align="center">
    <h3 align="center">设置考题</h3>
    <form action="${pageContext.request.contextPath}/CourseServlet">
        <input type="hidden" name="method" value="tes"/>
        <table class="table table-hover">
            <tr>
                <td><input id="input" class="form-control control-label ID" name="tes"  type="text"placeholder="输入题数" /></td>
                <td><input class="btn  btn-primary" type="submit"></td>
            </tr>
        </table>
    </form>

    <form action="${pageContext.request.contextPath}/CourseServlet" method="post" id="myform" name="myform">
        <input type="hidden" name="method" value="add_selects"/>
        <c:set var="begin" value="1"/>
        <c:set var="end" value="${tes}"/>

        <c:forEach var="i" begin="${begin}" end="${end}">
            <table  class="table table-hover">
                <tr>
                    <td>第${i}题</td>
                    <td><input class="form-control control-label ID" type="text" name="s_title"></td>
                </tr>
                <tr>
                    <td>A</td>
                    <td><input class="form-control control-label ID" type="text" name="a"></td>
                </tr>
                <tr>
                    <td>B</td>
                    <td><input class="form-control control-label ID" type="text" name="b"></td>
                </tr>
                <tr>
                    <td>C</td>
                    <td><input class="form-control control-label ID" type="text" name="c"></td>
                </tr>
                <tr>
                    <td>D</td>
                    <td><input class="form-control control-label ID" type="text" name="d"></td>
                </tr>
                <tr>
                    <td>答案</td>
                    <td><input class="form-control control-label ID" type="text" placeholder="正确答案" name="s_answer"></td>
                </tr>
                <tr>
                    <td>分值</td>
                    <td><input class="form-control control-label ID" type="text" placeholder="设置分值" name="s_score"></td>
                </tr>

            </table>
            </br>
        </c:forEach>
        <table>
            <tr>
                <td><input type="submit" class="btn  btn-primary" value="提交"></td>
                <td> <input type="reset" class="btn  btn-primary" value="重置"></td>
            </tr>
        </table>
    </form>

</div>

</body>
</html>
