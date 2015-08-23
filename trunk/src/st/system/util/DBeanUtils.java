package st.system.util;



import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
public class DBeanUtils {
	
	public static boolean setVOFromForm(Map<String,Object> request, Object model)   
    {   boolean b=false;
        try  
        {   
            Class class1 = model.getClass();
            Method method1[] = class1.getMethods();
            for(int i = 0; i < method1.length; i++)   
            {   
                String name = method1[i].getName();
                if(name.startsWith("set"))  
                {   
                    Class cc[] = method1[i].getParameterTypes();
                    if(cc.length == 1)
                    {   
                        String type = cc[0].getName();
                        name=tolowercase(name);
                        String param ="";
                        if(request.get(name)!=null&& !request.get(name).equals(""))
                        {
                             param = request.get(name).toString();
                             //System.out.println(name+":"+param);
                        }
                        
                        if(param != null && !param.equals(""))
                        {	
                            if(type.equals("java.lang.String"))
                                method1[i].invoke(model, new Object[]{param});
                            else if(type.equals("int") || type.equals("java.lang.Integer"))   
                                method1[i].invoke(model, new Object[]{new Integer(param)});   
                            else if(type.equals("long") || type.equals("java.lang.Long"))   
                                method1[i].invoke(model, new Object[]{new Long(param)});   
                            else if(type.equals("float") || type.equals("java.lang.Float"))   
                                method1[i].invoke(model, new Object[]{new Float(param)}); 
                            else if(type.equals("boolean") || type.equals("java.lang.Boolean"))   
                                method1[i].invoke(model, new Object[]{Boolean.valueOf(param)});   
                            else if(type.equals("java.sql.Date"))   
                            {   
                                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");   
                               Date d = df.parse(param);   
                                if(d != null)   
                                    method1[i].invoke(model, new Object[]{new Date(d.getTime())});   
                            }
                    }
                    }   
                }   
            }   
  
        b=true;
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
    

}
