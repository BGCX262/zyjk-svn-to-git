/****************************************************
 * <p>处理内容：企业人员信息</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-31     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.zyjk.pxxx;

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
import UI.dao.enterfile.QygzzdBean;
import UI.dao.enterfile.QyryxxBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk")
public class QyryxxAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(QyryxxAction.class);

    private QyryxxBean qyryxxbean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String enterno=""; //企业主键编号

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "QyryxxAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,qyryxxbean.*" }) })
	public String findObjson() {
		try {
			QyryxxBean qyryxxbean = new QyryxxBean();
			if (!"add".equals(messageBean.getMethod())) {
				qyryxxbean = (QyryxxBean) findByKey(qyryxxbean,
						" where  sysno='" + strSysno + "'");
				if (qyryxxbean != null) {
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
	@Action(value = "QyryxxAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/pxjg/pxxx/qyryxx/qyryxxdetail.jsp") })
	public String findByKey() {
		try {
			qyryxxbean = new QyryxxBean();
			//qyryxxbean.setEnterno(enterno);
			if (!(messageBean.getMethod().equals("add"))) {
				qyryxxbean = (QyryxxBean) findByKey(qyryxxbean,
						" where  sysno='" + strSysno + "'");
				if (qyryxxbean != null) {
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
	@Action(value = "QyryxxAction_insert")
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
			qyryxxbean.setSysno(number);
			messageBean = insert(qyryxxbean);
			count=messageBean.getCheckFlag();
			   //进行数据同步
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
				 	WriteRecordUtil.write(qyryxxbean, qyryxxbean.getClass().getName(), "qyryxx", "sysno", number, "add",cm);
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
	@Action(value = "QyryxxAction_update")
	public String update() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;
		try {

			messageBean = update(qyryxxbean, " where  sysno='"
					+ qyryxxbean.getSysno() + "'");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
						WriteRecordUtil.write(qyryxxbean, qyryxxbean.getClass().getName(), "qyryxx", "sysno", qyryxxbean.getSysno(), "update",cm);
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
	@Action(value = "QyryxxAction_delete")
	public String delete() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;
		try {
			qyryxxbean = new QyryxxBean();
			messageBean = delete(qyryxxbean, " where  sysno in (" + strSysno + ")");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
					if(count==1){
						WriteRecordUtil.write(qyryxxbean, qyryxxbean.getClass().getName(), "qyryxx", "sysno",strSysno, "delete",cm);
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

	

    

	public QyryxxBean getQyryxxbean() {
		return qyryxxbean;
	}

	public void setQyryxxbean(QyryxxBean qyryxxbean) {
		this.qyryxxbean = qyryxxbean;
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

	public String getEnterno() {
		return enterno;
	}

	public void setEnterno(String enterno) {
		this.enterno = enterno;
	}
    
	
}
