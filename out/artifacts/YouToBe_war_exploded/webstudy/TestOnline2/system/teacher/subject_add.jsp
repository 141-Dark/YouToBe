<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
	%>
<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>"></base>
		<meta charset="gbk">
		<title>SgExam在线考试系统|试题管理</title>
		<link rel="stylesheet" type="text/css" href="webstudy/TestOnline2/css/teacher_common.css" />
		<link rel="stylesheet" type="text/css" href="webstudy/TestOnline2/css/teacher_main.css" />
		<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<script type="text/javascript" src="<%=path%>webstudy/TestOnline2/js/jquery-3.1.1.js"></script>
	<script type="text/javascript">
	$(function(){
		var selectEle=$("#catid");
		selectEle.change(function(){
			if(selectEle.val()=="q1"||selectEle.val()=="q2"){
				$("tr[name='select']").remove();
				$("#selectBtn").remove();
				showQ1();
				$("#answerTxt").attr("cols","5").attr("rows","1").css("width","auto");
				var newTitle=$("<input class='common-text required' id='title' name='q_title' size='50'  type='text'>");
				$("#title").remove();
				$("#titleTd").append(newTitle);
			}else if(selectEle.val()=="q3"||selectEle.val()=="q4"){
				showQ1();
				$("tr[name='select']").remove();
				$("#selectBtn").remove();$("#selectBtn").remove();
				$("#answerTxt").attr("cols","5").attr("rows","1").css("width","98%");
				var newTitle=$("<input class='common-text required' id='title' name='q_title' size='50'  type='text'>");
				$("#title").remove();
				$("#titleTd").append(newTitle);
			}else if(selectEle.val()=="q5"){
				showQ1();
				$("tr[name='select']").remove();
				$("#selectBtn").remove();$("#selectBtn").remove();
				$("#answerTxt").attr("cols","5").attr("rows","5").css("width","98%");
				var newTitle=$("<textarea  name='q_title' id='title' cols='30' style='width: 98%;' rows='5' ></textarea>");
				$("#title").remove();
				$("#titleTd").append(newTitle);
			}
		});
		showQ1=function(){
		var selects=$("<tr name='select'>"
				+"<th>选项:</th>"
				+"<td>A:<input type='text' size='60' name='selects'/></td>"
				+"</tr>"
				+"<tr name='select'><td></td>"
				+"<td>B:<input type='text' size='60' name='selects'/></td>"
				+"</tr>"
				+"<tr name='select'><td></td>"
				+"<td>C:<input type='text' size='60' name='selects'/></td>"
				+"</tr>"
				+"<tr name='select'><td></td>"
				+"<td><span>D</span>:<input type='text' size='60' name='selects'/></td>"
				+"</tr>");
		selects.insertAfter("#viewTr");
		var selectBtn=$("<tr id='selectBtn'><td></td><td><input type='button' value='添加选项' class='btn btn6' onclick='addSelect(this)'>"
				+"<input type='button' value='删除选项' class='btn btn6' onclick='delSelect(this)'></td></tr>");
		selectBtn.insertBefore("#answerTr");
		}
	
		//删除选项
		delSelect=function(me){
			console.log($("tr[name='select']"));
			console.log($("tr[name='select']").length);
			if($("tr[name='select']").length>4){
			$(me).parent().parent().prev("tr[name='select']").remove();
			}else{
				alert("至少4个选项，无法删除!");
			}
		}
		//添加选项
		addSelect=function(me){
			var zimu=$(me).parent().parent().prev("tr[name='select']").find("span");
			var addZimu=String.fromCharCode((zimu.html().charCodeAt()+1));
			var selectOne=$("<tr name='select'><td></td>"
					+"<td><span>"+addZimu+"</span>:<input type='text' size='60' name='selects'/></td>"
					+"</tr>");
			selectOne.insertBefore("#selectBtn");
		}
		//预览问题
		showQuestion=function(){
			var selectEle=$("#catid");
			if(selectEle.val()=="0"){
				alert("请选择题目类型！");
				
			}else if(selectEle.val()=="q1"||selectEle.val()=="q2"){
				$("#viewTxt").css("display","block");
				$("#viewTxt").text("");
				showQ1Question();
			}else{
				$("#viewTxt").css("display","block");
				$("#viewTxt").text("");
				showQ345Question();
			}
		}
		//预览单选题
		showQ1Question=function(){
			var str=$("#title").val()+"<br/>";
			var selects=$("input[name='selects']");
			var startCode=65;
			selects.each(function(){
				str+=String.fromCharCode(startCode)+":"+$(this).val()+"<br/>";
				startCode++;
			})
			var reg=new RegExp("<br/>","g");
	        var stt= str.replace(reg,"\r\n");
	        $("#viewTxt").text(stt);
		}
		
		//预览填空题
		showQ345Question=function(){
			var str=$("#title").val();
	        $("#viewTxt").text(str);
		}
	});
	</script>
	<body>

		<div class="container clearfix">
			<!--/sidebar-->
			<div class="main-wrap">

				<div class="result-wrap">
					<div class="result-content">
						<form action="${pageContext.request.contextPath}/CourseServlet" method="post" id="myform" name="myform">
							<input type="hidden" name="method" value="findAll"/>
							<table class="insert-tab" width="100%">
								<tbody>


									<tr>
										<th><i class="require-red">*</i>题目：</th>
										<td id="titleTd">
											<input class="common-text required" id="title" name="q_title" size="50" value="" type="text">
										</td>
									</tr>
									<tr id="viewTr">
										<th><input type="button" id="viewBtn" class="btn btn-primary" value="预览" onclick="showQuestion()"/></th>
										<td><textarea readonly="readonly" name="view" class="preview-textarea" id="viewTxt" cols="30" style="width: 98%;display:none;" rows="5" ></textarea></td>
									</tr>
									<tr id="answerTr">
										<th>答案：</th>
										<td><textarea name="q_answer" class="common-textarea" id="answerTxt" cols="5" rows="1"></textarea></td>
									</tr>
									<tr>
										<th>答案解析：</th>
										<td><textarea name="explaination" class="common-textarea" id="explainationTxt" cols="30" style="width: 98%;" rows="10"></textarea></td>
									</tr>
									<tr>
										<th><i class="require-red">*</i>分值：</th>
										<td>
											<input class="common-text required" id="title" name="q_score" size="50" value="" type="text">
										</td>
									</tr>
									<tr>
										<th></th>
										<td>
											<input class="btn btn-primary btn6 mr10" value="提交" type="submit">
											<input class="btn btn6" value="重置" type="reset" id="reset">
											<input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
										</td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
				<script src="<%=path%>/js/add.js" type="text/javascript" charset="utf-8"></script>
			</div>
			<!--/main-->
		</div>

	</body>

</html>