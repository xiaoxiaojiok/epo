
function reportlist(){
	base.forward("/custom_report/reportlist");
}

function changeToQuery(){
	var id = $("#report_id").val();
	if(id==undefined)id=0;
	if(id==-1)return;
	var paras='id=' + id+'&page=1';
	base.load("list","/custom_report/queryById?" + paras,function(){
		base.showList("head","list","edit");		//标签的显示与隐藏，显示head、list、隐藏edit
	});
}

function queryMyReport(){
	var paras='page=1';
	base.load("list","/custom_report/queryMyReport?" + paras,function(){
		base.showList("head","list","edit");		//标签的显示与隐藏，显示head、list、隐藏edit
	});
}

function edit(id){
	base.forward("/custom_report/edit/"+id);
}

function showSelect(){
	var tabName = $("#tabName").val();
	if(tabName=="" || tabName=="0"){
		$("#selectDiv").empty();
		return;		
	}
	base.request(
			'/custom_report/getSelectByTable',
			'tabName='+tabName,
			function(data){
				if(data.success == "falid"){
					$("#selectDiv").empty();
				} else{
					var htmls = data.selectHtml;
					$("#selectDiv").empty();
					$("#selectDiv").append(htmls);
				}		
			},
			'POST','json'
	);	
}

function combField(){
	var tabName = $("#tabName").val();
	if(tabName=="0"){
		base.tips("请先选择表!",'error');
		return ;
	}
	base.request(
			'/custom_report/getCombFieldsByTable',
			'tabName='+tabName,
			function(data){
				if(data.success == "falid"){
					$("#combLeft").empty();
					$("#combRight").empty();
				} else{
					var htmls = data.selectHtml;
					$("#combLeft").empty();
					$("#combLeft").append(htmls);
					$("#combRight").empty();
					$("#combRight").append(htmls);
				}		
			},
			'POST','json'
	);	
	
}

function addCombField(){
	var combName = $("#tempComName").val();
	if(combName==""){
		base.tips("请先选择表!",'error');
		return ;
	}
	var combleft = $("#combLeft").val();
	var combright = $("#combRight").val();
	if(combField=="" || combright==0){
		base.tips("请先指定组合列!",'error');
		return ;
	}
	var oper = $("#operators").val();
	var nfcount = $("#nfCount").val();
	nfcount = nfcount==""?1:nfcount+1;
	var newV =combleft+"/"+oper+"/"+combright; 
	var newF = "<div>组合列：<input type='hidden' name='nfv"+nfcount+"' value='"+newV+"' /><input type='hidden' name='nfname"+nfcount+"' value='"+combName+"'/>"+combName+"<br/></div>";
	$("#selectDiv").append(newF);
	$("#nfCount").val(nfcount);
}

function save(key){
	var tabName = $("#tabName").val();
	if(tabName=="0"){
		base.tips("请先选择表!",'error');
		return ;
	}
	base.processStatus(1,'save','process');
	base.formSubmit("/custom_report/save",function(result){
			if(result == "success"){
				base.tips("操作成功",'success',1500);
				setTimeout(function(){
					base.forward("/custom_report/index");
				},2000)
			}else{
				base.tips("出现未知异常，操作失败!",'error');
			}
			base.processStatus(0,'save','process');
	},"reportForm");
}


function del(id){
	base.confirm("您确定要删除该报表吗?",'',function(){
		base.request("/custom_report/delete","ids=" + id,function(result){
				if(result == "success"){
					base.tips("删除成功!",'success',1500);
					setTimeout(function(){
						base.forward("/custom_report/reportlist");
					},2000);
				}else{
					base.tips("出现未知异常，操作失败!",'error');
				}
		},"POST","HTML");
	});
}

function delMore(){
	var ids = base.getChecked("cbx",true);
	del(ids);
}

function exportReport(){
	var exportId = $("#report_id").val();
	if(exportId==0){
		base.tips("请先选择一条报表项",'error');
		return;
	}
	var exportType = $("#exportType").val();
	var params = "id=" + exportId + "&exportType="+exportType;
	base.forward("/custom_report/export?" + params);
	
}

