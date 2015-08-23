<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- jmx ---------- Note -------------------
 * 1.0  2013-06-06               新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.system.dao.PtdeptBean"/>
<jsp:directive.page import="org.apache.struts2.ServletActionContext"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<jsp:directive.page import="UI.util.DistcodeUtil"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
     <script language="javascript" src="<%=webpath%>UI/zczj//zczjlist.js"></script>
  </head>
  <body  class="bodystyle">
  <input type="hidden" name="zbid" id="zbid"/>
  <input type="hidden" name="distcode" id="distcode" value="<%=discode %>"/>
  <div id="layout">
 <!-- TREE区域 -->
 <%--<div position="left" title="菜单"> <ul id="tree"  style="margin-top:3px;overflow:scroll;height:500px;width:200px"> </div>
 --%><!-- 中间区域 -->
 <div class="lay-center-out"  position="center"  style="border: 0"  >
   <!-- 查询区域 -->
    <div>
    <table class="table_search_layout_1"  cellpadding="0" cellspacing="0"  >
<tr>
  
  <td class="l-table-edit-td-right" >行政区划：</td> 
  <td class="l-table-edit-td-left" >   
   <input type="hidden"  id="distcode" name="distcode" style="width:10px;"   value="<%=discode %>"    />
  <input   id="distcodename"  style="width:70%;"   type="text" value="<%=DistcodeUtil.getDistName(discode)%>"/>
  </td> 
  
  <td class="l-table-edit-td-right" >单位名称：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="dwmc" type="text" id="dwmc" ltype="text"  class="l-research-area-input"/>   
  </td> 
  <td class="l-table-edit-td-right" >行业分类：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="hyflname" type="text" id="hyflname" ltype="text" />   
  <input name="hyfl" type="hidden" id="hyfl" ltype="text"  />   
  </td> 
  
  
  
 </tr>
 <tr>  
  <td class="l-table-edit-td-right" >自查时间段：</td> 
  <td class="l-table-edit-td-left"  colspan="3"> 
  <table>
  	<tr>
  		<td><input name="zcsj" type="text" id="zcsj" ltype="date"  /></td>
  		<td>——</td>
  		<td>  <input name="zcsje" type="text" id="zcsje" ltype="date"  /></td>
  	</tr>
  </table>  

 
  
  </td>
 <td class="l-table-edit-td-right" >项目类别：</td> 
  <td class="l-table-edit-td-left" >   
   <input name="prjName" type="text" id="prjName" ltype="text" />  
    <input name="prjLevel" type="hidden" id="prjLevel" ltype="text" />   
  <input name="prj" type="hidden" id="prj" ltype="text"  />    
  </td>  
<td align="left">
<input id="searchButton"   class="l-button l-button-submit" type="button" value=" 查询 " onclick="f_search()" />
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
