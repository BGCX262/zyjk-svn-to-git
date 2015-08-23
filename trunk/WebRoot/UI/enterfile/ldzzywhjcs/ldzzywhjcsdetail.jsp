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
<jsp:directive.page import="UI.dao.enterfile.QyldzzywhjcsBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyldzzywhjcsBean qyldzzywhjcsbean = (QyldzzywhjcsBean)request.getAttribute("qyldzzywhjcsbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/ldzzywhjcs//ldzzywhjcsdetail.js"></script>
  </head>
  <body class="menubody" style="width: 625"><%--
  <div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyldzzywhjcsbean.sysno" value="<%=qyldzzywhjcsbean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="ldzbh" name="qyldzzywhjcsbean.ldzbh" value="<%=qyldzzywhjcsbean.getLdzbh() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">劳动者姓名：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.ldzxm" readonly type="text" id="ldzxm" value="<%=qyldzzywhjcsbean.getLdzxm() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">作业工种：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.zygz" type="text" id="zygz" value="<%=qyldzzywhjcsbean.getZygz() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">职业危害工作岗位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.gzgw" type="text" id="gzgw" value="<%=qyldzzywhjcsbean.getGzgw() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">检测时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.jcsj" type="text" id="jcsj" value="<%=qyldzzywhjcsbean.getJcsj() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">有害因素名称1：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.whysmc1" type="text" id="whysmc1" value="<%=qyldzzywhjcsbean.getWhysmc1()%>" ltype="text"  />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">TWA1：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.twa1" type="text" id="twa1" value="<%=qyldzzywhjcsbean.getTwa1() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">有害因素名称2：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.whysmc2" type="text" id="whysmc2" value="<%=qyldzzywhjcsbean.getWhysmc2() %>" ltype="text"/>
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">TWA2</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.twa2" type="text" id="twa2" value="<%=qyldzzywhjcsbean.getTwa2() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">有害因素名称3：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.whysmc3" type="text" id="whysmc3" value="<%=qyldzzywhjcsbean.getWhysmc3() %>" ltype="text" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">TWA3：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.twa3" type="text" id="twa3" value="<%=qyldzzywhjcsbean.getTwa3() %>" ltype="text"  />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">有害因素名称4：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.whysmc4" type="text" id="whysmc4" value="<%=qyldzzywhjcsbean.getWhysmc4() %>" ltype="text" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">TWA4：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywhjcsbean.twa4" type="text" id="twa4" value="<%=qyldzzywhjcsbean.getTwa4() %>" ltype="text" />
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
