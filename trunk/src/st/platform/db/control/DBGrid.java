package st.platform.db.control;
import java.util.*;

import javax.sound.midi.SysexMessage;

import st.platform.db.*;
import st.platform.system.cache.*;
import st.platform.utils.Basic;

public class DBGrid {
    private String fgridID="";
    private String fdictID="";

    private boolean gridTitleVisible  = true;
    private boolean gridBottomVisible = true;
    
    private String gridType  = "read";
    private boolean checkbl = false;
    private boolean isTotal = false;
    
    
    private boolean isconfirmdelete = false;
    private boolean isconfirmcancel = false;
    private boolean isdirectdelete  = false;
    
    private int pageSize      = 100 ;////页记录条树
    private int AbsolutePage  = 1   ;//绝对页数
    private int RecordCount   = 0   ;///记录条树
    private int TotalPage     = 0   ;///总页页数
    
    
    
    private String fSQLStr    = "";///SQL查询语句
    private String fwhereStr  = "";////查询条件
    private String forderStr  = "";////查询条件
    
    private String forderField = "";
    private String forderType  = "";
    
    private RecordSet  gridRS;
        
    private int       gridWidth = 0;
    private String    enumStr    = "";

    private DictMain   dictMain;
    private DictDetail dictDetail;
    
    private boolean    isFieldAmbit = false;

    
      private Map fieldTypeS = new HashMap();   ///枚举类型树组容器
      
    ///////////////////////////////////////////////////////////////////////
    private String dataPilotID=""; /////;   数据按钮集
    private String buttons ="moveFirst,prevPage,movePrev,moveNext,nextPage,moveLast";     ///按钮集
    private String[] buttonsArr; ///按钮数组
    
    
    public void setGridID(String gridID){
        fgridID  = gridID;
    }
    
    public void setDictID(String dictID){
        fdictID = dictID;
        
        loadDataSet();
        
    }
    
    private void loadDataSet()
    {
        dictMain = DictConfig.getDictMain(fdictID);
        //System.out.println("fdictID"+fdictID);
        
        if (dictMain != null)
        {
                    
            if (fSQLStr.trim().equals(""))
                fSQLStr = dictMain.getFsqlstr();
            
            if (fwhereStr.trim().equals(""))
                fwhereStr = dictMain.getFwherestr();
            
            if (forderStr.trim().equals(""))
                forderStr = dictMain.getForderstr();
            
            gridType = dictMain.getFgridtype();
            checkbl  = dictMain.isFischeck();
            isTotal  = dictMain.isFistotal();
            gridBottomVisible = dictMain.isFbottomvisible();
            
            isconfirmdelete   = dictMain.isFisconfirmdelete();
            isconfirmcancel   = dictMain.isFisconfirmcancel();
            isdirectdelete   = dictMain.isFisdirectdelete();
            
            pageSize         = dictMain.getFpagesize();
        }   
    }
    
    

    public void setSQLStr(String SQLStr){

        this.fSQLStr =SQLStr;
    }
    
    public void setFieldType(String fieldName,String fieldType)
    {
        fieldTypeS.put(fieldName.toLowerCase(),fieldType);
    }
     
    public void setWhereStr(String WhereStr){
        this.fwhereStr =WhereStr;

    }
 
    public void setOrderStr(String orderStr){
        this.forderStr =orderStr;

    }
    
    public void setOrderField(String orderField){
        this.forderField =orderField;

    }    
   
   //绝对页数
    public void setAbsolutePage(int AbsolutePage) {
        this.AbsolutePage = AbsolutePage;
    }

    ////记录行数
    public void setRecordCount(int RecordCount){
        this.RecordCount =RecordCount;
    }

    ///取得每页记录条数
    private void getpagesize(){
        if (pageSize < 0) {
          pageSize = 99999;

        }
    }


    ///取得记录条数
    private void getRecordCount()
    {
         getpagesize();
         
         DatabaseConnection DBCon = null;
         DBCon = ConnectionManager.getInstance().getConnection();
        
         if (RecordCount <= 0) 
         {
             String  countSQL  = "select count(*) from ("+ fSQLStr +" " + fwhereStr + ") temp";
                     
             try{
                
                gridRS = DBCon.executeQuery(countSQL);//add
                if (gridRS.next()){
                    RecordCount =   gridRS.getInt(0);
                }
            } catch ( Exception e ) {
                if(DBCon != null)
                     DBCon.close();
                e.printStackTrace();
            }
         }
         try{
             gridRS = DBCon.executeQuery(fSQLStr,fwhereStr,forderStr , pageSize * (AbsolutePage - 1) + 1,pageSize,RecordCount);
         } catch ( Exception e ) {
             if(DBCon != null)
                 DBCon.close();
             
            e.printStackTrace();
         }
         
         if(forderStr.toLowerCase().trim().lastIndexOf(" desc") > 0)
             forderType = "desc";
         else
             forderType = "asc";
         
         if(DBCon != null)
             DBCon.close();
         
    }

