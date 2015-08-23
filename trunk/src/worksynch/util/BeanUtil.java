package worksynch.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import st.platform.db.sql.AbstractBasicBean;

public class BeanUtil {
	/**
	 * 取得javaBean了里面所有的字段名称
	 * @param object
	 * @return
	 */
	public static List<String> getFields(Object object){
		Class cla=object.getClass();
		 Field[] fields = cla.getDeclaredFields();
		 List<String> list=new ArrayList<String>();
		 for(int i=0;i<fields.length;i++){
			 String name=fields[i].getName();
			 list.add(name);
		 }
		return list;
		
	}
	/**
	 * 取得字段所对应的值
	 * @param object
	 * @return
	 */
	public static List<String> getValues2String(Object object){
		Class cla=object.getClass();
		 Field[] fields = cla.getDeclaredFields();
		 List<String> list=new ArrayList<String>();
		 Field.setAccessible(fields, true);      
		 for(int i=0;i<fields.length;i++){
			 String name=fields[i].getName();
			 String getMethodName = "get"+toFirstLetterUpperCase(name);
			 
			 try {
				 String value="";
				 if(null==fields[i].get(object)){
					 value="";
				 }else{
					 value=fields[i].get(object).toString();
				 }
				//System.out.println(str+"-----------");
				//String value = cla.getMethod(getMethodName).invoke(object).toString();
				list.add(value);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		 }
		return list;
	}
	/**
	 * 将属性及属性值放入sqlMaker中
	 * @param object
	 * @return
	 */
	public static void putSqlMaker(AbstractBasicBean object){
		Class cla=object.getClass();
		 Field[] fields = cla.getDeclaredFields();
		 Field.setAccessible(fields, true);      
		 for(int i=0;i<fields.length;i++){
			 String name=fields[i].getName();
			 if(!name.equals("serialVersionUID")&&!name.equals("TABLENAME")&&!name.equals("operate_mode")&&!name.equals("cf")){
				 String getMethodName = "get"+toFirstLetterUpperCase(name);
				 try {
					 String value="";
					// value = cla.getMethod(getMethodName).invoke(object).toString();
					// System.out.println(value);
					 if(null==fields[i].get(object)){
						 value="";
					 }else{
						 value=fields[i].get(object).toString();
					 }
					 //System.out.println("属性："+name+"----"+value);
					// objectsetSQLField(name, value);
					 object.getSqlMaker().setField(name, value, st.platform.db.sql.Field.TEXT);
					//String value = cla.getMethod(getMethodName).invoke(object).toString();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 }
			
		 }
		//return false;
	}
	
	
	/**
	 * 取得字段的数据类型
	 * @param object
	 * @return
	 */
	public static Hashtable getFieldsAndTypes(Object object){
		Class cla=object.getClass();
		 Field[] fields = cla.getDeclaredFields();
		 List<String> list=new ArrayList<String>();
		 Hashtable<String,String> ht=new Hashtable<String, String>();
		 for(int i=0;i<fields.length;i++){
			 String name=fields[i].getName();
			 String type = fields[i].getType().getName(); 
			 //System.out.println(type);
			 ht.put(name, type);
		 }
		return ht;
	}
	/**
	 * 取得javaBean 的名字
	 * @param object
	 * @return
	 */
	public static String getClassName(Object object){
		String name=object.getClass().getName().toString().replace(".", ",");
		System.out.println(name);
		
		String[] strs=name.split(",");
		System.out.println(strs.length);
		String str=strs[strs.length-1];
		return str.toLowerCase();
	}
	/**
	 * 将属性的第一个字母转换成大写
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
	
	public static Object setNull(Object model)   
    {   boolean b=false;
        try  
        {   
            Class class1 = model.getClass();
            Field[] fields = class1.getDeclaredFields();   
            for (int i = 0; i < fields.length; i++) {
            	String name = fields[i].getName();   
                String getMethodName = "get"+toFirstLetterUpperCase(name);   
                String setMethodName = "set"+toFirstLetterUpperCase(name); 
                try{   
                    //Object value = class2.getMethod(getMethodName).invoke(model2);   
                    class1.getMethod(setMethodName, new Class[]{String.class}).invoke(model, new Object[]{""}); 
                    b=true;
                 }catch(Exception e){   
                
                 }   

            }
            
        }   
        catch(Exception e)   
        {   
            e.printStackTrace();
          
        }
		return model;
    }

	public static void main(String[] args) {
		
	}
}
