/********************************** 列表页 ******************************************/
//获取数据列表
function getItemList(pageGo)
{
	//获取表单
	var objForm = $('form')[0];
	
	//准备参数：搜索条件
	var objParams = {};
	var params = $(objForm).find('input,select');
	for(var i=0; i<params.length; i++) {
		if ($(params[i]).val() != '') {
			objParams[$(params[i]).attr('name')] = $(params[i]).val();
		}
	}

	var requestUrl = $(objForm).attr('action').toString();
	//设置分页地址
	if (pageGo > 0){
		var requestUrl = requestUrl.indexOf('?') == -1 ? requestUrl+'?page='+pageGo : requestUrl+'&page='+pageGo;
	}

	//异步请求数据
	getRequestData(requestUrl, objParams);
	
	return false;
}

//异步请求数据
function getRequestData(url, params)
{
	$.ajax({
		type : 'post',
		url : url,
		data : params,
		dataType : 'json',
		success : function(data) {dataToHtml(data);}
	});
}

//格式化分页信息
function pageToHtml(page)
{
	var pageContent = '<div class="tablePageRight">';
	pageContent += '<span>第</span><span><input id="pageGo" type="text" /></span><span>页</span>';
	pageContent += '<span onclick="return getItemList($(\'#pageGo\').val())"><a href="###"></a></span></div>';

	pageContent += '<div class="tablePageNum">';
	pageContent += '<span '+(page.current>1 ? 'onclick="return getItemList('+(page.current-1) +')" class="up"><a href="###"></a></span>': 'class="up"><a></a></span>'); 
	
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
			pageContent += '<span onclick="return getItemList('+i+')" class="normal"><a href="###">'+i+'</a></span>';
		}
	}

	pageContent += '<span '+(page.current<page.count ? 'onclick="return getItemList('+(page.current+1) +')" class="next"><a href="###"></a></span>': 'class="next"><a></a></span>'); 
	pageContent += '</div>';

	$('#pageInfo').html('<span>共有<tt>'+page.total+'</tt>条记录</span> <span>共有<tt>'+page.count+'</tt>页</span>');
	$('#pageContainer').html(pageContent);
}

//删除站点
function itemToDelete(current,url) {
	if (confirm('如果删除该站点，将不可恢复，请确认？')){
		$.ajax({
		  type: 'POST',
		  url: url,
		  success: function(){getItemList(current);},
		  dataType: 'html'
		});
	} 
	return false;
}

/********************************** 表单页 ******************************************/

//检查唯一性
function checkUnique(obj,url,uniqueId)
{
	if ($(obj).val() == '') {
		return ;
	}

	var params = {};
	params[$(obj).attr('name')] = $(obj).val();
	$.ajax({
		type : 'post',
		url : url,
		data : params,
		dataType : 'json',
		success : function(data) {checkError(data,$(obj).attr('id'),uniqueId);}
	});
}

//重置提示信息
function resetMessage(attribute)
{
	if (attribute != '') {
		$('textarea[id$="'+attribute+'"], input[id$="'+attribute+'"]').parents('.addPointInputBox').find('.inputPrompt').remove();

	} else {
		$('.inputPrompt').remove();
	}
	
}

//验证错误信息
function checkError(data,attribute,uniqueId)
{
	if (data == null){
		resetMessage(attribute);
		return ;
	}
	
	if (uniqueId == '' || data.id != parseInt(uniqueId)){
		var message = {};
		message[attribute] = '已存在，<a href="'+data.url+'">点击更新</a>';
		
		responseMessage(message);
	}

}

//显示错误信息
function responseMessage(data)
{
	var message = '';
	for (k in data){
		var container = $('textarea[id$="'+k+'"], input[id$="'+k+'"]').closest('.addPointInputBox');
		if (container.length == 0){
			message += data[k];

		} else if (container.find('.inputPrompt').length) {
			container.find('.inputPrompt').html(data[k]);

		} else {
			container.append('<span class="inputPrompt">'+data[k]+'</span>');
		}
	}
	
	if (message != ''){
		//alert(message);
	}
}

//提示框
function messageContent(display,data)
{
	if (display == 1){
		//显示提示框
		$('.restate span').html($('.restate img'));
		$('.restate span').append(data);
		$('.restate').show();	

	} else {
		$('.restate').hide();
	}
}