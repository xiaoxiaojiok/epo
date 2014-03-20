<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form commandName="role" action="${ctx}/role/menu/save" method="post">
<form:hidden path="id"  />
<input type="hidden" value="${menu.id }" name="menuId"/>
<table class="biaoge_2" style="width:100%">
  <tr>
    <th style="width:20%">菜单名称</th>
    <th style="width:80%">菜单权限</th>
  </tr>
  <c:set var="count" value="0" />
  <c:forEach var="menus" items="${menuList}" varStatus="m" >
	   <tr class="biaoge_21">
	   <td style="width:20%">${menus.menuName}--</td>
	   <td align="left" style="width:80%">			    
	   			 <c:if test="${not empty permList[count]}">
			  		<form:checkboxes  path="permissionList" items="${permList[count]}" itemLabel="permName" itemValue="id" />
			  	</c:if>
			  	<c:if test="${empty permList[count]}">
			  	  <font color="red">没有数据</font>
			  	</c:if>
		</td>
	   </tr>
	   <c:set var="count" value="${count+1}" />
	  	<c:if test="${menus.hasNext eq 1}">
	  		<c:forEach items="${menus.subMenuList}" var="subMenu">
	  			 <tr class="biaoge_21">
			  <td style="width:20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			  					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${subMenu.menuName}</td>
			  <td align="left" style="width:80%">
			     <c:if test="${not empty permList[count]}">
			  		<form:checkboxes  path="permissionList" items="${permList[count]}" itemLabel="permName" itemValue="id" />
			  	</c:if>
			  	<c:if test="${empty permList[count]}">
			  	  <font color="red">没有数据</font>
			  	</c:if>
			  </td> 
			  </tr>
			  <c:set var="count" value="${count+1}" />
	  		</c:forEach>
	  	</c:if>
  </c:forEach>
  <tr>
		<td class="biaoge_34" colspan="4">
			<input type="submit" class="button_3" name="submit" value="保存" />
			<input type="button" class="button_3" name="" value="返回" onclick="history.back();"/>
		</td>
	</tr>
</table>
</form:form>