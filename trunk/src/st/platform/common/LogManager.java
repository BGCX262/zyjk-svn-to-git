package st.platform.common;
import st.platform.utils.*;
import java.io.*;

import java.util.GregorianCalendar;

public class LogManager {

    private String fOperid ="";
    private String fOperName ="";
    private String fClientIP ="";
    
    private boolean fisdebug;
    private boolean fisMessage;
    private boolean fisSql;
    private boolean fisError;
    
    private int      fdelDays;  
    
    private int           fLogType;
    private String         fLogMsg;
    private Exception      fLogExp;
    
    public static  String   fwebpath = "";
    
    public LogManager(String operid,String operName,String ClientIP)
    {
        fOperid = operid;
        fOperName = operName;
        fClientIP = ClientIP;
        
        try
        {
            fisdebug   =   Basic.IsTrue(Config.getProperty("isdebug"));
            fisMessage =   Basic.IsTrue(Config.getProperty("isMessage"));
            fisSql     =   Basic.IsTrue(Config.getProperty("isSql"));
            fisError   =   Basic.IsTrue(Config.getProperty("isError"));
            fdelDays   =   Basic.getInt(Config.getProperty("delDays"));
            
            delFile();
            
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
        
    public void setMessage(String msgStr)
    {
        fLogMsg  = msgStr;
        fLogType = 1;
        
        writeLog();
    }
    
    public void setSql(String sqlStr)
    {
        fLogMsg  = sqlStr;
        fLogType = 2;
        
        writeLog();
    }
    
    public void setError(String errorStr)
    {
        fLogMsg  = errorStr;
        fLogType = 3;
        
        writeLog();
    }
    
    public void setError(Exception LogExp)
    {
        fLogExp  = LogExp;
        fLogType = 4;
        
        writeLog();
    }
    
    
    
    
    private void writeLog()
    {
        try
        {
            GregorianCalendar gregoriancalendar = new GregorianCalendar();
            
            String monthStr = "";
            String dateStr  = "";
            
            if(gregoriancalendar.get(GregorianCalendar.MONTH) + 1 < 10)
                monthStr   = "0" + (gregoriancalendar.get(GregorianCalendar.MONTH) + 1);
            else
                monthStr   = (new StringBuffer(String.valueOf(gregoriancalendar.get(GregorianCalendar.MONTH) + 1))).toString();
            
            if(gregoriancalendar.get(GregorianCalendar.DATE) < 10)
                dateStr = "0" + gregoriancalendar.get(GregorianCalendar.DATE);
            else
                dateStr = gregoriancalendar.get(GregorianCalendar.DATE) + "";
            
            String fileName = gregoriancalendar.get(GregorianCalendar.YEAR) + monthStr + dateStr;
            
            FileOutputStream fileoutputstream = new FileOutputStream(fwebpath + "/message/log/" + fileName + ".txt", true);
            
            String logTitle = "******操作时间：" + BusinessDate.getTodaytime();
            
            if(fOperName!= null && !fOperName.equals(""))
                logTitle = logTitle + "操作员：" + fOperName + "(" + fOperid + ")";
            
            if(fClientIP!= null &&  !fClientIP.equals(""))
                logTitle = logTitle + "客户端地址：" + fClientIP;
            
            
            fileoutputstream.write((logTitle + "*********\n").getBytes());
            
            if(fLogType == 1 && fisMessage)
                fileoutputstream.write(("记录信息日志:" + fLogMsg + "\n").getBytes());
            
            if(fLogType == 2 && fisSql)
                fileoutputstream.write(("记录db日志:" + fLogMsg + "\n").getBytes());
            
            if(fLogType == 3 && fisError)
                fileoutputstream.write(("记录错误日志:" + fLogMsg + "\n").getBytes());
            
            if(fLogType == 4 && fisError)
            {
                fileoutputstream.write(("*************记录错误日志" + fLogExp.getMessage() + "*************************\n").getBytes());
                for(int i = 0; i < fLogExp.getStackTrace().length; i++)
                    fileoutputstream.write((fLogExp.getStackTrace()[i].toString() + "\n").getBytes());

                if(fisdebug)
                {
                    System.out.println(logTitle);
                    fLogExp.printStackTrace();
                }
            }
            if(fLogType != 4 && fisdebug)
            {
                System.out.println(logTitle);
                System.out.println(fLogMsg);
                System.out.println("  ");
            }
            fileoutputstream.write("\n".getBytes());
            fileoutputstream.flush();
            fileoutputstream.close();
            
           
        }catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
    
     private void delFile()
    {
       
                 
         File file = new File(fwebpath + "/message");
        if(!file.exists())
            file.mkdir();
        
        file = new File(fwebpath + "/message/log");
        if(!file.exists())
            file.mkdir();
        
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        
        String monthStr = "";
        String dateStr  = "";
        
        if(gregoriancalendar.get(GregorianCalendar.MONTH) + 1 < 10)
            monthStr   = "0" + (gregoriancalendar.get(GregorianCalendar.MONTH) + 1);
        else
            monthStr   = (new StringBuffer(String.valueOf(gregoriancalendar.get(GregorianCalendar.MONTH) + 1))).toString();
        
        if(gregoriancalendar.get(GregorianCalendar.DATE) < 10)
            dateStr = "0" + gregoriancalendar.get(GregorianCalendar.DATE);
        else
            dateStr = gregoriancalendar.get(GregorianCalendar.DATE) + "";
        
        String fileName = gregoriancalendar.get(GregorianCalendar.YEAR) + monthStr + dateStr;
        
        file = new File(fwebpath + "/message/log");
        File afile[] = file.listFiles();
       
        
        //System.out.println("文件 " + fileName);
       
       
        for(int i = 0; i < afile.length; i++)
        {
               //System.out.println("文件 1" + afile[i].getName());
            
            
            if(afile[i].isFile() && afile[i].exists() && Integer.parseInt(fileName) - Integer.parseInt(afile[i].getName().substring(0, afile[i].getName().length() - 4)) >= fdelDays)
                afile[i].delete();
        }

    }
     
     
     
     
}
