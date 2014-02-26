<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="monitorTopBox">
	<!-- top start -->
			<div class="monitorTitle">
				<span class="aTitle">舆论领袖</span>
				<span class="bTitle">言论信息分析</span>
			</div>
			<div class="clear"></div>
	<!-- top end -->
	</div>
	<table>
		<tr>
			<td align="center">网络ID：</td>
			<td align="center">${leader.networkid }</td>
		</tr>
		<tr>
			<td align="center">社交账号：</td>
			<td align="center">${leader.socialAccount }</td>
		</tr>
		<tr>
			<td align="center">所在地域：</td>
			<td align="center">${leader.region }</td>
		</tr>
		<tr>
			<td align="center">收入阶层：</td>
			<td align="center">${leader.income }</td>
		</tr>
		<tr>
			<td align="center">政治倾向：</td>
			<td align="center">${leader.political }</td>
		</tr>
		<tr>
			<td align="center">舆情影响力：</td>
			<td align="center">${leader.influence }</td>
		</tr>
	</table>
	
	<img src="http://chart.apis.google.com/chart?chs=250x250&chd=${fabu_Y}&cht=bvs&chco=ff0000&chf=c,s,76A4FB|bg,s,FFF2CC&chxt=x,y&chxl=${fabu_X}"
    />

	
</body>
</html>