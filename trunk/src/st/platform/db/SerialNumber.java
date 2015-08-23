package st.platform.db;



public class SerialNumber {

    /**
     * 获得当前的流水号
     * 失败时返回null
     * @param serialName
     * @return
     */
    public static String getNextSerialNo(String serialName) {
        DatabaseConnection dc = null;
        String rtn = null;
        try {
            dc = ConnectionManager.getInstance().getConnection();
            RecordSet rs=null;
            if (dc.DbType.equalsIgnoreCase("mysql")||dc.DbType.equalsIgnoreCase("sqlserver")){//add by gao 2006.12.30
                try {
                rtn=SeqGenerator.getSeq(serialName);
                }
                catch (Exception e) {
                }
            }
            else{
                if (!dc.DbType.equals("DB2"))
                {
                    rs = dc.executeQuery("select " + serialName + ".nextval from dual");
                }else
                {
                    rs = dc.executeQuery("select NEXTVAL  for "+ serialName + " from dual");
                }
                while (rs.next())
                    rtn = rs.getString(0);
                rs.close();
            }
            
        } catch (Exception e) {
            System.out.println("得到序列号失败:"+e);
        } finally {
            if (dc != null)
                dc.close();
        }
        return rtn;
    }

    /**
     * 获得下一个流水号
     * 失败时返回null
     * @param serialName
     * @return
     */
    public static String getCurrSerialNo(String serialName) {
        DatabaseConnection dc = null;
        String rtn = null;
        try {
            dc = ConnectionManager.getInstance().getConnection();
            RecordSet rs = dc.executeQuery("select " + serialName + ".currval from dual");
            while(rs.next())
                rtn = rs.getString(0);
            rs.close();
        } catch (Exception e) {
            System.out.println("得到序列号失败:"+e);
        } finally {
            if (dc != null)
                dc.close();
        }
        return rtn;
    }

    /**
     * 生成一个序列号生成器
     * @param serialName
     * @return
     */
    public static int createSerial(String serialName) {
        DatabaseConnection dc = null;
        int rtn = -1;
        try {
            dc = ConnectionManager.getInstance().getConnection();
            rtn = dc.executeUpdate(serialName);
        } catch (Exception e) {
            System.out.println("生成序列失败:"+e);
        } finally {
            if (dc != null)
                dc.close();
        }
        return rtn;
    }

    /**
     * 删除一个序列号生成器
     * @param serialName
     * @return
     */
    public static int removeSerial(String serialName) {
        DatabaseConnection dc = null;
        int rtn = -1;
        try {
            dc = ConnectionManager.getInstance().getConnection();
            rtn = dc.executeUpdate(serialName);
        } catch (Exception e) {
            System.out.println("删除序列失败:"+e);
        } finally {
            if (dc != null)
                dc.close();
        }
        return rtn;
    }

  public static void main(String[] args) {
      //System.out.println(SerialNumber.createSerial("create sequence aa minvalue 1 maxvalue 9999 start with 1 increment by 1 cache 15 cycle order"));
      //System.out.println(SerialNumber.getNextSerialNo("aa"));
      //System.out.println(SerialNumber.getCurrSerialNo("aa"));
      //System.out.println(SerialNumber.removeSerial("drop sequence aa"));
      System.out.println(SerialNumber.getNextSerialNo("11"));
  }
}
