/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-03-26               新規作成 ;
 ****************************************************/
package st.system.action.detail;





 import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.portal.html.DBSelect;
import st.system.dao.PtablecolumnBean;
import st.system.dao.PtformlabelBean;
import UI.message.MisConstant;
@ParentPackage("struts-filter")
@Namespace("/st/system/action/detail") 
public class DetailSetAction extends BasicAction {


	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(DetailSetAction.class);
	 private PtformlabelBean ptformlabelBean; // 返回的信息;

	 private String strWhere=""; // 查询条件;

	 private String strSysno=""; // 主键编号;

	 private PageBean pageBean; // 分页类;

	 private MessageBean  messageBean = new MessageBean();;// 操作状态
     
     private String  strHidden="";//是否隐藏字段
     
     private String  strContent="";//返回内容
     
     private String strTable ="";
     
     private String strFormName ="";
     
     private String strColumn ="";
     
     private List<PtformlabelBean> ptlist = new ArrayList<PtformlabelBean>() ;
     
     

	/**
	*  
	* 查询信息 返回jsp信息
	* @return 
	*/  
     @Action(value = "DetailSetAction_findByKey", results = {
             @Result(name = MisConstant.FINDBYKEY, location = "/UI/system/resoure/detail/detailset.jsp") })
   public String findByKey() {
	 try {
         ptformlabelBean = new PtformlabelBean();
       
          ptformlabelBean = (PtformlabelBean)findByKey(ptformlabelBean, " where formid ='" + strSysno + "'");
	  if (ptformlabelBean != null) {
	  messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
	  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
	   }else{
	  messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	  messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	   }
	 } catch (Exception e) {;
	 // TODO Auto-generated catch block
	 // 设置错误返回的提示
	 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
	 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	 }
	 return MisConstant.FINDBYKEY;
		}

     /**
    *  
    * 查询信息 返回jsp信息
    * @return 
    */  
      @Action(value = "DetailSetAction_findInfo", results = {
              @Result(name = MisConstant.FINDBYKEY, location = "/UI/system/resource/detail/detailinfo.jsp") })
    public String findInfo() {
     try {
      
      messageBean = new MessageBean();
      ptformlabelBean = new PtformlabelBean();
      strFormName = strSysno;
      logger.debug(strSysno);
      logger.debug(strFormName);
      strContent = getHTML(strSysno);
      messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
      messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
      
       
     } catch (Exception e) {;
     // TODO Auto-generated catch block
     // 设置错误返回的提示
     logger.error(MisConstant.MSG_OPERATE_FAIL, e);
     messageBean.setCheckFlag(MisConstant.MSG_FAIL);
     messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
     }
     return MisConstant.FINDBYKEY;
        }

	
	/**
	*  
	* 修改方法
	* @return 
	*/  
	 @Action(value = "DetailSetAction_update") 
   public String update() {
	 try {
	 
	  messageBean =  update(ptformlabelBean, " where Formid ='" + ptformlabelBean.getSysid() + "'");;
	 
	 } catch (Exception e) {;
	 // TODO Auto-generated catch block
	 // 设置错误返回的提示
	 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
	 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	 }
	 return MisConstant.RETMESSAGE;
		}

	/**
	*  
	* 删除改方法
	* @return 
	*/  
	 @Action(value = "DetailSetAction_delete") 
   public String delete() {
	 try {
         ptformlabelBean = new PtformlabelBean();
	  messageBean =  delete(ptformlabelBean, " where sysid in (" +  strSysno + ")");
	 
	 } catch (Exception e) {;
	 // TODO Auto-generated catch block
	 // 设置错误返回的提示
	 logger.error(MisConstant.MSG_OPERATE_FAIL, e);
	 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	 messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	 }
	 return MisConstant.RETMESSAGE;
		}
     
     
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
     /**
        *  
        * 添加方法
        * @return 
        */    
     @Action(value = "DetailSetAction_insert", results = { 
      @Result(type = "json", name = SUCCESS, params = { "includeProperties","messageBean.*,strContent" }) }) 
     public String insert() {
         try {
             
             PtablecolumnBean ptcolumn = new PtablecolumnBean();
             List<PtablecolumnBean> list =  ptcolumn.findByWhere(" where tablename ='" + strTable + "'");
//           取出涉及的表名称
             Map<String,PtablecolumnBean>map = new HashMap<String,PtablecolumnBean>();
             for(int i=0;i<list.size();i++)
             {
                 map.put(list.get(i).getColumnname(),list.get(i));
             }
                 String strArr[] = strColumn.split(";");
                 PtformlabelBean formlabel  = null;
             //根据表名称查询表信息    
                 
                 for(int i=0;i<strArr.length;i++)
                 {
                      formlabel = new PtformlabelBean();
                      //主键
                      formlabel.setSysid(""+System.currentTimeMillis());
                      //表单id
                      formlabel.setFormid(strFormName);
                      //表单名称
                      formlabel.setFormname(strFormName);
                      //表名称
                      formlabel.setTablename(strTable);
                      //标签id
                      formlabel.setLabelid(strArr[i]);
                      //标签名称
                      
                      String classBean = strTable.substring(0, 1).toUpperCase() + strTable.substring(1, strTable.length()).toLowerCase() + "Bean";
                      String labelName = classBean+"."+strArr[i];
                      formlabel.setLabelname(labelName);
                      //标签说明
                      System.out.println(strArr[i]);
                      formlabel.setLabeldesc(map.get(strArr[i]).getColumndesc());
                      //字段长度
                      formlabel.setColumnlength(map.get(strArr[i]).getColumnlength());
                      //是否隐藏字段
                      formlabel.setIshidden(strHidden);
                      //label类型
                      formlabel.setLabeltype("text");
                     
                      insert(formlabel);
                 }
              messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
              messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
              strContent = getHTML( strFormName );
         
         } catch (Exception e) {;
         // TODO Auto-generated catch block
         // 设置错误返回的提示
         e.printStackTrace();
         logger.error(e.getMessage());
         logger.error(MisConstant.MSG_OPERATE_FAIL, e);
         messageBean.setCheckFlag(MisConstant.MSG_FAIL);
         messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
         }
         return SUCCESS;
            }
	
