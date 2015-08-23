/**
 * 数据库连接辅助工具类
 * @author xulin
 * @version 1.0
 * @since 2007-09-03
 */
package worksynch.db;

import java.sql.*;
 

public class DBConn {

	// 定义JDBC连接数据库的辅助字符串
	private final String DRIVER = st.platform.utils.Config.getProperty("zjdriver");

	private final String URL = st.platform.utils.Config.getProperty("zjurl");

	private final String USERNAME = st.platform.utils.Config.getProperty("zjusername");

	private final String PWD = st.platform.utils.Config.getProperty("zjpwd");

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
