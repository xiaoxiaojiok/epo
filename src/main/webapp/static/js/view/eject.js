

function eject(id){
var oa = document.getElementById(id);
if(oa.style.display == "block"){
   oa.style.display = "none";
}else{
   oa.style.display = "block";
   oa.style.width = document.body.clientWidth + "px" ;
   oa.style.height = document.body.clientHeight + "px" ;
}
}

function change(i1,i2){
var oa = document.getElementById(i1);
var ob = document.getElementById(i2);
if(oa.style.display == "block"){
   oa.style.display = "none";
   ob.style.display = "block";
}else{
   oa.style.display = "block";
   ob.style.display = "none";
}
}

function turn(id){
var oa = document.getElementById(id);
if(oa.className == id+"1"){
   oa.className = id+"2";
}else{
   oa.className = id+"1";
}
}

function hide(id){
document.getElementById(id).style.display = "none";
}

function show(id){
document.getElementById(id).style.display = "block";
}


function speech(id){
	base.load("mid","/speech/forward/" + id,function(){
	});
}

function save_speech(id){
	base.processStatus(1,'save_btn','process_btn');
	var contents=$("#contents").val();
	var pars="contents="+contents;
	base.request("/speech/forward_save/" + id,pars,function(result){
		if(result == "true"){
			base.tips("保存成功!",'success',1500);
		setTimeout(function(){
				$("#speech_click").click();
			},2000)
		}else{
			base.tips("出现未知异常，操作失败!",'error');
		}
		base.processStatus(0,'save_btn','process_btn');
	},"POST","HTML");
}

function voice(id){
	base.load("mid","/voice/forward/" + id,function(){
	});
}

function save_voice(id){
	base.processStatus(1,'save_btn','process_btn');
	var contents=$("#contents").val();
	var pars="contents="+contents;
	base.request("/voice/forward_save/" + id,pars,function(result){
		if(result == "true"){
			base.tips("保存成功!",'success',1500);
		setTimeout(function(){
				$("#voice_click").click();
			},2000)
		}else{
			base.tips("出现未知异常，操作失败!",'error');
		}
		base.processStatus(0,'save_btn','process_btn');
	},"POST","HTML");
}

function homework(userid){
	base.load("mid","/homework/index/" + userid,function(){
	});
}
