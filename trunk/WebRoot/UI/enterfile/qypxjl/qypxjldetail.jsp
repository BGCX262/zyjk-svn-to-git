<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27               新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.QypxjlBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QypxjlBean qypxjlBean = (QypxjlBean)request.getAttribute("qypxjlBean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/qypxjl//qypxjldetail.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 操作method -->      
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qypxjlBean.sysno" value="<%=qypxjlBean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="enterno" name="qypxjlBean.enterno" value="<%=qypxjlBean.getEnterno() %>"/>    
         <input type="hidden" id="enternm" name="qypxjlBean.enternm" value="<%=qypxjlBean.getEnternm() %>"/>     
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         
         
         
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         
          <input type="hidden" id="pxjgno" name="qypxjlBean.pxjgno" value="<%=qypxjlBean.getPxjgno() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">人员姓名：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qypxjlBean.ryxm" type="text" id="ryxm" value="<%=qypxjlBean.getRyxm() %>" ltype="text" validate="{required:true }" />
                   <input name="qypxjlBean.rybh" type="hidden" id="rybh" value="<%=qypxjlBean.getRybh() %>" ltype="text" validate="{required:true }" />              
                </td>
                
                <td class="td_message"></td>
                <%--<td class="l-table-edit-td-right">人员编号：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qypxjlBean.rybh" type="text" id="rybh" value="<%=qypxjlBean.getRybh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                
            --%> 
               <td class="l-table-edit-td-right">培训日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                    <input name="qypxjlBean.pxdate" type="text" id="pxdate" value="<%=qypxjlBean.getPxdate() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">培训类型：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                <%
                 	 DBSelect dbsel = new DBSelect("qypxjlBean.pxlx","PXLX",qypxjlBean.getPxlx());
	 				 //dbsel.addAttr("style", "width: 202px;");
	 				 dbsel.addAttr("id", "pxlx");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "培训类型");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
                  %>
                
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">车间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qypxjlBean.cj" type="text" id="cj" value="<%=qypxjlBean.getCj() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
             <tr>
                <td class="l-table-edit-td-right">工种：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qypxjlBean.gz" type="text" id="gz" value="<%=qypxjlBean.getGz() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">分级：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qypxjlBean.fj" type="text" id="fj" value="<%=qypxjlBean.getFj() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            
             <tr>
                <td class="l-table-edit-td-right">培训机构：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qypxjlBean.pxjgmc" type="text" id="pxjgmc" value="<%=qypxjlBean.getPxjgmc() %>" ltype="text" onkeyup="getEnterinfo(this.value)" validate="{required:true}" />
               		<div id="_mainGrid"  style="position:absolute;z-index: 1001;background: white; width: 200px;" ></div>
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">培训学时：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qypxjlBean.pxxs" type="text" id="pxxs" value="<%=qypxjlBean.getPxxs() %>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">理论考核：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                    <input name="qypxjlBean.llkh" type="text" id="llkh" value="<%=qypxjlBean.getLlkh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">实操考核：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qypxjlBean.sckh" type="text" id="sckh" value="<%=qypxjlBean.getSckh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
             <tr>
                <td class="l-table-edit-td-right">补考情况：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qypxjlBean.bkqk" type="text" id="bkqk" value="<%=qypxjlBean.getBkqk() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">课程名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qypxjlBean.kcmc" type="text" id="kcmc" value="<%=qypxjlBean.getKcmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
        </table>
 <br />
<table align="center">
<tr>
 <td>
     <input type="submit" value="提交" id="subButton" class="l-button l-button-submit" /> 
     <input type="button" value="关闭" id="colButton" class="l-button l-button-test"/>
 </td>
</tr>
 
</table>
 </form>
    
</body>  
</html> 