    /**
    *  从详细页面删除字段
    * @return 
    */  
     @Action(value = "DetailSetAction_delcolumn", results = { 
             @Result(type = "json", name = SUCCESS, params = { "includeProperties","messageBean.*,strContent" }) }) 
    public String deletetext() {
     try {
      ptformlabelBean = new PtformlabelBean();
      messageBean =  delete(ptformlabelBean, " where sysid in ('" +  strColumn + "')");
      strContent = getHTML( strFormName );
      if(strContent.equals("")){
          strContent ="";
      }
     } catch (Exception e) {;
     // TODO Auto-generated catch block
     // 设置错误返回的提示
     logger.error(MisConstant.MSG_OPERATE_FAIL, e);
     messageBean.setCheckFlag(MisConstant.MSG_FAIL);
     messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
     }
     return SUCCESS;
        }
      
     /**
      * 提交字段内容
      * @return 
      */  
       @Action(value = "DetailSetAction_submint", results = { 
               @Result(type = "json", name = SUCCESS, params = { "includeProperties","messageBean.*,strContent" }) }) 
     public String submint(){
           try {
              
               System.out.println(ptlist.size()+"sadfasdf");
              for(int i=0;i<ptlist.size();i++)
              {
                  
                  ptformlabelBean = ptlist.get(i);
                  System.out.println(ptformlabelBean.getSysid());
                  update(ptformlabelBean," where sysid = '"+ptformlabelBean.getSysid()+"' ");
              }
               messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
               messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
               strContent = getHTML( strFormName );
          
          } catch (Exception e) {;
          // TODO Auto-generated catch block
          // 设置错误返回的提示
          logger.error(MisConstant.MSG_OPERATE_FAIL, e);
          messageBean.setCheckFlag(MisConstant.MSG_FAIL);
          messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
          }
           
         
           return SUCCESS;
     }
  
     
     
