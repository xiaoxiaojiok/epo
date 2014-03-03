<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>广州广报</title>
<link type="text/css"  href="${ctx }/static/style/css.css" rel="stylesheet"/>
<link rel="shortcut icon" href="${ctx }/favicon.ico" />
<script type="text/javascript" src="${ctx }/static/js/base/base.js"></script>
<script type="text/javascript" src="${ctx}/static/easyui/jquery-1.8.0.min.js"></script>

<script type="text/javascript"> 
<script type="text/javascript"> 
function todo(url){
	parent.document.getElementById("middleFrame").src = url;
}
</script>

</head>
<body>
<style type="text/css">
	body{background:none;}
	.changemonitorCon { height: 1250px; }
	.distop { margin-top:80px; }
	.mergemedia {
	          width:979px;
	          height:675px;
	          margin:0 auto;
	          margin-top:80px;
	          }	     	
</style>
		
				<!-- 页面内容 start -->
				
		      <div class="monitorCon changemonitorCon">
					<!-- top start -->
						<div class="monitorTopBox">
							<div class="monitorTitle">
								<span class="aTitle">城市形象与认识度</span>
								<span class="bTitle">主流媒体关注度</span>
							</div>
							
					    </div>
					<!-- top end -->
					<!-- content start -->
				<center>
					
					<img src="http://chart.apis.google.com/chart?chs=600x400&chd=${mediaAttention_Y}&cht=bvs&chbh=50&chdl=正面|中立|负面&chtt=主流媒体关注度柱状图&chco=ff0000,0000ff,00ff00&chf=c,s,76A4FB|bg,s,FFF2CC&chxt=x,y&chxl=${mediaAttention_X}"/>
					       
					   <div class="mergemedia">
					        <div class="addPointConBnt" float="center">
					                 <c:forEach var="mainMedia" items="${mainMediaList }">
					                     <div class="addPointConBntDiv" ><input type="hidden" name="ss" value="${mainMedia.name }">${mainMedia.name }</div>
					                 </c:forEach>
					         </div>
					            <table id="displayContent">
					             <tr >
					                 <td >
					                	 <img  src="http://chart.apis.google.com/chart?chs=400x250&chd=${mainmedia_Y }&cht=p&chco=00ff00,0000ff,ff0000&chtt=报道倾向性&chl=${mainmedia_X } "/>
					                 </td>
					                 <td> 
					                 	 <img  src="http://chart.apis.google.com/chart?chs=400x250&chd=${mainmediaIsAbout_Y }&cht=p3&chco=00ff00,0000ff,ff0000&chtt=涉穂报道倾向性&chl=${mainmediaIsAbout_X } "/>
					                 </td>
					             </tr>
					             <tr>
					                <td colspan="2" align="center"> 
					                	<img src="http://chart.apis.google.com/chart?chs=600x250&chd=${hemotion_Y}&cht=lc&chbh=60&chdl=正面|中立|负面&chtt=情感倾向变化趋势&chco=ff0000,0000ff,00ff00&chf=
											c,ls,90,999999,0.25,CCCCCC,0.25,FFFFFF,0.25&chxt=x,y&chxl=${hemotion_X}"/>
					                </td>
					             </tr>
					         </table>
					     </div>
				</center>
					<!-- content end -->
			</div>
				
				<!-- 页面内容  end -->
<input type="hidden" id="getMainmediaAttentionDetail" value="/cityRecognize/getMainmediaAttentionDetail">
<!-- table content end -->
<script type="text/javascript">
$(function()
{
//执行按钮切换效果
	changeBnt("addPointConBntDiv","basic");
})


//按钮切换效果
function changeBnt(bnt,con)
{
	$("."+bnt).click(function()
	{
		$("."+bnt).removeClass("addPointConBntAct");
		$(this).addClass("addPointConBntAct");
		var option = '';
		var mainmediaName = $(this).find("input[type='hidden']").val();
		$.ajax({url:$("#getMainmediaAttentionDetail").val(),  //获取子分类的URL
			type: 'get',
			async: false,
			data: {mainmediaName:mainmediaName},
			success: function(msg)
			{
				option= '<tr><td><img  src="http://chart.apis.google.com/chart?chs=400x250&chd='+msg[0].Y+'&cht=p&chco=00ff00,0000ff,ff0000&chtt=报道倾向性&chl='+msg[0].X+ '"/>'+
						'</td><td><img  src="http://chart.apis.google.com/chart?chs=400x250&chd='+msg[1].Y+'&cht=p3&chco=00ff00,0000ff,ff0000&chtt=涉穂报道倾向性&chl='+msg[1].X+ '"/>'+
						'</td><tr><td colspan="2" align="center"><img src="http://chart.apis.google.com/chart?chs=600x250&chd='+msg[2].Y+'&cht=lc&chbh=60&chdl=正面|中立|负面&chtt=情感倾向变化趋势&chco=ff0000,0000ff,00ff00&chf=c,ls,90,999999,0.25,CCCCCC,0.25,FFFFFF,0.25&chxt=x,y&chxl='+msg[2].X+ '"/></td></tr>';
				$("#displayContent").html(option); // 数据插入到子分类下拉表！
			
				}  
     });

	}) ;
	

}
</script>
</body>
</html>
