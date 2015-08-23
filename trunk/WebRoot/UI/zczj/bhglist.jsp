<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date -------  ---------- Note -------------------
 * 1.0  2013-06-21      孙雁斌         新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.system.dao.PtdeptBean"/>
<jsp:directive.page import="UI.dao.zyjk.ZczjdfbBean"/>
<jsp:directive.page import="UI.dao.zyjk.ZczjqyxxzbBean"/>
<jsp:directive.page import="java.util.*"/>
<jsp:directive.page import="org.apache.struts2.ServletActionContext"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	 //PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
     //String distcode=dept.getDistcode();
     ZczjdfbBean dfbBean=new ZczjdfbBean();
     ZczjqyxxzbBean xxbBean=new ZczjqyxxzbBean();
     //List<ZczjqyxxzbBean> xxblist=new ArrayList<ZczjqyxxzbBean>();
     
     String enterno=request.getParameter("enterno");
     xxbBean=xxbBean.findFirst(" where (enterno='"+ enterno +"' or corpkey='"+enterno +"') and bak1 in ('1','3') order by zcsj desc");
     //xxblist=xxbBean.find(" where enterno='"+ enterno +"' and bak1 in ('1','3') order by zcsj desc");
     String sysno;
     if(null==xxbBean){
    	 sysno="";
     }else{
    	 sysno=xxbBean.getSysno();
     }
     
     //System.out.println("企业的编号:"+enterno);
     
 %>
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
     <script language="javascript" src="<%=webpath%>UI/zczj/bhglist.js"></script>
  </head>
  <body  class="bodystyle" style="height:600px">
  <input type="hidden" name="zbid" id="zbid"/>
  <input type="hidden" name="" id="sysno" value="<%=sysno %>"/>
  <input type="hidden" name="distcode" id="distcode" value=""/>
  <div id="layout">
 <!-- 中间区域 -->
 <div class="lay-center-out"  position="center"  style="border: 0"  >
   <!-- grid区域 -->
  <div id="mainGrid"></div>
  </div>
</div>  
</body>  
</html> 
