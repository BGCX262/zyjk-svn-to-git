package st.platform.security;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.List;
import st.platform.common.MenuBean;
import st.platform.db.ConnectionManager;
import st.platform.db.DBUtil;
import st.platform.db.DatabaseConnection;
import st.portal.system.dao.PtOperBean;
import st.portal.system.dao.PtdeptBean;

public class OperatorManager
  implements Serializable
{
  private String operatorname = null;
  private String operatorid = null;

  private String xmlString = null;

  private String[] roles = new String[0];
  private MenuBean mb;
  private List jsplist = null;
  private PtOperBean operator;
  private PtdeptBean dept;
  private String remoteAddr = null;
  private String remoteHost = null;
  private boolean isLogin = false;
  private String filePath = "";
  private String safySign = "";

  private String fportalCss = "";
  private String fportalImg = "/css/";
  private String fportalID = "1";
  private String fwebpath = "";

  private String fdistcode = "";

  private String ffgdeptID = "";
  private String fimgSign;

  public String getXmlString()
  {
    return this.xmlString;
  }

  public PtOperBean getOperator()
  {
    return this.operator;
  }

  public PtdeptBean getDept()
  {
    return this.dept;
  }

  public String getSysDeptID()
  {
    this.ffgdeptID = "";
    try
    {
      this.ffgdeptID = DBUtil.getCellValue("PTOPER", "deptid", " deptid like'" + this.fdistcode + "%' and  opertype ='99'");
    }
    catch (Exception localException)
    {
    }
    return this.ffgdeptID;
  }

  public String getFgdeptID()
  {
    this.ffgdeptID = "";
    try
    {
      this.ffgdeptID = DBUtil.getCellValue("ptdept", "deptid", " deptid like'" + this.fdistcode + "%' and  mkdm ='4'");
    }
    catch (Exception localException)
    {
    }
    return this.ffgdeptID;
  }

  public String getFgdeptName()
  {
    this.ffgdeptID = "";
    try
    {
      this.ffgdeptID = DBUtil.getCellValue("ptdept", "deptName", " deptid like'" + this.fdistcode + "%' and  mkdm ='4'");
    }
    catch (Exception localException)
    {
    }
    return this.ffgdeptID;
  }

  public String getFMzdeptID()
  {
    this.ffgdeptID = "";
    try
    {
      this.ffgdeptID = DBUtil.getCellValue("ptdept", "deptid", " deptid like'" + this.fdistcode + "%' and  mkdm ='5'");
    }
    catch (Exception localException)
    {
    }
    return this.ffgdeptID;
  }

  public String getFmzdeptName()
  {
    this.ffgdeptID = "";
    try
    {
      this.ffgdeptID = DBUtil.getCellValue("ptdept", "deptName", " deptid like'" + this.fdistcode + "%' and  mkdm ='5'");
    }
    catch (Exception localException)
    {
    }
    return this.ffgdeptID;
  }

  public boolean getIsSysTemOperator()
  {
    return this.operator.getOpertype().trim().equals("99");
  }

  public boolean getIsPTDept()
  {
    return this.dept.getMkdm().equals("1");
  }

  public boolean getIsFGDept()
  {
    return this.dept.getMkdm().equals("4");
  }

  public boolean getIsMZDept()
  {
    return this.dept.getMkdm().equals("5");
  }

  public boolean getIsJDDept()
  {
    return this.dept.getMkdm().equals("2");
  }

  public boolean getIsBSCDept()
  {
    return this.dept.getMkdm().equals("3");
  }

  public String getDistCode()
  {
    return this.fdistcode;
  }

  public String filePath()
  {
    return this.filePath;
  }

  public String getPortalCss()
  {
    return this.fportalCss;
  }

  public String getportalImg()
  {
    return this.fportalImg;
  }

  public String getportalID() {
    return this.fportalID;
  }

  public void setWebPath(String webPath) {
    this.fportalImg = (webPath + "/css/");
  }

  public String getOperatorName()
  {
    return this.operator.getOpername();
  }

  public String getOperatorId()
    throws Exception
  {
    return this.operatorid;
  }

  public boolean login(String operid, String password)
  {
    try
    {
      String loginWhere = "where operid='" + operid + "' and operpasswd ='" + password + "'";

      System.out.println(loginWhere + "=====================");
      this.operatorid = operid;
      this.operator = new PtOperBean();
      this.operator = ((PtOperBean)this.operator.findFirstByWhere(loginWhere));
      System.out.println(this.operator == null);

      if (this.operator == null) {
        System.out.println("operator is null");
        this.isLogin = false;
      } else {
        System.out.println("bosdfffff");
        this.dept = new PtdeptBean();
        this.dept = ((PtdeptBean)this.dept.findFirstByWhere("where DEPTID ='" + this.operator.getDeptid() + "'"));

        this.fdistcode = this.dept.getDeptid().substring(0, 2);

        this.isLogin = true;

        this.operatorname = this.operator.getOpername();
        try
        {
          this.mb = new MenuBean();

          this.xmlString = this.mb.generateStream(operid);
        }
        catch (Exception ex3) {
          ex3.printStackTrace();
          System.err.println("Wrong when getting menus of operator: [ " + ex3 + "]");
        }
      }
      return this.isLogin;
    } catch (Exception e) {
      e.printStackTrace();
    }return false;
  }

  public boolean login(String name, String password, String deptid, String logintype)
  {
    try
    {
      ConnectionManager cm = ConnectionManager.getInstance();
      DatabaseConnection dc = cm.get();

      String loginWhere = "where deptid='" + deptid + "' and operpasswd ='" + password + "' and  replace(opername,' ','') ='" + name + "' ";

      System.out.println(loginWhere);
      this.operator = new PtOperBean();
      this.operator = ((PtOperBean)this.operator.findFirstByWhere(loginWhere));
      this.operatorid = this.operator.getOperid();

      if (this.operator == null)
      {
        this.isLogin = false;
      }
      else {
        this.dept = new PtdeptBean();
        this.dept = ((PtdeptBean)this.dept.findFirstByWhere("where DEPTID ='" + deptid + "'"));
        this.fdistcode = this.dept.getDeptid().substring(0, 2);
        this.isLogin = true;
        this.operatorname = this.operator.getOpername();
        try
        {
          this.mb = new MenuBean();
          this.xmlString = this.mb.generateStream(this.operator.getOperid());
        }
        catch (Exception ex3)
        {
          ex3.printStackTrace();
          System.err.println("Wrong when getting menus of operator: [ " + ex3 + "]");
        }
      }
      return this.isLogin;
    } catch (Exception e) {
      e.printStackTrace();
    }return false;
  }

  public List getJspList()
  {
    return this.jsplist;
  }

  public boolean isLogin()
  {
    return this.isLogin;
  }

  public void logout()
  {
    this.isLogin = false;

    this.operator = null;
    this.operatorname = null;
    this.operatorid = null;
    this.roles = null;
    this.mb = null;
    this.xmlString = null;
    this.remoteHost = null;
    this.remoteAddr = null;
  }
  public String setRemoteAddr() {
    return this.remoteAddr;
  }

  public void setRemoteAddr(String remoteAddr) {
    this.remoteAddr = remoteAddr;
  }

  public void setRemoteHost(String remoteHost) {
    this.remoteHost = remoteHost;
  }

  private void createImgSign() {
    this.fimgSign = "";
    try
    {
      int rad = (int)Math.round(Math.random() * 10.0D);
      if (rad == 10)
        rad = 9;
      this.fimgSign += rad;

      rad = (int)Math.round(Math.random() * 10.0D);
      if (rad == 10)
        rad = 9;
      this.fimgSign += rad;

      rad = (int)Math.round(Math.random() * 10.0D);
      if (rad == 10)
        rad = 9;
      this.fimgSign += rad;

      rad = (int)Math.round(Math.random() * 10.0D);
      if (rad == 10)
        rad = 9;
      this.fimgSign += rad;
    }
    catch (Exception localException)
    {
    }
  }

  public String getImgSign()
  {
    return this.fimgSign;
  }
}