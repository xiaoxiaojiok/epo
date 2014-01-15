<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@include file="../top.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>

<script type="text/javascript"> 
function todo(url){
	document.getElementById("middleFrame").src = url;
}
</script>

</head>
<body>
<div class="con">
<!-- topNav start -->
	<div class="topNav">
		<div class="navDiv act"><a href="/mainMedia/index" >主流媒体舆情</a></div>
		<div class="navDiv"><a href="/warning/index" >舆情预警</a></div> 
		<div class="navDiv"><a href="/cityRecognize/index" >城市形象与认知度</a></div>
		<div class="navDiv"><a href="/leaderRecognition/index" >舆论领袖识别</a></div>
		<div class="navDiv"><a href="/knowledgeDictLibManage/index" >知识库管理</a></div>
		<div class="navDiv"><a href="/systemManage/index" >系统管理</a></div>
	</div>
<!-- topNav end -->

<!-- table content start -->
	<div class="tableContent">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<td valign="top">
				<div class="tableContentLeft">
					<div class="navTitle"><a href="/mainMedia/index" >主流媒体概况</a></div>
					<div class="navSubTitle"><a href="/mainMedia/mainMediaInOutNews" >境内外涉穂新闻</a></div>
					<div class="navSubTitle"><a href="/mainMedia/mainMediaInOutComments" >境内外涉穂评论</a></div>
					<div class="navSubTitle"><a href="/mainMedia/mainMediaHotNews" >热点涉穂新闻</a></div>
					<div class="navSubTitle"><a class="act" href="/mainMedia/mainMediaHotComments" >热点涉穂评论</a></div>
					<div class="navSubTitle"><a href="/mainMedia/mainMediaTopNineSite" >九大网站关注度</a></div>
					<div class="navSubTitle"><a href="/mainMedia/mainMediaRegionConcern" >区县关注度</a></div>
					<div class="navSubTitle"><a href="/mainMedia/mainMediaNowNews" >实时新闻舆情</a></div>
				</div>
			</td>
			<td class="tdBak" valign="top">
				<div class="tableContentRight">
					<div class="currentPosition">
					&nbsp;&nbsp;&nbsp;&nbsp;当前位置：&nbsp;&nbsp;主流媒体舆情&nbsp;>&nbsp;热点涉穂评论
					</div>

				
	    		
				<!-- 页面内容 start -->
				
				热点涉穂评论
				
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
