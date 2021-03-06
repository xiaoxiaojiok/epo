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
function todo(url){
	parent.document.getElementById("middleFrame").src = url;
}
</script>

</head>
<body>
<div class="con">
<!-- topNav start -->
	<div class="topNav">
		<c:forEach items="${menuList}" var="one_menu">
				<c:if test="${one_menu.status eq 1}">
					<div <c:choose>
					       <c:when test="${one_menu.id eq pMenuId}">
					       	class="navDiv act"
					       </c:when>
					       <c:otherwise>
					       	class="navDiv"
					       </c:otherwise>
						</c:choose>
					>
					<a href="${one_menu.menuUrl}/${one_menu.id}" >${one_menu.menuName}</a>
					</div>
				</c:if>
		</c:forEach>
	</div>
<!-- topNav end -->

<!-- table content start -->
	<div class="tableContent">
	<table cellpadding="0" cellspacing="0">
		<tr>
			<td valign="top">
				<div class="tableContentLeft">
					<c:forEach items="${menu.subMenuList}" var="fir_menu">
						<c:if test="${fir_menu.status eq 1}">
							<div class="navSubTitle">
								<a <c:choose>
								       <c:when test="${fir_menu.id eq sMenuId}">
								       	class="act"
								       </c:when>
								       <c:otherwise>
								       	class=""
								       </c:otherwise>
									</c:choose>
								href="${fir_menu.menuUrl}/${fir_menu.id}" >
								${fir_menu.menuName}
								</a>
							</div>
							<c:forEach items="${fir_menu.subMenuList}" var="sec_menu">
								<c:if test="${sec_menu.status eq 1}">
									<div class="navSupTitle">
										<a <c:choose>
										       <c:when test="${sec_menu.id eq sMenuId}">
										       	class="act"
										       </c:when>
										       <c:otherwise>
										       	class=""
										       </c:otherwise>
											</c:choose>
										href="${sec_menu.menuUrl}/${sec_menu.id}" >
										${sec_menu.menuName}
										</a>
									</div>
								</c:if>
							</c:forEach>
						</c:if>
					</c:forEach>
				</div>
			</td>
			<td class="tdBak" valign="top">
				<div class="tableContentRight">
					<div class="currentPosition">
					&nbsp;&nbsp;&nbsp;&nbsp;当前位置：&nbsp;&nbsp;<a href="${fUrl }" >${fMenu }</a>
					&nbsp;>&nbsp;<a href="${sUrl }" >${sMenu }</a>
					<c:if test="${not empty tMenu}">&nbsp;>&nbsp;<a href="${tUrl }" >${tMenu }</a></c:if>
					</div>
				
				<!-- 页面内容 start -->

<!-- table content start -->
					
					<div class="addPoint">
<!-- addPointInput start -->
						<form action="/knowledgeDictLibManage/addLib">
						<div class="addPointInput modifyIndiv">
					
							<div class="addPointInputBox">
								<span class="inputTitle inputModifyTitle"><tt>*</tt>词库名称：</span>
								<span class="inputDiv inputModifyDiv"><input type=text name = "kdlName" value="${kdlName}" /></span>
								<span class="inputPrompt" id="exitName"></span>
							</div>

							<div class="addPointInputBox">
								<span class="inputTitle inputModifyTitle"><tt>*</tt>所属词库：</span>
								<span class="inputDiv inputModifyDiv">
								<select name="kdlParentIdLong" id="KnowledgeDictLib_kdlParentId">
								    
								</select>	
								</span>
								<span class="inputPrompt"></span>
							</div>
							
							
							<div id="rd">
						  		<c:if test="${dbId ne null and dbId ne 0}">
									<div class="addPointInputBox">
										<span class="inputTitle inputModifyTitle"><tt>*</tt>所属部门：</span>
										<span class="inputDiv inputModifyDiv">
							                 <select name="dbiIdLong" id="KnowledgeDictLib_dbiId">
								                  <option value="">--</option>
								                  <c:forEach var="db" items="${dblist }">
								                      <option <c:if test="${dbId eq db.id }"> selected="selected" </c:if> value="${db.id }">${db.dbiName }</option>
								                  </c:forEach>
								             </select>
										</span>
										<span class="inputPrompt"></span>
										
							
									</div>
					            </c:if>

							<c:if test="${rbId ne null and rbId ne 0}">
								<div class="addPointInputBox">
									<span class="inputTitle inputModifyTitle"><tt>*</tt>所属区县：</span>
									<span class="inputDiv inputModifyDiv">
							              <select name="rbiIdLong" id="KnowledgeDictLib_rbiId">
								                  <option value="">--</option>
								                  <c:forEach var="rb" items="${rblist }">
								                      <option <c:if test="${rbId eq rb.id }"> selected="selected" </c:if> value="${rb.id }">${rb.rbiName }</option>
								                  </c:forEach>
								             </select>
									</span>
									<span class="inputPrompt"></span>
								</div>
						    </c:if>
							
								
                            <c:if test="${parentId ne 1 and parentId ne 2 and parentId ne 3 and parentId ne null}">
                              
								<div class="addPointInputBox">
									<span class="inputTitle inputModifyTitle"><tt>*</tt>设置文件权重：</span>
									<span class="inputDiv inputModifyDiv">
		                                <select name="kdlIsWeight" id="KnowledgeDictLib_kdlIsWeight">
		                                    <options value="0">否</option>
 											<option <c:if test="${kdlIsWeight eq 1 }">selected="selected" </c:if> value="1">是</option>
						                </select>
									</span>
									<span class="inputPrompt"></span>
								</div>

									<div class="addPointInputBox">
										<span class="inputTitle inputModifyTitle"><tt>*</tt>生成文件名称：</span>
										<span class="inputDiv inputModifyDiv"> <input name="kdlFileName" id="KnowledgeDictLib_kdlFileName" type="text" maxlength="45" value="${kdlFileName }"/></span>
										<span class="inputPrompt"></span>
									</div>
								
						  </c:if>
								
							</div>
 <!--  zaici                          -->
                         </div>
							<div class="addPointInputBox addPointInputBox1">
								<span class="inputTitle inputModifyTitle">词库概述：</span>
								<span class="inputDiv inputModifyDiv">
								<input type="textArea" id="kdlDetail" name = "kdlDetail"  value="${kdlDetail }"/>
								</span>
							</div>
                      
					
						</form>
