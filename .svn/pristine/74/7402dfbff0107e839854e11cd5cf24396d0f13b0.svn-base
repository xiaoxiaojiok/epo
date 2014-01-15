function searchMySets(){
	$("#key").val(0);
	base.request(
			'/alertset/query',
			'',
			function(data){
				if(data.success == "success"){
					$("#key").val(1);
					var set1 = data.set1;
					var set2 = data.set2;
					var set3 = data.set3;
					var set4 = data.set4;
					var set5 = data.set5;
					var set6 = data.set6;
					$("#time1").val(set1.time1);
					$("#time2").val(set2.time2);
					$("#time3").val(set3.time3);
					$("#time4").val(set4.time4);
					$("#time5").val(set5.time5);
					$("#time6").val(set6.time6);
					$("#id1").val(set1.id1);
					$("#id2").val(set2.id2);
					$("#id3").val(set3.id3);
					$("#id4").val(set4.id4);
					$("#id5").val(set5.id5);
					$("#id6").val(set6.id6);
					if(set1.isemail1==1){
						$("#isemail1").attr("checked",true);
					}
					if(set2.isemail2==1){
						$("#isemail2").attr("checked",true);
					}
					if(set3.isemail3==1){
						$("#isemail3").attr("checked",true);
					}
					if(set4.isemail4==1){
						$("#isemail4").attr("checked",true);
					}
					if(set5.isemail5==1){
						$("#isemail5").attr("checked",true);
					}
					if(set6.isemail6==1){
						$("#isemail6").attr("checked",true);
					}
					if(set1.ismessage1==1){
						$("#ismessage1").attr("checked",true);
					}
					if(set2.ismessage2==1){
						$("#ismessage2").attr("checked",true);
					}
					if(set3.ismessage3==1){
						$("#ismessage3").attr("checked",true);
					}
					if(set4.ismessage4==1){
						$("#ismessage4").attr("checked",true);
					}
					if(set5.ismessage5==1){
						$("#ismessage5").attr("checked",true);
					}
					if(set6.ismessage6==1){
						$("#ismessage6").attr("checked",true);
					}
				}	
			},
			'POST','json'
	);
}

function alertQuery(){
	$("#dg").datagrid("load", sy.serializeObject($("#sear_forms").form()));
}


function saveSets(key){
		base.processStatus(1,'save','process');
		base.formSubmit("/alertset/save",function(result){
				if(result == "success"){
					base.tips("操作成功",'success',1500);
					setTimeout(function(){
						base.forward("/alertset/index");
					},2000);
				}else{
					base.tips("出现未知异常，操作失败!",'error');
				}
				base.processStatus(0,'save','process');
		},"alertForm");
	
}



function alertformatter1(value,row,index){
	var imgurl = getimgurl(value);
	var htmls ="";
	if(value==4){
		htmls = "<div style='float: left;'><a href='javascript:void(0);' onclick='setInfo(1,"+row.proid+","+row.proName+")'><img src='"+imgurl+"' /></a></div>";
	}else{
		htmls="<div style='float: left;'><img src='"+imgurl+"' /></div>";
	}
	 
	return htmls;
}

