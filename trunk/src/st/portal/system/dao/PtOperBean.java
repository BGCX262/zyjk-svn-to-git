package st.portal.system.dao;

import java.util.*;
import st.platform.db.*;
import st.platform.db.sql.*;
import st.platform.control.business.ActionRequest;

public class PtOperBean extends AbstractBasicBean implements Cloneable {
	public static List find(String sSqlWhere) throws Exception {
		return new PtOperBean().findByWhere(sSqlWhere);
	}

	public static List findAndLock(String sSqlWhere) throws Exception {
		return new PtOperBean().findAndLockByWhere(sSqlWhere);
	}

	public static PtOperBean findFirst(String sSqlWhere) throws Exception {
		return (PtOperBean) new PtOperBean().findFirstByWhere(sSqlWhere);
	}

	public static PtOperBean findFirstAndLock(String sSqlWhere)
			throws Exception {
		return (PtOperBean) new PtOperBean().findFirstAndLockByWhere(sSqlWhere);
	}

	public static RecordSet findRecordSet(String sSqlWhere) throws Exception {
		return new PtOperBean().findRecordSetByWhere(sSqlWhere);
	}

	public static List find(String sSqlWhere, boolean isAutoRelease)
			throws Exception {
		PtOperBean bean = new PtOperBean();
		bean.setAutoRelease(isAutoRelease);
		return bean.findByWhere(sSqlWhere);
	}

	public static List findAndLock(String sSqlWhere, boolean isAutoRelease)
			throws Exception {
		PtOperBean bean = new PtOperBean();
		bean.setAutoRelease(isAutoRelease);
		return bean.findAndLockByWhere(sSqlWhere);
	}

	public static PtOperBean findFirst(String sSqlWhere, boolean isAutoRelease)
			throws Exception {
		PtOperBean bean = new PtOperBean();
		bean.setAutoRelease(isAutoRelease);
		return (PtOperBean) bean.findFirstByWhere(sSqlWhere);
	}

	public static PtOperBean findFirstAndLock(String sSqlWhere,
			boolean isAutoRelease) throws Exception {
		PtOperBean bean = new PtOperBean();
		bean.setAutoRelease(isAutoRelease);
		return (PtOperBean) bean.findFirstAndLockByWhere(sSqlWhere);
	}

	public static RecordSet findRecordSet(String sSqlWhere,
			boolean isAutoRelease) throws Exception {
		PtOperBean bean = new PtOperBean();
		bean.setAutoRelease(isAutoRelease);
		return bean.findRecordSetByWhere(sSqlWhere);
	}

	String deptid;
	String operid;
	String operpasswd;
	String issuper;
	String opertype;
	String opername;
	String sex;
	String email;
	String mobilephone;
	String operphone;
	String otherphone;
	String operenabled;
	String fillstr50;
	String fillstr80;
	String fillstr100;
	String fillstr150;
	String fillstr600;
	String filldate1;
	String filldate2;
	String filldate3;
	String fillint6;
	String fillint8;
	String fillint10;
	String fillint12;
	String filldbl1;
	String filldbl2;
	String filldbl3;
	String userguid;
	String operbh;
	String nation;
	String birthday;
	String indt;
	String duty;
	String edudegree;
	String resume;
	String memo;
	public static final String TABLENAME = "ptoper";
	private String operate_mode = "add";
	public ChangeFileds cf = new ChangeFileds();

	public String getTableName() {
		return TABLENAME;
	}

