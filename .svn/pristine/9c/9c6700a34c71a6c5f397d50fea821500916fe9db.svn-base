//最终boxy选择器使用的数组集合
var arrGrade = new Array();
var arrClass = new Array();
//临时读取后台返回的数据集合
var tag = new Array();
var tac = new Array();
//用于保存cookie，如果是选择的同一学校，不用再查询后台数据库
var arrG = new Array();
var arrC = new Array();

var arrsubject = new Array();
var schoolArr = new Array();
var gradeArr = new Array();
var subjectArr = new Array();
var termArr = new Array();

/**
 * 考试类别选择器初始化数据
 */
function initExamCategory(){
	var initFirstExamCategoryArr  = document.getElementsByName("initFirstExamCategoryArr");
	var initSecondExamCategoryArr = document.getElementsByName("initSecondExamCategoryArr");
	var taFirst  = new Array();
	var taSecond = new Array();
	for(var i=0;i<initFirstExamCategoryArr.length;i++){
		var initFirstIdAndName = initFirstExamCategoryArr[i].value.split(","); 
		taFirst[i] = new Class(initFirstIdAndName[0], initFirstIdAndName[1]);	
	}
	for(var i=0;i<initSecondExamCategoryArr.length;i++){
		var initSecondIdAndNameAndUpid = initSecondExamCategoryArr[i].value.split(","); 
		taSecond[i] = new Item(initSecondIdAndNameAndUpid[0], initSecondIdAndNameAndUpid[1],initSecondIdAndNameAndUpid[2]);	
	}
	arrGrade = taFirst;
	arrClass = taSecond;	
}
/**
 * 考试类别选择器
 */
function selectExamCategory(){	
	initExamCategory();
	var examCategoryId = $("#examCategoryId").val();
	 Boxy.job(examCategoryId, "", function(valid,valname) {
		 	$("#examCategoryId").val(valid);
	        $("#examCategoryName").text(valname);
	        $("#examCategoryName").show();
		 	var ids = valid.split(",");
		 	var gid="";
		 	var cid="";
		 	for(var a=0;a<ids.length;a++){
		 		var t = ids[a].substring(0,1);
		 		var s = ids[a].substring(1,ids[a].length);
		 		if(t=="g"){
		 			gid+=s+",";
		 		}else if(t=="c"){
		 			cid+=s+",";
		 		}
		 	}
		 	if(gid.length>1){
		 		gid = gid.substring(0,gid.length-1);
		 	}
		 	if(cid.length>1){
		 		cid = cid.substring(0,cid.length-1);
		 	}
		 	$("#examCategoryFirstIds").val(gid);
		 	$("#examCategorySecondIds").val(cid);
	    }, { title: "考试类别选择器" });
}
/**
 * 初始化班级，年级数据
 * @return
 */
function initClassData(){
	var schoolId = $("#_xx_id").val();
	if(schoolId==0){
		Boxy.alert("请先选择学校！", null, { title: "提示信息"});
		return ;
	}
	var clsId = $("#clsId").val();
	//先判断有无存在cookie数据，如果不存在，访问后台接口查询班级，年级集合，如果存在，直接重构选择器
	if(arrG[schoolId]==undefined){
		base.request("/account/user/getGrades/"+schoolId,"",function(data){
			var success = data.result.success;
			if(success=="true"){
				var grades = data.result.grades;
				var cls = data.result.cls;
				for(var j=0;j<grades.length;j++){
					tag[j]=new Class(grades[j].id,grades[j].name);
				}
				for(var a=0;a<cls.length;a++){
					tac[a] = new Item(cls[a].id,cls[a].name,cls[a].upid);
				}
				
				arrG[schoolId] = tag;
				arrC[schoolId] = tac;
				arrGrade = tag;
				arrClass = tac;
				shows(clsId);
			}else{
				base.tips("该学校没有找到班级信息",'error');
			}
		},"POST","JSON");
	}else{
		arrGrade = arrG[schoolId];
		arrClass = arrC[schoolId];
		shows(clsId);
	}
	
}
/**
 * 生成选择器，并且将返回结果反馈于相关属性控件
 * @param value
 * @return
 */
