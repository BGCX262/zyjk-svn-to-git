package st.platform.db.sql;

import java.util.*;
import java.io.Serializable;

public class SQLMaker implements Serializable {
     public void setField(String name, String value, int type) {
          //if (value==null) {
           //    value = "";
          //}
          Field field = new Field(name, value, type ,"=");
          fields.put(name, field);
     }

     public void setField(String name, String value, int type,String relative) {
          //if (value==null) {
          //     value = "";
         // }
          Field field = new Field(name, value, type, relative);
          fields.put(name, field);
     }

     public void setField(Field field) {
          if (field==null) {
               return;
          }
          fields.put(field.getName(), field);
     }

     public String getDeleteSQL() {
          return deleteSQL;
     }

     public String getUpdateSQL() {
          StringBuffer sb = new StringBuffer();
          Object[] name = fields.keySet().toArray();
          for(int i = 0; i < name.length; i++) {
               if(i == 0)
                    sb.append(" set ");
               if(i == name.length - 1)
                    sb.append(((Field)fields.get(name[i])).getUpdateField()).append(" ");
               else
                    sb.append(((Field)fields.get(name[i])).getUpdateField()).append(",");
          }
          updateSQL = tableStr + sb.toString() + whereStr;
          return updateSQL;
     }

     public String getInsertSQL() {
    	 try{
	          StringBuffer sb = new StringBuffer();
	          Object[] name = fields.keySet().toArray();
	          for(int i = 0; i < name.length; i++) {
	               if(i == 0)
	                    sb.append(" ( ");
	               if(i == name.length - 1)
	                    sb.append((String)name[i]).append(" )");
	               else
	                    sb.append((String)name[i]).append(",");
	          }
	          insertSQL = tableStr + sb.toString();
	
	          sb = new StringBuffer();
	          for(int i = 0; i < name.length; i++)
	          {
	               if(i == 0)
	                    sb.append(" values ( ");
	               if(i == name.length - 1)
	                    sb.append(((Field)fields.get(name[i])).getInsertField()).append(" )");
	               else
	                    sb.append(((Field)fields.get(name[i])).getInsertField()).append(",");
	          }
	          insertSQL = insertSQL + sb.toString();
    	 }catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }

          return insertSQL;
     }

     public String getDeleteWhereSQL() {
          StringBuffer sb = new StringBuffer();
          Object[] name = fields.keySet().toArray();
          for(int i = 0; i < name.length; i++) {
               if(i == 0)
                    sb.append(" where ");
               if(i == name.length - 1)
                    sb.append(((Field)fields.get(name[i])).getDeleteField()).append(" ");
               else
                    sb.append(((Field)fields.get(name[i])).getDeleteField()).append(" and ");
          }
          return sb.toString();
     }

     public String getQueryWhereSQL() {
          StringBuffer sb = new StringBuffer();
          Object[] name = fields.keySet().toArray();
          for(int i = 0; i < name.length; i++) {
               if(i == 0)
                    sb.append(" where ");
               if(i == name.length - 1)
                    sb.append(((Field)fields.get(name[i])).getQueryField()).append(" ");
               else
                    sb.append(((Field)fields.get(name[i])).getQueryField()).append(" and ");
          }

          return sb.toString();
     }

     public String getSelectSQL() {
          return selectSQL;
     }

     public static void main(String[] args) {
          SQLMaker maker = new SQLMaker();
          maker.setField("name", null, Field.TEXT);
          maker.setField("age", "", Field.NUMBER);
          maker.setField("addr", "dddddd", Field.TEXT);
          maker.setField("born", "2003-03-04", Field.DATE);
          maker.setField("open", "2003-03-04 12:12:12", Field.DATETIME);
          System.out.println(maker.getDeleteWhereSQL());

     }

     public void setTableStr(String tableStr) {
          this.tableStr = tableStr;
     }

     public void setWhereStr(String whereStr) {
          this.whereStr = whereStr;
     }

     public SQLMaker() {
          fields = new HashMap();
     }
     public void init() {
          fields.clear();
          deleteSQL = "";
          updateSQL = "";
          selectSQL = "";
          insertSQL = "";
          tableStr = "";
          whereStr = "";
     }

     public boolean isEmpty() {
         return fields.isEmpty();
     }

     private String deleteSQL = "";
     private String updateSQL = "";
     private String selectSQL = "";
     private String insertSQL = "";
     private String tableStr = "";
     private String whereStr = "";
     private HashMap fields;
}
