/****************新闻********************/

//获取Top10
function getTop10()
{
	var requestUrl = $('#top10Form').attr('action');
	var params = {date:$('#selectDate').val()};

	getRequestData(requestUrl, params, 'get', top10ToHtml);
}

//TOP10 HTML格式化
function top10ToHtml(data)
{
	var selectType = $('#top10Form input[name="type"]');
	var currentSelect = null;
	for(var i=0; i<selectType.length; i++) {
		if ($(selectType[i]).attr("checked")){
			currentSelect = $(selectType[i]);
		}
	}

	var dataItems = currentSelect ? data[currentSelect.val()] : data.all;
	var keywords = currentSelect ? data['keyWord'][currentSelect.val()] : data['keyWord']['all'];
	var tableContent = data.type == 'news' ? newsTop10Html(dataItems) : commentTop10Html(dataItems);

	if (tableContent == ''){
		$('#columnChart1').prepend($('#noData').html());
	} else {
		$('#columnChart1 .nonum').remove();
	}

	$('#top10Container').html(tableContent);

	//取消绑定事件
	selectType.unbind();
	$('#selectDate').unbind();

	//重新绑定事件
	selectType.bind('click',function(){top10ToHtml(data)});
	$('#selectDate').bind('change',function(){getTop10()});

	//画图
	drawChart(keywords, data.type);
}

//新闻TOP10 HTML
function newsTop10Html(dataItems)
{
	var tableContent = '';
	for(var i=0; i<dataItems.length; i++) {
		tableContent += '<div class="tableList">';
		tableContent += '<table cellpadding="0" cellspacing="0">';
		tableContent += '<tr>';
		tableContent += '<td valign="bottom"><div class="newsCount '+ (i<4 ? 'newsColor' : '' ) +'">'+(i+1)+'</div></td>';
		tableContent += '<td class="PeopleBorder '+(i<4 ? '' : 'PeopleBorderC' )+'">';
		tableContent += '<div title="'+dataItems[i].fullTitle+'" class="newsDocket PeopleDocket"><a href="'+dataItems[i].url+'" target="_blank">'+dataItems[i].title+'</a></div>';
		tableContent += '<div class="sumTime">';
		tableContent += '<span class="reprint PeopleTimeMKLH">转载量：<tt>'+dataItems[i].reserved+'</tt></span>';
		tableContent += '<span class="soucre PeopleTimeMKL">网站：<tt>'+dataItems[i].site+'</tt></span>';
		tableContent += '<div class="clear"></div>';
		tableContent += '<span class="time PeopleTime">时间：'+dataItems[i].date+'</span>';
		tableContent += '</div>';
		tableContent += '</td>';
		tableContent += '</tr>';
		tableContent += '</table>';
		tableContent += '</div>';
	}

	return tableContent;

}

//评论TOP10 HTML
function commentTop10Html(dataItems)
{
	var tableContent = '';
	for(var i=0; i<dataItems.length; i++) {
		tableContent += '<div class="tableList">';
		tableContent += '<table cellpadding="0" cellspacing="0">';
		tableContent += '<tr>';
		tableContent += '<td valign="bottom"><div class="newsCount '+ (i<4 ? 'newsColor' : '' ) +'">'+(i+1)+'</div></td>';
		tableContent += '<td class="PeopleBorder '+(i<4 ? '' : 'PeopleBorderC' )+'">';
		tableContent += '<div title="'+dataItems[i].fullTitle+'" class="newsDocket PeopleDocket"><a href="'+dataItems[i].url+'" target="_blank">'+dataItems[i].title+'</a></div>';
		tableContent += '<div class="sumTime">';
		tableContent += '<span class="reprint PeopleTimeMKLH">转载量：<tt>'+dataItems[i].reserved+'</tt></span>';
		tableContent += '<span class="soucre PeopleTimeMKL">网站：<tt>'+dataItems[i].site+'</tt></span>';
		tableContent += '<div class="clear"></div>';
		tableContent += '<span class="time PeopleTime">时间：'+dataItems[i].date+'</span>';
		tableContent += '</div>';
		tableContent += '</td>';
		tableContent += '</tr>';
		tableContent += '</table>';
		tableContent += '</div>';
	}

	return tableContent;

}

//获取数据列表
var params='';
var objParams = {};
var re = new RegExp("[0-9\-]+","g");
function getItemVal(pageGo)
{
	//获取表单
	var objForm = $('form')[1];
	//准备参数：搜索条件
	objParams = {};
	objParams[$('#sortOrder').attr('name')] = $('#sortOrder').val();

	params = $(objForm).find(':text,input:checked,select');
	for(var i=0; i<params.length; i++) {
		if ($(params[i]).val() != '') {
			objParams[$(params[i]).attr('name')] = $(params[i]).val();
		}
	}
	getItemList(pageGo);
	return false;
}

