/*********************************************************************
 *<p>处理内容：Ptoper Action</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.03.22---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.ptoper;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.portal.action.PageBean;
import st.system.dao.PtoperroleBean;
import UI.message.MisConstant;
@ParentPackage("struts-filter")
@Namespace("/st/system/action/ptoper") 
public class PtoperAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(PtoperAction.class);

	private String strWhere=""; //查询条件

	private String strSysno=""; //资源主键编号
	
	private String strRoleno="";  //角色编号

	private MessageBean messageBean ;//操作状态

	private PtoperroleBean ptOPerRoleBean; //返回的信息

	private List<Map<String, Object>> list;
	
    private String operid="";
	


	/**
	 *添加方法
	 * @return String 返回操作结果
	 */
	@Action(value = "ptoper_insert")
	public String insert() {
		try {
			String[] strobj=strSysno.split(",");
			System.out.println("长度"+strobj.length);			

			for(int i=0;i<strobj.length;i++){
				ptOPerRoleBean=new PtoperroleBean();
				ptOPerRoleBean.setOperid(strRoleno);
				ptOPerRoleBean.setRoleid(strobj[i]);
				messageBean = insert(ptOPerRoleBean);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		
		System.out.println("测试增方法测试增方法测试增方法测试增方法测试增方法测试增方法测试增方法测试增方法测试增方法");
		return MisConstant.RETMESSAGE;
	}

	
	/**
	 * 查询信息
	 * 
	 * @return String 返回操作结果
	 */
	 @Action(value = "ptoper_findByKey", results = {
			    @Result(name = MisConstant.FINDBYKEY, location = "/UI/system/safeoper/opertree.jsp") }) 
	public String findByKey() {
		try {
			logger.debug(messageBean.getMethod());
			if (!(messageBean.getMethod().equals("add"))) {
				ptOPerRoleBean = new PtoperroleBean();
				ptOPerRoleBean = (PtoperroleBean) findByKey(ptOPerRoleBean," where operid ='" + strSysno + "'");
				
				if (ptOPerRoleBean == null) {
					messageBean.setCheckFlag(MisConstant.MSG_FAIL);
					messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
				}
			}else{
				
				ptOPerRoleBean.setOperid(ptOPerRoleBean.getOperid());

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}

		return MisConstant.FINDBYKEY;
	}

	/**
	 * 删除方法
	 * 
	 * @return String 返回操作结果
	 */
	 @Action(value = "ptoper_delete") 
	public String delete() {
		try {
			ptOPerRoleBean = new PtoperroleBean();
			messageBean = delete(ptOPerRoleBean, " where operid='"+ strRoleno +"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}

		System.out.println("测试减方法测试减方法测试减方法测试减方法测试减方法测试减方法测试减方法测试减方法测试减方法测试减方法");
		return MisConstant.RETMESSAGE;
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	

	public MessageBean getMessageBean() {
		return messageBean;
	}

	public void setMessageBean(MessageBean messageBean) {
		this.messageBean = messageBean;
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

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		PtoperAction.logger = logger;
	}

	public String getStrRoleno() {
		return strRoleno;
	}

	public void setStrRoleno(String strRoleno) {
		this.strRoleno = strRoleno;
	}


	public PtoperroleBean getPtOPerRoleBean() {
		return ptOPerRoleBean;
	}


	public void setPtOPerRoleBean(PtoperroleBean ptOPerRoleBean) {
		this.ptOPerRoleBean = ptOPerRoleBean;
	}
     
	public String getOperid() {
		return operid;
	}


	public void setOperid(String operid) {
		this.operid = operid;
	}
	
	
}