    ////返回总页数
    private void getTotalPage(){
        
        getRecordCount();
        
        if ( (RecordCount % pageSize) == 0) {
            TotalPage=  RecordCount / pageSize;
        } else {
            TotalPage=  RecordCount / pageSize + 1;
        }
    }
    
      ///生成可编辑的grid方法
    public String getDBGrid() {

        String returnStr ="";

        returnStr = "  <TABLE  id=tblWorkArea  cellPadding=0  width=\"100%\"><TR><TD  id=tdWorkArea vAlign=top algin=left height=\"100%\"><div   id=\"div_" + fgridID + "\"  antoresize=\"true\" onresize=\"divtop_resize(this)\" style=\" width:100%;\" >" +getEditDataTable()+ "</div></td></tr></table>";


        return returnStr;
    }

   ///生成可编辑的数据表
    public String getEditDataTable() 
    {
          
         getTotalPage();
         
         String returnStr ="";
         
         if (gridRS == null)
             return returnStr;
         
         try
         {
                
            if (gridTitleVisible && gridBottomVisible)
                returnStr =getGridTitle()+getDataGridTitle()+getFieldGrid()+getGridEnd();
    
            if (gridTitleVisible && !gridBottomVisible)
               returnStr =getGridTitle()+getDataGridTitle()+getFieldGrid()+getTitleNOEnd();
            
         }catch(Exception e)
         {
             
         }
        return returnStr;
    }
    
     private String getGridTitle() throws Exception
     {
         try
         {
             StringBuffer StrBuf = new StringBuffer();
             StringBuffer StrBuf1 = new StringBuffer();
             StrBuf1.append("<tr  >");
             
             if(checkbl)
             {
                 StrBuf1.append("<td   id=\"checkID\"   align=\"center\" vAlign=\"center\" width=\"30\" ><input class=\"checkbox\" type=\"checkbox\" id=\"chkpar_" + fgridID + "\"   style=\"borderStyle :none\" onclick=\"checkClick('form_" + fgridID + "')\"></td>");
                 gridWidth = 30;
             }
             for(int i = 0; i < gridRS.getColumnCount() - 1; i++)
             {
                 dictDetail  = dictMain.getDictDetail(gridRS.getFieldName(i));
                 if(dictDetail != null)
                 {
                     StrBuf1.append(" <td   align=\"center\" vAlign=\"center\" fieldName=\"" + dictDetail.getFfieldname() + "\" fieldLabel=\"" + dictDetail.getFfieldlabel() + "\"");
                     StrBuf1.append(" fieldType=\"" + dictDetail.getFfieldtype() + "\" fieldAlign=\"" + dictDetail.getFfieldalign() + "\" enumType=\"" + dictDetail.getFdropdownexp() + "\"");
                     StrBuf1.append(" fieldIsAllowNull=\"" + dictDetail.isFfieldisallownull() + "\" fieldMaxLength=\"" + dictDetail.getFfieldmaxlength() + "\"");
                     StrBuf1.append(" fieldIntLength=\"" + dictDetail.getFfieldintlength() + "\" fieldDecimallength=\"" + dictDetail.getFfielddecimallength() + "\"");
                     StrBuf1.append(" fieldMaxValue=\"" + dictDetail.getFfieldmaxvalue() + "\" fieldMinValue=\"" + dictDetail.getFfieldminvalue() + "\"");
                     if(dictDetail.isFfieldvisible())
                     {
                         gridWidth += dictDetail.getFfieldwidth();
                         StrBuf1.append(" width=\"" + dictDetail.getFfieldwidth() + "\"");
                     } else
                     {
                         StrBuf1.append(" style =\"display:none;\" ");
                     }
                     
                     if(dictDetail.isFfieldorder())
                         StrBuf1.append(" ondblclick=\"gridTitleTr_sort(this)\"");
                     
                     if(dictDetail.isFfieldorder())
                     {
                         if(forderType.equals("desc")&& forderField.trim().toLowerCase().equals(gridRS.getFieldName(i).trim().toLowerCase()))
                         {
                              StrBuf1.append(" orderType=\"desc\">" +dictDetail.getFfieldlabel() + " <font size=1 style=\"font-family:webdings; \" >&nbsp;6</font>");
                         }else
                         {
                             StrBuf1.append(" orderType=\"asc\">" +dictDetail.getFfieldlabel() + " <font size=1 style=\"font-family:webdings; \" >&nbsp;5</font>");
                         }
                     } else
                     {
                         StrBuf1.append(" >" + dictDetail.getFfieldlabel());
                     }
                     
                    
//                   if (dictDetail.getFfieldgraph())
//                   {
//                       //平面柱状图
//                       if (dictDetail.getFfieldgraphtype().trim().equals(DBGridConstants.GRAPHTYPE_PLANEBAR))
//                       {
//                           StrBuf1.append("<img  width='16' height='14' class='planebar'  graphType='planebar' title='平面柱状图' onclick='gridGraph_click()'/>");
//                       }
//                       //平面折线图
//                       if (dictDetail.getFfieldgraphtype().trim().equals(DBGridConstants.GRAPHTYPE_PLANELINE))
//                       {
//                           StrBuf1.append("<img  width='16' height='14' class='planeline'  graphType='planeline'title='平面折线图' onclick='gridGraph_click()' />");
//                       }
//                       //平面饼状图
//                       if (dictDetail.getFfieldgraphtype().trim().equals(DBGridConstants.GRAPHTYPE_PLANEPIE))
//                       {
//                           StrBuf1.append("<img  width='12' height='12' class='planepie'  graphType='planepie' title='平面饼状图' onclick='gridGraph_click()'/>");
//                       }
//                       //立体柱状图
//                       if (dictDetail.getFfieldgraphtype().trim().equals(DBGridConstants.GRAPHTYPE_SOLIDBAR))
//                       {
//                           StrBuf1.append("<img  width='15' height='15' class='solidbar'  graphType='solidbar' title='立体柱状图' onclick='gridGraph_click()' />");
//                       }
//                       //立体折线图
//                       if (dictDetail.getFfieldgraphtype().trim().equals(DBGridConstants.GRAPHTYPE_SOLIDLINE))
//                       {
//                           StrBuf1.append("<img  width='16' height='16' class='solidline'  graphType='solidline' title='立体折线图' onclick='gridGraph_click()'/>");
//                       }
//                       //立体饼状图
//                       if (dictDetail.getFfieldgraphtype().trim().equals(DBGridConstants.GRAPHTYPE_SOLIDPIE))
//                       {
//                           StrBuf1.append("<img  width='15' height='9' class='solidpie'  graphType='solidpie'  title='立体饼状图' onclick='gridGraph_click()' />");
//                       }
//                        
//                  }
                     StrBuf1.append(" </td>");
                 }
             }
    
             StrBuf.append("<form id=\"form_" + fgridID + "\" style=\"TOP:0px ;width:100%\"  class=\"gridForm\">");
             StrBuf.append("<div  class=\"divToucss\"  id=\"divt_" + fgridID + "\" style=\"Z-INDEX: 1; OVERFLOW: hidden;width:100%;\" onselectstart=\"event.returnValue=false\">");
             StrBuf.append("<table   id=\"Title_" + fgridID + "\"     bgcolor=\"#ffffff\"    width=\"" + gridWidth + "\"  border=\"0\"  cellspacing=\"1\" cellpadding=\"1\"  >");
             StrBuf1.append("</tr></table></div>");
             return StrBuf.toString() + StrBuf1.toString();
         }
         catch(Exception exception)
         {
             throw exception;
         }
     }
    
