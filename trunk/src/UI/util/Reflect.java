package UI.util;

import java.lang.reflect.Field;

import st.platform.db.SerialNumber;

import UI.dao.enterfile.QyjbqkBean;
import UI.dao.zyjk.Z_corBean;

public class Reflect {

	public static boolean setVOFromForm(Object model1,Object model2)   
    {   boolean b=false;
        try  
        {   
            Class class1 = model1.getClass();
            Class class2 = model2.getClass();
            Field[] fields = class1.getDeclaredFields();   
            for (int i = 0; i < fields.length; i++) {
            	String name = fields[i].getName();   
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
        catch(Exception e)   
        {   
            e.printStackTrace();
          
        }
		return b;
    }
	//����ʽ���е���Ϣ�ŵ���ʷ��
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
	//��ʷ������ʽ���и������
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
	
	//��ʷ������ʷ���и�����ݣ������old�ֶ�
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
	//��ʷ���Լ������ֶ���ݸ��Ƶ����ֶΣ����ҽ����ֶ��ƿ�
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

	
	public static void main(String[] args) {
//		RatingagenciesinfoBean ratingagenciesinfoBean=new RatingagenciesinfoBean();
//		Ratingagenciesinfo_chistoryBean rc=new Ratingagenciesinfo_chistoryBean();
		
//		rc.setNewassets("qwert");
//		ratingagenciesinfoBean.setLicense("sadasdasdasdasdas");
		
//		Reflect.setChangeNew(ratingagenciesinfoBean, rc);
		//System.out.println("===================="+ratingagenciesinfoBean.getAssets());
		
		try {
			Z_corBean z_corBean=new Z_corBean();
			QyjbqkBean qyjbqkBean=new QyjbqkBean();
			String number = BusinessDate.getNoFormatToday() + "-"
			+ SerialNumber.getNextSerialNo("67");
			qyjbqkBean.setEnterno(number);
			z_corBean=z_corBean.findFirst(" where corpkey='053287706862'");
			Reflect.setVOFromForm(qyjbqkBean, z_corBean);
			//System.out.println("===================="+qyjbqkBean.getDwmc());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
