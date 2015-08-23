/****************************************************
 * <p>处理内容：企业规章制度</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-24     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.enterfile;

import java.io.File;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
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
import UI.dao.enterfile.QygzzdBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/qygzzd")
public class QygzzdAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(QygzzdAction.class);

    private QygzzdBean qygzzdBean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String enterno=""; //企业主键编号
	
	 private File file;

	 private String fileFileName;
		
	 private String timeseria;

	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "QygzzdAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,qygzzdBean.*" }) })
	public String findObjson() {
		try {
			QygzzdBean qygzzdBean = new QygzzdBean();
			if (!(messageBean.getMethod().equals("add"))) {
				qygzzdBean = (QygzzdBean) findByKey(qygzzdBean,
						" where  sysno='" + strSysno + "'");
				if (qygzzdBean != null) {
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
	@Action(value = "QygzzdAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/qygzzd/qygzzddetail.jsp") })
	public String findByKey() {
		try {
			qygzzdBean = new QygzzdBean();
			qygzzdBean.setEnterno(enterno);
			if (!(messageBean.getMethod().equals("add"))) {
				qygzzdBean = (QygzzdBean) findByKey(qygzzdBean,
						" where  sysno='" + strSysno + "'");
//				if (qygzzdBean != null) {
//					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
//					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
//				} else {
//					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
//					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
//				}
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
	@Action(value = "QygzzdAction_insert",results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/qygzzd/qygzzddetail.jsp") })
	public String insert() {
		 //开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			HttpServletResponse response=ServletActionContext.getResponse();	 
			response.setContentType("text/html;charset=utf-8");  
			String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-"
					+ SerialNumber.getNextSerialNo("67");
			 if (file != null) {
					//if(Config.getProperty("photoState").equals("1")){
				         FileUploadService fs = new FileUploadService();
				             try {
				            	 timeseria=String.valueOf( System.currentTimeMillis());
								String path = fs.uploadImage(file, fileFileName, timeseria, "");
								qygzzdBean.setFjpath(path);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						
					}
			qygzzdBean.setSysno(number);
			
			messageBean = insert(qygzzdBean);
			messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
			 //执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qygzzdBean, qygzzdBean.getClass().getName(), "qygzzd", "sysno", number, "add",cm);
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
		return MisConstant.FINDBYKEY;
	}

	/**
	 * 
	 * 修改方法
	 * 
	 * @return
	 */
	@Action(value = "QygzzdAction_update",results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/qygzzd/qygzzddetail.jsp") })
	public String update() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			 if (file != null) {
					//if(Config.getProperty("photoState").equals("1")){
				         FileUploadService fs = new FileUploadService();
				             try {
				            	 timeseria=String.valueOf( System.currentTimeMillis());
								String path = fs.uploadImage(file, fileFileName, timeseria, qygzzdBean.getFjpath());
								qygzzdBean.setFjpath(path);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						
					}

			messageBean = update(qygzzdBean, " where  sysno='"
					+ qygzzdBean.getSysno() + "'");
			messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qygzzdBean, qygzzdBean.getClass().getName(), "qygzzd", "sysno", qygzzdBean.getSysno(), "update",cm);
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
		return MisConstant.FINDBYKEY;
	}

	/**
	 * 
	 * 删除改方法
	 * 
	 * @return
	 */
	@Action(value = "QygzzdAction_delete")
	public String delete() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count=0;
		try {
			qygzzdBean = new QygzzdBean();
			messageBean = delete(qygzzdBean, " where  sysno in (" + strSysno + ")");
//			执行同步操作
			count=messageBean.getCheckFlag();
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
					WriteRecordUtil.write(qygzzdBean, qygzzdBean.getClass().getName(), "qygzzd", "sysno", strSysno, "delete",cm);
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

	

	public QygzzdBean getQygzzdBean() {
		return qygzzdBean;
	}

	public void setQygzzdBean(QygzzdBean qygzzdBean) {
		this.qygzzdBean = qygzzdBean;
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

	public String getTimeseria() {
		return timeseria;
	}

	public void setTimeseria(String timeseria) {
		this.timeseria = timeseria;
	}
    
	
}