     /**
      * 刷新页面table
      * 返回连个内容 1个是hidden区域，1个是text区域
      * @return
      */
     public String getHTML(String strSysno){
         String hidtable = "<table >";
         System.out.println("zzzzzzzz12313123");
         String texttable = "<table >";
         //根据formid生成页面代码
         PtformlabelBean ptcolumn = new PtformlabelBean();
         try {
            List<PtformlabelBean> listhid =  ptcolumn.findByWhere(" where formid ='" + strSysno + "' and ishidden ='1' order by ladelindex");
           
            PtformlabelBean columnhide = null;
            for(int i=0;i<listhid.size();i++)
            {
                columnhide = listhid.get(i);
                hidtable = hidtable +"<tr>" +
                "<td><input type=\"hidden\"  name=\"ptlist["+i+"].sysid\"  value=\""+columnhide.getSysid()+"\" />" +
                "表名：<input type=\"text\"  name=\"ptlist["+i+"].tablename\" value=\""+columnhide.getTablename()+"\"/></td>" +
                "<td>字段：<input type=\"text\"  name=\"ptlist["+i+"].labelid\" value=\""+columnhide.getLabelid()+"\"/></td>" +
                "<td><input type=\"hidden\"  name=\"ptlist["+i+"].ishidden\" value=\""+columnhide.getIshidden()+"\"/>" +
                "<input type=\"button\" id=\""+columnhide.getSysid()+"\"  onclick=\"removerow(this)\" value=\"删除\"/></td>" +
                "</tr>";
            }
            hidtable = hidtable+"</table>";
            List<PtformlabelBean> listtext =  ptcolumn.findByWhere(" where formid ='" + strSysno + "' and ishidden ='0' order by ladelindex"); 
            //System.out.println(hidtable);
            
            for(int i=0;i<listtext.size();i++)
            {
               
                
                    
                
                columnhide = listtext.get(i);
                
                DBSelect dbsel = new DBSelect("labeltype"+i, "fieldtype",columnhide.getLabeltype());
                dbsel.addAttr("style", "width: 100%");
                dbsel.addAttr("notnull", "true");
                dbsel.addAttr("name", "ptlist["+i+"].labeltype" );
                dbsel.setDisplayAll(false);
                String select =dbsel.toString();
                texttable = texttable +
                "<tr><td style=\"color: red\"> 第"+(i+1)+"个字段</td><td><input colspan=\"4\"  type=\"button\"  id=\""+columnhide.getSysid()+"\"   onclick=\"removerow(this)\" value=\"删除\"/></td></tr>"+
                "<tr><td s>" +
                "<input type=\"hidden\"  name=\"ptlist["+i+"].sysid\"  value=\""+columnhide.getSysid()+"\" />" +
                "表名：<input type=\"text\"   name=\"ptlist["+i+"].tablename\" value=\""+columnhide.getTablename()+"\"/></td>" +
                "<td >字段：<input type=\"text\"   name=\"ptlist["+i+"].labelid\" value=\""+columnhide.getLabelid()+"\"/></td>" +
                "<td >标签名称：<input type=\"text\"  name=\"ptlist["+i+"].labeldesc\" value=\""+columnhide.getLabeldesc()+"\"/></td>" +
                "<td >类型："+select+"</td>" +
                "<td ></td>" +
                "</tr><tr>"+
                "<td >枚举：<input type=\"text\"  name=\"ptlist["+i+"].enumnmae\" value=\""+columnhide.getEnumnmae()+"\"/></td>" +
                "<td >长度：<input type=\"text\"  name=\"ptlist["+i+"].columnlength\" value=\""+columnhide.getColumnlength()+"\"/></td>" +
                "<td >独占一行：<input type=\"text\"  name=\"ptlist["+i+"].isonly\" value=\""+columnhide.getIsonly()+"\"/>" +
                "<td >排序：<input type=\"text\"  name=\"ptlist["+i+"].ladelindex\" value=\""+columnhide.getLadelindex()+"\"/></td>" +
                "<td ><input type=\"hidden\"  name=\"ptlist["+i+"].ishidden\" value=\""+columnhide.getIshidden()+"\"/>" +
                "</td></tr>";
          
                
            }
            texttable = texttable+"</table>";
            System.out.println(texttable);
            
        }  catch (Exception e) {
            logger.error(MisConstant.MSG_OPERATE_FAIL, e);
        }
        String retst = hidtable+texttable;
        System.out.println(retst);
        if(retst.equals("")){
            retst ="";
        }
        return  retst; 
     }
     
     
	 
	  public PtformlabelBean getPtformlabelBean() {
        return ptformlabelBean;
    }




    public void setPtformlabelBean(PtformlabelBean ptformlabelBean) {
        this.ptformlabelBean = ptformlabelBean;
    }




    public MessageBean getMessageBean() {
	  return messageBean;
	 }
	 
	  public void setMessageBean(MessageBean messageBean) {
	   this.messageBean = messageBean;
	 }
	 
	  public PageBean getPageBean() {
	  return pageBean;
	 }
	 
	  public void setPageBean(PageBean pageBean) {
	   this.pageBean = pageBean;
	 }
	 
	  public String getStrSysno() {
	  return strSysno;
	 }
	 
	  public void setStrSysno(String strSysno) {
	   this.strSysno = strSysno;
	 }
	 
	  public String getStrWhere() {
	  return strWhere;
	 }
	 
	  public void setStrWhere(String strWhere) {
	   this.strWhere = strWhere;
	 }




    public String getStrHidden() {
        return strHidden;
    }




    public void setStrHidden(String strHidden) {
        this.strHidden = strHidden;
    }




    public String getStrColumn() {
        return strColumn;
    }




    public void setStrColumn(String strColumn) {
        this.strColumn = strColumn;
    }




    public String getStrContent() {
        return strContent;
    }




    public void setStrContent(String strContent) {
        this.strContent = strContent;
    }




    public String getStrFormName() {
        return strFormName;
    }




    public void setStrFormName(String strFormName) {
        this.strFormName = strFormName;
    }




    public String getStrTable() {
        return strTable;
    }




    public void setStrTable(String strTable) {
        this.strTable = strTable;
    }

    public List<PtformlabelBean> getPtlist() {
        return ptlist;
    }

    public void setPtlist(List<PtformlabelBean> ptlist) {
        this.ptlist = ptlist;
    }
	 
      
      
}
