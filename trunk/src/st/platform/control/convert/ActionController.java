// Decompiled by DJ v3.2.2.67 Copyright 2002 Atanas Neshkov  Date: 2009-1-8 ÏÂÎç 03:21:38
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ActionController.java

package st.platform.control.convert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import st.platform.common.Keycode;
import st.platform.common.LogManager;
import st.platform.control.business.Action;
import st.platform.security.OperatorManager;
import st.platform.system.cache.ActionConfig;
import st.portal.system.dao.PtOperBean;

// Referenced classes of package st.platform.control.convert:
//            SQLRequest, SQLResponse

public class ActionController
{

    public ActionController()
    {
    }

    public String run(HttpSession httpsession, HttpServletRequest httpservletrequest)
    {
        if(!Keycode.isPass())
            return "";
        String reqXml = httpservletrequest.getParameter(REQUEST_XML_NAME);
        SQLRequest sqlReq = new SQLRequest();
        SQLResponse sqlRes = new SQLResponse();
        boolean result = sqlReq.setXMLStr(reqXml);
        if(!result)
        {
            sqlRes.setResult(true);
            sqlRes.setType(0);
            sqlRes.setMessage((new StringBuilder("\u89E3\u6790\u8BF7\u6C42XML\u6587\u4EF6\u5931\u8D25\uFF0Cxml=[")).append(reqXml).append("]").toString());
            return sqlRes.getXmlStr();
        }
        OperatorManager om = (OperatorManager)httpsession.getAttribute("plat_form_user_info");
     
        if(om == null || om.getOperator() == null)
        {
        	String  systype = (String)httpservletrequest.getSession(true).getAttribute("systype");
        	String query =  httpservletrequest.getParameter("method");
        	 if (  ( systype!=null  &&  systype.length()>0 ) || ( query!=null && query.equals("query") ) ) {
         	  
        	  } else {
        		 
 	            sqlRes.setResult(false);
	            sqlRes.setType(0);
	            sqlRes.setMessage("\u64CD\u4F5C\u5458\u8D85\u65F6\uFF0C\u8BF7\u91CD\u65B0\u7B7E\u5230\uFF01");
	            return sqlRes.getXmlStr();
        	 }
        }
         
        LogManager.fwebpath = httpservletrequest.getRealPath("");
//        logManager = new LogManager(om.getOperator().getOperid(), om.getOperator().getOpername(), om.setRemoteAddr());
        logManager = new LogManager("","","");
        int actionCount = sqlReq.getActionCount();
        for(int i = 0; i < actionCount; i++)
        {
            try
            {
                String actionNo = sqlReq.getActionName(i);
                st.platform.system.cache.ActionConfig.LogicAct lact = ActionConfig.getInstance().getActionConfig(actionNo);
                logManager.setMessage((new StringBuilder("\u4F1A\u8BDD\u64CD\u4F5C")).append(lact.logicClass).append("\u5F00\u59CB").toString());
                Class cc = Class.forName(lact.logicClass);
                Action act = (Action)cc.newInstance();
                act.logManager = logManager;
                if ( om != null )
                	act.setOperator(om.getOperator());
                act.execute(sqlReq.getActionRequest(i), sqlRes);
            }
            catch(Exception e)
            {
                sqlRes.setResult(false);
                sqlRes.setType(0);
                sqlRes.setMessage((new StringBuilder("\u8C03\u7528\u7C7B\u5BF9\u8C61\u51FA\u9519\uFF1A")).append(e.getMessage()).toString());
                logManager.setError(e);
            }
            logManager.setMessage("\u4F1A\u8BDD\u64CD\u4F5C\u7ED3\u675F");
        }

        return sqlRes.getXmlStr();
    }

    public static String REQUEST_XML_NAME = "sys_request_xml";
    public static String RESPONSE_XML_NAME = "sys_response_xml";
    private LogManager logManager;

}