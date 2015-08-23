<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-22     孙雁斌          新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.system.dao.PtdeptBean"/>
<jsp:directive.page import="org.apache.struts2.ServletActionContext"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<jsp:directive.page import="UI.util.DistcodeUtil"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<%
	 //PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
        
     //String distcode=dept.getDistcode();
     String discode="";
		PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
     String dqcode=dept.getDeptno();
		String[] dises=dqcode.split("-");
		
		if(dises[1].length()>8){
			if(dises[1].indexOf("0000")>=0){
				dqcode=dqcode.substring(3, 7);
				discode=dqcode+"00";
			}else if(dises[1].indexOf("00")>=0&&dises[1].indexOf("0000")<0){
				dqcode=dqcode.substring(3, 9);
				discode=dqcode;
			}else if(dises[1].indexOf("00")<0&&dises[1].indexOf("0000")<0){
				dqcode=dqcode.substring(3, 11);
				discode=dqcode;
			}
		}else{
				if(dises[1].substring(0,6).indexOf("0000")>=0){
				dqcode=dqcode.substring(3, 5);
				discode=dqcode+"0000";
			}else if(dises[1].substring(0,6).indexOf("00")>=0&&dises[1].substring(0,6).indexOf("0000")<0){
				dqcode=dqcode.substring(3, 7);
				discode=dqcode+"00";
			}else if(dises[1].substring(0,6).indexOf("00")<0&&dises[1].substring(0,6).indexOf("0000")<0){
				dqcode=dqcode.substring(3, 9);
				discode=dqcode;
			}
		}
		if(discode.equals("370200")){
			discode="370200000000";
		}
 %>
 <head>
 <title></title>
     <script language="javascript" src="<%=webpath%>/UI/enterfile/enterlist.js"></script>
  </head>
  <body  class="bodystyle">
   <input type="hidden" name="distcode" id="distcode" value="<%=discode %>"/>
  <div id="layout">
 <!-- TREE区域 --><%--
 <div position="left" title="行政区划"> <ul id="tree"  style="margin-top:3px;"> </div>
 --%><!-- 中间区域 -->
 <div class="lay-center-out"  position="center"  style="border: 0"  >
   <!-- 查询区域 -->
    <div>
    <table class="table_search_layout_1"    cellpadding="0" cellspacing="0"  >
<tr>
  <td class="l-table-edit-td-right" >行政区划：</td> 
  <td class="l-table-edit-td-left" >   
   <input type="hidden"  id="distcode" name="distcode" style="width:10px;"   value="<%=discode %>"    />
  <input   id="distcodename"  style="width:70%;"   type="text" value="<%=DistcodeUtil.getDistName(discode)%>"/>
  </td>  
  
  <td class="l-table-edit-td-right" >组织机构代码：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="zzjgdm" type="text" id="zzjgdm" ltype="text"  class="l-research-area-input"/>   
  </td> 
  

 </tr>
 <tr>
 <td class="l-table-edit-td-right" >单位名称：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="dwmc" type="text" id="dwmc" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >主管单位：</td> 
  <td class="l-table-edit-td-left" >   
    <% 
            DBSelect dbsel = new DBSelect("zhuguan","ZGDW","");
	        dbsel.addAttr("style", "width: 130px;");
	 		dbsel.addAttr("class","l-research-area-input");
	        dbsel.addAttr("check", "notBlank");
	        dbsel.addAttr("required", "true");
	        dbsel.addAttr("showName", "主管单位");
	        dbsel.addOption("请选择","");
 	        dbsel.setDisplayAll(false);
	        out.print(dbsel);
	  %>      
  </td> 
 
 </tr>
<tr>
  <td class="l-table-edit-td-right" >行业类别：</td> 
  <td class="l-table-edit-td-left" >   
   <input type="hidden"    id="hylb" name="hylb" style="width:10px;"  />
   <input id="hylbname"  style="width:65%;"  type="text" value=""/>
  </td> 
  <td class="l-table-edit-td-right" >注册地址：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="zcdz" type="text" id="zcdz" ltype="text"  class="l-research-area-input"/>   
  </td>
  <td align="left">
<input id="searchButton"   class="l-button l-button-submit" type="button" value=" 查询 " onclick="f_search()" />
 </td> 
<td align="left">
 </td> 
 </tr>
    </table>
    </div>
   <!-- grid区域 -->
  <div id="mainGrid"></div>
  </div>
</div>  
</body>  
</html> 
