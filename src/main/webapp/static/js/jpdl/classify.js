var citys=null;

function scity(pname,cname,bookClass,subClass,xf,cs){
	 
	var provice = bookClass;
	citys = subClass;
    document.write('<select onchange="select(this)" style="font-family:微软雅黑;font-size:13px;height:26px;text-align:center;line-height:26px;" id="pro" name="'+pname+'">');
	document.write('<option value="">--请选择角色--</option>');
	
  var a=0;
  
	for(var i=0;i<provice.length;i++){
		if(typeof(xf)!="undefined"){
			if(provice[i] == xf){
				//alert(xf);
				var sel = "selected=true";
				
				a=i;  //通过a知道那个父类被选中
				
			}else{
				var sel = "";
			}
		}else{
			var sel = "";
		}
	
		document.write('<option '+sel+'value="'+provice[i]+'">'+provice[i]+'</option>');
	}
	document.write('</select>');
	
	document.write('<select id="city" style="font-family:微软雅黑;font-size:13px;height:26px;text-align:center;line-height:26px;" name="'+cname+'">');
	document.write('<option value="">--请选择审批人--</option>');
	 
	 //手动地调用
	 if(a>0){
	 	select(document.getElementById("pro"),a,cs);
	}
}

	function select(obj,a,cs){
		
		if( typeof(a) !="undefined"){
			var index = a;
		}else{
			var index = obj.selectedIndex-1;
		}
		
		
		//alert(index);		
		var cobj=document.getElementById("city");
		cobj.innerHTML=""; //先清空一下
		if(index>=0){
			//alert(citys[index]);
			for(var i=0;i<citys[index].length;i++){
				
				if(typeof(cs) !="undefined"){
					if(citys[index][i] == cs){
						
						var sel = "selected";
					}else{
						var sel ="";
					}
				}else{
					var sel ="";
				}
				var option = document.createElement("option");
				var text=citys[index][i];
				option.value=text;
				option.selected=sel;
				option.innerHTML=text;
				cobj.appendChild(option);
			}
		}else{
				var option = document.createElement("option");
				option.value="";
				option.innerHTML="--请选择审批人--";
				cobj.appendChild(option);
		}
	}