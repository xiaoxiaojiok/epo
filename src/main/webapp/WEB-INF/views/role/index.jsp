<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>

<link type="text/css" rel="stylesheet" href="${ctx }/static/css/table.css"/>
<link rel="stylesheet" type="text/css"	href="${ctx}/static/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"	href="${ctx}/static/easyui/themes/icon.css" />
<script	type="text/javascript" src="${ctx}/static/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/base/base.js"></script>
<script type="text/javascript" src="/static/js/syspurview/role/role.js"></script>
<script type="text/javascript"	src="${ctx}/static/easyui/jquery.easyui.min.js"></script> 
<script	type="text/javascript" src="${ctx}/static/js/serialize/syUtile.js"></script>
<script type="text/javascript"	src="${ctx}/static/easyui/locale/easyui-lang-zh_CN.js"></script> 

<script type="text/javascript">
//<!--

	$(document).ready(function() {
		 	$('#dg').datagrid({
		    url: '/role/list',
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

		function statusformatter(value,row,index){
			if(value==-1){
				return "<span id='statusDisplay"+row.id+"'><font color='red'>停用</font></span>";
			}else{
				return "<span id='statusDisplay"+row.id+"'>正常</span>";
			}		
		}

		function rowformater(value,row,index){
			var edit = "<a  onclick='edit("+row.id+");' href='javascript:void(0);'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;"
		    var setup1 = "<a id='setUnable"+row.id+"'  onclick='stopRole("+row.id+");' href='javascript:void(0);'";
		    if(row.status==-1){
				setup1 +=" style='display:none;'>停用</a>";
		    }else{
		    	setup1 +=" >停用</a>";
			} 
		    
		    var setup2 = "<a id='setAble"+row.id+"'  onclick='startRole("+row.id+");' href='javascript:void(0);'";
		    if(row.status==1){
				setup2 +=" style='display:none;'>启用</a>";
		    } else{
		    	setup2 +=" >启用</a>";
		    }
		    var accredit = "&nbsp;&nbsp;&nbsp;&nbsp;<a onclick='accredit("+row.id+");' href='javascript:void(0);'>授权</a>";
			return edit+setup1+setup2+accredit;
		}
	
//回车事件搜索
document.onkeydown = function(e){ 
    var currKey=0,e=e||event; 
    if(e.keyCode==13) 
    {
    	roleQuery();
    } 
};
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

				
				
				<!-- 页面内容  end -->
				</div>
				<div class="easyui-layout" fit="true">
				<div region="north" border="false" title="角色管理" style="height: 110px;overflow: hidden;">
					<form  id="sear_forms" action="serachproperty" style="width:100% ; height: 100%">
						<table class="tableFrom datagrid-toolbar" style="width: 100%;height: 100%">
							<tr>
							 <td class="biaoge_11">查询条件</td>
								<td class="biaoge_12">
								 角色名称：
				      				<input class="text_1" name="roleName" id="roleName" type="text" />
				      				<shiro:user>
										<shiro:hasPermission name="role:view">
											<a href="javascript:void(0);" class="easyui-linkbutton" onclick="roleQuery();" style="margin-left:5px;">查询</a>
										</shiro:hasPermission>
									</shiro:user>
								</td>
							</tr>
							<tr>
							<td class="biaoge_11">操作</td>
								<td class="biaoge_12">
								 <div style="text-align:left;padding:5px">
								<shiro:user>
									<shiro:hasPermission name="role:edit">
										<a href="javascript:void(0);" class="easyui-linkbutton" onclick="window.location.href='/role/create'" style="margin-left:5px;">添加</a>
										<a href="javascript:void(0);" class="easyui-linkbutton" onclick="delMore();" style="margin-left:5px;">删除</a>
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
								<th data-options="field:'name',width:150">角色名称</th>
								<th data-options="field:'description',width:180">角色描述</th>
								<th data-options="field:'status',width:100,formatter:statusformatter">状态</th>
								<th data-options="field:'opt',width:180,formatter:rowformater">操作</th>
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