	public void addObject(List list, RecordSet rs) {
		PtOperBean abb = new PtOperBean();
		abb.deptid = rs.getString("deptid");
		abb.setKeyValue("DEPTID", "" + abb.getDeptid());
		abb.operid = rs.getString("operid");
		abb.setKeyValue("OPERID", "" + abb.getOperid());
		abb.operpasswd = rs.getString("operpasswd");
		abb.setKeyValue("OPERPASSWD", "" + abb.getOperpasswd());
		abb.issuper = rs.getString("issuper");
		abb.setKeyValue("ISSUPER", "" + abb.getIssuper());
		abb.opertype = rs.getString("opertype");
		abb.setKeyValue("OPERTYPE", "" + abb.getOpertype());
		abb.opername = rs.getString("opername");
		abb.setKeyValue("OPERNAME", "" + abb.getOpername());
		abb.sex = rs.getString("sex");
		abb.setKeyValue("SEX", "" + abb.getSex());
		abb.email = rs.getString("email");
		abb.setKeyValue("EMAIL", "" + abb.getEmail());
		abb.mobilephone = rs.getString("mobilephone");
		abb.setKeyValue("MOBILEPHONE", "" + abb.getMobilephone());
		abb.operphone = rs.getString("operphone");
		abb.setKeyValue("OPERPHONE", "" + abb.getOperphone());
		abb.otherphone = rs.getString("otherphone");
		abb.setKeyValue("OTHERPHONE", "" + abb.getOtherphone());
		abb.operenabled = rs.getString("operenabled");
		abb.setKeyValue("OPERENABLED", "" + abb.getOperenabled());
		abb.fillstr50 = rs.getString("fillstr50");
		abb.setKeyValue("FILLSTR50", "" + abb.getFillstr50());
		abb.fillstr80 = rs.getString("fillstr80");
		abb.setKeyValue("FILLSTR80", "" + abb.getFillstr80());
		abb.fillstr100 = rs.getString("fillstr100");
		abb.setKeyValue("FILLSTR100", "" + abb.getFillstr100());
		abb.fillstr150 = rs.getString("fillstr150");
		abb.setKeyValue("FILLSTR150", "" + abb.getFillstr150());
		abb.fillstr600 = rs.getString("fillstr600");
		abb.setKeyValue("FILLSTR600", "" + abb.getFillstr600());
		abb.filldate1 = rs.getString("filldate1");
		abb.setKeyValue("FILLDATE1", "" + abb.getFilldate1());
		abb.filldate2 = rs.getString("filldate2");
		abb.setKeyValue("FILLDATE2", "" + abb.getFilldate2());
		abb.filldate3 = rs.getString("filldate3");
		abb.setKeyValue("FILLDATE3", "" + abb.getFilldate3());
		abb.fillint6 = rs.getString("fillint6");
		abb.setKeyValue("FILLINT6", "" + abb.getFillint6());
		abb.fillint8 = rs.getString("fillint8");
		abb.setKeyValue("FILLINT8", "" + abb.getFillint8());
		abb.fillint10 = rs.getString("fillint10");
		abb.setKeyValue("FILLINT10", "" + abb.getFillint10());
		abb.fillint12 = rs.getString("fillint12");
		abb.setKeyValue("FILLINT12", "" + abb.getFillint12());
		abb.filldbl1 = rs.getString("filldbl1");
		abb.setKeyValue("FILLDBL1", "" + abb.getFilldbl1());
		abb.filldbl2 = rs.getString("filldbl2");
		abb.setKeyValue("FILLDBL2", "" + abb.getFilldbl2());
		abb.filldbl3 = rs.getString("filldbl3");
		abb.setKeyValue("FILLDBL3", "" + abb.getFilldbl3());
		abb.userguid = rs.getString("userguid");
		abb.setKeyValue("USERGUID", "" + abb.getUserguid());
		abb.operbh = rs.getString("operbh");
		abb.setKeyValue("OPERBH", "" + abb.getOperbh());
		abb.nation = rs.getString("nation");
		abb.setKeyValue("NATION", "" + abb.getNation());
		abb.birthday = rs.getString("birthday");
		abb.setKeyValue("BIRTHDAY", "" + abb.getBirthday());
		abb.indt = rs.getString("indt");
		abb.setKeyValue("INDT", "" + abb.getIndt());
		abb.duty = rs.getString("duty");
		abb.setKeyValue("DUTY", "" + abb.getDuty());
		abb.edudegree = rs.getString("edudegree");
		abb.setKeyValue("EDUDEGREE", "" + abb.getEdudegree());
		abb.resume = rs.getString("resume");
		abb.setKeyValue("RESUME", "" + abb.getResume());
		abb.memo = rs.getString("memo");
		abb.setKeyValue("MEMO", "" + abb.getMemo());
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

	public String getOperid() {
		if (this.operid == null) {
			return "";
		} else {
			return this.operid;
		}
	}

	public String getOperpasswd() {
		if (this.operpasswd == null) {
			return "";
		} else {
			return this.operpasswd;
		}
	}

	public String getIssuper() {
		if (this.issuper == null) {
			return "";
		} else {
			return this.issuper;
		}
	}

	public String getOpertype() {
		if (this.opertype == null) {
			return "";
		} else {
			return this.opertype;
		}
	}

	public String getOpername() {
		if (this.opername == null) {
			return "";
		} else {
			return this.opername;
		}
	}

	public String getSex() {
		if (this.sex == null) {
			return "";
		} else {
			return this.sex;
		}
	}

	public String getEmail() {
		if (this.email == null) {
			return "";
		} else {
			return this.email;
		}
	}

	public String getMobilephone() {
		if (this.mobilephone == null) {
			return "";
		} else {
			return this.mobilephone;
		}
	}

	public String getOperphone() {
		if (this.operphone == null) {
			return "";
		} else {
			return this.operphone;
		}
	}

	public String getOtherphone() {
		if (this.otherphone == null) {
			return "";
		} else {
			return this.otherphone;
		}
	}

	public String getOperenabled() {
		if (this.operenabled == null) {
			return "";
		} else {
			return this.operenabled;
		}
	}

	public String getFillstr50() {
		if (this.fillstr50 == null) {
			return "";
		} else {
			return this.fillstr50;
		}
	}

	public String getFillstr80() {
		if (this.fillstr80 == null) {
			return "";
		} else {
			return this.fillstr80;
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

	public String getFillstr600() {
		if (this.fillstr600 == null) {
			return "";
		} else {
			return this.fillstr600;
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

	public String getFilldate3() {
		if (this.filldate3 == null) {
			return "";
		} else {
			return this.filldate3;
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

	public String getFillint10() {
		if (this.fillint10 == null) {
			return "";
		} else {
			return this.fillint10;
		}
	}

	public String getFillint12() {
		if (this.fillint12 == null) {
			return "";
		} else {
			return this.fillint12;
		}
	}

	public String getFilldbl1() {
		if (this.filldbl1 == null) {
			return "";
		} else {
			return this.filldbl1;
		}
	}

	public String getFilldbl2() {
		if (this.filldbl2 == null) {
			return "";
		} else {
			return this.filldbl2;
		}
	}

	public String getFilldbl3() {
		if (this.filldbl3 == null) {
			return "";
		} else {
			return this.filldbl3;
		}
	}

	public String getUserguid() {
		if (this.userguid == null) {
			return "";
		} else {
			return this.userguid;
		}
	}

	public String getOperbh() {
		if (this.operbh == null) {
			return "";
		} else {
			return this.operbh;
		}
	}

	public String getNation() {
		if (this.nation == null) {
			return "";
		} else {
			return this.nation;
		}
	}

	public String getBirthday() {
		if (this.birthday == null) {
			return "";
		} else {
			return this.birthday;
		}
	}

	public String getIndt() {
		if (this.indt == null) {
			return "";
		} else {
			return this.indt;
		}
	}

	public String getDuty() {
		if (this.duty == null) {
			return "";
		} else {
			return this.duty;
		}
	}

	public String getEdudegree() {
		if (this.edudegree == null) {
			return "";
		} else {
			return this.edudegree;
		}
	}

	public String getResume() {
		if (this.resume == null) {
			return "";
		} else {
			return this.resume;
		}
	}

	public String getMemo() {
		if (this.memo == null) {
			return "";
		} else {
			return this.memo;
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

	public void setOperid(String operid) {
		sqlMaker.setField("operid", operid, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getOperid().equals(operid))
				cf.add("operid", this.operid, operid);
		}
		this.operid = operid;
	}

	public void setOperpasswd(String operpasswd) {
		sqlMaker.setField("operpasswd", operpasswd, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getOperpasswd().equals(operpasswd))
				cf.add("operpasswd", this.operpasswd, operpasswd);
		}
		this.operpasswd = operpasswd;
	}

	public void setIssuper(String issuper) {
		sqlMaker.setField("issuper", issuper, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getIssuper().equals(issuper))
				cf.add("issuper", this.issuper, issuper);
		}
		this.issuper = issuper;
	}

	public void setOpertype(String opertype) {
		sqlMaker.setField("opertype", opertype, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getOpertype().equals(opertype))
				cf.add("opertype", this.opertype, opertype);
		}
		this.opertype = opertype;
	}

	public void setOpername(String opername) {
		sqlMaker.setField("opername", opername, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getOpername().equals(opername))
				cf.add("opername", this.opername, opername);
		}
		this.opername = opername;
	}

	public void setSex(String sex) {
		sqlMaker.setField("sex", sex, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getSex().equals(sex))
				cf.add("sex", this.sex, sex);
		}
		this.sex = sex;
	}

	public void setEmail(String email) {
		sqlMaker.setField("email", email, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getEmail().equals(email))
				cf.add("email", this.email, email);
		}
		this.email = email;
	}

	public void setMobilephone(String mobilephone) {
		sqlMaker.setField("mobilephone", mobilephone, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getMobilephone().equals(mobilephone))
				cf.add("mobilephone", this.mobilephone, mobilephone);
		}
		this.mobilephone = mobilephone;
	}

	public void setOperphone(String operphone) {
		sqlMaker.setField("operphone", operphone, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getOperphone().equals(operphone))
				cf.add("operphone", this.operphone, operphone);
		}
		this.operphone = operphone;
	}

