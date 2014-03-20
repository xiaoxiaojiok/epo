<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>
<%@include file="/static/common/import_js.jsp"%>
<script type="text/javascript" src="/static/js/syspurview/role/role.js"></script>

<script type="text/javascript">
function back(){
	base.forward("/role/list");
}

</script>

<style type="text/css">
	body{
	font-size:12px;
	}
	table{
	font-size:13px;
	}
	.tdright{
	text-align:right;
	}
	
	.tcolor{
	color:#0E2D5F;}
	
	.required{
	color:#FF0000;}
	
	#intable{
		border:1px solid #0066CC;
		text-align:left;
		font-size:12px;
	    border-collapse: collapse;
        border-spacing: 0px;
	}
	
	#intable td{
	border:1px solid #0066CC;
	height:25px;
	}
	#content{
	width:100%;
	height:auto;
	border:1px solid black;
	margin:auto;
	}
	#table1{
	width:100%;
	height:auto;
	}
</style>
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

				<div style="text-align:left;padding:5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" onclick="window.history.back()" style="margin-left:20px;" data-options="iconCls:'icon-back'">返回</a>
				<a href="javascript:void(0);" class="easyui-linkbutton" onclick="save(${sId})" style="margin-left:20px;" data-options="iconCls:'icon-save'">保存</a>
				 </div>
				 <div class="easyui-panel" title="角色 信息" style="padding:5px 10px;width:auto; background-color:#F6F7FB;">
						<div style="padding:10px 10px 10px 10px">
				<form  id="roleForm" name="roleForm" method="post"  action="${ctx}/role/save">
				<input type="hidden" value="${role.id}" name="id" id="id"/>
				<table class="biaoge_3" style="margin-top:10px;">
					<tr>
						<td class="tdright"  style="width:100px;"><span style="color: #F00">*</span>角色名称:</td>
						<td class="biaoge_33" style="width:35%"><input name="name" id="name" value="${role.name }" class="text_3"/><form:errors path="name" cssClass="error" /></td>
						<td class="tdright" style="width:100px;">角色描述:</td>
						<td class="biaoge_33" style="width:35%"><input name="description" id="description" value="${role.description }" class="text_3"/></td>
					</tr>
					<tr>
						<td  class="tdright"><span style="color: #F00">*</span>角色状态:</td>
						<td class="biaoge_33">
							<select name="status" id="status" style="width:120px;" >
									<option value="1" <c:if test="${role.status eq 1}">selected</c:if>>正常</option>
									<option value="-1" <c:if test="${role.status eq -1}">selected</c:if>>停用</option>
							</select>
						</td>
						<!--  
						<td class="tdright">角色类型:</td>
						<td class="biaoge_33">
						<select name="roleTypeId" id="roleTypeId" onchange="setRoleUnit()">
							<c:forEach items="${roleType}" var="rt">
								<option value="${rt.id}" <c:if test="${role.roleType.id eq rt.id }">selected</c:if>>${rt.mkey}</option>
							</c:forEach>	
						</select>
						</td>
						-->
					</tr>
				</table>
				</form>
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
