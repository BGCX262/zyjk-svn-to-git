/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-03-26               新規作成 ;
 ****************************************************/
package st.system.action.detail;





 import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.SerialNumber;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.system.action.form.CreateInfoJSFile;
import st.system.action.form.CreateInfoJSPFile;
import st.system.dao.PtformBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
@ParentPackage("struts-filter")
@Namespace("/st/system/action/detail") 
public class DetailAction extends BasicAction {


	private static final long serialVersionUID = 1L;
	 private static Logger logger = Logger.getLogger(DetailAction.class);
	 private PtformBean ptformBean; // 返回的信息;

	 private String strWhere=""; // 查询条件;

	 private String strSysno=""; // 主键编号;

	 private PageBean pageBean; // 分页类;

	 private MessageBean messageBean;// 操作状态

	/**
	*  
	* 查询信息 返回json信息
	* @return 
	*/  
	 @Action(value = "DetailAction_findObjson", results = { 
	  @Result(type = "json", name = MisConstant.FINDOBJSON, params = { "includeProperties","messageBean.*,ptformBean.*" }) }) 
   public String findObjson() {
	 try {
        
      messageBean = new MessageBean();    
	  ptformBean = new PtformBean();
	  
      
	  ptformBean = (PtformBean)findByKey(ptformBean, " where Formid ='" + strSysno + "'");
	  if (ptformBean != null) {
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
	 return MisConstant.FINDOBJSON;
		}

	

	/**
	*  
	*添加方法
	* @return 
	*/  
   @Action(value="DetailAction_insert") 
   public String insert() {
	 try {
	  ptformBean.setFormid(ptformBean.getFormname());
	  messageBean = insert(ptformBean);
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
	* 修改方法
	* @return 
	*/  
	 @Action(value = "DetailAction_update") 
   public String update() {
	 try {
	 
	  messageBean =  update(ptformBean, " where Formid ='" + ptformBean.getFormid() + "'");;
	 
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
	 @Action(value = "DetailAction_delete") 
   public String delete() {
	 try {
	 ptformBean = new PtformBean();
	  messageBean =  delete(ptformBean, " where Formid ='" + strSysno + "'");
	 
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
         * 生成LIST JSP页面
         * @return
         */
        @Action(value = "DetailAction_createJsp")
        public String createJsp() {
            try {
                messageBean = new MessageBean();
                CreateInfoJSPFile jsp = new CreateInfoJSPFile();
                ptformBean = new PtformBean();
                ptformBean = (PtformBean)findByKey(ptformBean, " where Formid ='" + strSysno + "'");
                jsp.createJSP(ptformBean);
                
                CreateInfoJSFile js = new CreateInfoJSFile();
                js.createJS(ptformBean);
                
                messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
            } catch (Exception e) {
        // TODO Auto-generated catch block
        // 设置错误返回的提示
        logger.error(MisConstant.MSG_OPERATE_FAIL, e);
        messageBean.setCheckFlag(MisConstant.MSG_FAIL);
        messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
    }
            return MisConstant.RETMESSAGE;
            
            
        }
        
	 public PtformBean getPtformBean() {
	 return ptformBean;
	 }
	 
	  public void setPtformBean(PtformBean ptformBean) {
	  this.ptformBean = ptformBean;
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
	 
}
