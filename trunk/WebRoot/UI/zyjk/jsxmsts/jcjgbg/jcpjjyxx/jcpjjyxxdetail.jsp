<!--
/****************************************************
 * <p></p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29            新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.JcpjjyxxBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 JcpjjyxxBean jcpjjyxxbean = (JcpjjyxxBean)request.getAttribute("jcpjjyxxbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>/UI/zyjk/jcjg/jcjgbg/jcpjjyxx/jcpjjyxxdetail.js"></script>
  </head>
  <body class="menubody" style="width: 580">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="jcpjjyxxbean.sysno" value="<%=jcpjjyxxbean.getSysno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         
         <input type="hidden" id="bgbh" name="jcpjjyxxbean.bgbh" value="<%=jcpjjyxxbean.getBgbh() %>"/>
         
          <input type="hidden" id="dwbh" name="jcpjjyxxbean.dwbh" value="<%=jcpjjyxxbean.getDwbh() %>"/>
          
           <input type="hidden" id="jcdwbh" name="jcpjjyxxbean.jcdwbh" value="<%=jcpjjyxxbean.getJcdwbh() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">单位名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcpjjyxxbean.dwmc" type="text" id="dwmc" value="<%=jcpjjyxxbean.getDwmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">检测单位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="jcpjjyxxbean.jcdwmc" type="text" id="jcdwmc" value="<%=jcpjjyxxbean.getJcdwmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td  class="l-table-edit-td-right">组织管理：</td>
                <td  class="l-table-edit-td-left" colspan="4" > 
                <textarea cols="110"  rows="3" class="l-textarea" id="zzgl" name="jcpjjyxxbean.zzgl"  style="width:475px" validate="{required:true}" ><%=jcpjjyxxbean.getZzgl()%></textarea>
                </td> 
                <td  class="td_message"></td>
            </tr>
            
            <tr>
                <td  class="l-table-edit-td-right">工程技术：</td>
                <td  class="l-table-edit-td-left" colspan="4" > 
                <textarea cols="110"  rows="3" class="l-textarea" id="gcjs" name="jcpjjyxxbean.gcjs"  style="width:475px" validate="{required:true}" ><%=jcpjjyxxbean.getGcjs()%></textarea>
                </td> 
                <td  class="td_message"></td>
            </tr>
            
            <tr>
                <td  class="l-table-edit-td-right">个体防护：</td>
                <td  class="l-table-edit-td-left" colspan="4" > 
                <textarea cols="110"  rows="3" class="l-textarea" id="gtfh" name="jcpjjyxxbean.gtfh"  style="width:475px" validate="{required:true}" ><%=jcpjjyxxbean.getGtfh()%></textarea>
                </td> 
                <td  class="td_message"></td>
            </tr>
            
            <tr>
                <td  class="l-table-edit-td-right">卫生保健：</td>
                <td  class="l-table-edit-td-left" colspan="4" > 
                <textarea cols="110"  rows="3" class="l-textarea" id="wsbj" name="jcpjjyxxbean.wsbj"  style="width:475px" validate="{required:true}" ><%=jcpjjyxxbean.getWsbj()%></textarea>
                </td> 
                <td  class="td_message"></td>
            </tr>
            <tr>
                <td  class="l-table-edit-td-right">应急救援：</td>
                <td  class="l-table-edit-td-left" colspan="4" > 
                <textarea cols="110"  rows="3" class="l-textarea" id="yjjy" name="jcpjjyxxbean.yjjy"  style="width:475px" validate="{required:true}" ><%=jcpjjyxxbean.getYjjy()%></textarea>
                </td> 
                <td  class="td_message"></td>
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
