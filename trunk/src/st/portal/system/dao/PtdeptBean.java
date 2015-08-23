package st.portal.system.dao;

import java.util.*;
import st.platform.db.*;
import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;

public class PtdeptBean extends AbstractBasicBean implements Cloneable {
	public static List find(String sSqlWhere) throws Exception {
		return new PtdeptBean().findByWhere(sSqlWhere);
	}

	public static List findAndLock(String sSqlWhere) throws Exception {
		return new PtdeptBean().findAndLockByWhere(sSqlWhere);
	}

	public static PtdeptBean findFirst(String sSqlWhere) throws Exception {
		return (PtdeptBean) new PtdeptBean().findFirstByWhere(sSqlWhere);
	}

	public static PtdeptBean findFirstAndLock(String sSqlWhere)
			throws Exception {
		return (PtdeptBean) new PtdeptBean().findFirstAndLockByWhere(sSqlWhere);
	}

	public static RecordSet findRecordSet(String sSqlWhere) throws Exception {
		return new PtdeptBean().findRecordSetByWhere(sSqlWhere);
	}

	public static List find(String sSqlWhere, boolean isAutoRelease)
			throws Exception {
		PtdeptBean bean = new PtdeptBean();
		bean.setAutoRelease(isAutoRelease);
		return bean.findByWhere(sSqlWhere);
	}

	public static List findAndLock(String sSqlWhere, boolean isAutoRelease)
			throws Exception {
		PtdeptBean bean = new PtdeptBean();
		bean.setAutoRelease(isAutoRelease);
		return bean.findAndLockByWhere(sSqlWhere);
	}

	public static PtdeptBean findFirst(String sSqlWhere, boolean isAutoRelease)
			throws Exception {
		PtdeptBean bean = new PtdeptBean();
		bean.setAutoRelease(isAutoRelease);
		return (PtdeptBean) bean.findFirstByWhere(sSqlWhere);
	}

	public static PtdeptBean findFirstAndLock(String sSqlWhere,
			boolean isAutoRelease) throws Exception {
		PtdeptBean bean = new PtdeptBean();
		bean.setAutoRelease(isAutoRelease);
		return (PtdeptBean) bean.findFirstAndLockByWhere(sSqlWhere);
	}

	public static RecordSet findRecordSet(String sSqlWhere,
			boolean isAutoRelease) throws Exception {
		PtdeptBean bean = new PtdeptBean();
		bean.setAutoRelease(isAutoRelease);
		return bean.findRecordSetByWhere(sSqlWhere);
	}

	String deptid;
	String deptname;
	String deptdesc;
	String parentdeptid;
	String deptleaf;
	String deptlevel;
	String depttype;
	String dqdm;
	String mkdm;
	String deptindex;
	String deptguid;
	String deptphone;
	String fillstr10;
	String fillstr20;
	String fillstr100;
	String fillstr150;
	String fillint4;
	String fillint6;
	String fillint8;
	String filldbl2;
	String filldbl22;
	String filldbl4;
	String filldate1;
	String filldate2;
	String depttel;
	String deptpost;
	String accounts;
	String accountnm;
	String deptaddr;
	String distcode;
	String createdt;
	String normalpeos;
	String realpeos;
	String managernm;
	String deptinfo;
	String bmjc;
	public static final String TABLENAME = "ptdept";
	private String operate_mode = "add";
	public ChangeFileds cf = new ChangeFileds();

	public String getTableName() {
		return TABLENAME;
	}

