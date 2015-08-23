package synch.util;

import java.lang.reflect.Field;

public class CopyReflect {
	
/**
 * 将对象model2复制到model1
 * @param model1
 * @param model2
 * @return
 */
	public static boolean setVOFromForm(Object model1,Object model2)   
    {   boolean b=false;
    	if(null!=model1&&null!=model2){
    		 try  
    	        {   
    	            Class class1 = model1.getClass();
    	            Class class2 = model2.getClass();
    	            Field[] fields = class1.getDeclaredFields();   
    	            for (int i = 0; i < fields.length; i++) {
    	            	String name = fields[i].getName();
    		            if(!"TABLENAME,operate_mode,cf".contains(name)){
    			                String getMethodName = "get"+toFirstLetterUpperCase(name);   
    			                String setMethodName = "set"+toFirstLetterUpperCase(name); 
    			                try{   
    			                    Object value = class2.getMethod(getMethodName).invoke(model2);   
    			                    class1.getMethod(setMethodName, value.getClass()).invoke(model1, value); 
    			                    b=true;
    			                 }catch(Exception e){   
    			                
    			                 }   
    			
    		            }
    	            }
    	        }   
    	        catch(Exception e)   
    	        {   
    	            e.printStackTrace();
    	          
    	        }
    	}
       
		return b;
    }
	//将正式表中的信息放到历史表
	public static boolean setChange(Object model1,Object model2)   
    {   boolean b=false;
        try  
        {   
            Class class1 = model1.getClass();
            Class class2 = model2.getClass();
            Field[] fields = class2.getDeclaredFields();   
            for (int i = 0; i < fields.length; i++) {
            	String name = fields[i].getName();   
            	if(name.startsWith("new")){
            		String getMethodName = "get"+toFirstLetterUpperCase(name.substring(3, name.length()));   
                    String setMethodName = "set"+toFirstLetterUpperCase(name); 
            		try{   
                        Object value = class1.getMethod(getMethodName).invoke(model1);   
                        class2.getMethod(setMethodName, value.getClass()).invoke(model2, value);  
                        b=true;
                     }catch(Exception e){   
                    
                     }   
            	}
                
                

            }
            
        }   
        catch(Exception e)   
        {   
            e.printStackTrace();
          
        }
		return b;
    }
	//历史表向正式表中更新数据
	public static boolean setChangeNew(Object model1,Object model2)   
    {   boolean b=false;
        try  
        {   
            Class class1 = model1.getClass();
            Class class2 = model2.getClass();
            Field[] fields = class2.getDeclaredFields();   
            for (int i = 0; i < fields.length; i++) {
            	String name = fields[i].getName();   
            	if(name.startsWith("new")){
            		String getMethodName = "get"+toFirstLetterUpperCase(name);   
                    String setMethodName = "set"+toFirstLetterUpperCase(name.substring(3, name.length())); 
            		try{   
                        Object value = class2.getMethod(getMethodName).invoke(model2);   
                        class1.getMethod(setMethodName, value.getClass()).invoke(model1, value);  
                        b=true;
                     }catch(Exception e){   
                    
                     }   
            	}
            }
            
        }   
        catch(Exception e)   
        {   
            e.printStackTrace();
          
        }
		return b;
    }
	
	//历史表向历史表中更新数据，并清空old字段
	public static boolean exchangeNew(Object model1,Object model2)   
	 {   boolean b=false;
     try  
     {   
         Class class1 = model1.getClass();
         Class class2 = model2.getClass();
         Field[] fields = class2.getDeclaredFields();   
         for (int i = 0; i < fields.length; i++) {
         	String name = fields[i].getName();   
         	if(name.startsWith("new")){
         		String getMethodName = "get"+toFirstLetterUpperCase(name.substring(3, name.length()));   
         		String setMethod = "set"+toFirstLetterUpperCase(name.substring(3, name.length())); 
                 String setMethodName = "set"+toFirstLetterUpperCase(name); 
         		try{   
                     Object value = class1.getMethod(getMethodName).invoke(model1);   
                     class2.getMethod(setMethodName, value.getClass()).invoke(model2, value); 
                     class2.getMethod(setMethod, value.getClass()).invoke(model2, "");
                     b=true;
                  }catch(Exception e){   
                 
                  }   
         	}
             
             

         }
         
     }   
     catch(Exception e)   
     {   
         e.printStackTrace();
       
     }
		return b;
    }
	//历史表自己将新字段数据复制到老字段，并且将新字段制空
	public static boolean exchangeNew(Object model1)   
	 {   boolean b=false;
     try  
     {   
         Class class1 = model1.getClass(); 
         Field[] fields = class1.getDeclaredFields();   
         for (int i = 0; i < fields.length; i++) {
         	String name = fields[i].getName();   
         	if(name.startsWith("new")){
         		String getMethodName = "get"+toFirstLetterUpperCase(name);   
         		String setMethod = "set"+toFirstLetterUpperCase(name.substring(3, name.length())); 
                 String setMethodName = "set"+toFirstLetterUpperCase(name); 
         		try{   
                     Object value = class1.getMethod(getMethodName).invoke(model1);   
                     class1.getMethod(setMethod, value.getClass()).invoke(model1, value); 
                     class1.getMethod(setMethodName, value.getClass()).invoke(model1, "");
                     b=true;
                  }catch(Exception e){   
                 
                  }   
         	}
             
             

         }
         
     }   
     catch(Exception e)   
     {   
         e.printStackTrace();
       
     }
		return b;
    }
	
	public static String tolowercase (String name)
	{
		
		return name=((name.substring(3, 4)).toLowerCase())+name.substring(4);
		
	}
	
	public static String toFirstLetterUpperCase(String str) {   
	    if(str == null || str.length() < 2){   
	        return str;   
	    }   
	     String firstLetter = str.substring(0, 1).toUpperCase();   
	     return firstLetter + str.substring(1, str.length());   
	 }   

	
}