<!-- addPointInput end -->

<!-- submit start -->
						<div class="submitBox modifyBox">
						
							<span class="submitBnt"><a  onclick="submitForm()"></a></span>
							<span class="returnBnt"><a onclick="window.history.go(-1)"></a></span>
						</div>

<!-- submit end -->

<!-- submit success start -->
						<div class="restate" style="display:none">
							<span ><img src="${ctx}/static/images/loading.gif" />提交成功</span>
						</div>

						
<!-- submit success end -->
					</div>
					<input type="hidden" value="${parentId }" id="pardentId">
					<input type="hidden" value="" id="level">
					<input type="hidden" value="${rbId}" id="rbId">
					<input type="hidden" value="${dbId}" id="dbId">
					<input type="hidden" value="${kdlFileName}" id="kdlFileName">
					<input type="hidden" value="${kdlIsWeight}" id="kdlIsWeight">
					<input type="hidden" value="/knowledgeDictLibManage/getlistLib" id="getlist">
					<input type="hidden" value="/knowledgeDictLibManage/getlistROrD" id="rdlist">
					<input type="hidden" value="${id }" id="kdlId" name="id">
					

	
<!-- table content end -->


 

<script type="text/javascript">

$(function()
{
	$("#exitName").html('');
	var lib=$("#KnowledgeDictLib_kdlParentId");//词库列表
	//所属词库列表
	$.ajax({url:$("#getlist").val(),
		type:'get',
		async:false,
		//data:{level:($("#level").val()-1)},
		success:function(msg){
			var Item=$("#pardentId").val();
			var options = "";
			for(var j=0;j<msg.length;j++){
				if (Item==msg[j].id)
				{
					options += '<option selected="selected" value="' + msg[j].id + '">' + msg[j].name + '</option>'; //选中
				} 
				else {
					options += '<option value="' + msg[j].id + '">' + msg[j].name + '</option>'; //遍历赋值
				}
			}
			
			lib.html(options);
		}
	});

	//部门列表与曲线列表
	lib.change(function() {
		if(lib.val()==2){
				$.ajax({url:$("#rdlist").val(),
						type:'post',
						async:false,
						data:{region:true},
						success:function(msg){
							var rbId=$("#rbId").val();
							var options = '';
							options +='<div class="addPointInputBox">';
							options +='<span class="inputTitle inputModifyTitle"><tt>*</tt>所属区县：</span>';
							options +='<span class="inputDiv inputModifyDiv">';
							options +='<select name="rbiIdLong" id="KnowledgeDictLib_rbiId">';
							options += "<option value=\"\">" + "--" + "</option>";
							for(var j=0;j<msg.length;j++){
								if (rbId==msg[j].id){
									options += '<option selected="selected" value="' + msg[j].id + '">' + msg[j].name + '</option>';
								}
								else{
								options += '<option value="' + msg[j].id + '">' + msg[j].name + '</option>'; //遍历赋值
								}
							}
							options +='</select></span>';
							options +='<span class="inputPrompt"></span>';
							options +='</div>';
							
							
							$("#rd").html(options);
						}
				});		
		}

		if(lib.val()==3){
				$.ajax({url:$("#rdlist").val(),
						type:'post',
						async:false,
						data:{region:false},
						success:function(msg){
							var dbId=$("#dbId").val();
							var options = '';
							options +='<div class="addPointInputBox">';
							options +='<span class="inputTitle inputModifyTitle"><tt>*</tt>所属部门：</span>';
							options +='<span class="inputDiv inputModifyDiv">';
							options +='<select name="dbiIdLong" id="KnowledgeDictLib_dbiId">';
							options += "<option value=\"\">" + "--" + "</option>";
							for(var j=0 ;j<msg.length;j++){
								if (dbId==msg[j].id){
									options += '<option selected="selected" value="' + msg[j].id + '">' + msg[j].name + '</option>';
								}
								else{
								options += '<option value="' + msg[j].id + '">' + msg[j].name + '</option>'; //遍历赋值
								}
							}
							options +='</select></span>';
							options +='<span class="inputPrompt"></span>';
							options +='</div>';
							
							
							$("#rd").html(options);
						}
				});		
		}

		if(lib.val()!=3 && lib.val()!=2){
			
			$("#rd").html('');	 
			
			if(lib.val()!=1){
				var kdlFileName = $('#kdlFileName').val();
				var kdlIsWeight = $('#kdlIsWeight').val();
				var options = '';
				options +='<div class="addPointInputBox">';
					options +='<span class="inputTitle inputModifyTitle"><tt>*</tt>设置文件权重：</span>';
					options +='<span class="inputDiv inputModifyDiv">';
					options +='<select name="kdlIsWeight" id="KnowledgeDictLib_kdlIsWeight">';
					//options += "<option value=\"\">" + "--" + "</option>";
					options += "<option value=\"0\">否</option>";
					if(kdlIsWeight==1){
						options += "<option selected=\"selected\" value=\"1\">是</option>";
					}
					else{
					    options += "<option value=\"1\">是</option>";
					}
					options +='</select></span>';
					options +='<span class="inputPrompt"></span>';
				options +='</div>';

				options +='<div class="addPointInputBox">';
				options +='<span class="inputTitle inputModifyTitle"><tt>*</tt>生成文件名称：</span>';
				options +='<span class="inputDiv inputModifyDiv"><input name="kdlFileName" id="KnowledgeDictLib_kdlFileName" type="text" maxlength="45" value="'+kdlFileName+'"/></span>';
				options +='<span class="inputPrompt"></span>';
				options +='</div>';
				

				$("#rd").html(options);
			}
		}

	});

	

});

