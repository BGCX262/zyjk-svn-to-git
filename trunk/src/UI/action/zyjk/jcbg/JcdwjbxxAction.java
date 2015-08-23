/****************************************************
 * <p>处理内容：被检测单位基本信息</p>
 * <p>Copyright: Copyright (c) 2010</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.zyjk.jcbg;

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
import UI.dao.enterfile.JcdwjbxxBean;
import UI.dao.enterfile.JcjgpjbgjbqkBean;
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.enterfile.QyldzzysBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;
import UI.util.CommenUtil;

@ParentPackage("struts-filter")
@Namespace("/UI/action/zyjk")
public class JcdwjbxxAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(JcdwjbxxAction.class);

    private JcdwjbxxBean jcdwjbxxbean;

	private String strWhere = ""; // 查询条件;

	private String strSysno = ""; // 主键编号;

	private PageBean pageBean; // 分页类;

	private MessageBean messageBean;// 操作状态
	
	private String ldzbh="";
	
	private String bgbh; //报告编号 
	
	private File file;

	private String fileFileName;
	
	private File bdfile;

	private String bdfileFileName;
	
	private String timeseria;
	 
    private String dwbh="";  //单位编号 
	 
	
	/**
	 * 
	 * 查询信息 返回json信息
	 * 
	 * @return
	 */
	@Action(value = "JcdwjbxxAction_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,jcdwjbxxbean.*" }) })
	public String findObjson() {
		try {
			JcdwjbxxBean jcdwjbxxbean = new JcdwjbxxBean();
			if (!(messageBean.getMethod().equals("add"))) {
				jcdwjbxxbean = (JcdwjbxxBean) findByKey(jcdwjbxxbean,
						" where  sysno='" + strSysno + "'");
				if (jcdwjbxxbean != null) {
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
	@Action(value = "JcdwjbxxAction_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/jcjg/jcjgbg/jcdwjbxx/jcdwjbxxdetail.jsp") })
	public String findByKey() {
		try {
			jcdwjbxxbean = new JcdwjbxxBean();
		
			jcdwjbxxbean.setBgbh(bgbh);
			JcjgpjbgjbqkBean pjbg=new JcjgpjbgjbqkBean();
			pjbg=pjbg.findFirst(" where sysno='"+bgbh+"'");
			if(null==pjbg){
				pjbg=new JcjgpjbgjbqkBean();
			}
			QyjbqkBean qyBean =new QyjbqkBean();		
			qyBean=qyBean.findFirst(" where enterno='"+ pjbg.getJsdwbh() +"'");
			if(null!=qyBean){
                //建设单位名称
				jcdwjbxxbean.setDwmc(qyBean.getDwmc());
				//建设单位编号
				jcdwjbxxbean.setDwbh(qyBean.getEnterno());
				//单位地址
				jcdwjbxxbean.setDwdz(qyBean.getZcdz());
				//所属行业
				jcdwjbxxbean.setSshy(CommenUtil.getEnuName("HYLB", qyBean.getHyfl()) );
				//员工总数
				jcdwjbxxbean.setYgrs(qyBean.getNmzgrs());
				//企业性质
				jcdwjbxxbean.setQyxz(CommenUtil.getEnuName("ZCLX", qyBean.getZclx()) );
				//体检单位
				jcdwjbxxbean.setTjdwmc(qyBean.getGltijianjg());
			}
			if (!(messageBean.getMethod().equals("add"))) {
				jcdwjbxxbean = (JcdwjbxxBean) findByKey(jcdwjbxxbean,
						" where  sysno='" + strSysno + "'");
				if (jcdwjbxxbean != null) {
					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
				} else {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}
//			else{
//				jcdwjbxxbean = (JcdwjbxxBean) findByKey(jcdwjbxxbean,
//						" where  bgbh='" + bgbh + "'");
//				if(null==jcdwjbxxbean){
//					jcdwjbxxbean=new JcdwjbxxBean();
//				}
//				if (jcdwjbxxbean != null) {
//					messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
//					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
//				} else {
//					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
//					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
//				}
//				jcdwjbxxbean.setBgbh(bgbh);
//			}
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
	@Action(value = "JcdwjbxxAction_insert", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/jcjg/jcjgbg/jcdwjbxx/jcdwjbxxdetail.jsp") })
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
			jcdwjbxxbean.setSysno(number);
			
			 if (file != null) {
					//if(Config.getProperty("photoState").equals("1")){
				         FileUploadService fs = new FileUploadService();
				             try {
				            	timeseria=String.valueOf( System.currentTimeMillis());
								String path = fs.uploadFile(file, fileFileName, "4", "");
								jcdwjbxxbean.setGylc(path);
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						
					}
			 if (bdfile != null) {
					//if(Config.getProperty("photoState").equals("1")){
				         FileUploadService fs = new FileUploadService();
				             try {
				            	 timeseria=String.valueOf( System.currentTimeMillis());
								 String path = fs.uploadFile(bdfile, bdfileFileName, "5", "");
								 jcdwjbxxbean.setJcbdt(path);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} 
						
					}
			
			messageBean = insert(jcdwjbxxbean);
			count=messageBean.getCheckFlag();
			   //进行数据同步
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
				 	WriteRecordUtil.write(jcdwjbxxbean, jcdwjbxxbean.getClass().getName(), "jcdwjbxx", "sysno", number, "add",cm);
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
		return MisConstant.FINDBYKEY;
	}

	/**
	 * 
	 * 修改方法
	 * 
	 * @return
	 */
	@Action(value = "JcdwjbxxAction_update", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/jcjg/jcjgbg/jcdwjbxx/jcdwjbxxdetail.jsp") })
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
			            	timeseria=String.valueOf( System.currentTimeMillis());
							String path = fs.uploadFile(file, fileFileName, "4", jcdwjbxxbean.getGylc());
							jcdwjbxxbean.setGylc(path);
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					
				}
		 if (bdfile != null) {
				//if(Config.getProperty("photoState").equals("1")){
			         FileUploadService fs = new FileUploadService();
			             try {
			            	 timeseria=String.valueOf( System.currentTimeMillis());
							 String path = fs.uploadFile(bdfile, bdfileFileName, "5", jcdwjbxxbean.getJcbdt());
							 jcdwjbxxbean.setJcbdt(path);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					
				}
			messageBean = update(jcdwjbxxbean, " where  sysno='"
					+ jcdwjbxxbean.getSysno() + "'");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
				if(count==1){
						WriteRecordUtil.write(jcdwjbxxbean, jcdwjbxxbean.getClass().getName(), "jcdwjbxx", "sysno", jcdwjbxxbean.getSysno(), "update",cm);
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
	@Action(value = "JcdwjbxxAction_delete")
	public String delete() {
		//打开数据库连接	 
		 ConnectionManager cm  = ConnectionManager.getInstance();
	     DatabaseConnection dc = cm.get();
	     //开启事务
	     dc.begin();
	     int count=0;
		try {
			jcdwjbxxbean = new JcdwjbxxBean();
			messageBean = delete(jcdwjbxxbean, " where  sysno in (" + strSysno + ")");
			count=messageBean.getCheckFlag();
			 //往记录表里面插入数据
			if(Config.getProperty("isSynch").equals("1")){
					if(count==1){
						WriteRecordUtil.write(jcdwjbxxbean, jcdwjbxxbean.getClass().getName(), "jcdwjbxx", "sysno",strSysno, "delete",cm);
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

    
    

	public JcdwjbxxBean getJcdwjbxxbean() {
		return jcdwjbxxbean;
	}

	public void setJcdwjbxxbean(JcdwjbxxBean jcdwjbxxbean) {
		this.jcdwjbxxbean = jcdwjbxxbean;
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

	public String getLdzbh() {
		return ldzbh;
	}

	public void setLdzbh(String ldzbh) {
		this.ldzbh = ldzbh;
	}

	public String getBgbh() {
		return bgbh;
	}

	public void setBgbh(String bgbh) {
		this.bgbh = bgbh;
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

	
	public File getBdfile() {
		return bdfile;
	}

	public void setBdfile(File bdfile) {
		this.bdfile = bdfile;
	}

	public String getBdfileFileName() {
		return bdfileFileName;
	}

	public void setBdfileFileName(String bdfileFileName) {
		this.bdfileFileName = bdfileFileName;
	}

	public String getTimeseria() {
		return timeseria;
	}

	public void setTimeseria(String timeseria) {
		this.timeseria = timeseria;
	}

	public String getDwbh() {
		return dwbh;
	}

	public void setDwbh(String dwbh) {
		this.dwbh = dwbh;
	}

	
	
	

}
