<!--
/****************************************************
 * <p>处理内容：劳动者从业史</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29    劳动者从业史               新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.QyldzzysBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyldzzysBean qyldzzywbean = (QyldzzysBean)request.getAttribute("qyldzzywbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean"); 
 
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/ldzcys//ldzcysdetail.js"></script>
  </head>
  <body class="menubody" style="width: 620">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyldzzywbean.sysno" value="<%=qyldzzywbean.getSysno() %>"/>
         <!-- 隐藏域 劳动者编号id -->
         <input type="hidden" id="ldzbh" name="qyldzzywbean.ldzbh" value="<%=qyldzzywbean.getLdzbh() %>"/>
         
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
                   <input name="qyldzzywbean.ldzxm" readonly type="text" id="ldzxm" value="<%=qyldzzywbean.getLdzxm() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">用人单位名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywbean.entername" type="text" id="entername" value="<%=qyldzzywbean.getEntername() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">从事工种：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywbean.csgz" type="text" id="csgz" value="<%=qyldzzywbean.getCsgz() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">工作岗位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywbean.gzgw" type="text" id="gzgw" value="<%=qyldzzywbean.getGzgw() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
                      
            <tr>
                <td class="l-table-edit-td-right">开始时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywbean.kssj" type="text" id="kssj" value="<%=qyldzzywbean.getKssj() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">结束时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywbean.jssj" type="text" id="jssj" value="<%=qyldzzywbean.getJssj() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
             <tr>
                <%--<td class="l-table-edit-td-right">接触危害因素：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyldzzywbean.whys" type="text" id="whys" value="<%=qyldzzywbean.getWhys() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                --%><td class="l-table-edit-td-right">接触危害因素名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  
                <input type="hidden"   id="whys" name="qyldzzywbean.whys" style="width:10px;"  fieldname="whys"   alerttitle="危害因素" value="<%=qyldzzywbean.getWhys() %>" fieldType="text" />
			    <input id="whysmc" name="qyldzzywbean.whysmc"  style="width:100%;"  fieldname="whysmc"   alerttitle="危害因素名称"  type="text" value="<%=qyldzzywbean.getWhysmc() %>" />
			    
                
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
