<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>
<script type="text/javascript" src="${ctx}/static/js/site.js"></script>
<script type="text/javascript">
//格式化HTML
function dataToHtml(response)
{
	var tableHeader = '<tr><th align="center" width="7%">ID</th><th align="center" width="18%">采集点名称</th><th align="center" width="10%">来源类别</th><th align="center" width="12%">所属站点</th><th align="center" width="10%">采集权重</th><th align="center" width="10%">是否开启</th><th align="center" width="18%">最后采集</th><th align="center" width="15%">操作</th></tr>';

	var tableContent = '';
	if (response.data.length > 0){
		for(var i=0; i<response.data.length; i++) {
			tableContent += '<tr><td class="number" align="center" width="7%">'+response.data[i].id+'</td>';
			tableContent += '<td align="center" width="18%">'+response.data[i].name+'</td>';
			tableContent += '<td align="center" width="10%">'+response.data[i].type+'</td>';
			tableContent += '<td align="center" width="12%">'+response.data[i].site+'</td>';
			tableContent += '<td align="center" width="10%">'+response.data[i].weight+'</td>';
			tableContent += response.data[i].status==1 ? '<td class="normal" align="center" width="8%">开启</td>' : '<td class="close" align="center" width="10%">关闭</td>';
			tableContent += '<td align="center" width="18%">'+response.data[i].time+'</td>';
			tableContent += '<td align="center" width="15%"><div class="tableListDivTableBnt">';
			tableContent += '<span class="bntLeft"><a href="'+response.data[i].updateUrl+'"></a></span>';
			tableContent += '<span class="bntRight"><a onclick="return itemToDelete('+response.page.current+',\''+response.data[i].deleteUrl+'\')" href="###"></a></span>';
			tableContent += '</div></td></tr>';
		}
	}

	pageToHtml(response.page)
	$('#tableContainer').html(tableHeader+tableContent);

}

//初始化请求
$(function(){
	var initPageInfo = window.location.toString().match(/page(=|\/)([0-9]+)/);
	getItemList(initPageInfo ? initPageInfo[2] : 0);
});
</script>

</head>
<body>
<div class="con">
<!-- topNav start -->
	<div class="topNav">
		<div class="navDiv"><a href="/mainMedia/index" >主流媒体舆情</a></div>
		<div class="navDiv"><a href="/warning/index" >舆情预警</a></div> 
		<div class="navDiv"><a href="/cityRecognize/index" >城市形象与认知度</a></div>
		<div class="navDiv"><a href="/leaderRecognition/index" >舆论领袖识别</a></div>
		<div class="navDiv"><a href="/knowledgeDictLibManage/index" >知识库管理</a></div>
		<div class="navDiv act"><a href="/systemManage/index" >系统管理</a></div>
	</div>
<!-- topNav end -->

<!-- table content start -->
	<div class="tableContent">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<td valign="top">
				<div class="tableContentLeft">
					<div class="navTitle"><a href="/systemManage/index" >系统管理</a></div>
					<div class="navSubTitle"><a href="/systemManage/toSiteManage" >站点管理</a></div>
					<div class="navSupTitle"><a href="/systemManage/toAddSite" ><span>添加站点</span></a></div>
					<div class="navSupTitle"><a href="/systemManage/statistics" ><span>信息统计</span></a></div>
					
					<div class="navSubTitle"><a class="act" href="/systemManage/toGatherManage" >采集点管理</a></div>
					<div class="navSupTitle"><a href="/systemManage/toAddGather" ><span>添加采集点</span></a></div>
					
					<div class="navSubTitle"><a href="/systemManage/personalCenter" >个人中心</a></div>
					<div class="navSupTitle"><a href="/systemManage/toChangePass" ><span>更改密码</span></a></div>
					<div class="navSupTitle"><a href="/systemManage/toEditUser" ><span>修改信息</span></a></div>
					
					<div class="navSubTitle"><a href="/systemManage/toUserManage" >用户管理</a></div>
					<div class="navSupTitle"><a class="" href="/systemManage/toAddUser" ><span>添加用户</span></a></div>
				</div>
			</td>
			<td class="tdBak" valign="top">
				<div class="tableContentRight">
					<div class="currentPosition">
					&nbsp;&nbsp;&nbsp;&nbsp;当前位置：&nbsp;&nbsp;<a href="/systemManage/index" >系统管理</a>&nbsp;>&nbsp;<a href="/systemManage/toGatherManage" >采集点管理</a>&nbsp;>&nbsp;采集点列表
					</div>
				
				<!-- 页面内容 start -->
				
<form action="/webGatherNode/search" method="post" id="form">
<div class="systemSearch">
	<span>所属站点：</span>
	<span class="systemSearchLeft">
		<select id="webSiteID" class="select" name="webSiteID">
				<option value="">--</option>
				<c:forEach items="${webSiteNameList}" var="types">
					<option <c:if test="${types.key eq webSiteID}">selected="selected"</c:if> value="${types.key}">${types.value}</option>
				</c:forEach>
		</select>
	</span>
	<span class="space1">来源类别：</span>
	<span class="systemSearchRight">
		<select id="wgnType" class="select" name="wgnType">
				<option value="">--</option>
				<option value="1">新闻类</option>
				<option value="2">评论类</option>
				<option value="3">微博类</option>
				<option value="4">论坛类</option>
				<option value="5">博客类</option>
		</select>
	</span>
	<span class="input">
		<input id="wgnName" type="text" value="" maxlength="255" name="wgnName" />
	</span>
	<span class="img"><a href="###" onclick="return getItemList(0)">&nbsp;</a></span>
</div>
</form>

<div class="clear"></div>

<div class="tableListDiv">
	<div class="tableListDivNav">
		<!-- 分页统计 start -->
		<div id="pageInfo" class="tableListDivNavLeft"></div>
		<!-- 分页统计 end -->
		<div class="tableListDivNavRight">
			<a href="/systemManage/toAddGather"></a>
		</div>
	</div>
	<div class="tableListDivTable">
		<table id="tableContainer" cellpadding="0" cellspacing="0"></table>

		<!-- 分页 start -->
		<div id="pageContainer" class="tablePage"></div>
		<!-- 分页 end -->
	</div>
</div>
				
				<!-- 页面内容  end -->
				</div>
			</td>
		</tr>
	</table>
	</div>
<!-- table content end -->
</div>

<%@include file="../bottom.jsp"%>
</body>
</html>
