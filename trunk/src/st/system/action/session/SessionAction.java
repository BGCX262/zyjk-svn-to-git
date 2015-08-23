package st.system.action.session;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.security.SystemAttributeNames;
import st.portal.action.BasicAction;
import st.system.dao.PtdeptBean;
import st.system.dao.PtoperBean;

import com.opensymphony.xwork2.ActionContext;

/**
 * session 取内容 
 * @author Administrator
 *
 */
@ParentPackage("struts-filter")
@Namespace("/st/system/action/session") 
public class SessionAction extends BasicAction {

    
    private  PtoperBean oper;
    
    private  PtdeptBean dept;
    
    /**
     *返回session数值
     * @return String 返回操作结果
     */
    @Action(value = "SessionAction_getSession", results = {
            @Result(type = "json", name = SUCCESS, params = { "includeProperties", "oper.*,dept.*" }) })
    public String getSession(){
        
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        oper = (PtoperBean)session.get(SystemAttributeNames.USER_INFO_NAME);
        System.out.println(oper.getBirthday());
        dept = (PtdeptBean)session.get(SystemAttributeNames.DEPT_INFO_NAME);
        System.out.println(dept.getDeptno());
        return SUCCESS;
    }

    public PtdeptBean getDept() {
        return dept;
    }

    public void setDept(PtdeptBean dept) {
        this.dept = dept;
    }

    public PtoperBean getOper() {
        return oper;
    }

    public void setOper(PtoperBean oper) {
        this.oper = oper;
    }

 
    
    
}
