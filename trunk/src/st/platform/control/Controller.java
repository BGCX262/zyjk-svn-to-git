package st.platform.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import st.platform.security.OperatorManager;
import st.platform.utils.Basic;
import st.platform.control.convert.*;
import st.platform.db.control.*;

public class Controller
{

    public Controller()
    {
    }

    public static String ecxute(HttpSession httpsession, HttpServletRequest httpservletrequest)
    {
    	ActionController actionController = new ActionController();
        return actionController.run(httpsession, httpservletrequest);
    }
    
    
    public static String graphEcxute(HttpSession httpsession, HttpServletRequest httpservletrequest)
    {
    	GraphActionController graphActionController = new GraphActionController();
        return graphActionController.run(httpsession, httpservletrequest);
    }
    
    
    public static String table(HttpSession httpsession, HttpServletRequest httpservletrequest)
    {
        OperatorManager operatormanager = (OperatorManager)httpsession.getAttribute("plat_form_user_info");
        if(operatormanager == null || operatormanager.getOperator() == null)
        {
            return "null";
        } else
        {
        	
        	DBXML.webpath  = httpservletrequest.getRealPath("");
        	
        	DBXML dbXML    = new DBXML();           
            String xmnlStr = httpservletrequest.getParameter("tabStr");
            return dbXML.getDataTableXML(xmnlStr);
        }
    }

    public static String dropDown(HttpSession httpsession, HttpServletRequest httpservletrequest)
    {
    	DBXML.webpath  = httpservletrequest.getRealPath("");
    	
    	DBXML dbXML = new DBXML();
        String xmnlStr = httpservletrequest.getParameter("xx");
        return dbXML.getDropDownXML(Basic.decode(xmnlStr));
    }
}
