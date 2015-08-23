/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-24               新規作成 ;
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
import UI.dao.zyjk.JcjgbaxxBean;
import UI.dao.zyjk.JcjgpjryglBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk")
public class JcjgryglAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(JcjgryglAction.class);

	private JcjgpjryglBean jcjgpjryglBean; // 返回的信息;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态

	private String jgbh;

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "JcjgryglAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,jcjgpjryglBean.*" }) })
	public String findObjson() {
		try {
			jcjgpjryglBean = new JcjgpjryglBean();
			if (!(messageBean.getMethod().equals("add"))) {
				jcjgpjryglBean = (JcjgpjryglBean) findByKey(jcjgpjryglBean,
						" where Sysno ='" + strSysno + "'");
				if (jcjgpjryglBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean
							.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
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
	@Action(value = "JcjgryglAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/jcjg/jcjgry/jcjgryinfo.jsp") })
	public String findByKey() {
		try {
			jcjgpjryglBean = new JcjgpjryglBean();
			jcjgpjryglBean.setJgbh(jgbh);
			if (!(messageBean.getMethod().equals("add"))) {
				jcjgpjryglBean = (JcjgpjryglBean) findByKey(jcjgpjryglBean,
						" where Sysno ='" + strSysno + "'");
				if (jcjgpjryglBean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean
							.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
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
	@Action(value = "JcjgryglAction_insert")
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
			jcjgpjryglBean.setSysno(number);
			JcjgbaxxBean ba = new JcjgbaxxBean();
			ba = ba.findFirst(" where sysno='" + jcjgpjryglBean.getJgbh() + "'");
			jcjgpjryglBean.setJgmc(ba.getDwmc());
			messageBean = insert(jcjgpjryglBean);
			count=messageBean.getCheckFlag();
		   //进行数据同步
		   if(Config.getProperty("isSynch").equals("1")){
			  if(count==1){
			 	WriteRecordUtil.write(jcjgpjryglBean, jcjgpjryglBean.getClass().getName(), "jcjgpjrygl", "sysno", number, "add",cm);
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
	@Action(value = "JcjgryglAction_update")
	public String update() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;	
		try {

			messageBean = update(jcjgpjryglBean, " where Sysno ='"
					+ jcjgpjryglBean.getSysno() + "'");
			count=messageBean.getCheckFlag();
		  //往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(jcjgpjryglBean, jcjgpjryglBean.getClass().getName(), "jcjgpjrygl", "sysno", jcjgpjryglBean.getSysno(), "update",cm);
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
	@Action(value = "JcjgryglAction_delete")
	public String delete() {
		 //	打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;	
		try {
			jcjgpjryglBean = new JcjgpjryglBean();
			messageBean = delete(jcjgpjryglBean, " where Sysno in (" + strSysno
					+ ")");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
		    if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(jcjgpjryglBean, jcjgpjryglBean.getClass().getName(), "jcjgpjrygl", "sysno",strSysno, "delete",cm);
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

	public JcjgpjryglBean getJcjgpjryglBean() {
		return jcjgpjryglBean;
	}

	public void setJcjgpjryglBean(JcjgpjryglBean jcjgpjryglBean) {
		this.jcjgpjryglBean = jcjgpjryglBean;
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

	public String getJgbh() {
		return jgbh;
	}

	public void setJgbh(String jgbh) {
		this.jgbh = jgbh;
	}

}
