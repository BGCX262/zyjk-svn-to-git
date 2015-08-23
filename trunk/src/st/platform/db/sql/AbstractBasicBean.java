package st.platform.db.sql;

import java.io.Serializable;
import java.util.*;
import st.platform.db.*;
import java.sql.SQLException;

public abstract class AbstractBasicBean implements Cloneable,Serializable {
	
     protected SQLMaker sqlMaker = new SQLMaker();
     protected Hashtable keyValues = new Hashtable();  

     protected boolean isAutoRelease = false;//Ĭ���ͷ�Connection
     private   String   fConnID ="";
     
     public int insert() throws SQLException,Exception{
          int insertCount = -1;
          if ( sqlMaker == null ) {
               return insertCount;
          }
          
          ConnectionManager cm  = ConnectionManager.getInstance();
          if (fConnID != null && !fConnID.trim().equals(""))
        	  cm.setConnID(fConnID);
          
          DatabaseConnection dc = cm.get();
          
          dc.begin();
          
          try {
        	  	sqlMaker.setTableStr("insert into "+getTableName()+" ");
        	  	
        	  	String sSql = sqlMaker.getInsertSQL();
        	  	System.out.println(sSql);
                insertCount = dc.executeUpdate(sSql);
                System.out.println(insertCount);
               
          }catch ( SQLException e ) {
              e.printStackTrace();
        	  throw e;              
          } 
          catch ( Exception e ) {
              e.printStackTrace();
        	  throw e;              
          } finally {
               if ( insertCount > 0 ) {
                    dc.commit();
               } else {
                    dc.rollback();
               }
               if ( isAutoRelease )
                    cm.release();
               initSqlMaker();
               return insertCount;
          }
     }

     public int deleteByWhere(String sSqlWhere)throws SQLException,Exception {
          String sSql = "delete from " + getTableName() + " ";
          int deleteCount = -1;
          if ( sSqlWhere != null && sSqlWhere.length() > 0 ) {
               sSql += sSqlWhere;
          }
          
          ConnectionManager cm  = ConnectionManager.getInstance();
          if (fConnID != null && !fConnID.trim().equals(""))
        	  cm.setConnID(fConnID);
          
          DatabaseConnection dc = cm.get();
          dc.begin();
          try {
               System.out.println(sSql);
               deleteCount = dc.executeUpdate(sSql);
               
          }catch ( SQLException e ) {
        	  throw e;              
          }
          catch ( Exception e ) {              
        	  throw e;
          } finally {
               if ( deleteCount >= 0 ) {
                    dc.commit();
               } else {
                    dc.rollback();
               }
               if ( isAutoRelease )
                    cm.release();

               return deleteCount;
          }
     }

     public int updateByWhere(String sSqlWhere)throws SQLException,Exception{
          int uptCount = -1;
          if ( sSqlWhere == null ) {
               return uptCount;
          }

          
          ConnectionManager cm  = ConnectionManager.getInstance();
          if (fConnID != null && !fConnID.trim().equals(""))
        	  cm.setConnID(fConnID);
          
          DatabaseConnection dc = cm.get();
          dc.begin();
          try {
              sqlMaker.setTableStr("update " + getTableName() + " ");
              sqlMaker.setWhereStr(sSqlWhere);
              String sSql = sqlMaker.getUpdateSQL();
              System.out.println(sSql);
              uptCount = dc.executeUpdate(sSql);              
          }catch ( SQLException e ) {
        	  throw e;              
          }
          catch ( Exception e ) {              
        	  throw e;
          } finally {
               if ( uptCount >= 0 ) {
                    dc.commit();
               } else {
                    dc.rollback();
               }

               if ( isAutoRelease )
                    cm.release();

               initSqlMaker();
               return uptCount;
          }
     }

     public boolean isExist(String sSqlWhere)throws SQLException,Exception{
          String sSql = "select * from " + getTableName() + " ";
          if ( sSqlWhere != null && sSqlWhere.length() > 0 ) {
               sSql += sSqlWhere;
          }
          boolean isExist = false;
          
          ConnectionManager cm  = ConnectionManager.getInstance();
          if (fConnID != null && !fConnID.trim().equals(""))
        	  cm.setConnID(fConnID);
          
          DatabaseConnection dc = cm.get();
          try {
              System.out.println(sSql);
               RecordSet rs = dc.executeQuery(sSql);               
               if ( rs != null && rs.next() ) {
                    isExist = true;
               }
               rs.close();
          }
          catch ( SQLException e ) {
        	  throw e;              
          }
          catch ( Exception e ) {               
        	  throw e;
          } finally {
               if ( isAutoRelease )
                    cm.release();
               return isExist;
          }
     }

