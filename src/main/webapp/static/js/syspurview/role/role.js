
function roleQuery()
{	
	var roleName = $('#roleName').val();
	roleName = roleName==undefined?"":roleName;
	var paras='roleName=' + roleName;
	base.load("list","/role/query.do?" + paras,function(){
		base.showList("head","list","edit");		//标签的显示与隐藏，显示head、list、隐藏edit
	});
}

function editRole(id){
	if(id=undefined)id=null;
	base.load("edit","/role/edit.do",function(){
		base.showEdit("head","list","edit");
	});
	
}

function del(id){
	base.confirm("您确定要删除角色吗?",'',function(){
		base.request("/role/delete","ids=" + id,function(result){
				if(result == "success"){
					base.tips("删除成功!",'success',1500);
					setTimeout(function(){
						base.cancel('head','list','edit',roleQuery);
					},2000)
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

function save(){
		var roleName=$("#name").val();
		if(roleName==""){
			base.tips("先填写角色名称",'error',1500);
			return;
		}
		base.processStatus(1,'save','process');
		base.formSubmit("/role/save",function(result){
				if(result == "success"){
					base.tips("保存成功!",'success',1500);
					setTimeout(function(){
						base.forward("/role/index");
					},2000);
				}else{
					base.tips("出现未知异常，操作失败!",'error');
				}
				base.processStatus(0,'save','process');
		},"roleForm");
}

function setRoleUnit(){
	var roleType = $("#roleTypeId").val();
	if(roleType==5){
		$("#roleUnitId").val(0);
		$("#roleUnitDiv").hide();
	}else{
		$("#roleUnitDiv").show();
	}
	
}


function changeDept(){
	var orgid = $("#org_id").val();
	if(orgid==0)return;
	base.request(
			'/department/getDeptSelectByOrgId',
			'orgid='+orgid,
			function(data){
				var depts = data.dept_select;
				if(data.success == "falid"){
					$("#dept_id").empty();
					base.tips("此公司下面没有部门信息!",'error');
				} else{
					$("#dept_id").empty();
					$("#dept_id").append("<option value='0'>请选择</option>"+depts);
				}		
			},
			'POST','json'
	);	
}

/*
 * 停用
 */
 function stopRole(roleid)
 {
	  $.ajax({
		   url:'/role/stop/'+roleid,
		   type:'get', //数据发送方式 
		   async:false,//同步
		   dataType:'text', //接受数据格式       
		   data:null, //要传递的数据       
		   success:
			   function (data){//回传函数(这里是函数名) 
			      if(data=='true')
			       {
			    	  base.tips("停用成功!",'success',1500);
			    	 $("#dg").datagrid("reload");
			       }
			      else
			       {
			    	  alert('角色停用失败!');
			       }
		       }
	  });
 }
 /*
 * 启用
 */
 function startRole(roleid)
 {
	  $.ajax({
		   url:'/role/start/'+roleid,
		   type:'get', //数据发送方式 
		   async:false,//同步
		   dataType:'text', //接受数据格式       
		   data:null, //要传递的数据       
		   success:
			   function (data){//回传函数(这里是函数名) 
			      if(data=='true')
			       {
			    	  base.tips("启用成功",'success',1500);
			    	  $("#dg").datagrid("reload");
			       }
			      else
			       {
			    	  alert('角色启用失败!');
			       }
		       }
	  });
 }
 
 /*
  * 授权
  */
  function accredit(roleid)
  {
	  window.location.href="/role/accredit/"+roleid;
  }
  
  /*
   * 修改
   */
   function edit(roleid)
   {
	   base.forward("/role/update/"+roleid);
   }
