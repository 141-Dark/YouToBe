
;(function(){
	var hour;
	var minute;
	var seconds;

	var remains = 0 ; //剩余的秒数
	var consume = 0 ; //消耗掉的秒数
	var percent = 0 ; //消耗掉的百分比
	var width = "";		//剩余条 的宽度，用于设置css
	
	function use(){
		hour = parseInt($("#timeH").text());	//初始化小时数
		minute = parseInt($("#timeM").text());;	//初始化分钟数
		seconds = parseInt($("#timeS").text());;//初始化秒数
		console.log(hour + ":" + minute + ":" + seconds);
		valuemax = hour * 60 * 60 + minute * 60 + seconds ; //总秒数
		$("#daojishi #allow").text(hour + "小时" + minute + "分" + seconds + "秒"); 
	}
	$(function(){
		use();
	});
	
	function going(){
		seconds = seconds- 1;
		
		if(seconds < 0 ) {
			minute = minute -1 ;
			seconds = seconds + 60 ; 
		}
		if(minute < 0 ){
			hour = hour - 1;
			minute = minute + 60 ; 
		}
		
		if(hour < 0) {
			clearInterval(countdown);
			check();//强制提交成绩
			return;
		}
		$("#daojishi #remainder").text(hour + "小时" + minute + "分" + seconds+"秒"); 
		
		consume = consume + 1;
		percent = consume / valuemax ;
		width = (1 - percent) * 100 + "%";
		
		if(percent > 0.85){ //时间紧了就换成 红色 进度条
			$("#daojishi .progress-bar").addClass("bg-danger"); 
		}
		
		
		$("#daojishi .progress-bar").css("width", width);
		$("#daojishi .progress-bar").text(parseInt((1 - percent) * 100) + "%");
	}
	
	var countdown= setInterval(going, 1000); //倒计时时钟
})();

