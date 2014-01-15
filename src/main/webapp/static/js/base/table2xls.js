function replaceHtml(replacedStr,repStr,endStr){
	var replacedStrF = "";
	var replacedStrB = "";
	var repStrIndex = replacedStr.indexOf(repStr);
	while(repStrIndex != -1){
	    replacedStrF = replacedStr.substring(0,repStrIndex);
		replacedStrB = replacedStr.substring(repStrIndex,replacedStr.length);
		replacedStrB = replacedStrB.substring(replacedStrB.indexOf(endStr)+1,replacedStrB.length);
		replacedStr = replacedStrF + replacedStrB;
		repStrIndex = replacedStr.indexOf(repStr);
	}
	return replacedStr;
}
//elTalbeOut 这个为导出内容的外层表格，主要是设置border之类的样式，elDiv则是整个导出的html部分
function htmlToExcel(elTableOut,elDiv){
	try{
	    //设置导出前的数据，为导出后返回格式而设置
		var elDivStrBak = elDiv.innerHTML;
		//设置table的border=1，这样到excel中就有表格线 ps:感谢双面提醒
		elTableOut.border=1;
		//过滤elDiv内容
		var elDivStr = elDiv.innerHTML;
		elDivStr = replaceHtml(elDivStr,"<A",">");
		elDivStr = replaceHtml(elDivStr,"</A",">");
		elDiv.innerHTML=elDivStr;	
		
		var oRangeRef = document.body.createTextRange();
		oRangeRef.moveToElementText( elDiv );
		oRangeRef.execCommand("Copy");
		
		//返回格式变换以前的内容
		elDiv.innerHTML = elDivStrBak;
		//内容数据可能很大，所以赋空
		elDivStrBak = "";
		elDivStr = "";
		
		var oXL = new ActiveXObject("Excel.Application")
		var oWB = oXL.Workbooks.Add ;
		var oSheet = oWB.ActiveSheet ;
		oSheet.Paste();
		oSheet.Cells.NumberFormatLocal = "@";
		oSheet.Columns("D:D").Select;
		oXL.Selection.ColumnWidth = 20;
		oXL.Visible = true;		
		oSheet = null;
		oWB = null;
		appExcel = null;
	}catch(e){
		alert(e.description);
	}
}
