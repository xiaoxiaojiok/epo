
function query(){
	var pUnit = $("#p_unit option:selected").val();
	var unitName = $("#name").val();
	var unitCode = $("#unitCode").val();
	var paras = "page=1&unitName=" + encodeURI(unitName,"utf-8") + "&unitCode=" + unitCode + "&pUnit=" + pUnit;
	base.load("list",baseUrl + "/list?" + paras,function(){
		base.showList("head","list","edit");
	});
}

function edit(i){
	base.load("edit",baseUrl + "/edit/" + i,function(){
		base.showEdit("head","list","edit");
		changeUnit();
	});
}

function delMore(){
	var ids = base.getChecked("cbx",true);
	del(ids);
}

function del(id){
	base.confirm("删除机构将会影响其下的所有子机构，您确定还要删除吗?",'',function(){
		base.request(baseUrl + "/delete","ids=" + id,function(result){
				if(result == "success"){
					base.tips("删除成功!",'success',1500);
					setTimeout(function(){
						base.cancel('head','list','edit');
					},2000)
				}else{
					base.tips("出现未知异常，操作失败!",'error');
				}
		},"POST","HTML");
	});
}

function save(){
	if(checkForm()){
		base.processStatus(1,'save_btn','process_btn');
		base.formSubmit(baseUrl + "/save",function(result){
				if(result == "success"){
					base.tips("操作成功!",'success',1500);
					setTimeout(function(){
						base.cancel('head','list','edit');
					},2000)
				}else{
					base.tips("出现未知异常，操作失败!",'error');
				}
		},"mainForm");
	}
}

function checkForm(){
	
	var unitName = $("#mainForm #unitName");
	if(unitName.val() == ""){
		base.alert("机构名称不能为空!");
		unitName.focus();
		return false;
	}
/*	
	var dwdm = $("#mainForm #dwdm");
	if(dwdm.val() == ""){
		base.alert("单位代码不能为空!");
		dwdm.focus();
		return false;
	}
*/	
	var dq_m = $("#mainForm #dq_m");
	if(dq_m.val() == ""){
		//base.alert("地区码不能为空!");
		base.alert("单位代码不能为空!");
		dq_m.focus();
		return false;
	}
	
	var gjdwdm = $("#mainForm #gjdwdm");
	if(gjdwdm.val() == ""){
		base.alert("国家单位代码不能为空!");
		gjdwdm.focus();
		return false;
	}
/*	
	var gldwdm = $("#mainForm #gldwdm");
	if(gldwdm.val() == ""){
		base.alert("管理单位代码不能为空!");
		gldwdm.focus();
		return false;
	}
*/	
	return true;
}

function setup(id,status){
	base.request(baseUrl + "/setup","id=" + id + "&status=" + status,function(result){
				if(result == "success"){
					base.tips("修改成功!",'success',1500);
					if(status == 1){
						$("#setUnable" + id).show();
						$("#setAble" + id).hide();
						$("#statusDisplay" + id).html("正常");
					}else{
						$("#setUnable" + id).hide();
						$("#setAble" + id).show();
						$("#statusDisplay" + id).html("<font color='red'>禁用</font>");
					}
				}else{
					base.tips("出现未知异常，操作失败!",'error');
				}
	},"POST","HTML");
}

function changeUnit(profix){
	var topUnit = $("#topUnit").find("option:selected").val();
	var unitCode = $("#unitCodeNo").val();
	var value = "";
	if(topUnit == 0 || topUnit == ""){
		$("#t_unit").text("");
		if ($("#id").val() != "" && $("#dq_m").val() != "") {
			if($("#gldwdm").val() != ""){
				value = $("#gldwdm").val();
			}else{
				value = $("#dq_m").val();
			}
			$("#gldwdm").val(value);
			$("#dq_m_show").text(value);
			$("#gldwdm_show").text(value);
			$("#gjdwdm_show").text(value + "000");
			$("#dq_m").val(value);
		}else {
			value = $("#gldwdm").val();
			$("#dq_m_show").text(value);
			$("#dq_m").val(value);
			$("#gldwdm_show").text(value);
			$("#gjdwdm_show").text(value + "000");
		}
	}else{
		var length = topUnit.length;
		var suffix = ""; 
		var l = 2;
		if(topUnit.substring(2, length) == "0000000"){
			topUnit = topUnit.substring(0, 2);
			//suffix = unitCode.substring(topUnit.length, unitCode.length)
		}else if(topUnit.substring(4, length) == "00000"){
			topUnit = topUnit.substring(0, 4);
			suffix = unitCode.substring(topUnit.length, unitCode.length)
		}else if(topUnit.substring(6, length) == "000"){
			topUnit = topUnit.substring(0, 6);
			suffix = unitCode.substring(topUnit.length, unitCode.length)
			l = 3;
		}else{
			topUnit = topUnit.substring(0, length);
			//suffix = unitCode.substring(0, unitCode.length)
			l = 3;
		}
		$("#t_unit").text("");
		$("#t_unit").text(topUnit);
		$("#inputLength").val(l);
		
		if($("#gldwdm").val() == ""){
			$("#gldwdm").val(suffix);
		}
		
		//设置地区码、管理单位代码，暂时他们的值跟机构代码一至
		value = $("#gldwdm").val();
		$("#dq_m_show").text(topUnit + value);
		$("#dq_m").val(topUnit + value);
		$("#gldwdm_show").text(topUnit + value);
		$("#gjdwdm_show").text(topUnit + value + "000");
		
		if(profix != "notExsit" && value != ""){
			checkUnitCode($("#gldwdm").val(),$("#id").val());
		}
	}
}

function checkUnitCode(unitCode,unit_id){
	unitCode = $("#t_unit").text() + unitCode;
	if($("#gldwdm").val() == "") return;
	base.request(baseUrl + "/checkUnitCode","unitCode=" + unitCode,function(result){
		if(result == "notExsit"){
			changeUnit("notExsit");
		}else{
			if(result != unit_id){
				base.alert("该单位代码已经存在，请重新输入！");
				$("#gldwdm").val("");
				$("#gldwdm").focus();
				
				var value = $("#gldwdm").val();
				$("#dq_m_show").text(topUnit + value);
				$("#dq_m").val(topUnit + value);
				$("#gldwdm_show").text(topUnit + value);
				$("#gjdwdm_show").text(topUnit + value + "000");
			}else{
				changeUnit("notExsit");
			}
		}
	},"POST","HTML");
}


function exportUnit(){
	var pUnit = $("#p_unit option:selected").val();
	var unitName = $("#name").val();
	var unitCode = $("#unitCode").val();
	var params = "unitName=" + encodeURI(unitName,"utf-8") + "&unitCode=" + unitCode + "&pUnit=" + pUnit + "&"+Math.round(Math.random() * 10000);
	base.forward(baseUrl + "/export?" + params);
}

function importUnit(){
	base.forward(baseUrl + "/importInit");
}
