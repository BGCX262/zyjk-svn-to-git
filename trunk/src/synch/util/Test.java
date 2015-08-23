package synch.util;

import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import synch.beans.Element;
import synch.beans.Record;
import synch.beans.Result;
import synch.dao.Z_corBean;

public class Test {
	public static void main(String[] args) {

	     try {

            String endpoint = "http://192.168.9.56/zyjkSvc/Service.asmx";

            //直接引用远程的wsdl文件

           //以下都是套路 
            Service service = new Service();

            Call call = (Call) service.createCall();

            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            
           
            call.setOperationName(new QName("http://tempuri.org/", "Z_cor_ba"));//WSDL里面描述的接口名称
            
            String[] params={"dqid","st","et","col","page","userpwd"};
    		String[] ads={"admin","admin"};
    		Object[] oos={"12"," "," "," "," ",ads};

          //  call.removeAllParameters();
            
//            call.addParameter(new QName("http://tempuri.org/","col"), org.apache.axis.encoding.XMLType.XSD_STRING,
//
//                          javax.xml.rpc.ParameterMode.IN);//接口的参数
//            call.addParameter(new QName("http://tempuri.org/","whereStr"), org.apache.axis.encoding.XMLType.XSD_STRING,
//
//                    javax.xml.rpc.ParameterMode.IN);//接口的参数
            
            for(int i=0;i<params.length;i++){
              call.addParameter(new QName("http://tempuri.org/",params[i]), org.apache.axis.encoding.XMLType.XSD_STRING,
           	                    javax.xml.rpc.ParameterMode.IN);//接口的参数
            }
            
            
            call.setUseSOAPAction(true);
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);//设置返回类型  


            call.setSOAPActionURI("http://tempuri.org/"+"Z_cor_ba");

            String result = (String)call.invoke(oos);
            System.out.println("result is "+result);
//            Result rs= (Result)XmlToObject.xmlToOb(result);
//            System.out.println("result is "+result);
//            List<Record> list=rs.getRecords();
//			
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.size());
//				Record r=list.get(i);
//				List<Element> es=r.getElements();
//				Object oo=Reflect.creatObject("Z_cor", es);
//				Z_corBean zb=(Z_corBean)oo;
//				System.out.println("corkey====="+zb.getCorpkey());
//			}

     }

     catch (Exception e) {
    	 	e.printStackTrace();
            System.err.println(e.toString());

     }

}


}
