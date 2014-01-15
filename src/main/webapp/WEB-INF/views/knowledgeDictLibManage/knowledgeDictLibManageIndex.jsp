<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>

<script type="text/javascript"> 
function todo(url){
	parent.document.getElementById("middleFrame").src = url;
}
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
		<div class="navDiv act"><a href="/knowledgeDictLibManage/index" >知识库管理</a></div>
		<div class="navDiv"><a href="/systemManage/index" >系统管理</a></div>
	</div>
<!-- topNav end -->

<!-- table content start -->
	<div class="tableContent">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<td valign="top">
				<div class="tableContentLeft">
					<div class="navTitle"><a class="act" href="/knowledgeDictLibManage/index" >知识库概况</a></div>
					<div class="navSubTitle"><a href="/knowledgeDictLibManage/knowledgeDictLibManageLibManage" >词库管理</a></div>
					<div class="navSupTitle"><a href="/knowledgeDictLibManage/knowledgeDictLibManageToAddLib" ><span>添加词库</span></a></div>
					<div class="navSubTitle"><a href="/knowledgeDictLibManage/knowledgeDictLibManageItemManage" >词条管理</a></div>
					<div class="navSupTitle"><a href="/knowledgeDictLibManage/knowledgeDictLibManageToAddItem" ><span>添加词条</span></a></div>
					<div class="navSupTitle"><a href="/knowledgeDictLibManage/knowledgeDictLibManageUploadItem" ><span>导入词条</span></a></div>
				</div>
			</td>
			<td class="tdBak" valign="top">
				<div class="tableContentRight">
					<div class="currentPosition">
					&nbsp;&nbsp;&nbsp;&nbsp;当前位置：&nbsp;&nbsp;知识库管理&nbsp;>&nbsp;知识库概况
					</div>
				
					<!-- 页面内容 start -->		
<!-- 信息统计 start -->
					<div class="information">
						<div class="informationSourceTitle">
							<span class="sourceLeft">舆情词库</span>
							<span class="sourceRight sourceRight1"><a href="/knowledgeDictLibManage/knowledgeDictLibManageItemManage"></a></span>
						</div>
<!-- 今天 start -->
						<div class="basic">
							<div class="informationDiv">
								<div class="lconBox">
									<div class="lconDiv knowledgeWidth1">
										<div class="lconbak1"></div>
										<div class="lconbak2">
											<div class="lconTitle">本月新增词条</div>
											<div class="lconNumber"><tt>${newCountOfMonth}</tt>条</div>
										</div>
										<div class="lconbak3"></div>
									</div>

									<div class="lconDiv knowledgeWidth1">
										<div class="lconbak1"></div>
										<div class="lconbak2">
											<div class="lconTitle">本年新增词条</div>
											<div class="lconNumber"><tt>${newCountOfYear}</tt>条</div>
										</div>
										<div class="lconbak3"></div>
									</div>

									<div class="lconDiv knowledgeWidth1">
										<div class="lconbak1"></div>
										<div class="lconbak2">
											<div class="lconTitle">词条总数</div>
											<div class="lconNumber"><tt>${totalitem }</tt>条</div>
										</div>
										<div class="lconbak3"></div>
									</div>

									<div class="lconDiv knowledgeWidth1">
										<div class="lconbak1"></div>
										<div class="lconbak2">
											<div class="lconTitle">一级词库总数</div>
											<div class="lconNumber"><tt>${countOfLevelOneLib}</tt>个</div>
										</div>
										<div class="lconbak3"></div>
									</div>
								</div>
							</div>
						</div>
<!-- 今天 end -->

					</div>
<!-- 信息统计 end -->

<!-- 采集信息来源明细 start -->
					<div class="informationSource">
						<div class="sourceChartBox marginTop">
						<div class="sourceChartBoxLeft">
<!-- column chart start -->
							<div class="sourceChartBoxLeftDiv knowledgeDivW">
							<div class="sourceChartBoxLeftTitle"><a>本年度词条增长情况</a></div>
							<div class="sourceChartBoxLeftSelect">&nbsp;</div>
							<div class="clear"></div>
							<div class="informationChart" id="help_continuous_date_chart"></div>
							</div>

							<div class="knowledgeDiv">
						<!-- the data is from database-->
						    <c:forEach  var="kdl" items="${listlib}" >
								<div class="lconDiv knowledgeWidth2">
									<div class="lconbak1"></div>
									<div class="lconbak2">								
										<div class="lconTitle">${kdl.kdlName}</div>
										<div class="lconNumber"><tt>${kdl.kdlCount}</tt></div>		
									</div>
									<div class="lconbak3"></div>
								</div>
							</c:forEach>
                          <!-- data end -->
								
							</div>
<!-- column chart end -->
						</div>

						<div class="sourceChartBoxRight">
<!-- 最新词条 start -->
							<div class="surceWebBox marginTop">
								<div class="surceWebTitle">
									<span class="webTitle">最新词条</span>
								</div>
								<div class="webContent">
								<div class="webContentTable">
									<div class="webContentTh">
										<span class="sort">排序</span>
										<span class="title">词条</span>
										<span class="time">时间</span>
										<div class="clear"></div>
									</div>

							
									<div class="webContentTh webContentTd">
									<% int i=1; %>
									<c:forEach var="kdi" items="${listitem}">	
										<span class="sort"><%= i++ %></span>
										<span class="title">${kdi.kdiName}</span>
										<span class="time"> ${kdi.kdiCreateDate} </span>
										<div class="clear"></div>
										</c:forEach>
									</div>
							

								</div>
								</div>
							</div>
<!-- 最新词条 end -->
						</div>

						</div>
					</div>

			<!-- 页面内容 end -->	
		
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
