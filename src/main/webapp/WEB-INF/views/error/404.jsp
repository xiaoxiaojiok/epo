<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%response.setStatus(200);%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>404 - 页面不存在</title>
	<link type="text/css" rel="stylesheet" href="${ctx }/static/css/css.css"/>
</head>
<body>
<table width="300px" align="left">
	<tr>
		<td align="center">
			<div align="center">
				<h1>系统找不到指定路径.</h1>
				<div>
					<p><img src="${ctx }/static/images/404.jpg" /></p>
				</div>
			</div>
		</td>
	</tr>
</table>
</body>
</html>