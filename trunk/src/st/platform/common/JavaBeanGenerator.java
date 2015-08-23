

package st.platform.common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import st.platform.utils.Config;


public class JavaBeanGenerator {
	public  String SCHEMA="DB2ADMIN";
	
	
      private OutputStreamWriter  fos;

     public JavaBeanGenerator() {
    	 try
    	 {
    	 	SCHEMA = Config.getProperty("db2Schema");
    	 }catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
     }

     private void generateHead(String packageStr) {
          try {
               fos.write(("package "+packageStr+";\n"));
          } catch ( Exception e ) {

          }
     }

     private void generateImport() {
          try {
               String importStr = "import java.util.*;\nimport st.platform.db.*;\n import st.platform.db.sql.*;\nimport st.platform.control.business.ActionRequest;\n";
               fos.write(importStr);
          } catch ( Exception e ) {

          }
     }

     private void generateUtilMethod(String className) {
          String utilMethod =
                 "     public static List find(String sSqlWhere) throws Exception{ "
               + "          return new " + className + "().findByWhere(sSqlWhere); "
               + "     } "
               + " "
               + "     public static List findAndLock(String sSqlWhere)throws Exception { "
               + "          return new " + className + "().findAndLockByWhere(sSqlWhere); "
               + "     } "
               + " "
               + "     public static " + className + " findFirst(String sSqlWhere)throws Exception { "
               + "          return (" + className + ")new " + className + "().findFirstByWhere(sSqlWhere); "
               + "     } "
               + " "
               + "     public static " + className + " findFirstAndLock(String sSqlWhere)throws Exception { "
               + "          return (" + className + ")new " + className + "().findFirstAndLockByWhere(sSqlWhere); "
               + "     } "
               + "      "
               + "     public static RecordSet findRecordSet(String sSqlWhere) throws Exception{ "
               + "          return new " + className + "().findRecordSetByWhere(sSqlWhere); "
               + "     } "
               + " "
               + "     public static List find(String sSqlWhere,boolean isAutoRelease)throws Exception { "
               + "          " + className + " bean = new " + className + "(); "
               + "          bean.setAutoRelease(isAutoRelease); "
               + "          return bean.findByWhere(sSqlWhere); "
               + "     } "
               + " "
               + "     public static List findAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{ "
               + "          " + className + " bean = new " + className + "(); "
               + "          bean.setAutoRelease(isAutoRelease); "
               + "          return bean.findAndLockByWhere(sSqlWhere); "
               + "     } "
               + " "
               + "     public static " + className + " findFirst(String sSqlWhere,boolean isAutoRelease)throws Exception { "
               + "          " + className + " bean = new " + className + "(); "
               + "          bean.setAutoRelease(isAutoRelease); "
               + "          return (" + className + ")bean.findFirstByWhere(sSqlWhere); "
               + "     } "
               + " "
               + "     public static " + className + " findFirstAndLock(String sSqlWhere,boolean isAutoRelease) throws Exception{ "
               + "          " + className + " bean = new " + className + "(); "
               + "          bean.setAutoRelease(isAutoRelease); "
               + "          return (" + className + ")bean.findFirstAndLockByWhere(sSqlWhere); "
               + "     } "
               + " "
               + "     public static RecordSet findRecordSet(String sSqlWhere,boolean isAutoRelease)throws Exception { "
               + "          " + className + " bean = new " + className + "(); "
               + "          bean.setAutoRelease(isAutoRelease); "
               + "          return bean.findRecordSetByWhere(sSqlWhere); "
               + "     } ";

          try {
               fos.write(utilMethod);
          } catch(IOException ex) {

          }

     }
     public static String   raoluan2()
  	{  		
  		DatabaseAgent.raoluan1();
  		return Keycode.projectKey.substring(8,12)+ Keycode.dateKey.substring(14,16);  				
  	}
     
     
     public void generate(String classPath,String className,String tablename) throws Exception{
//    	 SCHEMA="stdb";
    	 if ( className == null || tablename == null || classPath == null ) {
               System.out.println("Error!");
               return;
          }
         
         String engPath = Config.getProperty("file");
         String filepath = "src/"+classPath.replace('.','/')+"/";
         if(engPath!=null)
         {
              filepath = engPath + "/src/"+classPath.replace('.','/')+"/";
         }
      
          tablename = tablename.toUpperCase();
          System.out.println("======生成javabean: ࡾ     " + filepath+className+".javabean======");
          try {
              FileOutputStream  stream = new FileOutputStream(filepath+className + ".java"); 
              fos = new OutputStreamWriter(stream,"UTF-8"); 
               generateHead(classPath);
               generateImport();
               fos.write(("public class "+className+" extends AbstractBasicBean implements Cloneable {\n"));
               fos.write(("private static final long serialVersionUID = 1L;\n"));
               generateUtilMethod(className); //zw changed 20050127
               ConnectionManager cm = ConnectionManager.getInstance();
               DatabaseConnection dc = cm.get();
               //fos.write(("private SQLMaker sqlMaker = new SQLMaker();\n"));
               
               String sql="";
               RecordSet rs ;
               
               if (dc.DbType.equals("DB2"))
               {            	   
            	   	sql =" SELECT name FROM SYSIBM.SYSCOLUMNS where tbcreator='"+SCHEMA+"' and tbname='" + tablename + "'"; 
            	   	 rs = dc.executeQuery(sql);
                     while ( rs != null && rs.next() ) {
                          fos.write(("String  " + rs.getString(0).toLowerCase() + ";\n"));
                     }
               }
               else if (dc.DbType.equalsIgnoreCase("mysql")) {//add by Lgao,2006.12.28
					sql = "select column_name ,column_comment from information_schema.columns where table_schema='"
							+ SCHEMA + "' and table_name='" + tablename + "'";
					rs = dc.executeQuery(sql);
					while (rs != null && rs.next()) {
						System.out.println(("String  " + rs.getString("column_name").toLowerCase() + "; //"+rs.getString("column_comment")+" \n"));
                        fos.write(("String  " + rs.getString("column_name").toLowerCase() + "; //"+rs.getString("column_comment")+" \n"));
					}
				}else if (dc.DbType.equalsIgnoreCase("sqlserver")) {//add by Wj,2010.07.16
					sql = "select column_name from information_schema.columns where table_catalog='"
						+ SCHEMA + "' and table_name='" + tablename + "'";
				rs = dc.executeQuery(sql);
				while (rs != null && rs.next()) {
					fos.write(("String  " + rs.getString(0).toLowerCase() + ";\n"));
				}
			}
               else
               {  
            	   		sql = " select case coltype " +            	   
                               " when 'NUMBER' then " +
                                    " case when scale > 0 then " +
                                    " 'String '||lower(cname)||';' "+
                                    " else "+
                                    " 'String '||lower(cname)||';' " +
                                    " end " +
                                    " when 'DATE' then  " +
                                    " 'String '||lower(cname)||';' " +
                                    " else " +
                                    " 'String '||lower(cname)||';' " +
                                    " end " +
                                    " from sys.col where tname='"+ tablename+"' order by colno ";
            	   		
            	   		
	            	   	 rs = dc.executeQuery(sql);
	                     while ( rs != null && rs.next() ) {
	                          fos.write((rs.getString(0)+"\n"));
	                     }
               }

               fos.write(("public static final String TABLENAME =\""+tablename.toLowerCase()+"\";\n"));
               fos.write(("private String operate_mode = \"add\";\n")); //dd
               fos.write(("public ChangeFileds cf = new ChangeFileds();\n"));//dd
               fos.write("public String getTableName() {return TABLENAME;}\n");
               fos.write(" @SuppressWarnings(\"unchecked\")\n");
               fos.write("public void addObject(List list,RecordSet rs) {\n");
               fos.write((className+" abb = new "+className+"();\n"));
              
               if (dc.DbType.equals("DB2"))
               {   
            		sql =" SELECT name FROM SYSIBM.SYSCOLUMNS where tbcreator='"+SCHEMA+"' and tbname='" + tablename + "'"; 
	
	               rs = dc.executeQuery(sql);
	
	               while ( rs != null && rs.next() ) {
	            	   fos.write(("abb." + rs.getString(0).toLowerCase() + "=rs.getString(\"" + rs.getString(0).toLowerCase() + "\");\n"));
                       fos.write(("abb.setKeyValue(\"" + rs.getString(0).toUpperCase() + "\",\"\" + abb.get" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() +"());\n")); 
	               }        	   
    	   
               }
               else if (dc.DbType.equalsIgnoreCase("mysql")) {//add by Lgao,2006.12.28
					sql = "select column_name from information_schema.columns where table_schema='"
							+ SCHEMA + "' and table_name='" + tablename + "'";
					rs = dc.executeQuery(sql);
	               while ( rs != null && rs.next() ) {
	            	   fos.write(("abb." + rs.getString(0).toLowerCase() + "=rs.getString(\"" + rs.getString(0).toLowerCase() + "\");\n"));
                       fos.write(("abb.setKeyValue(\"" + rs.getString(0).toUpperCase() + "\",\"\" + abb.get" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() +"());\n")); 
	               }        	   
				} else if (dc.DbType.equalsIgnoreCase("sqlserver")) {//add by Wj,2010.07.16
					sql = "select column_name from information_schema.columns where table_catalog='"
						+ SCHEMA + "' and table_name='" + tablename + "'";
				rs = dc.executeQuery(sql);
               while ( rs != null && rs.next() ) {
            	   fos.write(("abb." + rs.getString(0).toLowerCase() + "=rs.getString(\"" + rs.getString(0).toLowerCase() + "\");\n"));
                   fos.write(("abb.setKeyValue(\"" + rs.getString(0).toUpperCase() + "\",\"\" + abb.get" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() +"());\n")); 
               }        	   
			}
               else
               {
            	   		sql =
	                    " select case coltype " +
	                    "   when 'NUMBER' then "+
	                    "     case when scale > 0 then "+
	                    "       'abb.'||lower(cname)||'=rs.getString(\"'|| lower(cname) ||'\");'||'abb.setKeyValue(\"'||upper(cname)||'\",\"\"+abb.get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'());' "+
	                    "     else " +
	                    "       'abb.'||lower(cname)||'=rs.getString(\"'|| lower(cname) ||'\");'||'abb.setKeyValue(\"'||upper(cname)||'\",\"\"+abb.get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'());' "+
	                    "   end " +
	                    "   when 'DATE' then "+
	                    "       'abb.'||lower(cname)||'=rs.getTimeString(\"'|| lower(cname) ||'\");'||'abb.setKeyValue(\"'||upper(cname)||'\",\"\"+abb.get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'());' "+
	                    "  else " +
	                    "       'abb.'||lower(cname)||'=rs.getString(\"'|| lower(cname) ||'\");'||'abb.setKeyValue(\"'||upper(cname)||'\",\"\"+abb.get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'());' "+
	                    "  end " +
	                    " from sys.col where tname='"+tablename+"' order by colno";
	
	               rs = dc.executeQuery(sql);
	
	               while ( rs != null && rs.next() ) {
	                    fos.write((rs.getString(0)+"\n"));
	               }
               }
               
               
               
               fos.write("list.add(abb);\n");
               fos.write("abb.operate_mode = \"edit\";\n");
               fos.write("}");
               
               if (dc.DbType.equals("DB2"))
               {   
            		sql =" SELECT name,coltype,scale  FROM SYSIBM.SYSCOLUMNS where tbcreator='"+SCHEMA+"' and tbname='" + tablename + "'"; 
	
	               rs = dc.executeQuery(sql);
	
	               while ( rs != null && rs.next() ) {
	            	   fos.write(("public String get" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() +"(){"));
	            	   fos.write((" if ( this." + rs.getString(0).toLowerCase() +" == null)"));
	            	   if (rs.getString(1).equals("TIMESTMP")) {
	            		   fos.write(("{ return \"\"; } else {return this."+ rs.getString(0).toLowerCase()+".split(\"\\\\.\")[0];}}"));
	            	   } else if (rs.getString(1).equals("DECIMAL")) {
	            		   /*	if  (Integer.parseInt(rs.getString(2))==4) 
	            		   		fos.write(("{ return \"\"; } else {return this."+ rs.getString(0).toLowerCase()+".substring(0,this."+rs.getString(0).toLowerCase()+".length()-2);}}"));
	            		   	else if  (Integer.parseInt(rs.getString(2))==6)
	            		   		fos.write(("{ return \"\"; } else {return this."+ rs.getString(0).toLowerCase()+".substring(0,this."+rs.getString(0).toLowerCase()+".length()-4);}}"));
	            		   	else*/
	            		   		fos.write(("{ return \"\"; } else {return this."+ rs.getString(0).toLowerCase()+";}}"));	  
	                }
            		   else {
	            	        fos.write(("{ return \"\"; } else {return this."+ rs.getString(0).toLowerCase()+";}}"));	            		   
	            	   }
	               }        	   
    	   
               }
               else if (dc.DbType.equalsIgnoreCase("mysql")){
           			sql =" SELECT column_name,data_type,''  FROM information_schema.columns where table_schema='"+ SCHEMA + "' and table_name='" + tablename + "'"; 
           		
	               rs = dc.executeQuery(sql);
	
	               while ( rs != null && rs.next() ) {
	            	   fos.write(("public String get" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() +"(){"));
	            	   fos.write((" if ( this." + rs.getString(0).toLowerCase() +" == null)"));
	            	   if (rs.getString(1).equals("TIMESTMP")) {
	            		   fos.write(("{ return \"\"; } else {return this."+ rs.getString(0).toLowerCase()+".split(\"\\\\.\")[0];}}"));
	            	   }
	         		   else {
		            	   fos.write(("{ return \"\"; } else {return this."+ rs.getString(0).toLowerCase()+";}}"));	            		   
	            	   }
	               }        	   
               }else if (dc.DbType.equalsIgnoreCase("sqlserver")){
          			sql =" SELECT column_name,data_type,''  FROM information_schema.columns where table_catalog='"+ SCHEMA + "' and table_name='" + tablename + "'"; 
               		
 	               rs = dc.executeQuery(sql);
 	
 	               while ( rs != null && rs.next() ) {
 	            	   fos.write(("public String get" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() +"(){"));
 	            	   fos.write((" if ( this." + rs.getString(0).toLowerCase() +" == null)"));
 	            	   if (rs.getString(1).equals("TIMESTMP")) {
 	            		   fos.write(("{ return \"\"; } else {return this."+ rs.getString(0).toLowerCase()+".split(\"\\\\.\")[0];}}"));
 	            	   }
 	         		   else {
 		            	   fos.write(("{ return \"\"; } else {return this."+ rs.getString(0).toLowerCase()+";}}"));	            		   
 	            	   }
 	               }        	   
                }
               else
               {
		               String getterSql =
		                    " select case coltype " +
		                    " when 'NUMBER' then " +
		                    "   case when scale > 0 then "+
		                    "     'public String get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'() { if ( this.'||lower(cname)||' == null ) { return \"\"; } else {return this.'||lower(cname)||'; } }'  " +
		                    "   else " +
		                    "     'public String get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'() { if ( this.'||lower(cname)||' == null ) { return \"\"; } else {return this.'||lower(cname)||'; } }'  " +
		                    "   end " +
		                    " when 'DATE' then  "+
		                    "   'public String get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'() {  if ( this.'||lower(cname)||' == null ) { return \"\"; } else { return this.'||lower(cname)||'.trim().split(\" \")[0];} }'||" +
		                    "   'public String get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'Time() {  if ( this.'||lower(cname)||' == null ) return \"\"; return this.'||lower(cname)||'.split(\"\\\\.\")[0];}'  " +
		                    " else " +
		                    "   'public String get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'() { if ( this.'||lower(cname)||' == null ) return \"\"; return this.'||lower(cname)||';}'       " +
		                    " end " +
		                    " from sys.col where tname='"+tablename+"' order by colno";
		//               System.out.println(getterSql);
		               rs = dc.executeQuery(getterSql);
		               while ( rs != null && rs.next() ) {
		                    fos.write((rs.getString(0)+"\n"));
		               }
               }
               
               
               
               if (dc.DbType.equals("DB2"))
               {   
            		sql =" SELECT name,coltype FROM SYSIBM.SYSCOLUMNS where tbcreator='"+SCHEMA+"' and tbname='" + tablename + "'"; 
	
	                rs = dc.executeQuery(sql);
	
	                while ( rs != null && rs.next() ) {
	            	   fos.write(("public void set" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() +"( String " + rs.getString(0).toLowerCase()+"){"));
	            	   
	            	   if (rs.getString(1).toUpperCase().equals("DECIMAL")|| rs.getString(1).toUpperCase().equals("INTEGER")|| rs.getString(1).toUpperCase().equals("BIGINT")|| rs.getString(1).toUpperCase().equals("DOUBLE")|| rs.getString(1).toUpperCase().equals("SMALLINT"))
	            	   {
	            		   fos.write(("sqlMaker.setField(\""+ rs.getString(0).toLowerCase() +"\"," + rs.getString(0).toLowerCase() +"," + "Field.NUMBER);\n"));
	            	   }else
	            	   {
	            		   fos.write(("sqlMaker.setField(\""+ rs.getString(0).toLowerCase() +"\"," + rs.getString(0).toLowerCase() +"," + "Field.TEXT);\n"));
	            	   } 
	            	   fos.write(("if (this.operate_mode.equals(\"edit\")) {\n"));
	            	   fos.write(("if (!this.get" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() + "().equals("+rs.getString(0).toLowerCase()+"))\n"));
	            	   fos.write(("cf.add(\""+ rs.getString(0).toLowerCase() +"\",this." + rs.getString(0).toLowerCase() +"," + rs.getString(0).toLowerCase()+");\n"));
	            	   fos.write(("}\n"));
	            	   fos.write(("this." + rs.getString(0).toLowerCase() +"=" + rs.getString(0).toLowerCase()+";\n" ));
	            	   
	            	   fos.write(("}\n"));
	               }        	   
    	   
               }
               else if(dc.DbType.equalsIgnoreCase("mysql")){
	           		sql =" SELECT column_name,data_type,''  FROM information_schema.columns where table_schema='"+ SCHEMA + "' and table_name='" + tablename + "'"; 
	           		
	                rs = dc.executeQuery(sql);
	
	                while ( rs != null && rs.next() ) {
	            	   fos.write(("public void set" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() +"( String " + rs.getString(0).toLowerCase()+"){"));
	            	   
	            	   if (rs.getString(1).toUpperCase().equalsIgnoreCase("DECIMAL")|| rs.getString(1).toUpperCase().equalsIgnoreCase("INTEGER")|| rs.getString(1).toUpperCase().equalsIgnoreCase("BIGINT")|| rs.getString(1).toUpperCase().equalsIgnoreCase("DOUBLE")|| rs.getString(1).toUpperCase().equalsIgnoreCase("SMALLINT"))
	            	   {
	            		   fos.write(("sqlMaker.setField(\""+ rs.getString(0).toLowerCase() +"\"," + rs.getString(0).toLowerCase() +"," + "Field.NUMBER);\n"));
	            	   }else
	            	   {
	            		   fos.write(("sqlMaker.setField(\""+ rs.getString(0).toLowerCase() +"\"," + rs.getString(0).toLowerCase() +"," + "Field.TEXT);\n"));
	            	   } 
	            	   fos.write(("if (this.operate_mode.equals(\"edit\")) {\n"));
	            	   fos.write(("if (!this.get" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() + "().equals("+rs.getString(0).toLowerCase()+"))\n"));
	            	   fos.write(("cf.add(\""+ rs.getString(0).toLowerCase() +"\",this." + rs.getString(0).toLowerCase() +"," + rs.getString(0).toLowerCase()+");\n"));
	            	   fos.write(("}\n"));
	            	   fos.write(("this." + rs.getString(0).toLowerCase() +"=" + rs.getString(0).toLowerCase()+";\n" ));
	            	   
	            	   fos.write(("}\n"));
	               }        	   
               }else if(dc.DbType.equalsIgnoreCase("sqlserver")){
	           		sql =" SELECT column_name,data_type,''  FROM information_schema.columns where table_catalog='"+ SCHEMA + "' and table_name='" + tablename + "'"; 
	           		
	                rs = dc.executeQuery(sql);
	
	                while ( rs != null && rs.next() ) {
	            	   fos.write(("public void set" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() +"( String " + rs.getString(0).toLowerCase()+"){"));
	            	   
	            	   if (rs.getString(1).toUpperCase().equalsIgnoreCase("DECIMAL")|| rs.getString(1).toUpperCase().equalsIgnoreCase("INTEGER")|| rs.getString(1).toUpperCase().equalsIgnoreCase("BIGINT")|| rs.getString(1).toUpperCase().equalsIgnoreCase("DOUBLE")|| rs.getString(1).toUpperCase().equalsIgnoreCase("SMALLINT"))
	            	   {
	            		   fos.write(("sqlMaker.setField(\""+ rs.getString(0).toLowerCase() +"\"," + rs.getString(0).toLowerCase() +"," + "Field.NUMBER);\n"));
	            	   }else
	            	   {
	            		   fos.write(("sqlMaker.setField(\""+ rs.getString(0).toLowerCase() +"\"," + rs.getString(0).toLowerCase() +"," + "Field.TEXT);\n"));
	            	   } 
	            	   fos.write(("if (this.operate_mode.equals(\"edit\")) {\n"));
	            	   fos.write(("if (!this.get" + rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase() + "().equals("+rs.getString(0).toLowerCase()+"))\n"));
	            	   fos.write(("cf.add(\""+ rs.getString(0).toLowerCase() +"\",this." + rs.getString(0).toLowerCase() +"," + rs.getString(0).toLowerCase()+");\n"));
	            	   fos.write(("}\n"));
	            	   fos.write(("this." + rs.getString(0).toLowerCase() +"=" + rs.getString(0).toLowerCase()+";\n" ));
	            	   
	            	   fos.write(("}\n"));
	               }        	   
               }
               else
               {
	               String setterSql =
	                    " select case coltype "+
	                    "        when 'NUMBER' then "+
	                    "            case when scale > 0 then"+
	                    "              'public void set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(String '||lower(cname)||') { sqlMaker.setField(\"'||lower(cname)||'\",\"\"+'||lower(cname)||',Field.NUMBER); if (this.operate_mode.equals(\"edit\")) { if (this.get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'()!='||lower(cname)||') cf.add(\"'||lower(cname)||'\",this.'||lower(cname)||'+\"\",'||lower(cname)||'+\"\"); } this.'||lower(cname)||'='||lower(cname)||';}'"+
	                    "            else "+
	                    "              'public void set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(String '||lower(cname)||') { sqlMaker.setField(\"'||lower(cname)||'\",\"\"+'||lower(cname)||',Field.NUMBER); if (this.operate_mode.equals(\"edit\")) { if (this.get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'()!='||lower(cname)||') cf.add(\"'||lower(cname)||'\",this.'||lower(cname)||'+\"\",'||lower(cname)||'+\"\"); } this.'||lower(cname)||'='||lower(cname)||';}' "+
	                    "            end "+
	                    "        when 'DATE' then "+
	                    "           'public void set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(String '||lower(cname)||') { sqlMaker.setField(\"'||lower(cname)||'\",'||lower(cname)||',Field.DATE); if (this.operate_mode.equals(\"edit\")) { if (!this.get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'().equals('||lower(cname)||')) cf.add(\"'||lower(cname)||'\",this.'||lower(cname)||','||lower(cname)||'); } this.'||lower(cname)||'='||lower(cname)||';}' "+
	                    "        else "+
	                    "           'public void set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(String '||lower(cname)||') { sqlMaker.setField(\"'||lower(cname)||'\",'||lower(cname)||',Field.TEXT); if (this.operate_mode.equals(\"edit\")) { if (!this.get'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'().equals('||lower(cname)||')) cf.add(\"'||lower(cname)||'\",this.'||lower(cname)||','||lower(cname)||'); } this.'||lower(cname)||'='||lower(cname)||';}' "+
	                    "        end "+
	                    " from sys.col where tname='"+tablename+"' order by colno";
	//               System.out.println(setterSql);
	               rs = dc.executeQuery(setterSql);
	               while ( rs != null && rs.next() ) {
	                    fos.write((rs.getString(0)+"\n"));
	               }
               }
               
               
               
               
               fos.write("public void init(int i,ActionRequest actionRequest) throws Exception { ");
               
               if (dc.DbType.equals("DB2"))
               {   
            	   sql =" SELECT name,coltype FROM SYSIBM.SYSCOLUMNS where tbcreator='"+SCHEMA+"' and tbname='" + tablename + "'";
            	   rs = dc.executeQuery(sql);            		
	               while ( rs != null && rs.next() ) {	                	
	            	    fos.write(("if (actionRequest.getFieldValue(i, \""+ rs.getString(0).toLowerCase()+ "\") != null) \n"));
	            	    fos.write(("this.set"+ rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase()+"(actionRequest.getFieldValue(i, \""+rs.getString(0).toLowerCase()+"\"));\n"));
	           		
	               }
               }else if (dc.DbType.equalsIgnoreCase("mysql")){
            	   sql =" SELECT column_name,data_type,''  FROM information_schema.columns where table_schema='"+ SCHEMA + "' and table_name='" + tablename + "'";
            		   
            	   rs = dc.executeQuery(sql);            		
	               while ( rs != null && rs.next() ) {	                	
	            	    fos.write(("if (actionRequest.getFieldValue(i, \""+ rs.getString(0).toLowerCase()+ "\") != null) \n"));
	            	    fos.write(("this.set"+ rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase()+"(actionRequest.getFieldValue(i, \""+rs.getString(0).toLowerCase()+"\"));\n"));
	               }
               }else if (dc.DbType.equalsIgnoreCase("sqlserver")){
            	   sql =" SELECT column_name,data_type,''  FROM information_schema.columns where table_catalog='"+ SCHEMA + "' and table_name='" + tablename + "'";
            		   
            	   rs = dc.executeQuery(sql);            		
	               while ( rs != null && rs.next() ) {	                	
	            	    fos.write(("if (actionRequest.getFieldValue(i, \""+ rs.getString(0).toLowerCase()+ "\") != null) \n"));
	            	    fos.write(("this.set"+ rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase()+"(actionRequest.getFieldValue(i, \""+rs.getString(0).toLowerCase()+"\"));\n"));
	               }
               }
               else
               {
	               String initSql =
	                    " select  case coltype " +
	                    " when 'NUMBER' then " +
	                    " case when scale > 0 then " +
	                    " 'if ( actionRequest.getFieldValue(i,\"'||lower(cname)||'\") !=null && actionRequest.getFieldValue(i,\"'||lower(cname)||'\").trim().length() > 0 ) {' ||'this.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(actionRequest.getFieldValue(i,\"'||lower(cname)||'\"));}' " +
	                    " else " +
	                    " 'if ( actionRequest.getFieldValue(i,\"'||lower(cname)||'\") !=null && actionRequest.getFieldValue(i,\"'||lower(cname)||'\").trim().length() > 0 ) {' ||'this.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(actionRequest.getFieldValue(i,\"'||lower(cname)||'\"));}' " +
	                    " end " +
	                    " when 'DATE' then " +
	                    " 'if ( actionRequest.getFieldValue(i,\"'||lower(cname)||'\") !=null ) {' ||'this.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(actionRequest.getFieldValue(i,\"'||lower(cname)||'\"));}' " +
	                    " else " +
	                    " 'if ( actionRequest.getFieldValue(i,\"'||lower(cname)||'\") !=null ) {' ||'this.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(actionRequest.getFieldValue(i,\"'||lower(cname)||'\"));}' " +
	                    " end " +
	                    " from sys.col where tname='"+tablename+"' order by colno";
	           
	               rs = dc.executeQuery(initSql);
	               while ( rs != null && rs.next() ) {
	                    fos.write((rs.getString(0)+"\n"));
	               }
               }  
               
               fos.write("}");


               fos.write("public void init(ActionRequest actionRequest) throws Exception { ");
               fos.write("this.init(0,actionRequest);");
               fos.write("}");

//==========initAll
//               String initAllSql =
//                    " select  case coltype " +
//                    " when 'NUMBER' then " +
//                    " case when scale > 0 then " +
//                    " 'if ( actionRequest.getFieldValue(i,\"'||lower(cname)||'\") !=null && actionRequest.getFieldValue(i,\"'||lower(cname)||'\").trim().length() > 0 ) {' ||'this.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(actionRequest.getFieldValue(i,\"'||lower(cname)||'\"));} ' " +
//                    " else " +
//                    " 'if ( actionRequest.getFieldValue(i,\"'||lower(cname)||'\") !=null && actionRequest.getFieldValue(i,\"'||lower(cname)||'\").trim().length() > 0 ) {' ||'this.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(actionRequest.getFieldValue(i,\"'||lower(cname)||'\"));} ' " +
//                    " end " +
//                    " when 'DATE' then " +
//                    " 'if ( actionRequest.getFieldValue(i,\"'||lower(cname)||'\") !=null ) {' ||'this.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(actionRequest.getFieldValue(i,\"'||lower(cname)||'\"));} else {'||'this.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(null);}' " +
//                    " else " +
//                    " 'if ( actionRequest.getFieldValue(i,\"'||lower(cname)||'\") !=null ) {' ||'this.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(actionRequest.getFieldValue(i,\"'||lower(cname)||'\"));} else {'||'this.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(null);}' " +
//                    " end " +
//                    " from sys.col where tname='"+tablename+"' order by colno";


//               System.out.println(initAllSql);
               fos.write("public void initAll(int i,ActionRequest actionRequest) throws Exception { ");
//               rs = dc.executeQuery(initAllSql);
//               while ( rs != null && rs.next() ) {
//                    fos.write((rs.getString(0)+"\n"));
//               }
               fos.write("this.init(i,actionRequest);");
               fos.write("}");


               fos.write("public void initAll(ActionRequest actionRequest) throws Exception { ");
               fos.write("this.initAll(0,actionRequest);");
               fos.write("}");

               //==========initAll

               
               
               fos.write("public Object clone() throws CloneNotSupportedException { ");
               fos.write((className+" obj = ("+className+")super.clone();"));
               
               if (dc.DbType.equals("DB2"))
               {   
            	   sql =" SELECT name,coltype FROM SYSIBM.SYSCOLUMNS where tbcreator='"+SCHEMA+"' and tbname='" + tablename + "'";
            	   rs = dc.executeQuery(sql);            		
	               while ( rs != null && rs.next() ) {	                	
	            	    fos.write(("obj.set"+ rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase()+ "(obj."+ rs.getString(0).toLowerCase()+");\n"));           	    
	           		
	               }
               }else  if (dc.DbType.equalsIgnoreCase("mysql")){
            	   sql =" SELECT column_name,data_type,''  FROM information_schema.columns where table_schema='"+ SCHEMA + "' and table_name='" + tablename + "'";
            	   rs = dc.executeQuery(sql);            		
	               while ( rs != null && rs.next() ) {	                	
	            	    fos.write(("obj.set"+ rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase()+ "(obj."+ rs.getString(0).toLowerCase()+");\n"));           	    
	           		
	               }
               }else  if (dc.DbType.equalsIgnoreCase("sqlserver")){
            	   sql =" SELECT column_name,data_type,''  FROM information_schema.columns where table_catalog='"+ SCHEMA + "' and table_name='" + tablename + "'";
            	   rs = dc.executeQuery(sql);            		
	               while ( rs != null && rs.next() ) {	                	
	            	    fos.write(("obj.set"+ rs.getString(0).substring(0,1).toUpperCase() + rs.getString(0).substring(1).toLowerCase()+ "(obj."+ rs.getString(0).toLowerCase()+");\n"));           	    
	           		
	               }
               }
               else
               {             
               
	               String cloneSql =
	                    " select  case coltype " +
	                    " when 'NUMBER' then " +
	                    " case when scale > 0 then " +
	                    " 'obj.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(obj.'||lower(cname)||');' " +
	                    " else " +
	                    " 'obj.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(obj.'||lower(cname)||');' " +
	                    " end " +
	                    " when 'DATE' then " +
	                    " 'obj.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(obj.'||lower(cname)||');' " +
	                    " else " +
	                    " 'obj.set'||substr(cname,1,1)||lower(substr(cname,2,length(cname)-1))||'(obj.'||lower(cname)||');' " +
	                    " end " +
	                    " from sys.col where tname='"+tablename+"' order by colno";
	
	               rs = dc.executeQuery(cloneSql);
	               while ( rs != null && rs.next() ) {
	                    fos.write((rs.getString(0)+"\n"));
	               }
               }
               
               fos.write("return obj;");
               fos.write("}");
               rs.close();
               cm.release();
               fos.write("}");

               fos.flush();
               fos.close();
          } catch ( Exception e ) {
               e.printStackTrace();
               System.out.println("*******产生类【"+filepath+className+".java】失败！*******");
          }
          System.out.println("======产生类【"+filepath+className+".java】成功！======");
     }
     public static void main(String args[]){
	 JavaBeanGenerator tt=new JavaBeanGenerator(); 
}
}
