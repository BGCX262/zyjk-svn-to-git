/*********************************************************************
 *<p>处理内容：Enumdetail Action</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.03.20---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.enume;

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
import st.system.dao.PtenudetailBean;
import st.system.dao.PtenumainBean;
import UI.message.MisConstant;
@ParentPackage("struts-filter")
@Namespace("/st/system/action/enudetail") 
public class EnuDetailAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(EnuDetailAction.class);

	private String strWhere=""; //查询条件

	private String strSysno=""; //主键编号

	private MessageBean messageBean ;//操作状态s

	private List<Map<String, Object>> list;
	
	private PtenudetailBean ptEnuDetailBean;
	
	private PtenumainBean ptEnuMainBean;
	
	private String enutype="";
	
	private String enuname="";
    
	/**
	 *添加方法
	 * @return String 返回操作结果
	 */
	@Action(value = "enudetail_insert")
	public String insert() {
		
		try {

			messageBean = insert(ptEnuDetailBean);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}


	/**
	 * 查询信息
	 * 
	 * @return String 返回操作结果
	 */
	 @Action(value = "enudetail_findByKey", results = {
			    @Result(name = MisConstant.FINDBYKEY, location = "/UI/system/enum/enudetailinfo.jsp") }) 
	public String findByKey() {
		try {
			logger.debug(messageBean.getMethod());
			//ptMenuBean = new PtmenuBean();
			ptEnuDetailBean = new PtenudetailBean();
			if (!(messageBean.getMethod().equals("add"))) {
				
				ptEnuDetailBean = (PtenudetailBean) findByKey(ptEnuDetailBean," where enutype ='" + ptEnuMainBean.getEnutype() + "' and enuitemvalue='"+ strSysno +"'");
				
				if (ptEnuDetailBean == null) {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}

		return MisConstant.FINDBYKEY;
	}

	/**
	 * 修改
	 * 
	 * @return String 返回操作结果
	 */
	 @Action(value = "enudetail_update") 
	public String update() {
		logger.debug("修改");
		
		try {
			messageBean = update(ptEnuDetailBean, " where enutype ='"+ ptEnuMainBean.getEnutype() + "' and ENUITEMVALUE='"+ ptEnuDetailBean.getEnuitemvalue() +"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}

	/**
	 * 删除方法
	 * 
	 * @return String 返回操作结果
	 */
	 @Action(value = "enudetail_delete") 
	public String delete() {
		try {
			ptEnuDetailBean = new PtenudetailBean();
			messageBean = delete(ptEnuDetailBean, " where enutype='"+ ptEnuMainBean.getEnutype() +"' and ENUITEMVALUE in (" + strSysno	+ ")");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	

	public MessageBean getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
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

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		EnuDetailAction.logger = logger;
	}
    

	public String getEnuname() {
		return enuname;
	}

	public void setEnuname(String enuname) {
		this.enuname = enuname;
	}

	public String getEnutype() {
		return enutype;
	}

	public void setEnutype(String enutype) {
		this.enutype = enutype;
	}

	public PtenudetailBean getPtEnuDetailBean() {
		return ptEnuDetailBean;
	}

	public void setPtEnuDetailBean(PtenudetailBean ptEnuDetailBean) {
		this.ptEnuDetailBean = ptEnuDetailBean;
	}

	public PtenumainBean getPtEnuMainBean() {
		return ptEnuMainBean;
	}

	public void setPtEnuMainBean(PtenumainBean ptEnuMainBean) {
		this.ptEnuMainBean = ptEnuMainBean;
	}

	
	
	
}
