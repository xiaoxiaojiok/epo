<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>
<script type="text/javascript" src="${ctx }/static/js/base/base.js"></script>
<link type="text/css" rel="stylesheet" href="${ctx }/static/css/table.css"/>
<link rel="stylesheet" type="text/css"	href="${ctx}/static/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"	href="${ctx}/static/easyui/themes/icon.css" />
<script	type="text/javascript" src="${ctx}/static/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/base/base.js"></script>
<script type="text/javascript" src="${ctx }/static/js/syspurview/role/role.js"></script>
<script type="text/javascript"	src="${ctx}/static/easyui/jquery.easyui.min.js"></script> 
<script	type="text/javascript" src="${ctx}/static/js/serialize/syUtile.js"></script>
<script type="text/javascript"	src="${ctx}/static/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"	src="/static/jquery-zTree-v3.4/js/jquery.ztree.all-3.4.js"></script>
<script type="text/javascript" src="${ctx }/static/jquery-zTree-v3.4/js/jquery.ztree.core-3.4.js"></script>
<link type="text/css" href="${ctx }/static/jquery-zTree-v3.4/css/demo.css" rel="stylesheet"/>
<link type="text/css" href="${ctx }/static/jquery-zTree-v3.4/css/zTreeStyle/zTreeStyle.css" rel="stylesheet"/>

<style>
<!--
.success {
	color:green;
}
-->
</style>
<script type="text/javascript">
<!--

var setting = {
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			onClick: this.onClick
		},
		view: {
			fontCss: function(treeId, node){
				return node.font ? node.font : {};
			},
			nameIsHTML: true
		}
	};
var zNodes = null;

$(document).ready(function(){
	$("#message").fadeOut(3000);
	var result = $("#jValue").val();
	zNodes = base.json(result);
	$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	onClick();
});
	
	
function onClick(){
	var roleid = $("#roleid").val();
	base.load("content","${ctx}/role/menu/crt/"+roleid,function(){});
	//base.load("content","${ctx}/role/menu/crt/"+roleid + "?menuId="+menuid,function(){});
	//$("#content").load("${ctx}/role/menu/accredit",{'menuid':menuid,'roleid':roleid});
	//base.load("content","${ctx}/system/subSys/index",function(){});
}
//-->
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


<input type="hidden" name="jValue" id="jValue" value="${jValue }"/>
<input type="hidden" name="roleid" id="roleid" value="${role.id}"/>
<c:if test="${not empty message}">
		<div id="message" class="success">${message}</div>	
	</c:if>
<table style="width:100%" >
  <tr>
    
    <th><div id="content"></div></th>
  </tr>
</table>
		
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

