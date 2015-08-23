/*********************************************************************
 *<p>处理内容：平台  公共JAVASCRIPT </p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/

/*radio 封装事件*/
function radiochange(_name,_this)
    {
    	var _index = "#"+_name;
    	$(_index).val(_this.value);
    }
    
 /*js取得传递参数*/
    
 function  getUrlParam(strName) {  
		 var strHref =location.href;
		 var intPos = strHref.indexOf("?"); 
		 var strRight = strHref.substr(intPos + 1); 
		 var arrTmp = strRight.split("&"); 
		 for(var i = 0; i < arrTmp.length; i++) { 
		 var arrTemp = arrTmp[i].split("="); 
		 if(arrTemp[0].toUpperCase() == strName.toUpperCase()) return arrTemp[1]; 
		 } 
		 return "";  
	}
	
/*打开子窗口*/
function loadSubWindow(url,width,height){
   if(width==undefined||width==''){
     width = screen.availWidth-10; 
   }else{
     width=width+'px';
   }
   if(height==undefined||height==''){
     height = screen.availHeight-10;
   }else{
     height=height+'px';
   }  
   window.showModalDialog(url,'','dialogHeight:'+ height +';dialogWidth:'+ width +';status:no;location:no;resize:no');
   //window.open(url,"newwindow","height=700px,width=1200px,toolbar=yes,menubar=yes,scrollbars=yes,resizable=yes,location=no,status=yes");
}	