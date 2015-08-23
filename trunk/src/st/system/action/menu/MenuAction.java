/*********************************************************************
 *<p>处理内容：Menu Action</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.02.28---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.menu;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.DBUtil;
import st.platform.utils.Basic;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.system.dao.PtmenuBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
@ParentPackage("struts-filter")
@Namespace("/st/system/action/menu") 
public class MenuAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(MenuAction.class);

	private String strWhere=""; //查询条件

	private String strSysno=""; //主键编号

	private MessageBean messageBean ;//操作状态

	private PtmenuBean ptMenuBean; //返回的信息

	private List<Map<String, Object>> list;
	
	

	/**
	 *添加方法
	 * @return String 返回操作结果
	 */
	@Action(value = "menu_insert")
	public String insert() {
		try {
			//String number = BusinessDate.getNoFormatToday() + "-" + st.platform.db.SerialNumber.getNextSerialNo("67");
			PtmenuBean parentmenu=new PtmenuBean();
		    parentmenu=(PtmenuBean) parentmenu.findFirstByWhere(" where menuid='"+ptMenuBean.getParentmenuid()+"'");
		    System.out.println("ptMenuBean.getParentmenuid()==="+ptMenuBean.getParentmenuid());
		    int menulevel=0;
		    if (null!=parentmenu) {
	            menulevel=Basic.getInt(parentmenu.getMenulevel())+1;
	        }
			String s1 = DBUtil.getCellValue("ptmenu", "max(menuid)", "len(menuid)=(select max(len(menuid)) from  ptmenu)");
	        s1 = (new StringBuffer(String.valueOf(Integer.parseInt(s1) + 1))).toString();
	        if(Integer.parseInt(s1) < 10)
	            s1 = "0" + s1;
			
	        ptMenuBean.setMenulevel(menulevel+"");
	        ptMenuBean.setMenuid(s1);
			//ptMenuBean.setMenuid(number);
			ptMenuBean.setParentmenuid(ptMenuBean.getParentmenuid());
			ptMenuBean.setIsleaf("1");
			messageBean = insert(ptMenuBean);
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
	 @Action(value = "menu_findByKey", results = {
			    @Result(name = MisConstant.FINDBYKEY, location = "/UI/system/menu/menuinfo.jsp") }) 
	public String findByKey() {
		try {
			logger.debug(messageBean.getMethod());
			//ptMenuBean = new PtmenuBean();
			
			if (!(messageBean.getMethod().equals("add"))) {
				ptMenuBean = new PtmenuBean();
				ptMenuBean = (PtmenuBean) findByKey(ptMenuBean," where menuid ='" + strSysno + "'");
				
				if (ptMenuBean == null) {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}else{
				
				ptMenuBean.setParentmenuid(ptMenuBean.getParentmenuid());
				
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
	 @Action(value = "menu_update") 
	public String update() {
		logger.debug("修改");
		try {
			messageBean = update(ptMenuBean, " where menuid ='"	+ ptMenuBean.getMenuid() + "'");
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
	 @Action(value = "menu_delete") 
	public String delete() {
		try {
			ptMenuBean = new PtmenuBean();
			messageBean = delete(ptMenuBean, " where menuid in (" + strSysno
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

	public PtmenuBean getPtMenuBean() {
		return ptMenuBean;
	}

	public void setPtMenuBean(PtmenuBean ptMenuBean) {
		this.ptMenuBean = ptMenuBean;
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
		MenuAction.logger = logger;
	}

}
