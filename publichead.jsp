<%@page import="com.anweitech.teacher.service.impl.StudentServiceImpl"%>
<%@page import="com.anweitech.teacher.domain.TeacherUser"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<style>
*{
	margin:0px;
	padding:0px;
}
.head{
	width: 100%;
	height: 56px;
	color: white;
	line-height: 56px;
	margin-right:20px;
	background:#212121;
	z-index:150;
	position:relative;
}
.head img{
	margin-left:35px;
	text-decoration: none;
	height:80px;
	position:relative;
	top:-12.5px;
}
.ssss{
	color:black;
	width:60%;
	top:0px;
	left:20%;
	font-size:1.2em;
	text-align: center;
	position:absolute;
}
.ssss li{
	list-style:none;
	float:left;
	margin-right:7%;
	overflow: hidden;
	height:56px;
	transition-duration:0.1s;
	width:12%;
}
.ssss li a{
	color:#ffffff;
}
.ssss li a:hover{
	color:#00a2e2;
}
.ssss li ul{
	width:100%;
}
.ssss li ul li:first-child{
	
}
.ssss li ul li{
	clear:left;
	background:#616161;
	width:100%;
	color:#ffffff;
	line-height:50px;
}
.ssss li ul li a{
	line-height: 50px;
}
a{
	color:black;
	text-decoration: none;	
}
a:active{
	color:black;
	text-decoration: none;	
}
a:visited{
	color:black;
	text-decoration: none;	
}
a:hover {
	color:black;
	text-decoration: none;	
}
.gongneng{
	display:inline;
	width:59px;
	text-align:center;
	float:right;
	height:56px;
	border-left:1px solid #464a51;
	cursor:pointer;
}
.gongneng:hover{
	
}
.gongneng img{
	margin-left:0px;
	text-decoration: none;
	width:30px;
	height:35px;
	margin:auto;
	top:0px;
	line-height: 56px;
	position:static;
	margin-top:-5px;	
}
.rightMenu{
	width:350px;
	height:100%;
	position:fixed;
	border-left:1px solid #d3d3d3;
	right:0px;
	top:0px;
	z-index:40;
	background:rgba(86,86,86,0.49);
	visibility:hidden;
}
.dwdh{
	width:100%;
	margin-top:56px;
}
.dwdh ul{
	list-style:none;
	width:100%;
	height:50px;
}
.dwdh ul li{
	width:100%;
	height:50px;
	border-bottom:1px solid black;
	color:black;
	background:#ffffff;
	cursor:pointer;
}
.dwdh ul li p{
	width:100%;
	height:100%;
	padding-left:20px;
	line-height: 50px;
}
.dwdh ul li ul{
	width:100%;
	margin-top:1px;
}
.dwdh ul li ul li{
	background:rgba(255,255,255,0.84);
	width:100%;
	height:50px;
	border-bottom:1px solid black;
	cursor:auto;
}
.dwdh ul li ul li img{
	display:inline;
	position: relative;
	top:4px;
	left:14px;
}
.dwdh ul li ul li a{
	color:blue;
}
.dwdh ul li ul li a p{
	width:80%;
	margin-left:20px;
	line-height:50px;
	display:inline;
	padding-left:0px;
}
.dwdh ul li ul li a p:hover{
	color: red;
}
.dwdh ul li ul li a:visited{
	color:blue;
}
.yonghu{
	float:right;
	margin-right:3%;
	height:56px;
}
.yonghu>a{
	color:white;
	position:relative;
	top:-54px;
	left:36px;
}
.yonghu>a:hover{
	color:#00a2e2 !important;
}
#asd{
	margin-left:-46px;
}
#ase{
	margin-right:10px;
}
</style>

<div class="head">
	<img src="<%=basePath%>img/logo.png" draggable="false" height="100%">
	<ul class="ssss">
		<li id="l1">
			<a href="shouye.jsp" id="aFirst"><b>首页</b></a>
		</li>
		<li id="l2">
			<a href="homepage.jsp"><b>状态监控</b></a>
		</li>
		<li id="l3">
			<a href="TProcessAll_Controller.do"><b>历史查询</b></a>
			<ul>
				<li><a href="TProcessAll_Controller.do">操作</a></li>
				<li><a href="StudentAll_fubenController.do">数据</a></li>
			</ul>
		</li>
		<li id="l4">
			<a href="Exports.do"><b>报告导出</b></a>
			<ul>
				<li><a href="Exports.do">当前</a></li>
				<li><a href="ExportsAll.do">历史</a></li>
			</ul>
		</li>
		<li id="l5">
			<a href="dataPage.do"><b>数据图表</b></a>
		</li>
	</ul>
		
	<div class="gongneng">
		<img src="img/23.gif" width="50%" style="display: inline-block; vertical-align: middle;">
	</div>
	
	<div class="yonghu">
		<p id="asd">${user}</p>
		<a id="ase" href="logOutController.do" style="color:white">注销</a>
	</div>	
</div>

<div class="rightMenu">
	<div class="dwdh">
		<ul>
			<li class="ultitle">
				<p>技术指导书&nbsp</p>
				<ul>
					<li><a href="<%=basePath%>download/ExperimentAll.zip" download><p>全部实验.zip</p><img src="img/textimg.png" width="20px"></a></li>
					<li><a href="<%=basePath%>download/Experiment1.pdf" download><p>实验一 密钥预置实验</p><img src="img/textimg.png" width="20px"></a></li>
					<li><a href="<%=basePath%>download/Experiment2.pdf" download><p>实验二 身份认证实验</p><img src="img/textimg.png" width="20px"></a></li>
					<li><a href="<%=basePath%>download/Experiment3.pdf" download><p>实验三 密钥更新实验</p><img src="img/textimg.png" width="20px"></a></li>
					<li><a href="<%=basePath%>download/Experiment4.pdf" download><p>实验四 网关广播源认证实验</p><img src="img/textimg.png" width="20px"></a></li>
				</ul>
			</li>
		</ul>
	</div>
</div>
<script>

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
   		}else{
   			console.log(data.user)
   		}
   	}
});



$(".rightMenu").hide();
$(".ultitle p").click(function(){
	$(this).next('ul').find('li').slideToggle(100);
})
$('.ultitle ul li').unbind("click");
$('.gongneng').mouseover(function(){
	$(".rightMenu").show(200);
	$(".rightMenu").css({"visibility":"visible"})
	$(".gongneng").css({"background":"#00c1de"});
});	
$(".rightMenu").mouseleave(function(){
	$(".rightMenu").hide(200);
	$(".head div").css({"background":"#212121"});
})
$(".ssss>li").mouseover(function(){
	$(this).css({"height":"168px"})
})
$(".ssss>li").mouseleave(function(){
	$(this).css({"height":"56px"})
})

</script>