     private String getDataGridTitle()  throws Exception
     {
         try
         {
             StringBuffer stringbuffer = new StringBuffer();
             stringbuffer.append("<div  class=\"divTiSkin\"  id=\"divfd_" + fgridID + "\"   onscroll=\"doscroll(this);\" onmouseover=\"this.style.cursor='hand'\"  onmouseout=\"this.style.cursor='default'\" >");
             stringbuffer.append("<table id=\"" + fgridID + "\"  dictid=\"" + fdictID + "\"  width=\"" + gridWidth + "\"  border=\"0\" cellspacing=\"1\" cellpadding=\"1\" activeIndex=0  whereStr=\"" 
                                + Basic.encode(fwhereStr) + "\" orderStr=\"" + forderStr + "\" AbsolutePage=\"" + AbsolutePage + "\" totalPage=\"" + TotalPage + "\" RecordCount=\"" + RecordCount 
                                + "\" checkbl=\"" + checkbl + "\" gridType=\"" + gridType + "\" isTotal=\"" + isTotal + "\" >");
             return stringbuffer.toString();
         }
         catch(Exception exception)
         {
             throw exception;
         }
     }
 
     private String getFieldValue(int fieldIndex ,DictDetail dictDetail) throws Exception
     {
         DatabaseConnection databaseconnection = null;
         
         String fieldValue  = gridRS.getString(fieldIndex);
         
         if(fieldValue == null || fieldValue.toLowerCase().equals("null"))
             return "";      
        
         try
         {
             if(dictDetail.getFfieldtype().toLowerCase().equals("dropdown"))
             {
                enumStr = fieldValue;
                
                EnumerationBean enumBean = EnumerationType.getEnu(dictDetail.getFdropdownexp());
            if (enumBean != null) {
                    enumStr = ((String) enumBean.getValue(fieldValue.trim())).split(";")[0];
            }               

            if (enumStr == null)
                enumStr = "";               
             } 
             
             else  if(dictDetail.getFfieldtype().toLowerCase().equals("sql"))
             {
                 enumStr ="";
                 DatabaseConnection dc = ConnectionManager.getInstance().getConnection();
                 RecordSet rs1;
                 try
                 {
                     String sSql = dictDetail.getFdropdownexp().replaceAll("\\$",fieldValue);                    
                    
                     rs1 = dc.executeQuery(sSql);
                     if ( rs1.next() ) 
                     {
                         if (rs1.getfieldCount()>1)
                         {
                             enumStr = rs1.getString(1);
                         }else
                         {
                             enumStr = rs1.getString(0);
                         }
                     }
                     
                     dc.close();
                     rs1.close();
                    
                     
                 }catch(Exception e)
                 {                   
                     enumStr = fieldValue;
                 }
                 
                 dc.close();
                 
                if (enumStr==null)
                    enumStr ="";
             }
             if(dictDetail.getFfieldtype().toLowerCase().equals("money") || dictDetail.getFfieldtype().toLowerCase().equals("percent"))
             {
                    String[] fieldValueS = fieldValue.split("\\.");
                    if (fieldValueS.length == 2)
                    {
                        if (fieldValueS[1].length()>=2)
                            fieldValue=fieldValueS[0]+"."+fieldValueS[1].substring(0,2);
                    }
             }           
                         
             return fieldValue;
         }
         catch(Exception exception)
         {
             if(databaseconnection != null)
                 databaseconnection.close();
             throw exception;
         }
     }
    
