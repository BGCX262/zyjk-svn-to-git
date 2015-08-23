package st.platform.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import st.platform.common.LogManager;

public class DatabaseConnection
{
  private Connection connect;
  private boolean isAuto = true;

  private int layers = 0;

  public String DbType = "";
  public LogManager logManager;

  public DatabaseConnection(String dbPool)
    throws SQLException, Exception
  {
    try
    {
      Hashtable prop = new Hashtable();

      Context initCtx = new InitialContext(prop);

      DataSource ds = (DataSource)initCtx.lookup(dbPool);

      this.connect = ds.getConnection();
    }
    catch (SQLException ex) {
      if (this.logManager != null) {
        this.logManager.setError(ex);
      }
      throw ex;
    } catch (Exception e) {
      if (this.logManager != null)
        this.logManager.setError(e);
      throw e;
    }
  }

  public DatabaseConnection(String sDBDriver, String sConnStr, String user, String passwd)
    throws SQLException, Exception
  {
    try
    {
      Class.forName(sDBDriver).newInstance();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    try
    {
      this.connect = DriverManager.getConnection(sConnStr, user, passwd);
    }
    catch (SQLException ex) {
      if (this.logManager != null) {
        this.logManager.setError(ex);
      }
      throw ex;
    } catch (Exception ex) {
      if (this.logManager != null) {
        this.logManager.setError(ex);
      }
      throw ex;
    }
  }

  public void begin()
  {
    this.isAuto = false;
    try {
      if (this.connect.getAutoCommit())
        this.connect.setAutoCommit(false);
    } catch (SQLException sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle);
    }
    this.layers += 1;
  }

  public void commit()
  {
    if (!this.isAuto) {
      this.layers -= 1;
      if (this.layers == 0)
        try {
          this.connect.commit();
          this.connect.setAutoCommit(true);
          this.isAuto = true;
        } catch (SQLException sqle) {
          if (this.logManager != null)
            this.logManager.setError(sqle);
        }
    }
  }

  public void rollback()
  {
    if (!this.isAuto) {
      this.layers = 0;
      try {
        this.connect.rollback();
        this.isAuto = true;
      } catch (SQLException sqle) {
        if (this.logManager != null)
          this.logManager.setError(sqle);
      }
    }
  }

