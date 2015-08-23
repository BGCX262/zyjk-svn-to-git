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
<jsp:directive.page import="UI.dao.enterfile.QyzybfhssBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyzybfhssBean qyzybfhssBean = (QyzybfhssBean)request.getAttribute("qyzybfhssBean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/zybfhss//zybfhssdetail.js"></script>
  </head>
  <body class="menubody" style="width: 630"><%--
  <div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyzybfhssBean.sysno" value="<%=qyzybfhssBean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="enterno" name="qyzybfhssBean.enterno" value="<%=qyzybfhssBean.getEnterno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <%--<td class="l-table-edit-td-right">序号：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhssBean.no" type="text" id="no" value="<%=qyzybfhssBean.getNo() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                --%>
                <td class="l-table-edit-td-right" style="width:160px">防护设施名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhssBean.fhssmc" type="text" id="fhssmc" value="<%=qyzybfhssBean.getFhssmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                
                
                <td class="l-table-edit-td-right" style="width:160px">投用日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <input name="qyzybfhssBean.tyrq" type="text" id="tyrq" value="<%=qyzybfhssBean.getTyrq() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                
            </tr>
            <tr>
                
                <%--<td class="l-table-edit-td-right">设备编号：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <input name="qyzybfhssBean.sbbh" type="text" id="sbbh" value="<%=qyzybfhssBean.getSbbh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                
                --%><td class="l-table-edit-td-right" style="width:160px">型号：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhssBean.xh" type="text" id="xh" value="<%=qyzybfhssBean.getXh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right" style="width:160px">所在部位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <input name="qyzybfhssBean.szbw" type="text" id="szbw" value="<%=qyzybfhssBean.getSzbw() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right" style="width:160px">维护检修周期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhssBean.whzq" type="text" id="whzq" value="<%=qyzybfhssBean.getWhzq() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right" style="width:160px">所在车间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhssBean.szcj" type="text" id="szcj" value="<%=qyzybfhssBean.getSzcj() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                
                
                <td class="l-table-edit-td-right" style="width:160px">维护检修人员：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybfhssBean.whry" type="text" id="whry" value="<%=qyzybfhssBean.getWhry() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right" style="width:160px">防护功能：</td>
                <td class="l-table-edit-td-left" colspan="4">
                <textarea  class="l-textarea"  cols="110"  rows="4" id="ffgn" name="qyzybfhssBean.ffgn"  
                style="width:500px" ><%=qyzybfhssBean.getFfgn()%></textarea>     
                
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