     private String getEditFieldCell(int fieldIndex)  throws Exception
     {
         try
         {
             String     cellStr  =  "";
             String     fieldValue  =  "";
             
             dictDetail = dictMain.getDictDetail(gridRS.getFieldName(fieldIndex));
             if(dictDetail != null)
             {
                 fieldValue  = getFieldValue(fieldIndex, dictDetail);
                 
                                 
                 if(dictDetail.isFfieldvisible())
                 {
                     if(dictDetail.getFfieldtype().toLowerCase().equals("dropdown") || dictDetail.getFfieldtype().toLowerCase().equals("sql"))
                     {
                         
                         
                         cellStr = "<td  nowrap width=\"" + dictDetail.getFfieldwidth() + "\"   align =\"" +dictDetail.getFfieldalign() + "\"" + " oldvalue =\"" + fieldValue + "\"  fieldName=\"" + dictDetail.getFfieldname() 
                                    + "\" fieldType=\"" + dictDetail.getFfieldtype() + "\" fieldValue=\"" + fieldValue + "\"  enumType=\"" + dictDetail.getFdropdownexp() + "\" onclick=\"Col_click(this)\" ondblclick=\"Col_Dbclick(this)\" >" + enumStr + "</td>";
                     
                     }else if ((dictDetail.getFfieldtype().toLowerCase().equals("int")||dictDetail.getFfieldtype().toLowerCase().equals("number")))
                     {
                         cellStr = "<td  nowrap width=\"" + dictDetail.getFfieldwidth() + "\"    align =\"" + dictDetail.getFfieldalign() + "\" " + " oldvalue =\"" + fieldValue + "\"  fieldName=\"" +dictDetail.getFfieldname() 
                            + "\" fieldType=\"" + dictDetail.getFfieldtype() + "\" fieldValue=\"" + fieldValue + "\"  onclick=\"Col_click(this)\" ondblclick=\"Col_Dbclick(this)\" >" + fieldValue + "</td>";

                         
//                       if (!dictDetail.getFfieldmaxambit().equals("")&&!dictDetail.getFfieldmaxambitcolor().equals(""))
//                       {
//                           
//                           if (Basic.getDouble(dictDetail.getFfieldmaxambit()) < Basic.getDouble(fieldValue))
//                           {                   
//                               isFieldAmbit  = true;
//                               
//                               cellStr = "<td style=\"color:"+dictDetail.getFfieldmaxambitcolor() + "\"  nowrap width=\"" + dictDetail.getFfieldwidth() + "\"    align =\"" + dictDetail.getFfieldalign() + "\" " + " oldvalue =\"" + fieldValue + "\"  fieldName=\"" +dictDetail.getFfieldname() 
//                                          + "\" fieldType=\"" + dictDetail.getFfieldtype() + "\" fieldValue=\"" + fieldValue + "\"  onclick=\"Col_click(this)\" ondblclick=\"Col_Dbclick(this)\" >" + fieldValue + "</td>";
//                           }
//                       }                       
//                       if (!dictDetail.getFfieldminambit().equals("")&&!dictDetail.getFfieldminambitcolor().equals(""))
//                       {
//                           
//                           if (Basic.getDouble(dictDetail.getFfieldminambit()) > Basic.getDouble(fieldValue))
//                           {                   
//                                  
//                               isFieldAmbit  = true;
//                               
//                               cellStr = "<td style=\"color:"+dictDetail.getFfieldminambitcolor() + "\"  nowrap width=\"" + dictDetail.getFfieldwidth() + "\"    align =\"" + dictDetail.getFfieldalign() + "\" " + " oldvalue =\"" + fieldValue + "\"  fieldName=\"" +dictDetail.getFfieldname() 
//                                          + "\" fieldType=\"" + dictDetail.getFfieldtype() + "\" fieldValue=\"" + fieldValue + "\"  onclick=\"Col_click(this)\" ondblclick=\"Col_Dbclick(this)\" >" + fieldValue + "</td>";
//                           }
//                       }
                     }else
                     {
                         cellStr = "<td  nowrap width=\"" + dictDetail.getFfieldwidth() + "\"    align =\"" + dictDetail.getFfieldalign() + "\" " + " oldvalue =\"" + fieldValue + "\"  fieldName=\"" +dictDetail.getFfieldname() 
                            + "\" fieldType=\"" + dictDetail.getFfieldtype() + "\" fieldValue=\"" + fieldValue + "\"  onclick=\"Col_click(this)\" ondblclick=\"Col_Dbclick(this)\" >" + fieldValue + "</td>";

                     }
                     
                 } else
                 {
                     cellStr = "<td  style =\"display:none;\" oldvalue =\"" + fieldValue + "\" " + " fieldName=\"" + dictDetail.getFfieldname() + "\" fieldType=\"" + dictDetail.getFfieldtype() + "\" fieldValue=\"" + fieldValue + "\" >" + fieldValue + "</td>";
                 }
             }
             return cellStr;
         }
         catch(Exception exception)
         {
             throw exception;
         }
     }
    
