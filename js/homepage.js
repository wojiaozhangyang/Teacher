$(".operationBodyShowBox table tr:even").css({"background":"#f9f9f9"});
$(".operationBodyShowBox table tr:odd").css({"background":"#ffffff"});
var sBoxShow=true;
//$(document).mousemove(function (e) {
//	var xx = e.originalEvent.x || e.originalEvent.layerX || 0;
//	var yy = e.originalEvent.y || e.originalEvent.layerY || 0;
//	if(xx==0 && sBoxShow){
//		$(".settingBox").animate({
//			width:"256px"
//		},200);
//		sBoxShow=false;
//	}
//});

var t2=setInterval('operationList()', 5000)
var stuList=[];//学生的集合
//显示全部学生
operationList()
function operationList(){
	$.ajax({
	   	type: "POST",
	   	url: "studentAll.do",
	   	data: "name=John&location=Boston",
	   	dataType:"json",
	   	success: function(data){   		
   			$(".studentListBox div").empty();
   			/*$(".operationShowBox").empty();*/
	   		for(i=0;i<data.length;i++)
	   		{
	   			//如果没有sid
	   			if(data[i].sid==null){
	   				continue;
				}
				if(data[i].whether_online=="0"){//如果在线
					if(data[i].level==1){
						if(data[i].sgroup.length>4){
							data[i].sgroup=data[i].sgroup.substring(0,4)+'...';
						}
						$(".studentListBox div:eq(0)").prepend('<button type="button" onclick=\'ss2("'+data[i].sgroup+'")\'>'+data[i].sgroup+'</button>');
					}
					}
			}
	   	}
	});
}

//让表格始终对齐
function sdf(){
	var sw=$(".operationBodyShowBox")[0].offsetWidth-$(".operationBodyShowBox")[0].scrollWidth;
	var tsw=$(".operationBodyShowTitleBox")[0].offsetWidth;
	var s=tsw-sw;
	$(".operationBodyShowTitleBox table").css({"width":s})
}
sdf()
setInterval("sdf()",100);











