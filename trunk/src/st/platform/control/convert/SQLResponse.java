package st.platform.control.convert;
import  st.platform.db.*;
import java.util.*;
import st.platform.utils.Basic;


public class SQLResponse {
    
    private Vector  VectFieldName ;//字段名称每个名称用；隔开    
    private Vector  vectFieldValue;//字段值每个值用;隔开

    public static final int MESSAGE_TYPE     = 0;
    public static final int DATA_TYPE        = 1;
    public static final int HTML_TYPE        = 2;
    public static final int SELF_XML_TYPE    = 3;
    public static final int VALUE_TYPE       = 4;

    
    
    private String   fMessage    = "";
    private int     fType        = 0;
    private boolean fResult      =  false;
    private RecordSet frecordSet  = null;
    
    
    public SQLResponse() {
       
        VectFieldName  = new Vector();        
        vectFieldValue = new Vector();

    }
  
    public void setMessage(String message){
        fMessage = message;
    }

   public void setResult(boolean Result){
       fResult = Result;
    }

    public void setType(int type){
        fType = type;
    }

     public void setRecordset(RecordSet recordSet) {
         frecordSet = recordSet;
    }

   
    public void addField(String name,String value) {
        VectFieldName.add(name);
        vectFieldValue.add(value);
        fType = VALUE_TYPE;
    }


    public String getXmlStr()
    {
        StringBuffer  StrBuf = new StringBuffer();

        try{
             StrBuf.append("<root>");

             if (fType==1)
             {
                   if (fResult) 
                   {
                         if (frecordSet != null && frecordSet.next())
                         {

                               StrBuf.append("<action type=\"1\" result=\"true\">");
                               frecordSet.beforeFirst(); //多次取出响应结果
                               
                               while (frecordSet.next())
                               {
                                    StrBuf.append("<record> ");

                                    for (int j=0; j<frecordSet.getColumnCount(); j++)
                                    {
                                        StrBuf.append("<field ");
                                        StrBuf.append(" name =\"" + frecordSet.getFieldName(j) + "\"");
                                        StrBuf.append(" type =\"text\"");
                                        StrBuf.append("  value =\"" + Basic.encode(frecordSet.getString(j)) + "\"");
                                        StrBuf.append(" />");

                                      }
                                     StrBuf.append("</record>");

                               }
                               
                                StrBuf.append("</action>");

                            }else
                            {
                                StrBuf.append("<action type=\"1\" result=\"false\">"+Basic.encode("无返回结果！")+"</action>");
                            }
                       }else
                       {
                           StrBuf.append("<action type=\"1\" result=\"false\">"+Basic.encode(fMessage)+"</action>");
                       }
                 } 
                 else if ( fType == VALUE_TYPE ) {
                   StrBuf.append(getfieldValue());
                }else if ( fType == MESSAGE_TYPE ){
                    StrBuf.append("<action type=\""+fType+"\" result=\""+ fResult +"\">"+Basic.encode(fMessage)+"</action>");
                }else {
                    StrBuf.append("<action type=\""+fType+"\" result=\""+ fResult +"\">"+fMessage+"</action>");
                }
             
               StrBuf.append("</root>");
               
            } catch ( Exception e ) {
               e.printStackTrace();
              return "<root><action type=\"0\" result=\"false\">"+Basic.encode("构造XML出错")+"</action></root>";
            }
            
            return StrBuf.toString();
    }



    private String getfieldValue()
    {
        
        StringBuffer stringbuffer = new StringBuffer();
        if(VectFieldName.size() > 0)
        {
            stringbuffer.append("<action type=\"1\" result=\"true\">");
            stringbuffer.append("<record> ");
            for(int i = 0; i < VectFieldName.size(); i++)
            {
                stringbuffer.append("<field ");
                stringbuffer.append(" name =\"" + (String)VectFieldName.get(i) + "\"");
                stringbuffer.append(" type =\"text\"");
                stringbuffer.append(" value =\"" + Basic.encode((String)vectFieldValue.get(i)) + "\"");
                stringbuffer.append(" />");
            }

            stringbuffer.append("</record>");
            stringbuffer.append("</action>");
        } else
        {
            stringbuffer.append("<action type=\"1\" result=\"false\">" + Basic.encode("无记录返回！") + "</action>");
        }
        return stringbuffer.toString();
    }
}