     private String getFieldROW(int RecorderIndex) throws Exception
     {
         try
         {
              String cellStr = "";
              StringBuffer StrBuf = new StringBuffer();
              
              /*非自定义颜色列表*/
                    
              if (!gridType.equals("color"))
              {
                 if(RecorderIndex % 2 == 0)
                     StrBuf.append("<tr  class=\"gridOddRow\"  edit=false state=\"past\"  height=\"25\"  OnMouseUp=\"Gride_OnMouseUp(this)\"  onclick=\"Row_click(this)\" ondblclick=\"Row_Dbclick(this)\"  >");
                 else
                     StrBuf.append("<tr class=\"gridEvenRow\" edit=false state=\"past\"   height=\"25\"  OnMouseUp=\"Gride_OnMouseUp(this)\"    onclick=\"Row_click(this)\" ondblclick=\"Row_Dbclick(this)\" >");
              
             
                 if(checkbl)
                 {
                     cellStr = "<td noWrap align=\"center\"   width=\"30\" >  <input class=\"checkbox\"  type=\"checkbox\" style=\"borderStyle :none\"  name=\"chkchild_" + fgridID + "\"  onclick=\"checkChildClick('child_" + fgridID + "')\"></td>";
                     StrBuf.append(cellStr);
                 }
                 for(int j = 0; j < gridRS.getColumnCount() - 1; j++)
                     StrBuf.append(getEditFieldCell(j));
        
                 StrBuf.append("</tr>");
                 
                 
             }else
             {
                                                        
                    StrBuf.append("<tr  bgcolor=\""+gridRS.getString(gridRS.getColumnCount() - 2)+ "\"  edit=false state=\"past\"   height=\"25\"  OnMouseUp=\"Gride_OnMouseUp(this)\"    onclick=\"Row_click(this)\" ondblclick=\"Row_Dbclick(this)\" >");
                    if(checkbl)
                    {
                         cellStr = "<td noWrap align=\"center\"   width=\"30\" >  <input class=\"checkbox\"  type=\"checkbox\" style=\"borderStyle :none\"  name=\"chkchild_" + fgridID + "\"  onclick=\"checkChildClick('child_" + fgridID + "')\"></td>";
                         StrBuf.append(cellStr);
                    }
                    
                    for(int j = 0; j < gridRS.getColumnCount() - 2; j++)
                         StrBuf.append(getEditFieldCell(j));
            
                     StrBuf.append("</tr>");
             }
              
              
              
             return StrBuf.toString();
         }
         catch(Exception exception)
         {
             throw exception;
         }
     }
     
     private String getFieldGrid()  throws Exception
     {
         try
         {
             int RecorderIndex = 0;
             StringBuffer StrBuf = new StringBuffer();
             
             while(gridRS != null && gridRS.next()) 
             {
                 StrBuf.append(getFieldROW(RecorderIndex));
                 RecorderIndex++;
             }
             return StrBuf.toString();
         }
         catch(Exception exception)
         {
             throw exception;
         }
     }
    
