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
	 * ʹ��axis����webservice
	 * @param method
	 * @param params
	 * @param oos
	 * @return
	 */
	public static String service(String method,String[] params ,Object[] oos){
			String result="";
		     try {
	           String endpoint = Config.getProperty("webservice");//webservice��ַ
	           
	           Service service=null;
	           try{
	        	   service = new Service();
	           }catch (Exception e) {
				// TODO: handle exception
	        	   e.printStackTrace();
			}
	          
	           Call call = (Call) service.createCall();
	           call.setTargetEndpointAddress(new java.net.URL(endpoint));
	           
	           
	           call.setOperationName(new QName("http://tempuri.org/", method));//WSDL���������Ľӿ�����,���õķ���
	         
//	           call.addParameter(new QName("http://tempuri.org/","col"), org.apache.axis.encoding.XMLType.XSD_STRING,
//	                         javax.xml.rpc.ParameterMode.IN);//�ӿڵĲ���
//	           call.addParameter(new QName("http://tempuri.org/","whereStr"), org.apache.axis.encoding.XMLType.XSD_STRING,
//	                   javax.xml.rpc.ParameterMode.IN);//�ӿڵĲ���
	           //����ӿڵĲ���
	           for(int i=0;i<params.length;i++){
		           call.addParameter(new QName("http://tempuri.org/",params[i]), org.apache.axis.encoding.XMLType.XSD_STRING,
                   javax.xml.rpc.ParameterMode.IN);//�ӿڵĲ���
	           }
	           
	           call.setUseSOAPAction(true);//����Э��
	           call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//���÷�������  
	           call.setSOAPActionURI("http://tempuri.org/"+method);
	           result = (String)call.invoke(oos);
	
	    }catch (Exception e) {
	   	 	e.printStackTrace();
	           System.err.println(e.toString());
	
	    }
	    return result;
		
	}
	/**
	 * ʹ��xfire����webservice����
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
