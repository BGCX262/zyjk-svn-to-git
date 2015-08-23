<!--
/****************************************************
 * <p>处理内容：劳动者职业病治疗情况</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29    孙雁斌           新規作成 ;
 ****************************************************/
-->
<%@ page language="java" import="UI.dao.*,st.system.dao.*,st.portal.action.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.enterfile.QyzybzlqkBean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
 <head>
 <title></title>
 <%
 QyzybzlqkBean qyzybzlqkbean = (QyzybzlqkBean)request.getAttribute("qyzybzlqkbean");
 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");
 %>
    <script language="javascript" src="<%=webpath%>//UI/enterfile/ldzzybzlqk//ldzzybzlqkdetail.js"></script>
  </head>
  <body class="menubody" style="width: 625">
  <%--<div class="searchtitle">        
  <img width="20" height="20" src="<%=webpath%>/js/ligerUI/skins/icons/customers.gif"/> 
   </div>        
   <div class="navline" ></div>       

--%><form name="form" method="post"  id="form">
     <div>
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="sysno" name="qyzybzlqkbean.sysno" value="<%=qyzybzlqkbean.getSysno() %>"/>
         <!-- 隐藏域 企业id -->
         <input type="hidden" id="ldzbh" name="qyzybzlqkbean.ldzbh" value="<%=qyzybzlqkbean.getLdzbh() %>"/>
         <!-- 操作method -->           
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         
         
         <input type="hidden" id="zddwbh" name="qyzybzlqkbean.zddwbh" value="<%=qyzybzlqkbean.getZddwbh() %>"/>
     </div>
        <table cellpadding="0" cellspacing="0" class="form-l-table-edit" align="center">
            <tr>
                <td class="l-table-edit-td-right">劳动者姓名：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybzlqkbean.ldzxm" readonly type="text" id="ldzxm" value="<%=qyzybzlqkbean.getLdzxm() %>" ltype="text" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">诊断单位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybzlqkbean.zddwmc" type="text" id="zddwmc" value="<%=qyzybzlqkbean.getZddwmc() %>" ltype="text" onkeyup="getEnterinfo(this.value)" validate="{required:true }" />
                   	<div id="_mainGrid"  style="position:absolute;z-index: 1001;background: white; width: 200px;" ></div>
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">是否调离原岗位：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                      <% 
				               	 DBSelect dbsel = new DBSelect("qyzybzlqkbean.sfdl","SF",qyzybzlqkbean.getSfdl());
				 				 //dbsel.addAttr("style", "width: 202px;");
				 				 dbsel.addAttr("id", "sfdl");
				                 dbsel.addAttr("check", "notBlank");
				                 dbsel.addAttr("required", "true");
				                 dbsel.addAttr("showName", "是否调离原岗位");
				                 dbsel.addOption("请选择","");
			 	             	 dbsel.setDisplayAll(false);
				                 out.print(dbsel);
				            %>
                
                
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">职业病医疗待遇：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybzlqkbean.zybyldy" type="text" id="zybyldy" value="<%=qyzybzlqkbean.getZybyldy() %>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">职业病津贴：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybzlqkbean.zybjt" type="text" id="zybjt" value="<%=qyzybzlqkbean.getZybjt() %>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">职业病护理费：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybzlqkbean.zybhlf" type="text" id="zybhlf" value="<%=qyzybzlqkbean.getZybhlf() %>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            <tr>
                <td class="l-table-edit-td-right">辅助器具费：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <input name="qyzybzlqkbean.fzqjf" type="text" id="fzqjf" value="<%=qyzybzlqkbean.getFzqjf() %>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">伤残抚恤费：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybzlqkbean.scfxf" type="text" id="scfxf" value="<%=qyzybzlqkbean.getScfxf() %>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">在职伤残补助金：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <input name="qyzybzlqkbean.zzscbzj" type="text" id="zzscbzj" value="<%=qyzybzlqkbean.getZzscbzj() %>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">易地安家补助费：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybzlqkbean.ydajbzf" type="text" id="ydajbzf" value="<%=qyzybzlqkbean.getYdajbzf() %>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">就业补助金：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <input name="qyzybzlqkbean.jybzj" type="text" id="jybzj" value="<%=qyzybzlqkbean.getJybzj()%>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">医疗费：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybzlqkbean.ylf" type="text" id="ylf" value="<%=qyzybzlqkbean.getYlf() %>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
            
            <tr>
                <td class="l-table-edit-td-right">丧葬补助金：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <input name="qyzybzlqkbean.szbzj" type="text" id="szbzj" value="<%=qyzybzlqkbean.getSzbzj() %>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
                <td class="l-table-edit-td-right">供养亲属抚恤金：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                   <input name="qyzybzlqkbean.gyqsfxj" type="text" id="gyqsfxj" value="<%=qyzybzlqkbean.getGyqsfxj()%>" ltype="spinner" validate="{required:true }" />
                </td>
                <td class="td_message"></td>
            </tr>
             <tr>
                <td class="l-table-edit-td-right">一次性补助金：</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <input name="qyzybzlqkbean.ycbzj" type="text" id="ycbzj" value="<%=qyzybzlqkbean.getYcbzj()%>" ltype="spinner" validate="{required:true }" />
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