     public List findByWhere(String sSqlWhere)throws SQLException,Exception{
          String sSql = "select * from " + getTableName() + " ";
          if ( sSqlWhere != null && sSqlWhere.length() > 0 ) {
               sSql += sSqlWhere;
          }

          List list = new ArrayList();
          
          ConnectionManager cm  = ConnectionManager.getInstance();
          if (fConnID != null && !fConnID.trim().equals(""))
        	  cm.setConnID(fConnID);
          
          DatabaseConnection dc = cm.get();

          try {
              System.out.println(sSql);
               RecordSet rs = dc.executeQuery(sSql);              
               while ( rs != null && rs.next() ) {
                   addObject(list,rs);
               }
               rs.close();
          }
          catch ( SQLException e ) {
        	  throw e;              
          }
          catch ( Exception e ) {               
        	  throw e;
          } finally {
               if ( isAutoRelease )
                    cm.release();
               return list;
          }
     }
     public Object findFirstByWhere(String sSqlWhere)throws SQLException,Exception{
          String sSql = "select * from " + getTableName() + " ";
          if ( sSqlWhere != null && sSqlWhere.length() > 0 ) {
               sSql += sSqlWhere;
          }

          List list = new ArrayList();
          
          ConnectionManager cm  = ConnectionManager.getInstance();
          if (fConnID != null && !fConnID.trim().equals(""))
        	  cm.setConnID(fConnID);
          
          DatabaseConnection dc = cm.get();

          try {
               System.out.println(sSql);
               RecordSet rs = dc.executeQuery(sSql);
              
               if ( rs != null && rs.next() ) {
            	   
                   addObject(list,rs);
               }
               rs.close();
          }
          catch ( SQLException e ) {
        	  throw e;              
          }
          catch ( Exception e ) {              
        	  throw e;
          } finally {
               if ( isAutoRelease )
                    cm.release();
               if ( list.size() > 0 )
                    return list.get(0);
               else
                    return null;
          }
     }

     public RecordSet findRecordSetByWhere(String sSqlWhere)throws SQLException,Exception{
          String sSql = "select * from " + getTableName() + " ";
          if ( sSqlWhere != null && sSqlWhere.length() > 0 ) {
               sSql += sSqlWhere;
          }

         

          ConnectionManager cm  = ConnectionManager.getInstance();
          if (fConnID != null && !fConnID.trim().equals(""))
        	  cm.setConnID(fConnID);
          
          DatabaseConnection dc = cm.get();
          RecordSet rs = null;
          try {
              System.out.println(sSql);
               rs = dc.executeQuery(sSql);               
          } catch ( SQLException e ) {
        	  throw e;              
          }
          catch ( Exception e ) {
        	  throw e;
          } finally {
               if ( isAutoRelease )
                    cm.release();
               return rs;
          }
     }

     public List findAndLockByWhere(String sSqlWhere)throws SQLException,Exception{
          String sSql = "select * from " + getTableName() + " ";
          if ( sSqlWhere != null && sSqlWhere.length() > 0 ) {
               sSql += sSqlWhere;
          }
          sSql += " for update ";

          List list = new ArrayList();

          ConnectionManager cm  = ConnectionManager.getInstance();
          if (fConnID != null && !fConnID.trim().equals(""))
        	  cm.setConnID(fConnID);
          
          DatabaseConnection dc = cm.get();

          try {
              System.out.println(sSql);
               RecordSet rs = dc.executeQuery(sSql);              
               while ( rs != null && rs.next() ) {
                   addObject(list,rs);
               }
               rs.close();
          } catch ( SQLException e ) {
        	  throw e;              
          }
          catch ( Exception e ) {               
        	  throw e;
          } finally {
               if ( isAutoRelease )
                    cm.release();
               return list;
          }
     }

     public Object findFirstAndLockByWhere(String sSqlWhere)throws SQLException,Exception{
          String sSql = "select * from " + getTableName() + " ";
          if ( sSqlWhere != null && sSqlWhere.length() > 0 ) {
               sSql += sSqlWhere;
          }
          sSql += " for update ";

          List list = new ArrayList();

          ConnectionManager cm  = ConnectionManager.getInstance();
          if (fConnID != null && !fConnID.trim().equals(""))
        	  cm.setConnID(fConnID);
          
          DatabaseConnection dc = cm.get();

          try {
              System.out.println(sSql);
               RecordSet rs = dc.executeQuery(sSql);
               
               if ( rs != null && rs.next() ) {
            	  
                   addObject(list,rs);
               }
               rs.close();
          } catch ( SQLException e ) {
        	  throw e;              
          } 
          catch ( Exception e ) {               
        	  throw e;
          } finally {
               if ( isAutoRelease )
                    cm.release();
               if ( list.size() > 0 )
                    return list.get(0);
               else
                    return null;
          }
     }

     public void setAutoRelease(boolean autoRelease) {
          this.isAutoRelease = autoRelease;
     }

     public boolean isAutoRelease() {
          return this.isAutoRelease;
     }


     public void initSqlMaker() {
          sqlMaker.init();
     }

     public void setSQLField(String name,String value) {
          sqlMaker.setField(name,value,Field.NUMBER);
     }

     public Object clone()
          throws CloneNotSupportedException {
          AbstractBasicBean obj = (AbstractBasicBean)super.clone();
          obj.sqlMaker = new SQLMaker();

          return obj;
     }

     public void setKeyValue(String key,String value) {
         keyValues.put(key,value);
     }

     public String getKeyValue(String key) {
         return (String)keyValues.get(key);
     }

     public Hashtable getKeyValues() {
         return keyValues;
     }
    

    public SQLMaker getSqlMaker() {
        return sqlMaker;
    }
    public void setConnID(String connID)
    {
    	fConnID = connID;
    }


    public abstract String getTableName() ;
     public abstract void addObject(List list,RecordSet rs);
}
