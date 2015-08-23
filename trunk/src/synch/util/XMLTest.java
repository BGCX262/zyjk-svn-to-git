package synch.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import synch.beans.Element;
import synch.beans.Error;
import synch.beans.Factor;
import synch.beans.Param;
import synch.beans.Record;
import synch.beans.Request;
import synch.beans.Result;
import synch.beans.Verification;
import synch.dao.Z_corBean;

import com.thoughtworks.xstream.XStream;


public class XMLTest {

	public static void main(String[] args) {
		 try {
			FileInputStream fileInputStream=new FileInputStream(new File("G://c.xml"));
			/////////////////////////////
			String xml="<?xml version='1.0' encoding='GB2312'?><result> <process> <number>number</number> <code>code</code> <message>message</message> <tablename>aa</tablename> </process> <records> <record> <elements> <element> <name>corpkey</name> <value>abc11111111 </value> </element> <element> <name>dwmc</name> <value>������ĳ��ҵ</value> </element> <element> <name>jcdate</name> <value>1990-1-1 0:00:00</value> </element> <element> <name>zcdz</name> <value>abc</value> </element> <element> <name>zcyzbm</name> <value>100001</value> </element> <element> <name>csdz</name> <value>zycsdz</value> </element> <element> <name>csyzbm</name> <value>100001</value> </element> <element> <name>leader</name> <value>daibiao</value> </element> <element> <name>lxdh</name> <value>325326</value> </element> <element> <name>hyfl1</name> <value>03</value> </element> <element> <name>hyfl2</name> <value>0328</value> </element> <element> <name>hyfl</name> <value>03282</value> </element> <element> <name>zclx</name> <value>110</value> </element> <element> <name>tblb</name> <value>��һ���걨</value> </element> <element> <name>zywsjg</name> <value>��Ҳ</value> </element> <element> <name>zywsleader</name> <value>����</value> </element> <element> <name>zywslxdh</name> <value>32521532</value> </element> <element> <name>bgyy</name> <value> </value> </element> <element> <name>qtbgyy</name> <value> </value> </element> <element> <name>nmzgrs</name> <value>200</value> </element> <element> <name>scwomen</name> <value>0</value> </element> <element> <name>scnongmin</name> <value>0</value> </element> <element> <name>whrenshu</name> <value>180</value> </element> <element> <name>whwomen</name> <value>0</value> </element> <element> <name>whnongmin</name> <value>0</value> </element> <element> <name>tjrenshu</name> <value>120</value> </element> <element> <name>zybrenshu</name> <value>0</value> </element> <element> <name>dlrenshu</name> <value>0</value> </element> <element> <name>tjrenshu2</name> <value>0</value> </element> <element> <name>tjrenshu3</name> <value>0</value> </element> <element> <name>zybrenshuxz</name> <value>0</value> </element> <element> <name>zybrenshuys</name> <value>0</value> </element> <element> <name>pxrenshu</name> <value>120</value> </element> <element> <name>swrenshu</name> <value>0</value> </element> <element> <name>swrenshuxz</name> <value>0</value> </element> <element> <name>zhuguan</name> <value>������ҵ</value> </element> <element> <name>zywsjgshu</name> <value>0</value> </element> <element> <name>zywsgl</name> <value>1</value> </element> <element> <name>chanzhi</name> <value>2144</value> </element> <element> <name>zichan</name> <value>3432</value> </element> <element> <name>sbren</name> <value>���</value> </element> <element> <name>sbrendh</name> <value>3215215326</value> </element> <element> <name>ystbbm</name> <value> </value> </element> <element> <name>ystbren</name> <value> </value> </element> <element> <name>ysshren</name> <value> </value> </element> <element> <name>ystbdate</name> <value>2010-10-20 0:00:00</value> </element> <element> <name>ysjiancejg</name> <value>sdgsaewa</value> </element> <element> <name>ysjiancedate</name> <value>2009-11-1 0:00:00</value> </element> <element> <name>gltbbm</name> <value> </value> </element> <element> <name>gltbren</name> <value> </value> </element> <element> <name>gltbdate</name> <value>1900-1-1 0:00:00</value> </element> <element> <name>glpeixunjg</name> <value>rewtewtw</value> </element> <element> <name>glpeixundate</name> <value>2009-1-1 0:00:00</value> </element> <element> <name>gltijianjg</name> <value>wqtwtwqt</value> </element> <element> <name>gltijiandate</name> <value>2009-12-1 0:00:00</value> </element> <element> <name>liuchengID</name> <value>3</value> </element> <element> <name>tbliucheng</name> <value>13452</value> </element> <element> <name>DQ1</name> <value>43</value> </element> <element> <name>DQ2</name> <value>4301</value> </element> <element> <name>DQ3</name> <value>430171</value> </element> <element> <name>scyj1</name> <value> </value> </element> <element> <name>scyj2</name> <value> </value> </element> <element> <name>scyj3</name> <value>ͬ�ⱸ����</value> </element> <element> <name>scdate1</name> <value>1900-1-1 0:00:00</value> </element> <element> <name>scdate2</name> <value>1900-1-1 0:00:00</value> </element> <element> <name>scdate3</name> <value>2010-10-20 9:59:02</value> </element> <element> <name>sbyes</name> <value>s</value> </element> <element> <name>beiandate</name> <value>2010-10-20 10:02:27</value> </element> <element> <name>beianhao</name> <value>(��ɳ��)��ְ��(2010)��000001��</value> </element> <element> <name>scyj0</name> <value> </value> </element> <element> <name>scdate0</name> <value>1900-1-1 0:00:00</value> </element> </elements> </record> <record> <elements> <element> <name>corpkey</name> <value>123456789ylj </value> </element> <element> <name>dwmc</name> <value>yljtest1</value> </element> <element> <name>jcdate</name> <value>1999-1-1 0:00:00</value> </element> <element> <name>zcdz</name> <value>dsdssfd</value> </element> <element> <name>zcyzbm</name> <value>111111</value> </element> <element> <name>csdz</name> <value>dfdff</value> </element> <element> <name>csyzbm</name> <value>11111</value> </element> <element> <name>leader</name> <value>111</value> </element> <element> <name>lxdh</name> <value>ewrerew</value> </element> <element> <name>hyfl1</name> <value>02</value> </element> <element> <name>hyfl2</name> <value>0210</value> </element> <element> <name>hyfl</name> <value>02101</value> </element> <element> <name>zclx</name> <value>110</value> </element> <element> <name>tblb</name> <value>��һ���걨</value> </element> <element> <name>zywsjg</name> <value> </value> </element> <element> <name>zywsleader</name> <value> </value> </element> <element> <name>zywslxdh</name> <value> </value> </element> <element> <name>bgyy</name> <value> </value> </element> <element> <name>qtbgyy</name> <value> </value> </element> <element> <name>nmzgrs</name> <value>120</value> </element> <element> <name>scwomen</name> <value>0</value> </element> <element> <name>scnongmin</name> <value>0</value> </element> <element> <name>whrenshu</name> <value>100</value> </element> <element> <name>whwomen</name> <value>0</value> </element> <element> <name>whnongmin</name> <value>0</value> </element> <element> <name>tjrenshu</name> <value>0</value> </element> <element> <name>zybrenshu</name> <value>0</value> </element> <element> <name>dlrenshu</name> <value>0</value> </element> <element> <name>tjrenshu2</name> <value>0</value> </element> <element> <name>tjrenshu3</name> <value>0</value> </element> <element> <name>zybrenshuxz</name> <value>0</value> </element> <element> <name>zybrenshuys</name> <value>0</value> </element> <element> <name>pxrenshu</name> <value>0</value> </element> <element> <name>swrenshu</name> <value>0</value> </element> <element> <name>swrenshuxz</name> <value>0</value> </element> <element> <name>zhuguan</name> <value>������ҵ</value> </element> <element> <name>zywsjgshu</name> <value>0</value> </element> <element> <name>zywsgl</name> <value>0</value> </element> <element> <name>chanzhi</name> <value>12345</value> </element> <element> <name>zichan</name> <value>1234</value> </element> <element> <name>sbren</name> <value>erty</value> </element> <element> <name>sbrendh</name> <value>34666</value> </element> <element> <name>ystbbm</name> <value> </value> </element> <element> <name>ystbren</name> <value> </value> </element> <element> <name>ysshren</name> <value> </value> </element> <element> <name>ystbdate</name> <value>2010-10-22 0:00:00</value> </element> <element> <name>ysjiancejg</name> <value> </value> </element> <element> <name>ysjiancedate</name> <value>1900-1-1 0:00:00</value> </element> <element> <name>gltbbm</name> <value> </value> </element> <element> <name>gltbren</name> <value> </value> </element> <element> <name>gltbdate</name> <value>1900-1-1 0:00:00</value> </element> <element> <name>glpeixunjg</name> <value> </value> </element> <element> <name>glpeixundate</name> <value>1900-1-1 0:00:00</value> </element> <element> <name>gltijianjg</name> <value> </value> </element> <element> <name>gltijiandate</name> <value>1900-1-1 0:00:00</value> </element> <element> <name>liuchengID</name> <value>1</value> </element> <element> <name>tbliucheng</name> <value>1345</value> </element> <element> <name>DQ1</name> <value>12</value> </element> <element> <name>DQ2</name> <value>1201</value> </element> <element> <name>DQ3</name> <value>120109</value> </element> <element> <name>scyj1</name> <value>ͬ�ⱸ����</value> </element> <element> <name>scyj2</name> <value> </value> </element> <element> <name>scyj3</name> <value> </value> </element> <element> <name>scdate1</name> <value>2010-10-22 13:51:25</value> </element> <element> <name>scdate2</name> <value>1900-1-1 0:00:00</value> </element> <element> <name>scdate3</name> <value>1900-1-1 0:00:00</value> </element> <element> <name>sbyes</name> <value>s</value> </element> <element> <name>beiandate</name> <value>2010-10-22 13:51:49</value> </element> <element> <name>beianhao</name> <value>(��)��ְ��(2010)��000001��</value> </element> <element> <name>scyj0</name> <value> </value> </element> <element> <name>scdate0</name> <value>1900-1-1 0:00:00</value> </element> </elements> </record> </records> </result>";
			XStream xStream = new XStream();   
			xStream.alias("element", Element.class);   
			xStream.alias("error", Error.class);   
			xStream.alias("factor", Factor.class);   
			xStream.alias("param", Param.class);   
			xStream.alias("record", Record.class);   
			xStream.alias("verification", Verification.class);
			xStream.alias("request", Request.class);
			xStream.alias("process", synch.beans.Process.class);
			xStream.alias("result", Result.class);
			Result result=(Result)xStream.fromXML(xml);
			List<Record> list=result.getRecords();
			
			for(int i=0;i<list.size();i++){
				System.out.println(list.size());
				Record r=list.get(i);
				List<Element> es=r.getElements();
				Object oo=Reflect.creatObject("Z_cor", es);
				Z_corBean zb=(Z_corBean)oo;
				System.out.println("corkey====="+zb.getCorpkey());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	       // Person person1=(Person)xStream.fromXML(fileInputStream);  
	      //  Person person1=(Person)xStream.fromXML(xml); 
	}
}
