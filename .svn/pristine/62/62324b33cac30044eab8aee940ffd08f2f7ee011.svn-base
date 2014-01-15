<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户登录</title>
<link type="text/css"  href="${ctx }/static/style/css.css" rel="stylesheet"/>
<link type="text/css"  href="${ctx }/static/style/logn.css" rel="stylesheet"/>
<link rel="shortcut icon" href="${ctx }/favicon.ico" />
<script type="text/javascript" src="${ctx }/static/js/base/base.js"></script>
<script type="text/javascript" src="${ctx}/static/easyui/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
function tosubmit(){
	$('#loginFrom').submit();
}

</script>
</head>
<body>

<div class="lognBak1">
<div class="lognBak2">
<div class="lognBak3">
<div class="lognBak4">
<div class="lognBak5">
<div class="lognBak6">
<div class="lognBox">
<form action="/" method="post" id="loginFrom">
<!-- 用户名 start -->
		<div class="lognName">
			<span class="bak1"></span>
			<span class="input">
			<input id="loginName" class="txt" type="text" name="loginName" onkeydown='if(event.keyCode==13){tosubmit();}'/>
			</span>
		</div>
<!-- 用户名 end -->
<!-- 密码 start -->
		<div class="lognPassword">
			<span class="bak1"></span>
			<span class="input">
			<input id="password" class="txt" type="password" name="password" onkeydown='if(event.keyCode==13){tosubmit();}'/>
			</span>
		</div>
<!-- 密码 end -->
		<div class="clear"></div>
<!-- 提示 start -->
		<div class="lognPrompt">	
			<span>${errorInfo }</span>
		</div>
<!-- 提示 end -->


		<div class="clear"></div>
<!-- 提交 start -->
		<div class="lognsubmit"><a href="javascript:tosubmit();"></a></div>
		
<!-- 提交 end -->
</form>
	</div>
</div>
</div>
</div>
</div>
</div>
</div>

	<div class="footer">技术支持：广州广报数据科技有限责任公司</div>
</body>
</html>
