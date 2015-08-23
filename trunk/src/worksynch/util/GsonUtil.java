package worksynch.util;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import st.platform.db.sql.AbstractBasicBean;

import UI.dao.enterfile.QyjbqkBean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonUtil {
	
	 private static Gson gson =  new Gson();
	 
	 private static GsonBuilder gsonBuilder = new GsonBuilder();
	 
	
	 /**
	  * 将对象转换成Json字符串
	  * @param obj
	  */
	public static String  beanToJson(Object obj){
		
		String json = gson.toJson(obj);
		 
	     System.out.println(json);
	     
	     return json.toString();
	}
	
	/**
	 * 将Json字符串转换成对象
	 * @param json
	 * @param obj
	 */
	public static Object jsonToObject(String json,String classname){
		Class<?>  forName = null;
		Object object = null;
		try {
			forName = Class.forName(classname);
			object = forName.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		object = gson.fromJson(json, object.getClass());
	 
		//System.out.println(object);
		 
		return object;
	     //System.out.println(json);
	}
	
	/**
	 * 将list转换成json字符串
	 * @param list
	 * @return
	 */
	public static String listToJson(List<Object> list){
		
			//泛型List -> Json
		 
	       java.lang.reflect.Type type =new TypeToken<List<Object>>(){}.getType();
	 
	       String json = gson.toJson(list, type);
	 
	       System.out.println(json);  
	     
	     return json.toString();
	}

	/**
	 * 将json串转换成list对象
	 * @param json
	 * @param list
	 * @return
	 */
	public static List<Object> jsonToList(String json,List<Object> list){
			// Json -> 泛型List
		  java.lang.reflect.Type type =new com.google.gson.reflect.TypeToken<List<Object>>(){}.getType();
	      list = gson.fromJson(json.toString(), type);
	 
	      return list;
	}
	/**
	 * 将Map转换成json串
	 * @param map
	 * @return
	 */
	public static String mapToJson(Map<Object,Object> map){
			//泛型Map -> Json
	       java.lang.reflect.Type type =new com.google.gson.reflect.TypeToken<Map<Object, Object>>(){}.getType();
	 
	       String json = gson.toJson(map, type);
	 
	       System.out.println(json); 
	     
	       return json;
	}
	/**
	 * 将json转换成map
	 * @param json
	 * @param map
	 * @return
	 */
	public static Map<Object,Object> jsonToMap(String json,Map<Object,Object> map){
		java.lang.reflect.Type type =new com.google.gson.reflect.TypeToken<Map<Object, Object>>(){}.getType();
		map=gson.fromJson(json, type);
		return map;
	}
	
	 /**
	  * 将对象转换成Json字符串，带日期格式
	  * @param obj
	  */
	public static String  beanToJsonDate(Object obj){
		
		gson = gsonBuilder.registerTypeAdapter(java.util.Date.class,
				 
	              new DateSerializerUtils()).setDateFormat(DateFormat.LONG).create();
		String json = gson.toJson(obj);
		 
	     System.out.println(json);
	     
	     return json.toString();
	}
	
	/**
	 * 将Json字符串转换成对象，带日期格式
	 * @param json
	 * @param obj
	 */
	public static Object jsonToObjectDate(String json,Object obj){
		gson = gsonBuilder.registerTypeAdapter(java.util.Date.class,
				 
	              new DateDeserializerUtils()).setDateFormat(DateFormat.LONG).create();
		
		obj = gson.fromJson(json, Object.class);
	 
		System.out.println(obj);
		 
		return obj;
	     //System.out.println(json);
	}
	
	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		QyjbqkBean qyjbqk=new QyjbqkBean();
		try {
			qyjbqk=qyjbqk.findFirst(" where enterno='20130725-20130010452'");
			String json=GsonUtil.beanToJson(qyjbqk);
			//System.out.println(json);
			//AbstractBasicBean obj=new QyjbqkBean();
			AbstractBasicBean obj=(AbstractBasicBean)GsonUtil.jsonToObject(json, "UI.dao.enterfile.QyjbqkBean");
			System.out.println(obj);
			
//			 Class<?> forName = Class.forName("UI.dao.enterfile.QyjbqkBean");
//			 
//			 System.out.println(forName.newInstance());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
