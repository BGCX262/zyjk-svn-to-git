/****************************************************
 * <p>处理内容：评价报告基本情况</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14    新規作成 ;
 ****************************************************/
package UI.action.zyjk;

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
import UI.dao.zyjk.JcjgbaxxBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk")
public class JcjgbgAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(JcjgbgAction.class);

    private JcjgpjbgjbqkBean jcjgpjbgjbqkbean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String enterno=""; //企业主键编号
	
	private String jgbh;
	
	private File file;

	private String fileFileName;

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "JcjgbgAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,jcjgpjbgjbqkbean.*" }) })
	public String findObjson() {
		try {
			JcjgpjbgjbqkBean jcjgpjbgjbqkbean = new JcjgpjbgjbqkBean();
			if (!(messageBean.getMethod().equals("add"))) {
				jcjgpjbgjbqkbean = (JcjgpjbgjbqkBean) findByKey(jcjgpjbgjbqkbean,
						" where  sysno='" + strSysno + "'");
				if (jcjgpjbgjbqkbean != null) {
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
	@Action(value = "JcjgbgAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/jcjg/jcjgbg/jcjgbginfo.jsp") })
	public String findByKey() {
		try {
			jcjgpjbgjbqkbean = new JcjgpjbgjbqkBean();
			jcjgpjbgjbqkbean.setWtdwbh(jgbh);
			JcjgbaxxBean ba = new JcjgbaxxBean();
			ba = ba.findFirst(" where sysno='" + jgbh + "'");
			if(null==ba){
				ba=new JcjgbaxxBean();
			}
			jcjgpjbgjbqkbean.setWtdwmc(ba.getDwmc());
			if (!(messageBean.getMethod().equals("add"))) {
				jcjgpjbgjbqkbean = (JcjgpjbgjbqkBean) findByKey(jcjgpjbgjbqkbean,
						" where  sysno='" + strSysno + "'");
				if (jcjgpjbgjbqkbean != null) {
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
	@Action(value = "JcjgbgAction_insert", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/jcjg/jcjgbg/jcjgbginfo.jsp") })
	public String insert() {
		 //	打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;	 	 	 
		try {
			String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			jcjgpjbgjbqkbean.setSysno(number);
//			JcjgbaxxBean ba = new JcjgbaxxBean();
//			ba = ba.findFirst(" where sysno='" + jcjgpjbgjbqkbean.getWtdwbh() + "'");
//			if(null==ba){
//				ba=new JcjgbaxxBean();
//			}
//			jcjgpjbgjbqkbean.setWtdwmc(ba.getDwmc());
			 if (file != null) {
					//if(Config.getProperty("photoState").equals("1")){
				         FileUploadService fs = new FileUploadService();
				             try {
				            	// timeseria=String.valueOf( System.currentTimeMillis());
								String path = fs.uploadFile(file, fileFileName, "1", "");
								jcjgpjbgjbqkbean.setBgfj(path);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						
					}
			messageBean = insert(jcjgpjbgjbqkbean);
			count=messageBean.getCheckFlag();
			  //进行数据同步
			  if(Config.getProperty("isSynch").equals("1")){
				 if(count==1){
					WriteRecordUtil.write(jcjgpjbgjbqkbean, jcjgpjbgjbqkbean.getClass().getName(), "jcjgpjbgjbqk", "sysno", number, "add",cm);
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
		return MisConstant.FINDBYKEY;
	}

	/**
	 * 
	 * 修改方法
	 * 
	 * @return
	 */
	@Action(value = "JcjgbgAction_update", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/jcjg/jcjgbg/jcjgbginfo.jsp") })
	public String update() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;	 	 
		try {
			
			if (file != null) {
				//if(Config.getProperty("photoState").equals("1")){
			         FileUploadService fs = new FileUploadService();
			             try {
			            	// timeseria=String.valueOf( System.currentTimeMillis());
							String path = fs.uploadFile(file, fileFileName, "1", jcjgpjbgjbqkbean.getBgfj());
							jcjgpjbgjbqkbean.setBgfj(path);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					
				}

			messageBean = update(jcjgpjbgjbqkbean, " where  sysno='"
					+ jcjgpjbgjbqkbean.getSysno() + "'");
			count=messageBean.getCheckFlag();
		  //往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(jcjgpjbgjbqkbean, jcjgpjbgjbqkbean.getClass().getName(), "jcjgpjbgjbqk", "sysno", jcjgpjbgjbqkbean.getSysno(), "update",cm);
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
		return MisConstant.FINDBYKEY;
	}

	/**
	 * 
	 * 删除改方法
	 * 
	 * @return
	 */
	@Action(value = "JcjgbgAction_delete")
	public String delete() {
		 //	打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;	 	 
		try {
			jcjgpjbgjbqkbean = new JcjgpjbgjbqkBean();
			messageBean = delete(jcjgpjbgjbqkbean, " where  sysno in (" + strSysno + ")");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
			 if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(jcjgpjbgjbqkbean, jcjgpjbgjbqkbean.getClass().getName(), "jcjgpjbgjbqk", "sysno",strSysno, "delete",cm);
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

	
    
	

	public JcjgpjbgjbqkBean getJcjgpjbgjbqkbean() {
		return jcjgpjbgjbqkbean;
	}

	public void setJcjgpjbgjbqkbean(JcjgpjbgjbqkBean jcjgpjbgjbqkbean) {
		this.jcjgpjbgjbqkbean = jcjgpjbgjbqkbean;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	

}
