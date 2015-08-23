package st.platform.common;

import java.io.InputStream;
import java.util.List;
import org.jdom.*;
import org.jdom.input.SAXBuilder;

public class XMLConfig {
	private static String propsXML = "/oryx.xml";
	private Element rootNode =null;
	
	public XMLConfig()
	{
		try
        {
			intConfig();
        }
		catch(Exception exception)
        {
        	
        }
       
	}
	  
	private void intConfig()throws Exception
	{
		SAXBuilder saxbd = new SAXBuilder();
		
		InputStream inputstream = null;
		try
        {
			inputstream = getClass().getResourceAsStream(propsXML);
		
			Document doc = saxbd.build(inputstream);
			rootNode     = doc.getRootElement();
			
        }catch(Exception exception)
        {
        	inputstream.close();
            throw exception;
        }
        finally
        {
            inputstream.close();
        }
	}
	
	
	public List getChildNodeList(String nodeName)
	{
		List ElementList =null;
		if (rootNode != null)
		{
			ElementList = rootNode.getChildren(nodeName);		
				
		}
		return ElementList;
	}
	public List getChildNodeList(Element element,String nodeName)
	{
		List ElementList =null;
		if (element != null)
		{
			ElementList = element.getChildren(nodeName);		
				
		}
		return ElementList;
	}
	
	public Element getChildNode(String nodeName)
	{
		Element element =null;
		if (rootNode != null)
		{
			element = rootNode.getChild(nodeName);		
				
		}
		return element;
	}
	
	public Element getChildNode(Element element,String nodeName)
	{
		Element elementChild =null;
		if (element != null)
		{
			elementChild = element.getChild(nodeName);		
				
		}
		return elementChild;
	}
	
	 public static String[]   raoluan3()
  	{  		
	    String[]  keyS = new String[2];
		 
	    keyS[0] = JavaBeanGenerator.raoluan2() + "-8" + Keycode.projectKey.substring(Keycode.projectKey.length()/2,Keycode.projectKey.length()/2 + 4)+ 
	    Keycode.dateKey.substring(6,8) +Keycode.projectKey.substring(Keycode.projectKey.length()-50,Keycode.projectKey.length()-44)+Keycode.dateKey.substring(0,2);
  		
	    keyS[1] = JavaBeanGenerator.raoluan2() + "-0" + Keycode.projectKey.substring(Keycode.projectKey.length()/2,Keycode.projectKey.length()/2 + 4)+ 
	    Keycode.dateKey.substring(6,8) +Keycode.projectKey.substring(Keycode.projectKey.length()-50,Keycode.projectKey.length()-44)+Keycode.dateKey.substring(0,2);
	    
	    return keyS;
  	}
	     
	  
	  
	public String getChildNodeValue(Element element,String nodeName)
	{
		Element elementChild = getChildNode(element,nodeName);
		if (elementChild != null)
		{
			return elementChild.getText();
				
		}else
		{
			return "";
		}
	}
	public String getChildNodeValue(String nodeName)
	{
		Element element = getChildNode(nodeName);
		if (element != null)
		{
			return element.getText();
				
		}
		{
			return "";
		}
	}
	
	public  Element  GetChildAttrNode( Element element,String whereAttrName,String whereAttrValue )throws Exception
	{			
		if (Keycode.isPass() == false)
			return null;
		
		try
		{				
			Element elementNode = null;
			
			List ElementList = element.getChildren();
			
			for (int i=0 ;i< ElementList.size(); i++)
			{
				elementNode = (Element)ElementList.get(i);				
				if (elementNode.getAttribute(whereAttrName) != null && elementNode.getAttributeValue(whereAttrName).equals(whereAttrValue))
					break;			
			}
			
			return elementNode;
		}
		catch(Exception e)
		{	
			throw e;						
		}
		
	}
	
	
}