	public void setOtherphone(String otherphone) {
		sqlMaker.setField("otherphone", otherphone, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getOtherphone().equals(otherphone))
				cf.add("otherphone", this.otherphone, otherphone);
		}
		this.otherphone = otherphone;
	}

	public void setOperenabled(String operenabled) {
		sqlMaker.setField("operenabled", operenabled, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getOperenabled().equals(operenabled))
				cf.add("operenabled", this.operenabled, operenabled);
		}
		this.operenabled = operenabled;
	}

	public void setFillstr50(String fillstr50) {
		sqlMaker.setField("fillstr50", fillstr50, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillstr50().equals(fillstr50))
				cf.add("fillstr50", this.fillstr50, fillstr50);
		}
		this.fillstr50 = fillstr50;
	}

	public void setFillstr80(String fillstr80) {
		sqlMaker.setField("fillstr80", fillstr80, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillstr80().equals(fillstr80))
				cf.add("fillstr80", this.fillstr80, fillstr80);
		}
		this.fillstr80 = fillstr80;
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

	public void setFillstr600(String fillstr600) {
		sqlMaker.setField("fillstr600", fillstr600, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillstr600().equals(fillstr600))
				cf.add("fillstr600", this.fillstr600, fillstr600);
		}
		this.fillstr600 = fillstr600;
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

	public void setFilldate3(String filldate3) {
		sqlMaker.setField("filldate3", filldate3, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFilldate3().equals(filldate3))
				cf.add("filldate3", this.filldate3, filldate3);
		}
		this.filldate3 = filldate3;
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

	public void setFillint10(String fillint10) {
		sqlMaker.setField("fillint10", fillint10, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillint10().equals(fillint10))
				cf.add("fillint10", this.fillint10, fillint10);
		}
		this.fillint10 = fillint10;
	}

	public void setFillint12(String fillint12) {
		sqlMaker.setField("fillint12", fillint12, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFillint12().equals(fillint12))
				cf.add("fillint12", this.fillint12, fillint12);
		}
		this.fillint12 = fillint12;
	}

	public void setFilldbl1(String filldbl1) {
		sqlMaker.setField("filldbl1", filldbl1, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFilldbl1().equals(filldbl1))
				cf.add("filldbl1", this.filldbl1, filldbl1);
		}
		this.filldbl1 = filldbl1;
	}

	public void setFilldbl2(String filldbl2) {
		sqlMaker.setField("filldbl2", filldbl2, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFilldbl2().equals(filldbl2))
				cf.add("filldbl2", this.filldbl2, filldbl2);
		}
		this.filldbl2 = filldbl2;
	}

	public void setFilldbl3(String filldbl3) {
		sqlMaker.setField("filldbl3", filldbl3, Field.NUMBER);
		if (this.operate_mode.equals("edit")) {
			if (!this.getFilldbl3().equals(filldbl3))
				cf.add("filldbl3", this.filldbl3, filldbl3);
		}
		this.filldbl3 = filldbl3;
	}

	public void setUserguid(String userguid) {
		sqlMaker.setField("userguid", userguid, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getUserguid().equals(userguid))
				cf.add("userguid", this.userguid, userguid);
		}
		this.userguid = userguid;
	}

	public void setOperbh(String operbh) {
		sqlMaker.setField("operbh", operbh, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getOperbh().equals(operbh))
				cf.add("operbh", this.operbh, operbh);
		}
		this.operbh = operbh;
	}

	public void setNation(String nation) {
		sqlMaker.setField("nation", nation, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getNation().equals(nation))
				cf.add("nation", this.nation, nation);
		}
		this.nation = nation;
	}

	public void setBirthday(String birthday) {
		sqlMaker.setField("birthday", birthday, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getBirthday().equals(birthday))
				cf.add("birthday", this.birthday, birthday);
		}
		this.birthday = birthday;
	}

	public void setIndt(String indt) {
		sqlMaker.setField("indt", indt, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getIndt().equals(indt))
				cf.add("indt", this.indt, indt);
		}
		this.indt = indt;
	}

	public void setDuty(String duty) {
		sqlMaker.setField("duty", duty, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getDuty().equals(duty))
				cf.add("duty", this.duty, duty);
		}
		this.duty = duty;
	}

	public void setEdudegree(String edudegree) {
		sqlMaker.setField("edudegree", edudegree, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getEdudegree().equals(edudegree))
				cf.add("edudegree", this.edudegree, edudegree);
		}
		this.edudegree = edudegree;
	}

	public void setResume(String resume) {
		sqlMaker.setField("resume", resume, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getResume().equals(resume))
				cf.add("resume", this.resume, resume);
		}
		this.resume = resume;
	}

	public void setMemo(String memo) {
		sqlMaker.setField("memo", memo, Field.TEXT);
		if (this.operate_mode.equals("edit")) {
			if (!this.getMemo().equals(memo))
				cf.add("memo", this.memo, memo);
		}
		this.memo = memo;
	}

	public void init(int i, ActionRequest actionRequest) throws Exception {
		if (actionRequest.getFieldValue(i, "deptid") != null)
			this.setDeptid(actionRequest.getFieldValue(i, "deptid"));
		if (actionRequest.getFieldValue(i, "operid") != null)
			this.setOperid(actionRequest.getFieldValue(i, "operid"));
		if (actionRequest.getFieldValue(i, "operpasswd") != null)
			this.setOperpasswd(actionRequest.getFieldValue(i, "operpasswd"));
		if (actionRequest.getFieldValue(i, "issuper") != null)
			this.setIssuper(actionRequest.getFieldValue(i, "issuper"));
		if (actionRequest.getFieldValue(i, "opertype") != null)
			this.setOpertype(actionRequest.getFieldValue(i, "opertype"));
		if (actionRequest.getFieldValue(i, "opername") != null)
			this.setOpername(actionRequest.getFieldValue(i, "opername"));
		if (actionRequest.getFieldValue(i, "sex") != null)
			this.setSex(actionRequest.getFieldValue(i, "sex"));
		if (actionRequest.getFieldValue(i, "email") != null)
			this.setEmail(actionRequest.getFieldValue(i, "email"));
		if (actionRequest.getFieldValue(i, "mobilephone") != null)
			this.setMobilephone(actionRequest.getFieldValue(i, "mobilephone"));
		if (actionRequest.getFieldValue(i, "operphone") != null)
			this.setOperphone(actionRequest.getFieldValue(i, "operphone"));
		if (actionRequest.getFieldValue(i, "otherphone") != null)
			this.setOtherphone(actionRequest.getFieldValue(i, "otherphone"));
		if (actionRequest.getFieldValue(i, "operenabled") != null)
			this.setOperenabled(actionRequest.getFieldValue(i, "operenabled"));
		if (actionRequest.getFieldValue(i, "fillstr50") != null)
			this.setFillstr50(actionRequest.getFieldValue(i, "fillstr50"));
		if (actionRequest.getFieldValue(i, "fillstr80") != null)
			this.setFillstr80(actionRequest.getFieldValue(i, "fillstr80"));
		if (actionRequest.getFieldValue(i, "fillstr100") != null)
			this.setFillstr100(actionRequest.getFieldValue(i, "fillstr100"));
		if (actionRequest.getFieldValue(i, "fillstr150") != null)
			this.setFillstr150(actionRequest.getFieldValue(i, "fillstr150"));
		if (actionRequest.getFieldValue(i, "fillstr600") != null)
			this.setFillstr600(actionRequest.getFieldValue(i, "fillstr600"));
		if (actionRequest.getFieldValue(i, "filldate1") != null)
			this.setFilldate1(actionRequest.getFieldValue(i, "filldate1"));
		if (actionRequest.getFieldValue(i, "filldate2") != null)
			this.setFilldate2(actionRequest.getFieldValue(i, "filldate2"));
		if (actionRequest.getFieldValue(i, "filldate3") != null)
			this.setFilldate3(actionRequest.getFieldValue(i, "filldate3"));
		if (actionRequest.getFieldValue(i, "fillint6") != null)
			this.setFillint6(actionRequest.getFieldValue(i, "fillint6"));
		if (actionRequest.getFieldValue(i, "fillint8") != null)
			this.setFillint8(actionRequest.getFieldValue(i, "fillint8"));
		if (actionRequest.getFieldValue(i, "fillint10") != null)
			this.setFillint10(actionRequest.getFieldValue(i, "fillint10"));
		if (actionRequest.getFieldValue(i, "fillint12") != null)
			this.setFillint12(actionRequest.getFieldValue(i, "fillint12"));
		if (actionRequest.getFieldValue(i, "filldbl1") != null)
			this.setFilldbl1(actionRequest.getFieldValue(i, "filldbl1"));
		if (actionRequest.getFieldValue(i, "filldbl2") != null)
			this.setFilldbl2(actionRequest.getFieldValue(i, "filldbl2"));
		if (actionRequest.getFieldValue(i, "filldbl3") != null)
			this.setFilldbl3(actionRequest.getFieldValue(i, "filldbl3"));
		if (actionRequest.getFieldValue(i, "userguid") != null)
			this.setUserguid(actionRequest.getFieldValue(i, "userguid"));
		if (actionRequest.getFieldValue(i, "operbh") != null)
			this.setOperbh(actionRequest.getFieldValue(i, "operbh"));
		if (actionRequest.getFieldValue(i, "nation") != null)
			this.setNation(actionRequest.getFieldValue(i, "nation"));
		if (actionRequest.getFieldValue(i, "birthday") != null)
			this.setBirthday(actionRequest.getFieldValue(i, "birthday"));
		if (actionRequest.getFieldValue(i, "indt") != null)
			this.setIndt(actionRequest.getFieldValue(i, "indt"));
		if (actionRequest.getFieldValue(i, "duty") != null)
			this.setDuty(actionRequest.getFieldValue(i, "duty"));
		if (actionRequest.getFieldValue(i, "edudegree") != null)
			this.setEdudegree(actionRequest.getFieldValue(i, "edudegree"));
		if (actionRequest.getFieldValue(i, "resume") != null)
			this.setResume(actionRequest.getFieldValue(i, "resume"));
		if (actionRequest.getFieldValue(i, "memo") != null)
			this.setMemo(actionRequest.getFieldValue(i, "memo"));
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
		PtOperBean obj = (PtOperBean) super.clone();
		obj.setDeptid(obj.deptid);
		obj.setOperid(obj.operid);
		obj.setOperpasswd(obj.operpasswd);
		obj.setIssuper(obj.issuper);
		obj.setOpertype(obj.opertype);
		obj.setOpername(obj.opername);
		obj.setSex(obj.sex);
		obj.setEmail(obj.email);
		obj.setMobilephone(obj.mobilephone);
		obj.setOperphone(obj.operphone);
		obj.setOtherphone(obj.otherphone);
		obj.setOperenabled(obj.operenabled);
		obj.setFillstr50(obj.fillstr50);
		obj.setFillstr80(obj.fillstr80);
		obj.setFillstr100(obj.fillstr100);
		obj.setFillstr150(obj.fillstr150);
		obj.setFillstr600(obj.fillstr600);
		obj.setFilldate1(obj.filldate1);
		obj.setFilldate2(obj.filldate2);
		obj.setFilldate3(obj.filldate3);
		obj.setFillint6(obj.fillint6);
		obj.setFillint8(obj.fillint8);
		obj.setFillint10(obj.fillint10);
		obj.setFillint12(obj.fillint12);
		obj.setFilldbl1(obj.filldbl1);
		obj.setFilldbl2(obj.filldbl2);
		obj.setFilldbl3(obj.filldbl3);
		obj.setUserguid(obj.userguid);
		obj.setOperbh(obj.operbh);
		obj.setNation(obj.nation);
		obj.setBirthday(obj.birthday);
		obj.setIndt(obj.indt);
		obj.setDuty(obj.duty);
		obj.setEdudegree(obj.edudegree);
		obj.setResume(obj.resume);
		obj.setMemo(obj.memo);
		return obj;
	}
}