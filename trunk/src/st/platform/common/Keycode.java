package st.platform.common;
import st.platform.db.control.DBXML;
import st.platform.utils.*;

public class Keycode {

    public static String dateKey    = "";
    public static String projectKey = "";
    
    
    private String createDateKey()
    {
        try{
            byte[] pwdBytes = Config.getProperty("key").getBytes();
            for ( int i = 0 ; i < pwdBytes.length ; i++ ) {
                
                pwdBytes[i] = (byte) (pwdBytes[i]- 2*i); 
            }
                    
            String limitDate = new String(pwdBytes).toLowerCase();
            if (limitDate.length()==8)
            {
                Config.limitTime = limitDate.substring(0,4)+"年"+limitDate.substring(4,6)+"月"+limitDate.substring(6,8)+"日";
            }else
                Config.limitTime =limitDate;
            
            return new String(pwdBytes).toLowerCase();
        }catch(Exception e)
        {
            e.printStackTrace();
            
            return "";
        }
    }   
    
    public boolean isDatePass()
    {
        return java.lang.Long.parseLong(createDateKey()) > java.lang.Long.parseLong(BusinessDate.getdayNumber());
    }

    public  String encodeKeyDate()
    {   
        char[] keyBytes =Config.getProperty("key").toCharArray();
        
        String  dateKey = "";
        for (int i=0;i<keyBytes.length;i++)
        {
            dateKey =  dateKey+ java.lang.Long.toHexString(keyBytes[i]);
        }
        
        return dateKey;     
    }
    
    
    private String ProjectKey()
    {
        return  "由青岛信软科技有限公司开发的:"+Config.getProperty("project")+"项目现授予:"+Config.getProperty("copyright")+"版权.";
    }
    
    
    public  String encodeStr1()
    {
        char[] keyBytes = ProjectKey().toCharArray();
        
        String enKeyStr = "";
        for (int i=0; i< keyBytes.length; i++)
        {
            enKeyStr = enKeyStr + java.lang.Long.toHexString(keyBytes[i]);
        
        }       
        return enKeyStr;
    }
    
    public static String encodeStr2()
    {
        Keycode keycode = new Keycode();
        
        char[] keyBytes = keycode.encodeStr1().toCharArray();
        String enKeyStr = "";
        for (int i=0; i< keyBytes.length; i++)
        {
            enKeyStr = enKeyStr + (char)(keyBytes[i]/2+i/2);
        
        }
        
        return enKeyStr;        
    }
     
     private  String[]   raoluan6()
     {          
            
         String[]  keyS = new String[2];
            
         String[]  keyS3 = DBXML.raoluan5();
         
         
         keyS[0] = keyS[0] = keyS3[0]+  "-2" + projectKey.substring(projectKey.length()/4,projectKey.length()/4 + 3)+ dateKey.substring(2,7) + projectKey.substring(projectKey.length()-50,projectKey.length()-47);
         keyS[1] = keyS[1] = keyS3[1]+  "-P" + projectKey.substring(projectKey.length()/4,projectKey.length()/4 + 3)+ dateKey.substring(2,7) + projectKey.substring(projectKey.length()-50,projectKey.length()-47);
         
         return keyS;
     }
    
     public boolean  isKeyPass()
     {          
        
        /**
         * 授本软件正版
         */
         if (raoluan6()[0].toUpperCase().equals(Config.getProperty("registered")))
         {
             Config.copyright = true;
             return  true;
         }
         
        /**
         * 授本软件试用版
         */
         if (raoluan6()[1].toUpperCase().equals(Config.getProperty("registered")))
         {
             Config.copyright = false;
             return  true;
         }
                 
         return  true;          
     }
    
     
     public static boolean isPass()
     {
         
         //LogManager logManager = new LogManager("00000","系统级","");        
         Keycode keycode = new Keycode();
         
         if (keycode.isKeyPass())
         {
             
             if( Config.copyright)
             {
                 return true;
             
             }else if (! Config.copyright && keycode.isDatePass())
                 return true;
             else
             {
                 //logManager.setError("该软件使用已过期！");
                 return true;
             }
         }else
         {
             //logManager.setError("该软件无授予" + Config.getProperty("copyright")+"版权！");
             return true;
         }
        
         
     }
     
}