     private String getNOTitleGridEnd() throws Exception
     {
         try
         {
             StringBuffer stringbuffer = new StringBuffer();
             stringbuffer.append("<tr class=\"gridEvenRow\" >");
             stringbuffer.append("<td  colspan=\"" + (gridRS.getColumnCount() - 1) + "\"class=\"borderGrooveT\" >");
             stringbuffer.append("<div  class=\"scrollpane\"  id=\"divb_" + fgridID + "\" style=\"TOP:0px; height:25px \">");
             stringbuffer.append("<table id=\"bottom_" + fgridID + "\" width=\"100%\" height=\"100%\" cellspacing=\"0\" cellpadding=\"0\"><tr  class=\"gridHead\" ><td id=\"all_recordcount\" class=\"statusBarText\" width=\"30%\">总条目:" +RecordCount + "</td>");
             stringbuffer.append("<td width=\"30%\" align =\"right\" > <input class=\"Covert_Button\"  id=\"Covert_Button" + fgridID + "\" type=button  hideFocus=true style=\"height: 22px;width:30px\"   value=转到  onclick='Covert_Click(\"" + fgridID + "\",\"Covert_Button" + fgridID + "\",\"Covert_Text" + fgridID + "\")'>");
             stringbuffer.append("<td width=\"10%\" class=\"statusBarText\" valign=\"top\"><input id=\"Covert_Text" + fgridID + "\" style=\"height: 20px;width:30px\"   value=" + AbsolutePage + " onKeyPress='return newturnPage1_1(\"" + fgridID + "\",\"Covert_Button" + fgridID + "\",\"Covert_Text" + fgridID + "\");' >页</td>");
             stringbuffer.append("<td id=\"all_page\" class=\"statusBarText\" width=\"30%\" > 总页数:" + TotalPage+ "</td>");
             stringbuffer.append("</tr></table></div> </td></tr>");
             stringbuffer.append("</table></form>");
             return stringbuffer.toString();
         }
         catch(Exception exception)
         {
             throw exception;
         }
     }
    
     private String getNOTitleNOEnd()throws Exception
     {
         try
         {
             StringBuffer StrBuf = new StringBuffer();
             StrBuf.append("</table></form>");
             return StrBuf.toString();
         }
         catch(Exception exception)
         {
             throw exception;
         }
     }
    
     private String getTitleNOEnd() throws Exception
     {
         try
         {
             StringBuffer StrBuf = new StringBuffer();
             StrBuf.append("</table></div></td></tr>");
             StrBuf.append("</table></form>");
             return StrBuf.toString();
         }
         catch(Exception exception)
         {
             throw exception;
         }
     }
    