	public void addObject(List list, RecordSet rs) {
		PtdeptBean abb = new PtdeptBean();
		abb.deptid = rs.getString("deptid");
		abb.setKeyValue("DEPTID", "" + abb.getDeptid());
		abb.deptname = rs.getString("deptname");
		abb.setKeyValue("DEPTNAME", "" + abb.getDeptname());
		abb.deptdesc = rs.getString("deptdesc");
		abb.setKeyValue("DEPTDESC", "" + abb.getDeptdesc());
		abb.parentdeptid = rs.getString("parentdeptid");
		abb.setKeyValue("PARENTDEPTID", "" + abb.getParentdeptid());
		abb.deptleaf = rs.getString("deptleaf");
		abb.setKeyValue("DEPTLEAF", "" + abb.getDeptleaf());
		abb.deptlevel = rs.getString("deptlevel");
		abb.setKeyValue("DEPTLEVEL", "" + abb.getDeptlevel());
		abb.depttype = rs.getString("depttype");
		abb.setKeyValue("DEPTTYPE", "" + abb.getDepttype());
		abb.dqdm = rs.getString("dqdm");
		abb.setKeyValue("DQDM", "" + abb.getDqdm());
		abb.mkdm = rs.getString("mkdm");
		abb.setKeyValue("MKDM", "" + abb.getMkdm());
		abb.deptindex = rs.getString("deptindex");
		abb.setKeyValue("DEPTINDEX", "" + abb.getDeptindex());
		abb.deptguid = rs.getString("deptguid");
		abb.setKeyValue("DEPTGUID", "" + abb.getDeptguid());
		abb.deptphone = rs.getString("deptphone");
		abb.setKeyValue("DEPTPHONE", "" + abb.getDeptphone());
		abb.fillstr10 = rs.getString("fillstr10");
		abb.setKeyValue("FILLSTR10", "" + abb.getFillstr10());
		abb.fillstr20 = rs.getString("fillstr20");
		abb.setKeyValue("FILLSTR20", "" + abb.getFillstr20());
		abb.fillstr100 = rs.getString("fillstr100");
		abb.setKeyValue("FILLSTR100", "" + abb.getFillstr100());
		abb.fillstr150 = rs.getString("fillstr150");
		abb.setKeyValue("FILLSTR150", "" + abb.getFillstr150());
		abb.fillint4 = rs.getString("fillint4");
		abb.setKeyValue("FILLINT4", "" + abb.getFillint4());
		abb.fillint6 = rs.getString("fillint6");
		abb.setKeyValue("FILLINT6", "" + abb.getFillint6());
		abb.fillint8 = rs.getString("fillint8");
		abb.setKeyValue("FILLINT8", "" + abb.getFillint8());
		abb.filldbl2 = rs.getString("filldbl2");
		abb.setKeyValue("FILLDBL2", "" + abb.getFilldbl2());
		abb.filldbl22 = rs.getString("filldbl22");
		abb.setKeyValue("FILLDBL22", "" + abb.getFilldbl22());
		abb.filldbl4 = rs.getString("filldbl4");
		abb.setKeyValue("FILLDBL4", "" + abb.getFilldbl4());
		abb.filldate1 = rs.getString("filldate1");
		abb.setKeyValue("FILLDATE1", "" + abb.getFilldate1());
		abb.filldate2 = rs.getString("filldate2");
		abb.setKeyValue("FILLDATE2", "" + abb.getFilldate2());
		abb.depttel = rs.getString("depttel");
		abb.setKeyValue("DEPTTEL", "" + abb.getDepttel());
		abb.deptpost = rs.getString("deptpost");
		abb.setKeyValue("DEPTPOST", "" + abb.getDeptpost());
		abb.accounts = rs.getString("accounts");
		abb.setKeyValue("ACCOUNTS", "" + abb.getAccounts());
		abb.accountnm = rs.getString("accountnm");
		abb.setKeyValue("ACCOUNTNM", "" + abb.getAccountnm());
		abb.deptaddr = rs.getString("deptaddr");
		abb.setKeyValue("DEPTADDR", "" + abb.getDeptaddr());
		abb.distcode = rs.getString("distcode");
		abb.setKeyValue("DISTCODE", "" + abb.getDistcode());
		abb.createdt = rs.getString("createdt");
		abb.setKeyValue("CREATEDT", "" + abb.getCreatedt());
		abb.normalpeos = rs.getString("normalpeos");
		abb.setKeyValue("NORMALPEOS", "" + abb.getNormalpeos());
		abb.realpeos = rs.getString("realpeos");
		abb.setKeyValue("REALPEOS", "" + abb.getRealpeos());
		abb.managernm = rs.getString("managernm");
		abb.setKeyValue("MANAGERNM", "" + abb.getManagernm());
		abb.deptinfo = rs.getString("deptinfo");
		abb.setKeyValue("DEPTINFO", "" + abb.getDeptinfo());
		abb.bmjc = rs.getString("bmjc");
		abb.setKeyValue("BMJC", "" + abb.getBmjc());
		list.add(abb);
		abb.operate_mode = "edit";
	}

	public String getDeptid() {
		if (this.deptid == null) {
			return "";
		} else {
			return this.deptid;
		}
	}

