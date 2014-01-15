<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../top.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>

<script type="text/javascript">


//表单提交
function submitForm(){
	//获取表单数据对象
	var formLabel = $("form").find('input[type="text"],input[type="password"],select');
	//获取表单数据
	var dataLabel = requiredLabel(formLabel);
	//如果检测必填数据为空，返回页面
	if(dataLabel==false){
		return false;
	}
	//验证用户名是否唯一
	//validateUnque($(formLabel[0]));
	//是否有错误提示
	var hasErrors = inputPrompt();
	
	//提交表单
	if(hasErrors==false){
		$.ajax({url:$("form").attr("action"),
		type:'post',
		async:false,
		data:dataLabel,
		dataType:"json",
		success:function(msg){
			if(msg.errors){
				$(".restate span").html("<img src=\"/static/images/loading.gif\" />");
				$(".importPrompt").html();
				$(".restate span").append("添加用户失败");
				$(".restate").css("display","block");
			}else{
				$(".restate span").html("<img src=\"/static/images/loading.gif\" />");
				$(".importPrompt").html();
				$(".restate span").append("添加用户成功");
				$(".restate").css("display","block");
			}

			setInterval("$('.restate').css('display','none')",3000);
		}
	});
	
	}


}

//验证不能为空，若都有值则返回表单数组、密码验证、邮箱验证
function requiredLabel(objLabel){
	
	var data = {};

	var status="";

	for(var i=0;i<objLabel.length;i++){
		data[$(objLabel[i]).attr("name")] = $(objLabel[i]).val();
		var labelText = $(objLabel[i]).parent().prev().text();

		if($(objLabel[i]).parent().prev().find("tt").text()=="*" && $(objLabel[i]).val()==""){
			$(objLabel[i]).parent().next().html(labelText.substr(1,labelText.length-2)+"不能为空");
			status = 1;
		}else{
			$(objLabel[i]).parent().next().html("");
		}
	}

	//邮箱验证
	var temp = $("#email");
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.|\-]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	
	if(temp.val()!=''){
		if(!myreg.test(temp.val()))
		{	status = 1;
			$(temp).parent().next().html("邮箱地址不符合电子邮箱格式");
		}
	}
	
	//确认密码
	if($("#password").val()!=$("#qr_password").val())
	{	status = 1;
		$("#password").parent().next().html("确认密码与用户密码不一致");
	}

	//密码不能少于8位数
	
	if( $("#password").val().length<8)
	{	status = 1;
		$("#password").parent().next().html("密码长度不能少于8位");
	}
	

	//验证用户名是否唯一
	if($("#loginName").val()!=""){
		var unqueName=validateUnque($("#loginName"));
		if(unqueName==false){
			status=1;
		}
	}
	

	if(status!=1){
		return data;
	}else{
		return false;
	}
}

//验证用户名唯一性
function validateUnque(names)
{	
	$.ajax({url:"/user/checkLoginNameIsExits",
		type:'get',
		async:false,
		data:'loginName='+$(names).val(),
		dataType:"json",
		success:function(msg){
			if(msg.data.name){
				$(names).parent().next().html("<a href=\"#\">"+msg.data.name+"</a>已存在，请重新输入");
				return false;
			}else{
				$(names).parent().next().html("");
				return true;
			}
		}
	});
	

}
//是否有错误提示
function inputPrompt(){
	for(var i=0;i<$(".inputPrompt").length;i++){
			if($($(".inputPrompt")[i]).html()==""){
				return false;
			}else{
				return true;
			}
	}
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
					
					<div class="navSubTitle"><a href="/systemManage/toUserManage" >用户管理</a></div>
					<div class="navSupTitle"><a class="act" href="/systemManage/toAddUser" ><span>添加用户</span></a></div>
				</div>
			</td>
			<td class="tdBak" valign="top">
				<div class="tableContentRight">
					<div class="currentPosition">
					&nbsp;&nbsp;&nbsp;&nbsp;当前位置：&nbsp;&nbsp;<a href="/systemManage/index" >系统管理</a>&nbsp;>&nbsp;<a href="/systemManage/toUserManage" >用户管理</a>&nbsp;>&nbsp;<a href="/systemManage/toAddUser" >添加用户</a>
					</div>
				
				<!-- 页面内容 start -->
				

				<div class="addPoint">
<!-- addPointInput start -->
					
						<form action="/user/addUser" id="form" name="form" method="post">
						<div class="addPointInput modifyIndiv">
							<div class="addPointInputBox">
								<span class="inputTitle inputModifyTitle"><tt>*</tt>用户名：</span>
								<span class="inputDiv inputModifyDiv"><input id="loginName" type="text" maxlength="16" name="loginName" /></span>
								<span class="inputPrompt"></span>
							</div>

							<div class="addPointInputBox">
								<span class="inputTitle inputModifyTitle">用户昵称：</span>
								<span class="inputDiv inputModifyDiv"><input id="username" type="text" maxlength="16" name="username" /></span>
								<span class="inputPrompt"></span>
							</div>

							<div class="addPointInputBox">
								<span class="inputTitle inputModifyTitle"><tt>*</tt>用户级别：</span>
								<span class="inputDiv inputModifyDiv"><select id="userType" name="userType">
																		<option value="">--</option>
																		<option value="1">系统管理员</option>
																		<option value="2">部负责人</option>
																		<option value="3">处室负责人</option>
																		<option value="4">处室人员</option>
																		<option value="5">中心负责人</option>
																		<option value="6">中心人员</option>
																		</select></span>
								<span class="inputPrompt"></span>
							</div>
							<div class="addPointInputBox">
								<span class="inputTitle inputModifyTitle"><tt>*</tt>电子邮箱：</span>
								<span class="inputDiv inputModifyDiv"><input id="email" type="text" maxlength="64" name="email" /></span>
								<span class="inputPrompt"></span>
							</div>
							
							<div class="addPointInputBox">
								<span class="inputTitle inputModifyTitle"><tt>*</tt>密码：</span>
								<span class="inputDiv inputModifyDiv"><input id="password" type="password" name="password" value="" /></span>
								<span class="inputPrompt"></span>
							</div>

							<div class="addPointInputBox">
								<span class="inputTitle inputModifyTitle"><tt>*</tt>确认密码：</span>
								<span class="inputDiv inputModifyDiv"><input id="qr_password" type="password" name="qr_password" value="" /></span>
								<span class="inputPrompt"></span>
							</div>
							
							
							<div class="addPointInputBox addUserBox">
									<span class="inputTitle inputModifyTitle">登陆ip限制：</span>
									<span class="inputTextarea addUserTextarea">
										<textarea id="umiLoginIp" name="umiLoginIp"></textarea>
									</span>
							</div>
						

						</div>
<!-- addPointInput end -->

<!-- submit start -->
						<div class="submitBox modifyBox">
							<span class="submitBnt"><a href="###" onclick="submitForm()"></a></span>
							<span class="returnBnt"><a href="/systemManage/toUserManage"></a></span>
						</div>
<!-- submit end -->

<!-- submit success start -->
						<div class="restate" style="display:none">
							<span ><img src="/static/images/loading.gif" />提交成功</span>
						</div>
<!-- submit success end -->

					</form>
					</div>
					
				
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
