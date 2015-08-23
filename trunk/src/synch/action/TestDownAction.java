package synch.action;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import st.platform.db.control.DBGrid;
import st.platform.system.cache.EnumerationType;
import st.platform.utils.Config;
import synch.beans.CountBean;
import synch.util.SearchUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ��ݵ�����
 * @author jmx
 *
 */
public class TestDownAction extends ActionSupport{
	
	private String message;
	
	private String updateState;
	
	private String qybh;
	
	private String whys;
	
	private String distcode;
	
	private String hyfl;
	
	private String zgdw;
	
	private String name;
	
	private String zcdz;
	
	private String zczb1;
	
	private String zczb2;
	
	private String zgrs1;
	
	private String zgrs2;
	
	private String whrs1;
	
	private String whrs2;
	
	private String sbzt;
	
	private String czfs;
	
	private String sfgl;
	
	private String sqlwhere;
	

	private String table = ""; // ������
	private String GridID = "enterinfoTable"; // ������
	private String acitonname = "/UI/enterinfo/enterinfo_listInfo.action"; // ��ҳ�ύ��action
	private String DataPilot = ""; // ����ť
	private String dictid = "Z_corlist"; // ��ݼ���ʾ
	private String whereStr = ""; // 
	private String enternoarr;// �������ҵ����һ������
	private String orderStr = ""; // 
	private int AbsolutePage = 1; // 
	private String totalPage = ""; // 
	private int RecordCount = 0; // 
	private String isTotal = ""; // 
	private String buttons = "moveFirst,prevPage,nextPage,moveLast, �鿴 =lookRecord";
	
	private String sql;
	
	private String mess;
	
	
	