function getItemList(pageGo)
{
	//获取表单
	var objForm = $('form')[1];
	//通过获取日期
	rangDate = $('#widgetField span').html().match(re);
	//获取排序方式
	objParams[$('#sortOrder').attr('name')] = $('#sortOrder').val();
	params = $(objForm).find('#widget span');
	objParams[params.attr('name')+'[dateStart]'] = rangDate[0];
	objParams[params.attr('name')+'[dateEnd]'] = rangDate[1];
	
	var requestUrl = $(objForm).attr('action').toString();
	//设置分页地址
	var max = $("#maxPage").html() == null || isNaN($("#maxPage").html()) || parseInt($("#maxPage").html()) == 0 ? 1 : parseInt($("#maxPage").html());
	if (pageGo > 0 && pageGo <= max){
		var requestUrl = requestUrl.indexOf('?') == -1 ? requestUrl+'?page='+pageGo : requestUrl+'&page='+pageGo;
	}else{
		$("#pageGo").val(1);
		return false;
	}

	//异步请求数据
	getRequestData(requestUrl, objParams, 'post', dataToHtml);
}

//异步请求数据
function getRequestData(url, params, method, handle)
{
	$.ajax({
		type : method,
		url : url,
		data : params,
		dataType : 'json',
		success : function(data) {handle(data)}
	});
}

//格式化分页信息
function pageToHtml(page)
{
	var pageContent = '<div class="tablePageRight">';

	if (page.total > 0){	
		pageContent += '<span>第</span><span><input id="pageGo" type="text" /></span><span>页</span>';
		pageContent += '<span onclick="getItemList($(\'#pageGo\').val())"><a href="###"></a></span></div>';

		pageContent += '<div class="tablePageNum">';

		//上一页
		if (page.current > 1){
			pageContent += '<span onclick="getItemList('+(page.current-1)+')" class="up"><a href="###"></a></span>';

		} else {
			pageContent += '<span class="upend"><a href="###"></a></span>';
		}
		
		var pageLength = 5;
		for(var i=1; i<=page.count; i++) {
			if (page.current>Math.floor(pageLength/2) && page.current<page.count-Math.floor(pageLength/2) && (i<page.current-Math.floor(pageLength/2) || i>page.current+Math.floor(pageLength/2))){
				continue;
			} 
			if (page.current<Math.ceil(pageLength/2) && i>pageLength){
				continue;
			}
			if (page.current>page.count-Math.ceil(pageLength/2) && i<=page.count-pageLength){
				continue;
			}
			if (page.current == i){
				pageContent += '<span class="normal act"><a href="###">'+i+'</a></span>';
			} else {
				pageContent += '<span onclick="getItemList('+i+')" class="normal"><a href="###">'+i+'</a></span>';
			}
		}

		//下一页
		if (page.current < page.count){
			pageContent += '<span onclick="getItemList('+(page.current+1)+')" class="next"><a href="###"></a></span>';

		} else {
			pageContent += '<span class="nextend"><a href="###"></a></span>';
		}
	}

	pageContent += '</div>';

	$('#pageInfo').html('<span>共有<tt>'+page.total+'</tt>条记录</span> <span>共有<tt id="maxPage">'+page.count+'</tt>页</span>');
	$('#pageContainer').html(pageContent);
}

//格式化新闻或评论列表
function dataToHtml(response)
{
	var tableHeader = '<tr><th align="center" width="35%">标题</th><th align="center" width="7%">转载量</th><th align="center" width="17%">最近转载</th><th align="center" width="10%">网站</th><th align="center" width="7%">境内/外</th><th align="center" width="15%">发布时间</th><th align="center" width="9%">操作</th></tr>';

	var tableContent = '';
	if (response.data && response.data.length > 0){
		for(var i=0; i<response.data.length; i++) {
			tableContent += '<td title="'+response.data[i].fullTitle+'" align="center"><div class="pTitle"><a target="_blank" href="'+response.data[i].url+'">'+response.data[i].title+'</a></div></td>';
			tableContent += '<td align="center">'+response.data[i].reserved+'</td>';
			tableContent += '<td align="center">'+response.data[i].reservedTime+'</td>';
			tableContent += '<td align="center">'+response.data[i].site+'</td>';
			tableContent += '<td align="center">'+response.data[i].source+'</td>';
			tableContent += '<td align="center">'+response.data[i].date+'</td>';
			tableContent += '<td align="center"><div class="mainstreamTableBnt">';
			tableContent += '<span class="bntLeft"><a href="'+response.data[i].updateUrl+'" onclick="return coveDiv(this);"></a></span>';
			tableContent += '</div></td></tr>';
		}
	}

	pageToHtml(response.page);
	$('#tableContainer').html(tableHeader+tableContent);
}