     private String getGridEnd() throws Exception
     {
         StringBuffer StrBuf = new StringBuffer();
         StrBuf.append("</table></div>");
         
         String sumSql      = "";
         String cellStr     = "";
         String fieldValue  = "";
         String fieldAtr    = "";
         
         if(isTotal)
         {
                  
             StrBuf.append("<div  class=\"dbGridTotal\" id=\"divTotal_" + fgridID + "\" onscroll=\"dototalscroll(this);\"  >");
             StrBuf.append("<table   id=\"total_" + fgridID + "\"   border=\"0\" cellspacing=\"1\" cellpadding=\"1\"><tr>");
             if(checkbl)
                 StrBuf.append("<td noWrap align=\"center\"   width=\"30\" >合计</td>");
             
             DatabaseConnection databaseconnection = null;
             try
             {
                 databaseconnection = ConnectionManager.getInstance().getConnection();
                 
                 
                 
                 for(int i = 0; i < gridRS.getColumnCount() - 1; i++)
                 {
                     dictDetail = dictMain.getDictDetail(gridRS.getFieldName(i));
                     fieldValue = "";
                     
                     if(dictDetail != null)
                     {                       
                         if(dictDetail.isFfieldvisible())
                         {
                            
                             if(dictDetail.getFfieldtype().toLowerCase().equals("number") ||dictDetail.getFfieldtype().toLowerCase().equals("money") || dictDetail.getFfieldtype().toLowerCase().equals("int"))
                             {
                                 sumSql = "select sum(" +dictDetail.getFfieldname() + ") from ("+ fSQLStr +" " + fwhereStr + ") temp";
                                 try
                                 {
                                     RecordSet recordset = databaseconnection.executeQuery(sumSql);
                                     if(recordset.next())
                                         fieldValue = recordset.getString(0);
                                     recordset.close();
                                 }
                                 catch(Exception exception2) { }
                             }
                             cellStr = "<td  nowrap width=\"" + dictDetail.getFfieldwidth() + "\"   align =\"" +dictDetail.getFfieldalign() + "\">" + fieldValue + "</td>";
                         } else
                         {
                             cellStr = "<td  style =\"display:none;\">&nbsp;</td>";
                         }
                         StrBuf.append(cellStr);
                     }
                 }
        
             }
             catch(Exception exception1)
             {
                 throw exception1;
             }
             finally
             {
                 if(databaseconnection != null)
                     databaseconnection.close();
             }
             StrBuf.append("</tr></table> </div>");
             
            // if(databaseconnection != null)
             //    databaseconnection.close();
         }
         
         if (isFieldAmbit)
         {
             StrBuf.append("<div  class=\"dbGridTotal\" id=\"divAmbit_" + fgridID + "\" onscroll=\"dototalscroll(this);\"  >");
             StrBuf.append("<table   id=\"ambit_" + fgridID + "\"   border=\"0\" cellspacing=\"1\" cellpadding=\"1\"><tr>");
             if(checkbl)
                 StrBuf.append("<td noWrap align=\"center\"   width=\"30\" >范围</td>");
             
             try
             {                               
                 for(int i = 0; i < gridRS.getColumnCount() - 1; i++)
                 {
                     dictDetail = dictMain.getDictDetail(gridRS.getFieldName(i));
                     fieldValue = "";
                     
                     if(dictDetail != null)
                     {                       
                         if(dictDetail.isFfieldvisible())
                         {
                            
//                           if (!dictDetail.getFfieldminambit().equals("")&&!dictDetail.getFfieldminambitcolor().equals(""))
//                           {
//                               fieldValue =" <font color=\"" + dictDetail.getFfieldminambitcolor()+ "\">" + dictDetail.getFfieldminambit() + "</font>";
//                               fieldAtr    =  dictDetail.getFfieldminambit();
//                           }
//                           
//                           if (!dictDetail.getFfieldmaxambit().equals("")&&!dictDetail.getFfieldmaxambitcolor().equals(""))
//                           {
//                              if (fieldValue.equals(""))
//                              {
//                                   fieldValue  = " <font size='4' color=\"" + dictDetail.getFfieldmaxambitcolor()+ "\">" + dictDetail.getFfieldmaxambit() + "</font>";
//                                   fieldAtr    =  dictDetail.getFfieldmaxambit();
//                              }else
//                              {
//                                  fieldValue  = fieldValue + "~~<font color=\"" + dictDetail.getFfieldmaxambitcolor()+ "\">" + dictDetail.getFfieldmaxambit() + "</font>";
//                                  fieldAtr    =  fieldAtr + "|" + dictDetail.getFfieldmaxambit();
//                              }
//                           }
                             
                             
                             cellStr = "<td  fieldAtr=\"" + fieldAtr + "\" STYLE=\"font: normal bolder 12pt Arial\" nowrap width=\"" + dictDetail.getFfieldwidth() + "\" >" + fieldValue + "</td>";
                         } else
                         {
                             cellStr = "<td  style =\"display:none;\">&nbsp;</td>";
                         }
                         StrBuf.append(cellStr);
                     }
                 }
        
             }
             catch(Exception exception1)
             {
                 throw exception1;
             }
             finally
             {
                 
             }
             StrBuf.append("</tr></table> </div>");
            
         }
         
         StrBuf.append("<div  class=\"divBottom\" id=\"divb_" + fgridID + "\"  >");
         StrBuf.append("<table   id=\"bottom_" + fgridID + "\"  cellspacing=\"0\" cellpadding=\"0\"><tr  class=\"gridHead\" ><td id=\"all_recordcount\" class=\"statusBarText\" width=\"30%\">总条目:" +RecordCount+ "</td>");
         StrBuf.append("<td width=\"30%\" align =\"right\" > <input class=\"Covert_Button\"  id=\"Covert_Button" + fgridID + "\" type=button hideFocus=true   value=转到  onclick='Covert_Click(\"" + fgridID + "\",\"Covert_Button" + fgridID + "\",\"Covert_Text" + fgridID + "\")'>");
         StrBuf.append("<td width=\"10%\" class=\"statusBarText\" valign=\"top\"><input id=\"Covert_Text" + fgridID + "\" tableid=\"" + fgridID + "\"  buttonid=\"Covert_Button" + fgridID + "\"  style=\"height: 20px;width:30px\"   value=" + AbsolutePage + " onKeyPress='return newturnPage1_1(\"" + fgridID + "\",\"Covert_Button" + fgridID + "\",\"Covert_Text" + fgridID + "\");' >页</td>");
         StrBuf.append("<td id=\"all_page\" class=\"statusBarText\" width=\"30%\" > 总页数:" + TotalPage+  "</td>");
         StrBuf.append("</tr></table> </div>");
         StrBuf.append("</form>");
         
         return StrBuf.toString();
    
     }
     

       public void setbuttons(String buttons){

            if(buttons.toLowerCase().equals("readonly"))
                this.buttons ="moveFirst,prevPage,movePrev,moveNext,nextPage,moveLast";
           else if (buttons.toLowerCase().equals("default"))
               this.buttons ="moveFirst,prevPage,movePrev,moveNext,nextPage,moveLast,appendRecord,editRecord,deleteRecord,cancelRecord,updateRecord";
           else if (!buttons.toLowerCase().equals(""))
               this.buttons =buttons;


           if (!this.buttons.toLowerCase().equals(""))
               buttonsArr = this.buttons.split(",",-2);
       }

