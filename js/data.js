var sList=[];
operationList();
var change=0;

//更新数组添加
function addData(chart, label, data,change) {
	
    if(change==1){
    	
    	
    	chart.update(0);
    }else{
        chart.data.datasets.forEach((dataset) => {
            dataset.data.push(data);
        });
        chart.update(0);
    }
}
//删除数据
function removeData(chart) {
    chart.data.labels.pop();
    chart.data.datasets.forEach((dataset) => {
        dataset.data.pop();
    });
    chart.update();
}
//学生列表
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
	   			if(data[i].sid==null){
	   				continue;
	   			}
	   			if(data[i].level==1){
					if(data[i].sgroup.length>6){
						data[i].sgroup=data[i].sgroup.substring(0,5)+'...';
					}
					$(".studentListBox div").prepend('<button type="button" onclick=\'dynamicSid("'+data[i].sgroup+'")\'>'+data[i].sgroup+'</button>');
	   			}
	   		}
	   	}
	});
}

//初始化图表
test(1000,0);
var dynamic = setInterval("test(100,"+change+")",5000);


//显示学生的温湿度
function dynamicSid(sid){
	change=1;
	window.clearInterval(dynamic);
	test(sid,change);
	dynamic = setInterval("test("+sid+","+0+")",5000);	
}
	

var color=getRandomColor();
//显示一个人
function test(sid,change){
		$.ajax({
		   	type: "POST",
		   	url: "dataLine.do",
		   	data: "name=John&location=Boston",
		   	dataType:"json",
		   	success: function(data){
		   		
		   		console.log('test的'+change);
		   		
		   		//清空画布
		   		if(cahnge=1)
		   			chartUpdate();
		   		
		   		//生成数据
		   		var ss=[];
		   		var tt=[];
		   		var zz=[];
		   		var ss2=[];
		   		var tt2=[];
		   		var zz2=[];
		   		var ss3=[];
		   		var tt3=[];
		   		var zz3=[];
		   		for(i=0;i<data.length;i++){
		   			if(data[i].sid==sid){
		   				if(data[i].subtype=='光照'){
		   					ss.push(parseInt(data[i].datavalue,16)/10);
		   					tt.push(timeFormatter(data[i].dtime));
		   				}else if(data[i].subtype=='温度'){
		   					ss2.push(parseInt(data[i].datavalue,16)/100);
		   					tt2.push(timeFormatter(data[i].dtime));
		   				}else if(data[i].subtype=='湿度'){
		   					ss3.push(parseInt(data[i].datavalue,16)/100);
		   					tt3.push(timeFormatter(data[i].dtime));
		   				}
		   			}
		   		}
   				zz.push({
   		            lineTension : 0, 
   		            fill : false, 
   		            backgroundColor: color, //背景填充色
   		            borderColor: color, //路径颜色
   		            pointBackgroundColor: color, //数据点颜色
   		            pointBorderColor: color, //数据点边框颜色
   		            data: ss ,//对应的值
   				})	
   				zz2.push({
   		            lineTension : 0, 
   		            fill : false, 
   		            backgroundColor: color, //背景填充色
   		            borderColor: color, //路径颜色
   		            pointBackgroundColor: color, //数据点颜色
   		            pointBorderColor: color, //数据点边框颜色
   		            data: ss2 ,//对应的值
   				})
   				zz3.push({
   		            lineTension : 0, 
   		            fill : false, 
   		            backgroundColor: color, //背景填充色
   		            borderColor: color, //路径颜色
   		            pointBackgroundColor: color, //数据点颜色
   		            pointBorderColor: color, //数据点边框颜色
   		            data: ss3 ,//对应的值
   				})
   				
		   		t(ss,tt,zz,change)
		   		t2(ss2,tt2,zz2,change)
		   		t3(ss3,tt3,zz3,change)
		   	},error: function(data){
		   		
		   	}	
		});
	}

