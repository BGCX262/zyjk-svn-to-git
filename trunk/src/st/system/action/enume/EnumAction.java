/*********************************************************************
 *<p>处理内容：Enum Action</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.03.19---- 孙雁斌 --------- 新规作成<br>
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
import st.system.dao.PtenumainBean;
import UI.message.MisConstant;
@ParentPackage("struts-filter")
@Namespace("/st/system/action/enum") 
public class EnumAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(EnumAction.class);

	private String strWhere=""; //查询条件

	private String strSysno=""; //主键编号

	private MessageBean messageBean ;//操作状态

	private List<Map<String, Object>> list;
	
	private PtenumainBean ptEnuMainBean;
	
	private String enutype="";
	
	private String enuname="";
    
	/**
	 *添加方法
	 * @return String 返回操作结果
	 */
	@Action(value = "enum_insert")
	public String insert() {
		
		try {
			ptEnuMainBean.setParenutype("system");
			messageBean = insert(ptEnuMainBean);
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
	 @Action(value = "enum_findByKey", results = {
			    @Result(name = MisConstant.FINDBYKEY, location = "/UI/system/enum/enuminfo.jsp") }) 
	public String findByKey() {
		try {
			logger.debug(messageBean.getMethod());
			//ptMenuBean = new PtmenuBean();
			ptEnuMainBean = new PtenumainBean();
			if (!(messageBean.getMethod().equals("add"))) {
				
				ptEnuMainBean = (PtenumainBean) findByKey(ptEnuMainBean," where enutype ='" + enutype + "'");
				
				if (ptEnuMainBean == null) {
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
	 @Action(value = "enum_update") 
	public String update() {
		logger.debug("修改");
		try {
			messageBean = update(ptEnuMainBean, " where enutype ='"	+ ptEnuMainBean.getEnutype() + "'");
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
	 @Action(value = "enum_delete") 
	public String delete() {
		try {
			ptEnuMainBean = new PtenumainBean();
			messageBean = delete(ptEnuMainBean, " where enutype in (" + strSysno
					+ ")");
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
		EnumAction.logger = logger;
	}

	public PtenumainBean getPtEnuMainBean() {
		return ptEnuMainBean;
	}

	public void setPtEnuMainBean(PtenumainBean ptEnuMainBean) {
		this.ptEnuMainBean = ptEnuMainBean;
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

	
	
	
}
