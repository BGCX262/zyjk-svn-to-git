package st.platform.utils;

import java.io.InputStream;
import java.util.Properties;
import org.jdom.Element;
import st.platform.common.XMLConfig;;

public class Config
{

    public Config()
    {
    }

    public static String getProperty(String propsKey)
    {
        Config config     = new Config();
        String propsValue = "";
        try
        {
        	 propsValue = config.getProp(propsKey);
             
             if(propsValue == null)
                 return "";
             
        	propsValue = new String(propsValue.getBytes("ISO-8859-1"));
        }
        catch(Exception exception) { }
        
        return propsValue;
    }

    public static String getDbConnectionStr(String conID) throws Exception
    {
    	XMLConfig xmlConfig = new XMLConfig();
    	Element   dbNode    = xmlConfig.getChildNode("dataAccess");
    	  
        if(conID == null || conID.trim().equals(""))
        	conID = xmlConfig.getChildNodeValue(dbNode,"defualtDB");
            	
        Element element = xmlConfig.GetChildAttrNode(dbNode, "ID", conID);
        if(element == null)
        {
            return "";
        } else
        {
            String s1 = element.getAttributeValue("Type").toUpperCase();
            s1 = s1 + "|" + element.getAttributeValue("DBPool");
            s1 = s1 + "|" + element.getAttributeValue("DBDriver");
            s1 = s1 + "|" + element.getAttributeValue("ConnStr");
            s1 = s1 + "|" + element.getAttributeValue("user");
            s1 = s1 + "|" + element.getAttributeValue("passwd");

            return s1;
        }
    	
    }

   

    public String getProp(String s) throws Exception
    {
        if(properties == null)
        	init();
        return properties.getProperty(s);
    }

    private void init()throws Exception
    {
    	properties = new Properties();
        InputStream inputstream = null;
        try
        {
            inputstream = getClass().getResourceAsStream(propsName);
            properties.load(inputstream);
        }
        catch(Exception exception)
        {
            inputstream.close();
            throw exception;
        }
        finally
        {
            inputstream.close();
        }
        return;
    }

    public static void main(String args[])
    {
        try
        {
            System.out.println(getDbConnectionStr(""));
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private static String propsName = "/oryx.properties";
    private static Properties properties = null;
    
    public static boolean copyright = false;
    
    public static String  limitTime = "";

}
