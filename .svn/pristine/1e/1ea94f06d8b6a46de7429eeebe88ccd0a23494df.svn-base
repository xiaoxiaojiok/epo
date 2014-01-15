/**
 *
 * 基础JS类，封装一些常用的方法和AJAX操作
 * 需要jquery支持
 *
 * Author  殷俊 整理
 * Create  2012-11-8 下午05:58:03
 */

var base = null;
var box = null;
var _currUrl = "";
var _currPage = "";
var _currDiv = "";

function Base(){};

Base.prototype = {
		/**
		 * 获取ID为_nodeId的DOM对象
		 */
		getObject : function(_nodeId){
			 if(_nodeId == undefined){
			 	return null;
			 }else{
			 	return "" == _nodeId ? null : document.getElementById(_nodeId);
			 }
		},
		
		/**
		 *  页面跳转
		 *  _obj不填写为当前页面
		 */
		forward : function(/*string*/_url,/*object*/_obj){
			(!_obj ? document : _obj).location.href = _url;
		},
		
		/**
		 * 使用form进行表单提交.
		 * 
		 */
		formSubmit : function(/*string*/_url, /*function*/onSuccess, /*string*/_formId,/*string*/_dataType)
		{
			var paras = this._formValues(this.getObject(_formId));
			this.request(_url, paras, onSuccess, 'POST',!_dataType ? "HTML" : _dataType);
		},

	
		/**
		 * 向服务器发送请求，并指定处理函数
		 */
		request : function(/*string*/_url, /*string*/paras,/*function*/onSuccess, /*string*/_method,/*string*/_dataType) {
			$.ajax({
				type: !_method ? 'POST' : _method,
				url: _url,
				data: paras,
				dataType: !_dataType ? 'HTML' : _dataType,
				success: onSuccess,
				error: function(XMLHttpRequest, textStatus, errorThrown){
					base.alert('出现未知异常，操作失败！');
				}
			});	
		},
		
		/**
		 * Ajax Get 提交,携带已拼接的参数。需要(key/value)参数请求的请自行采用$.get();
		 */
		doGet : function(_url,callback){
			if(!_url) return;
			$.get(_url,callback);
		},
		
		/**
		 * Ajax Post 提交,携带已拼接的参数。需要(key/value)参数请求的请自行采用$.post();
		 */
		doPost : function(_url,callback){
			if(!_url) return;
			$.post(_url,callback);
		},

		/**
		 * 载入远程 HTML 文件代码并插入至 DOM 中,携带已拼接的参数。需要(key/value)参数请求的请自行采用$("#id").load();
		 */
		load : function(_target,_url,callback){
			if(!_target || !_url) return;
			if(_url.indexOf("?") < 0){
				$("#" + _target).load(_url + "?" + Math.round(Math.random() * 10000),callback);
			}else{
				$("#" + _target).load(_url + "&" + Math.round(Math.random() * 10000),callback);
			}
		},		
		/**
		 * JS翻页转换
		 * @param {Object} _listDiv
		 * @param {Object} _url
		 * @param {Object} curPage
		 */
		roll : function(_listDiv,_url, curPage){
			_currUrl = _url;
			_currPage = curPage;
			_currDiv = _listDiv;
			this.load(_listDiv,_url + curPage,function(){});
		},
		
		/**
		 * 返回操作.用于返回用户当前所选中的页.调用前提曾调用过base.roll
		 */
		cancel : function(headDiv,listDiv,editDiv,doQuery){
			if(_currUrl == "" && _currPage =="" && _currDiv == ""){
				if(!doQuery){
					query();
				}else{
					doQuery();
				}
				
			}else{
				this.roll(_currDiv,_currUrl,_currPage);
				this.showList(headDiv,listDiv,editDiv);
			}
		},
		
		/**
		 * 结合上面几个方法，配套使用
		 */
		showEdit : function(head,list,edit){
			$("#" + head).hide();
			$("#" + list).hide();
			$("#" + edit).show();
		},
		/**
		 * 结合上面几个方法，配套使用
		 */
		showList : function(head,list,edit){
			$("#" + head).show();
			$("#" + list).show();
			$("#" + edit).hide();
		},
		/**
		 * 结合上面几个方法，配套使用
		 */
		showLeftMenu : function(list){
			$("#" + list).show();
		},
		
		/**
		 * 使指定的checkbox框全部被选中或不选中
		 */
		checkAll : function(/*string*/ checkboxName, /*HTMLCheckboxObject*/_obj) {
			var ckboxs = document.getElementsByName(checkboxName);
			if (ckboxs.length == 0) ckboxs = document.getElementsByTagName('INPUT');
			var check = false;
			if (_obj.checked){
				check = true;
			}else{
				check = false;
			} 
			for (var i = 0; i < ckboxs.length; i ++) {
				if (ckboxs[i].type != 'checkbox') continue;
				if (ckboxs[i].name != checkboxName) continue;
				ckboxs[i].checked = check;
			}
		},
	
		/**
		 * 获取指定名称并且被选中的checkbox，数组返回.
		 * 如果getValue为true，那么将返回其checkbox的值，否则返回checkbox对象
		 */
		getChecked : function(/*string*/ checkboxName, /*boolean,default is false*/ getValue) {
			var ckboxs = document.getElementsByName(checkboxName);
			if (ckboxs.length == 0) ckboxs = document.getElementsByTagName('INPUT');
			var result = [];
			for (var i = 0; i < ckboxs.length; i ++) {
				if (ckboxs[i].type != 'checkbox') continue;
				if (ckboxs[i].name != checkboxName) continue;
				if (!ckboxs[i].checked) continue;
				if (getValue == true) result[result.length] = ckboxs[i].value;
				else result[result.length] = ckboxs[i];
			}
			return result;
		},
		
		/**
		 * 获取指定名称并且不被选中的checkbox，数组返回.
		 * 如果getValue为true，那么将返回其checkbox的值，否则返回checkbox对象
		 */
		getNotChecked : function(/*string*/ checkboxName, /*boolean,default is false*/ getValue) {
			var ckboxs = document.getElementsByName(checkboxName);
			if (ckboxs.length == 0) ckboxs = document.getElementsByTagName('INPUT');
			var result = [];
			for (var i = 0; i < ckboxs.length; i ++) {
				if (ckboxs[i].type != 'checkbox') continue;
				if (ckboxs[i].name != checkboxName) continue;
				if (ckboxs[i].checked) continue;
				if (getValue == true) result[result.length] = ckboxs[i].value;
				else result[result.length] = ckboxs[i];
			}
			return result;
		},
		
		/**
		 * 对指定的汉字进行编码设置，尤其是在使用prototype.js的时候，如果传递的参数
		 * （不是加在URL后面的）中含有中文的话就会报错误。
		 */
		encode : function(/*string*/str, /*boolean*/multiPart) {
			if (typeof(str) != 'string') return null;
			var mt = multiPart || false;
			return mt == true ? encodeURI(this.trim(str)) : encodeURIComponent(this.trim(str));
		},
		
		/**
		 * 对使用encode进行编码的进行解编码
		 */
		decode : function(/*string*/str, /*boolean*/multiPart) {
			if (typeof(str) != 'string') return null;
			var mt = multiPart || false;
			return mt == true ? decodeURI(str) : decodeURIComponent(str);
		},
				
		/**
		 * 删除左右两端的空格   
		 * @param {Object} str
		 * @return {TypeName} 
		 */
		trim : function(str) {
	 		var _str = str.replace(/(^\s*)|(\s*$)/g, "");  
	 		
	 		var mNameExclude = ["'",'%','&','#','*','`','$','!'];
	 		for (var i = 0; i < mNameExclude.length; i++) {
	 			/*if (_str.indexOf(mNameExclude[i]) != -1) {
	 				base.alert('查询条件中不允许包含下列非法字符：\n' + mNameExclude.join('  '), function(){
	 					
	 				});
	 				return '';
	 			}*/
	 		}
	 		return _str;
		},

		/**
		 * 将指定form节点的所有可提交元素组合成字符串返回
		 */
		_formValues : function(/*object*/formNode)
		{
			if ((!formNode) || (!formNode.tagName) || (!formNode.tagName.toLowerCase() == "form")) {
				base.alert('请指定一个正确的form节点！');
				return null;
			}
			var values = [];
			for (var i = 0; i < formNode.elements.length; i++) {
				var elm = formNode.elements[i];
				if (!elm || elm.tagName.toLowerCase() == "fieldset" || !this._formFilter(elm)) {
					continue;
				}
				var name = this.encode(elm.name);
				var type = elm.type.toLowerCase();
				if (type == "select-multiple") {
					for (var j = 0; j < elm.options.length; j++) {
						if (elm.options[j].selected) {
							values.push(name + "=" + this.encode(elm.options[j].value));
						}
					}
				} else {
					if ($.inArray(type, ["radio", "checkbox"]) > -1) {
						if (elm.checked) {
							values.push(name + "=" + this.encode(elm.value));
						}
					} else {
						values.push(name + "=" + this.encode(elm.value));
					}
				}
			}
			var inputs = formNode.getElementsByTagName("input");
			for (var i = 0; i < inputs.length; i++) {
				var input = inputs[i];
				if (input.type.toLowerCase() == "image" && input.form == formNode && this._formFilter(input)) {
					var name = this.encode(input.name);
					values.push(name + "=" + this.encode(input.value));
					values.push(name + ".x=0");
					values.push(name + ".y=0");
				}
			}
			return values.join("&") + "&";
		},

	  /**
	   * 表单可提交元素过滤器.
	   */
	  _formFilter : function(/*object*/node) {
		  var type = (node.type || "").toLowerCase();
		  return !node.disabled && node.name && !($.inArray(type, ["file", "submit", "image", "reset", "button"]) > -1);
	  },

	 /**
	  * 将服务器端返回的JSON对象转换成js中的对象
	  */
	 json : function(/*string*/jsonString) {
		try {
			return eval('(' + jsonString + ')');
		} catch (ex) {
			return null;
		}
	 },
	
	 /**
	  * 执行指定的文本中的所有脚本,执行成功返回true，否则返回false
	  */
	 exe : function(/*string*/str) {
		if (!str || typeof(str) != 'string') return false;
		try {
			str.evalScripts();
			if (str.extractScripts().length > 0) return true;
			return false;
		} catch (ex) {}
	 },

	/**
	 * 弹出层
	 * @param {Object} msg
	 * @param {Object} _title 可选
	 * @param {Object} _callback	可选
	 */	 
	 alert : function(/*string*/msg,/*[title]*/_title,/*[callback]*/_callback){
	 	msg = !msg ? "" : msg;
	 	if(!_callback){
			box.alert(msg,!_title ? "系统消息" : _title);
		}else{
			box.alert(msg,!_title ? "系统消息" : _title,_callback);
		}
	 },
	 
	 /**
	 * 确认框
	 * @param {Object} msg
	 * @param {Object} _title 可选
	 * @param {Object} _ok	可选	 点击确定执行的方法
	 * @param {Object} _cancel	可选 点击取消执行的方法
	 * @param {Object} _close	可选 关闭窗口时执行的方法
	 */	 
	 confirm : function(/*string*/msg,/*[title]*/_title,/*close*/_ok,/*close*/_cancel,/*close*/_close){
	 	asyncbox.confirm(msg,!_title ? '系统信息' : _title,function(action){
			//confirm 返回三个 action 值，分别是 'ok'、'cancel' 和 'close'。
			if(action == 'ok'){
				if(!_ok){
					return;
				}
				_ok();
			}
			if(action == 'cancel'){
				if(!_cancel){
					return;
				}
				_cancel();
			}
			if(action == "close"){
				if(!_close){
					return;
				}
				_close();
			}
		});
	 },
	 
	 /**
	  *  提示框样式
	  * @param _msg 
	  * @param _type [error success warn] default warn
	  * @param _timer 消失时间 毫秒单位
	  */
	 tips : function(/*提示信息*/_msg,/*提示类型*/_type,/**/_timer){
		 box.tips(_msg,_type,!_timer ?3000 : _timer);
	 },
	 
	 /**
	  * 基于页面的弹出弹，类似于window.open();
	  * @param {Object} _id	弹出层id,如果需要动态操作该层，需明确声明ID。如box.close(id);
	  * @param {Object} _url 请求地址不带参与 http://localhost:8080/
	  * @param {Object} _data 请求参数，可为''	u=name&p=123...
	  * @param {Object} _title 标题，缺省'系统窗口'
	  * @param {Object} _modal 是否遮罩, 缺省true
	  * @param {Object} _width 
	  * @param {Object} _height
	  */
	 open : function(/*string*/_id,/*_url*/_url,/*_data*/_data,/*_title*/_title,/*_modal*/_modal,/*_width*/_width,/*_height*/_height){
	 	if(!_url){
			base.alert("请明确指定请求地址!");
			return;	
		}
	 	box.open({
			id: !_id ? "_box" : _id,
			url: _url,
			data: !_data ? "" : _data,
			title: !_title ? "系统窗口" : _title,
			modal: !_modal ? true : _modal,
			width: !_width ? 600 : _width,
			height: !_height ? 500 : _height
		});
	 },
	 
	/**
	 * 动态加载css文件
	 * @param {Object} path
	 */ 
    dynLoadCss: function(path){
		if(!path || path.length === 0){
			throw new Error('argument "path" is required !');
		}
		var head = document.getElementsByTagName('head')[0];
        var link = document.createElement('link');
        link.href = path;
        link.rel = 'stylesheet';
        link.type = 'text/css';
        head.appendChild(link);
    },
	
	/**
	 * 动态加载js文件
	 * @param {Object} path
	 */
    dynLoadJs: function(path){
		if(!path || path.length === 0){
			throw new Error('argument "path" is required !');
		}
		var head = document.getElementsByTagName('head')[0];
        var script = document.createElement('script');
        script.src = path;
        script.type = 'text/javascript';
        head.appendChild(script);
    },
	 
	/**
	 * 获取当前日期
	 * format 为输出日期格式，默认格式为yyyy-MM-dd
	 */
	 getCurrDate : function (format){
	 	if (!format){
	 		format = 'yyyy-MM-dd';
	 	}
	 	var curDate = new Date();
	 	var year = ''+curDate.getFullYear();
	 	var month = ''+(curDate.getMonth()+1);
	 	var day = ''+curDate.getDate();
	 	var len = 0;
	 	if (month<10)
	 		month = '0'+month;
	 	if (day<10)
	 		day = '0'+day;
	 	var tmp = '';
	 	var result = format;
	 	for (i=0;i<format.length;i++){
	 		chr = format.substr(i,1);
			 if (tmp.indexOf(chr)>-1){
	 			tmp +=   format.substr(i,1);
	 		}
	 		if (('yMd'.indexOf(chr)>-1 && (tmp.indexOf(chr)==-1||i==format.length-1))){
	 			if (tmp.indexOf('y')>=0){
	 				if (tmp.length>4) len = 4; else len = tmp.length;
	 				result = result.replace(tmp,year.substr(4-len));
	 			} else if (tmp.indexOf('M')>=0){
	 				if (tmp.length>2) len = 2; else len = tmp.length;
	 				result = result.replace(tmp,month.substr(2-len));
	 			} else if (tmp.indexOf('d')>=0){
	 				if (tmp.length>2) len = 2; else len = tmp.length;
	 				result = result.replace(tmp,day.substr(2-len));
	 			}
	 			tmp = chr;
	 		}
	 	}
	 	return result;
	 },
	 
	 /**
	  * 取两个日期时间之差
	  */
     getDateDiff : function(date1,date2){   
        var re  = /^(\d{4})\S(\d{1,2})\S(\d{1,2})$/;   
        var dt1,dt2;   
        if(re.test(date1)){   
           dt1= new Date(RegExp.$1,RegExp.$2-1,RegExp.$3);   
        }if(re.test(date2)){   
           dt2=new Date(RegExp.$1,RegExp.$2-1,RegExp.$3);   
        } 
        return Math.floor((dt2-dt1)/(1000 * 60 * 60 * 24))
    },
	/**
	 * 保留数字输入键,禁止字母等字输入
	 */
	digitOnly : function(){
	 	var keyCode = event.keyCode;
		if ((keyCode >= 48 && keyCode <= 57) || (keyCode == 190) || (keyCode >= 96 && keyCode <= 105) || (keyCode == 110) || (keyCode == 8) || (keyCode == 46)){	// [1-9.]
			event.returnValue = true;
		}else{
			event.returnValue = false;
		}
	},
	/**
	 * Ajax上传组件
	 * action1 上传请求地址
	 * buttonId 页面上的上传按钮ID
	 * fileType 允许上传的文件类型，即文件后缀名，多个用逗号隔开, '*'代表允许上传所有格式的文件
	 * maxCount 一个页面上允许上传的文件数，默认1，上传文件在这个数的时候，上传按钮会自动隐藏
	 * uploadSuccess 上传成功后执行的方法 uploadSuccess可接受两个参数(file[文件原名称],filename[生成文件的新名称])
	 * 初始化方法示例：base.initUpload('/imageUpload/upload','upload','jpg,gif,jpeg,png,bmp',10,uploadSuccess);
	 */
	 initUpload : function(/*string*/action1, /*string*/buttonId, /*string*/fileType, /*int*/maxCount,/*上传成功后*/uploadSuccess){
		if(!maxCount || maxCount<1) maxCount = 1;
		var ft = (fileType || 'jpg,gif').replace(new RegExp(',','gm'),'|');
		var button = $('#' + buttonId), interval;
		var buttonval = button.val();
		button.after("<input id='filecount' value='0' type='hidden' />");
		new AjaxUpload(buttonId, {
			action: action1, 
			name: 'file',
			onSubmit : function(file, ext){
						if (ft!='*' && (!ext || !(eval('/^('+ft+')$/i')).test(ext))){
							base.alert('只能上传格式为['+ft+']的图片！');
							return false;
						}
						button.attr('value','正在上传图片');
						this.disable();
						interval = window.setInterval(function(){
							var text = button.attr('value');
							if (text.length < 15){
								button.attr('value', text + '.');					
							} else {
								button.attr('value', buttonval);				
							}
						
						}, 200);
					},
			onComplete: function(file, response){
				var filename = response;
				button.attr('value', buttonval);	
				window.clearInterval(interval);
				var c = parseInt($('#filecount').attr('value')) + 1;
				$('#filecount').attr('value',c);
				if(c >= maxCount){
					$('#' + buttonId).hide();
				}
				this.enable();
				
				//file 原文件名称
				//filename 新生成的文件名称
				uploadSuccess(file,filename);
			}
		});
	},
	processStatus : function(i,x,y){
		if(i == 1){	//show
			$("#" + x).hide();
			$("#" + y).show();
			var str = $("#" + y).val();
			var j = 0;
			setInterval(function(){
				if(j % 4 == 0){
					$("#" + y).val(str);
				}else{
					$("#" + y).val($("#" + y).val()+".");
				}
				j++;
			},700);
		}else{	//hidden
			clearInterval();
			$("#" + x).show();
			$("#" + y).hide();
		}
		
	},
	downloadTemplate : function (filepath,filename){
		this.forward("/template/download?filepath=" + filepath + "&filename=" + encodeURI(filename,"utf-8"));
	},
   initUpload2 : function(/*string*/action1, /*string*/buttonId, /*string*/fileType, /*int*/maxCount,/*上传成功后*/uploadSuccess){
		if(!maxCount || maxCount<1) maxCount = 1;
		var ft = (fileType || 'jpg,gif').replace(new RegExp(',','gm'),'|');
		var button = $('#' + buttonId), interval;
		var buttonval = button.val();
		button.after("<input id='filecount' value='0' type='hidden' />");
		new AjaxUpload(buttonId, {
			action: action1, 
			name: 'file',
			onSubmit : function(file, ext){
						if (ft!='*' && (!ext || !(eval('/^('+ft+')$/i')).test(ext))){
							base.alert('只能上传格式为['+ft+']的文件！');
							return false;
						}
						button.attr('value','正在上传文件');
						this.disable();
						interval = window.setInterval(function(){
							var text = button.attr('value');
							if (text.length < 15){
								button.attr('value', text + '.');					
							} else {
								button.attr('value', buttonval);				
							}
						
						}, 200);
					},
			onComplete: function(file, response){
				var filename = response;
				button.attr('value', buttonval);	
				window.clearInterval(interval);
				var c = parseInt($('#filecount').attr('value')) + 1;
				$('#filecount').attr('value',c);
				this.enable();
				
				//file 原文件名称
				//filename 新生成的文件名称
				uploadSuccess(file,filename);
			}
		});
	}
}

$(document).ready(function(){
	base = new Base();
	if (!box) {
		//加入弹出层CSS及JS AsyncBox.v1.4.5
		base.dynLoadCss("/static/asyncbox/skins/Chrome/asyncbox.css");
		base.dynLoadJs("/static/asyncbox/AsyncBox.v1.4.5.js");
	}	
});

/**
 * 捕获执行JS中的错误信息，并打印
 */
/*
window.onerror = function(_msg, _url, _line) {
	var error = '发现JS错误，报告如下：<br/>地址 : ' + _url + '<br/>'
		+ '行数 : ' + _line + '<br/>错误 : ' + _msg;
	base.alert(error);
	return true; // 在IE中可以避免在地址栏中出现错误提示
};
*/