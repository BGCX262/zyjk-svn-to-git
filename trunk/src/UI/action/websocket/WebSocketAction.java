/*********************************************************************
 *<p>处理内容：WebSocket Action</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package UI.action.websocket;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;


@ParentPackage("struts-filter")
@Namespace("/UI/action/websocket")  
public class WebSocketAction extends ActionSupport{

    private static Logger logger = Logger.getLogger(WebSocketAction.class);

    private static final long serialVersionUID = 1L;

    String strTime = "";
    

    /**
     * 查询信息 返回json信息
     * 
     * @return
     */
    @Action(value = "WebSocket", results = {
            @Result(type = "json", name = SUCCESS, params = { "includeProperties", "strTime" }) })
    public String pushSocket(){
        try {
            while(true)
            {
            //System.out.println(strTime);
            //System.out.println("123123");
             strTime = ""+System.currentTimeMillis();
            }
        }catch (Exception e) {
            // TODO: handle exception
        }
        
        return SUCCESS;
    }


    public String getStrTime() {
        return strTime;
    }


    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }
    
    
    
}