function shows(value){
	 Boxy.job(value, "", function(valid,valname) {
		 $("#clsId").val(valid);
	        $("#clsName").text(valname);
	        $("#clsName").show();
		 	var ids = valid.split(",");
		 	var gid="";
		 	var cid="";
		 	for(var a=0;a<ids.length;a++){
		 		var t = ids[a].substring(0,1);
		 		var s = ids[a].substring(1,ids[a].length);
		 		if(t=="g"){
		 			gid+=s+",";
		 		}else if(t=="c"){
		 			cid+=s+",";
		 		}
		 	}
		 	if(gid.length>1){
		 		gid = gid.substring(0,gid.length-1);
		 	}
		 	if(cid.length>1){
		 		cid = cid.substring(0,cid.length-1);
		 	}
		 	$("#gradeIds").val(gid);
		 	$("#classIds").val(cid);
		 	changeSubject(gid,cid);
	    }, { title: "年级/班级选择器" });
}

function changeSubject(gid,cid){
	base.request("/public/getSubjectList","gradeCode="+gid+"&classId="+cid,function(data){
		var success = data.result.success;
		if(success=="true"){
			var subs = data.result.subjects;
			subjectArr = new Array();
		 	$("#subjectCode").val("");
	        $("#subName").text("");
			for(var i=0;i<subs.length;i++){
				subjectArr[i] = new Class(subs[i].id,subs[i].name);
			}
		}else{
			Boxy.alert("请先检查科目管理，设置对应年级的科目映射关系", null, { title: "提示信息"});
		}
	},"POST","JSON");
}

function selectSubject(){
	var subids = $("#subjectCode").val();
	if(subjectArr.length==0){
		base.tips("目前没有可选学科，请先选择年级班级信息",'error');
		return;
	}
	arrsubject = subjectArr;
	 Boxy.industry(subids, function(valid,valname) {
		 	$("#subjectCode").val(valid);
	        $("#subName").text(valname);
	    }, { title: "学科选择器" });
}

function selectTerm(){	
	var termids = $("#termIdArr").val();
	if(termArr.length==0){
		var initTermArr = document.getElementsByName("initTermArr");
		termArr = new Array();
		for(var i=0;i<initTermArr.length;i++){
			var initTermIdAndName = initTermArr[i].value.split(","); 
			termArr[i] = new Class(initTermIdAndName[0], initTermIdAndName[1]);		
		}
	}
	arrsubject = termArr;
	 Boxy.industry(termids, function(valid,valname) {
		 	$("#termIdArr").val(valid);
	        $("#termNameArr").text(valname);
	    }, { title: "学期选择器" });
}

function initSchoolData(dwid){
	base.request("/public/getSchoolList","dwid="+dwid,function(data){
		var success = data.result.success;
		if(success=="true"){
			var schs = data.result.schools;
			for(var i=0;i<schs.length;i++){
				schoolArr[i] = new Class(schs[i].id,schs[i].name);
			}
		}else{
			base.tips("没有获取到学校信息",'error');
		}
	},"POST","JSON");
}

function cominitSchoolData(){
	var dwid=$("#_dw_id").find("option:selected").val();
	var schoolType=$("#schoolType").find("option:selected").val();
	base.request("/public/getcomSchoolList","dwid="+dwid+"&schoolType="+schoolType,function(data){
		var success = data.result.success;
		if(success=="true"){
			var schs = data.result.schools;
			for(var i=0;i<schs.length;i++){
				schoolArr[i] = new Class(schs[i].id,schs[i].name);
			}
		}else{
			base.tips("没有获取到学校信息",'error');
		}
	},"POST","JSON");
	
	
}


function selectSchool(){
	var schoolsId = $("#schoolId").val();
	if(schoolArr.length==0){
		base.tips("目前没有可选学校，请确认该单位下有学校信息",'error');
		return;
	}
	arrsubject = schoolArr;
	 Boxy.industry(schoolsId, function(valid,valname) {
		 	$("#schoolId").val(valid);
	        $("#schoolName").text(valname);
	        changeGrade(valid);
	    }, { title: "学科选择器" });
}

