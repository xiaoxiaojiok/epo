/**
 * 吴科2013-9-26
 */
var sy = $.extend( {}, sy);/* 定义一个全局变量 */

/*以下方法没有用到*/
sy.ns = function(){
	var o  = {},d;
	for ( var i = 0; i < arguments.length; i++) {
		d = arguments[i].split(".");
		o = window[d[0]] = window[d[0]] || {};
		for(var k = 0 ; k<d.slice(1).length;k++){
			o = o[d[k+1]] = o[d[k+1]] || {};
		}
	}
	return o;
};

sy.serializeObject = function(form) { /* 将form表单内的元素序列化为对象，扩展Jquery的一个方法 */
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};


function myformatter(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
}
function myparser(s){
	if (!s) return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0],10);
	var m = parseInt(ss[1],10);
	var d = parseInt(ss[2],10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
		return new Date(y,m-1,d);
	} else {
		return new Date();
	}
}
