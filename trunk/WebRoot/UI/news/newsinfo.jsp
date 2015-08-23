<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.page import="UI.dao.zyjk.NewsBean"/>
<jsp:directive.page import="st.portal.action.MessageBean"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
NewsBean newsBean=(NewsBean)request.getAttribute("newsBean");
if(newsBean==null){
	newsBean=new NewsBean();
}

 MessageBean messageBean = (MessageBean)request.getAttribute("messageBean");

%>
<%@ include file="/global.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新闻信息</title>
    <script type="text/javascript" src="<%=path%>/FCKeditor/fckeditor.js"></script>
    <script language="javascript" src="<%=path%>/UI/news/newsinfo.js"></script>
    <script type="text/javascript" src="<%=basePath%>js/jquery-1.4.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
  </head>
  
  <body>
   	<form name="form" method="post"  id="form" enctype="multipart/form-data">
     <div>
         <!-- 操作method -->      
         <!-- 隐藏域 主键id -->
         <input type="hidden" id="id" name="newsBean.sysno" value="<%=newsBean.getSysno()%>"/>
            
         <input type="hidden" id="method" name="messageBean.method" value="<%=messageBean.getMethod() %>"/>
         <!-- 操作状态flag -->   
         <input type="hidden" id="flag" name="flag" value="<%=messageBean.getCheckFlag() %>"/>
         <!-- 操作message信息 -->    
         <input type="hidden" id="message" name="message" value="<%=messageBean.getCheckMessage() %>"/>
         
         <!-- 隐藏域  操作方式-->            
         <input type="hidden" id="bak1" name="newsBean.bak1" value="<%=newsBean.getBak1() %>"/>
         <!-- 隐藏域  发布人-->    
         <input type="hidden" id="isscueperson" name="newsBean.isscueperson" value="<%=newsBean.getIsscueperson() %>"/>
         <!-- 隐藏域  来源--> 
         <input type="hidden" id="messageorigin" name="newsBean.messageorigin" value="<%=newsBean.getMessageorigin() %>"/>   
     </div>
        <table cellpadding="0" cellspacing="0" align="center"  border="1px" bordercolor="#B9D3EE" style="width:80%;"><%--
        
        <tr>
        	<td colspan="3" align="center" style="font-size: 28">
        			新闻信息
        	</td>
        </tr>
        
        --%><tr>
        <td class="l-table-edit-td-right" width="50px"  style="width:50px;">新闻名称</td>
                <td class="l-table-edit-td-left" style="width:160px">
                
                  <input type="text" id="bzzmc" ltype="text" style="width:160px" name="newsBean.title" value="<%=newsBean.getTitle() %>"/>         
                </td>
                
        </tr>
        <tr>
          <td class="l-table-edit-td-right">新闻类型</td>
                <td class="l-table-edit-td-left" style="width:160px">
                 <% 
                 DBSelect dbsel = new DBSelect("newsBean.messagetype","XWLX",newsBean.getMessagetype());
	 				 dbsel.addAttr("style", "width: 202px;");
	 				 dbsel.addAttr("id", "Messagetype");
	                 dbsel.addAttr("check", "notBlank");
	                 dbsel.addAttr("required", "true");
	                 dbsel.addAttr("showName", "新闻类型");
	                 dbsel.addAttr("class","l-research-area-input");
	                 dbsel.addOption("请选择","");
 	             	 dbsel.setDisplayAll(false);
	                 out.print(dbsel);
	           %>
                </td>
                
        </tr>
		 <tr>
        <td class="l-table-edit-td-right">发布时间</td>
                <td class="l-table-edit-td-left" style="width:160px">
                
                  <input type="text" id="isscuedate" ltype="date"  name="newsBean.isscuedate" value="<%=newsBean.getIsscuedate() %>"/>         
                </td>
                
        </tr>
           
             <tr>
                <td class="l-table-edit-td-right">内容</td>
                <td class="l-table-edit-td-left" >
                	<input type="hidden" name="newsBean.content" id="content"/>
                    <textarea class="l-textarea"  id="contentx" name="contentx" ltype="text"  style="width:80%" ><%=newsBean.getContent()%></textarea>
                    <script type="text/javascript">
						var oFCKeditor = new FCKeditor('contentx') ;
						oFCKeditor.BasePath = '<%=path%>/FCKeditor/' ;
						oFCKeditor.ToolbarSet = 'Default';
						oFCKeditor.Width='100%';
						oFCKeditor.Height='400';
						oFCKeditor.Value='';
						oFCKeditor.ReplaceTextarea(); 
						//oFCKeditor.Create() ;
					</script>
                
                </td>
                
            </tr>
            <tr>
            	<td class="l-table-edit-td-right">图片</td>
            	<td  class="l-table-edit-td-left">
						<input type="file" name="file" style="" id="file" title="照片">
						<!--	<input type="button" onclick="upload()" value="上传"  id="scbt">-->
				</td>
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