//画图
function drawChart(keywords, type) {
	var rectangle = {xMin:10,yMin:10,xMax:90,yMax:90,width:790,height:500};
	var circles = new Array();

	//计算出最大值
	var maxValue = 0;
	for(var i=0; i<keywords.length; i++) {
		maxValue = keywords[i].weight > maxValue ? keywords[i].weight : maxValue;
	}

	var data = new google.visualization.DataTable();
	var rows = new Array();
	for(var i=0; i<keywords.length; i++) {
		var circle = createCircle(rectangle, {rSize:keywords[i].weight/maxValue*(rectangle.yMax-10)}, circles, 500);
		if (circle){
			rows[i] = new Array(keywords[i].word.toString(),circle.xAxis,circle.yAxis,keywords[i].related+'篇',circle.rSize);
			circles.push(circle);
		} else {
			rows[i] = null;
		}
	}

	data.addColumn('string', '关键词');
	data.addColumn('number', '');
	data.addColumn('number', '');
	data.addColumn('string', type=='news' ? '相关新闻' : '相关评论');
	data.addColumn({type:'number', role: 'Population'});
	data.addRows(rows)

	var options = {
		width:790,
		height:500,
		chartArea:
		{
			left:0,
			top:0,
			width:rectangle.width,
			height:rectangle.height
		},

		hAxis: {
			textStyle:
			{
				color:'#000'
			},
			baselineColor: '#fff',
			gridlines:{color:'#fff'},
			maxValue:rectangle.xMax,
			minValue:rectangle.xMin
		},

		vAxis: {
			textStyle:
			{
				color:'#000'
			},
			baselineColor: '#fff',
			gridlines:{color:'#fff'},
			maxValue:rectangle.yMax,
			minValue:rectangle.yMin
		},

		colors:['#71b5e4'],

		enableInteractivity: true,

		sizeAxis:
		{
			maxSize:70,
			maxValue:70,
			minSize:10,
			minValue:10

		},
		legend: {position: 'none'},

		bubble:
		{
			opacity: 1,
			textStyle:{
				color: 'black',
				fontName:'simhei',
				fontSize: '16'
			}
		},
		animation:
		{
			duration: 1000,
			easing: 'in'
		}
	};

	//var chart = new google.visualization.BubbleChart(document.getElementById('columnChart1'));
	chart.draw(data, options);
}

//生成一个圆 circle:圆参数 rectangle:矩形参数 circles:已存在的圆 times:尝试次数
function createCircle(rectangle, circle, circles, times)
{
	var coordinate = randomCoordinate(rectangle);
	circle.xAxis = coordinate.xAxis;
	circle.yAxis = coordinate.yAxis;

	for(var i=times; i>0; i--) {
		//不溢出、不重叠
		if (isInnerRectangle(circle, rectangle) && isNotOverlay(circle, circles, rectangle)){
			return circle;

		} else {
			return createCircle(rectangle, circle, circles, i-1);//递归调用
		}
	}

	return false;
}

//在一个矩形屏幕上随机取一个点放置一个圆 rectangle:矩形参数
function randomCoordinate(rectangle)
{
	//取出xAxis随机值
	var xAxis = Math.random() * (rectangle.xMax - rectangle.xMin) + rectangle.xMin;

	//取出yAxis随机值
	var yAxis = Math.random() * (rectangle.yMax - rectangle.yMin) + rectangle.yMin;
	

	return {xAxis:xAxis,yAxis:yAxis};
}

//这个圆不溢出矩形边界 circle:圆参数，rectangle:矩形参数
function isInnerRectangle(circle, rectangle)
{
	//修正值
	var xAxis = 5;
	var yAxis = 10;

	//X轴溢出
	if (circle.xAxis + circle.rSize/rectangle.width*100 + xAxis > rectangle.xMax || circle.xAxis - circle.rSize/rectangle.width*100 < rectangle.xMin + xAxis){
		return false;
	}

	//Y轴溢出
	if (circle.yAxis + circle.rSize/rectangle.height*100 + yAxis > rectangle.yMax || circle.yAxis - circle.rSize/rectangle.height*100 < rectangle.yMin + yAxis){
		return false;
	}

	return true;
}