function alertformatter2(value,row,index){
	var currentUserId = $("#currUserId").val();
	var imgurl = getimgurl(value);
	var htmls ="";
	if(value==4){
		if(row.managerId==currentUserId){
			htmls = "<div style='float: left;border:none;'><a href='javascript:void(0);' onclick='javascript:setInfo(2,"+row.proid+","+index+");'><img style='border:none;' src='"+imgurl+"' /></a></div>";
		}else if(row.desc!=""){
			var id = row.proid;
			htmls ="<div onMouseOver='javascript:showAlertInfo(event,"+index+");' onMouseOut='javascript:hideAlertInfo();' style='float: left;'><img src='"+imgurl+"'/></div>";
		}else{
			htmls="<div style='float: left;'><img src='"+imgurl+"' /></div>";
		}		
	}else{
		htmls="<div style='float: left;'><img src='"+imgurl+"' /></div>";
	}
	 
	return htmls;
}
function alertformatter3(value,row,index){
	var currentUserId = $("#currUserId").val();
	var imgurl = getimgurl(value);
	var htmls ="";
	if(value==4){
		if(row.managerId==currentUserId){
			htmls = "<div style='float: left;'><a href='javascript:void(0);' onclick='javascript:setInfo(3,"+row.proid+","+index+");'><img src='"+imgurl+"' /></a></div>";
		}else if(row.desc!=""){
			var id = row.proid;
			htmls ="<div  onMouseOver='javascript:showAlertInfo(event,"+index+");' onMouseOut='javascript:hideAlertInfo();'  style='float: left;'><img src='"+imgurl+"'/></div>";
		}else{
			htmls="<div style='float: left;'><img src='"+imgurl+"' /></div>";
		}	
	}else{
		htmls="<div style='float: left;'><img src='"+imgurl+"' /></div>";
	}
	 
	return htmls;
}
function alertformatter4(value,row,index){
	var currentUserId = $("#currUserId").val();
	var imgurl = getimgurl(value);
	var htmls ="";
	if(value==4){
		if(row.managerId==currentUserId){
			htmls = "<div style='float: left;'><a href='javascript:void(0);' onclick='javascript:setInfo(4,"+row.proid+","+index+");'><img src='"+imgurl+"' /></a></div>";
		}else if(row.desc!=""){
			var id = row.proid;
			htmls ="<div  onMouseOver='javascript:showAlertInfo(event,"+index+");' onMouseOut='javascript:hideAlertInfo();' style='float: left;'><img src='"+imgurl+"'/></div>";
		}else{
			htmls="<div style='float: left;'><img src='"+imgurl+"' /></div>";
		}	
	}else{
		htmls="<div style='float: left;'><img src='"+imgurl+"' /></div>";
	}
	 
	return htmls;
}
function alertformatter5(value,row,index){
	var imgurl = getimgurl(value);
	var htmls ="";
	if(value==4){
		htmls = "<div style='float: left;'><a href='javascript:void(0);' onclick='setInfo(5,"+row.proid+","+row.proName+")'><img src='"+imgurl+"' /></a></div>";
	}else{
		htmls="<div style='float: left;'><img src='"+imgurl+"' /></div>";
	}
	return htmls;
}
function alertformatter6(value,row,index){
	var imgurl = getimgurl(value);
	var htmls ="";
	if(value==4){
		htmls = "<div style='float: left;'><a href='javascript:void(0);' onclick='setInfo(6,"+row.proid+","+row.proName+")'><img src='"+imgurl+"' /></a></div>";
	}else{
		htmls="<div style='float: left;'><img src='"+imgurl+"' /></div>";
	}
	 
	return htmls;
}

function setInfo(level,id,index){
	$('#dg').datagrid('selectRow', index);
	$("#addAlertInfo").show();
    $("#addAlertInfo").dialog({
        closed: false,
        cache: false,
        modal: true,
		buttons:[{
			text:'添加',
			handler:function(){
				base.processStatus(1,'save','process');
				base.formSubmit("/alert/saveInfo",function(result){
						if(result == "success"){
							base.tips("操作成功",'success',1500);
							setTimeout(function(){
								base.forward("/alert/index");
							},2000);
						}else{
							base.tips("出现未知异常，操作失败!",'error');
						}
						base.processStatus(0,'save','process');
				},"myformdata");
			}
			}]
	    });
   var row= $('#dg').datagrid('getSelected');
   if(row){
	   $("#projId").val(row.proid);
	   $("#projName").val(row.proName);
	   $("#projDesc").val(row.desc);
	}
  $("#projLevel").val(getLevelName(level));
 
  
}

function getLevelName(level){
	switch(level){
		case 1:
			return "申报";
			break;
		case 2:
			return "设计";
			break;
		case 3:
			return "施工";
			break;
		case 4:
			return "验收";
			break;
		case 5:
			return "竣工";
			break;
		case 6:
			return "转固";
			break;					
	}
}

function showInfo(id) {  
    var objDiv = document.getElementById("infoDiv"+id);
    $("#infoDiv"+id).show();
    $("#infoDiv"+id).dialog({
        closed: false,
        cache: false,
        modal: true,
		buttons:[{
			text:'添加',
			handler:function(){
				
			}
			}]
	    });
}
function hideInfo(id) {
	var objDiv = document.getElementById("infoDiv"+id);
    $(objDiv).css("display", "none");
} 

/**
 * 导出项目预警信息
 * @return
 */
function exportAlertInfo(){
	var typeid = $("#typeId").find("option:selected").val();
	var pertyid = $("#pertyId").find("option:selected").val();
	var exporttype = $("#exportType").find("option:selected").val();
	var proname = $("#proName").val();
	var params = "typeId=" + typeid + "&pertyId=" + pertyid+ "&proName=" + base.encode(proname) +"&exportType="+exporttype;
	base.forward("/alert/export?" + params);
}