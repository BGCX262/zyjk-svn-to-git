package UI.action.tj;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import st.platform.security.OperatorManager;
import st.platform.security.SystemAttributeNames;
import st.system.dao.OrganizationBean;
import st.system.dao.PtdeptBean;
import st.system.dao.PtenudetailBean;
import st.system.dao.PtoperBean;
import UI.message.MisConstant;
import UI.util.DataTable;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("struts-filter")
@Namespace("/UI/action/flfjtj") 
public class FLFJTjAction extends ActionSupport{
	
	private DataTable table;
	
	private String distcode;
	
	private String hylb;
	
	private String qygm;
	
	private String zclx;
	
	private String whys;
	
	public String getWhys() {
		return whys;
	}


	public void setWhys(String whys) {
		this.whys = whys;
	}


	public String getDistcode() {
		return distcode;
	}


	public void setDistcode(String distcode) {
		this.distcode = distcode;
	}


	public String getHylb() {
		return hylb;
	}


	public void setHylb(String hylb) {
		this.hylb = hylb;
	}


	public String getQygm() {
		return qygm;
	}


	public void setQygm(String qygm) {
		this.qygm = qygm;
	}


	public String getZclx() {
		return zclx;
	}


	public void setZclx(String zclx) {
		this.zclx = zclx;
	}


	public DataTable getTable() {
		return table;
	}


	public void setTable(DataTable table) {
		this.table = table;
	}

	/**
	 * 按照行政区域进行统计
	 * @return
	 */
	 @Action(value = "FLFJTjAction_getDistcodeTable", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/flfj/tj/distcodeTj.jsp") }) 
	public String getDistcodeTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		PtoperBean oper = (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
		String dqcode=oper.getDeptid();
	    PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
        
		String dis=dept.getDistcode();
		//String discode =  st.platform.utils.Config.getProperty("discode");
		String sqlc=" and 1=1 and bak2!='2'";
		String xsql=" and 1=1";
//		if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
//			if(distcode.indexOf("00000000")>=0){
//				dqcode=distcode.substring(0, 4);
//				xsql+=" and code like '"+dqcode+"%' and depth in (1,2)";
//			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
//				dqcode=distcode.substring(0, 6);
//				xsql+=" and code like '"+dqcode+"%' and depth in (2,3)";
//			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
//				dqcode=distcode.substring(0, 9);
//				xsql+=" and code like '"+dqcode+"%' and depth in (3,4)";
//			}else{
//				xsql+=" and code like '"+distcode+"%' and depth in (4)";
//				
//			}
//			sqlc+=" and distcode like '"+dqcode+"%'";
//			//xsql+=" and code like '"+distcode+"%'";
//		}else{
//			if(dis.indexOf("00000000")>=0){
//				distcode=dis.substring(0, 4);
//				xsql+=" and code like '"+distcode+"%' and depth in (1,2)";
//			}else if(dis.indexOf("000000")>=0&&dis.indexOf("00000000")<0){
//				distcode=dis.substring(0, 6);
//				xsql+=" and code like '"+distcode+"%' and depth in (2,3)";
//			}else if(dis.indexOf("000000")<0&&dis.indexOf("00000000")<0&&dis.indexOf("000")>=0){
//				distcode=dis.substring(0, 9);
//				xsql+=" and code like '"+distcode+"%' and depth in (3,4)";
//			}else{
//				xsql+=" and code like '"+distcode+"%' and depth in (4)";
//				
//			}
//			sqlc+=" and distcode like '"+distcode+"%'";
//			//xsql+=" and code like '"+distcode+"%'";
//		}
		if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
			if(distcode.equals("370200")){
				distcode="3702";
			}
			sqlc+=" and distcode like '"+distcode+"%'";
			xsql+=" and enuitemvalue like '"+distcode+"%'";
		}else{
			String[] dises=dqcode.split("-");
			if(dises[1].length()>8){
				if(dqcode.indexOf("0000")>=0){
					dqcode=dqcode.substring(3, 7);
					distcode=dqcode;
				}else if(dqcode.indexOf("00")>=0&&dqcode.indexOf("0000")<0){
					dqcode=dqcode.substring(3, 9);
					distcode=dqcode;
				}else if(dqcode.indexOf("00")<0&&dqcode.indexOf("0000")<0){
					dqcode=dqcode.substring(3, 11);
					distcode=dqcode;
				}
			}else{
					if(dises[1].substring(0,6).indexOf("0000")>=0){
					dqcode=dqcode.substring(3, 5);
					distcode=dqcode;
				}else if(dises[1].substring(0,6).indexOf("00")>=0&&dises[1].substring(0,6).indexOf("0000")<0){
					dqcode=dqcode.substring(3, 7);
					distcode=dqcode;
				}else if(dises[1].substring(0,6).indexOf("00")<0&&dises[1].substring(0,6).indexOf("0000")<0){
					dqcode=dqcode.substring(3, 9);
					distcode=dqcode;
				}
			}
			sqlc+=" and distcode like '"+distcode+"%'";
			xsql+=" and enuitemvalue like '"+distcode+"%'";
		}
		if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
			sqlc+=" and zyjkflfj.corpkey in (select Z_cor.corpkey from Z_cor where hyfl like '"+hylb+"%')";
		}
		
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			sqlc+=" and zyjkflfj.corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
		}
		
		
		ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		
