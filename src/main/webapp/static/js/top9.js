//获取数据列表
var params='';
var objParams = {};
var re = new RegExp("[0-9\-]+","g");
function getItemVal(pageGo)
{
	
	//获取表单
	var objForm = $('form')[1];
	//通过获取日期
	var rangDate = $('#widgetField span').html().match(re);
	//准备参数：搜索条件
	objParams = {};
	objParams[$('#sortOrder').attr('name')] = $('#sortOrder').val();
	objParams['TopNineMedia[start]'] = rangDate[0];
	objParams['TopNineMedia[end]'] = rangDate[1];
	
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
	//获取排序方式
	objParams[$('#sortOrder').attr('name')] = $('#sortOrder').val();
	var requestUrl = $(objForm).attr('action').toString();
	//设置分页地址
	var max = $("#maxPage").html() == null || isNaN($("#maxPage").html()) ||  parseInt($("#maxPage").html()) == 0 ? 1 : parseInt($("#maxPage").html());
	
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
		
		//$('#pageContainer').hide();
		$('#tableContainer').hide();
		$('#loading').show();
	$.ajax({
		type : method,
		url : url,
		data : params,
		dataType : 'json',
		success : function(data) {
			$('#loading').hide();
			$('#pageContainer').show();
			$('#tableContainer').show();
			handle(data);
		}
	});
}

//格式化分页信息
function pageToHtml(page)
{
	var pageContent = '<div class="tablePageRight">';

	if (page.total > 0){
		//上一页
		pageContent += '<span>第</span><span><input id="pageGo" type="text" value='+page.current+' /></span><span>页</span>';
		pageContent += '<span onclick="getItemList($(\'#pageGo\').val())"><a href="###"></a></span></div>';

		pageContent += '<div class="tablePageNum">';
		if (page.current > 1){
			pageContent += '<span onclick="getItemList('+(page.current>1 ? page.current-1 : 1)+')" class="up"><a href="###"></a></span>';
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
			pageContent += '<span onclick="getItemList('+(page.current<page.count ? page.current+1 : page.count)+')" class="next"><a href="###"></a></span>';
		} else {
			pageContent += '<span class="nextend"><a href="###"></a></span>';
		}
	}

	pageContent += '</div>';

	$('#pageInfo').html('<span>共有<tt>'+page.total+'</tt>条记录</span> <span>共有<tt id="maxPage">'+page.count+'</tt>页</span>');
	$('#pageContainer').html(pageContent);
}

//格式化搜索列表
function dataToHtml(response)
{
	var tableHeader = '<tr><th align="center" width="35%">标题</th><th align="center" width="9%">转载量</th><th align="center" width="18%">最近转载</th><th align="center" width="9%">网站</th><th align="center" width="18%">发布时间</th><th align="center" width="9%">操作</th></tr>';
	var tableContent = '';
	if (response.data && response.data.length > 0){
		for(var i=0; i<response.data.length; i++) {
			tableContent += '<td title="'+response.data[i].fullTitle+'" align="center" width="35%"><div class="pTitle"><a target="_blank" href="'+response.data[i].url+'" title="'+response.data[i].fullTitle+'">'+response.data[i].title+'</a></div></td>';
			tableContent += '<td align="center" width="9%">'+response.data[i].reserved+'</td>';
			tableContent += '<td align="center" width="18%">'+response.data[i].updateTime+'</td>';
			tableContent += '<td align="center" width="9%">'+response.data[i].wsmId+'</td>';
			tableContent += '<td align="center" width="18%">'+response.data[i].date+'</td>';
			tableContent += '<td align="center" width="9%"><div class="mainstreamTableBnt">';
			tableContent += '<span class="bntLeft"><a href="'+response.data[i].updateUrl+'" onclick="return coveDiv(this);"></a></span>';
			tableContent += '</div></td></tr>';
		}
	}

	pageToHtml(response.page);
	$('#tableContainer').html(tableHeader+tableContent);

}
		
//弹出框居中
function coveDiv(e){

	$(".popupBoxCove").css({opacity:'0.5',width:$(document).width(),height:$(document).height(),display:'block'});
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
	$(".popupBoxCove").css({opacity:'0',display:'none'});
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