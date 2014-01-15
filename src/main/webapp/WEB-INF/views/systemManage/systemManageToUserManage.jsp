<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>

<script type="text/javascript" src="${ctx}/static/js/user.js"></script>
</head>
<body>
<div class="con">
<!-- topNav start -->
	<div class="topNav">
		<div class="navDiv"><a href="/mainMedia/index" >主流媒体舆情</a></div>
		<div class="navDiv"><a href="/warning/index" >舆情预警</a></div> 
		<div class="navDiv"><a href="/cityRecognize/index" >城市形象与认知度</a></div>
		<div class="navDiv"><a href="/leaderRecognition/index" >舆论领袖识别</a></div>
		<div class="navDiv"><a href="/knowledgeDictLibManage/index" >知识库管理</a></div>
		<div class="navDiv act"><a href="/systemManage/index" >系统管理</a></div>
	</div>
<!-- topNav end -->

<!-- table content start -->
	<div class="tableContent">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<td valign="top">
				<div class="tableContentLeft">
					<div class="navTitle"><a href="/systemManage/index" >系统管理</a></div>
					<div class="navSubTitle"><a href="/systemManage/toSiteManage" >站点管理</a></div>
					<div class="navSupTitle"><a href="/systemManage/toAddSite" ><span>添加站点</span></a></div>
					<div class="navSupTitle"><a href="/systemManage/statistics" ><span>信息统计</span></a></div>
					
					<div class="navSubTitle"><a href="/systemManage/toGatherManage" >采集点管理</a></div>
					<div class="navSupTitle"><a href="/systemManage/toAddGather" ><span>添加采集点</span></a></div>
					
					<div class="navSubTitle"><a href="/systemManage/personalCenter" >个人中心</a></div>
					<div class="navSupTitle"><a href="/systemManage/toChangePass" ><span>更改密码</span></a></div>
					<div class="navSupTitle"><a href="/systemManage/toEditUser" ><span>修改信息</span></a></div>
					
					<div class="navSubTitle"><a class="act" href="/systemManage/toUserManage" >用户管理</a></div>
					<div class="navSupTitle"><a class="" href="/systemManage/toAddUser" ><span>添加用户</span></a></div>
				</div>
			</td>
			<td class="tdBak" valign="top">
				<div class="tableContentRight">
					<div class="currentPosition">
					&nbsp;&nbsp;&nbsp;&nbsp;当前位置：&nbsp;&nbsp;<a href="/systemManage/index" >系统管理</a>&nbsp;>&nbsp;<a href="/systemManage/toUserManage" >用户管理</a>
					</div>
				
				<!-- 页面内容 start -->
				
<!-- 弹出框 start -->
	<div class="popupBox">
		<div class="popupBoxTitle">系统提示</div>
		<div class="popupBoxCon">
			
		</div>
		<div class="popupBoxBnt">
			<a href="###" class="bntLeft" onclick="return qr()"></a>
			<a href="###" class="bntClose" onclick="return coveColse()"></a>
		</div>
	</div>
<!-- 弹出框 end -->	
								
<div class="systemSearch">
			<form action="/user/search" method="post" id="myform">
						<span>用户昵称：</span>
						<span class="input">
						<input name="username" type="text" id="username"/>
						</span>
						<span class="space1">用户名：</span>
						<span class="input"><input name="loginName" type="text" id="loginName"/></span>
						<span class="systemSearchRight marginLeft">
							<select id="userType" class="select" name="userType">
								<option value="">--</option>
								<option value="1">系统管理员</option>
								<option value="2">部负责人</option>
								<option value="3">处室负责人</option>
								<option value="4">处室人员</option>
								<option value="5">中心负责人</option>
								<option value="6">中心人员</option>
							</select>
						</span>
			</form>
						<span class="img"><a href="###" onclick="return getItemList(0)">&nbsp;</a></span>
					</div>
					<div class="clear"></div>

					<div class="tableListDiv">
						<div class="tableListDivNav">
							<!-- 分页统计 start -->
							<div id="pageInfo" class="tableListDivNavLeft"></div>
							<!-- 分页统计 end -->
							<div class="tableListDivAddUser">
								<a href="/user/toAdd"></a>
							</div>
						</div>
						<div class="tableListDivTable">
							<table id="tableContainer" cellpadding="0" cellspacing="0">
							</table>
<!-- 分页 start -->
							<div class="tablePage"  id="pageContainer">
								
							</div>
<!-- 分页 end -->
						</div>
					</div>

<!-- table content end -->

<input type="hidden" id="deleteUrl" value="/user/delete" />
<input type="hidden" id="resetUrl" value="/user/resetPassword" />

<script type="text/javascript">
$(function()
{	
	//将弹框层转移到遮罩层后
	$(".popupBox").insertAfter(".popupBoxCove");

	//初始化分页数据页面
	var initPageInfo = window.location.toString().match(/page(=|\/)([0-9]+)/);
	getItemList(initPageInfo ? initPageInfo[2] : 0);
});
//删除按钮事件
function onDelete()
{
	$.ajax({url:$("#deleteUrl").val(),
		type:"get",
		async:false,
		data:{id:userId},
		dataType:"json",
		success:function(msg){
			coveColse();
			if(msg.data){
				getItemList(current);
			}
		}
	});	
}

function resetPassword(){
	
	$.ajax({
			url:$("#resetUrl").val(),
			type:'get',
			async:false,
			data:{id:userId},
			dataType:'json',
			success:function(msg){
				if(msg.data){
					var text = '新密码为：'+msg.Success+'<br />请及时保存！';

				}else{
					var text = '密码重置失败！';
				}
				$('.popupBox .popupBoxCon').html(text);
				coveDiv();
			}
	});
	return false;
}


var userId;//要操作的用户ID
var actionType;//要操作的模式（删除或重置密码）
var current;//当前页数

//弹出框居中
function coveDiv(cur,id,info,type)
{	
	actionType=type;
	userId=id;
	current=cur;
	$(".popupBoxCove").css({opacity:'0.5',width:$(document).width(),height:$(document).height(),display:'block'});
	$(".popupBox").css({left:($(window).width()-308)/2+'px',top:($(window).height()-188)/2+$(document).scrollTop()+'px',display:'block'});
	
	$(".popupBoxCon").text(info);
}

//关闭弹出框
function coveColse()
{
	$(".popupBoxCove").css({display:'none'});
	$(".popupBox").css({display:'none'});
	
	return false;
}

function qr()
{
	if(userId=='' || actionType=='')
		return false;
	
	if(actionType=='reset'){
		resetPassword();
		return true;
	}

	if(actionType=='delete'){
		onDelete();
		return true;
	}

	return coveColse();
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
