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
<script type="text/javascript" src="${ctx }/static/js/topic.js"></script>
<script type="text/javascript" src="${ctx }/static/js/eye.js"></script>

</head>
<body>

<div class="monitorCon">
	<div class="monitorTopBox">
<!-- top start -->
		<div class="monitorTitle">
			<span class="aTitle">主流媒体舆情</span>
			<span class="bTitle">新闻热点话题</span>
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
			<!--  
			<span class="wh1 space0">来源：</span>
			<span class="wh21">
				<select id="site" class="select" name="site">
				<option value="">所有</option>
				<option value="18">境内</option>
				<option value="19">境外</option>
				</select>
			</span>
			-->
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
	url: "/topic/topicIndex",
	data: 'day=1&monitor=1',
	dataType:"json",
	success: function(json){
		putWeibo(json);
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
				url: "/topic/topicIndex",
				data: ajaxData,
				dataType:"json",
				success: function(json){
					putWeibo(json);
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
	
	function putWeibo(data){
		loading('#tableListBox');
		if(data==''){
			setTimeout(function(){nonum('tableListBox')},500);
		}else{
			var weiboList='';
			weiboList+='<div id="Top1">';
			for(e in data){
					var num=parseInt(e)+1;
					if(e==10){
						weiboList+='</div>';
						weiboList+='<div id="Top2">';
					}
					weiboList+='<div class="tableList tableListMB">';
					weiboList+='<table cellpadding="0" cellspacing="0">';
					weiboList+='<tr>';
						if(num<=4){
							weiboList+='<td valign="bottom"><div class="newsCount newsCount4">'+num+'</div></td>';
							weiboList+='<td class="PeopleBorder2">';
						}else{
							weiboList+='<td valign="bottom"><div class="newsCount">'+num+'</div></td>';
							weiboList+='<td class="PeopleBorder1 PeopleBorder1C">';
						}
					weiboList+='<div class="newsDocket PeopleDocket2Mb"><a href="'+data[e].url+'" title="'+data[e].fullContent+'" target="_blank">';
						if(data[e].wsmId == $($('#site option')[1]).val()){
							//weiboList+='<img src="/static/images/xinlang.gif" />';
						}else{
							//weiboList+='<img src="/static/images/tx.gif" />';
						}
					weiboList+=data[e].content+'</a></div>';
					weiboList+='<div class="sumTime">';
					weiboList+='<span class="reprint clubReprint PeopleTimeMbnAdd">评论数：<tt>'+data[e].mmnReserved+'</tt></span>';
					weiboList+='<span class="soucre clubsoucre PeopleTimeMbnAdd">关联新闻数：<tt>'+data[e].ftorwarding+'</tt></span>';
					weiboList+='</div>';
					weiboList+='<div class="sumTime">';
					weiboList+='<span class="soucre PeopleTimeMbnLaiy">关键字：<tt><a title='+data[e].author+'>'+data[e].author+'</a></tt></span>';
					weiboList+='<span class="time PeopleTimeM PeopleTimeMbnLaiy">时间：<tt>'+data[e].date+'</tt></span>';
					weiboList+='</div>';
					weiboList+='</td>';
					weiboList+='</tr>';
					weiboList+='</table>';
					weiboList+='</div>';
				}
				weiboList+='</div>';

				setTimeout(function(){
					$('#tableListBox').html(weiboList)
					$('#Top1').show();
					$('#Top2').hide();
					$('#TopPage').val(1);
					if(data=='' || e<10){
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