function selectSchoolAnalyse(single){
	single =(single==undefined)?true:single;
	var schoolsId = $("#schoolId").val();
	if(schoolArr.length==0){
		base.tips("目前没有可选学校，请确认该单位下有学校信息",'error');
		return;
	}
	arrsubject = schoolArr;
	 Boxy.industry(schoolsId, function(valid,valname) {
		 	$("#schoolId").val(valid);
	        $("#schoolName").text(valname);
	        if(single){
	        	initGradeData(valid);
	        }else{
	        	showGradeData(valid);
	        	
	        }        
	    }, { title: "学科选择器" });
}

/**
 * 根据学校级联到年级单选
 * @param schoolIds
 */
function showGrade(){
	var schoolsId = $("#schoolId").val();
	if(schoolArr.length==0){
		base.tips("目前没有可选学校，请确认该单位下有学校信息",'error');
		return;
	}
	arrsubject = schoolArr;
	 Boxy.industry(schoolsId, function(valid,valname) {
		 	$("#schoolId").val(valid);
	        $("#schoolName").text(valname);
	        showGradeData(valid);
	    }, { title: "学科选择器" });
}

function showGradeData(schoolIds){
	base.request("/public/getGradeListBySchoolIds","schoolIds="+schoolIds,function(data){
		var success = data.result.success;
		if(success=="true"){
			var grades = data.result.grades;
			var opts="";
		//	alert(grades.length);
			for(var i=0;i<grades.length;i++){
				opts+="<option value=\""+grades[i].id+"\">"+grades[i].name+"</option>";
			}
			$("#gradeId").html("<option value=\"0\">请选择年级</option>"+opts);
		}
	},"POST","JSON");
	
}


/**
 * 根据年级联动科目单选
 * @param gradeId
 * @return
 */
function showSubject(gradeId){
	base.request("/public/getSubjectList","gradeCode="+gradeId+"&classId=",function(data){
		var success = data.result.success;
		if(success=="true"){
			var subs = data.result.subjects;
			for(var i=0;i<subs.length;i++){
				subjectArr[i] = new Class(subs[i].id,subs[i].name);
			}
		}else{
			Boxy.alert("请先检查科目管理，设置对应年级的科目映射关系", null, { title: "提示信息"});
		}
	},"POST","JSON");
}

/**
 * 根据年级级联班级并级联科目单选
 * @param gradeId
 */
function getClassSelectAndShowSubject(gradeId){
	var xx_id=$("#_xx_id").val();
	base.request("/account/user/getClassSelect","grade_code=" + gradeId+"&xx_id="+xx_id,function(result){
	var opts = result.result.class_select;
	$("#classs").html("<option value=\"0\">请选择</option>"+opts);
	},"POST","JSON");
	base.request("/public/getSubjectList","gradeCode="+gradeId+"&classId=",function(data){
		var success = data.result.success;
		if(success=="true"){
			var subs = data.result.subjects;
			for(var i=0;i<subs.length;i++){
				subjectArr[i] = new Class(subs[i].id,subs[i].name);
			}
		}else{
			Boxy.alert("请先检查科目管理，设置对应年级的科目映射关系", null, { title: "提示信息"});
		}
	},"POST","JSON");
}


function changeGrade(schoolIds){
	base.request("/public/getGradeSelectBySchoolIds","schoolIds="+schoolIds,function(data){
		var success = data.result.success;
		if(success=="true"){
			var grades = data.result.grades;
			$("#gradeId").html(grades);
		}
	},"POST","JSON");
}

function initGradeData(schoolIds){
	base.request("/public/getGradeListBySchoolIds","schoolIds="+schoolIds,function(data){
		var success = data.result.success;
		if(success=="true"){
			var grades = data.result.grades;
			for(var i=0;i<grades.length;i++){
				gradeArr[i] = new Class(grades[i].id,grades[i].name);
			}
		}
	},"POST","JSON");
}

function selectGradeAnalyse(){
	var gradesId = $("#gradeIds").val();
	if(gradeArr.length==0){
		base.tips("目前没有可选年级",'error');
		return;
	}
	arrsubject = gradeArr;
	 Boxy.industry(gradesId, function(valid,valname) {
		 	$("#gradeIds").val(valid);
	        $("#gradeNames").text(valname);
	        changeSubject(valid,"");
	    }, { title: "学科选择器" });
}