  public int executeUpdate(String sql)
    throws SQLException, Exception
  {
    if ((sql == null) || (sql.trim().length() == 0)) {
      if (this.logManager != null)
        this.logManager.setError("操作数据库语句为空！");
      return -1000;
    }
    try {
      if (this.logManager != null)
        this.logManager.setSql(sql);
      Statement st = this.connect.createStatement();
      int result = st.executeUpdate(sql);
      st.close();
      return result;
    } catch (SQLException sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle);
      throw sqle;
    } catch (Exception sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle); 
      throw sqle;
    }
    
  }

  public RecordSet executeQuery(String sql)
    throws SQLException, Exception
  {
    if ((sql == null) || (sql.trim().length() == 0)) {
      if (this.logManager != null)
        this.logManager.setError("操作数据库语句为空！");
      return null;
    }
    try {
      if (this.logManager != null)
        this.logManager.setSql(sql);
      Statement st = this.connect.createStatement();

      ResultSet rs = st.executeQuery(DBUtil.toDB(sql));
      RecordSet records = new RecordSet(rs);

      rs.close();
      st.close();
      return records;
    } catch (SQLException sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle);
      throw sqle;
    } catch (Exception sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle); 
      throw sqle;
    }
  
  }

  public ResultSet executeResultSetQuery(String sql) throws SQLException, Exception
  {
    if ((sql == null) || (sql.trim().length() == 0))
    {
      if (this.logManager != null)
        this.logManager.setError("操作数据库语句为空！");
      return null;
    }
    try {
      if (this.logManager != null)
        this.logManager.setSql(sql);
      Statement st = this.connect.createStatement();
      ResultSet rs = st.executeQuery(DBUtil.toDB(sql));
      return rs;
    } catch (SQLException sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle);
      throw sqle;
    } catch (Exception sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle); 
      throw sqle;
    }
   
  }

  public String getOrdedStr(String sql)
    throws Exception
  {
    if ((sql == null) || (sql.trim().length() == 0)) {
      return "";
    }
    if (sql.toLowerCase().trim().lastIndexOf(" desc") > 0) {
      return sql.replaceFirst(" desc", "");
    }
    return sql + " desc";
  }

  public RecordSet executeQuery(String fSQLStr, String fwhereStr, String forderStr, int beginIndex, int resultNo, int RecordCount)
    throws SQLException, Exception
  {
    String sql = fSQLStr + " " + fwhereStr + " " + forderStr;

    if ((sql == null) || (sql.trim().length() == 0)) {
      if (this.logManager != null)
        this.logManager.setError("操作数据库语句为空！");
      return new RecordSet();
    }
    try
    {
      String pageSql = "";
      sql = DBUtil.toDB(sql);
      Statement st = this.connect.createStatement(1004, 1007);
      if (this.DbType.equals("DB2")) {
        pageSql = " select * from (SELECT ta.*, ROWNUMBER() OVER ()  rn FROM ( " + sql + ") ta FETCH FIRST " + (
          beginIndex - 1 + resultNo) + " ROW ONLY) tb where tb.rn>" + (beginIndex - 1);
      }
      else if (this.DbType.equalsIgnoreCase("mysql"))
      {
        st.executeQuery("set @rownum=0");
        pageSql = "select t1.*,(@rownum:=@rownum+1) as rownum from (" + sql + " limit " + (beginIndex - 1) + 
          "," + resultNo + ") t1";
      } else if (this.DbType.equalsIgnoreCase("sqlserver"))
      {
        String orderStr = "";
        String tmpSql = "";
        tmpSql = fSQLStr.substring(fSQLStr.indexOf(" "));
        if ((forderStr == null) || (forderStr.equals(""))) {
          String orderF = tmpSql.substring(0, tmpSql.indexOf(","));
          forderStr = " order by " + orderF;
        }
        orderStr = forderStr.replaceAll("\\s[a-zA-Z]*\\.", " ");

        int pageNum = 0;
        if (beginIndex > resultNo) {
          pageNum = (int)Math.floor(beginIndex / resultNo);
        }
        fSQLStr = "SELECT  *,row_number() over(" + orderStr + ") as row from (" + fSQLStr + " " + fwhereStr + ") b";
        if (beginIndex - 1 + resultNo > RecordCount)
        {
          pageSql = "select * from (" + fSQLStr + ")a where row between " + beginIndex + " and " + 
            RecordCount;
        }
        else
        {
          pageSql = "select * from (" + fSQLStr + ")a where row between " + beginIndex + " and " + 
            (pageNum + 1) * resultNo;
        }
      }
      else
      {
        pageSql = " select * from ( select t1.*, rownum rnum from ( " + sql + " ) t1 where rownum<= " + (
          beginIndex - 1 + resultNo) + " ) t2 where t2.rnum> " + (beginIndex - 1);
      }

      if (this.logManager != null)
        this.logManager.setSql(pageSql);
      ResultSet rs = st.executeQuery(pageSql);
      RecordSet records = new RecordSet(rs);

      rs.close();
      st.close();
      return records;
    } catch (SQLException sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle);
      throw sqle;
    } catch (Exception sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle); 
      throw sqle;
    }
   
  }

  public RecordSet executeQuery(String sql, int beginIndex, int resultNo)
    throws SQLException, Exception
  {
    if ((sql == null) || (sql.trim().length() == 0)) {
      if (this.logManager != null)
        this.logManager.setError("操作数据库语句为空！");
      return new RecordSet();
    }
    try {
      String pageSql = "";
      sql = DBUtil.toDB(sql);
      Statement st = this.connect.createStatement(1004, 1007);
      if (this.DbType.equals("DB2")) {
        pageSql = " select * from (SELECT ta.*, ROWNUMBER() OVER ()  rn FROM ( " + 
          sql + ") ta FETCH FIRST " + (beginIndex - 1 + resultNo) + 
          " ROW ONLY) tb where tb.rn>" + (beginIndex - 1);
      } else if (this.DbType.equalsIgnoreCase("mysql")) {
        st.executeQuery("set @rownum=0");
        pageSql = "select t1.*,(@rownum:=@rownum+1) as rownum from (" + sql + 
          " limit " + (beginIndex - 1) + "," + resultNo + ") t1";
      }
      else if (this.DbType.equalsIgnoreCase("sqlserver"))
      {
        int index = sql.toLowerCase().indexOf("order");
        String orderStr = "";
        if (index == -1)
        {
          String tmpStr = sql.substring(sql.toLowerCase().indexOf("select") + 6);

          tmpStr = tmpStr.substring(0, tmpStr.indexOf(","));
          orderStr = " order by " + tmpStr;
        } else {
          orderStr = sql.substring(index).replaceAll(";", " ");
        }
        orderStr = orderStr.replaceAll("\\s[a-zA-Z]*\\.", " ");
        String sqlStr = "SELECT  *,row_number() over(" + orderStr + ") as row from (" + sql + ") b";

        pageSql = "select * from (" + sqlStr + ")a where row between " + beginIndex + " and " + (
          beginIndex + resultNo - 1);
      }
      else {
        pageSql = " select * from ( select t1.*, rownum rnum from ( " + sql + 
          " ) t1 where rownum<= " + (beginIndex - 1 + resultNo) + 
          " ) t2 where t2.rnum> " + (beginIndex - 1);
      }

      ResultSet rs = st.executeQuery(pageSql);
      RecordSet records = new RecordSet(rs);

      rs.close();
      st.close();
      return records;
    } catch (SQLException sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle);
      throw sqle;
    } catch (Exception sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle); 
      throw sqle;
    }
    
  }

  public boolean isExist(String sql)
    throws SQLException, Exception
  {
    if ((sql == null) || (sql.trim().length() == 0)) {
      if (this.logManager != null)
        this.logManager.setError("操作数据库语句为空！");
      return false;
    }
    try
    {
      if (this.logManager != null)
        this.logManager.setSql(sql);
      Statement st = this.connect.createStatement();
      ResultSet rs = st.executeQuery(DBUtil.toDB(sql));
      boolean exist = rs.next();
      rs.close();
      st.close();
      return exist;
    } catch (SQLException sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle);
      throw sqle;
    } catch (Exception sqle) {
      if (this.logManager != null)
        this.logManager.setError(sqle); 
      throw sqle;
    }
   
  }

  public boolean isAuto()
  {
    return this.isAuto;
  }

  public void setAuto(boolean isAuto)
  {
    try
    {
      this.connect.setAutoCommit(isAuto);
    } catch (SQLException sqle) {
      if (this.logManager != null) {
        this.logManager.setError(sqle);
      }
      sqle.printStackTrace();
    }
    this.isAuto = isAuto;
  }

  public void close()
  {
    try
    {
      this.connect.close();
    }
    catch (SQLException ex) {
      if (this.logManager != null)
        this.logManager.setError(ex);
      ex.printStackTrace();
    }
  }

  public PreparedStatement getPreparedStatement(String str)
  {
    if ((str == null) || (str.trim().length() == 0)) {
      if (this.logManager != null)
        this.logManager.setError("操作数据库语句为空！");
      return null;
    }
    try
    {
      if (this.logManager != null)
        this.logManager.setSql(str);
      PreparedStatement st = this.connect.prepareStatement(str, 1004, 
        1007);
      return st;
    } catch (SQLException ex) {
      if (this.logManager != null)
        this.logManager.setError(ex);
    }
    return null;
  }

  public Connection getConnection()
  {
    return this.connect;
  }
}