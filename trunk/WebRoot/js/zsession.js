/*********************************************************************
 *<p>处理内容：平台  公共JAVASCRIPT GRID </p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/

var session;
function  getSession() {  
	  try {
       $.post(webpath+"/st/system/action/session/SessionAction_getSession.action",function(data){
	   session =data;
	   return session;
	   },"json").error(function() { 
				alert("session json error ");
				});
		    			
	 	}catch (e) {
     			alert("session error");
    		}
    		
    	return session			 
	}