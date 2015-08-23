<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- jmx ---------- Note -------------------
 * 1.0  2013-05-06               新規作成 ;
 ****************************************************/
-->
<%@ page language="java"  pageEncoding="UTF-8"%>
<jsp:directive.page import="st.system.dao.PtdeptBean"/>
<jsp:directive.page import="org.apache.struts2.ServletActionContext"/>
<jsp:directive.page import="st.platform.security.SystemAttributeNames"/>
<jsp:directive.page import="st.platform.system.cache.EnumerationType"/>
<jsp:directive.page import="UI.util.DistcodeUtil"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
<%		String discode="";
		PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
        String dqcode=dept.getDeptno();
		String[] dises=dqcode.split("-");
		System.out.println("区划编码："+dises[1]);
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
			discode="3702";
		}
 %>
 <head>
 <title></title>
     <script language="javascript" src="<%=webpath%>/UI/zyjk/flfj//tjflfj.js"></script>
  </head>
  <body  class="bodystyle">
  <input type="hidden" name="discode" id="discode" value="<%=discode %>"/>
  <div id="layout">
 <!-- TREE区域 --><%--
 <div position="left" title="菜单"> <ul id="tree"  style="margin-top:3px;"> </div>
 --%><!-- 中间区域 -->
 <div class="lay-center-out"  position="center"  style="border: 0"  >
   <!-- 查询区域 -->
    <div>
<table class="table_search_layout_1"    cellpadding="0" cellspacing="0"  >
<tr>
  <td class="l-table-edit-td-right" >行政区划：</td> 
  <td class="l-table-edit-td-left" >   
   <input type="hidden"  id="distcode" name="distcode" style="width:10px;"   value="<%=discode %>"    />
  <input   id="distcodename"  style="width:70%;"   type="text" value="<%=DistcodeUtil.getDisName(discode)%>"/>
			   
  </td> 
  
  <td class="l-table-edit-td-right" >单位名称：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="dwmc" type="text" id="dwmc" ltype="text"  class="l-research-area-input"/>   
  </td> 
   </tr>
   <tr>
  <td class="l-table-edit-td-right" >联系人：</td> 
  <td class="l-table-edit-td-left" >   
  <input name="lxr" type="text" id="lxr" ltype="text"  class="l-research-area-input"/>   
  </td> 

  <td class="l-table-edit-td-right" >监督管理等级：</td> 
  
          <td class="l-table-edit-td-left">
        	<% 
	               	 DBSelect dbsel = new DBSelect("jdgldj","HDGLDJ","");
	 				 dbsel.addAttr("style", "width: 130px;");
	 				 dbsel.addAttr("id", "jdgldj");
	 				 dbsel.addAttr("class","l-research-area-input");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "监督管理等级");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
        </td>  
   </tr>     
   <tr>     
  <td class="l-table-edit-td-right" >卫生管理等级：</td> 
  <td class="l-table-edit-td-left" >   
           <% 
	               	 dbsel = new DBSelect("wsgldj","ZYWSGLDJ","");
	 				 dbsel.addAttr("style", "width: 130px;");
	 				 dbsel.addAttr("id", "wsgldj");
	 				 dbsel.addAttr("class","l-research-area-input");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "卫生管理等级");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>   
  </td> 
  <td class="l-table-edit-td-right" >危害类别：</td> 
  <td class="l-table-edit-td-left" >   
    <% 
	               	 dbsel = new DBSelect("whlb","ZYBWHLB","");
	 				 dbsel.addAttr("style", "width: 130px;");
	 				 dbsel.addAttr("id", "whlb");
	 				 dbsel.addAttr("class","l-research-area-input");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "危害类别");
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
  
 <td class="l-table-edit-td-left" ></td> 
  <td class="l-table-edit-td-left" >   
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
