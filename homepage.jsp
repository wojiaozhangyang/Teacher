<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>homepage</title>
	<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.1.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/homepage.css">
	<style>
	</style>
	<script>
	var bgcolor;
	//显示全部
	var tt = true;
	function detailedOperationInput(){
		$.ajax({
		   	type: "POST",
		   	url: "detailedOperationInput.do?t=0",
		   	data: "name=John",
		   	dataType:"json",
			success: function(data){
				$(".operationBodyShowBox table").empty();
				var color='black';
				for(i=0;i<data.length;i++){
					arr=data[i].split("|");
					if(arr.length==5){
						if(arr[2]!=null && arr[2].indexOf("成功")!=-1)
							color='black';
						else
							color='red';
						$(".operationBodyShowBox table").append('<tr height="35px" bgcolor='+bgcolor+'>'+
							'<td width="20%">'+arr[0]+'</td>'+
							'<td width="20%">'+arr[1]+'</td>'+
							'<td width="20%"><font color="'+color+'">'+arr[2].replace("~","")+'</font></td>'+
							'<td width="20%"><font color="'+color+'">'+arr[3].replace("~","")+'</font></td>'+
							'<td width="20%">'+arr[4].substring(0,19)+'</td>'+
							'</tr>');
							var div = document.getElementById('obsb');
					}
						if(tt)
				    	div.scrollTop = div.scrollHeight;	
				}
			}
		})
	}	

	var t=setInterval('detailedOperationInput2()', 5000);

	//显示临时
	function detailedOperationInput2(){
		$.ajax({
		   	type: "POST",
		   	url: "detailedOperationInput.do?t=1",
		   	data: "name=John",
		   	dataType:"json",
			success: function(data){
				var color="black";
				
				for(i=0;i<data.length;i++){
					arr=data[i].split("|");
					if(arr.length==5){
						if(arr[2].indexOf("成功")!=-1)
							color='black';
						else
							color='red';
					
						$(".operationBodyShowBox table").append('<tr height="35px" bgcolor='+bgcolor+'>'+
							'<td width="20%">'+arr[0]+'</td>'+
							'<td width="20%">'+arr[1]+'</td>'+
							'<td width="20%"><font color="'+color+'">'+arr[2]+'</font></td>'+
							'<td width="20%"><font color="'+color+'">'+arr[3]+'</font></td>'+
							'<td width="20%">'+arr[4].substring(0,19)+'</td>'+
							'</tr>')
					
						var div = document.getElementById('obsb');
					}
						if(tt)
				   	div.scrollTop = div.scrollHeight;
					
				}
			}
		})
	}
	
	function ss1(){
		window.clearInterval(t);
		detailedOperationInput();
		t=setInterval('detailedOperationInput()', 5000);
	}
	
	//根据sid显示
	function detailedOperationInputBySid(sid){
		$.ajax({
		   	type: "POST",
		   	url: "detailedOperationInput.do?t=0",
		   	data: "name=John",
		   	dataType:"json",
			success: function(data){
				$(".operationBodyShowBox table").empty();
				var color="black";
				for(i=0;i<data.length;i++){
						arr=data[i].split("|");
						if(arr.length==5){
						if(arr[2].indexOf("成功")!=-1)
							color='black';
						else
							color='red';
					if(arr[0]==sid){
						$(".operationBodyShowBox table").append('<tr height="35px">'+
							'<td width="20%">'+arr[0]+'</td>'+
							'<td width="20%">'+arr[1]+'</td>'+
							'<td width="20%"><font color="'+color+'">'+arr[2].replace("~","")+'</font></td>'+
							'<td width="20%"><font color="'+color+'">'+arr[3].replace("~","")+'</font></td>'+
							'<td width="20%">'+arr[4].substring(0,19)+'</td>'+
							'</tr>')
						}
					var div = document.getElementById('obsb');
					}
					if(tt)
				    div.scrollTop = div.scrollHeight;
					}
				var div = document.getElementById('obsb');
				if(tt)
			    div.scrollTop = div.scrollHeight;
			}
		})
	}
	
	function detailedOperationInputBySid2(sid){
		$.ajax({
		   	type: "POST",
		   	url: "detailedOperationInput.do?t=1",
		   	data: "name=John",
		   	dataType:"json",
			success: function(data){
				var color="black";
				for(i=0;i<data.length;i++){
					arr=data[i].split("|");
					if(arr.length==5){
					if(arr[2].indexOf("成功")!=-1)
						color='black';
					else
						color='red';
					if(arr[0]==sid){
						$(".operationBodyShowBox table").append('<tr height="35px" bgcolor='+bgcolor+'>'+
							'<td width="20%">'+arr[0]+'</td>'+
							'<td width="20%">'+arr[1]+'</td>'+
							'<td width="20%"><font color="'+color+'">'+arr[2].replace("~","")+'</font></td>'+
							'<td width="20%"><font color="'+color+'">'+arr[3].replace("~","")+'</font></td>'+
							'<td width="20%">'+arr[4].substring(0,19)+'</td>'+
							'</tr>')
						var div = document.getElementById('obsb');
					}
						if(tt)
				    	div.scrollTop = div.scrollHeight;
					}	
				}
			}
		})
	}

	
	function ss2(sid){
		window.clearInterval(t);
		detailedOperationInputBySid(sid)
		t=setInterval("detailedOperationInputBySid2("+sid+")",5000);
	}
	
	//情空操作
	function ss3(){
		$(".operationBodyShowBox table").empty();
	}         

	//滚动条
	$(".operationBodyShowBox").scroll(function() {
	    var scrollHeight = document.getElementById("obsb").scrollHeight; //251
	    var scrollTop = document.getElementById("obsb").scrollTop; //0-18
	    var clientHeight = document.getElementById("obsb").clientHeight; //233
	    var div = document.getElementById('obsb');
	    if (scrollHeight - clientHeight == scrollTop) {
	        tt = true;
	    }

	    var agent = navigator.userAgent;
	    if (/.*Firefox.*/.test(agent)) {
	        document.addEventListener("DOMMouseScroll",
	        function(e) {
	            e = e || window.event;
	            var detail = e.detail;
	            if (detail > 0) {
	                console.log("鼠标向下滚动");
	            } else {
	                tt = false;
	            }
	        });
	    } else {
	        document.onmousewheel = function(e) {
	            e = e || window.event;
	            var wheelDelta = e.wheelDelta;
	            if (wheelDelta > 0) {
	                tt = false;
	            } else {
	                console.warn("鼠标向下滚动");
	            }
	        }
	    }
	})
	</script>
