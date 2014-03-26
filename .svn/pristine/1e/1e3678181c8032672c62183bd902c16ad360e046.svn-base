<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>
<%@include file="/static/common/import_js.jsp"%>
<link type="text/css" rel="stylesheet" href="${ctx }/static/css/table.css"/>
<script type="text/javascript" src="${ctx }/static/js/syspurview/mcode/mcode.js"></script>
<script	type="text/javascript">
	
	$(document).ready(function() {
		 	$('#dg').datagrid({
		    url: '/mcode/query',
			pageSize:20,
		    pageList:[20,30,50],
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
			var edit = "<a onclick='edit("+row.id+");' href='javascript:void(0);'>修改</a>";
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

		
				<!-- 页面内容  end -->
				</div>
				<div class="easyui-layout" fit="true">
				<div region="north" border="false" title="码表管理" style="height: 110px;overflow: hidden;">
					<form  id="sear_forms" style="width:100% ; height: 100%">
						<table class="tableFrom datagrid-toolbar" style="width: 100%;height: 100%">
							<tr>
								<td class="biaoge_11">查询条件</td>
								<td  class="biaoge_12"><span style="float:left">码类型：
										<input type="text" id="sear_mtype" name="sear_mtype"/>
									</span>
								</td>
							</tr>
							<tr>
								<td class="biaoge_11">操作</td>
								<td  class="biaoge_12">
								 <div style="text-align:left;padding:5px">
								<shiro:user>
									<shiro:hasPermission name="mcode:edit">
										<a href="javascript:void(0);" class="easyui-linkbutton" onclick="codeQuery()" style="margin-left:20px;" >查询</a>		
									</shiro:hasPermission>
									<shiro:hasPermission name="mcode:edit">
										<a href="javascript:void(0);" class="easyui-linkbutton" onclick="edit(0);" style="margin-left:20px;" >添加</a>
									</shiro:hasPermission>
								</shiro:user>
								<shiro:user>
									<shiro:hasPermission name="mcode:delete">
										<a href="javascript:void(0);" class="easyui-linkbutton" onclick="delMore();" style="margin-left:20px;" >删除</a>
									</shiro:hasPermission>
								</shiro:user>
								</div>
								</td>
							</tr>
						</table>
					</form>
				</div>
				<div id="list" region="center" border="false">
						<table id="dg" >
						<thead>
							<tr>
								<th data-options="field:'id',width:180,checkbox:true">全选</th>
								<th data-options="field:'mtype',width:150,sortable:true,align:'center'">码类型</th>
								<th data-options="field:'mkey',width:180,sortable:true,align:'center'">码名称</th>
								<th data-options="field:'mvalue',width:50,sortable:true,align:'center'">码值</th>
								<th data-options="field:'orderNum',width:80,sortable:true,align:'center'">码排序</th>
								<th data-options="field:'datelevel',width:80,sortable:true,align:'center'">码级别</th>
								<th data-options="field:'remark',width:150,sortable:true,align:'center'">备注</th>
								<th data-options="field:'date',width:120,sortable:true,align:'center'">创建时间</th>
								<th data-options="field:'createrName',width:100,sortable:true,align:'center'">创建者</th>
								<th data-options="field:'opt',width:180,formatter:rowformater,align:'center'">操作</th>
							</tr>
							</thead>
						</table>
					</div>
				<div id="edit"></div>
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
