package st.platform.db;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SeqGenerator
{
  public static String getSeq(String seqno)
  {
    boolean isOK = true;
    DatabaseConnection dc = null;
    try
    {
      dc = ConnectionManager.getInstance().getConnection();
      dc.begin();
      Connection con = dc.getConnection();
      Statement stmt = con.createStatement();

      String sequence = getNextSeq(stmt, seqno, dc.DbType);

      stmt.close();
      String str1 = sequence;
      return str1;
    }
    catch (Exception e) {
      isOK = false;
      System.out.println(e);
    }
    finally {
      if (dc != null) {
        if (isOK)
          dc.commit();
        else {
          dc.rollback();
        }
        dc.close();
      }
    }
    return "";
  }

  private static String getNextSeq(Statement stmt, String seqno, String dbtype)
    throws Exception
  {
    ResultSet rs = stmt.executeQuery("select * from PTSEQ WHERE SEQNO='" + seqno + "'");
    if (!rs.next()) {
      throw new SeqException("±àºÅ¡¾" + seqno + "¡¿²»´æÔÚ");
    }

    String seqtype = rs.getString("SEQTYPE");

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String ldateString = rs.getString("LDATE");
    Date ldate = sdf.parse(ldateString);
    long basnum = rs.getLong("BASNUM");
    long nums = rs.getLong("NUMS");

    long nextSeq = basnum + 1L;

    Calendar curDate = Calendar.getInstance();
    if (ldate == null) {
      ldate = curDate.getTime();
    }
    sdf = new SimpleDateFormat("yyyy-MM-dd");
    String nextrq = sdf.format(curDate.getTime());

    if (seqtype.equals("A")) {
      sdf = new SimpleDateFormat("yyyy");
      if (!sdf.format(curDate.getTime()).equals(sdf.format(ldate)))
        nextSeq = 1L;
    }
    else if (seqtype.equals("b")) {
      sdf = new SimpleDateFormat("yyMM");
      if (!sdf.format(curDate.getTime()).equals(sdf.format(ldate)))
        nextSeq = 1L;
    }
    else if (seqtype.equals("c")) {
      sdf = new SimpleDateFormat("yyMMdd");
      if (!sdf.format(curDate.getTime()).equals(sdf.format(ldate)))
        nextSeq = 1L;
    }
    else if (seqtype.equals("C")) {
      sdf = new SimpleDateFormat("yyMMdd");
      if (!sdf.format(curDate.getTime()).equals(sdf.format(ldate))) {
        nextSeq = 1L;
      }
    }
    StringBuffer seqsb = new StringBuffer();

    if ((dbtype.equalsIgnoreCase("mysql")) || (dbtype.equalsIgnoreCase("db2")) || (dbtype.equalsIgnoreCase("sqlserver"))) {
      seqsb.append("update PTSEQ set BASNUM=");
      seqsb.append(nextSeq).append(",LDATE='");
      seqsb.append(nextrq).append("'");
      seqsb.append(" WHERE SEQNO='").append(seqno).append("'");
    } else {
      seqsb.append("update PTSEQ set BASNUM=");
      seqsb.append(nextSeq).append(",LDATE=to_date('");
      seqsb.append(nextrq).append("','YYYY-MM-DD')");
      seqsb.append(" WHERE SEQNO='").append(seqno).append("'");
    }
    stmt.execute(seqsb.toString());
    rs.close();

    seqsb.setLength(0);

    seqsb.append(sdf.format(curDate.getTime()));

    int nextSeqNums = String.valueOf(nextSeq).length();
    for (long i = nums; i > nextSeqNums; i -= 1L) {
      seqsb.append("0");
    }
    seqsb.append(String.valueOf(nextSeq));

    return seqsb.toString();
  }

  public static void main(String[] argv) {
    System.out.println(getSeq("ss"));
  }
}