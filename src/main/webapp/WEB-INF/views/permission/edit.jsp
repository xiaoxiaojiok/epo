<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<style type="text/css">
	body{
	font-size:12px;
	}
	table{
	font-size:13px;
	}
	.tdright{
	text-align:right;
	font-weight:bold;}
	
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
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>

<%@include file="/static/common/import_js.jsp"%>
<link type="text/css" rel="stylesheet" href="${ctx }/static/css/table.css"/>
<script type="text/javascript" src="${ctx }/static/js/syspurview/permission/permission.js"></script>
<script	type="text/javascript" charset="utf-8">
	
	$(document).ready(function() {
		 	$('#dg').datagrid({
		    url: '${ctx}/permission/query',
			pageSize:10,
		    pageList:[10,20,50],
		    width: 700,  
	        height: 'auto',  
	        nowrap: false,  
	        striped: true,  
	        border: true,  
	        collapsible:false,//是否可折叠的  
	        fit: true,//自动大小  
	        fitColumns:true,
	        remoteSort:false,   
	        idField:'id',  
	        singleSelect:false,//是否单选  
	        pagination:true,//分页控件  
	        rownumbers:true
		});
	});
		function serachproperty(){
			$("#dg").datagrid("load", sy.serializeObject($("#sear_forms").form()));
		}

		function rowformater(value,row,index){
			var edit = "<a  onclick='edit("+row.id+");' href='javascript:void(0);'>修改</a>";
			var del = "&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='del("+row.id+");' href='javascript:void(0);'>删除</a>";
			return edit+del;
		}
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
		<div id="content">
 <div style="text-align:left;padding:5px">
<a href="javascript:void(0);" class="easyui-linkbutton" onclick="window.history.back()" style="margin-left:20px;" data-options="iconCls:'icon-back'">返回</a>
<a href="javascript:void(0);" class="easyui-linkbutton" onclick="save(${sId})" style="margin-left:20px;" data-options="iconCls:'icon-save'">保存</a>
 </div>
	<div class="easyui-panel" title="权限信息" style="padding:5px 10px;width:auto; background-color:#F6F7FB;">
		<div style="padding:10px 10px 10px 10px">
	    <form id="permissionForm" method="post">
	    <input type="hidden" name="id" id="id" value="${permission.id}"/>
	    <input type="hidden" name="oldpvalue" id="oldpvalue" value="${permission.permValue}"/>
		<div class="table-showpage">
		   	<table id="table1" border="0" class="k-right">
			<tr>
				<td>权限名称</td>
				<td><input name="permName"  id="permName" value="${permission.permName}"/><font id="tipone" color="red"></font></td>
				<td>权限描述</td>
				<td><input name="descript" id="descript" value="${permission.descript}"/></td>
			</tr>
			<tr>
				<td>权限类型</td>
				<td>
					<select name="permType" id="permType" style="width:120px;" >
							<option value="0">--请选择--</option>
							<option value="1" <c:if test="${permission.permType eq 1}">selected</c:if>>功能权限</option>
							<option value="-1" <c:if test="${permission.permType eq -1}">selected</c:if>>菜单权限</option>
					</select><font id="tiptwo" color="red"></font>
				</td>
				<td>权限所属菜单</td>
				<td><select name="menuId" id="menuId" onchange="menuChange()">
				<c:forEach items="${mlist}" var="menu">
				<option value="${menu.id}" <c:if test="${permission.menu.id eq menu.id}">selected</c:if>>${menu.menuName}</option>
				</c:forEach>
				</select></td>
			</tr>
			<tr id="per_value">
				<td>权限值</td>
			<td><input name="permValue" id="permValue" onblur="checkPermValue()" value="${permission.permValue}"/><font id="tipvalue"  color="red"></font></td>
			</tr>
		</table>
		</div>
</form>
</div>
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
  

