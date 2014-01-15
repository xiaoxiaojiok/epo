function codeQuery(){
	var mtype = $("#sear_mtype").val();
	$("#dg").datagrid("load", {mtype: mtype});
	
}


function del(id){
	base.confirm("您确定要删除此码吗?",'',function(){
		base.request("/mcode/delete","ids=" + id,function(result){
				if(result == "success"){
					base.tips("删除成功!",'success',1500);
					setTimeout(function(){
						$("#dg").datagrid("reload");
					},2000);
				}else{
					base.tips("出现未知异常，操作失败!",'error');
				}
		},"POST","HTML");
	});
}

function delMore(){
	var mrow = $("#dg").datagrid("getSelections");
	var ids = [];
	if(mrow.length>0){
		for(var i = 0;i<mrow.length;i++){
			 ids.push(mrow[i].id);
		}
		del(ids);
	}else{
		$.messager.alert('提示','请选择您要删除的记录','warning');
	}
}

function edit(i){
	base.forward("/mcode/edit/"+i);
}

function save(){
	if(checkForm()){
		base.processStatus(1,'save','process');
		base.formSubmit("/mcode/save",function(result){
				if(result == "success"){
					base.tips("操作成功",'success',1500);
					setTimeout(function(){
						base.forward("/mcode/index");
					},2000);
				}else{
					base.tips("出现未知异常，操作失败!",'error');
				}
				base.processStatus(0,'save','process');
		},"mcodeForm");
	}else{
		$("#password").blur();
		base.tips("请完善用户信息!",'warning',1500);
	}
}

function checkForm(){
	checks('mtype');
	checks('mkey');
	checks('mvalue');
	if(($("#tipone").html()=="" && $("#tiptwo").html()=="" && $("#tipthree").html()=="")){  
		return true;
	}else{
		return false;
	}
}

function checks(id){
	if(id=='mtype'){
		var types = $("#mtype").val();
		if(types==""){
			$("#tipone").html("码类型不能为空！");
			$("#mtype").focus();
		}else{
			$("#tipone").html("");
		}
	}else if(id=='mkey'){
		var keys = $("#mkey").val();
		if(keys==""){
			$("#tiptwo").html("码名称不能为空！");
			$("#mkey").focus();
		}else{
			$("#tiptwo").html("");
		}		
	}else if(id=='mvalue'){
		var mvalue = $("#mvalue").val();
		if(mvalue==""){
			$("#tipthree").html("码值不能为空！");
			$("#mvalue").focus();
		}else{
			$("#tipthree").html("");
		}
	}	
}