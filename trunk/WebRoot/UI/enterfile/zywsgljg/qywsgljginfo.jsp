<!--
/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-08-19             新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.*"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QywsgljgBean qywsgljgbean = (QywsgljgBean)request.getAttribute("qywsgljgbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>/UI/enterfile/zywsgljg/qywsgljginfo.js"></script>
  
  </head>
  <body class="menubody" style="width: 635">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qywsgljgbean.sysno" value="<%=qywsgljgbean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="enterno" name="qywsgljgbean.enterno" value="<%=qywsgljgbean.getEnterno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">机构名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qywsgljgbean.jgmc" type="text" id="jgmc" value="<%=qywsgljgbean.getJgmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>    
                <td class="l-table-edit-td-right">成立时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qywsgljgbean.creardate" type="text" id="creardate" value="<%=qywsgljgbean.getCreardate() %>" ltype="date" validate="{required:true }" />
                </td>
               <td class="td_message"></td>      
            </tr> 
            <tr>
                <td class="l-table-edit-td-right">分管负责人：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qywsgljgbean.fgfzr" type="text" id="fgfzr" value="<%=qywsgljgbean.getJgmc() %>" ltype="text" />
                </td>
                <td class="td_message"></td>    
                <td class="l-table-edit-td-right">分管负责人电话：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qywsgljgbean.fgfzrdh" type="text" id="fgfzrdh" value="<%=qywsgljgbean.getFgfzrdh() %>" ltype="text" />
                </td>
               <td class="td_message"></td>      
            </tr> 
            
            <tr>
                <td class="l-table-edit-td-right">分管负责人手机：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qywsgljgbean.fgfzrsj" type="text" id="fgfzrsj" value="<%=qywsgljgbean.getFgfzrsj() %>" ltype="text" />
                </td>
                <td class="td_message"></td>    
                <td class="l-table-edit-td-right">机构人数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qywsgljgbean.jgrs" type="text" id="jgrs" value="<%=qywsgljgbean.getJgrs() %>" ltype="text"  />
                </td>
               <td class="td_message"></td>      
            </tr>    
            <tr>
                <td class="l-table-edit-td-right">管理人数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qywsgljgbean.glrs" type="text" id="glrs" value="<%=qywsgljgbean.getGlrs() %>" ltype="text" />
                </td>
                <td class="td_message"></td>    
                <td class="l-table-edit-td-right">专职负责人数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qywsgljgbean.zzfzrs" type="text" id="zzfzrs" value="<%=qywsgljgbean.getZzfzrs() %>" ltype="text"  />
                </td>
               <td class="td_message"></td>      
            </tr>  
            <tr>
                <td class="l-table-edit-td-right">兼职负责人数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qywsgljgbean.jzfzrs" type="text" id="jzfzrs" value="<%=qywsgljgbean.getJzfzrs()%>" ltype="text"  />
                </td>
                <td class="td_message"></td>    
                <td class="l-table-edit-td-right">机构负责人：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qywsgljgbean.jgfzr" type="text" id="jgfzr" value="<%=qywsgljgbean.getJgfzr()%>" ltype="text" validate="{required:true }" />
                </td>
               <td class="td_message"></td>      
            </tr>  
            
            <tr>
                <td class="l-table-edit-td-right">机构负责人电话：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qywsgljgbean.jgfzrdh" type="text" id="jgfzrdh" value="<%=qywsgljgbean.getJgfzrdh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>    
                <td class="l-table-edit-td-right">机构负责人手机：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qywsgljgbean.jgfzrsj" type="text" id="jgfzrsj" value="<%=qywsgljgbean.getJgfzrsj() %>" ltype="text" validate="{required:true }" />
                </td>
               <td class="td_message"></td>      
            </tr>
             <tr>
                <td class="l-table-edit-td-right">机构负责人职务：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qywsgljgbean.fzrzw" type="text" id="fzrzw" value="<%=qywsgljgbean.getFzrzw()%>" ltype="text" />
                </td>
                <td class="td_message"></td>    
                <td class="l-table-edit-td-right">机构负责人职称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qywsgljgbean.fzrzc" type="text" id="fzrzc" value="<%=qywsgljgbean.getFzrzc() %>" ltype="text"  />
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
