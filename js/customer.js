//得到想要的日期；啊哈哈哈哈哈
function GetDateStr(AddDayCount) { 
	var dd = new Date(); 
	dd.setDate(dd.getDate()+AddDayCount);//获取AddDayCount天后的日期 
	var y = dd.getFullYear(); 
	var m = (dd.getMonth()+1);//获取当前月份的日期 
	var d = dd.getDate(); 
	
	if(m<10)
		m="0"+m
	if(d<10)
		d="0"+d
	return y+'-'+m+'-'+d; 
} 

//让表格始终对齐
function t(){
	var sw=$(".middelTap")[0].offsetWidth-$(".middelTap")[0].scrollWidth;
	var tsw=$(".mm")[0].offsetWidth;
	var s=tsw-sw;
	$(".mm table").css({"width":s})
}
t()
setInterval("t()",100);














