<!--
/****************************************************
 * <p>处理内容：劳动者康复情况</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29    孙雁斌              新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.QyzlkfqkBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyzlkfqkBean qyzlkfqkbean = (QyzlkfqkBean)request.getAttribute("qyzlkfqkbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/ldzkfqk/ldzkfqkdetail.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyzlkfqkbean.sysno" value="<%=qyzlkfqkbean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="ldzbh" name="qyzlkfqkbean.ldzbh" value="<%=qyzlkfqkbean.getLdzbh() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         
         
          <input type="hidden" id="zldwbh" name="qyzlkfqkbean.zldwbh" value="<%=qyzlkfqkbean.getZldwbh() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">劳动者姓名：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzlkfqkbean.ldzxm" readonly type="text" id="ldzxm" value="<%=qyzlkfqkbean.getLdzxm() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzlkfqkbean.sj" type="text" id="sj" value="<%=qyzlkfqkbean.getSj() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">治疗：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <input name="qyzlkfqkbean.zl" type="text" id="zl" value="<%=qyzlkfqkbean.getZl() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">康复：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzlkfqkbean.kf" type="text" id="kf" value="<%=qyzlkfqkbean.getKf() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
             <tr>
                <td class="l-table-edit-td-right">治疗单位名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <input name="qyzlkfqkbean.zldwmc" type="text" id="zldwmc" value="<%=qyzlkfqkbean.getZldwmc() %>" ltype="text" onkeyup="getEnterinfo(this.value)" validate="{required:true }" />
                 	<div id="_mainGrid"  style="position:absolute;z-index: 1001;background: white; width: 200px;" ></div>
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
