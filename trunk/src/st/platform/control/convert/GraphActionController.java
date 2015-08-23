package st.platform.control.convert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import st.platform.system.cache.*;
import st.platform.system.cache.ActionConfig.LogicAct;
import st.platform.security.*;
import st.platform.common.*;
import st.platform.control.business.*;

public class GraphActionController {
   
    public static String REQUEST_XML_NAME  = "sys_request_xml";
    public static String RESPONSE_XML_NAME = "sys_response_xml";
    private LogManager logManager;
 
    public String  run(HttpSession httpsession, HttpServletRequest httpservletrequest) {

        if (Keycode.isPass() == false)
            return "";
        
        String reqXml     = httpservletrequest.getParameter(REQUEST_XML_NAME);

        SQLRequest sqlReq = new SQLRequest();
        SQLResponse sqlRes = new SQLResponse();

        boolean result = sqlReq.setXMLStr(reqXml);
      
        if ( !result ) {
            sqlRes.setResult(true);
            sqlRes.setType(0);
            sqlRes.setMessage("解析请求XML文件失败，xml=["+reqXml+"]");
            return sqlRes.getXmlStr();
        }
        
        OperatorManager om = (OperatorManager)httpsession.getAttribute(SystemAttributeNames.USER_INFO_NAME);
        
        if (om==null || om.getOperator() == null){
             sqlRes.setResult(false);
             sqlRes.setType(0);
             sqlRes.setMessage("操作员超时，请重新签到！");
             return sqlRes.getXmlStr();
        }
        
        logManager = new LogManager(om.getOperator().getOperid(),om.getOperator().getOpername(),om.setRemoteAddr());       
        
        int actionCount  = sqlReq.getActionCount();
        for (int i = 0 ; i < actionCount; i++) 
        {
            try 
            {
                String actionNo = sqlReq.getActionName(i);

                LogicAct lact = ActionConfig.getInstance().getActionConfig(actionNo);
                
                //logManager.setMessage("会话操作" + lact.logicClass + "开始");
                
                Class       cc      = Class.forName(lact.logicClass);
                GraphAction act     = (GraphAction) cc.newInstance();
                
                act.logManager = logManager;
                act.setOperator(om.getOperator());
                
                act.execute(sqlReq.getActionRequest(i), sqlRes);
    
            } catch (Exception e) {
                
                sqlRes.setResult(false);
                sqlRes.setType(0);
                sqlRes.setMessage("调用类对象出错："+e.getMessage());
                
                logManager.setError(e);
            }
            
            //logManager.setMessage("会话操作结束");
        }       

        return sqlRes.getXmlStr();
    }

}