</head>
<body>
	<div class="allcontent">
		<jsp:include page="publichead.jsp"></jsp:include>
		
		<div class="studentListBox">
			<div>
				
			</div>
		</div>
		<div class="gongnenglan">
			<button type="button" onclick="detailedOperationInput()">全部</button>
			<button type="button" onclick="ss3()">清空</button>
		</div>
		<div class="operationShowBox">
			<div class="operationBodyShowTitleBox">
				<table width="100%" border="1px" align="left">
					<tr bgcolor="#f9f9f9" height="20px">
						<th width="20%" height="40px">组号</th>
						<th width="20%" height="40px">状态</th>
						<th width="20%" height="40px">行为</th>
						<th width="20%" height="40px">结果</th>
						<th width="20%" height="40px">时间</th>
					</tr>
				</table>
			</div>
			<div class="operationBodyShowBox" id="obsb">
				<table width="100%" border="1px" id="scrolldIV">

				</table>
			</div>		
		</div>	
		<div class="foot">
			<div>
		 		<p>
		 			北京安为科技有限公司 版权所有 © 2017京ICP备1702606
		 		</p>
  			</div>
		</div>
	
	<script type="text/javascript" src="<%=basePath %>js/homepage.js"></script>
	<style>
		#l2{
			color:white;
		}
		#l2 a{
			color:#00a2e2;
		}
		#l2 ul li a{
			color:white;
		}
		#l2 ul li a:hover{
			color:#00a2e2;
		}
		.ssss a:hover{
			color:#00a2e2;
		}
		#scrolldIV tr{
			min-height: 35px;
			height:35px;
		}
	</style>
	<a href="login.jsp" id="login"></a>
	<script type="text/javascript">	
	var a=$("#asd").text().trim().replace("|","");
	$.ajax({
	   	type: "POST",
	   	url: "tuJson.do?user="+a,
	   	data: "name=s",
	   	dataType:"json",
	   	success: function(data){  
	   		//如果用户不存在且为空的话
	   		if(data.user==null){
	   			console.log(data.user)
	   			$("#login").trigger("click");
	   			document.getElementById("login").click();
	   		}else{
	   			console.log(data.user)
	   		}
	   	}
	});
	</script>
</body>
</html>