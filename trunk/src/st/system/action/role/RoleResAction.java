/*********************************************************************
 *<p>处理内容：RoleRes Action</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.03.22---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.role;

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
import st.system.dao.PtroleresBean;
import UI.message.MisConstant;
@ParentPackage("struts-filter")
@Namespace("/st/system/action/roleres") 
public class RoleResAction extends BasicAction {

	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(RoleResAction.class);

	private String strWhere=""; //查询条件

	private String strSysno=""; //资源主键编号
	
	private String strRoleno="";  //角色编号

	private MessageBean messageBean ;//操作状态

	private PtroleresBean ptRoleResBean; //返回的信息

	private List<Map<String, Object>> list;
	


    
    
	/**
	 *添加方法
     *
	 * @return String 返回操作结果
	 */
	@Action(value = "roleres_insert")
	public String insert() {
		try {
            ptRoleResBean = new PtroleresBean();
            messageBean = delete(ptRoleResBean, " where roleid='"+ strRoleno +"'");
            
			String[] strobj=strSysno.split(",");
			for(int i=0;i<strobj.length;i++){
				ptRoleResBean=new PtroleresBean();
				ptRoleResBean.setRoleid(strRoleno);
				ptRoleResBean.setResid(strobj[i]);
				messageBean = insert(ptRoleResBean);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}
		return MisConstant.RETMESSAGE;
	}


	/**
	 * 查询信息
	 * 
	 * @return String 返回操作结果
	 */
	 @Action(value = "roleres_findByKey", results = {
			    @Result(name = MisConstant.FINDBYKEY, location = "/UI/system/role/roletree.jsp") }) 
	public String findByKey() {
		try {
			logger.debug(messageBean.getMethod());
			if (!(messageBean.getMethod().equals("add"))) {
				
			}else{
				
				ptRoleResBean.setRoleid(ptRoleResBean.getRoleid());

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
	 @Action(value = "roleres_delete") 
	public String delete() {
		try {
			ptRoleResBean = new PtroleresBean();
			messageBean = delete(ptRoleResBean, " where roleid='"+ strRoleno +"'");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			logger.error(MisConstant.MSG_OPERATE_FAIL, e);
			messageBean.setCheckFlag(MisConstant.MSG_FAIL);
			messageBean.setCheckMessage(MisConstant.MSG_OPERATE_FAIL);
		}

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
		RoleResAction.logger = logger;
	}
    

	public PtroleresBean getPtRoleResBean() {
		return ptRoleResBean;
	}

	public void setPtRoleResBean(PtroleresBean ptRoleResBean) {
		this.ptRoleResBean = ptRoleResBean;
	}

	public String getStrRoleno() {
		return strRoleno;
	}

	public void setStrRoleno(String strRoleno) {
		this.strRoleno = strRoleno;
	}

	
	
}
