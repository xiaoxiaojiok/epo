<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>
<link type="text/css"  href="${ctx }/static/style/css.css" rel="stylesheet"/>
<link rel="shortcut icon" href="${ctx }/favicon.ico" />
<script type="text/javascript" src="${ctx }/static/js/base/base.js"></script>
<script type="text/javascript" src="${ctx}/static/easyui/jquery-1.8.0.min.js"></script>

<script type="text/javascript"> 
<script type="text/javascript"> 
function todo(url){
	parent.document.getElementById("middleFrame").src = url;
}
</script>

</head>
<body>
<style type="text/css">
	body{background:none;}
	.changemonitorCon { height: 1700px; }
	.contentTitle { 
	          display:inline;
	          padding-top:10px;
	          font-size:20px;
	          color:#1486cd;
	          font-weight:bold;
	          float:left;
	          }

</style>
		
				<!-- 页面内容 start -->
				
		      <div class="monitorCon changemonitorCon">
					<!-- top start -->
						<div class="monitorTopBox">
							<div class="monitorTitle">
								<span class="aTitle">城市形象与认识度</span>
								<span class="bTitle">情感分析</span>
							</div>
							
					    </div>
					<!-- top end -->
					<!-- content start -->
				<span class="space2">职能部门：</span>
					<span class="systemSearchLeft">
						    <select class="select" id="department" name="departmentName">
						       <option value="" >--</option>
						       <c:forEach var="lib" items="${departmentName}">
						           <option value="${lib.dbiName}" >${lib.dbiName}</option>
						       </c:forEach>
						    </select>
					 </span>
					 <span id="departmentAttentionchg">
					 </span>
				<br >
				<span class="contentTitle">职能部门关注度排行图</span>
				<br />
				<br />
				<img src="http://chart.apis.google.com/chart?chs=1000x300&chd=${departmentAttention_Y}&cht=bvs&chbh=35&chdl=正面|中立|负面&chco=ff0000,0000ff,00ff00&chxt=x,y&chxl=${departmentAttention_X}"/>
				</div>
				
				<!-- 页面内容  end -->

<!-- table content end -->
<script>
$('#department').change(function() {
	var options = '';
	$("#departmentAttentionchg").html("");
	if($('#department').val()==""){
		$("#departmentAttentionchg").html(options); // 数据插入到子分类下拉表！
	}else{
		options = '<img src="http://chart.apis.google.com/chart?chs=800x375&chd=';
		$.ajax({url:$("#getAttentionChange").val(),  //获取子分类的URL
				type: 'get',
				async: false,
				data: {department:$('#department').val()},
				success: function(msg)
				{
					alert(msg[0]);
						options += msg[0] + '&cht=lc&chbh=50&chdl=正面|中立|负面&chtt=情感倾向变化趋势&chco=ff0000,0000ff,00ff00&chf=c,ls,90,999999,0.25,CCCCCC,0.25,FFFFFF,0.25&chxt=x,y&chxl=' + msg[1] +'/>';
						alert(options);
					$("#departmentAttentionchg").html(options); // 数据插入到子分类下拉表！
				
					}  
         });
	}
 });
</script>
</body>
</html>
