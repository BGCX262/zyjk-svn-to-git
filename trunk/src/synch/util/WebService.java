package synch.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.codehaus.xfire.client.Client;

import st.platform.utils.Config;
import synch.beans.Element;
import synch.beans.Record;
import synch.beans.Result;
import synch.dao.Z_corBean;

public class WebService {
	/**
	 * 使用axis调用webservice
	 * @param method
	 * @param params
	 * @param oos
	 * @return
	 */
	public static String service(String method,String[] params ,Object[] oos){
			String result="";
		     try {
	           String endpoint = Config.getProperty("webservice");//webservice地址
	           
	           Service service=null;
	           try{
	        	   service = new Service();
	           }catch (Exception e) {
				// TODO: handle exception
	        	   e.printStackTrace();
			}
	          
	           Call call = (Call) service.createCall();
	           call.setTargetEndpointAddress(new java.net.URL(endpoint));
	           
	           
	           call.setOperationName(new QName("http://tempuri.org/", method));//WSDL里面描述的接口名称,调用的方法
	         
//	           call.addParameter(new QName("http://tempuri.org/","col"), org.apache.axis.encoding.XMLType.XSD_STRING,
//	                         javax.xml.rpc.ParameterMode.IN);//接口的参数
//	           call.addParameter(new QName("http://tempuri.org/","whereStr"), org.apache.axis.encoding.XMLType.XSD_STRING,
//	                   javax.xml.rpc.ParameterMode.IN);//接口的参数
	           //定义接口的参数
	           for(int i=0;i<params.length;i++){
		           call.addParameter(new QName("http://tempuri.org/",params[i]), org.apache.axis.encoding.XMLType.XSD_STRING,
                   javax.xml.rpc.ParameterMode.IN);//接口的参数
	           }
	           
	           call.setUseSOAPAction(true);//开启协议
	           call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型  
	           call.setSOAPActionURI("http://tempuri.org/"+method);
	           result = (String)call.invoke(oos);
	
	    }catch (Exception e) {
	   	 	e.printStackTrace();
	           System.err.println(e.toString());
	
	    }
	    return result;
		
	}
	/**
	 * 使用xfire调用webservice服务
	 * @param method
	 * @param params
	 * @param oos
	 * @return
	 */
	public static String xfireService(String method,String[] params ,Object[] oos){
		String result="";
		String serivceURL = Config.getProperty("webservice")+"?wsdl";
		
        //String[] params = {"52","","","","","admin|admin"};
        Object[] res = {}; 
        try {
        	Client client = new Client(new URL(serivceURL));
			res = client.invoke(method, oos);
			result=res[0].toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

	public static void main(String[] args) throws MalformedURLException, IOException {
		String serivceURL = Config.getProperty("webservice")+"?wsdl";
		
		System.out.println( new URL(serivceURL).getContent());
	}
}
