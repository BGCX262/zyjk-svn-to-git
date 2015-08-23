/*********************************************************************
 *<p>处理内容：部门分配权限</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.06.03---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.role;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import UI.message.MisConstant;

import st.portal.action.BasicAction;
import st.portal.action.MessageBean;
import st.system.dao.PtdeptresBean;
import st.system.dao.PtroleresBean;

@ParentPackage("struts-filter")
@Namespace("/st/system/action/role") 
public class DeptResAction extends BasicAction {
    
    private static final long serialVersionUID = 1L;

    private static Logger logger = Logger.getLogger(RoleResAction.class);

    private String strWhere=""; //查询条件

    private String strSysno=""; //资源主键编号
    
    private String strDeptid="";  //部门编号

    private MessageBean messageBean ;//操作状态

    private PtdeptresBean ptdeptresBean; //返回的信息

    private List<Map<String, Object>> list;
    
    /**
     *添加方法
     * @return String 返回操作结果
     */
    @Action(value = "deptres_insert")
    public String insert() {
        try {
            //删除原先已有的资源
            ptdeptresBean = new PtdeptresBean();
            messageBean = delete(ptdeptresBean, " where deptid='"+ strDeptid +"'");
            
            String[] strobj=strSysno.split(",");
            for(int i=0;i<strobj.length;i++){
                ptdeptresBean=new PtdeptresBean();
                ptdeptresBean.setDeptid(strDeptid);
                ptdeptresBean.setResid(strobj[i]);
                messageBean = insert(ptdeptresBean);
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
     @Action(value = "deptres_findByKey", results = {
                @Result(name = MisConstant.FINDBYKEY, location = "/UI/system/ptdept/roletree.jsp") }) 
    public String findByKey() {
        try {
            logger.debug(messageBean.getMethod());
            if (!(messageBean.getMethod().equals("add"))) {
                
            }else{
                ptdeptresBean = new PtdeptresBean();
                ptdeptresBean.setDeptid(strDeptid);

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


    public PtdeptresBean getPtdeptresBean() {
        return ptdeptresBean;
    }


    public void setPtdeptresBean(PtdeptresBean ptdeptresBean) {
        this.ptdeptresBean = ptdeptresBean;
    }


    public String getStrDeptid() {
        return strDeptid;
    }


    public void setStrDeptid(String strDeptid) {
        this.strDeptid = strDeptid;
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
    
     
}
