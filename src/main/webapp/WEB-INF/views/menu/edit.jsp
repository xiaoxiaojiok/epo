<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="weizhi">你的位置是：系统管理 >> 菜单管理 >> 编辑菜单</div>
<form name="mainForm" id="mainForm">
	<input type="hidden" name="id" id="id" value="${menu.id }"/>
	<input type="hidden" id="addType" value="${addType }"/>
	<table class="biaoge_3" style="margin-top:10px;">
		<tr>
			<td class="biaoge_31" colspan="4">注：带"*"为必填项，第一级菜单可不必选择上级菜单</td>
		</tr>
		<tr>
			<td class="biaoge_32" style="width:15%"><span style="color: #F00">*</span>上级菜单</td>
			<td class="biaoge_33" style="width:35%">
				<select name="top_menu" id="top_menu" onchange="changeMenu();">
					<option value="0">---请选择---</option>
					${menuOptions }
				</select> 
			</td>
			<td class="biaoge_32"><span style="color: #F00">*</span>菜单名称</td>
			<td class="biaoge_33"><input type="text" class="text_3" name="menuName" id="menuName" value="${menu.menuName }"/></td>
		</tr>
		<tr>
			<td class="biaoge_32" style="width:15%"><span style="color: #F00">*</span>菜单级别</td>
			<td class="biaoge_33" style="width:35%"><span id="menuLevelSpan">${menu.menuLevel }</span><input type="hidden" name="menuLevel" id="menuLevel" value="${menu.menuLevel }"/></td>
			<td class="biaoge_32"><span style="color: #F00">*</span>请求地址</td>
			<td class="biaoge_33">
				<input type="text" name="menuUrl" id="menuUrl" class="text_4" value="${menu.menuUrl }"/>
			</td>
		</tr>
		<tr>
			<td class="biaoge_32" style="width:15%"><span style="color: #F00">*</span>同级排序</td>
			<td class="biaoge_33" style="width:35%"><input type="text" class="text_3" name="orderNum" id="orderNum" value="${menu.orderNum }"/></td>
			<td class="biaoge_32">状态</td>
			<td class="biaoge_33">
				<select name="status" id="status" style="width:100px;">
					<option value="1" <c:if test="${menu.status eq 1}">selected</c:if>>启用</option>
					<option value="0" <c:if test="${menu.status eq 0}">selected</c:if>>禁用</option>
				</select> 
			</td>
		</tr>
		<tr>
			<td class="biaoge_34" colspan="4">
				<input type="button" class="button_3" id="save_btn" name="" value="保存" onclick="save();"/>
				<input type="button" class="button_3" id="process_btn" name="" value="正在处理" style="display:none;" disabled/>
				<input type="button" class="button_3" name="" value="返回" onclick="base.cancel('head','list','edit');"/>
			</td>
		</tr>
	</table>
</form>