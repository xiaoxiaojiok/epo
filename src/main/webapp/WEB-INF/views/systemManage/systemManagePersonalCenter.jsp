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
		<c:forEach items="${menuList}" var="one_menu">
				<c:if test="${one_menu.status eq 1}">
					<div <c:choose>
					       <c:when test="${one_menu.id eq pMenuId}">
					       	class="navDiv act"
					       </c:when>
					       <c:otherwise>
					       	class="navDiv"
					       </c:otherwise>
						</c:choose>
					>
					<a href="${one_menu.menuUrl}/${one_menu.id}" >${one_menu.menuName}</a>
					</div>
				</c:if>
		</c:forEach>
	</div>
<!-- topNav end -->

<!-- table content start -->
	<div class="tableContent">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<td valign="top">
				<div class="tableContentLeft">
					<c:forEach items="${menu.subMenuList}" var="fir_menu">
						<c:if test="${fir_menu.status eq 1}">
							<div class="navSubTitle">
								<a <c:choose>
								       <c:when test="${fir_menu.id eq sMenuId}">
								       	class="act"
								       </c:when>
								       <c:otherwise>
								       	class=""
								       </c:otherwise>
									</c:choose>
								href="${fir_menu.menuUrl}/${fir_menu.id}" >
								${fir_menu.menuName}
								</a>
							</div>
							<c:forEach items="${fir_menu.subMenuList}" var="sec_menu">
								<c:if test="${sec_menu.status eq 1}">
									<div class="navSupTitle">
										<a <c:choose>
										       <c:when test="${sec_menu.id eq sMenuId}">
										       	class="act"
										       </c:when>
										       <c:otherwise>
										       	class=""
										       </c:otherwise>
											</c:choose>
										href="${sec_menu.menuUrl}/${sec_menu.id}" >
										${sec_menu.menuName}
										</a>
									</div>
								</c:if>
							</c:forEach>
						</c:if>
					</c:forEach>
				</div>
			</td>
			<td class="tdBak" valign="top">
				<div class="tableContentRight">
					<div class="currentPosition">
					&nbsp;&nbsp;&nbsp;&nbsp;当前位置：&nbsp;&nbsp;<a href="${fUrl }" >${fMenu }</a>
					&nbsp;>&nbsp;<a href="${sUrl }" >${sMenu }</a>
					<c:if test="${not empty tMenu}">&nbsp;>&nbsp;<a href="${tUrl }" >${tMenu }</a></c:if>
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
												<span class="photoTitle">${user.username }</span>
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
	<shiro:user>
		<shiro:hasPermission name="39">
				<span class="changePass"><a href="/systemManage/toChangePass"></a></span>
		</shiro:hasPermission>
	</shiro:user>
		<shiro:user>
		<shiro:hasPermission name="41">
				<span class="modifyInfor"><a href="/systemManage/toEditUser"></a></span>
		</shiro:hasPermission>
	</shiro:user>
											
											
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
