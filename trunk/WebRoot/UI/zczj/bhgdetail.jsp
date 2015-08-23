<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-24   孙雁斌       新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.ZczjdfbBean"/>
<jsp:directive.page import="UI.dao.zyjk.T_yhzc_bzbBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 ZczjdfbBean zczjdfbBean = (ZczjdfbBean)request.getAttribute("zczjdfbBean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 T_yhzc_bzbBean bzbBean=new T_yhzc_bzbBean();
 bzbBean=bzbBean.findFirst(" where id='"+ zczjdfbBean.getNrsysno() +"'");
  String value=bzbBean.getBzmc();
 %>
    <script language="javascript" src="<%=webpath%>//UI/zczj/bhgdetail.js"></script>
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
         <input type="hidden" id="sysno" name="zczjdfbBean.sysno" value="<%=zczjdfbBean.getSysno() %>"/>
            
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
        <tr>
        <td class="l-table-edit-td-right">整改项目：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <textarea class="l-textarea" readonly id="" name=""  rows="2" style="width:475px" ><%=value%></textarea>           
                </td>
                <td class="td_message"></td>
        </tr>
      
            <tr>
                <td class="l-table-edit-td-right">整改日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="zczjdfbBean.zgrq" type="text" id="zgrq" value="<%=zczjdfbBean.getZgrq()%>" ltype="date"  />
                </td>
                <td class="td_message"></td>
            </tr>
           
             <tr>
                <td class="l-table-edit-td-right">整改记录：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                    <textarea class="l-textarea" rows="4" id="zcjl" name="zczjdfbBean.zcjl"  style="width:475px" ><%=zczjdfbBean.getZcjl()%></textarea>           
                </td>
                <td class="td_message"></td>
            </tr>
              <tr>
          <td class="l-table-edit-td-right">整改结果：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <% 
                 DBSelect dbsel = new DBSelect("zczjdfbBean.zghc","SFHG",zczjdfbBean.getZghc());
	 				 dbsel.addAttr("style", "width: 202px;");
	 				 dbsel.addAttr("id", "zghc");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "是否合格");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	       %>
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
