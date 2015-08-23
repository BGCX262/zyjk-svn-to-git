package st.platform.db.control;

import st.platform.common.Keycode;
import st.platform.common.XMLConfig;
import st.platform.db.common.*;
import st.platform.db.*;

import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import java.io.*;

import java.util.List;
import jxl.*;
import jxl.write.*;
import st.platform.system.cache.*;
import st.platform.utils.*;



import java.util.*;



public class DBXML
{
    
    public static String webpath ="";
    
    public DBXML()
    {
    }
    public String getDataTableXML(String xmlStr) {
      String outstr = "";
      Document doc = null;
      Element rootNode;     

      try {
        

         Reader reader = new StringReader(xmlStr);
         SAXBuilder ss = new SAXBuilder();
         try {
            doc = ss.build(reader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

         rootNode = doc.getRootElement();

         List list = rootNode.getChildren();

         Element childRoot = (Element) list.get(0);

         DBGrid  dbGrid= new DBGrid();
         dbGrid.setGridID(childRoot.getAttributeValue("id"));
        
         dbGrid.setOrderField(childRoot.getAttributeValue("orderFieldName"));
         dbGrid.setAbsolutePage(Integer.parseInt(childRoot.getAttributeValue("AbsolutePage")));
         dbGrid.setRecordCount(Integer.parseInt(childRoot.getAttributeValue("RecordCount")));
         dbGrid.setSQLStr(Basic.decode(childRoot.getAttributeValue("sqlStr")));         
         dbGrid.setOrderStr(Basic.decode(childRoot.getAttributeValue("orderStr")));
         dbGrid.setWhereStr(Basic.decode(childRoot.getAttributeValue("whereStr")));
         dbGrid.setDictID(childRoot.getAttributeValue("dictid"));
         
         outstr = dbGrid.getEditDataTable();


      }
    catch (JDOMException ex) {
      System.out.print(ex.getMessage());

    } finally {
        
    }
    return outstr;
 }

    public String getDropDownXML(String xmlStr) {
      String outstr = "";
      Document doc = null;
      Element rootNode,child;
     
      try {
        Reader reader = new StringReader(xmlStr);
        SAXBuilder saxbuilder = new SAXBuilder();
        try {
            doc = saxbuilder.build(reader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        rootNode = doc.getRootElement();

        if (rootNode.getAttributeValue("type").equals("lp"))
        {
            return getloadspell(rootNode.getText());
        }

        if (rootNode.getAttributeValue("type").equals("lm"))
        {
           return getLoadName(rootNode.getText());
        }

        List list = rootNode.getChildren();
        Element childRoot = (Element) list.get(0);
        
        String fieldTitle = childRoot.getAttributeValue("fieldTitle");
        if (rootNode.getAttributeValue("type").equals("enum"))
        {
            String enumType = childRoot.getAttributeValue("enumType");
            return getEnumType(enumType,fieldTitle);
        }
        
        if (rootNode.getAttributeValue("type").equals("sql"))
        {
            String SqlStr = childRoot.getAttributeValue("SqlStr");           
            return getDropDownStr(SqlStr,fieldTitle);
        }
       
        if (rootNode.getAttributeValue("type").equals("select"))
        {
            String SqlStr = childRoot.getAttributeValue("refSql");
            
            //System.out.println(SqlStr);
            return getChildSelect(SqlStr);
        }
          
        if (rootNode.getAttributeValue("type").equals("excel"))
        {
            return writExcel(childRoot);
        }
        
      


   }
    catch (JDOMException ex) {
      System.out.print(ex.getMessage());

    }


     return outstr;
   }

   ////获取路拼信息
   private String getloadspell(String words){
       return PtWordSpell.getChSpellS(words);
   }
   
   private String getChildSelect(String SqlStr)
   {
       DatabaseConnection  DBCon = ConnectionManager.getInstance().getConnection();
       StringBuffer StrBuf = new StringBuffer();
       try{

            RecordSet rs = DBCon.executeQuery(SqlStr);

            StrBuf.append("<root>");
            while (rs.next())
            {
                StrBuf.append("<recorder>");
                
                for (int i=0;i< rs.getfieldCount();i++)
                {
                    if (i==0)
                        StrBuf.append("<field name=\"value\" value=\""+rs.getString(rs.getFieldName(i))+"\" />");
                    else if (i==1)
                        StrBuf.append("<field name=\"text\" value=\""+rs.getString(rs.getFieldName(i))+"\" />");
                    else
                        StrBuf.append("<field name=\"" + rs.getFieldName(i) + "\" value=\""+rs.getString(rs.getFieldName(i))+"\" />");
                }
                StrBuf.append("</recorder>");
            }
            StrBuf.append("</root>");
           rs.close();
       }
       catch (Exception e) {
            e.printStackTrace();

            return e.getMessage();
       }finally{
            DBCon.close();
       }
     
        return StrBuf.toString();
    }


   /////获取枚举中信息
   private String getEnumType(String enumType,String fieldTitle){

       try{
             EnumerationBean enumBean = EnumerationType.getEnu(enumType);

             Object[] keys = enumBean.getKeys().toArray();

             StringBuffer StrBuf = new StringBuffer();


             String[] fieldTitlearr = fieldTitle.split(",");

             StrBuf.append("<table id='Data_dropDown' class=\"dropDownTable\"  width='100%' border='0'  cellspacing='1' cellpadding='1' >");

             StrBuf.append("<tr height='20'   class=\"dropDownHead\" >");

             for (int i = 0; i < fieldTitlearr.length; i++) {
                    StrBuf.append("<td align=\"center\">" + fieldTitlearr[i] + "</td> ");
             }
               StrBuf.append("</tr>");


              for ( int i = 0 ; i < keys.length ; i++ ) {
                Object key=keys[i];

                 StrBuf.append("<tr  onclick=\"TRClick(this)\" height='20' class=\"gridEvenRow\">");
                 String[] enumStr = ((String) enumBean.getValue(key)).split(";");
                 StrBuf.append("<td  align =\"left\" >" + key.toString() + "</td>");
                 StrBuf.append("<td  align =\"left\" >" + enumStr[0] + "</td>");
                 StrBuf.append("</tr>");
             }
             StrBuf.append("</table>");

             return StrBuf.toString();
       }catch(Exception e){
            e.printStackTrace();
       }
       return "";
   }

   //////过滤路名
   private String getLoadName(String spells)
   {
      return RoadEnum.getRoadName(spells.toUpperCase());
   }


   private String writExcel(Element element)
   {
       DatabaseConnection databaseconnection = null;
       DictDetail dictDetail;
       try
       {
           String dictid   =  element.getAttributeValue("dictid");
           String sqlStr   = Basic.decode(element.getAttributeValue("sqlStr"));
           String orderStr = Basic.decode(element.getAttributeValue("orderStr"));
           String whereStr = Basic.decode(element.getAttributeValue("whereStr"));
                     
           DictMain dictMain = DictConfig.getDictMain(dictid);
           if(dictMain != null)
           {
               if(sqlStr.trim().length() == 0)
                   sqlStr = dictMain.getFsqlstr();
               if(whereStr.trim().length() == 0)
                   whereStr = dictMain.getFwherestr();
               if(orderStr.trim().length() == 0)
                   orderStr = dictMain.getForderstr();
           }else
               return "";
           
           String savefile = "";
           databaseconnection = ConnectionManager.getInstance().getConnection();
           
           File file = new File(webpath + "/message");
           if(!file.exists())
               file.mkdir();
           
           file = new File(webpath + "/message/excel");
           if(!file.exists())
               file.mkdir();
           
           savefile = (new StringBuffer(String.valueOf(System.currentTimeMillis()))).toString().substring(0, 5);
           
           file = new File(webpath + "/message/excel");
           File afile[] = file.listFiles();
           
           for(int i = 0; i < afile.length; i++)
           {
               if(afile[i].isFile() && afile[i].exists() && Integer.parseInt(savefile) - Integer.parseInt(afile[i].getName().substring(0, 5)) > 0)
                   afile[i].delete();
           }
           savefile = System.currentTimeMillis() + ".xls";
           
           
           WritableWorkbook writableworkbook = Workbook.createWorkbook(new File(webpath + "/message/excel/" + savefile));
           WritableSheet writablesheet       = writableworkbook.createSheet("Sheet1", 0);
           writablesheet.getSettings().setDefaultColumnWidth(50);
           
           RecordSet recordset = databaseconnection.executeQuery(sqlStr +" " + whereStr + " " + orderStr);
           
           int cellIndex =0;
           
           for(int i = 0; i < recordset.getColumnCount(); i++)
           {
               dictDetail = dictMain.getDictDetail(recordset.getFieldName(i));
               
               if(dictDetail != null && dictDetail.isFfieldvisible())
               {
                   Label label = new Label(cellIndex, 0, dictDetail.getFfieldlabel());
                   writablesheet.addCell(label); 
                   
                   cellIndex++;
               }
           }
           
           int reindex =1;
           
           while (recordset.next())
           {
               
               cellIndex =0; 
               for(int i = 0; i < recordset.getColumnCount(); i++)
               {
                   dictDetail = dictMain.getDictDetail(recordset.getFieldName(i));
                   
                   if(dictDetail != null && dictDetail.isFfieldvisible())
                   {
                       if(dictDetail.getFfieldtype().trim().toLowerCase().equals("number"))
                       {
                           jxl.write.Number number = new jxl.write.Number(cellIndex, reindex, recordset.getDouble(i));
                           writablesheet.addCell(number);
                           
                       }else if(dictDetail.getFfieldtype().trim().toLowerCase().equals("int"))
                       {
                           jxl.write.Number number1 = new jxl.write.Number(cellIndex, reindex, recordset.getInt(i));
                           writablesheet.addCell(number1);
                           
                       } else  if(dictDetail.getFfieldtype().trim().toLowerCase().equals("dropdown"))
                       {
                           String fieldValue = recordset.getString(i);
                           String enumStr = fieldValue;
                        
                            EnumerationBean enumBean = EnumerationType.getEnu(dictDetail.getFdropdownexp());
                            if (enumBean != null) {
                                enumStr = ((String) enumBean.getValue(fieldValue.trim())).split(";")[0];
                            }               

                            Label label1 = new Label(cellIndex, reindex, enumStr);
                            writablesheet.addCell(label1);
                       } else
                       {
                           Label label2 = new Label(cellIndex, reindex, recordset.getString(i));
                           writablesheet.addCell(label2);
                       }
                       
                       cellIndex++;
                   }
               }
               
               reindex ++;
           }

           writableworkbook.write();
           writableworkbook.close();
           recordset.close();
           return "/message/excel/" + savefile;
           
       }catch(Exception e){
        System.out.println(e.getMessage());
        return "";
        
       }
       finally
       {
           if(databaseconnection != null)
               databaseconnection.close();
       }
      
       
   }

  public static String[]   raoluan5()
 {          
        
        String[]  keyS = new String[2];
    
        String[]  keyS3 = RecordMetaData.raoluan4();
      
        keyS[0] = keyS3[0] + "-1" + Keycode.projectKey.substring(66,71)+ Keycode.dateKey.substring(4,7) + 
        Keycode.projectKey.substring(Keycode.projectKey.length()/3+2,Keycode.projectKey.length()/3+5)+ Keycode.dateKey.substring(12,15);
        
        keyS[1] = keyS3[1] + "-3" + Keycode.projectKey.substring(66,71)+ Keycode.dateKey.substring(4,7) + 
        Keycode.projectKey.substring(Keycode.projectKey.length()/3+2,Keycode.projectKey.length()/3+5)+ Keycode.dateKey.substring(12,15);
       
        return keyS;
            
 }

    private String getDropDownStr(String SqlStr, String fieldTitle) 
    {

         DatabaseConnection  DBCon = ConnectionManager.getInstance().getConnection();
         StringBuffer StrBuf = new StringBuffer();
         try{
              
              int count = 0;
              RecordSet rs = DBCon.executeQuery(SqlStr);

              String[] fieldTitlearr = fieldTitle.split(",");

              StrBuf.append("<table id='Data_dropDown' class=\"dropDownTable\"  width='100%' border='0'  cellspacing='1' cellpadding='1' >");

              StrBuf.append("<tr height='20'   class=\"dropDownHead\" >");

              for(int i = 0; i < fieldTitlearr.length; i++) {
                   StrBuf.append("<td align=\"center\">" + fieldTitlearr[i] + "</td></td> ");
              }
              StrBuf.append("</tr>");
              count = 0;

              while(rs.next()) {

                   if(count % 2 == 0) {
                        StrBuf.append("<tr  onclick=\"TRClick(this)\" height='20' class=\"gridEvenRow\">");
                   } else {
                        StrBuf.append("<tr  onclick=\"TRClick(this)\" height='20' class=\"gridOddRow\">");

                   }
                   for(int j = 0; j < fieldTitlearr.length; j++) {

                        String FieldValue = rs.getString(j);

                        if(FieldValue != null) {

                             StrBuf.append("<td >" + FieldValue + "</td>");
                        } else {
                             StrBuf.append("<td  ></td>");

                        }
                   }
                   StrBuf.append("</tr>");

                   count++;
              }

              StrBuf.append("</table>");
              rs.close();
         }
         catch (Exception e) {
              e.printStackTrace();

              return e.getMessage();
         }finally{
                DBCon.close();
         }

        return StrBuf.toString();
    }



}
