/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  孙雁斌;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-13     孙雁斌          新規作成 ;
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
import UI.dao.enterfile.QyjbqkBean;
import UI.dao.zyjk.JcjgbaxxBean;
import UI.dao.zyjk.PxjgbaxxBean;
import UI.dao.zyjk.T_officerBean;
import UI.dao.zyjk.WsjgbaxxBean;
import UI.message.MisConstant;
import UI.util.BusinessDate;

@ParentPackage("struts-filter")
@Namespace("/UI/action/register")
public class RegisterAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(RegisterAction.class);
  
	private QyjbqkBean qyjbqkBean; // 返回的信息;
	
	private T_officerBean officerBean; // 返回的信息;

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
	@Action(value = "EnterMain_findObjson", results = { @Result(type = "json", name = MisConstant.FINDOBJSON, params = {
			"includeProperties", "messageBean.*,qyjbqkBean.*" }) })
	public String findObjson() {
		try {
			qyjbqkBean = new QyjbqkBean();
			if (!(messageBean.getMethod().equals("add"))) {
				qyjbqkBean = (QyjbqkBean) findByKey(qyjbqkBean,
						" where enterno ='" + strSysno + "'");
				if (qyjbqkBean != null) {
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
	@Action(value = "EnterMain_findByKey", results = { @Result(name = MisConstant.FINDBYKEY, location = "/UI/enterfile/register.jsp") })
	public String findByKey() {
		try {
			qyjbqkBean = new QyjbqkBean();
			officerBean=new T_officerBean();
			if (!(messageBean.getMethod().equals("add"))) {
				qyjbqkBean = (QyjbqkBean) findByKey(qyjbqkBean,
						" where enterno ='" + strSysno + "'");
				if (qyjbqkBean != null) {
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
	@Action(value = "EnterMain_insert")
	public String insert() {
//		开线程
		ConnectionManager cm  = ConnectionManager.getInstance();
        DatabaseConnection dc = cm.get();
        dc.begin();
        //锁标态位
        int count1=0;
        int count2=0;
        try {
			//String number = BusinessDate.getNoFormatToday() + "-"
			//		+ SerialNumber.getNextSerialNo("67");
			String number =Config.getProperty("distcode")+"-"+SerialNumber.getNextSerialNo("67");
			String enternm=officerBean.getOfficer_name().trim();
			
			//单位注册类型
			String regType=officerBean.getDept_type(); 
			
			T_officerBean qybean=new T_officerBean();
			
			qybean=qybean.findFirst(" where officer_name='"+ enternm +"' ");
			//检测机构用户
    		JcjgbaxxBean jcBean=new JcjgbaxxBean();
    		//培训机构用户
    		PxjgbaxxBean pxBean=new PxjgbaxxBean();
    		//卫生机构用户
    		WsjgbaxxBean wsBean=new WsjgbaxxBean();
			
			if(null!=qybean){
				 messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	             messageBean.setCheckMessage(MisConstant.WARN_REG_DUPLICATE);
			}else{
				
				if(regType.equals("1")){
                    //单位用户
					qyjbqkBean.setEnterno(number);
					qyjbqkBean.setCorpkey(number);
					officerBean.setLogin_id(number);
					officerBean.setDept_type("1");
					qyjbqkBean.setDwmc(officerBean.getOfficer_name().trim());
					MessageBean qy_messageBean = insert(qyjbqkBean);
					MessageBean office_messageBean = insert(officerBean);
					
					 //执行同步操作
					count1=qy_messageBean.getCheckFlag();
					count2=office_messageBean.getCheckFlag();
					if(Config.getProperty("isSynch").equals("1")){
						if(count1==1&&count2==1){
							WriteRecordUtil.write(qyjbqkBean, qyjbqkBean.getClass().getName(), "qyjbqk", "enterno", number, "add",cm);
							WriteRecordUtil.write(officerBean, officerBean.getClass().getName(), "T_Officer", "officer_id", number, "add",cm);
						}
					}
					
					
				}else if(regType.equals("2")){
                   //检测机构单位用户
					jcBean.setSysno(number);
					officerBean.setLogin_id(number);
					officerBean.setDept_type("2");
					jcBean.setDwmc(officerBean.getOfficer_name().trim());
					jcBean.setGszch(qyjbqkBean.getGszch());
					jcBean.setZzjgdm(qyjbqkBean.getZzjgdm());
					jcBean.setDistcode(qyjbqkBean.getDistcode());
					jcBean.setFddbr(qyjbqkBean.getFddbr());
					jcBean.setZcdz(qyjbqkBean.getZcdz());
					MessageBean qy_messageBean = insert(jcBean);
					MessageBean office_messageBean = insert(officerBean);
					
					 //执行同步操作
					count1=qy_messageBean.getCheckFlag();
					count2=office_messageBean.getCheckFlag();
					if(Config.getProperty("isSynch").equals("1")){
						if(count1==1&&count2==1){
							WriteRecordUtil.write(jcBean, jcBean.getClass().getName(), "jcjgbaxx", "sysno", number, "add",cm);
							WriteRecordUtil.write(officerBean, officerBean.getClass().getName(), "T_Officer", "officer_id", number, "add",cm);
						}
					}
				}else if(regType.equals("3")){
                   //培训机构单位用户
					pxBean.setSysno(number);
					officerBean.setLogin_id(number);
					officerBean.setDept_type("3");
					pxBean.setPxjgmc(officerBean.getOfficer_name().trim());
					pxBean.setPxjgdz(qyjbqkBean.getZcdz());
					pxBean.setFddbr(qyjbqkBean.getFddbr());
					MessageBean qy_messageBean = insert(pxBean);
					MessageBean office_messageBean = insert(officerBean);
					
					 //执行同步操作
					count1=qy_messageBean.getCheckFlag();
					count2=office_messageBean.getCheckFlag();
					if(Config.getProperty("isSynch").equals("1")){
						if(count1==1&&count2==1){
							WriteRecordUtil.write(pxBean, pxBean.getClass().getName(), "pxjgbaxx", "sysno", number, "add",cm);
							WriteRecordUtil.write(officerBean, officerBean.getClass().getName(), "T_Officer", "officer_id", number, "add",cm);
						}
					}
				}else if(regType.equals("4")){
                    //卫生机构单位用户
					wsBean.setSysno(number);
					officerBean.setLogin_id(number);
					officerBean.setDept_type("4");
					wsBean.setJgmc(officerBean.getOfficer_name().trim());
					wsBean.setJgdz(qyjbqkBean.getZcdz());
					wsBean.setFddbr(qyjbqkBean.getFddbr());
					MessageBean qy_messageBean = insert(wsBean);
					MessageBean office_messageBean = insert(officerBean);
					
					 //执行同步操作
					count1=qy_messageBean.getCheckFlag();
					count2=office_messageBean.getCheckFlag();
					if(Config.getProperty("isSynch").equals("1")){
						if(count1==1&&count2==1){
							WriteRecordUtil.write(wsBean, wsBean.getClass().getName(), "wsjgbaxx", "sysno", number, "add",cm);
							WriteRecordUtil.write(officerBean, officerBean.getClass().getName(), "T_Officer", "officer_id", number, "add",cm);
						}
					}
				}
				
				
				ServletActionContext.getContext().getSession().put("login", "false"); 
	            
	            // 判断用户姓名和密码是否一致
	            // 判断账户是否已经停用
	            if (  null==officerBean.getOfficer_name()|| null==officerBean.getC_pwd()||officerBean.getOfficer_name().equals("") ||officerBean.getC_pwd().equals("")  ) {
	                return LOGIN;
	            } else {
	            	strWhere = " where officer_name='" + officerBean.getOfficer_name() + "' and c_pwd='" + officerBean.getC_pwd() + "'";
	            }
	            
	            //如果用户名和密码正确
	            officerBean=officerBean.findFirst(strWhere);
	            if (officerBean != null) {
	            	ServletActionContext.getContext().getSession().put(SystemAttributeNames.CORP_INFO_NAME, officerBean);  
	                messageBean.setCheckFlag(MisConstant.MSG_SUCCESS);
	                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_SUCCESS);
	            }else{
	                messageBean.setCheckFlag(MisConstant.MSG_FAIL);
	                messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
	            }
	            
	            messageBean.setWidgetValue(regType);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// 设置错误返回的提示
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}finally{
			//关闭线程
			 if ( count1 > 0&&count2 > 0 ) {
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

	public QyjbqkBean getQyjbqkBean() {
		return qyjbqkBean;
	}

	public void setQyjbqkBean(QyjbqkBean qyjbqkBean) {
		this.qyjbqkBean = qyjbqkBean;
	}

	public T_officerBean getOfficerBean() {
		return officerBean;
	}

	public void setOfficerBean(T_officerBean officerBean) {
		this.officerBean = officerBean;
	}

}
