
	
	staut1()
	$("#staut1").click(function(){
		staut1()
	})
	$("#staut2").click(function(){
		staut2()
	})
	
	//简单显示
	function staut1(){	
		for(i=4;i<20;i++){
			$("."+i).hide();
		}
		$(".exportTableBox").css({"width":"30%"})
	}
	//详细显示
	function staut2(){
		for(i=4;i<19;i++){
			$("."+i).show();
		}
		$(".exportTableBox").css({"width":"90%"})
	}
	
	//21更换对错
	
	$(".21").click(function(){
		if($(this).text()=='√'){
			$(this).text('×');
			$(this).css({"color":"red","fontSize":"1.2em"});
		}
		else{
			$(this).text('√');
			$(this).css({"color":"green","fontSize":"1.0em"});
		}
	})
	
	//全选
	
	//只生成对号标记的组的文档
	function ttt(){
		var t='';
		for(i=0;i<$(".21").length;i++){
			if($(".21:eq("+i+")").text()=='√'){
				t+=$(".1:eq("+i+")").text()+'-';
			}else{  
				
			}	
		}
		$(".fm").val(t);
		alert($(".fm").val());
	}

