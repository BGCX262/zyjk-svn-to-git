package st.platform.utils;

import java.io.FileOutputStream;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;

public class CreateSql {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CreateSql createSql = new CreateSql();
		createSql.gerentSql("ptroleres");

	}
	
	public void gerentSql(String tableName)
	{
		 ConnectionManager cm = ConnectionManager.getInstance();
         DatabaseConnection dc = cm.get();
        
         
         String sql      = "";
         String valueStr ="";
         
        
         RecordSet dateRS ;
         try {
        	 FileOutputStream fos = new FileOutputStream("c:/" + tableName + ".sql");
        	 
        	 dateRS =  dc.executeQuery("select * from " + tableName);
        	 
        	 while(dateRS.next())
        	 {
        		 fos.write(("insert into " + tableName + "( ").getBytes());
        		
        		 
        		 for(int i=0;i< dateRS.getfieldCount();i++)
        		 {
        			 	 if (i==0)
	        			 {
	        				 fos.write(dateRS.getFieldName(i).getBytes());
	        				 
	        				 if (dateRS.getString(dateRS.getFieldName(i)) == null)
	        					 valueStr = "null";
	        				 else
	        					 valueStr = "'"+ dateRS.getString(dateRS.getFieldName(i)) +"'";
	        				 
	        			 }else
	        			 {
	        				 fos.write(("," + dateRS.getFieldName(i)).getBytes());
	        				 
	        				 if (dateRS.getString(dateRS.getFieldName(i)) == null)
	        					 valueStr += ",null";
	        				 else
	        					 valueStr += ",'"+ dateRS.getString(dateRS.getFieldName(i)) +"'";
	        			 }
        		
        		 }
        		 
        		 fos.write((")").getBytes());
        		 
        		 fos.write(("values(" + valueStr +");\n").getBytes());    		
        	 
        	 }
        	 dateRS.close();
        	 cm.release();
             fos.flush();
             fos.close();
		
		} catch ( Exception e ) {
            e.printStackTrace();
            System.out.println("");
       }
	}

}
