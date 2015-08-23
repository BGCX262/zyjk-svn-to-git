/**
 * ���ݿ����Ӹ���������
 * @author xulin
 * @version 1.0
 * @since 2007-09-03
 */
package qd.db;

import java.sql.*;

import st.platform.common.LogManager;
import st.platform.db.DBUtil;
import st.platform.db.RecordSet;
 

public class DBConn {

	// ����JDBC�������ݿ�ĸ����ַ���
	private final String DRIVER = st.platform.utils.Config.getProperty("qddriver");

	private final String URL = st.platform.utils.Config.getProperty("qdurl");

	private final String USERNAME = st.platform.utils.Config.getProperty("qdusername");

	private final String PWD = st.platform.utils.Config.getProperty("qdpwd");
	
	public LogManager logManager;
	// ����JDBC�����ݿ����ӽӿ�
	private Connection conn = null;

	/**
	 * Ĭ�Ϲ�����
	 * 
	 */
	public DBConn() {
		// ��һ��,�������ݿ�����������
		try {
			Class.forName(DRIVER); 
		} catch (ClassNotFoundException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡһ�����õ����ݿ����Ӷ�������
	 * 
	 * @return
	 */
	public Connection getConnection() {
		// �ڶ���,�������ݿ��������Ӷ���
		try {
			//if (conn == null || conn.isClosed()) { com.microsoft.sqlserver.jdbc.SQLServerDriver
			if (conn == null  ) {   
				conn = DriverManager.getConnection(URL, USERNAME, PWD);
			}
		} catch (SQLException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * �ر����ݿ����Ӳ��ͷ����е�JDBC��Դ
	 * 
	 */
	public void closeConnection() {
		// ���һ��,�ر����ݿ�����
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO �Զ����� catch ��
				e.printStackTrace();
			}
			conn = null;
		}
	}

	/**
	 * ����ָ����ѯSQL���Ľ������������
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet getResult(String sql) {
		Statement stmt = null;
		ResultSet rs = null;

		// �������ݿ����Ӷ���
		getConnection();

		try {
			// ����SQLִ�ж���
			stmt = conn.createStatement();

			// ִ�в�ѯ���
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * ִ��ָ���ĸ���SQL���
	 * 
	 * @param sql
	 * @return
	 */
	public boolean executeSQL(String sql) {
		Statement stmt = null;
        boolean rt=false;
		// �������ݿ����Ӷ���
		try {
			// ����SQLִ�ж���
			stmt = conn.createStatement();
       
			// ִ�в�ѯ���
			int result = stmt.executeUpdate(sql);

			if (result > 0)
				rt = true;
		} catch (SQLException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		} finally {
			return rt;
		}

		
	}
	 public ResultSet executeQuery(String sql, int beginIndex, int resultNo) throws SQLException, Exception {
//	        if (sql == null || sql.trim().length() == 0) {
//	            if (logManager != null)
//	                logManager.setError("�������ݿ����Ϊ�գ�");
//	            return null;
//	        }
	        try {
	            String pageSql = "";
	            sql = DBUtil.toDB(sql);
	            Statement st = conn.createStatement(1004, 1007);
	            
	                //order by ����ʼλ��
	                int index=sql.toLowerCase().indexOf("order");
	                String orderStr="";
	                int pageNum = 0;
	                if (beginIndex > resultNo) {
	                    pageNum = (int) Math.floor(beginIndex / resultNo);
	                }
	                if (index==-1) {
	                    //û��order by �������
	                    //��ȥselect
	                    String tmpStr=sql.substring(sql.toLowerCase().indexOf("select")+6);
	                    //�س����ֶ�--���ո�
	                    tmpStr=tmpStr.substring(0,tmpStr.indexOf(","));
	                    orderStr=" order by "+tmpStr;
	                }else {
	                    orderStr=sql.substring(index).replaceAll(";", " ");
	                }
	                orderStr=orderStr.replaceAll("\\s[a-zA-Z]*\\.", " ");
	                String sqlStr = "SELECT  top "+resultNo+" * from (" + sql+") a";
	                
	                pageSql = "select * from (" + sqlStr + " where a."+orderStr.replaceAll("order by ", " ").trim()+" not in  (" +
	                			"SELECT TOP "+resultNo*(pageNum)+" "+orderStr.replaceAll("order by ", " ").trim()+" from (" +sql+") b order by b."+orderStr.replaceAll("order by ", " ").trim()+")) a";
	               
	                
	           
	            System.out.println("pageSql" + pageSql);
	            // if(logManager != null)
	            // logManager.setSql(pageSql);
	            System.out.println("pageSql:"+pageSql);
	            ResultSet rs = st.executeQuery(pageSql);
	            //RecordSet records = new RecordSet(rs);

	            //rs.close();
	            //st.close();
	            return rs;
	        } catch (SQLException sqle) {
	            if (logManager != null)
	                logManager.setError(sqle);
	            throw sqle;
	        } catch (Exception sqle) {
	            if (logManager != null)
	                logManager.setError(sqle);
	            throw sqle;
	        }
	    }
	public static void main(String[] args) throws SQLException {
		DBConn access = new DBConn();
		access.getConnection();
		ResultSet rs = access.getResult(" select   CHKNO,QUESTIONNO,QUESTIONDESC,RECTIFYMODE,RECTIFYDT from problems ");
		while(rs.next()) {
		   System.out.println(rs.getString("CHKNO"));
		}
        rs.close();
        access.closeConnection();
	}
}
