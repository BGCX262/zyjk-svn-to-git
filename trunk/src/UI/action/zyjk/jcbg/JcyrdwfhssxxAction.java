/****************************************************
 * <p>处理内容：用人单位配备的防护设施及个人防护用品</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.zyjk.jcbg;

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
import UI.dao.enterfile.JcjgpjbgjbqkBean;
import UI.dao.enterfile.JcyrdwfhssxxBean;
import UI.dao.enterfile.QyldzzysBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk")
public class JcyrdwfhssxxAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(JcyrdwfhssxxAction.class);

    private JcyrdwfhssxxBean jcyrdwfhssxxbean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String dwbh="";
	
	private String bgbh;
	
	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "JcyrdwfhssxxAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,jcyrdwfhssxxbean.*" }) })
	public String findObjson() {
		try {
			JcyrdwfhssxxBean jcyrdwfhssxxbean = new JcyrdwfhssxxBean();
			if (!(messageBean.getMethod().equals("add"))) {
				jcyrdwfhssxxbean = (JcyrdwfhssxxBean) findByKey(jcyrdwfhssxxbean,
						" where  sysno='" + strSysno + "'");
				if (jcyrdwfhssxxbean != null) {
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
	@Action(value = "JcyrdwfhssxxAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/jcjg/jcjgbg/jcyrdwfhssxx/jcyrdwfhssxxdetail.jsp") })
	public String findByKey() {
		try {
			jcyrdwfhssxxbean = new JcyrdwfhssxxBean();
			//jcyrdwfhssxxbean.setDwbh(dwbh);
			JcjgpjbgjbqkBean jcbg=new JcjgpjbgjbqkBean();
			jcbg=(JcjgpjbgjbqkBean)jcbg.findFirst(" where sysno='"+bgbh+"'");
			if(null==jcbg){
				jcbg=new JcjgpjbgjbqkBean();
			}
			jcyrdwfhssxxbean.setJcdwbh(jcbg.getWtdwbh());
			jcyrdwfhssxxbean.setJcdwmc(jcbg.getWtdwmc());
			jcyrdwfhssxxbean.setDwbh(jcbg.getJsdwbh());
			jcyrdwfhssxxbean.setDwmc(jcbg.getJsdwmc());
			jcyrdwfhssxxbean.setBgbh(bgbh);
			if (!(messageBean.getMethod().equals("add"))) {
				jcyrdwfhssxxbean = (JcyrdwfhssxxBean) findByKey(jcyrdwfhssxxbean,
						" where  sysno='" + strSysno + "'");
				if (jcyrdwfhssxxbean != null) {
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
	@Action(value = "JcyrdwfhssxxAction_insert")
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
			jcyrdwfhssxxbean.setSysno(number);
			messageBean = insert(jcyrdwfhssxxbean);
			count=messageBean.getCheckFlag();
			   //进行数据同步
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
				 	WriteRecordUtil.write(jcyrdwfhssxxbean, jcyrdwfhssxxbean.getClass().getName(), "jcyrdwfhssxx", "sysno", number, "add",cm);
				 }
			}
		} catch (Exception e) {
			;
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
	@Action(value = "JcyrdwfhssxxAction_update")
	public String update() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;
		try {

			messageBean = update(jcyrdwfhssxxbean, " where  sysno='"
					+ jcyrdwfhssxxbean.getSysno() + "'");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
						WriteRecordUtil.write(jcyrdwfhssxxbean, jcyrdwfhssxxbean.getClass().getName(), "jcyrdwfhssxx", "sysno", jcyrdwfhssxxbean.getSysno(), "update",cm);
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
	@Action(value = "JcyrdwfhssxxAction_delete")
	public String delete() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;
		try {
			jcyrdwfhssxxbean = new JcyrdwfhssxxBean();
			messageBean = delete(jcyrdwfhssxxbean, " where  sysno in (" + strSysno + ")");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
					if(count==1){
						WriteRecordUtil.write(jcyrdwfhssxxbean, jcyrdwfhssxxbean.getClass().getName(), "jcyrdwfhssxx", "sysno",strSysno, "delete",cm);
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

    

	public JcyrdwfhssxxBean getJcyrdwfhssxxbean() {
		return jcyrdwfhssxxbean;
	}

	public void setJcyrdwfhssxxbean(JcyrdwfhssxxBean jcyrdwfhssxxbean) {
		this.jcyrdwfhssxxbean = jcyrdwfhssxxbean;
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

	public String getDwbh() {
		return dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
	}

	
	
	
	

}