//		List<OrganizationBean> rows=new ArrayList<OrganizationBean>();
//		OrganizationBean pt=new OrganizationBean();
		List<PtenudetailBean> rows=new ArrayList<PtenudetailBean>();
		PtenudetailBean pt=new PtenudetailBean();
		try {
//			rows=pt.find(" where 1=1 "+xsql+" order by ordernum");
			rows=pt.find(" where enutype='DISTCODE'  "+xsql);
			table=new DataTable(rows.size(),12);
			for(int i=0;i<rows.size();i++){
//				OrganizationBean pb=rows.get(i);
				PtenudetailBean pb=rows.get(i);
//				table.addRow(pb.getCode(), pb.getName(), i+1);
				table.addRow(pb.getEnuitemvalue(), pb.getEnuitemlabel(), i+1);
			}
			//table.addCol("AA", "小计",0);
			table.addCol("AA", "小计", 1);
			table.addCol("A", "重点", 2);
			table.addCol("B", "一般", 3);
			
			table.addCol("CC", "小计", 4);
			table.addCol("a", "A", 5);
			table.addCol("b", "B", 6);
			table.addCol("c", "C", 7);
			//table.setSumColIdx(3, "小计");
			table.addCol("BB", "小计", 8);
			table.addCol("1", "一级", 9);
			table.addCol("2", "二级", 10);
			table.addCol("3", "三级", 11);
			table.addCol("4", "四级", 12);
			//对分类的统计
			String sql="select count(*) as num,distcode,whlb from zyjkflfj where 1=1 "+sqlc+" group by distcode,whlb ";
			System.out.println(sql);
			RecordSet rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
				 if(distcode.length()>6){
					 distcode=distcode.substring(0, 6);
				 }
				 String whlb = rs.getString("whlb");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, whlb, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,distcode from zyjkflfj where 1=1 "+sqlc+" group by distcode";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
				 //String jdgldj = rs.getString("jdgldj");
				 if(distcode.length()>6){
					 distcode=distcode.substring(0, 6);
				 }
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "AA", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			//卫生管理等级
			sql="select count(*) as num,distcode,wsgldj from zyjkflfj where 1=1 "+sqlc+" group by distcode,wsgldj";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
				 if(distcode.length()>6){
					 distcode=distcode.substring(0, 6);
				 }
				 String wsgldj = rs.getString("wsgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, wsgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,distcode from zyjkflfj where 1=1 "+sqlc+" group by distcode";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
				 if(distcode.length()>6){
					 distcode=distcode.substring(0, 6);
				 }
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "CC", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			//对分级的统计
			sql="select count(*) as num,distcode,jdgldj from zyjkflfj where 1=1 "+sqlc+" group by distcode,jdgldj";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
				 if(distcode.length()>6){
					 distcode=distcode.substring(0, 6);
				 }
				 String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, jdgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,distcode from zyjkflfj where 1=1 "+sqlc+" group by distcode";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
				 if(distcode.length()>6){
					 distcode=distcode.substring(0, 6);
				 }
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "BB", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return  MisConstant.FINDBYKEY;
	}
	 @Action(value = "FLFJTjAction_gethylbTable", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/flfj/tj/hyflTj.jsp") }) 
	public String gethylbTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		PtoperBean oper = (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
		String dqcode=oper.getDeptid();
		PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
	        
		String dis=dept.getDistcode();
		String sqlc=" and 1=1 and bak2!='2'";
		String xsql=" and 1=1";
		if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
			if(distcode.indexOf("00000000")>=0){
				dqcode=distcode.substring(0, 4);
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				dqcode=distcode.substring(0, 6);
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				dqcode=distcode.substring(0, 9);
			}
			sqlc+=" and distcode like '"+dqcode+"%'";
			//xsql+=" and enuitemvalue like '"+distcode+"%'";
		}else{
			if(dis.indexOf("00000000")>=0){
				distcode=dis.substring(0, 4);
			}else if(dis.indexOf("000000")>=0&&dis.indexOf("00000000")<0){
				distcode=dis.substring(0, 6);
			}else if(dis.indexOf("000000")<0&&dis.indexOf("00000000")<0&&dis.indexOf("000")>=0){
				distcode=dis.substring(0, 9);
			}
			sqlc+=" and distcode like '"+distcode+"%'";
			//xsql+=" and code like '"+distcode+"%'";
		}
		
		if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
			sqlc+=" and  hyfl like '"+hylb+"%'";
			if(hylb.length()==2){
				xsql+=" and len(enuitemvalue)<5 and enuitemvalue like '"+hylb+"%' ";
			}else{
				xsql+=" and enuitemvalue like '"+hylb+"%'";
			}
			
		}else{
			xsql+=" and len(enuitemvalue)<3 ";
		}
		
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			sqlc+=" and zyjkflfj.corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
		}
		
		
		
		ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		
		List<PtenudetailBean> rows=new ArrayList<PtenudetailBean>();
		PtenudetailBean pt=new PtenudetailBean();
		try {
			System.out.println(xsql);
			rows=pt.find(" where enutype='HYLB' "+xsql+" order by DISPNO");
			table=new DataTable(rows.size(),12);
			for(int i=0;i<rows.size();i++){
				PtenudetailBean pb=rows.get(i);
				table.addRow(pb.getEnuitemvalue(), pb.getEnuitemlabel(), i+1);
			}
//			table.addCol("AA", "小计",0);
			table.addCol("AA", "小计", 1);
			table.addCol("A", "重点", 2);
			table.addCol("B", "一般", 3);
			
			table.addCol("CC", "小计", 4);
			table.addCol("a", "A", 5);
			table.addCol("b", "B", 6);
			table.addCol("c", "C", 7);
			//table.setSumColIdx(3, "小计");
			table.addCol("BB", "小计", 8);
			table.addCol("1", "一级", 9);
			table.addCol("2", "二级", 10);
			table.addCol("3", "三级", 11);
			table.addCol("4", "四级", 12);
			//对分类的统计
			String sql="";
			if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
				if(hylb.length()==2){//如果行业分类是二级代码，则根据hyfl2字段进行判断
					 sql="select count(*) as num,hyfl2 as hyfl,whlb from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl2,whlb ";
				}else {
					 sql="select count(*) as num,hyfl,whlb from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl,whlb ";
				}
			
			}else {
				sql="select count(*) as num,hyfl1 as hyfl,whlb from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl1,whlb ";
			}
			System.out.println(sql);
			RecordSet rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("hyfl");
				 String whlb = rs.getString("whlb");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, whlb, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
				if(hylb.length()==2){//如果行业分类是二级代码，则根据hyfl2字段进行判断
					 sql="select count(*) as num,hyfl2 as hyfl from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl2 ";
				}else {
					 sql="select count(*) as num,hyfl from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl ";
				}
			
			}else {
				sql="select count(*) as num,hyfl1 as hyfl from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl1";
			}
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("hyfl");
				 //String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "AA", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			//卫生管理等级
			
			if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
				if(hylb.length()==2){//如果行业分类是二级代码，则根据hyfl2字段进行判断
					sql="select count(*) as num,hyfl2 as hyfl,wsgldj from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl2,wsgldj";
				}else {
					 sql="select count(*) as num,hyfl,wsgldj from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl,wsgldj ";
				}
			
			}else {
				sql="select count(*) as num,hyfl1 as hyfl,wsgldj from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl1,wsgldj";
			}
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("hyfl");
				 String wsgldj = rs.getString("wsgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, wsgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
				if(hylb.length()==2){//如果行业分类是二级代码，则根据hyfl2字段进行判断
					sql="select count(*) as num,hyfl2 as hyfl from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl2";
				}else {
					 sql="select count(*) as num,hyfl from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl ";
				}
			
			}else {
				sql="select count(*) as num,hyfl1 as hyfl from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl1";
			}
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("hyfl");
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "CC", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			//对分级的统计
			
			if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
				if(hylb.length()==2){//如果行业分类是二级代码，则根据hyfl2字段进行判断
					sql="select count(*) as num,hyfl2 as hyfl,jdgldj from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl2,jdgldj";
				}else {
					 sql="select count(*) as num,hyfl,jdgldj from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl,jdgldj ";
				}
			
			}else {
				sql="select count(*) as num,hyfl1 as hyfl,jdgldj from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl1,jdgldj";
			}
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("hyfl");
				 String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, jdgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
				if(hylb.length()==2){//如果行业分类是二级代码，则根据hyfl2字段进行判断
					sql="select count(*) as num,hyfl2 as hyfl from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl2";
				}else {
					 sql="select count(*) as num,hyfl from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl ";
				}
			
			}else {
				sql="select count(*) as num,hyfl1 as hyfl from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by hyfl1";
			}
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("hyfl");
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "BB", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return  MisConstant.FINDBYKEY;
	}
	 @Action(value = "FLFJTjAction_getqygmTable", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/flfj/tj/qygmTj.jsp") }) 
	public String getqygmTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		PtoperBean oper = (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
		String dqcode=oper.getDeptid();
		PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
	        
		String dis=dept.getDistcode();
		String sqlc=" and 1=1 and bak2!='2'";
		//String xsql=" and 1=1";
		if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
			if(distcode.indexOf("00000000")>=0){
				dqcode=distcode.substring(0, 4);
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				dqcode=distcode.substring(0, 6);
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				dqcode=distcode.substring(0, 9);
			}
			sqlc+=" and distcode like '"+dqcode+"%'";
			//xsql+=" and enuitemvalue like '"+distcode+"%'";
		}else{
			if(dis.indexOf("00000000")>=0){
				distcode=dis.substring(0, 4);
			}else if(dis.indexOf("000000")>=0&&dis.indexOf("00000000")<0){
				distcode=dis.substring(0, 6);
			}else if(dis.indexOf("000000")<0&&dis.indexOf("00000000")<0&&dis.indexOf("000")>=0){
				distcode=dis.substring(0, 9);
			}
			sqlc+=" and distcode like '"+distcode+"%'";
			//xsql+=" and enuitemvalue like '"+distcode+"%'";
		}
		
		if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
			sqlc+=" and  hyfl like '"+hylb+"%'";
		}
		
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			sqlc+=" and corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
		}
		
		
		ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		
		List<PtenudetailBean> rows=new ArrayList<PtenudetailBean>();
		PtenudetailBean pt=new PtenudetailBean();
		try {
			rows=pt.find(" where enutype='QYGM'");
			table=new DataTable(rows.size(),12);
			for(int i=0;i<rows.size();i++){
				PtenudetailBean pb=rows.get(i);
				table.addRow(pb.getEnuitemvalue(), pb.getEnuitemlabel(), i+1);
			}
//			table.addCol("AA", "小计",0);
			table.addCol("AA", "小计", 1);
			table.addCol("A", "重点", 2);
			table.addCol("B", "一般", 3);
			
			table.addCol("CC", "小计", 4);
			table.addCol("a", "A", 5);
			table.addCol("b", "B", 6);
			table.addCol("c", "C", 7);
			//table.setSumColIdx(3, "小计");
			table.addCol("BB", "小计", 8);
			table.addCol("1", "一级", 9);
			table.addCol("2", "二级", 10);
			table.addCol("3", "三级", 11);
			table.addCol("4", "四级", 12);
			//对分类的统计
			String sql="select count(*) as num,chanzhi,whlb from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by chanzhi,whlb ";
			System.out.println(sql);
			RecordSet rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("chanzhi");
				 String whlb = rs.getString("whlb");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, whlb, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,chanzhi from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by chanzhi";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("chanzhi");
				 //String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "AA", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
//			卫生管理等级
			sql="select count(*) as num,chanzhi,wsgldj from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by chanzhi,wsgldj";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("chanzhi");
				 String wsgldj = rs.getString("wsgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, wsgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,chanzhi from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by chanzhi";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("chanzhi");
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "CC", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			//对分级的统计
			sql="select count(*) as num,chanzhi,jdgldj from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by chanzhi,jdgldj";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("chanzhi");
				 String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, jdgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,chanzhi from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by chanzhi";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("chanzhi");
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "BB", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return  MisConstant.FINDBYKEY;
	}
	 @Action(value = "FLFJTjAction_getzclxTable", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/flfj/tj/zclxTj.jsp") }) 
	public String getzclxTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		PtoperBean oper = (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
		String dqcode=oper.getDeptid();
		PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
	        
		String dis=dept.getDistcode();
		String sqlc=" and 1=1 and bak2!='2'";
		String xsql=" and 1=1";
		if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
			if(distcode.indexOf("00000000")>=0){
				dqcode=distcode.substring(0, 4);
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				dqcode=distcode.substring(0, 6);
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				dqcode=distcode.substring(0, 9);
			}
			sqlc+=" and distcode like '"+dqcode+"%'";
			//xsql+=" and enuitemvalue like '"+distcode+"%'";
		}else{
			if(dis.indexOf("00000000")>=0){
				distcode=dis.substring(0, 4);
			}else if(dis.indexOf("000000")>=0&&dis.indexOf("00000000")<0){
				distcode=dis.substring(0, 6);
			}else if(dis.indexOf("000000")<0&&dis.indexOf("00000000")<0&&dis.indexOf("000")>=0){
				distcode=dis.substring(0, 9);
			}
			sqlc+=" and distcode like '"+distcode+"%'";
			//xsql+=" and enuitemvalue like '"+distcode+"%'";
		}
		if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
			sqlc+=" and  hyfl like '"+hylb+"%'";
		}
		
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			sqlc+=" and zyjkflfj.corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
		}
		
		ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		
		List<PtenudetailBean> rows=new ArrayList<PtenudetailBean>();
		PtenudetailBean pt=new PtenudetailBean();
		try {
			rows=pt.find(" where enutype='ZCLX'");
			table=new DataTable(rows.size(),12);
			for(int i=0;i<rows.size();i++){
				PtenudetailBean pb=rows.get(i);
				table.addRow(pb.getEnuitemvalue(), pb.getEnuitemlabel(), i+1);
			}
//			table.addCol("AA", "小计",0);
			table.addCol("AA", "小计", 1);
			table.addCol("A", "重点", 2);
			table.addCol("B", "一般", 3);
			
			table.addCol("CC", "小计", 4);
			table.addCol("a", "A", 5);
			table.addCol("b", "B", 6);
			table.addCol("c", "C", 7);
			//table.setSumColIdx(3, "小计");
			table.addCol("BB", "小计", 8);
			table.addCol("1", "一级", 9);
			table.addCol("2", "二级", 10);
			table.addCol("3", "三级", 11);
			table.addCol("4", "四级", 12);
			//对分类的统计
			String sql="select count(*) as num,zclx,whlb from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by whlb,zclx ";
			System.out.println(sql);
			RecordSet rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("zclx");
				 String whlb = rs.getString("whlb");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, whlb, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,zclx from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by zclx";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("zclx");
				 //String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "AA", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
//			卫生管理等级
			sql="select count(*) as num,zclx,wsgldj from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by wsgldj,zclx";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("zclx");
				 String wsgldj = rs.getString("wsgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, wsgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,zclx from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by zclx";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("zclx");
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "CC", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			//对分级的统计
			sql="select count(*) as num,zclx,jdgldj from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by jdgldj,zclx";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("zclx");
				 String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, jdgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,zclx from zyjkflfj,Z_cor  where 1=1 and zyjkflfj.corpkey=Z_cor.corpkey "+sqlc+" group by zclx";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("zclx");
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "BB", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return  MisConstant.FINDBYKEY;
	}
	 @Action(value = "FLFJTjAction_getWhysTable", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/flfj/tj/whysTj.jsp") }) 
	public String getWhysTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		PtoperBean oper = (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
		String dqcode=oper.getDeptid();
		PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
	        
		String dis=dept.getDistcode();
		String sqlc=" and 1=1 and bak2!='2'";
		String xsql=" and 1=1";
		if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
			if(distcode.indexOf("00000000")>=0){
				dqcode=distcode.substring(0, 4);
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				dqcode=distcode.substring(0, 6);
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				dqcode=distcode.substring(0, 9);
			}
			sqlc+=" and distcode like '"+dqcode+"%'";
			//xsql+=" and enuitemvalue like '"+distcode+"%'";
		}else{
			if(dis.indexOf("00000000")>=0){
				distcode=dis.substring(0, 4);
			}else if(dis.indexOf("000000")>=0&&dis.indexOf("00000000")<0){
				distcode=dis.substring(0, 6);
			}else if(dis.indexOf("000000")<0&&dis.indexOf("00000000")<0&&dis.indexOf("000")>=0){
				distcode=dis.substring(0, 9);
			}
			sqlc+=" and distcode like '"+distcode+"%'";
			
		}
		if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
			sqlc+=" and zyjkflfj.corpkey in(select Z_cor.corpkey from Z_cor where hyfl like '"+hylb+"%')";
		}
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			sqlc+=" and  whDM like '"+whys+"%' ";
		}
		//对枚举表添加查询条件
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			if(whys.length()==2){
				xsql+=" and enuitemvalue like '"+whys+"%' ";
			}else{
				xsql+=" and enuitemvalue like '"+whys+"%'";
			}
			
		}else{
			xsql+=" and len(enuitemvalue)<3 ";
		}
		
		
		ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		
		List<PtenudetailBean> rows=new ArrayList<PtenudetailBean>();
		PtenudetailBean pt=new PtenudetailBean();
		try {
			System.out.println(xsql);
			rows=pt.find(" where enutype='WHYS' "+xsql+" order by DISPNO");
			table=new DataTable(rows.size(),12);
			for(int i=0;i<rows.size();i++){
				PtenudetailBean pb=rows.get(i);
				table.addRow(pb.getEnuitemvalue(), pb.getEnuitemlabel(), i+1);
			}
//			table.addCol("AA", "小计",0);
			table.addCol("AA", "小计", 1);
			table.addCol("A", "重点", 2);
			table.addCol("B", "一般", 3);
			
			table.addCol("CC", "小计", 4);
			table.addCol("a", "A", 5);
			table.addCol("b", "B", 6);
			table.addCol("c", "C", 7);
			//table.setSumColIdx(3, "小计");
			table.addCol("BB", "小计", 8);
			table.addCol("1", "一级", 9);
			table.addCol("2", "二级", 10);
			table.addCol("3", "三级", 11);
			table.addCol("4", "四级", 12);
			//对分类的统计
			String sql="";
			if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
//				if(whys.length()==2){//如果行业分类是二级代码，则根据hyfl2字段进行判断
//					 sql="select count(*) as num,substring(whDM,1,2) as whDM,whlb from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by substring(whDM,1,2),whlb ";
//				}else {
					 sql="select count(*) as num,whDM,whlb from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by whDM,whlb ";
//				}
			
			}else {
				sql="select count(*) as num,substring(whDM,1,2) as whDM,whlb from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by substring(whDM,1,2),whlb ";
			}
			System.out.println(sql);
			RecordSet rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("whDM");
				 String whlb = rs.getString("whlb");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, whlb, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
