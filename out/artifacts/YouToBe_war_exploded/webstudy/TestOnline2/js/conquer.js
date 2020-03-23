		/**
		 * 初始化给每个题的正确答案做标记
		 */
		function ready(){
			
			var answer;
			
			$(".one_question").each(function(){
				
				answer= $(this).find(".answer").attr("value");
				
				var ops = answer.split(":");
				
				$(this).find(".option").each(function(){
					for(i = 0;i<ops.length;i++){
						if($(this).find("input").val()==(ops[i])){
							$(this).append('<span class="gou badge badge-success">正确答案</span>');
						};
					}
				});
			});
		}
		$(function(){
			ready();
		})
		
		/**
		 * 用户点击提交按钮
		 */
		function sub(paperId){
			if(confirm("你确定要交卷吗？")){
				check(paperId);
			}
		}
		
		/**
		 * 开始算分
		 */
		function check(paperId){
			
			$("#checkbutton").attr('disabled','disabled');
			$("#checkbutton").text("已提交");
			$("#checkbutton").remove();
			
			var sum = 0;//总题数
			var right = 0;//做对的题数
			
			$(".one_question").each(function(){
				sum++;
				
				
				//var select= $(this).find("input[on='op']:checked").val();//这句是以前单选的
				
				
				var select = "";
				$(this).find("input[on='op']:checked").each(function(){
					select = select+$(this).val()+":";
				});
				
				var answer= $(this).find(".answer").attr("value");
				
				console.log("你选了：" + select);
				console.log("正确答案是：" + answer);
				console.log(".....................................");
				if (select==answer) {
					right++;
					$(this).find(".result-check").show();
				}
				else{
					$(this).find(".result-close").show();
				}
				
			});
			
			console.log("正确数=" + right);
			console.log("题总数=" + sum);
			
			var score = (100*( right /sum ) );//百分制
			
			
			console.log("得分=" + score);
		
			$(".score").text(score);
			$(".gou").show();
			$.ajax({
				type:"POST",
				url:"scoreServlet.ajax?operation=getScore",
				data:{
					score:score,
					paperId:paperId
				},
				dataType:"",
				success:function(result){
					
				},
				error:function(){
					
				}
				
			});
			stop();
			
			//$("#form").submit();			
		}
	
		
		
		
		
		//显示开始时间
		function displayStartTime() {
			var clock_start = document.getElementById("clock_start");
			var now = new Date(); // 得到系统时间
			clock_start.innerHTML ="开始时间： " + now.toLocaleTimeString(); //让elt来显示它
		}
		$(function(){
			displayStartTime();
		});
		
		
		
		
		
		
		//显示当前时间
		function displayTime() {
			var elt = document.getElementById("clock_now");
			var now = new Date(); // 得到系统时间
			elt.innerHTML ="当前时间： " + now.toLocaleTimeString();
			setTimeout(displayTime,1000); //在1秒后再次执行    这里用的是反复调用自己的方式
		}
		$(function(){
			displayTime();
		});
		
		
		
		
		
		
		
		//秒表：实为已消耗时间
		var t_1;//时钟变量
	
		var hour;
		var minute; 
		var seconds;
		var miniseconds;
		
		function going(){
			miniseconds = parseInt(document.getElementById("miniseconds").innerHTML);
			seconds = parseInt(document.getElementById("seconds").innerHTML);
			minute = parseInt(document.getElementById("minute").innerHTML);
			hour = parseInt(document.getElementById("hour").innerHTML);
			
			miniseconds = miniseconds + 1; 
			if(miniseconds==10){
				miniseconds = 0;
				seconds=seconds + 1;
				if(seconds==60){
					seconds = 0;
					minute = minute + 1;
					if(minute == 60){
						minute=0;
						hour=hour+1;
					}
				}
			}
			
			document.getElementById("miniseconds").innerHTML=miniseconds; 
			document.getElementById("seconds").innerHTML= (seconds<10) ? '0' + seconds:seconds; //小于10要补个0字符
			document.getElementById("minute").innerHTML=  (minute<10)  ? '0' + minute : minute; //小于10要补个0字符
			document.getElementById("hour").innerHTML= hour;
		}
		function start(){t_1 = setInterval(going,100);}
		function stop(){clearInterval(t_1);}
		function reset()
		{
			clearInterval(t_1);
			document.getElementById("miniseconds").innerHTML=0;
			document.getElementById("seconds").innerHTML=0;
			document.getElementById("minute").innerHTML=0;
			document.getElementById("hour").innerHTML=0;
		}
		
		$(function(){
			start();
		});
		
