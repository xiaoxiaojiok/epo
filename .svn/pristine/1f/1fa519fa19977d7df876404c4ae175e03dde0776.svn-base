/********************************** 列表页 ******************************************/
//获取数据列表
function getItemList(pageGo)
{
	//获取表单
	var objForm = $('#searchWarning');
	
	//准备参数：搜索条件
	var objParams = {};
	if($("#GatherWarningRecord_gwrId").val()>0){
		objParams['GatherWarningRecord[gwrId]']=$("#GatherWarningRecord_gwrId").val();
	}else{
		var params = $(objForm).find('input[type="hidden"],select');
		for(var i=0; i<params.length; i++) {
			if ($(params[i]).val() != '') {
				objParams[$(params[i]).attr('name')] = $(params[i]).val();
			}
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
		success : function(data) {dataToHtml(data)}
	});
}

//格式化分页信息
function pageToHtml(page)
{
	var pageContent = '<div class="tablePageRight">';
	pageContent += '<span>第</span><span><input id="pageGo" type="text" /></span><span>页</span>';
	pageContent += '<span onclick="return getItemList($(\'#pageGo\').val())"><a href="###"></a></span></div>';

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
			pageContent += '<span onclick="return getItemList('+i+')" class="normal"><a href="###">'+i+'</a></span>';
		}
	}

	if(page.current<page.count){
		pageContent += '<span onclick="getItemList('+(page.current+1)+')" class="next"><a href="###"></a></span>';
	}else{
		pageContent += '<span class="nextend"><a href="###"></a></span>';
	}
	pageContent += '</div>';

	$('#pageInfo').html('<span>共有<tt>'+page.total+'</tt>条记录</span> <span>共有<tt>'+page.count+'</tt>页</span>');
	$('#pageContainer').html(pageContent);
}

//格式化HTML
function dataToHtml(response)
{
	var tableHeader='<tr>';
	tableHeader+='<th align="center" width="20%">采集点名称</th>';
	tableHeader+='<th align="center" width="10%">来源类别</th>';
	tableHeader+='<th align="center" width="15%">所属站点</th>';
	tableHeader+='<th align="center" width="8%">级别</th>';
	tableHeader+='<th align="center" width="15%">产生时间</th>';
	tableHeader+='<th align="center" width="15%">最近报警时间</th>';
	tableHeader+='<th align="center" width="17%">操作</th>';
	tableHeader+='</tr>';

	var tableContent = '';
	var levelClass='';
	var levelname='';
	
	if(response.data!=undefined){
		if (response.data.length > 0){
			for(var i=0; i<response.data.length; i++) {

				if(response.data[i].level==1){
					levelClass='oneSty';
					levelName='一级';
				}

				if(response.data[i].level==2){
					levelClass='twoSty';
					levelName='二级';
				}

				if(response.data[i].level==3){
					levelClass='threeSty';
					levelName='三级';
				}

				tableContent += '<tr>';
					tableContent += '<td align="center" width="20%">'+response.data[i].name+'</td>';
					tableContent += '<td align="center" width="10%">'+response.data[i].type+'</td>';
					tableContent += '<td align="center" width="15%">'+response.data[i].web+'</td>';
					tableContent += '<td class="'+levelClass+'" align="center" width="8%">'+levelName+'</td>';
					tableContent += '<td align="center" width="15%">'+response.data[i].time+'</td>';
					tableContent += '<td align="center" width="15%">'+response.data[i].recentTime+'</td>';
					tableContent += '	<td align="center" width="17%">';
						tableContent += '<div class="tableListDivTableBntSty tableListDivTableBntStyAct">';
							tableContent += '<span class="bntLeft"><a href="###" onclick="showLine('+response.data[i].wgnId+',\''+response.data[i].name+'\')"></a></span>';
							tableContent += '<span onclick="handle('+response.data[i].id+')" class="bntRight '+(response.data[i].status=='是' ? 'bntRightAct' : '')+'"><a href="###"></a></span>';
						tableContent += '</div>';
					tableContent += '</td>';
				tableContent += '</tr>';
			}
		}
	}

	pageToHtml(response.page);
	$('#tableContainer').html(tableHeader+tableContent);

}

//初始化请求
$(function(){
	getItemList(0);
});



