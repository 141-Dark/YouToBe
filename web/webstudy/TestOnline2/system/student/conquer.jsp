<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

	<title>试卷列表</title>

	<jsp:include page="css_js_head_exam.jsp"/>
</head>
<body>
	<jsp:include page="navbar_exam.jsp"/>


	<style>
		.gou{display: none;}
	</style>
	
	
	<div id = "timeuse" style="display:none;"><span id="timeH">${timeH}</span> <span id="timeM">${timeM}</span><span id="timeS">${timeS}</span></div>
	<div class="container" style="margin-top: 10px;">
		<div class="row">
			
			<div class="col-xl-12" >
				<a href='<c:url value="/"/> '> 主页 </a> > <a href="list">试卷列表</a> > 正在答卷
			</div>
	
		</div>
	</div>
	
	
	
	<div class="container" style="margin-top:20px;">

		<div class="hidden" hidden id="paperId" value="${paper.paperId}">ID：${paper.paperId}</div>
			
		<div class="text-center"><h3>${paper.title}</h3></div>
		
		<div style="margin-top:5px; padding:5px;">
			<button class="btn btn-warning" id="checkbutton" onclick="sub(${paper.paperId})" >提交答卷</button>
			
			<span class="font-weight-bold">你的得分：<span class="score" > ？ </span></span>

		</div>
		
		<div style="margin-top:5px; padding:5px;">
			
			<h4>
			<span style="cursor:default;" id="clock_start" class="badge badge-primary"></span>
			
			<span style="cursor:default;" id="clock_now" class="badge badge-info"></span>
			
			<span style="cursor:default;" class="badge badge-danger">
				已用时
				<span id="clock_use">
					<span id="hour">0</span>:<span id="minute">0</span>:<span id="seconds">0</span>
					<span hidden>:</span><span hidden id="miniseconds">0</span>
				</span>
			</span>
			
			</h4>
		</div>


		<c:if test="${!empty questions }">
			<%
				int i=0;
			%>
			
			<form action="submit" id="form" method="post">
			<c:forEach var="one" items="${questions}">
				<div class="one_question" id="${one.questionId}" style="padding:10px;border-bottom: 1px solid #eee;">
					<input type="hidden" name="question[${one.questionId}]" value="${one.questionId}">
				
					<div>
						<p>
							<span class="result-close pull-right" style="display:none;color:red;">
								<i class="fa fa-close fa-4" aria-hidden="true"></i>
							</span>
							<span class="result-check pull-right" style="display:none;color:green;">
								<i class="fa fa-check fa-4" aria-hidden="true"></i>
							</span>
							
						
							<%=++i%>、${one.title}
						</p>
					</div>
					
					<div style="margin-top: 10px;">
						<div class="option">
							<input type="checkbox" class=""  on="op" name="option[${one.questionId}]" value="1"> A、 ${one.optionA} 
							<%-- <c:if test="${one.answer eq '1'}">
								<span class="gou badge badge-success">正确答案</span>
							</c:if> --%>
						</div>
						<div class="option">
							<input type="checkbox" class=""  on="op" name="option[${one.questionId}]" value="2"> B、 ${one.optionB}
							<%-- <c:if test="${one.answer eq '2'}">
								<span class="gou badge badge-success">正确答案</span>
							</c:if> --%>
						</div>
						<div class="option">
							<input type="checkbox" class=""  on="op" name="option[${one.questionId}]" value="3"> C、 ${one.optionC}
							<%-- <c:if test="${one.answer eq '3'}">
								<span class="gou badge badge-success">正确答案</span>
							</c:if> --%>
						</div>
						<div class="option">
							<input type="checkbox" class=""  on="op" name="option[${one.questionId}]" value="4"> D、 ${one.optionD}
							<%-- <c:if test="${one.answer eq '4'}">
								<span class="gou badge badge-success">正确答案</span>
							</c:if> --%>
						</div>
						
					</div>
					
					<div class="answer" value="${one.answer}" hidden class="hidden">答案 ${one.answer}</div>
					
				</div>
			</c:forEach>
			
			</form>
			
		</c:if>
		<a class="btn btn-warning" href="">退出</a>
	</div>

	
	<%-- <script src='<c:url value="../../js/conquer.js"/>' ></script>
	<script src='<c:url value="../../js/daojishi.js"/>' ></script> --%>
	<script type="text/javascript" src="<%=basePath%>webstudy/TestOnline2/js/conquer.js"></script>
	<script type="text/javascript" src="<%=basePath%>webstudy/TestOnline2/js/daojishi.js"></script>
	

	
</body>
</html>