//表单提交
function submitForm(){
	//获取表单数据对象
	var formLabel = $("form").find('input[type="text"],select,textArea');
	//获取表单数据
	var dataLabel = requiredLabel(formLabel);
	//如果检测必填数据为空，返回页面
	if(dataLabel==false){
		return false;
	}

	var hasErrors = inputPrompt();
	dataLabel[$("#kdlId").attr("name")] = $("#kdlId").val();
	dataLabel[$("#kdlDetail").attr("name")] = $("#kdlDetail").val();
	//提交表单
	if(hasErrors==false){
		
		$.ajax({url:$("form").attr("action"),
		type:'post',
		async:false,
		data:dataLabel,
		dataType:"json",
		success:function(msg){
		
			if(msg.exit){
				
				$("#exitName").html("<a href=\"/knowledgeDictLibManage/knowledgeDictLibManageToAddLib\">词库已存在，更新失败！");
			}
			else if(msg.errors){
				
					$(".restate span").html("<img src=\"${ctx}/static/images/loading.gif\" />");
					$(".importPrompt").html();
					$(".restate span").append("更新词库失败");
					$(".restate").css("display","block");
				}else{
					
					$(".restate span").html("<img src=\"${ctx}/static/images/loading.gif\" />");
					$(".importPrompt").html();
					$(".restate span").append("更新词库成功");
					$(".restate").css("display","block");
				}

			setInterval("$('.restate').css('display','none')",3000);
		}
	});
	
	}


}

//验证不能为空，若都有值则返回表单数组
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

		//词库文件名验证
		var temp = $("#KnowledgeDictLib_kdlFileName");
		var myreg = /[\W]/;

		if(temp.val()!='undefined' && temp.val()!=''){
			if(myreg.test(temp.val()))
			{	status = 1;
				$(temp).parent().next().html("词库文件名只能输入英文、数字、下划线");
			}else{
				$(temp).parent().next().html('');
			}
		}

		if($("#KnowledgeDictLib_kdlParentId").val()==$("#kdlId").val()){
			$("#KnowledgeDictLib_kdlParentId").parent().next().html("所属词库不能与本身一样！");
			status = 1;
		}else{
			$("#KnowledgeDictLib_kdlParentId").parent().next().html("");
		}

	}

	if(status!=1){
		return data;
	}else{
		return false;
	}
}

function inputPrompt(){
	for(var i=0;i<$(".inputPrompt").length;i++){
			if($($(".inputPrompt")[i]).html()==""){
				return false;
			}else{
				return true;
			}
	}
}

$("#KnowledgeDictLib_kdlParentId").change(function(){
	if($("#KnowledgeDictLib_kdlParentId").val()==$("#kdlId").val()){
		$("#KnowledgeDictLib_kdlParentId").parent().next().html("所属词库不能与本身一样！");
	}else{
		$("#KnowledgeDictLib_kdlParentId").parent().next().html("");
	}

});



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
