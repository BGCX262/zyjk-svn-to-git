<!--
/****************************************************
 * <p>处理内容：被检测单位基本信息</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14   新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.JcdwjbxxBean"/>
<jsp:directive.page import="UI.dao.enterfile.QyjbqkBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 JcdwjbxxBean jcdwjbxxbean = (JcdwjbxxBean)request.getAttribute("jcdwjbxxbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 
 %>
    <script language="javascript" src="<%=webpath%>/UI/zyjk/jcjg/jcjgbg/jcdwjbxx/jcdwjbxxdetail.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <div class="searchtitle">        
  <%--<img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form" enctype="multipart/form-data">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="jcdwjbxxbean.sysno" value="<%=jcdwjbxxbean.getSysno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         
         <input type="hidden" id="bgbh" name="jcdwjbxxbean.bgbh" value="<%=jcdwjbxxbean.getBgbh() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">单位名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                	 <input name="jcdwjbxxbean.dwbh" type="hidden" id="dwbh" value="<%=jcdwjbxxbean.getDwbh() %>" ltype="text"  />
                   <input name="jcdwjbxxbean.dwmc" type="text" id="dwmc" value="<%=jcdwjbxxbean.getDwmc() %>" ltype="text"  onkeyup="getEnterinfo(this.value)"  validate="{required:true }" />
               		<div id="_mainGrid"  style="position:absolute;z-index: 1001;background: white; width: 200px;" ></div>
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">单位地址：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.dwdz" type="text" id="dwdz" value="<%=jcdwjbxxbean.getDwdz() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">所属行业：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.sshy" type="text" id="sshy" value="<%=jcdwjbxxbean.getSshy() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">联系人：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.lxr" type="text" id="lxr" value="<%=jcdwjbxxbean.getLxr() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">联系电话：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.lxdh" type="text" id="lxdh" value="<%=jcdwjbxxbean.getLxdh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">企业规模：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.qygm" type="text" id="qygm" value="<%=jcdwjbxxbean.getQygm() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">企业性质：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.qyxz" type="text" id="qyxz" value="<%=jcdwjbxxbean.getQyxz()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">现有员工人数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.ygrs" type="text" id="ygrs" value="<%=jcdwjbxxbean.getYgrs()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">现有设备总数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.sbzs" type="text" id="sbzs" value="<%=jcdwjbxxbean.getSbzs()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">是否组织职工体检：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <%--<input name="jcdwjbxxbean.sftj" type="text" id="sftj" value="<%=jcdwjbxxbean.getSftj() %>" ltype="text" validate="{required:true }" />--%>
               	   <% 
	               	 DBSelect dbsel = new DBSelect("jcdwjbxxbean.sftj","SF",jcdwjbxxbean.getSftj());
	 				 //dbsel.addAttr("style", "width: 130px;");
	 				 dbsel.addAttr("id", "sftj");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">体检单位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.tjdwmc" type="text" id="tjdwmc" value="<%=jcdwjbxxbean.getTjdwmc()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">是否做过预评价：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <%--<input name="jcdwjbxxbean.sfypj" type="text" id="sfypj" value="<%=jcdwjbxxbean.getSfypj() %>" ltype="text" validate="{required:true }" />--%>
                   <% 
	               	 dbsel = new DBSelect("jcdwjbxxbean.sfypj","SF",jcdwjbxxbean.getSfypj());
	 				 //dbsel.addAttr("style", "width: 130px;");
	 				 dbsel.addAttr("id", "sfypj");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">是否做过控制效果评价：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <%--<input name="jcdwjbxxbean.sfkzxgpj" type="text" id="sfkzxgpj" value="<%=jcdwjbxxbean.getSfkzxgpj() %>" ltype="text" validate="{required:true }" />--%>
                	<% 
	               	dbsel = new DBSelect("jcdwjbxxbean.sfkzxgpj","SF",jcdwjbxxbean.getSfkzxgpj());
	 				 //dbsel.addAttr("style", "width: 130px;");
	 				 dbsel.addAttr("id", "sfkzxgpj");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">是否做过职业病危害检测：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <%--<input name="jcdwjbxxbean.sfzywhjc" type="text" id="sfzywhjc" value="<%=jcdwjbxxbean.getSfzywhjc()%>" ltype="text" validate="{required:true }" />--%>
               		<% 
	               	dbsel = new DBSelect("jcdwjbxxbean.sfzywhjc","SF",jcdwjbxxbean.getSfzywhjc());
	 				 //dbsel.addAttr("style", "width: 130px;");
	 				 dbsel.addAttr("id", "sfzywhjc");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">是否有立项批复文件：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <%--<input name="jcdwjbxxbean.sflxpf" type="text" id="sflxpf" value="<%=jcdwjbxxbean.getSflxpf() %>" ltype="text" validate="{required:true }" />--%>
              	   <% 
	               	dbsel = new DBSelect("jcdwjbxxbean.sflxpf","SF",jcdwjbxxbean.getSflxpf());
	 				 //dbsel.addAttr("style", "width: 130px;");
	 				 dbsel.addAttr("id", "sflxpf");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">是否设有管理机构与管理制度：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <%--<input name="jcdwjbxxbean.sfslgl" type="text" id="sfslgl" value="<%=jcdwjbxxbean.getSfslgl()%>" ltype="text" validate="{required:true }" />--%>
               		<% 
	               	dbsel = new DBSelect("jcdwjbxxbean.sfslgl","SF",jcdwjbxxbean.getSfslgl());
	 				 //dbsel.addAttr("style", "width: 130px;");
	 				 dbsel.addAttr("id", "sfslgl");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	            %>
                </td>
                <td class="td_message"></td>
            </tr>
            
             <tr>
                <td class="l-table-edit-td-right">工艺流程：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.gylc" type="hidden" id="gylc" value="<%=jcdwjbxxbean.getGylc() %>" ltype="text" />
                	<input type="file" name="file" id="file"/>
                </td>
                <td class="td_message"></td>
             	 <td class="l-table-edit-td-right">现场检测布点图：</td>
              	  <td class="l-table-edit-td-left" style="width:160px">
                 	  <input name="jcdwjbxxbean.jcbdt" type="hidden" id="jcbdt" value="<%=jcdwjbxxbean.getJcbdt() %>" ltype="text" />
                		<input type="file" name="bdfile" id="bdfile" />
                </td>
                <td class="td_message"></td>
            </tr>
            
             <tr>
                
                  <td class="l-table-edit-td-right">专家意见：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcdwjbxxbean.zjyj" type="text" id="zjyj" value="<%=jcdwjbxxbean.getZjyj() %>" ltype="text" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
            	<td colspan="6" align="center" style="font-size: 16px;font-weight: bold;">
            		<%if(jcdwjbxxbean.getGylc()!=null&&!jcdwjbxxbean.getGylc().equals("null")&&!jcdwjbxxbean.getGylc().equals("")){
            		%>
            			<a href="<%=webpath+jcdwjbxxbean.getGylc()%>">工艺流程图下载</a>
            		<%} %>
            	</td>
            </tr>
             <tr>
            	<td colspan="6" align="center" style="font-size: 16px;font-weight: bold;">
            		<%if(jcdwjbxxbean.getJcbdt()!=null&&!jcdwjbxxbean.getJcbdt().equals("null")&&!jcdwjbxxbean.getJcbdt().equals("")){
            		%>
            			<a href="<%=webpath+jcdwjbxxbean.getJcbdt()%>">现场布点图下载</a>
            		<%} %>
            	</td>
            </tr>          
           
        </table>
 <br />
<table align="center">
<tr>
 <td>
     <input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /><%-- 
     <input type="button" value="关闭" id="colButton" class="l-button l-button-test"/>
 --%></td>
</tr>
 
</table>
 </form>
    
</body>  
</html> 
