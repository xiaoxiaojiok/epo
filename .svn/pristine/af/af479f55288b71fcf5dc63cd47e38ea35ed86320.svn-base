//读取下一个span,可以通过这个对象给状态״̬
function getSpan(obj){
	while(true){   //去掉input和span之间的空白标签
		if(obj.nextSibling.nodeName!="SPAN")
		{
			obj=obj.nextSibling;
		}else{
			return obj.nextSibling;
		}
		
	}
}

/*
 通用检查方法
 第一个参数：obj 用来检查的对象
 第二个参数：用来检查的提示信息
 第三个参数：fun 是一个回调函数 用来检查值是否按照条件输入
 第四个参数：click是一个状态 分清楚是单击提交按 还是失去焦点

*/
function check(obj,info,fun,click){
	  var sp=getSpan(obj);
	  obj.onfocus=function(){
  	sp.innerHTML=info;
  	sp.className="status2";
  };
  obj.onblur=function(){
  	if(fun(this.value)){
	  	sp.innerHTML='<img src="../images/book_ok.png"></img>';
	  	sp.className="status4";
  	}else{
	  	sp.innerHTML='<img src="../images/book_error.png"></img>';
	  	sp.className="status3";
  	}
  }
  
  if(click=='click'){
  	//手动地,这个可以有
  	obj.onblur();
  }
}

//页面加载完 自动加载
onload=regs

//一个函数 可以使用onsubmit调用 也可以使用onload调用
	function regs(click){
		var status=true;
	var bookId=document.getElementsByName("bookId")[0];
	var user=document.getElementsByName("user")[0];
	var bookName=document.getElementsByName("bookName")[0];
	var bookClass=document.getElementsByName("bookClass")[0];
	var subClass=document.getElementsByName("subClass")[0];
	var bookAuthor=document.getElementsByName("bookAuthor")[0];
	var bookPress=document.getElementsByName("bookPress")[0];
	var bookWeight=document.getElementsByName("bookWeight")[0];
	var ISBN=document.getElementsByName("ISBN")[0];
	var edition=document.getElementsByName("edition")[0];
	var pageNumber=document.getElementsByName("pageNumber")[0];
	var bookDepict=document.getElementsByName("bookDepict")[0];
	var bookPrice=document.getElementsByName("bookPrice")[0];
	var bookSale=document.getElementsByName("bookSale")[0];
	var bookSaleNum=document.getElementsByName("bookSaleNum")[0];
	var bookLeaveNum=document.getElementsByName("bookLeaveNum")[0];
	var myspan=document.getElementById("classify");
	
	bookClass.onfocus=function(){
  			myspan.className="status2";
	};
	bookClass.onblur=function(){
		var index = bookClass.selectedIndex;
	  	if(bookClass.options[index].value!=""){
		  	myspan.innerHTML='<img src="../images/book_ok.png"></img>';
		  	myspan.className="status4";
	  	}else{
		  	myspan.innerHTML='<img src="../images/book_error.png"></img>';
		  	myspan.className="status3";
		  	status = false;
	  	}
	};
	subClass.onfocus=function(){
  			myspan.className="status2";
	};
	subClass.onblur=function(){
		var index = subClass.selectedIndex;
	  	if(subClass.options[index].value!=""){
		  	myspan.innerHTML='<img src="../images/book_ok.png"></img>';
		  	myspan.className="status4";
	  	}else{
		  	myspan.innerHTML='<img src="../images/book_error.png"></img>';
		  	myspan.className="status3";
		  	status = false;
	  	}
	};
  if(click=='click'){
	bookClass.onblur();
  	subClass.onblur();
  }
	
  //alert("ok");
  //alert(getSpan(username).nodeName);
  check(bookId,"ID的长度要在1-11之间",function(val){
  	if(val.match(/^[1-9]\d*$/) && val.length >=1 && val.length <=11){
  		return true;
  	}else{
  		status = false;
  		return false;
  	}
  },click);
  
  check(user,"拥有者的长度要在1-20之间",function(val){
  	if(val.match(/^\S+$/) && val.length >=1 && val.length <= 20){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
      
   check(bookName,"书名的长度要在1-20之间",function(val){
  	if(val.match(/^\S+$/) && val.length >=1 && val.length <= 20){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
      
      
    check(bookAuthor,"作者的长度要在1-20之间",function(val){
  	if(val.match(/^\S+$/) && val.length >=1 && val.length <= 20){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
        
    check(bookPress,"出版社的长度要在3-20之间",function(val){
  	if(val.match(/^\S+$/) && val.length >=3 && val.length <= 20){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
          
    check(bookWeight,"重量应为整数或小数",function(val){
  	if(val.match(/^[1-9]*\d(\.\d+)?$/) && val.length >=1 && val.length <= 10){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
    
       check(ISBN,"ISBN的长度要在1-20之间",function(val){
  	if(val.match(/^\S+$/) && val.length >=1 && val.length <= 20){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
       
       check(edition,"版次应为整数",function(val){
  	if(val.match(/^[1-9]\d*$/) &&  val.length <= 10){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
       
      check(pageNumber,"页数应为整数",function(val){
  	if(val.match(/^[1-9]\d*$/) &&  val.length <= 10){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
      
      check(bookDepict,"书籍描述的长度要在1-50之间",function(val){
  	if(val.match(/^\S+$/) && val.length >=1 && val.length <= 50){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
      
    check(bookPrice,"原价应为整数或小数",function(val){
  	if(val.match(/^[1-9]*\d(\.\d+)?$/ )&& val.length >=1 && val.length <= 10){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
            
    check(bookSale,"售价应为整数或小数",function(val){
  	if(val.match(/^[1-9]*\d(\.\d+)?$/) && val.length >=1 && val.length <= 10){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
                  
      check(bookSaleNum,"售出数量应为整数",function(val){
  	if(val.match(/^[0-9]\d*$/) && val.length >=1 && val.length <= 10){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
                        
     check(bookLeaveNum,"剩余数量应为整数",function(val){
  	if(val.match(/^[0-9]\d*$/) && val.length >=1 && val.length <= 10){
  		return true;
  	}else{
  				status = false;
  		return false;
  	}
  },click);
  return status;
}
