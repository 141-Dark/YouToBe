<%--
  Created by IntelliJ IDEA.
  User: DYK
  Date: 2020/3/11
  Time: 17:35
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
<head>
    <title>Title</title>
</head>

<body>
<table border="1" align="center" class="table table-striped">
    <tr>
        <th style="width: 20%">考试科目</th>
        <th style="width: 30%">题型</th>
        <th style="width: 50%">选择操作</th>
    </tr>

    <c:forEach items="${pb.beanList}" var="v">

        <tr>
            <td>${v.cname}</td>

            <td>${v.qt_type}</td>


           <c:choose>
               <c:when test="${v.qt_type eq '填空题'}">
                   <td>
                       <a href="<c:url value="/CourseServlet?method=blankstest&cname=${v.cname}"/>">参与考试</a>
                       <a href="<c:url value="/CustomerServlet?method=delete&cid=${cstm.cid}"/>">  弃考</a>
                   </td>
               </c:when>
               <c:otherwise>
                   <td>
                       <a href="<c:url value="/CourseServlet?method=selectstest&cname=${v.cname}"/>">参与考试</a>
                       <a href="<c:url value="/CustomerServlet?method=delete&cid=${cstm.cid}"/>">  弃考</a>
                   </td>
               </c:otherwise>
           </c:choose>


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

</body>
</html>
