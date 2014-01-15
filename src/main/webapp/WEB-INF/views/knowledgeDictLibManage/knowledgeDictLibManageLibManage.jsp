<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>
<script type="text/javascript" src="${ctx }/static/js/knowledge/lib.js"></script>
<script type="text/javascript"> 
function todo(url){
	parent.document.getElementById("middleFrame").src = url;
}
</script>

</head>
<body>
<div class="con">
<!-- topNav start -->
	<div class="topNav">
		<div class="navDiv"><a href="/mainMedia/index" >主流媒体舆情</a></div>
		<div class="navDiv"><a href="/warning/index" >舆情预警</a></div> 
		<div class="navDiv"><a href="/cityRecognize/index" >城市形象与认知度</a></div>
		<div class="navDiv"><a href="/leaderRecognition/index" >舆论领袖识别</a></div>
		<div class="navDiv act"><a href="/knowledgeDictLibManage/index" >知识库管理</a></div>
		<div class="navDiv"><a href="/systemManage/index" >系统管理</a></div>
	</div>
<!-- topNav end -->

<!-- table content start -->
	<div class="tableContent">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<td valign="top">
				<div class="tableContentLeft">
					<div class="navTitle"><a href="/knowledgeDictLibManage/index" >知识库概况</a></div>
					<div class="navSubTitle"><a class="act" href="/knowledgeDictLibManage/knowledgeDictLibManageLibManage" >词库管理</a></div>
					<div class="navSupTitle"><a href="/knowledgeDictLibManage/knowledgeDictLibManageToAddLib" ><span>添加词库</span></a></div>
					
					<div class="navSubTitle"><a href="/knowledgeDictLibManage/knowledgeDictLibManageItemManage" >词条管理</a></div>
					<div class="navSupTitle"><a href="/knowledgeDictLibManage/knowledgeDictLibManageToAddItem" ><span>添加词条</span></a></div>
					<div class="navSupTitle"><a href="/knowledgeDictLibManage/knowledgeDictLibManageUploadItem" ><span>导入词条</span></a></div>
				</div>
			</td>
			<td class="tdBak" valign="top">
				<div class="tableContentRight">
					<div class="currentPosition">
					&nbsp;&nbsp;&nbsp;&nbsp;当前位置：&nbsp;&nbsp;知识库管理&nbsp;>&nbsp;词库管理
					</div>
				
				<!-- 页面内容 start -->
				
<!-- table content start -->
	
					
					<div class="addPoint dataBaseBox">
<!-- addPointCon start -->
					<div class="addPointCon dataBase">
						<div class="addPointConBntLine"></div>
						<div class="addPointConBnt">
						<form action="/knowledgeDictLibManage/getlistLibByParentId">
					
							<div class="addPointConBntDiv addPointConBntAct""><input type="hidden" name="all" value="1">一级词库</div>
							<c:forEach var="lib" items="${listlib}">
							<div class="addPointConBntDiv" ><input type="hidden" name="ss" value="${lib.id }">${lib.kdlName}</div>
							</c:forEach>
						
						</div>
						<input type="hidden" name="kdlParentId" id="kdlParentId" value="1">
						</form>

					<div class="addPointConContent">
<!-- 基本配置1 start -->
					<div class="basic">
					<div class="tableListDiv dataBasetableListDiv">
						<div class="tableListDivNav">
							<div class="tableListDivNavLeft" id="pageInfo" >
								
							</div>
							<div class="tableListDivAddDataBase">
								<a href="/knowledgeDictLibManage/knowledgeDictLibManageToAddLib"></a>
							</div>
						</div>
						<div class="tableListDivTable">
							<table cellpadding="0" cellspacing="0" id="tableContainer">
								
							</table>
<!-- 分页 start -->
							<div class="tablePage" id="pageContainer">
								
							</div>
<!-- 分页 end -->
						</div>
					</div>
					</div>
<!-- 基本配置1 end -->
							</div>
						</div>
<!-- addPointCon end -->

					</div>
					
	
<!-- table content end -->

<script type="text/javascript">
$(function()
{	//初始化分页数据页面
	var initPageInfo = window.location.toString().match(/page(=|\/)([0-9]+)/);
	getItemList(initPageInfo ? initPageInfo[2] : 0);
    
	//执行按钮切换效果
	changeBnt("addPointConBntDiv","basic");
})


//按钮切换效果
function changeBnt(bnt,con)
{
	$("."+bnt).click(function()
	{
		$("."+bnt).removeClass("addPointConBntAct");
		$(this).addClass("addPointConBntAct");
		//$("."+con).addClass("hidden");
		//$($("."+con)[$(this).index()]).removeClass("hidden");
			
		$('#kdlParentId').attr("value",$(this).find("input[type='hidden']").val());
		var initPageInfo = window.location.toString().match(/page(=|\/)([0-9]+)/);
		getItemList(initPageInfo ? initPageInfo[2] : 0);

	}) ;
	

}
</script>



				
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
