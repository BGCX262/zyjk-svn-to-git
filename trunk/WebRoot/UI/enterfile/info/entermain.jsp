<!--
/*********************************************************************
 *<p>处理内容：treemenu列表</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.6.16---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.portal.action.MessageBean"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<jsp:directive.page import="UI.dao.zyjk.T_officerBean"/>
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>

<%
	
	MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
	T_officerBean officer=(T_officerBean)session.getAttribute(SystemAttributeNames.CORP_INFO_NAME);
	QyjbqkBean qyjbqkBean=new QyjbqkBean();
	String enterno=officer.getLogin_id();
	String url="";
	qyjbqkBean=qyjbqkBean.findFirst(" where corpkey='"+ officer.getLogin_id() +"'");
	String state="1";
	if(null!=qyjbqkBean){
		enterno=qyjbqkBean.getEnterno();
		 url+="/UI/action/enter/EnterMain_findByKey.action?messageBean.method=update&state=0&strSysno="+enterno;
		 state="2";
	}else{
		 url+="/UI/action/enter/EnterMain_findByKey.action?messageBean.method=add&state=0&strSysno="+enterno;
	}
	
	if(null==officer){
		officer=new T_officerBean();
	}
	if(null==messageBean){
		messageBean=new MessageBean();
	}
	
	
 %>
<head>
<title>职业危害信息管理系统-企业用户</title>
<script  src="<%=webpath%>/UI/enterfile/info/entermain.js" type="text/javascript"></script> 
<script>
       /*退出*/
       function userlogout(){
               
                $.ligerDialog.confirm("退出系统", function (state)
              {
                    if(state)
                   {    
                       $.post(webpath+"st/system/action/login/LoginAction_remove.action",function(data){            
                         if(data.checkFlag=="1"){
                          window.location.href="../../../select.html";    
                   }
				        },"json").error(function() { 
					           alert("error");
				        }); 
                   }else{
                   
                   }
               });	
              
		      
        }          

</script>
<style>
	 /* 顶部 */ 
    .l-topmenu{ margin:0; padding:0; height:31px; line-height:31px; background:url('<%=webpath%>images/top.jpg') repeat-x bottom;  position:relative; border-top:1px solid #1D438B;  }
    .l-topmenu-logo{ color:#E7E7E7; padding-left:35px; line-height:26px;background:url('<%=webpath%>images/msn.gif') no-repeat 10px 5px;}
    .l-topmenu-welcome{  position:absolute; height:24px; line-height:24px;  right:30px; top:2px;color:#070A0C;}
    .l-topmenu-welcome a{ color:#E7E7E7; text-decoration:underline} 
</style>
</head> 
<body>
			<!-- 操作method -->		 	
		 	<input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod()%>"/>
		 	<!-- 操作状态flag -->	
		 	<input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
		 	<!-- 操作message信息 -->	
		 	<input type="hidden" id="enterno" name="enterno" value="<%=enterno %>"/>
		 	
		 
		 	
		 	
		 	<!--  判断 企业是否保存信息-->
		 	<input type="hidden" id="state" name="state" value="<%=state %>"/>
  <div id="topmenu" class="l-topmenu">
	    <div class="l-topmenu-logo">职业危害防治信息平台-企业用户</div>
	    <div class="l-topmenu-welcome">
     <span class="space">|</span>
        <a href="#" class="l-link2" target="">帮助</a> 
        <span class="space">|</span>
         <a href="javascript:userlogout()" class="l-link2">退出</a>
    </div> 
	</div>		 	
  <div id="layout">
            
            <div position="left" title="企业信息导航"> <ul id="tree"  style="margin-top:3px;"> </div>
            <div position="center" id="navtab">
              <div tabid="1" title="基本信息"  >
            	<iframe frameborder="0" name="showmessage" src="<%=webpath+url%>"></iframe>
            </div>           
           </div>
  </div>
  <div  style="height:32px; line-height:32px; text-align:center;color: black">
            技术支持:信软科技 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 联系电话:15725208580&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
  </body>
</html>