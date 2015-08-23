/****************************************************
 * <p>处理内容：职业病危害事故报告与应急处置记录</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-30     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.enterfile;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.SerialNumber;
import st.platform.security.SystemAttributeNames;
import st.platform.utils.Config;
import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import worksynch.util.WriteRecordUtil;
import UI.dao.enterfile.QygzzdBean;
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.enterfile.QyzybsgczjlBean;
import UI.dao.zyjk.T_officerBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
import UI.util.DistcodeUtil;

@ParentPackage("struts-filter")
@Namespace("/UI/action/qyzybsgczjl")
public class QyzybsgczjlAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(QyzybsgczjlAction.class);

    private QyzybsgczjlBean qyzybsgczjlbean;

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
	@Action(value = "ZybsgczjilAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,qyzybsgczjlbean.*" }) })
	public String findObjson() {
		try {
			QyzybsgczjlBean qyzybsgczjlbean = new QyzybsgczjlBean();
			if (!(messageBean.getMethod().equals("add"))) {
				qyzybsgczjlbean = (QyzybsgczjlBean) findByKey(qyzybsgczjlbean,
						" where  sysno='" + strSysno + "'");
				if (qyzybsgczjlbean != null) {
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
	@Action(value = "ZybsgczjilAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/qyzybsgczjl/qyzybsgczjldetail.jsp") })
	public String findByKey() {
		try {
			qyzybsgczjlbean = new QyzybsgczjlBean();
			qyzybsgczjlbean.setEnterno(enterno);
			 T_officerBean officer=(T_officerBean) ServletActionContext.getContext().getSession().get(SystemAttributeNames.CORP_INFO_NAME);
			 if(null!=officer){
				 //Z_corBean cor=new Z_corBean();
				 QyjbqkBean qyjbqkbean=new QyjbqkBean();
				 qyjbqkbean=qyjbqkbean.findFirst(" where corpkey='"+officer.getLogin_id()+"'");
				 if(qyjbqkbean!=null){
					 //cor=new Z_corBean();
					 qyzybsgczjlbean.setEntername(qyjbqkbean.getDwmc());
					 qyzybsgczjlbean.setFrdb(qyjbqkbean.getFddbr());
				 }
			 }
			if (!(messageBean.getMethod().equals("add"))) {
				qyzybsgczjlbean = (QyzybsgczjlBean) findByKey(qyzybsgczjlbean,
						" where  sysno='" + strSysno + "'");
				if (qyzybsgczjlbean != null) {
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
	@Action(value = "ZybsgczjilAction_insert")
	public String insert() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			qyzybsgczjlbean.setSysno(number);
			messageBean = insert(qyzybsgczjlbean);
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qyzybsgczjlbean, qyzybsgczjlbean.getClass().getName(), "qyzybsgczjl", "sysno", number, "add",cm);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
			//关闭线程
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
	@Action(value = "ZybsgczjilAction_update")
	public String update() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {

			messageBean = update(qyzybsgczjlbean, " where  sysno='"
					+ qyzybsgczjlbean.getSysno() + "'");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qyzybsgczjlbean, qyzybsgczjlbean.getClass().getName(), "qyzybsgczjl", "sysno", qyzybsgczjlbean.getSysno(), "update",cm);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
			//关闭线程
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
	@Action(value = "ZybsgczjilAction_delete")
	public String delete() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			qyzybsgczjlbean = new QyzybsgczjlBean();
			messageBean = delete(qyzybsgczjlbean, " where  sysno in (" + strSysno + ")");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qyzybsgczjlbean, qyzybsgczjlbean.getClass().getName(), "qyzybsgczjl", "sysno", strSysno, "delete",cm);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
            //关闭线程
			 if ( count > 0 ) {
                dc.commit();
           } else {
                dc.rollback();
           }
			cm.release();
		}
		return MisConstant.RETMESSAGE;
	}

	

	

	public QyzybsgczjlBean getQyzybsgczjlbean() {
		return qyzybsgczjlbean;
	}

	public void setQyzybsgczjlbean(QyzybsgczjlBean qyzybsgczjlbean) {
		this.qyzybsgczjlbean = qyzybsgczjlbean;
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
