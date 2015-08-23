package synch.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import synch.beans.Element;
import synch.beans.Error;
import synch.beans.Record;
import synch.beans.Result;

public class Util {
	/**
	 * ��������ʱ��������ݣ�������Ķ��󷵻�Result��ת����XML�����ظ�������
	 * @param list
	 * @param errcode
	 * @param method
	 * @return
	 */
	public static String createErrorResult(List list,String errcode,String method){
		
		List<Record> res=new ArrayList<Record>();
		for(int i=0;i<res.size();i++){
			Object obj=res.get(i);
			List<Element> els=TurnObject.turn(obj);
			Record rec=new Record();
			rec.setElements(els);
			res.add(rec);
		}
		Result rs=new Result();
		rs.setRecords(res);
		Error err=new Error();
		err.setErrorcode(errcode);
		err.setErrormessage("�������ݳ���");
		err.setErrormethod(method);
		rs.setError(err);
		String xml=XmlToObject.obToXml(rs);
		return xml;
	}

	/**
	 * ����xml���������"."�滻���ַ�
	 * @param xml
	 * @return
	 */
	public static String replaceD(String xml){
		if(null!=xml&&!"".equals(xml)&&!"null".equals(xml)){
			xml=xml.replace("", "&#x7;");
		}
		return xml;
		
	} 
	/**
	 * ʱ�䴦��
	 * @param num
	 * @return
	 */
	public static  String getTime(int num){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.add(Calendar.MONTH, num);
        return simpleDateFormat.format(calender.getTime()); 
	}
	public static void main(String[] args) {
		System.out.println(Integer.parseInt("-1"));
	}
}
