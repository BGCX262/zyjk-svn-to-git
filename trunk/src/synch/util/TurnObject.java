package synch.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import synch.beans.Element;
import synch.dao.Z_corBean;

public class TurnObject {
	/**
	 * 将对象转换成List<Element>；
	 * @param object
	 * @return
	 */
	public static List<Element> turn(Object object){
		List<Element> list=new ArrayList<Element>();
		Class model = object.getClass();
		Field[] fields = model.getDeclaredFields();  
		for(int i=0;i<fields.length;i++){
			String name = fields[i].getName();   
			if(!"TABLENAME,operate_mode,cf".contains(name)){
	            String getMethodName = "get"+toFirstLetterUpperCase(name);   
	            String setMethodName = "set"+toFirstLetterUpperCase(name); 	
	            try {
					Object value = model.getMethod(getMethodName).invoke(object);
					Element e=new Element();
					e.setName(name);
					e.setValue(value.toString());
					list.add(e);
					//System.out.println(name+"-----"+value.toString());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
		return list;
	}
	/**
	 * 大写转小写
	 * @param name
	 * @return
	 */
	public static String tolowercase (String name)
	{
		
		return name=name.toLowerCase();
		
	}
	/**
	 * 将首字母大写
	 * @param str
	 * @return
	 */
	public static String toFirstLetterUpperCase(String str) {   
	    if(str == null || str.length() < 2){   
	        return str;   
	    }   
	     String firstLetter = str.substring(0, 1).toUpperCase();   
	     return firstLetter + str.substring(1, str.length());   
	 }   
	public static void main(String[] args) throws SQLException, Exception {
		Z_corBean zc=new Z_corBean();
		zc=(Z_corBean)zc.findFirstByWhere(" where corpkey='1376523106'");
		TurnObject.turn(zc);
	}
}