	public String getDeptname() {
		if (this.deptname == null) {
			return "";
		} else {
			return this.deptname;
		}
	}

	public String getDeptdesc() {
		if (this.deptdesc == null) {
			return "";
		} else {
			return this.deptdesc;
		}
	}

	public String getParentdeptid() {
		if (this.parentdeptid == null) {
			return "";
		} else {
			return this.parentdeptid;
		}
	}

	public String getDeptleaf() {
		if (this.deptleaf == null) {
			return "";
		} else {
			return this.deptleaf;
		}
	}

	public String getDeptlevel() {
		if (this.deptlevel == null) {
			return "";
		} else {
			return this.deptlevel;
		}
	}

	public String getDepttype() {
		if (this.depttype == null) {
			return "";
		} else {
			return this.depttype;
		}
	}

	public String getDqdm() {
		if (this.dqdm == null) {
			return "";
		} else {
			return this.dqdm;
		}
	}

	public String getMkdm() {
		if (this.mkdm == null) {
			return "";
		} else {
			return this.mkdm;
		}
	}

	public String getDeptindex() {
		if (this.deptindex == null) {
			return "";
		} else {
			return this.deptindex;
		}
	}

	public String getDeptguid() {
		if (this.deptguid == null) {
			return "";
		} else {
			return this.deptguid;
		}
	}

	public String getDeptphone() {
		if (this.deptphone == null) {
			return "";
		} else {
			return this.deptphone;
		}
	}

	public String getFillstr10() {
		if (this.fillstr10 == null) {
			return "";
		} else {
			return this.fillstr10;
		}
	}

	public String getFillstr20() {
		if (this.fillstr20 == null) {
			return "";
		} else {
			return this.fillstr20;
		}
	}

	public String getFillstr100() {
		if (this.fillstr100 == null) {
			return "";
		} else {
			return this.fillstr100;
		}
	}

	public String getFillstr150() {
		if (this.fillstr150 == null) {
			return "";
		} else {
			return this.fillstr150;
		}
	}

	public String getFillint4() {
		if (this.fillint4 == null) {
			return "";
		} else {
			return this.fillint4;
		}
	}

	public String getFillint6() {
		if (this.fillint6 == null) {
			return "";
		} else {
			return this.fillint6;
		}
	}

	public String getFillint8() {
		if (this.fillint8 == null) {
			return "";
		} else {
			return this.fillint8;
		}
	}

	public String getFilldbl2() {
		if (this.filldbl2 == null) {
			return "";
		} else {
			return this.filldbl2;
		}
	}

	public String getFilldbl22() {
		if (this.filldbl22 == null) {
			return "";
		} else {
			return this.filldbl22;
		}
	}

	public String getFilldbl4() {
		if (this.filldbl4 == null) {
			return "";
		} else {
			return this.filldbl4;
		}
	}

	public String getFilldate1() {
		if (this.filldate1 == null) {
			return "";
		} else {
			return this.filldate1;
		}
	}

	public String getFilldate2() {
		if (this.filldate2 == null) {
			return "";
		} else {
			return this.filldate2;
		}
	}

	public String getDepttel() {
		if (this.depttel == null) {
			return "";
		} else {
			return this.depttel;
		}
	}

	public String getDeptpost() {
		if (this.deptpost == null) {
			return "";
		} else {
			return this.deptpost;
		}
	}

	public String getAccounts() {
		if (this.accounts == null) {
			return "";
		} else {
			return this.accounts;
		}
	}

	public String getAccountnm() {
		if (this.accountnm == null) {
			return "";
		} else {
			return this.accountnm;
		}
	}

	public String getDeptaddr() {
		if (this.deptaddr == null) {
			return "";
		} else {
			return this.deptaddr;
		}
	}

	public String getDistcode() {
		if (this.distcode == null) {
			return "";
		} else {
			return this.distcode;
		}
	}

	public String getCreatedt() {
		if (this.createdt == null) {
			return "";
		} else {
			return this.createdt;
		}
	}

	public String getNormalpeos() {
		if (this.normalpeos == null) {
			return "";
		} else {
			return this.normalpeos;
		}
	}

	public String getRealpeos() {
		if (this.realpeos == null) {
			return "";
		} else {
			return this.realpeos;
		}
	}

	public String getManagernm() {
		if (this.managernm == null) {
			return "";
		} else {
			return this.managernm;
		}
	}