//显示所有人
function textAll(){
	$.ajax({
	   	type: "POST",
	   	url: "dataLine.do",
	   	data: "name=John&location=Boston",
	   	dataType:"json",
	   	success: function(data){		   		
	   		var ss=[];
	   		var tt=[];
	   		var zz=[];
	   		var ss2=[];
	   		var tt2=[];
	   		var zz2=[];
	   		var ss3=[];
	   		var tt3=[];
	   		var zz3=[];
	   		var color=getRandomColor();
	   		var sid=null;
	   		for(m=0;m<sList.length;m++){//所有学生的循环
	   			
	   			sid=sList[m];
	   			for(i=0;i<data.length;i++){//所有data的循环
	   				if(sList[m]==data[i].sid){//如果是当前循环的sid,就添加数据
	   		   			if(data[i].subtype=='光照'){
	   		   				ss.push(parseInt(data[i].datavalue,16)/10);
	   		   			}else if(data[i].subtype=='温度'){
	   		   				ss.push(parseInt(data[i].datavalue,16)/100);
	   		   			}else if(data[i].subtype=='湿度'){
	   		   				ss.push(parseInt(data[i].datavalue,16)/100);
	   		   			}
	   				}
	   			}
	   			
	   			color=getRandomColor()
	   			
				zz.push({
		            lineTension : 0, 
		            fill : false, 
		            backgroundColor: color, //背景填充色
		            borderColor: color, //路径颜色
		            pointBackgroundColor: color, //数据点颜色
		            pointBorderColor: color, //数据点边框颜色
		            data: ss ,//对应的值
				})	
				zz2.push({
		            lineTension : 0, 
		            fill : false, 
		            backgroundColor: color, //背景填充色
		            borderColor: color, //路径颜色
		            pointBackgroundColor: color, //数据点颜色
		            pointBorderColor: color, //数据点边框颜色
		            data: ss2 ,//对应的值
				})
				zz3.push({
		            lineTension : 0, 
		            fill : false, 
		            backgroundColor: color, //背景填充色
		            borderColor: color, //路径颜色
		            pointBackgroundColor: color, //数据点颜色
		            pointBorderColor: color, //数据点边框颜色
		            data: ss2 ,//对应的值
				})
				
				ss=[];
				ss2=[];
				ss3=[];
	   		}
	   		
	   		
	   		for(i=0;i<data.length;i++){//添加时间
	   			sid=data[i].sid;
	   			if(data[i].subtype=='光照'){
	   				tt.push(timeFormatter(data[i].dtime));
	   			}else if(data[i].subtype=='温度'){
	   				tt2.push(timeFormatter(data[i].dtime));
	   			}else if(data[i].subtype=='湿度'){
	   				tt3.push(timeFormatter(data[i].dtime));
	   			}
	   		}

				
	   		t(ss,tt,zz)
	   		t2(ss2,tt2,zz2)
	   		t3(ss3,tt3,zz3)
	   	},error: function(data){
	   		
	   	}	
	});
	
}

