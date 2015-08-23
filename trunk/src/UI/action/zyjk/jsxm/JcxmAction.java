/****************************************************
 * <p>处理内容：评价报告基本情况</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14    新規作成 ;
 ****************************************************/
package UI.action.zyjk.jsxm;

import java.io.File;

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
import UI.action.upload.FileUploadService;
import UI.dao.enterfile.JcjgpjbgjbqkBean;
import UI.dao.enterfile.JcxmxxBean;
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.zyjk.JcjgbaxxBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk")
public class JcxmAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(JcxmAction.class);

    private JcxmxxBean jcxmxxBean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String enterno=""; //企业主键编号
	
	private String jgbh;
	

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "JcxmAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,jcxmxxBean.*" }) })
	public String findObjson() {
		try {
			JcxmxxBean jcxmxxBean = new JcxmxxBean();
			if (!(messageBean.getMethod().equals("add"))) {
				jcxmxxBean = (JcxmxxBean) findByKey(jcxmxxBean,
						" where  sysno='" + strSysno + "'");
				if (jcxmxxBean != null) {
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
	@Action(value = "JcxmAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/jsxmsts/jsxminfo.jsp") })
	public String findByKey() {
		try {
			jcxmxxBean = new JcxmxxBean();
			QyjbqkBean qyjbqk=new QyjbqkBean();
			qyjbqk=(QyjbqkBean)qyjbqk.findFirst(" where enterno='"+enterno+"'");
			if(null==qyjbqk){
				qyjbqk=new QyjbqkBean();
			}
			jcxmxxBean.setJsdwbh(qyjbqk.getEnterno());
			jcxmxxBean.setJsdwmc(qyjbqk.getDwmc());
			if (!(messageBean.getMethod().equals("add"))) {
				jcxmxxBean = (JcxmxxBean) findByKey(jcxmxxBean,
						" where  sysno='" + strSysno + "'");
				if (jcxmxxBean != null) {
					//messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					//messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
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
	@Action(value = "JcxmAction_insert")
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
			jcxmxxBean.setSysno(number);
			messageBean = insert(jcxmxxBean);
			count=messageBean.getCheckFlag();
			   //进行数据同步
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
				 	WriteRecordUtil.write(jcxmxxBean, jcxmxxBean.getClass().getName(), "jcxmxx", "sysno", number, "add",cm);
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
	@Action(value = "JcxmAction_update")
	public String update() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;
		try {
			
			messageBean = update(jcxmxxBean, " where  sysno='"
					+ jcxmxxBean.getSysno() + "'");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
						WriteRecordUtil.write(jcxmxxBean, jcxmxxBean.getClass().getName(), "jcxmxx", "sysno", jcxmxxBean.getSysno(), "update",cm);
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
	@Action(value = "JcxmAction_delete")
	public String delete() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;
		try {
			jcxmxxBean = new JcxmxxBean();
			messageBean = delete(jcxmxxBean, " where  sysno in (" + strSysno + ")");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
					if(count==1){
						WriteRecordUtil.write(jcxmxxBean, jcxmxxBean.getClass().getName(), "jcxmxx", "sysno",strSysno, "delete",cm);
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

	public String getJgbh() {
		return jgbh;
	}

	public void setJgbh(String jgbh) {
		this.jgbh = jgbh;
	}

	public JcxmxxBean getJcxmxxBean() {
		return jcxmxxBean;
	}

	public void setJcxmxxBean(JcxmxxBean jcxmxxBean) {
		this.jcxmxxBean = jcxmxxBean;
	}
	
	

}