	public String getDeptinfo() {
		if (this.deptinfo == null) {
			return "";
		} else {
			return this.deptinfo;
		}
	}

	public String getBmjc() {
		if (this.bmjc == null) {
			return "";
		} else {
			return this.bmjc;
		}
	}

	public void setDeptid(String deptid) {
		sqlMaker.setField("deptid", deptid, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptid().equals(deptid))
				cf.add("deptid", this.deptid, deptid);
		}
		this.deptid = deptid;
	}

	public void setDeptname(String deptname) {
		sqlMaker.setField("deptname", deptname, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptname().equals(deptname))
				cf.add("deptname", this.deptname, deptname);
		}
		this.deptname = deptname;
	}

	public void setDeptdesc(String deptdesc) {
		sqlMaker.setField("deptdesc", deptdesc, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptdesc().equals(deptdesc))
				cf.add("deptdesc", this.deptdesc, deptdesc);
		}
		this.deptdesc = deptdesc;
	}

	public void setParentdeptid(String parentdeptid) {
		sqlMaker.setField("parentdeptid", parentdeptid, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getParentdeptid().equals(parentdeptid))
				cf.add("parentdeptid", this.parentdeptid, parentdeptid);
		}
		this.parentdeptid = parentdeptid;
	}

	public void setDeptleaf(String deptleaf) {
		sqlMaker.setField("deptleaf", deptleaf, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptleaf().equals(deptleaf))
				cf.add("deptleaf", this.deptleaf, deptleaf);
		}
		this.deptleaf = deptleaf;
	}

	public void setDeptlevel(String deptlevel) {
		sqlMaker.setField("deptlevel", deptlevel, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptlevel().equals(deptlevel))
				cf.add("deptlevel", this.deptlevel, deptlevel);
		}
		this.deptlevel = deptlevel;
	}

	public void setDepttype(String depttype) {
		sqlMaker.setField("depttype", depttype, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDepttype().equals(depttype))
				cf.add("depttype", this.depttype, depttype);
		}
		this.depttype = depttype;
	}

	public void setDqdm(String dqdm) {
		sqlMaker.setField("dqdm", dqdm, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDqdm().equals(dqdm))
				cf.add("dqdm", this.dqdm, dqdm);
		}
		this.dqdm = dqdm;
	}

	public void setMkdm(String mkdm) {
		sqlMaker.setField("mkdm", mkdm, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getMkdm().equals(mkdm))
				cf.add("mkdm", this.mkdm, mkdm);
		}
		this.mkdm = mkdm;
	}

	public void setDeptindex(String deptindex) {
		sqlMaker.setField("deptindex", deptindex, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptindex().equals(deptindex))
				cf.add("deptindex", this.deptindex, deptindex);
		}
		this.deptindex = deptindex;
	}

	public void setDeptguid(String deptguid) {
		sqlMaker.setField("deptguid", deptguid, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptguid().equals(deptguid))
				cf.add("deptguid", this.deptguid, deptguid);
		}
		this.deptguid = deptguid;
	}

	public void setDeptphone(String deptphone) {
		sqlMaker.setField("deptphone", deptphone, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptphone().equals(deptphone))
				cf.add("deptphone", this.deptphone, deptphone);
		}
		this.deptphone = deptphone;
	}

	public void setFillstr10(String fillstr10) {
		sqlMaker.setField("fillstr10", fillstr10, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillstr10().equals(fillstr10))
				cf.add("fillstr10", this.fillstr10, fillstr10);
		}
		this.fillstr10 = fillstr10;
	}

	public void setFillstr20(String fillstr20) {
		sqlMaker.setField("fillstr20", fillstr20, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillstr20().equals(fillstr20))
				cf.add("fillstr20", this.fillstr20, fillstr20);
		}
		this.fillstr20 = fillstr20;
	}

	public void setFillstr100(String fillstr100) {
		sqlMaker.setField("fillstr100", fillstr100, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillstr100().equals(fillstr100))
				cf.add("fillstr100", this.fillstr100, fillstr100);
		}
		this.fillstr100 = fillstr100;
	}

	public void setFillstr150(String fillstr150) {
		sqlMaker.setField("fillstr150", fillstr150, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillstr150().equals(fillstr150))
				cf.add("fillstr150", this.fillstr150, fillstr150);
		}
		this.fillstr150 = fillstr150;
	}

	public void setFillint4(String fillint4) {
		sqlMaker.setField("fillint4", fillint4, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillint4().equals(fillint4))
				cf.add("fillint4", this.fillint4, fillint4);
		}
		this.fillint4 = fillint4;
	}

	public void setFillint6(String fillint6) {
		sqlMaker.setField("fillint6", fillint6, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillint6().equals(fillint6))
				cf.add("fillint6", this.fillint6, fillint6);
		}
		this.fillint6 = fillint6;
	}

	public void setFillint8(String fillint8) {
		sqlMaker.setField("fillint8", fillint8, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillint8().equals(fillint8))
				cf.add("fillint8", this.fillint8, fillint8);
		}
		this.fillint8 = fillint8;
	}

	public void setFilldbl2(String filldbl2) {
		sqlMaker.setField("filldbl2", filldbl2, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFilldbl2().equals(filldbl2))
				cf.add("filldbl2", this.filldbl2, filldbl2);
		}
		this.filldbl2 = filldbl2;
	}

	public void setFilldbl22(String filldbl22) {
		sqlMaker.setField("filldbl22", filldbl22, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFilldbl22().equals(filldbl22))
				cf.add("filldbl22", this.filldbl22, filldbl22);
		}
		this.filldbl22 = filldbl22;
	}

	public void setFilldbl4(String filldbl4) {
		sqlMaker.setField("filldbl4", filldbl4, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFilldbl4().equals(filldbl4))
				cf.add("filldbl4", this.filldbl4, filldbl4);
		}
		this.filldbl4 = filldbl4;
	}

	public void setFilldate1(String filldate1) {
		sqlMaker.setField("filldate1", filldate1, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFilldate1().equals(filldate1))
				cf.add("filldate1", this.filldate1, filldate1);
		}
		this.filldate1 = filldate1;
	}

	public void setFilldate2(String filldate2) {
		sqlMaker.setField("filldate2", filldate2, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFilldate2().equals(filldate2))
				cf.add("filldate2", this.filldate2, filldate2);
		}
		this.filldate2 = filldate2;
	}

	public void setDepttel(String depttel) {
		sqlMaker.setField("depttel", depttel, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDepttel().equals(depttel))
				cf.add("depttel", this.depttel, depttel);
		}
		this.depttel = depttel;
	}

	public void setDeptpost(String deptpost) {
		sqlMaker.setField("deptpost", deptpost, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptpost().equals(deptpost))
				cf.add("deptpost", this.deptpost, deptpost);
		}
		this.deptpost = deptpost;
	}

	public void setAccounts(String accounts) {
		sqlMaker.setField("accounts", accounts, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getAccounts().equals(accounts))
				cf.add("accounts", this.accounts, accounts);
		}
		this.accounts = accounts;
	}

	public void setAccountnm(String accountnm) {
		sqlMaker.setField("accountnm", accountnm, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getAccountnm().equals(accountnm))
				cf.add("accountnm", this.accountnm, accountnm);
		}
		this.accountnm = accountnm;
	}

	public void setDeptaddr(String deptaddr) {
		sqlMaker.setField("deptaddr", deptaddr, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptaddr().equals(deptaddr))
				cf.add("deptaddr", this.deptaddr, deptaddr);
		}
		this.deptaddr = deptaddr;
	}

	public void setDistcode(String distcode) {
		sqlMaker.setField("distcode", distcode, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDistcode().equals(distcode))
				cf.add("distcode", this.distcode, distcode);
		}
		this.distcode = distcode;
	}

	public void setCreatedt(String createdt) {
		sqlMaker.setField("createdt", createdt, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getCreatedt().equals(createdt))
				cf.add("createdt", this.createdt, createdt);
		}
		this.createdt = createdt;
	}

	public void setNormalpeos(String normalpeos) {
		sqlMaker.setField("normalpeos", normalpeos, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getNormalpeos().equals(normalpeos))
				cf.add("normalpeos", this.normalpeos, normalpeos);
		}
		this.normalpeos = normalpeos;
	}

	public void setRealpeos(String realpeos) {
		sqlMaker.setField("realpeos", realpeos, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getRealpeos().equals(realpeos))
				cf.add("realpeos", this.realpeos, realpeos);
		}
		this.realpeos = realpeos;
	}

	public void setManagernm(String managernm) {
		sqlMaker.setField("managernm", managernm, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getManagernm().equals(managernm))
				cf.add("managernm", this.managernm, managernm);
		}
		this.managernm = managernm;
	}

	public void setDeptinfo(String deptinfo) {
		sqlMaker.setField("deptinfo", deptinfo, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDeptinfo().equals(deptinfo))
				cf.add("deptinfo", this.deptinfo, deptinfo);
		}
		this.deptinfo = deptinfo;
	}

	public void setBmjc(String bmjc) {
		sqlMaker.setField("bmjc", bmjc, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getBmjc().equals(bmjc))
				cf.add("bmjc", this.bmjc, bmjc);
		}
		this.bmjc = bmjc;
	}

	public void init(int i, ActionRequest actionRequest) throws Exception {
		if (actionRequest.getFieldValue(i, "deptid") != null)
			this.setDeptid(actionRequest.getFieldValue(i, "deptid"));
		if (actionRequest.getFieldValue(i, "deptname") != null)
			this.setDeptname(actionRequest.getFieldValue(i, "deptname"));
		if (actionRequest.getFieldValue(i, "deptdesc") != null)
			this.setDeptdesc(actionRequest.getFieldValue(i, "deptdesc"));
		if (actionRequest.getFieldValue(i, "parentdeptid") != null)
			this
					.setParentdeptid(actionRequest.getFieldValue(i,
							"parentdeptid"));
		if (actionRequest.getFieldValue(i, "deptleaf") != null)
			this.setDeptleaf(actionRequest.getFieldValue(i, "deptleaf"));
		if (actionRequest.getFieldValue(i, "deptlevel") != null)
			this.setDeptlevel(actionRequest.getFieldValue(i, "deptlevel"));
		if (actionRequest.getFieldValue(i, "depttype") != null)
			this.setDepttype(actionRequest.getFieldValue(i, "depttype"));
		if (actionRequest.getFieldValue(i, "dqdm") != null)
			this.setDqdm(actionRequest.getFieldValue(i, "dqdm"));
		if (actionRequest.getFieldValue(i, "mkdm") != null)
			this.setMkdm(actionRequest.getFieldValue(i, "mkdm"));
		if (actionRequest.getFieldValue(i, "deptindex") != null)
			this.setDeptindex(actionRequest.getFieldValue(i, "deptindex"));
		if (actionRequest.getFieldValue(i, "deptguid") != null)
			this.setDeptguid(actionRequest.getFieldValue(i, "deptguid"));
		if (actionRequest.getFieldValue(i, "deptphone") != null)
			this.setDeptphone(actionRequest.getFieldValue(i, "deptphone"));
		if (actionRequest.getFieldValue(i, "fillstr10") != null)
			this.setFillstr10(actionRequest.getFieldValue(i, "fillstr10"));
		if (actionRequest.getFieldValue(i, "fillstr20") != null)
			this.setFillstr20(actionRequest.getFieldValue(i, "fillstr20"));
		if (actionRequest.getFieldValue(i, "fillstr100") != null)
			this.setFillstr100(actionRequest.getFieldValue(i, "fillstr100"));
		if (actionRequest.getFieldValue(i, "fillstr150") != null)
			this.setFillstr150(actionRequest.getFieldValue(i, "fillstr150"));
		if (actionRequest.getFieldValue(i, "fillint4") != null)
			this.setFillint4(actionRequest.getFieldValue(i, "fillint4"));
		if (actionRequest.getFieldValue(i, "fillint6") != null)
			this.setFillint6(actionRequest.getFieldValue(i, "fillint6"));
		if (actionRequest.getFieldValue(i, "fillint8") != null)
			this.setFillint8(actionRequest.getFieldValue(i, "fillint8"));
		if (actionRequest.getFieldValue(i, "filldbl2") != null)
			this.setFilldbl2(actionRequest.getFieldValue(i, "filldbl2"));
		if (actionRequest.getFieldValue(i, "filldbl22") != null)
			this.setFilldbl22(actionRequest.getFieldValue(i, "filldbl22"));
		if (actionRequest.getFieldValue(i, "filldbl4") != null)
			this.setFilldbl4(actionRequest.getFieldValue(i, "filldbl4"));
		if (actionRequest.getFieldValue(i, "filldate1") != null)
			this.setFilldate1(actionRequest.getFieldValue(i, "filldate1"));
		if (actionRequest.getFieldValue(i, "filldate2") != null)
			this.setFilldate2(actionRequest.getFieldValue(i, "filldate2"));
		if (actionRequest.getFieldValue(i, "depttel") != null)
			this.setDepttel(actionRequest.getFieldValue(i, "depttel"));
		if (actionRequest.getFieldValue(i, "deptpost") != null)
			this.setDeptpost(actionRequest.getFieldValue(i, "deptpost"));
		if (actionRequest.getFieldValue(i, "accounts") != null)
			this.setAccounts(actionRequest.getFieldValue(i, "accounts"));
		if (actionRequest.getFieldValue(i, "accountnm") != null)
			this.setAccountnm(actionRequest.getFieldValue(i, "accountnm"));
		if (actionRequest.getFieldValue(i, "deptaddr") != null)
			this.setDeptaddr(actionRequest.getFieldValue(i, "deptaddr"));
		if (actionRequest.getFieldValue(i, "distcode") != null)
			this.setDistcode(actionRequest.getFieldValue(i, "distcode"));
		if (actionRequest.getFieldValue(i, "createdt") != null)
			this.setCreatedt(actionRequest.getFieldValue(i, "createdt"));
		if (actionRequest.getFieldValue(i, "normalpeos") != null)
			this.setNormalpeos(actionRequest.getFieldValue(i, "normalpeos"));
		if (actionRequest.getFieldValue(i, "realpeos") != null)
			this.setRealpeos(actionRequest.getFieldValue(i, "realpeos"));
		if (actionRequest.getFieldValue(i, "managernm") != null)
			this.setManagernm(actionRequest.getFieldValue(i, "managernm"));
		if (actionRequest.getFieldValue(i, "deptinfo") != null)
			this.setDeptinfo(actionRequest.getFieldValue(i, "deptinfo"));
		if (actionRequest.getFieldValue(i, "bmjc") != null)
			this.setBmjc(actionRequest.getFieldValue(i, "bmjc"));
	}

	public void init(ActionRequest actionRequest) throws Exception {
		this.init(0, actionRequest);
	}

	public void initAll(int i, ActionRequest actionRequest) throws Exception {
		this.init(i, actionRequest);
	}

	public void initAll(ActionRequest actionRequest) throws Exception {
		this.initAll(0, actionRequest);
	}

	public Object clone() throws CloneNotSupportedException {
		PtdeptBean obj = (PtdeptBean) super.clone();
		obj.setDeptid(obj.deptid);
		obj.setDeptname(obj.deptname);
		obj.setDeptdesc(obj.deptdesc);
		obj.setParentdeptid(obj.parentdeptid);
		obj.setDeptleaf(obj.deptleaf);
		obj.setDeptlevel(obj.deptlevel);
		obj.setDepttype(obj.depttype);
		obj.setDqdm(obj.dqdm);
		obj.setMkdm(obj.mkdm);
		obj.setDeptindex(obj.deptindex);
		obj.setDeptguid(obj.deptguid);
		obj.setDeptphone(obj.deptphone);
		obj.setFillstr10(obj.fillstr10);
		obj.setFillstr20(obj.fillstr20);
		obj.setFillstr100(obj.fillstr100);
		obj.setFillstr150(obj.fillstr150);
		obj.setFillint4(obj.fillint4);
		obj.setFillint6(obj.fillint6);
		obj.setFillint8(obj.fillint8);
		obj.setFilldbl2(obj.filldbl2);
		obj.setFilldbl22(obj.filldbl22);
		obj.setFilldbl4(obj.filldbl4);
		obj.setFilldate1(obj.filldate1);
		obj.setFilldate2(obj.filldate2);
		obj.setDepttel(obj.depttel);
		obj.setDeptpost(obj.deptpost);
		obj.setAccounts(obj.accounts);
		obj.setAccountnm(obj.accountnm);
		obj.setDeptaddr(obj.deptaddr);
		obj.setDistcode(obj.distcode);
		obj.setCreatedt(obj.createdt);
		obj.setNormalpeos(obj.normalpeos);
		obj.setRealpeos(obj.realpeos);
		obj.setManagernm(obj.managernm);
		obj.setDeptinfo(obj.deptinfo);
		obj.setBmjc(obj.bmjc);
		return obj;
	}
}