(function($){
var myflow = $.myflow;

$.extend(true, myflow.editors, {
	inputEditor : function(arg){
		var _props,_k,_div,_src,_r;
		this.init = function(props, k, div, src, r){
			_props=props; _k=k; _div=div; _src=src; _r=r;
			
			if(typeof arg === 'string'){
				$('<input value="" style="width:100%;" id="'+arg+'"/>').val(props[_k].value).change(function(){
					props[_k].value = $(this).val();
				}).appendTo('#'+_div);
			}else{
				$('<input style="width:100%;"/>').val(props[_k].value).change(function(){
					//alert(props[_k].value +"--"+ $(this).val() );
					props[_k].value = $(this).val();
				}).appendTo('#'+_div);
			}

			$('#'+_div).data('editor', this);
		}
		this.destroy = function(){
			$('#'+_div+' input').each(function(){
				_props[_k].value = $(this).val();
			});
		}
	},
	selectEditor : function(arg){
		var _props,_k,_div,_src,_r;
		this.init = function(props, k, div, src, r){
			_props=props; _k=k; _div=div; _src=src; _r=r;

/*			var tex = $('<select multiple style="width:100%;height:110px;overflow: hidden;overflow-y:auto;"/><br/><br/>').val(props[_k].value).change(function(){
				props[_k].value = $(this).val();
			}).appendTo('#'+_div);*/
			

			//alert(arg);
			if(typeof arg === 'string' && arg == '/jbpm/showRoles'){
					var tex = $('<input id="myroles" style="width:100%;"/><br/><br/>').val(props[_k].value).change(function(){
						props[_k].value = $(this).val();
					}).appendTo('#'+_div);
					
					var sle = $('<select id="myrolesSelect" style="width:100%;"/>').val(props[_k].value).change(function(){
						if(props[_k].value != ""){
							//tex.append('<option value="'+$(this).val()+'">'+$(this).val()+'</option>');
							props[_k].value  = props[_k].value +','+$(this).val();
						}else{
							props[_k].value  = $(this).val();
						}
						tex.val(props[_k].value);
						//alert(props[_k].value );
					}).appendTo('#'+_div);
					
					sle.append('<option value="">--请选择角色--</option>');
					
					$.ajax({ 
					   type: "POST",
					   url: arg,
					   dataType:"json",
					 async:false,
						contentType:'application/json;charset=UTF-8',
					   success: function(data){
						  var opts = eval(data);
						 if(opts && opts.length){
							for(var idx=0; idx<opts.length; idx++){
								sle.append('<option value="'+opts[idx]+'">'+opts[idx]+'</option>');
							}
							sle.val(_props[_k].value);
						 }
					   }
					});
					//alert($("#mytype").val());
					
					if($("#mytype").val()!='指定角色'){
						//若存在元素，则隐藏角色
						if($("#mytype").length!=0){
							$("#myroles").hide();
							$("#myrolesSelect").hide();
						}
						/*$("#myroles").attr("disabled","disabled");
						$("#myrolesSelect").attr("disabled","disabled");*/
					}else{
						$("#myroles").show();
						$("#myrolesSelect").show();
						/*$("#myroles").removeAttr("disabled");
						$("#myrolesSelect").removeAttr("disabled");*/
					}

			}else {
				if(typeof arg === 'string' && arg == '/jbpm/getAssign'){
					var sle = $('<select  id="mytype" style="width:100%;"/>').val(props[_k].value).change(function(){
						//alert($(this).val());
						if($(this).val()!='指定角色'){
							$("#myroles").hide();
							$("#myrolesSelect").hide();
							/*$("#myroles").attr("disabled","disabled");
							$("#myrolesSelect").attr("disabled","disabled");*/
						}else{
							$("#myroles").show();
							$("#myrolesSelect").show();
							/*$("#myroles").removeAttr("disabled");
							$("#myrolesSelect").removeAttr("disabled");*/
						}
						props[_k].value = $(this).val();
					}).appendTo('#'+_div);
					
					//for(var idx=0; idx<arg.length; idx++){
						//sle.append('<option value="'+arg[idx].value+'">'+arg[idx].name+'</option>');
					//}
					sle.append('<option value="">--请选择类型--</option>');
					
					$.ajax({ 
						   type: "POST",
						   url: arg,
						   dataType:"json",
						   async:false,
							contentType:'application/json;charset=UTF-8',
						   success: function(data){
							  var opts = eval(data);
							 if(opts && opts.length){
								for(var idx=0; idx<opts.length; idx++){
									sle.append('<option value="'+opts[idx]+'">'+opts[idx]+'</option>');
								}
								sle.val(_props[_k].value);
							 }
						   }
						});
					
					//sle.append('<option value="指定角色">指定角色</option>');
					//sle.append('<option value="指定项目经理">指定项目经理</option>');
					//sle.val(_props[_k].value);
				}else{
					if(typeof arg === 'string' && arg == 'joinselect'){
						var sle = $('<select  id="joinselect" style="width:100%;"/>').val(props[_k].value).change(function(){
							props[_k].value = $(this).val();
						}).appendTo('#'+_div);
						
						sle.append('<option value="">--请选择人数--</option>');
						if($("#myrolesInJoin").val()!=""){
				
							var myrolesInJoin = $("#myrolesInJoin").val();
							var strs = new Array();
							strs = myrolesInJoin.split(",");
							/*for(var j=0;j<strs.length;j++){
								alert(strs[j]);
							}*/
							//alert($("#joinselect").val());
							
							var num = $("#joinselect").val();
							//alert(num);
							$("#joinselect").empty();
							$("#joinselect").append('<option value="">--请选择人数--</option>');
							for(var idx=1; idx<=strs.length; idx++){
								$("#joinselect").append('<option value="'+idx+'">'+idx+'</option>');
							}
							if(num==""){
								$("#joinselect").val(strs.length);
							}else{
								$("#joinselect").val(num);
							}
							
							//$("#joinselect").val(num);
						}
						sle.val(_props[_k].value);
						
					}else{
						if(typeof arg === 'string' && arg == '/jbpm/showRolesInJoin'){
							var tex = $('<input id="myrolesInJoin" style="width:100%;"/><br/><br/>').val(props[_k].value).change(function(){
								props[_k].value = $(this).val();
							}).appendTo('#'+_div);
							
							var sle = $('<select id="myrolesSelectInJoin" style="width:100%;"/>').val(props[_k].value).change(function(){
								if(props[_k].value != ""){
									//tex.append('<option value="'+$(this).val()+'">'+$(this).val()+'</option>');
									props[_k].value  = props[_k].value +','+$(this).val();
								}else{
									props[_k].value  = $(this).val();
								}
								tex.val(props[_k].value);
								
								if($("#myrolesInJoin").val()!=""){
									var myrolesInJoin = $("#myrolesInJoin").val();
									var strs = new Array();
									strs = myrolesInJoin.split(",");
									/*for(var j=0;j<strs.length;j++){
										alert(strs[j]);
									}*/
									//alert($("#joinselect").val());
									var num = $("#joinselect").val();
									$("#joinselect").empty();
									$("#joinselect").append('<option value="">--请选择人数--</option>');
									for(var idx=1; idx<=strs.length; idx++){
										$("#joinselect").append('<option value="'+idx+'">'+idx+'</option>');
									}
									if(num==""){
										$("#joinselect").val(strs.length);
									}else{
										$("#joinselect").val(num);
									}
									
									//$("#joinselect").val(num);
								}
								//alert(props[_k].value );
							}).appendTo('#'+_div);
							
							sle.append('<option value="">--请选择角色--</option>');
							
							$.ajax({ 
							   type: "POST",
							   url: "/jbpm/showRoles",
							   dataType:"json",
							 async:false,
								contentType:'application/json;charset=UTF-8',
							   success: function(data){
								  var opts = eval(data);
								 if(opts && opts.length){
									for(var idx=0; idx<opts.length; idx++){
										sle.append('<option value="'+opts[idx]+'">'+opts[idx]+'</option>');
									}
									sle.val(_props[_k].value);
								 }
							   }
							});
							
			
						}else{
							
						}
					}
				}
			}
			$('#'+_div).data('editor', this);
		};
		this.destroy = function(){
			$('#'+_div+' input').each(function(){
				_props[_k].value = $(this).val();
			});
		};
	}
});

})(jQuery);

