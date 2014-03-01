<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>
<script type="text/javascript" src="${ctx}/static/easyui/jquery-1.8.0.min.js"></script>
<link type="text/css"  href="${ctx }/static/style/css.css" rel="stylesheet"/>
<link type="text/css"  href="${ctx }/static/style/datepicker.css" rel="stylesheet"/>
<script type="text/javascript" src="${ctx }/static/js/blog.js"></script>
<script type="text/javascript" src="${ctx }/static/js/eye.js"></script>

</head>
<body>

<div class="monitorCon">
	<div class="monitorTopBox">
<!-- top start -->
		<div class="monitorTitle">
			<span class="aTitle">舆情预警</span>
			<span class="bTitle">热点涉穂帖子</span>
		</div>

		<div class="monitorInput widthRT1">
			<span class="wh1">时间：</span>
			<span class="wh21">
				<select name='day' id='day'>
					<option value=1>1天</option>
					<option value=7>7天</option>
					<option value=14>14天</option>
					<option value=30>30天</option>
				</select>
			</span>

				<span class="wh1 space0">来源：</span>
				<span class="inputDiv2 inputDiv4">
				<select id="site" class="select" name="site" style="width:120px">
				<option value="">所有</option>
				<c:forEach items="${webSiteNameList}" var="types">
					<option value="${types.key}">${types.value}</option>
				</c:forEach>
				</select>
				</span>

			<span class="wh1 space0">排序：</span>
			<span class="wh21">
				<select name='TopPage' id='TopPage'>
					<option value='1'>1-10</option>
					<option value='2'>11-20</option>
				</select>
			</span>
		</div>
		<div class="clear"></div>
<!-- top end -->
	</div>

<!-- content start -->
	<div class="monitorDiv">
<!-- table list start -->	
<div class="tableListBox" id='tableListBox'>

</div>
<!-- table list end -->
	</div>
<!-- content end -->

</div>
<script>
//TOP20排序JS
$('#TopPage').live("change",function(){
	if($('#TopPage').attr('value')==1){
		$('#Top1').show();
		$('#Top2').hide();
	}else{
		$('#Top1').hide();
		$('#Top2').show();
	}
});
//TOP20ajax
loading('#tableListBox');
$.ajax({
	type: "post",
	url: "/forum/forumIndex",
	data: 'day=1&monitor=1',
	dataType:"json",
	success: function(json){
		putForum(json);
	},
	error: function(){
		alert("请求错误");
	}
});


	//Top20 change ajax
	$('[name=site],#day').live("change",function() {
		var ajaxData='';
		ajaxData='day' +"="+$('[name=day]').attr('value');
		if($('[name=site]').attr('value')!==''){
			ajaxData+='&site'+"="+$('[name=site]').attr('value');
		}
		ajaxData+='&monitor=1';
		//排序效果
		loading('#tableListBox');
		$.ajax({
				type: "post",
				url: "/forum/forumIndex",
				data: ajaxData,
				dataType:"json",
				success: function(json){
					putForum(json);
				},
				error: function(){
					alert("请求错误");
				}
			});
	});
	
	function loading(id){
		var loading='<div class="centerImg centerImgH" style="margin-top:100px;"><img src="/static/images/loadingBig.gif" /></div>';
		$(id).html(loading);
	}
	
	function putForum(data){
		
		loading('#tableListBox');
		if(data==''){
			setTimeout(function(){nonum('tableListBox')},500);
		}else{
			var forumList='';
			forumList+='<div id="Top1">';
			for(e in data){
				var num=parseInt(e)+1;
				if(e==10){
					forumList+='</div>';
					forumList+='<div id="Top2">';
				}
				forumList+='<div class="tableList tableListHei">';
				forumList+='<table cellpadding="0" cellspacing="0">';
				forumList+='<tr>';
				if(num<=4){
					forumList+='<td valign="bottom"><div class="newsCount newsCount4">'+num+'</div></td>';
					forumList+='<td class="PeopleBorder2">';
				}else{
					forumList+='<td valign="bottom"><div class="newsCount">'+num+'</div></td>';
					forumList+='<td class="PeopleBorder1 PeopleBorder1C">';
				}
				forumList+='<div class="newsDocket PeopleDocket2"><a href="'+data[e].url+'" target="_blank" title="'+data[e].fullTitle+'">'+data[e].title+'</a></div>';
				forumList+='<div class="sumTime">';
				forumList+='<span class="reprint clubReprint PeopleTimeMbnAdd">回复：<tt>'+data[e].reply+'</tt></span>';
				forumList+='<span class="soucre clubsoucre PeopleTimeMbnAdd">查看：<tt>'+data[e].view+'</tt></span>';
				forumList+='<div class="clear"></div>';
				forumList+='<span class="soucre PeopleTimeMbnLaiy">网站：<tt>'+data[e].site+'</tt></span>';
				forumList+='<span class="time PeopleTimeMCO PeopleTimeMbnAdd">时间：<tt>'+data[e].date+'</tt></span>';
				forumList+='</div>';
				forumList+='</td>';
				forumList+='</tr>';
				forumList+='</table>';
				forumList+='</div>';
			}
			forumList+='</div>';

			//切换效果
			
			setTimeout(function(){
				$('#tableListBox').html(forumList)
				$('#Top1').show();
				$('#Top2').hide();
				$('#TopPage').val(1);
				if(data=='' || data.length<11){
					$('#TopPage option:last').hide();
				}else{
					$('#TopPage option:last').show();
				}
			},500);
		
		}
	}
	
	function nonum(boxid)
	{
		$("#"+boxid).html('<div class="centerImg centerImgH" style="margin-top:100px;"><img class="nonum" src="/static/images/nonum.jpg" /></div>');
	}
	
</script>

</body>
</html>