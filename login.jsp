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
	<title>登陆页</title>
	<script type="text/javascript" src="<%=basePath %>js/jquery-2.1.1.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/login.css" >
</head> 


<body>
	<div class="headimg">
		<img src="img/headimg.jpg" alt="╮(╯▽╰)╭" width="100%">
	</div>
	<h1 id="hh1">安为传感网教学实训平台</h1>
	<h1 id="hh2">（教师端）</h1>
	<form class="tt" action="loginController.do" method="post">
		<img src="img/user2.png">
		<input type="text" placeholder="账号" id="user" name="user" autocomplete='off'>
		<br> 
		<img src="img/pass2.png">
		<input type="password" placeholder="密码" id="pass" name="pass" 	autocomplete='off'>
		<br>
		<input type="submit" value="登 陆" id="sub">
	</form>
</body>
</html>