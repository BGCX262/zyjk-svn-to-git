/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-22               新規作成 ;
 ****************************************************/
package UI.action.zyjk;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.SerialNumber;
import st.platform.utils.Config;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import worksynch.util.WriteRecordUtil;
import UI.message.MisConstant;
import UI.util.BusinessDate;
import UI.dao.zyjk.PxjgbaxxBean;

@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk")
public class PxjgbaAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(PxjgbaAction.class);

	private PxjgbaxxBean pxjgbaxxBean; // 返回的信息;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "PxjgbaAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,pxjgbaxxBean.*" }) })
	public String findObjson() {
		try {
			pxjgbaxxBean = new PxjgbaxxBean();
			if (!(messageBean.getMethod().equals("add"))) {
				pxjgbaxxBean = (PxjgbaxxBean) findByKey(pxjgbaxxBean,
						" where Sysno ='" + strSysno + "'");
				if (pxjgbaxxBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
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
	 * 查询信息 返回jsp
	 * 
	 * @return
	 */
	@Action(value = "PxjgbaAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/pxjg/pxjginfo.jsp") })
	public String findByKey() {
		try {
			pxjgbaxxBean = new PxjgbaxxBean();
			if (!(messageBean.getMethod().equals("add"))) {
				pxjgbaxxBean = (PxjgbaxxBean) findByKey(pxjgbaxxBean,
						" where Sysno ='" + strSysno + "'");
				if (pxjgbaxxBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
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
	 * 查询信息 返回jsp
	 * 
	 * @return
	 */
	@Action(value = "PxjgbaAction_loginFindByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/pxjg/login/pxjginfo.jsp") })
	public String loginFindByKey() {
		try {
			pxjgbaxxBean = new PxjgbaxxBean();
			if (!(messageBean.getMethod().equals("add"))) {
				pxjgbaxxBean = (PxjgbaxxBean) findByKey(pxjgbaxxBean,
						" where Sysno ='" + strSysno + "'");
				if (pxjgbaxxBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
		} catch (Exception e) {
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
	 * 添加方法
	 * 
	 * @return
	 */
	@Action(value = "PxjgbaAction_insert")
	public String insert() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;
		try {
			String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			pxjgbaxxBean.setSysno(number);
			messageBean = insert(pxjgbaxxBean);
			count=messageBean.getCheckFlag();
		   //进行数据同步
		   if(Config.getProperty("isSynch").equals("1")){
			  if(count==1){
			 	WriteRecordUtil.write(pxjgbaxxBean, pxjgbaxxBean.getClass().getName(), "pxjgbaxx", "sysno", number, "add",cm);
			 }
		   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
			 if ( count > 0 ) {
	             dc.commit();
	        } else {
	             dc.rollback();
	        }
			cm.release();
		}
		return MisConstant.RETMESSAGE;
	}

	/**
	 * 
	 * 修改方法
	 * 
	 * @return
	 */
	@Action(value = "PxjgbaAction_update")
	public String update() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;
		try {

			messageBean = update(pxjgbaxxBean, " where Sysno ='"
					+ pxjgbaxxBean.getSysno() + "'");
			count=messageBean.getCheckFlag();
			//往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(pxjgbaxxBean, pxjgbaxxBean.getClass().getName(), "pxjgbaxx", "sysno", pxjgbaxxBean.getSysno(), "update",cm);
				}
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
			 if ( count > 0 ) {
	             dc.commit();
	        } else {
	             dc.rollback();
	        }
			cm.release();
		}
		return MisConstant.RETMESSAGE;
	}

	/**
	 * 
	 * 删除改方法
	 * 
	 * @return
	 */
	@Action(value = "PxjgbaAction_delete")
	public String delete() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;	
		try {
			pxjgbaxxBean = new PxjgbaxxBean();
			messageBean = delete(pxjgbaxxBean, " where Sysno in (" + strSysno + ")");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
		    if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(pxjgbaxxBean, pxjgbaxxBean.getClass().getName(), "pxjgbaxx", "sysno",strSysno, "delete",cm);
				}
		    }	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
			 if ( count > 0 ) {
	             dc.commit();
	        } else {
	             dc.rollback();
	        }
			cm.release();
		}
		return MisConstant.RETMESSAGE;
	}

	public PxjgbaxxBean getPxjgbaxxBean() {
		return pxjgbaxxBean;
	}

	public void setPxjgbaxxBean(PxjgbaxxBean pxjgbaxxBean) {
		this.pxjgbaxxBean = pxjgbaxxBean;
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