       public String getDataPilot(){
           
           this.dataPilotID = fgridID +"_Pilot";

           StringBuffer StrBuf = new StringBuffer();

           StrBuf.append("<table class=\"borderDataPilot\" attrib=datapilot  id=\""+dataPilotID+"\" tableName=\"" +fgridID +
                "\"  confirmdelete=" + isconfirmdelete + "  confirmcancel=" + isconfirmcancel + "  directDelete=" + isdirectdelete +  " readonly=true border=0  cellspacing=1 cellpadding=0>");

          StrBuf.append("<tr align=\"center\">");

          for (int i = 0; i < buttonsArr.length; i++) {

             if (buttonsArr[i].equals("moveFirst")) {
                 StrBuf.append("<td  > <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_moveFirst   buttontype=\"moveFirst\"   type=button hideFocus=true style=\"width:30px; font-family: Webdings\" value=\"9\"  title=\"移动到第一页记录\"   onclick=\"dataPilotButton_onclick()\"></td>");
             } else if (buttonsArr[i].equals("prevPage")) {
                 StrBuf.append("<td > <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_prevPage  buttontype=\"prevPage\"   type=button  hideFocus=true style=\"width:30px; font-family: Webdings\" value=\"7\"  title=\"向前翻页\"    onclick=\"dataPilotButton_onclick()\"></td>");
             } else if (buttonsArr[i].equals("movePrev")) {
                 StrBuf.append("<td > <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_movePrev   buttontype=\"movePrev\"   type=button  hideFocus=true style=\"width:30px; font-family: Webdings\" value=\"3\"  title=\"移动到上一条记录\"    onclick=\"dataPilotButton_onclick()\"></td>");
             } else  if (buttonsArr[i].equals("moveNext")) {
                 StrBuf.append("<td> <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_moveNext   buttontype=\"moveNext\"   type=button hideFocus=true style=\"width:30px; font-family: Webdings\" value=\"4\"  title=\"移动到下一条记录\"    onclick=\"dataPilotButton_onclick()\" ></td>");
             } else if (buttonsArr[i].equals("nextPage")) {
                 StrBuf.append("<td > <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_nextPage   buttontype=\"nextPage\"   type=button  hideFocus=true style=\"width:30px; font-family: Webdings\" value=\"8\"  title=\"向后翻页\"    onclick=\"dataPilotButton_onclick()\"></td>");
             } else  if (buttonsArr[i].equals("moveLast")) {
                 StrBuf.append("<td > <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_moveLast   buttontype=\"moveLast\"  type=button  hideFocus=true style=\"width:30px; font-family: Webdings\" value=\":\"  title=\"移动到最后一页记录\"    onclick=\"dataPilotButton_onclick()\"></td>");
             }
             
             if (buttonsArr[i].equals("insertRecord")) {
                 StrBuf.append("<td> <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_insertRecord   buttontype=\"insertRecord\"  type=button  hideFocus=true style=\"width:45px\" value=\"插入\"  title=\"插入一条新记录\"    onclick=\"dataPilotButton_onclick()\"></td>");
             } else   if (buttonsArr[i].equals("appendRecord")) {
                 StrBuf.append("<td> <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_appendRecord   buttontype=\"appendRecord\"  type=button  hideFocus=true style=\"width:45px\" value=\"添加\"  title=\"添加一条新记录\"    onclick=\"dataPilotButton_onclick()\"></td>");
             } else   if (buttonsArr[i].equals("editRecord")) {
                 StrBuf.append("<td> <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_editRecord   buttontype=\"editRecord\"  type=button  hideFocus=true style=\"width:45px\" value=\"修改\"  title=\"修改当前记录\"    onclick=\"dataPilotButton_onclick()\"></td>");
             } else if (buttonsArr[i].equals("deleteRecord")) {
                 StrBuf.append("<td> <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_deleteRecord   buttontype=\"deleteRecord\"  type=button  hideFocus=true style=\"width:45px\" value=\"删除\"  title=\"删除当前记录\"   onclick=\"dataPilotButton_onclick()\"></td>");
             } else  if (buttonsArr[i].equals("cancelRecord")) {
                 StrBuf.append("<td> <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_cancelRecord   buttontype=\"cancelRecord\"  type=button  hideFocus=true style=\"width:45px\" value=\"撤销\"  title=\"撤销对当前记录的修改\"    onclick=\"dataPilotButton_onclick()\"></td>");
             } else  if (buttonsArr[i].equals("updateRecord")) {
                 StrBuf.append("<td> <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_updateRecord   buttontype=\"updateRecord\"   type=button  hideFocus=true style=\"width:45px\" value=\"确认\"  title=\"确认对当前记录的修改\"    onclick=\"dataPilotButton_onclick()\"></td>");
             }
            
             String[] buttonArr = Basic.splite(buttonsArr[i], "=");
             if (buttonArr.length > 1) {
                     StrBuf.append("<td> <input class=\"buttonGrooveDisable\" id=" + dataPilotID + "_" +buttonArr[1] + " buttontype=\"" + buttonArr[1] +
                    "\"   type=button  hideFocus=true style=\" fontFamily: Webdings\" value=\"" +buttonArr[0] + "\"      onclick=\"dataPilotButton_onclick()\"></td>");
            }


        }
        StrBuf.append("</tr></table>");
        return StrBuf.toString();

       }

}
