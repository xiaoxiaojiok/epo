/**
 * dxq
 */

var _p_config = {
		eleementclass : 'commitprocess',  //触发提交的class
		nexpersonurl : '/jbpm/nextPerson', //走下一步路径
		formid : '', //设置默认的form id 例如填写表单  既要保存又要完成第一步,
		defaultform : ['taskid','transitionName','processdefinitonkey','jbpm4_opinion','jbpm4_caosong'], //默认往后台传递的值
		prefix : 'jbpm4_', //默认前缀
		defaultassignId : '',//如果指定用户id的话 直接发给他。。与流程定义兼容 暂时没用
		defaultassign : 'assignname', //分配人 如果出现fork 情况  后台获取 assignname0 assignname1....默认单选是assignname
		opinionid : '', //意见栏id，如果没值 则在提交的弹出框内出现意见。有值 则后台获取的值是该id节点的value
		defaultopinionid : 'defaultopinionid', //默认弹出框意见栏的id
		defaultopinionname : 'opinion', // 后台接受意见的 参数
		width : 450,  //弹出框大小
		height : 300,//弹出框大小
		left : null,//弹出框方位
		top : null,//弹出框方位
		isAjax : false, //提交方式是否是异步 ，false不是异步，true是异步
		hasemergency : '', //是否设置紧急情况 
		completeurl :'', //提交路径
		defaulthanler : function(){
			alert('这是默认的处理函数需要重构');
		},
		nextPersonParam : function(){
			return {}; //获取下一步办理人的时候往后台传递的参数
		},
		isMultiProcess : false,//批量提交  默认为false 不批量
		beforeNext : function(){
			return true; //提交之前判断
		},
		obtainParam : function(){
			return {}; //提交之前 额外的参数
		},
		parameter : '',  //节点上其他属性的名
		parameterValue : ''//节点上其他属性的名对应的value
		
};
var Process = function(){
	var t = this;
	var defaultconfig = {};
	var cacheNext = {};
	
	var taskid,transitionName,processdefinitonkey,jbpm4_opinion,jbpm4_hasemergency,jbpm4_caosong, _j_tar;
	this.getVariable = function(name){
		return eval('('+name+')');
	};
	this.init = function(){
		var event = arguments[0];
		
		initTimer();
		
		defaultconfig=_p_config;
		
		var _j_target = $(this);
		_j_tar = _j_target;
		taskid=_j_target.attr('taskid');
		transitionName=_j_target.attr('transitionName');
		processdefinitonkey=_j_target.attr('processdefinitonkey');//暂时用processinstance id
		
		if(defaultconfig.parameter != '' && defaultconfig.parameter != null){
			defaultconfig.parameterValue = _j_target.attr(defaultconfig.parameter);
		}
		
		
		if(taskid!=null && taskid !=''){
			
			var ta = taskid+'_'+transitionName;
			if(cacheNext[ta]!=null && cacheNext[ta]!=''){
				renderCandidate.call(t,cacheNext[ta]);
				return ;
			}
		}else if(processdefinitonkey!=null && processdefinitonkey!=''){
			
			if(cacheNext[processdefinitonkey]!=null && cacheNext[processdefinitonkey]!=''){
				renderCandidate.call(t,cacheNext[processdefinitonkey]);
				return ;
			}
		}
		
		var nextPersonParam = {'taskid':taskid,'transitionName':transitionName,'processkey':processdefinitonkey,'hasemergency':defaultconfig.hasemergency,'defaultassignId':defaultconfig.defaultassignId};
		nextPersonParam = $.extend(nextPersonParam,defaultconfig.nextPersonParam());
		$.ajax({
			type: "POST",
			url: defaultconfig.nexpersonurl,
			data: nextPersonParam,
			beforeSend : function(XHR){
				$('#jbpm_waitmsg').window('open');
			},
			success: function(msg){
				$('#jbpm_waitmsg').window('close');
				if(msg == null || msg==''){
					renderCandidate.call(t,msg);
					return ;
				}
				if(typeof msg == 'string'){
					msg = $.parseJSON(msg);
				}
				//if(msg['status']=='-1'){
				///	alert(msg['info']);
				//	return ;
				//}
				
				if(taskid!=null && taskid !=''){
					var ta = taskid+'_'+transitionName;
					cacheNext[ta]=msg;
				}else if(processdefinitonkey!=null && processdefinitonkey!=''){
					cacheNext[processdefinitonkey]=msg;
				}
				renderCandidate.call(t,msg);
			}
		});
		
	};
	var initTimer = function(){
		if($('#jbpm_waitmsg').size()==0){
			var wait = [];
			wait.push('<div><div><span>正在获取下一节点信息，请稍等</span><span></span></div></div>');
			
			$('body').append('<div id="jbpm_waitmsg"  style="text-align:left;" class="easyui-window"  ></div>');
			$('#jbpm_waitmsg').html(wait.join(''));
			$('#jbpm_waitmsg').window({
				width:250,
				height:40,
				modal:true,
				closed : true,
				closable : false,
				minimizable : false,
				maximizable : false,
				collapsible : false,
				title : false
			});
		
		}
	};
	var renderCandidate=function(msg){
		var isAutoCommit = false;
		//放在这里校验数据 1.在弹出框之前要校验 2.根据流程走向来判断是否需要校验
		if(msg['vidatedata']!=null && msg['vidatedata']!=''&&msg['vidatedata']=='false'){
			//不需要校验
			defaultconfig.formid = null;
		}
		else{
			var bo = defaultconfig.beforeNext(t);
			if(!bo){
				return ;
			}
		}
		
		
		var defaultassign = defaultconfig.defaultassign;
		if(msg['status']!=null && msg['status']=='-1'){
			if(!defaultconfig.isMultiProcess){
				alert(msg['info']);
			}
			else{
				//如果获取下一节点的分配人失败 就直接处理把 批量才这样弄
				defaultconfig.defaulthanler.call(_j_tar,msg);	
			}
			return ;
		}
		else if(msg['data']==null || msg['data']==''){
			
			//this.completeStep.call(t);
			//return ;
			msg.data = [];
			
			msg.type ='task';
			isAutoCommit = true;
		}
		
		var sts = [];
		
		sts.push('<div>');
		sts.push('  <div>');
		if(msg.type!='fork'){
			if(msg.data.length!=0){
				if(msg.data[0].candidate.length==1){
					var a_u = msg.data[0].candidate[0];
					sts.push(' <div> <div class="userinfo" style="display:none;"><span><input type="radio" checked="true" name="'+defaultassign+'" value="'+a_u['id']+'">'+a_u['givenName']+'</span></div></div>');
					isAutoCommit = true;
				}else{
					for(var i=0;i<msg.data[0].candidate.length;i++){
						var a_u = msg.data[0].candidate[i];
						sts.push(' <div style="width:120px;float:left;"> <div class="userinfo"><span><input type="radio" name="'+defaultassign+'" value="'+a_u['id']+'">'+a_u['givenName']+'</span></div></div>');
					}
					sts.push('<div style="clear:both;"></div>');
				}
			}
			
		}
		else{
			
			for(var i=0;i<msg.data.length;i++){
				var a_u = msg.data[i];
				sts.push('  <div><div class="userinfo " style="margin-bottom:10px;"><span>请选择<label>'+a_u['name']+'</label>的办理人</span></div></div>');
				for(var m=0;m<a_u.candidate.length;m++){
					var a_m = a_u.candidate[m];
					sts.push('  <div style="width:120px;float:left;"><div class="userinfo"><span><input type="radio" name="'+defaultassign+i+'" value="'+a_m['id']+'">'+a_m['givenName']+'</span></div></div>');
				}
				sts.push('<div style="clear:both;"></div>');
				
			}
		}
		if(defaultconfig.opinionid == null || defaultconfig.opinionid == ''){
			sts.push('<div class="userinfo"><div><span>意见:</span></div><div><textarea style="width:'+(defaultconfig.width-100)+'px;height:100px;" id="'+defaultconfig.defaultopinionid+'"></textarea></div></div>');
		}
		
		//抄送人
		sts.push('<div class="userinfo" style="display:none;"><div><span>抄送人:</span></div><div><input type="hidden" id="chaosong_v"></div></div>');
		
		if(defaultconfig.hasemergency!=null && defaultconfig.hasemergency!=''){
			sts.push('<div class="userinfo">');
			sts.push('<div><span>项目紧急状态</span></div>');
			for(var i=0;i<msg.emergency.length;i++){
				var _emer=msg.emergency[i];
				sts.push('<div style="width:100px;float:left;">');
				if(_emer['mvalue']=='changgui'){
					sts.push('<input type="radio" checked="checked" name="emergency" value="'+_emer['id']+'">');
				}
				else sts.push('<input type="radio" name="emergency" value="'+_emer['id']+'">');
				sts.push(_emer['mkey']);
				sts.push('</div>');
			}
			sts.push('<div style="clear:both;"></div>');
			sts.push('</div>');
		}

		sts.push('<div class="userinfo" style="text-align:center;"><div style="width:250px;margin-right:auto;margin-left:auto;"><a href="javascript:void(0);" id="processsubit" >提交</a>&nbsp;&nbsp;<a href="javascript:void(0);" id="processcancel" >取消</a>&nbsp;&nbsp;<a href="javascript:void(0);" id="caosong"  >抄送</a></div></div>');
		sts.push('  </div>');
		sts.push('</div>');
		
		var _n_height = defaultconfig.height;
		if(defaultconfig.opinionid != null && defaultconfig.opinionid != ''){
			_n_height = 240;
		}
		if($('#candidate').size()==0){
			$('body').append('<div id="candidate" style="text-align:left;" class="easyui-window" title="确认提交" ></div>');
			$('#candidate').html(sts.join(''));
			$('#candidate').window({
				width:defaultconfig.width,
				height:_n_height,
				modal:true,
				closable : true,
				minimizable : false,
				maximizable : false,
				collapsible : false,
				left : defaultconfig.left,
				top : defaultconfig.top
			});
			
		
		}
		
		$('#candidate').html(sts.join(''));
		if(isAutoCommit){
			$('#candidate').window('close');
			$('#processsubit').trigger('click');
			return ;
		}
		if(defaultconfig.isMultiProcess){
			//多个人  在批量的时候提示失败 佛祖保佑
			$('#candidate').window('close');
			var msg1 = {};
			msg1['status']='-1';
			msg1['info']='下一环节有多个候选者，请手动分配';
			defaultconfig.defaulthanler.call(_j_tar,msg1);
			return ;
		}
		$('#candidate').window('open');
		$('#processsubit,#caosong,#processcancel').linkbutton({plain : false});

	};
	var submitProcess = function(){
		$('#candidate').window('close');
	};
	this.addCache = function(taskid,o){
		if(cacheNext[taskid]!=null && cacheNext[taskid]!=''){
			cacheNext[taskid]=taskid;
		}
	};
	this.defaultRender=function(){
		var o = arguments[0];
	};
	this.cancelStep=function(){
		$('#candidate').window('close');
	};
	this.completeStep=function(){
		//判断有没有选人
		//$('#candidate')
		
		if($('#candidate').find(':radio[name=assignname]').size()!=0){
			if($('#candidate').find(':checked[name=assignname]').size()==0){
				alert('请选择下一步办理人');
				return false;
			}
		}
		if($('#processsubit').size()!=0){
			$('#processsubit').attr('disabled','disabled');
			$('#processsubit').attr('value','提交中...');
		}
		
		var target1 = this;
		var formid = defaultconfig.formid;
		
		if(formid!=null && formid!=''){
			var e_form = $("#"+formid).get(0);
			var forme = defaultconfig.defaultform;
			var addElement = [];
			for(var i=0;i<forme.length;i++){
				var t = forme[i];
				if(e_form[t]==null){
					addElement.push('<input type="hidden"  name="'+t+'"/>');
				}
			}
			//userinfo
			$('.userinfo input:checked').each(function(index, domEle){
				var e_name = $(domEle).attr('name');
				
				var e_value = $(domEle).val();
				var prefix = defaultconfig.prefix;
				addElement.push('<input type="hidden" value="'+e_value+'"  name="'+prefix+e_name+'"/>');
			});
			
			$(e_form).append(addElement.join(''));
			
			//opinion值
			var opinionid = '';
			if(defaultconfig.opinionid == null || defaultconfig.opinionid==''){
				opinionid = defaultconfig.defaultopinionid;
			}
			else opinionid = defaultconfig.opinionid;
			jbpm4_opinion=$('#'+opinionid).val();
			
			jbpm4_caosong=$('#chaosong_v').val();
			
			for(var i=0;i<forme.length;i++){
				var t = forme[i];
				var v = eval(t);
				$(e_form[t]).val(v);
			}
			
			
			
			if(defaultconfig.isAjax){
				if(defaultconfig.completeurl != null && defaultconfig.completeurl!=''){
					$(e_form).form('submit',{
						url : defaultconfig.completeurl,
						success : function(data){
							if(typeof data == "string"){
								data = $.parseJSON(data);
							}
							$('#candidate').window('close');
							defaultconfig.defaulthanler.call(e_form,data);
							
						}
					});
				}
				else{
					$(e_form).form('submit',{
						success : function(data){
							if(typeof data == "string"){
								data = $.parseJSON(data);
							}
							$('#candidate').window('close');
							defaultconfig.defaulthanler.call(e_form,data);
							
						}
					});
				}
				
			}
			else{
				e_form.submit();
			}
			
		}else{
			if(defaultconfig.isAjax){
				var param = {};
				var forme = defaultconfig.defaultform;
				
				var opinionid = '';
				if(defaultconfig.opinionid == null || defaultconfig.opinionid==''){
					opinionid = defaultconfig.defaultopinionid;
				}
				else opinionid = defaultconfig.opinionid;
				
				jbpm4_opinion=$('#'+opinionid).val();
				
				jbpm4_caosong=$('#chaosong_v').val();
				
				for(var i=0;i<forme.length;i++){
					var t = forme[i];
					var v = eval(t);
					param[t]=v;
				}
				
				$('.userinfo input:checked').each(function(index, domEle){
					var e_name = $(domEle).attr('name');
					var e_value = $(domEle).val();
					var prefix = defaultconfig.prefix;
					param[prefix+e_name]=e_value;
				});
				var o = defaultconfig.obtainParam();
	
				param = $.extend(param,o);
				
				$.ajax({
					type: "POST",
					url : defaultconfig.completeurl,
					data : param,
					method : 'post',
					success : function(data, textStatus){
						var msg = '';
						
						if(!defaultconfig.isMultiProcess){
							if(data==null || data==''){
								alert('提交失败');
								return false;
							}
							
							else if(typeof data == 'string'){
								try{
									msg=$.parseJSON(data);
								}
								catch(err){
									alert('提交失败');
									return false;
								}
							}
							else{
								msg = data;
							}
						}
						else{
							if(data==null || data==''){
								var msg2 ={'status':'-1','info':'返回数据有误'};
								$('#candidate').window('close');
								defaultconfig.defaulthanler.call(_j_tar,msg2);
								return false;
							}
							
							else if(typeof data == 'string'){
								try{
									msg=$.parseJSON(data);
								}
								catch(err){
									var msg2 ={'status':'-1','info':'返回数据有误'};
									$('#candidate').window('close');
									defaultconfig.defaulthanler.call(_j_tar,msg2);
									return false;
								}
							}
							else{
								msg = data;
							}
						}
						
						
						
						if(!defaultconfig.isMultiProcess){
							
								
								$('#candidate').window('close');
								defaultconfig.defaulthanler.call(_j_tar,msg);	
								return true;
							
						}
						else{
							$('#candidate').window('close');
							defaultconfig.defaulthanler.call(_j_tar,msg);	
							return true;
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown){
						var msg = {};
						msg['status']='-1';
						msg['info']='办理失败';
						$('#candidate').window('close');
						defaultconfig.defaulthanler.call(_j_tar,msg);	
						return true;
					} 
				});
			}
		}
	};
};

$(function(){
	var p = new Process();
	$(".commitprocess").live("click", p.init);  
	$("#processsubit").live("click", p.completeStep);
	$("#processcancel").live("click", p.cancelStep);
	$('#caosong').live('click',function(){
		var returnValue = window.showModalDialog('/notify/index',window,"dialogHeight: 600px; dialogWidth: 850px; edge: Raised; center: Yes; help: no; resizable: no; status: no;");
		if(returnValue.length != 0){
			 $('#chaosong_v').val(returnValue.join(','));
		}
		else $('#chaosong_v').val('');
	});
});

$(function(){
	var e_if = $("#taskinfo");
	if(e_if.size()<=0)
		return ;
	var eif = e_if.get(0);
	$(eif).bind('load',function(){
		var ifm = eif;
		var subWeb = document.frames ? document.frames["taskinfo"].document : ifm.contentDocument;
		if(ifm != null && subWeb != null) {
			ifm.height = subWeb.body.scrollHeight; 
		}
	});
});