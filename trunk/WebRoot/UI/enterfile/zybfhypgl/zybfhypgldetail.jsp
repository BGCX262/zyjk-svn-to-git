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
<jsp:directive.page import="UI.dao.enterfile.QyzybfhypglBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyzybfhypglBean qyzybfhypglBean = (QyzybfhypglBean)request.getAttribute("qyzybfhypglBean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/zybfhypgl//zybfhypgldetail.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyzybfhypglBean.sysno" value="<%=qyzybfhypglBean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="enterno" name="qyzybfhypglBean.enterno" value="<%=qyzybfhypglBean.getEnterno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="entername" name="qyzybfhypglBean.entername" value="<%=qyzybfhypglBean.getEntername() %>"/>
         
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
               <%--
                <td class="l-table-edit-td-right">序号：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhypglBean.xh" type="text" id="xh" value="<%=qyzybfhypglBean.getXh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                --%>
                
                <td class="l-table-edit-td-right" style="width:160px">用品名称：</td>
                <td class="l-table-edit-td-left">
                   <input name="qyzybfhypglBean.fhypmc" type="text" id="fhypmc" value="<%=qyzybfhypglBean.getFhypmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">规格型号：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                    <input name="qyzybfhypglBean.ggxh" type="text" id="ggxh" value="<%=qyzybfhypglBean.getGgxh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                
                <td class="l-table-edit-td-right" style="width:160px">数量：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhypglBean.sl" type="text" id="sl" value="<%=qyzybfhypglBean.getSl() %>" ltype="spinner" ligerui="{type:'int'}" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">使用期限：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhypglBean.syqx" type="text" id="syqx" value="<%=qyzybfhypglBean.getSyqx() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            
            <tr>
                
                <td class="l-table-edit-td-right" style="width:160px">购买商家：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhypglBean.seller" type="text" id="seller" value="<%=qyzybfhypglBean.getSeller() %>" ltype="text"   />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">购买日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhypglBean.buydate" type="text" id="buydate" value="<%=qyzybfhypglBean.getBuydate() %>" ltype="date"  />
                </td>
                <td class="td_message"></td>
            </tr>
            
            
            
            <tr>
               <td class="l-table-edit-td-right">发放范围：</td>
                <td class="l-table-edit-td-left" style="width:160px" colspan="5">
                <textarea  class="l-textarea"  cols="110"  rows="4" id="fffw" name="qyzybfhypglBean.fffw"  
                style="width:475px" ><%=qyzybfhypglBean.getFffw()%></textarea> 
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