//这个圆不与其他圆重叠 circle:当前圆参数，circles已存在圆参数，rectangle:矩形参数
function isNotOverlay(circle, circles, rectangle)
{
	for (var i=0; i<circles.length; i++) {
		var width = (circle.xAxis- circles[i].xAxis) * rectangle.width / 100;
		var height = (circle.yAxis - circles[i].yAxis)* rectangle.height / 100;
		var length = circle.rSize + circles[i].rSize;

		if (Math.pow(width,2) + Math.pow(height,2) < Math.pow(length,2)) {
			return false;
		}
	}

	return true;
}

//检查播放状态
function checkPlay(data)
{
	if (playStatus > 0){
		window.clearInterval(playStatus);
		playStatus = 0;
		$('#playButton').attr('src',$('#playButton').attr('src').replace("stop02.jpg","play02.jpg"));

	} else {
		playStatus = self.setInterval(function(){top10ToHtml(data);},15000);
		$('#playButton').attr('src',$('#playButton').attr('src').replace("play02.jpg","stop02.jpg"));
	}
}

//弹出层事件响应
function clickTheColumnChart(pageGo)
{
	//清理自动播放
	if (playStatus > 0) {
		checkPlay(null);
	}

	var requestUrl = $('#keywordSearchForm').attr('action');
	var model = $('#keywordSearchForm').attr('name')
	//设置分页地址
	if (pageGo > 0){
		var requestUrl = requestUrl.indexOf('?') == -1 ? requestUrl+'?page='+pageGo : requestUrl+'&page='+pageGo;
	}

	var selection = chart.getSelection();
	if (!selection.length){
		return ;
	}

	var keyword = currentKeywords[selection[0].row];
	var currentDate = new Date();
	var selectTime = currentDate.getTime() - ($('#selectDate').val()-1)*24*3600*1000;
	currentDate.setTime(selectTime);

	var params = {};
	var prefix = 'mmn';
	if (model == 'MainMediaComment'){
		prefix = 'mmc';
	}
	params[model+'[dateStart]'] = currentDate.toDateString();
	params[model+'['+prefix+'Title]'] = keyword.word;
	params[model+'[sortOrder]'] = 1;
	
	var selectType = $('#top10Form input[name="type"]:checked');
	if (selectType.val() == 'home'){
		params[model+'['+prefix+'IsAbroad]'] = 0;

	} else if (selectType.val() == 'abroad'){
		params[model+'['+prefix+'IsAbroad]'] = 1;
	}

	$(".popupBoxCove").css({opacity:'0.5',width:$(document).width(),height:$(document).height(),display:'block'});
	$(".TcBox").css({left:($(window).width()-800)/2+'px',top:($(window).height()-461)/2+$(document).scrollTop()+'px',display:'block'});
	$("#boxTable").html($(".centerImg").clone());

	getRequestData(requestUrl, params, 'post', searchToHtml);
}

//格式化弹出层列表
function searchToHtml(response)
{
	var selection = chart.getSelection();
	if (!selection.length){
		return ;
	}
	var keyword = currentKeywords[selection[0].row];

	var selectType = $('#top10Form input[name="type"]:checked');
	var listTag = '所有';
	switch(selectType.val()) {
		case 'home' :
			listTag = '境内';
			break;
		case 'abroad' :
			listTag = '境外';
			break;
	}

	//弹出框标题
	var boxTitle = '<span class="title">主流媒体舆情 - '+(response.type=='news'?'热点涉穂新闻':'热点涉穂评论')+'</span>';
	boxTitle += '<span class="close"><a href="###" onclick="coveTableColse()"></a></span>';
	$('#boxTitle').html(boxTitle);

	//表格列表
	var boxTable = '<tr><th align="center" width="35%">标题</th><th align="center" width="7%">转载量</th><th align="center" width="17%">最近转载</th><th align="center" width="10%">网站</th><th align="center" width="7%">境内/外</th><th align="center" width="15%">发布时间</th><th align="center" width="9%">操作</th></tr>';
	if (response.data && response.data.length > 0){
		for(var i=0; i<response.data.length; i++) {
			boxTable += '<td title="'+response.data[i].fullTitle+'" align="center"><div class="pTitle"><a target="_blank" href="'+response.data[i].url+'">'+response.data[i].title+'</a></div></td>';
			boxTable += '<td align="center">'+response.data[i].reserved+'</td>';
			boxTable += '<td align="center">'+response.data[i].reservedTime+'</td>';
			boxTable += '<td align="center">'+response.data[i].site+'</td>';
			boxTable += '<td align="center">'+response.data[i].source+'</td>';
			boxTable += '<td align="center">'+response.data[i].date+'</td>';
			boxTable += '<td align="center"><div class="mainstreamTableBnt">';
			boxTable += '<span class="bntLeft"><a onclick="return coveDiv(this);" href="'+response.data[i].updateUrl+'"></a></span>';
			boxTable += '</div></td></tr>';
		}
		$('#boxTable').html(boxTable);
	}
	
	//分页信息
	searchPageToHtml(response.page);
}