//				if(whys.length()==2){//如果行业分类是二级代码，则根据hyfl2字段进行判断
//					 sql="select count(*) as num,substring(whDM,1,2) as whDM from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by substring(whDM,1,2) ";
//				}else {
					 sql="select count(*) as num,whDM from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by whDM ";
//				}
			
			}else {
				sql="select count(*) as num,substring(whDM,1,2) as whDM from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by substring(whDM,1,2)";
			}
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("whDM");
				 //String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "AA", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			//卫生管理等级
			
			if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
//				if(whys.length()==2){//如果危害因素是二级代码，则根据hyfl2字段进行判断
//					sql="select count(*) as num,substring(whDM,1,2) as whDM,wsgldj from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by substring(whDM,1,2),wsgldj";
//				}else {
					 sql="select count(*) as num,whDM,wsgldj from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by whDM,wsgldj ";
//				}
			
			}else {
				sql="select count(*) as num,substring(whDM,1,2) as whDM,wsgldj from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by substring(whDM,1,2) ,wsgldj";
			}
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("whDM");
				 String wsgldj = rs.getString("wsgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, wsgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
//				if(whys.length()==2){//如果行业分类是二级代码，则根据hyfl2字段进行判断
//					sql="select count(*) as num,substring(whDM,1,2) as whDM from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by whDM";
//				}else {
					 sql="select count(*) as num,whDM from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by whDM ";
//				}
			
			}else {
				sql="select count(*) as num,substring(whDM,1,2) as whDM from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by whDM";
			}
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("whDM");
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "CC", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			//对分级的统计
			
			if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
