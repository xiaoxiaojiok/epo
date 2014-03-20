<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>广州广报</title>
<link type="text/css"  href="${ctx }/static/style/css.css" rel="stylesheet"/>
<link rel="shortcut icon" href="${ctx }/favicon.ico" />
<script type="text/javascript" src="${ctx }/static/js/base/base.js"></script>
<script type="text/javascript" src="${ctx}/static/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${ctx }/static/js/datepicker.js"></script>
<script type="text/javascript" src="${ctx }/static/js/eye.js"></script>
<script type="text/javascript" src="${ctx }/static/js/chooseDate.js"></script>
<script type="text/javascript" src="${ctx }/static/js/jsapi"></script>
<script type="text/javascript" src="${ctx }/static/js/format+zh_CN,default,corechart.I.js"></script>

<link rel="shortcut icon" href="${ctx }/favicon.ico" />

<style type="text/css">
	body{background:none;}

	
</style>

</head>
<body>
	<div class="indivlCenter">
		<div class="monitorTopBox" width="1045px" align="center">
	<!-- top start -->
			<div class="monitorTitle">
				<span class="aTitle">舆论领袖</span>
				<span class="bTitle">个人中心</span>
			</div>
			<div class="clear"></div>
	<!-- top end -->
		</div>
		<table cellspacing="0" cellpadding="0">

			<tr>
				<td valign="top">
					<div class="indivlCenterTableLeft">
						<div class="indivlCenterPhoto">
							<div class="photoLeft">
								<a href="###">
								<img alt="用户头像" src="/static/images/yuq_115.jpg">
								</a>
							</div>
							<form>
								<input type="file" name="pic" accept="image/gif" />
							</form>
							<div class="photoRight">
								<span class="photoTitle"></span>
								<span class="photoDocket"></span>
							</div>
							<div class="clear"></div>
						</div>
						<div class="indivlCenterPhoto">
							<span class="textTitle">网络ID</span>
							<span>${leader.id }</span>
						</div>
						<div class="indivlCenterPhoto">
							<span class="textTitle">社交账号</span>
							<span>${leader.socialAccount }</span>
						</div>
						<div class="indivlCenterPhoto">
							<span class="textTitle">所在地域</span>
							<span>${leader.regionId.name }</span>
						</div>
						<div class="indivlCenterPhoto">
							<span class="textTitle">收入阶层</span>
							<span>${leader.hierarchyId.name }</span>
						</div>
						<form action="">
							<div class="indivlCenterPhoto">
								<span class="textTitle">收政治倾向</span>
								<span>
									<select type="select" name="political" value="${leader.political }">
										<option>左倾主义</option>
										<option>中庸主义</option>
										<option>右倾主义</option>
									</select>
								</span>
							</div>
							<div class="indivlCenterPhoto">
								<span class="textTitle">舆情影响力</span>
								<span>
									<select type="select" name="influence" value="${leader.influence }">
										<option>1级</option>
										<option>2级</option>
										<option>3级</option>
									</select>
								</span>
							</div>
						</form>
						
						
						<div class="indivlCenterPhoto">
							<button>更新</button>
						</div>	
					</div>
				</td>
				<td class="indivlCenterbak" valign="top">
					<div class="informationSourceTitle">
						<span class="sourceLeft">参与历史事件</span>
					</div>
					<table font-color="black" border="1px" align="center" width=80%>
						<tr>
							<th align="center">社交账号</th>
							<th align="center">时间描述</th>
							<th align="center">类型</th>
							<th align="center">扮演角色</th>
							<th align="center">所持观点</th>
					   </tr>
				
					   <c:forEach var="history" items="${lhr }">
					   <tr>
							<td align="center">${history.mediaLeaderId.socialAccount }</td>
							<td align="center">${history.description }</a></td>
							<td align="center">${history.type }</td>
							<td align="center">${history.role}</td>
							<td align="center">${history.view}</td>
					  </tr>
					 </c:forEach>
				  </table>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>