//格式化分页信息
function searchPageToHtml(page)
{
	var pageContent = '';
	if (page.total > 0){
		//上一页
		if (page.current <= 1){
			pageContent += '<span class="up"><a href="###"></a></span>';

		} else {
			pageContent += '<span onclick="clickTheColumnChart('+(page.current>1 ? page.current-1 : 1)+')" class="up"><a href="###"></a></span>';
		}

		for(var i=1; i<=page.count && i<=4; i++) {
			if (page.current == i){
				pageContent += '<span><a class="act" href="###"> </a></span>';

			} else {
				pageContent += '<span onclick="clickTheColumnChart('+i+')"><a href="###"> </a></span>';
			}
		}

		//下一页
		if (page.current >= 4){
			pageContent += '<span class="next"><a href="###"></a></span>';

		} else {
			pageContent += '<span onclick="clickTheColumnChart('+(page.current<page.count ? page.current+1 : page.count)+')" class="next"><a href="###"></a></span>';
		}
	}

	$('#boxPage').html(pageContent);
}

//关闭弹出框
function coveTableColse()
{
	$(".popupBoxCove").css({display:'none'});
	$(".TcBox").css({display:'none'});
}


//弹出框居中(信息纠错部分)
function coveDiv(e){
	$(".popupBoxCove").css({opacity:'0.5',width:$(document).width(),height:$(document).height(),display:'block'});
	$(".popupBoxXX").appendTo($('body'));
	$(".popupBoxXX").css({left:($(window).width()-308)/2+'px',top:($(window).height()-310)/2+$(document).scrollTop()+'px',display:'block'});	
	$('.popupBoxConXXSpanRT textarea').val('');
	$('.popupBoxBntXX .bntLeft').unbind('click');
	$('.popupBoxBntXX .bntLeft').bind('click',function(){
		return coveSubmit(e);
	});
	return false;
}

//关闭弹出框
function coveColse(){
	//$(".popupBoxCove").css({opacity:'0',display:'none'});
	$(".popupBox").css({display:'none'});	
	$(".popupBoxXX").css({display:'none'});
	$('.popupBoxConXXSpanR select option').attr("selected", false);
	$('.popupBoxConXXSpanR select option[value=1]').attr("selected", true);
	return false;
}

//提交
function coveSubmit(e){
	var url  = e.href;
	var icmUUID = $(e).parent().siblings('input').val();
	var objParams = {};
	objParams['InfoCorrectionManage'] = {};
	objParams['InfoCorrectionManage']['ietId'] = $('.popupBoxConXXSpanR select').val();			//错误类型ID
	objParams['InfoCorrectionManage']['icmRemarks'] = $('.popupBoxConXXSpanRT textarea').val();	//纠错备注

	$.ajax({
		type : 'post',
		url : url,
		data : objParams,
		dataType : 'json',
		error:function(){return false;},
		success : function(response) {
			if (response != null) {
				coveChange(response);
			}
		}
	});
	return false;
}


//提交后反馈
function coveChange(response){
	if(response[0] == '1'){
		$(".popupBox").find(".popupBoxCon").html("成功添加到舆情研判");
		$(".popupBoxCove").css({opacity:'0.5',width:$(document).width(),height:$(document).height(),display:'block'});
		$(".popupBox").css({left:($(window).width()-308)/2+'px',top:($(window).height()-280)/2+$(document).scrollTop()+'px',display:'block'});	
		$(".popupBoxXX").css({display:'none'});
	}else if(response[0] == '0'){
		$(".popupBox").find(".popupBoxCon").html("该信息已存在，不能重复添加");
		$(".popupBoxCove").css({opacity:'0.5',width:$(document).width(),height:$(document).height(),display:'block'});
		$(".popupBox").css({left:($(window).width()-308)/2+'px',top:($(window).height()-280)/2+$(document).scrollTop()+'px',display:'block'});	
		$(".popupBoxXX").css({display:'none'});
	}		
}