//				if(whys.length()==2){//如果危害因素是二级代码，则根据hyfl2字段进行判断
//					sql="select count(*) as num,substring(whDM,1,2) as whDM,jdgldj from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by substring(whDM,1,2),jdgldj";
//				}else {
					 sql="select count(*) as num,whDM,jdgldj from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by whDM,jdgldj ";
//				}
			
			}else {
				sql="select count(*) as num,substring(whDM,1,2) as whDM,jdgldj from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by substring(whDM,1,2) ,jdgldj";
			}
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("whDM");
				 String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, jdgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
//				if(whys.length()==2){//如果行业分类是二级代码，则根据hyfl2字段进行判断
//					sql="select count(*) as num,substring(whDM,1,2) as whDM from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by whDM";
//				}else {
					 sql="select count(*) as num,whDM from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by whDM ";
//				}
			
			}else {
				sql="select count(*) as num,substring(whDM,1,2) as whDM from zyjkflfj,Z_wh  where 1=1 and zyjkflfj.corpkey=Z_wh.corpkey "+sqlc+" group by whDM";
			}
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("whDM");
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "BB", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return  MisConstant.FINDBYKEY;
	}
	
	
	/**
	 * 区县对镇街进行统计
	 * @return
	 */
	 @Action(value = "FLFJTjAction_getZjDistcodeTable", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/flfj/tj/distcodeZjTj.jsp") }) 
	public String getZjDistcodeTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
//		OperatorManager om = (OperatorManager) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
//		String dqcode=om.getDept().getDeptid();
		//String discode =  st.platform.utils.Config.getProperty("discode");
		String sqlc=" and 1=1 and bak2!='2'";
		String xsql=" and 1=1";
		int depth=4;
		if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
			if(distcode.equals("370200")){
				distcode="3702";
			}
			if(distcode.indexOf("00000000")>=0){
				distcode=distcode.substring(0, 4);
				depth=1;
				xsql+=" and code like '"+distcode+"%' and depth in (1,2)";
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				distcode=distcode.substring(0, 6);
				xsql+=" and code like '"+distcode+"%' and depth in (2,3)";
				depth=2;
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				distcode=distcode.substring(0, 9);
				xsql+=" and code like '"+distcode+"%' and depth in (3,4)";
				depth=3;
			}else{
				xsql+=" and code like '"+distcode+"%' and depth in (4)";
				depth=4;
			}
			sqlc+=" and distcode like '"+distcode+"%'";
			//xsql+=" and code like '"+distcode+"%'";
		}
		if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
			sqlc+=" and zyjkflfj.corpkey in (select Z_cor.corpkey from Z_cor where hyfl like '"+hylb+"%')";
		}
		
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			sqlc+=" and zyjkflfj.corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
		}
		
		
		ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		
		List<PtenudetailBean> rows=new ArrayList<PtenudetailBean>();
		//PtenudetailBean pt=new PtenudetailBean();
		try {
			String dsql="select * from organization where  1=1 "+xsql+" order by ordernum";
			System.out.println(xsql);
			RecordSet rs=dcc.executeQuery(dsql);
			
			
			while(rs.next()){
				PtenudetailBean pb=new PtenudetailBean();
				pb.setEnuitemvalue(rs.getString("code"));
				pb.setEnuitemlabel(rs.getString("name"));
				rows.add(pb);
			}
			
			table=new DataTable(rows.size(),12);
			for(int i=0;i<rows.size();i++){
				PtenudetailBean pb=rows.get(i);
				table.addRow(pb.getEnuitemvalue(), pb.getEnuitemlabel(), i+1);
			}
			//table.addCol("AA", "小计",0);
			table.addCol("AA", "小计", 1);
			table.addCol("A", "重点", 2);
			table.addCol("B", "一般", 3);
			
			table.addCol("CC", "小计", 4);
			table.addCol("a", "A", 5);
			table.addCol("b", "B", 6);
			table.addCol("c", "C", 7);
			//table.setSumColIdx(3, "小计");
			table.addCol("BB", "小计", 8);
			table.addCol("1", "一级", 9);
			table.addCol("2", "二级", 10);
			table.addCol("3", "三级", 11);
			table.addCol("4", "四级", 12);
			//对分类的统计
			String sql="select count(*) as num,distcode,whlb from zyjkflfj where 1=1 "+sqlc+" group by distcode,whlb ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 String whlb = rs.getString("whlb");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, whlb, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,distcode from zyjkflfj where 1=1 "+sqlc+" group by distcode";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
				 //String jdgldj = rs.getString("jdgldj");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "AA", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			//卫生管理等级
			sql="select count(*) as num,distcode,wsgldj from zyjkflfj where 1=1 "+sqlc+" group by distcode,wsgldj";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 String wsgldj = rs.getString("wsgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, wsgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,distcode from zyjkflfj where 1=1 "+sqlc+" group by distcode";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "CC", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
			//对分级的统计
			sql="select count(*) as num,distcode,jdgldj from zyjkflfj where 1=1 "+sqlc+" group by distcode,jdgldj";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, jdgldj, Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			sql="select count(*) as num,distcode from zyjkflfj where 1=1 "+sqlc+" group by distcode";
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				// String jdgldj = rs.getString("jdgldj");
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "BB", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return  MisConstant.FINDBYKEY;
	}
	
}
