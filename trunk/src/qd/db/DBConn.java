/**
 * 数据库连接辅助工具类
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

	// 定义JDBC连接数据库的辅助字符串
	private final String DRIVER = st.platform.utils.Config.getProperty("qddriver");

	private final String URL = st.platform.utils.Config.getProperty("qdurl");

	private final String USERNAME = st.platform.utils.Config.getProperty("qdusername");

	private final String PWD = st.platform.utils.Config.getProperty("qdpwd");
	
	public LogManager logManager;
	// 定义JDBC的数据库连接接口
	private Connection conn = null;

	/**
	 * 默认构造器
	 * 
	 */
	public DBConn() {
		// 第一步,加载数据库驱动程序类
		try {
			Class.forName(DRIVER); 
		} catch (ClassNotFoundException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * 获取一个可用的数据库连接对象引用
	 * 
	 * @return
	 */
	public Connection getConnection() {
		// 第二步,创建数据库连接连接对象
		try {
			//if (conn == null || conn.isClosed()) { com.microsoft.sqlserver.jdbc.SQLServerDriver
			if (conn == null  ) {   
				conn = DriverManager.getConnection(URL, USERNAME, PWD);
			}
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}

		return conn;
	}

	/**
	 * 关闭数据库连接并释放所有的JDBC资源
	 * 
	 */
	public void closeConnection() {
		// 最后一步,关闭数据库连接
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}
			conn = null;
		}
	}

	/**
	 * 返回指定查询SQL语句的结果集对象引用
	 * 
	 * @param sql
	 * @return
	 */
	public ResultSet getResult(String sql) {
		Statement stmt = null;
		ResultSet rs = null;

		// 建立数据库连接对象
		getConnection();

		try {
			// 创建SQL执行对象
			stmt = conn.createStatement();

			// 执行查询语句
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * 执行指定的更新SQL语句
	 * 
	 * @param sql
	 * @return
	 */
	public boolean executeSQL(String sql) {
		Statement stmt = null;
        boolean rt=false;
		// 建立数据库连接对象
		try {
			// 创建SQL执行对象
			stmt = conn.createStatement();
       
			// 执行查询语句
			int result = stmt.executeUpdate(sql);

			if (result > 0)
				rt = true;
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} finally {
			return rt;
		}

		
	}
	 public ResultSet executeQuery(String sql, int beginIndex, int resultNo) throws SQLException, Exception {
//	        if (sql == null || sql.trim().length() == 0) {
//	            if (logManager != null)
//	                logManager.setError("操作数据库语句为空！");
//	            return null;
//	        }
	        try {
	            String pageSql = "";
	            sql = DBUtil.toDB(sql);
	            Statement st = conn.createStatement(1004, 1007);
	            
	                //order by 的起始位置
	                int index=sql.toLowerCase().indexOf("order");
	                String orderStr="";
	                int pageNum = 0;
	                if (beginIndex > resultNo) {
	                    pageNum = (int) Math.floor(beginIndex / resultNo);
	                }
	                if (index==-1) {
	                    //没有order by 语句的情况
	                    //截去select
	                    String tmpStr=sql.substring(sql.toLowerCase().indexOf("select")+6);
	                    //截出首字段--带空格
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
