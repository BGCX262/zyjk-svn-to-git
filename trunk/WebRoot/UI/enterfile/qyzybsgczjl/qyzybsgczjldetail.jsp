<!--
/****************************************************
 * <p>处理内容：职业病危害事故报告与应急处置记录</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-30    孙雁斌               新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.QyzybsgczjlBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyzybsgczjlBean qyzybsgczjlbean = (QyzybsgczjlBean)request.getAttribute("qyzybsgczjlbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/qyzybsgczjl//qyzybsgczjldetail.js"></script>
  </head>
  <body class="menubody" style="width: 580;" >
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyzybsgczjlbean.sysno" value="<%=qyzybsgczjlbean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="enterno" name="qyzybsgczjlbean.enterno" value="<%=qyzybsgczjlbean.getEnterno() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">企业名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.entername" type="text" id="entername" value="<%=qyzybsgczjlbean.getEntername() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">法人代表：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.frdb" type="text" id="frdb" value="<%=qyzybsgczjlbean.getFrdb() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">日期：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qyzybsgczjlbean.date" type="text" id="date" value="<%=qyzybsgczjlbean.getDate() %>" ltype="date" validate="{required:true }" />                   
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">联系电话：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.lxdh" type="text" id="lxdh" value="<%=qyzybsgczjlbean.getLxdh() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">发生时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.fsdate" type="text" id="fsdate" value="<%=qyzybsgczjlbean.getFsdate() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                
                
                <td class="l-table-edit-td-right">报告时间：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.bgdate" type="text" id="bgdate" value="<%=qyzybsgczjlbean.getBgdate() %>" ltype="date" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                
               
                
            </tr>
            <tr>
                <td class="l-table-edit-td-right">接触人数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qyzybsgczjlbean.jcrs" type="text" id="jcrs" value="<%=qyzybsgczjlbean.getJcrs() %>" ltype="spinner" ligerui="{type:'int'}" validate="{required:true }" />                   
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">发病人数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.fbrs" type="text" id="fbrs" value="<%=qyzybsgczjlbean.getFbrs() %>" ltype="spinner" ligerui="{type:'int'}" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">治疗人数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.zlrs" type="text" id="zlrs" value="<%=qyzybsgczjlbean.getZlrs()%>" ltype="spinner" ligerui="{type:'int'}" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">死亡人数：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.swrs" type="text" id="swrs" value="<%=qyzybsgczjlbean.getSwrs() %>" ltype="spinner" ligerui="{type:'int'}" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">职业危害名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qyzybsgczjlbean.whname" type="text" id="whname" value="<%=qyzybsgczjlbean.getWhname()%>" ltype="text" validate="{required:true }" />                   
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">事故经过：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.sgjg" type="text" id="sgjg" value="<%=qyzybsgczjlbean.getSgjg() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">结论：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qyzybsgczjlbean.jl" type="text" id="jl" value="<%=qyzybsgczjlbean.getJl()%>" ltype="text" validate="{required:true }" />                   
                </td>
                <td class="td_message"></td>
                
                 <td class="l-table-edit-td-right">车间名称：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.cjmc" type="text" id="cjmc" value="<%=qyzybsgczjlbean.getCjmc() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>

                
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">报告单位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qyzybsgczjlbean.bgdw" type="text" id="bgdw" value="<%=qyzybsgczjlbean.getBgdw()%>" ltype="text" validate="{required:true }" />                   
                </td>
                <td class="td_message"></td>
                
                
                <td class="l-table-edit-td-right">负责人：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybsgczjlbean.fzr" type="text" id="fzr" value="<%=qyzybsgczjlbean.getFzr() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                
                <td class="l-table-edit-td-right">事故报告人：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                  <input name="qyzybsgczjlbean.bgr" type="text" id="bgr" value="<%=qyzybsgczjlbean.getBgr() %>" ltype="text" validate="{required:true }" />                   
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
