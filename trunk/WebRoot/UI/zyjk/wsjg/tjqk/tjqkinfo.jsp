<!--
/****************************************************
 * <p>处理内容：劳动者健康检查结果</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29  新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.QyzywsjkjcjgBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyzywsjkjcjgBean qyzywsjkjcjgbean = (QyzywsjkjcjgBean)request.getAttribute("qyzywsjkjcjgbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>/UI/zyjk/wsjg/tjqk/tjqkinfo.js"></script>
  </head>
  <body class="menubody" style="width: 600">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyzywsjkjcjgbean.sysno" value="<%=qyzywsjkjcjgbean.getSysno() %>"/>
         <!-- 隐藏域 劳动者 id -->
         <input type="hidden" id="ldzbh" name="qyzywsjkjcjgbean.ldzbh" value="<%=qyzywsjkjcjgbean.getLdzbh() %>"/>
         
         <!-- 隐藏域 体检单位编号 id -->
         <input type="hidden" id="tjdwbh" name="qyzywsjkjcjgbean.tjdwbh" value="<%=qyzywsjkjcjgbean.getTjdwbh() %>"/>       
         
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
                   <input name="qyzywsjkjcjgbean.ldzxm" type="text" id="ldzxm" value="<%=qyzywsjkjcjgbean.getLdzxm() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">检查单位名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.entername" type="text" id="entername" value="<%=qyzywsjkjcjgbean.getEntername() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">检查时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.jcdate" type="text" id="jcdate" value="<%=qyzywsjkjcjgbean.getJcdate() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">粉尘：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.fc" type="text" id="fc" value="<%=qyzywsjkjcjgbean.getFc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">毒物：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.dw" type="text" id="dw" value="<%=qyzywsjkjcjgbean.getDw() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">物理因素：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.wl" type="text" id="wl" value="<%=qyzywsjkjcjgbean.getWl() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">上岗前：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.gq" type="text" id="gq" value="<%=qyzywsjkjcjgbean.getGq() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">在岗期间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.gz" type="text" id="gz" value="<%=qyzywsjkjcjgbean.getGz() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">离岗时：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.lg" type="text" id="lg" value="<%=qyzywsjkjcjgbean.getLg() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">正常：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.normal" type="text" id="normal" value="<%=qyzywsjkjcjgbean.getNormal()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">复查：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.recheck" type="text" id="recheck" value="<%=qyzywsjkjcjgbean.getRecheck() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">病人：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.patient" type="text" id="patient" value="<%=qyzywsjkjcjgbean.getPatient() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">禁忌症：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.jjz" type="text" id="jjz" value="<%=qyzywsjkjcjgbean.getJjz()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">其他疾患：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.qtjh" type="text" id="qtjh" value="<%=qyzywsjkjcjgbean.getQtjh()%>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">体检单位名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzywsjkjcjgbean.tjdwmc" type="text" id="tjdwmc" value="<%=qyzywsjkjcjgbean.getTjdwmc() %>" ltype="text" validate="{required:true }" />
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
