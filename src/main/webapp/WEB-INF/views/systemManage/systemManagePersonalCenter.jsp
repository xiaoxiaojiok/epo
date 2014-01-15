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
//统计用户贡献总数
var lconCount=0;
for(var i=0;i<$(".lconNumber").length;i++){
	if(i>0){
		lconCount+=Number($($(".lconNumber")[i]).find("tt").text());
	}
}
$($(".lconNumber tt")[0]).html(lconCount);
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
					
					<div class="navSubTitle"><a href="/systemManage/toGatherManage" >采集点管理</a></div>
					<div class="navSupTitle"><a href="/systemManage/toAddGather" ><span>添加采集点</span></a></div>
					
					<div class="navSubTitle"><a class="act" href="/systemManage/personalCenter" >个人中心</a></div>
					<div class="navSupTitle"><a href="/systemManage/toChangePass" ><span>更改密码</span></a></div>
					<div class="navSupTitle"><a href="/systemManage/toEditUser" ><span>修改信息</span></a></div>
					
					<div class="navSubTitle"><a href="/systemManage/toUserManage" >用户管理</a></div>
					<div class="navSupTitle"><a class="" href="/systemManage/toAddUser" ><span>添加用户</span></a></div>
				</div>
			</td>
			<td class="tdBak" valign="top">
				<div class="tableContentRight">
					<div class="currentPosition">
					&nbsp;&nbsp;&nbsp;&nbsp;当前位置：&nbsp;&nbsp;<a href="/systemManage/index" >系统管理</a>&nbsp;>&nbsp;<a href="/systemManage/personalCenter" >个人中心</a>
					</div>
				
		       <!-- 页面内容 start -->
				
				<!-- 个人中心内容区 start -->
					<div class="indivlCenter">
						<table cellpadding="0" cellspacing="0">
							<tr>
								<td valign="top">

									<div class="indivlCenterTableLeft">
										<div class="indivlCenterPhoto">
											<div class="photoLeft"><a href="###"><img src="/static/images/yuq_115.jpg" alt="用户头像" /></a></div>
											<div class="photoRight">
												<span class="photoTitle">${user.loginName }</span>
												<span class="photoDocket">${user.type }</span>
											</div>
											<div class="clear"></div>
										</div>

										<div class="indivlCenterPhoto">
											<span class="textTitle">累计登录</span>
											<span>${user.loginCount }次</span>
										</div>

										<div class="indivlCenterPhoto">
											<span class="textTitle">电子邮箱</span>
											<span>${user.email }</span>
										</div>

										<div class="indivlCenterPhoto">
											<span class="textTitle">最后登录ip</span>
											<span>${user.lastLoginIP }</span>
										</div>

										<div class="indivlCenterPhoto">
											<span class="textTitle">最后登录时间</span>
											<span>${user.lastTime }</span>
										</div>

										<div class="indivlCenterTableLeftBnt">
											<span class="changePass"><a href="/systemManage/toChangePass"></a></span>
											<span class="modifyInfor"><a href="/systemManage/toEditUser"></a></span>
										</div>

									</div>
								</td>

								<td class="indivlCenterbak" valign="top">

									<div class="indivCenterRight">

										<div class="addPointConBntLine"></div>
										<div class="addPointConBnt">
											<div class="addPointConBntDiv addPointConBntAct">用户贡献</div>
										</div>
										<div class="clear"></div>
<!-- 贡献说明值 start -->
										<div class="lconBox">
											<div class="lconDiv">
												<div class="lconbak1"></div>
												<div class="lconbak2">
													<div class="lconTitle">累计贡献</div>
													<div class="lconNumber"><tt></tt>次</div>
												</div>
												<div class="lconbak3"></div>
											</div>

										
											<div class="lconDiv lconDivWidth">
												<div class="lconbak1"></div>
												<div class="lconbak2">
													<div class="lconTitle">添加词条</div>
													<div class="lconNumber"><tt>15</tt>次</div>
												</div>
												<div class="lconbak3"></div>
											</div>

										</div>
<!-- 贡献说明值 end -->

<!-- table start -->
										<div class="tableListDivTable lconTable">
										<table cellpadding="0" cellspacing="0">
										<tr>
											<th align="center" width="10%">序号</th>
											<th align="center" width="30%">时间</th>
											<th align="center" width="20%">贡献</th>
											<th align="center" width="40%">详细</th>
										</tr>
										
										<tr>
											<td class="number" align="center" width="10%">3822</td>
											<td align="center" width="30%">2013-3-12</td>
											<td align="center" width="20%">添加词条</td>
											<td align="center" width="40%">空手夺白刃</td>
										</tr>

									</table>
									</div>
<!-- table end -->
									</div>
										
								</td>
							</tr>
						</table>
					</div>
<!-- 个人中心内容区 end -->

				
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
