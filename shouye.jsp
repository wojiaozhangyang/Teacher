<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>首页</title>
	<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
	<link rel="stylesheet" type="text/css" href="css/shouye.css">
</head>
<body>
	<jsp:include page="publichead.jsp"></jsp:include>
	<div class="middel">
		<div class="curriculumTitle">   
			<h1>安全传感网教学实训平台</h1><br>
		</div>

		<div class="curriculumBox">
			<div class="curriculum"> 
				<table width="100%" height="600px">
					<tr>
						<td width="50%" class="fi1">
							<div>
								<img src="img/system.png" width="100%">
							</div>
						</td>
						<td width="50%" valign="top" class="fi2">
							<div class="ff1">
								<a href="homepage.jsp">
									<h2>传感网安全实验</h2>
								</a>
							</div>
							<div class="ff2">
								<a href="homepage.jsp">
									<p>
										学生通过安全实验平台，按照安全指导手册进行相应的练习，帮助学生更直观的认识密钥在系统安全中所起的作用，理解身份认证的原理及认证方法，认识密钥协商的过程
										，了解merkle树基本原理，认识基于merkle树的广播源认证方式，以及网络密钥如何保证广播源认证的安全性。
									</p>
									<br>
									<br>
									<br>
									<br>
								</a>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="foot">
		<div>
		 	<p>
		 		北京安为科技有限公司 版权所有 © 2017京ICP备1702606
		 	</p>
  		</div>
	</div>
	<a href="login.jsp" id="login"></a>
	<style>
		#l1{
			color:white;
		}
		#l1 a{
			color:#00a2e2;
		}
		#l1 ul li a{
			color:white;
		}
		#l1 ul li a:hover{
			color:#00a2e2;
		}
	</style>
	<script type="text/javascript" src="js/shouye.js">
	</script>
	<script type="text/javascript">
	var t=$("#asd").text().trim().replace("|","");
	$.ajax({
	   	type: "POST",
	   	url: "tuJson.do?user="+t,
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