//更新数组，最终确定版
function chartUpdate(){
	$('.sd1').remove();
	$('.sd2').remove();
	$('.sd3').remove();
	$('.middel').prepend('<h1 class="sd3">温度</h1><canvas id="myChart3" class="sd3" width="600" height="400"></canvas>');
	$('.middel').prepend('<h1 class="sd2">湿度</h1><canvas id="myChart2" class="sd2" width="600" height="400"></canvas>');
	$('.middel').prepend('<h1 class="sd1">光照</h1><canvas id="myChart" class="sd1" width="600" height="400"></canvas>');
}
//光照	
function t(ss,tt,zz,change){
    var options = {
    	responsive : true,
        maintainAspectRatio: false,
        spanGaps: false,
        legend:{
        	display: false
        },
        plugins: {
            filler: {
                propagate: false
            }
        },
        scales: {
            xAxes: [{
                ticks: {
                    autoSkip: true,
                    maxRotation: 0
                }
            }],
            yAxes: [{
                ticks: {
                    autoSkip: false,
                    maxRotation: 0,
                    min:0,
                    max:100,
                    callback: function(value, index, values) {return value+'%';}
                }
            }] 
        }
    };
    
    var data={
        //折线图需要为每个数据点设置一标签。这是显示在X轴上。
        labels: tt,
        //数据集（y轴数据范围随数据集合中的data中的最大或最小数据而动态改变的）
        datasets: zz                
    };
    var ctx = document.getElementById("myChart").getContext('2d');
    var myLineChart = new Chart(ctx, {
        type: 'line',
        data: data,
        options: options
    });
    myLineChart.render({
        duration: 0,
        lazy: false,
        easing: 'easeOutBounce'
    });
    console.log('光照'+change);
    

    
    addData(myLineChart,tt,data,change);
}
//湿度
function t2(ss,tt,zz,change){
    var options = {
    	responsive : true,
        maintainAspectRatio: false,
        spanGaps: false,
        legend:{
        	display: false
        },
        plugins: {
            filler: {
                propagate: false
            }
        },
        scales: {
            xAxes: [{
                ticks: {
                    autoSkip: true,
                    maxRotation: 0
                }
            }],
            yAxes: [{
                ticks: {
                    autoSkip: false,
                    maxRotation: 0,
                    min:0,
                    max:100,
                    callback: function(value, index, values) {return value+'%';}
                }
            }] 
        },
    };
    
    var data={
        //折线图需要为每个数据点设置一标签。这是显示在X轴上。
        labels: tt,
        //数据集（y轴数据范围随数据集合中的data中的最大或最小数据而动态改变的）
        datasets: zz                
    };
    var ctx = document.getElementById("myChart2").getContext('2d');
    var myLineChart = new Chart(ctx, {
        type: 'line',
        data: data,
        options: options
    });
    
    
    addData(myLineChart,tt,data,change)
}
//温度
function t3(ss,tt,zz,change){
    var options = {
    	responsive : true,
        maintainAspectRatio: false,
        spanGaps: false,
        legend:{
        	display: false
        },
        plugins: {
            filler: {
                propagate: false
            }
        },
        scales: {
            xAxes: [{
                ticks: {
                    autoSkip: true,
                    maxRotation: 0
                }
            }],
            yAxes: [{
                ticks: {
                    autoSkip: false,
                    maxRotation: 0,
                }
            }] 
        },
    };
    
    var data={
        //折线图需要为每个数据点设置一标签。这是显示在X轴上。
        labels: tt,
        //数据集（y轴数据范围随数据集合中的data中的最大或最小数据而动态改变的）
        datasets: zz                
    };
    var ctx = document.getElementById("myChart3").getContext('2d');
    var myLineChart = new Chart(ctx, {
        type: 'line',
        data: data,
        options: options
    });
    
    addData(myLineChart,tt,data,change)
}
//获取时间
function timeFormatter(value) {
	var da = new Date(value)
    return da.getFullYear() + "-" + (da.getMonth() + 1) + "-" + da.getDate() + " " + da.getHours() + ":" + da.getMinutes() + ":" + da.getSeconds();
}
//获取颜色
function getRandomColor(){ 

	return "#"+("00000"+((Math.random()*16777215+0.5)>>0).toString(16)).slice(-6); 
	} 
//数组去重
function deleteDuplicate(a) {
	  if( Object.prototype.toString.call( a ) !== '[object Array]' || !a.length ) {
	    return a;//非数组、空数组直接返回
	  }
	  var tmp = [ a[0] ];//存储原数组第一个元素
	  for(var i = 1; i < a.length; i++) {//从第二个开始遍历
	    if( tmp.indexOf( a[i] ) === -1 ) {
	      tmp.push( a[i] );
	    }
	  }
	  return tmp;
	}


