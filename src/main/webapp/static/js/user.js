/********************************** 列表页 ******************************************/
//获取数据列表
function getItemList(pageGo)
{
	//获取表单
	var objForm = $('form');
	
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
		success : function(data) {handle(data);}
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
		if(page.current>1){
			pageContent += '<span onclick="getItemList('+(page.current-1)+')" class="up"><a href="###"></a></span>';
		}else{
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

		if(page.current<page.count){
			pageContent += '<span onclick="getItemList('+(page.current+1)+')" class="next"><a href="###"></a></span>';
		}else{
			pageContent += '<span class="nextend"><a href="###"></a></span>';
		}
	}

	pageContent += '</div>';

	$('#pageInfo').html('<span>共有<tt>'+page.total+'</tt>条记录</span> <span>共有<tt>'+page.count+'</tt>页</span>');
	$('#pageContainer').html(pageContent);
}

//格式化新闻或评论列表
function dataToHtml(response)
{
	var tableHeader='';
	tableHeader+='<tr><th align="center" width="6%">ID</th>';
	tableHeader+='<th align="center" width="12%">用户名</th>';
	tableHeader+='<th align="center" width="12%">用户昵称</th>';
	tableHeader+='<th align="center" width="12%">用户级别</th>';
	tableHeader+='<th align="center" width="16%">最后登录时间</th>';
	tableHeader+='<th align="center" width="16%">最后登录IP</th>';
	tableHeader+='<th align="center" width="26%">操作</th></tr>';

	var tableContent = '';

	if (response.data && response.data.length > 0){
		for(var i=0; i<response.data.length; i++) {

			tableContent += '<tr>';
			tableContent += '<td class="number" align="center" width="6%">'+response.data[i].id+'</td>';
			tableContent += '<td align="center" width="12%">'+response.data[i].name+'</td>';
			tableContent += '<td align="center" width="12%">'+response.data[i].nickname+'</td>';
			tableContent += '<td align="center" width="12%">'+response.data[i].type+'</td>';
			tableContent += '<td align="center" width="16%">'+response.data[i].lastTime+'</td>';
			tableContent += '<td align="center" width="16%">'+response.data[i].lastIp+'</td>';
			tableContent += '<td align="center" width="26%">';
			tableContent += '<div class="tableListDivTableBnt userManagement">';
			tableContent += '<span class="bntLeft"><a href="'+response.data[i].updateUrl+'"></a></span>';
			tableContent += '<span class="bntMidden"><a onclick="coveDiv('+response.page.current+','+response.data[i].id+',\'密码重置后，原来密码将不能使用，你确认要重置密码\',\'reset\')"></a></span>';
			tableContent += '<span class="bntRight"><a onclick="return coveDiv('+response.page.current+','+response.data[i].id+',\'确认要删除用户'+response.data[i].name+'?\',\'delete\')"></a></span>';
			tableContent += '</div>';
			tableContent += '</td>';
			tableContent += '</tr>';
		}
	}

	pageToHtml(response.page);
	$('#tableContainer').html(tableHeader+tableContent);
}


