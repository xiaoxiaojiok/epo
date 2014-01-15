function setImagePreview(filename,imgname,imgdiv) {
        var docObj=document.getElementById(filename);
 
        var imgObjPreview=document.getElementById(imgname);
                if(docObj.files &&    docObj.files[0]){
                        //火狐下，直接设img属性
                        imgObjPreview.style.display = 'block';
                        imgObjPreview.style.width = '150px';
                        imgObjPreview.style.height = '120px';
                        //imgObjPreview.src = docObj.files[0].getAsDataURL();

      //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式  
      imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);

                }else{
                        //IE下，使用滤镜
                        docObj.select();
                        var imgSrc = document.selection.createRange().text;
                        var localImagId = document.getElementById(imgdiv);
                        //必须设置初始大小
                        localImagId.style.width = "150px";
                        localImagId.style.height = "120px";
                        //图片异常的捕捉，防止用户修改后缀来伪造图片
try{
                                localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
                                localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
                        }catch(e){
                                alert("您上传的图片格式不正确，请重新选择!");
                                return false;
                        }
                       
                        imgObjPreview.style.display = 'none';
                        document.selection.empty();
                }
                return true;
        }


	function getSWF(movieName){
		if (window.document[movieName]){
		   return window.document[movieName];
		}else if (navigator.appName.indexOf("Microsoft Internet")==-1){
		   if (document.embeds && document.embeds[movieName])
		   return document.embeds[movieName]; 
		}else{
		   return document.getElementById(movieName);
		}
	} 


