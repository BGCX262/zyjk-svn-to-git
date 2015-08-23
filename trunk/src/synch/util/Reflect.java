package synch.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import synch.beans.Element;
import synch.dao.B_corBean;
import synch.dao.B_pxtjBean;
import synch.dao.B_scclBean;
import synch.dao.B_sccpBean;
import synch.dao.B_sczjBean;
import synch.dao.B_siteBean;
import synch.dao.B_whBean;
import synch.dao.T_corBean;
import synch.dao.T_pxtjBean;
import synch.dao.T_scclBean;
import synch.dao.T_sccpBean;
import synch.dao.T_sczjBean;
import synch.dao.T_siteBean;
import synch.dao.T_whBean;
import synch.dao.Z_corBean;
import synch.dao.Z_pxtjBean;
import synch.dao.Z_scclBean;
import synch.dao.Z_sccpBean;
import synch.dao.Z_sczjBean;
import synch.dao.Z_siteBean;
import synch.dao.Z_whBean;
/**
 * 处理结果集的反射类
 * @author jmx
 *
 */
public class Reflect {

	private Map<String,String> tables;
	
	
	
	public Reflect() {
		
	}

	
	/**
	 * 根据表名table，元素List<Element>返回相应的java bean对象
	 * @param table
	 * @param list
	 * @return
	 */
	public static Object creatObject(String table,List<Element> list){
		Object object=new Object();
		object=Reflect.getTable(table);
		Class model = object.getClass();
		Field[] fields = model.getDeclaredFields();  
		if(null!=list&&list.size()>0){
			for(int i=0;i<list.size();i++){
				Element e=list.get(i);
				String name=e.getName();
				String value=e.getValue();
				//System.out.println(value);
				String setMethodName = "set"+toFirstLetterUpperCase(tolowercase(name)); 
				try {
					model.getMethod(setMethodName, value.getClass()).invoke(object, value);
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		}
		
		return object;
	}
	/**
	 * 根据表明name的值取得相对应的对象
	 * @param name
	 * @return
	 */
	private static Object getTable(String name){
		Map<String,Object> map=new HashMap<String,Object>();
		
		Z_corBean zc=new Z_corBean();
		map.put("Z_cor", zc);
		
		Z_pxtjBean zp=new Z_pxtjBean();
		map.put("Z_pxtj", zp);
		
		Z_scclBean zs=new Z_scclBean();
		map.put("Z_sccl", zs);
		
		Z_sccpBean zsc=new Z_sccpBean();
		map.put("Z_sccp", zsc);
		
		Z_sczjBean zscz=new Z_sczjBean();
		map.put("Z_sczj", zscz);
		
		Z_siteBean zsi=new Z_siteBean();
		map.put("Z_site", zsi);
		
		Z_whBean zw=new Z_whBean();
		map.put("Z_wh", zw);
		
		B_corBean bc=new B_corBean();
		map.put("B_cor", bc);
		
		B_pxtjBean bp=new B_pxtjBean();
		map.put("B_pxtj", bp);
		
		B_scclBean bs=new B_scclBean();
		map.put("B_sccl", bs);
		
		B_sccpBean bsc=new B_sccpBean();
		map.put("B_sccp", bsc);
		
		B_sczjBean bscz=new B_sczjBean();
		map.put("B_sczj", bscz);
		
		B_siteBean bsi=new B_siteBean();
		map.put("B_site", bsi);
		
		B_whBean bw=new B_whBean();
		map.put("B_wh", bw);
		
		T_corBean tc=new T_corBean();
		map.put("T_cor", tc);
		
		T_pxtjBean tp=new T_pxtjBean();
		map.put("T_pxtj", tp);
		
		T_scclBean ts=new T_scclBean();
		map.put("T_sccl", ts);
		
		T_sccpBean tsc=new T_sccpBean();
		map.put("T_sccp", tsc);
		
		T_sczjBean tscz=new T_sczjBean();
		map.put("T_sczj", tscz);
		
		T_siteBean tsi=new T_siteBean();
		map.put("T_site", tsi);
		
		T_whBean tw=new T_whBean();
		map.put("T_wh", tw);
		
		Object oo=map.get(name);
		
		return oo;
	}
	
	public static String tolowercase (String name)
	{
		
		return name=name.toLowerCase();
		
	}
	
	public static String toFirstLetterUpperCase(String str) {   
	    if(str == null || str.length() < 2){   
	        return str;   
	    }   
	     String firstLetter = str.substring(0, 1).toUpperCase();   
	     return firstLetter + str.substring(1, str.length());   
	 }   
}