	public String getSqlwhere() {
		return sqlwhere;
	}
	public void setSqlwhere(String sqlwhere) {
		this.sqlwhere = sqlwhere;
	}
	public String getCzfs() {
		return czfs;
	}
	public void setCzfs(String czfs) {
		this.czfs = czfs;
	}
	public String getSbzt() {
		return sbzt;
	}
	public void setSbzt(String sbzt) {
		this.sbzt = sbzt;
	}
	public String getSfgl() {
		return sfgl;
	}
	public void setSfgl(String sfgl) {
		this.sfgl = sfgl;
	}
	public String getWhrs1() {
		return whrs1;
	}
	public void setWhrs1(String whrs1) {
		this.whrs1 = whrs1;
	}
	public String getWhrs2() {
		return whrs2;
	}
	public void setWhrs2(String whrs2) {
		this.whrs2 = whrs2;
	}
	public String getZczb1() {
		return zczb1;
	}
	public void setZczb1(String zczb1) {
		this.zczb1 = zczb1;
	}
	public String getZczb2() {
		return zczb2;
	}
	public void setZczb2(String zczb2) {
		this.zczb2 = zczb2;
	}
	public String getZgrs1() {
		return zgrs1;
	}
	public void setZgrs1(String zgrs1) {
		this.zgrs1 = zgrs1;
	}
	public String getZgrs2() {
		return zgrs2;
	}
	public void setZgrs2(String zgrs2) {
		this.zgrs2 = zgrs2;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	public String getDistcode() {
		return distcode;
	}
	public void setDistcode(String distcode) {
		this.distcode = distcode;
	}
	public String getHyfl() {
		return hyfl;
	}
	public void setHyfl(String hyfl) {
		this.hyfl = hyfl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQybh() {
		return qybh;
	}
	public void setQybh(String qybh) {
		this.qybh = qybh;
	}
	
	public String getZgdw() {
		return zgdw;
	}
	public void setZgdw(String zgdw) {
		this.zgdw = zgdw;
	}
	public String getUpdateState() {
		return updateState;
	}
	public void setUpdateState(String updateState) {
		this.updateState = updateState;
	}
	public String getWhys() {
		return whys;
	}
	public void setWhys(String whys) {
		this.whys = whys;
	}
	public String getZcdz() {
		return zcdz;
	}
	public void setZcdz(String zcdz) {
		this.zcdz = zcdz;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String search(){
		
		if(null==sql){
			
			sql="1=1";
		}else{
			sql="1=1";
		}
		
		
		if(null!=qybh&&!"".equals(qybh)&&!"".equals(qybh)){
			sql+=" and corpkey like '"+qybh+"%'";
		}
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			if(updateState.equals("1")){
				sql+=" and corpkey in (select corpkey from Z_wh where whDM like '"+whys+"%')";
			}else if(updateState.equals("2")){
				sql+=" and corpkey in (select corpkey from T_wh where whDM like '"+whys+"%')";
			}else if(updateState.equals("3")){
				sql+=" and corpkey in (select corpkey from T_wh where whDM like '"+whys+"%')";
			}else if(updateState.equals("4")){
				sql+=" and corpkey in (select corpkey from Z_wh where whDM like '"+whys+"%')";
			}else if(updateState.equals("5")){
				sql+=" and corpkey in (select corpkey from B_wh where whDM like '"+whys+"%')";
			}
			
		}
		if(null!=qybh&&!"".equals(qybh)&&!"".equals(qybh)){
			sql+=" and corpkey like '"+qybh+"%'";
		}
		if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
			sql+=" and DQ3 like '"+distcode+"%'";
		}else{
			distcode=Config.getProperty("zyjkdiscode");
			if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
				sql+=" and DQ3 like '"+distcode+"%'";
			
			}
			
		}
		if(null!=hyfl&&!"".equals(hyfl)&&!"null".equals(hyfl)){
			sql+=" and hyfl like'"+hyfl+"%'";
		}
		if(null!=zgdw&&!"".equals(zgdw)&&!"null".equals(zgdw)){
			sql+=" and zhuguan='"+EnumerationType.getEnu("ZGDW", zgdw)+"'";
		}
		if(null!=zcdz&&!"".equals(zcdz)&&!"null".equals(zcdz)){
			try {
				//name= java.net.URLDecoder.decode(name,"utf-8");
				zcdz= java.net.URLDecoder.decode(zcdz,"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			sql+=" and ccdz like '%"+zcdz+"%'";
		}
		if(null!=name&&!"".equals(name)&&!"null".equals(name)){
			try {
				//name= java.net.URLDecoder.decode(name,"utf-8");
				name= java.net.URLDecoder.decode(name,"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			sql+=" and dwmc like '%"+name+"%'";
		}
		
		String zsql="";
		
		if(null!=zczb1&&!"".equals(zczb1)&&!"null".equals(zczb1)){
			zsql+=" and zichan>='"+zczb1+"'";
		}
		
		if(null!=zczb1&&!"".equals(zczb1)&&!"null".equals(zczb1)){
			zsql+=" and zichan<='"+zczb2+"'";
		}
		
		sql+=zsql;
		
		String zgsql="";
		
		if(null!=zgrs1&&!"".equals(zgrs1)&&!"null".equals(zgrs1)){
			zgsql+=" and nmzgrs>='"+zgrs1+"'";
		}
		if(null!=zgrs2&&!"".equals(zgrs2)&&!"null".equals(zgrs2)){
			zgsql+=" and nmzgrs<='"+zgrs2+"'";
		}
		sql+=zgsql;
		
		String wsql="";
		
		if(null!=whrs1&&!"".equals(whrs1)&&!"null".equals(whrs1)){
			wsql+=" and whrenshu>='"+whrs1+"'";
		}
		if(null!=whrs2&&!"".equals(whrs2)&&!"null".equals(whrs2)){
			wsql+=" and whrenshu<='"+whrs2+"'";
		}
		sql+=wsql;
		
		if(null!=sbzt&&!"".equals(sbzt)&&!"null".equals(sbzt)){
			String zg=EnumerationType.getEnu("SBZT", sbzt);
			if(updateState.equals("1")){
				sql+=" and corpkey in (select corpkey from Z_wh where sbstate like '"+zg+"%')";
			}else if(updateState.equals("2")){
				sql+=" and corpkey in (select corpkey from T_wh where sbstate like '"+zg+"%')";
			}else if(updateState.equals("3")){
				sql+=" and corpkey in (select corpkey from T_wh where sbstate like '"+zg+"%')";
			}else if(updateState.equals("4")){
				sql+=" and corpkey in (select corpkey from Z_wh where sbstate like '"+zg+"%')";
			}else if(updateState.equals("5")){
				sql+=" and corpkey in (select corpkey from B_wh where sbstate like '"+zg+"%')";
			}
			
		}
		
		if(null!=czfs&&!"".equals(czfs)&&!"null".equals(czfs)){
			String zg=EnumerationType.getEnu("CZFS", czfs);
			if(updateState.equals("1")){
				sql+=" and corpkey in (select corpkey from Z_wh where czfs like '"+zg+"%')";
			}else if(updateState.equals("2")){
				sql+=" and corpkey in (select corpkey from T_wh where czfs like '"+zg+"%')";
			}else if(updateState.equals("3")){
				sql+=" and corpkey in (select corpkey from T_wh where czfs like '"+zg+"%')";
			}else if(updateState.equals("4")){
				sql+=" and corpkey in (select corpkey from Z_wh where czfs like '"+zg+"%')";
			}else if(updateState.equals("5")){
				sql+=" and corpkey in (select corpkey from B_wh where czfs like '"+zg+"%')";
			}
			//sql+=" and corpkey in (select corpkey from Z_wh where czfs like '"+zg+"%')";
		}
		
		if(null!=sfgl&&!"".equals(sfgl)&&!"null".equals(sfgl)){
			String zg=EnumerationType.getEnu("SFGL", sfgl);
			if(updateState.equals("1")){
				sql+=" and corpkey in (select corpkey from Z_wh where sfgl like '"+zg+"%')";
			}else if(updateState.equals("2")){
				sql+=" and corpkey in (select corpkey from T_wh where sfgl like '"+zg+"%')";
			}else if(updateState.equals("3")){
				sql+=" and corpkey in (select corpkey from T_wh where sfgl like '"+zg+"%')";
			}else if(updateState.equals("4")){
				sql+=" and corpkey in (select corpkey from Z_wh where sfgl like '"+zg+"%')";
			}else if(updateState.equals("5")){
				sql+=" and corpkey in (select corpkey from B_wh where sfgl like '"+zg+"%')";
			}
			//sql+=" and corpkey in (select corpkey from Z_wh where sfgl like '"+zg+"%')";
		}
		
		if(null!=sqlwhere&&!"".equals(sqlwhere)&&!"null".equals(sqlwhere)){
			sql+=" and "+sqlwhere;
		}
		System.out.println("sql============"+sql);
		
		String table="Z";
		String reval="01";
		if(updateState.equals("1")){
			table="Z";
			acitonname = "/UI/enterinfo/enterinfo_listInfo.action"; // ��ҳ�ύ��action
			dictid = "Z_corlist"; // ��ݼ���ʾ
			reval="01";
		}else if(updateState.equals("2")){
			acitonname = "/UI/enterinfo/Tenterinfo_listInfo.action"; // ��ҳ�ύ��action
			dictid = "T_corlist"; // ��ݼ���ʾ
			reval="02";
			table="T";
		}else if(updateState.equals("3")){
			acitonname = "/UI/enterinfo/Tenterinfo_listInfo.action"; // ��ҳ�ύ��action
			dictid = "T_corlist"; // ��ݼ���ʾ
			reval="02";
			table="T";
		}else if(updateState.equals("4")){
			acitonname = "/UI/enterinfo/enterinfo_listInfo.action"; // ��ҳ�ύ��action
			dictid = "Z_corlist"; // ��ݼ���ʾ
			reval="01";
			table="Z";
		}else if(updateState.equals("5")){
			acitonname = "/UI/enterinfo/Benterinfo_listInfo.action"; // ��ҳ�ύ��action
			dictid = "B_corlist"; // ��ݼ���ʾ
			reval="03";
			table="B";
		}
		
		CountBean cb=SearchUtil.handle(table, sql);
		mess="������ɣ�";
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("cb", cb);
		
		
		return "00";
		
	}
	

	
	public int getAbsolutePage() {
		return AbsolutePage;
	}
	public void setAbsolutePage(int absolutePage) {
		AbsolutePage = absolutePage;
	}
	public String getAcitonname() {
		return acitonname;
	}
	public void setAcitonname(String acitonname) {
		this.acitonname = acitonname;
	}
	public String getButtons() {
		return buttons;
	}
	public void setButtons(String buttons) {
		this.buttons = buttons;
	}
	public String getDataPilot() {
		return DataPilot;
	}
	public void setDataPilot(String dataPilot) {
		DataPilot = dataPilot;
	}
	public String getDictid() {
		return dictid;
	}
	public void setDictid(String dictid) {
		this.dictid = dictid;
	}
	public String getEnternoarr() {
		return enternoarr;
	}
	public void setEnternoarr(String enternoarr) {
		this.enternoarr = enternoarr;
	}
	public String getGridID() {
		return GridID;
	}
	public void setGridID(String gridID) {
		GridID = gridID;
	}
	public String getIsTotal() {
		return isTotal;
	}
	public void setIsTotal(String isTotal) {
		this.isTotal = isTotal;
	}
	public String getOrderStr() {
		return orderStr;
	}
	public void setOrderStr(String orderStr) {
		this.orderStr = orderStr;
	}
	public int getRecordCount() {
		return RecordCount;
	}
	public void setRecordCount(int recordCount) {
		RecordCount = recordCount;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	public String getWhereStr() {
		return whereStr;
	}
	public void setWhereStr(String whereStr) {
		this.whereStr = whereStr;
	}
	
}
