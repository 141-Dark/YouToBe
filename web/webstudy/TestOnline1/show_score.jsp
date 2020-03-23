<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/12
  Time: 15:46
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
    <style type="text/css">
        .b{
            margin-left: 35%;
        }
    </style>
</head>
<body class="b">
<div style="width: 500px;height: 400px" align="center">
    <table border="1" align="center" class="table table-striped">

        <tr>
            <th>考试序列</th>
            <th>考试科目</th>
            <th>最终成绩</th>
        </tr>

        <c:forEach items="${pb.beanList}" var="cstm" varStatus="v">
            <tr>
                <td>${v.index+1}</td>
                <td>${cstm.cname}</td>
                <td>${cstm.bs}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <%--
    给出分页相关的连接
    --%>

    <div align="center">
        第${pb.pc}页/共${pb.tp}页
        <%--

        --%>
        <a href="${pb.url}&pc=1">首页</a>
        <c:if test="${pb.pc>1}">
            <a href="${pb.url}&pc=${pb.pc-1}">上一页</a>
        </c:if>

        <c:choose>
            <%--如果获取的页数小于7，则将所有页数显示出来--%>
            <c:when test="${pb.tp<=10}">
                <c:set var="begin" value="1"/>
                <c:set var="end" value="${pb.tp}"/>
            </c:when>
            <c:otherwise>
                <%--如果获取的页数d大于7，公式计算--%>
                <c:set var="begin" value="${pb.pc-5}"/>
                <c:set var="end" value="${pb.pc+4}"/>

                <%--处理头溢出--%>
                <c:if test="${begin < 1}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="10"/>
                </c:if>

                <%--处理尾溢出--%>
                <c:if test="${end > pb.tp}">
                    <c:set var="begin" value="${pb.tp-9}"/>
                    <c:set var="end" value="${pb.tp}"/>
                </c:if>
            </c:otherwise>

        </c:choose>
        <%--循环显示页码列表--%>
        <c:forEach var="i" begin="${begin}" end="${end}">
            <a href="${pb.url}&pc=${i}" class="btn btn-primary">${i}</a>
        </c:forEach>
        <c:if test="${pb.pc<pb.tp}">
            <a href="${pb.url}&pc=${pb.pc+1}">下一页</a>
        </c:if>
        <a href="${pb.url}&pc=${pb.tp}">尾页</a>
    </div>

</div>
</body>
</html>
