package synch.util;


import synch.beans.Element;
import synch.beans.Error;
import synch.beans.Factor;
import synch.beans.Param;
import synch.beans.Record;
import synch.beans.Request;
import synch.beans.Result;
import synch.beans.Verification;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class XmlToObject {

	/**
	 * 将xml转换成对象
	 * @param xml
	 * @return
	 */
	public static Object xmlToOb(String xml){
		
		Object object=new Object();
		  // xstream = new XStream(); // XML转对象时报错 Exception in thread "main" java.lang.IllegalArgumentException: XPP3  
	    // pull parser library not present. Specify another driver. For example: new  
	    // XStream(new DomDriver())  
		XStream xStream = new XStream(new DomDriver());   
		xStream.alias("element", Element.class);   
		xStream.alias("error", Error.class);   
		xStream.alias("factor", Factor.class);   
		xStream.alias("param", Param.class);   
		xStream.alias("record", Record.class);   
		xStream.alias("verification", Verification.class);
		xStream.alias("request", Request.class);
		xStream.alias("process", Process.class);
		xStream.alias("result", Result.class);
		if(null!=xml&&!"".equals(xml)&&!"null".equals(xml)){
			object=xStream.fromXML(xml);
		}else{
			object=new Result();
		}
		
		return object;
	}
	/**
	 * 将对象转化成xml
	 * @param object
	 * @return
	 */
	public static String obToXml(Object object){
		
		String xml="";
		  // xstream = new XStream(); // XML转对象时报错 Exception in thread "main" java.lang.IllegalArgumentException: XPP3  
	    // pull parser library not present. Specify another driver. For example: new  
	    // XStream(new DomDriver())  
		XStream xStream = new XStream(new DomDriver());   
		xStream.alias("element", Element.class);   
		xStream.alias("error", Error.class);   
		xStream.alias("factor", Factor.class);   
		xStream.alias("param", Param.class);   
		xStream.alias("record", Record.class);  
		xStream.alias("verification", Verification.class);
		xStream.alias("request", Request.class);
		xStream.alias("process", Process.class);
		xStream.alias("result", Result.class);
		if(null!=object){
			xml=xStream.toXML(object);
		}
		return xml;
	}
}
