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
@Namespace("/UI/action/gksmtj") 
public class GksmTjAction extends ActionSupport{
	
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
	 @Action(value = "GksmTjAction_getDistcodeTable", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/gksm/tj/distcodeTj.jsp") }) 
	public String getDistcodeTable(){
		HttpServletRequest request=ServletActionContext.getRequest();
		PtoperBean oper = (PtoperBean) request.getSession().getAttribute(SystemAttributeNames.USER_INFO_NAME);
		String dqcode="";
	    PtdeptBean dept=(PtdeptBean)ServletActionContext.getContext().getSession().get(SystemAttributeNames.DEPT_INFO_NAME);
        
	   String dis=dept.getDistcode();
		System.out.println("dqcode:"+distcode);
		//String discode =  st.platform.utils.Config.getProperty("discode");
		String sqlc=" and 1=1 ";
		String xsql=" and 1=1";
		if(null!=distcode&&!"".equals(distcode)&&!"null".equals(distcode)){
			if(distcode.indexOf("00000000")>=0){
				dqcode=distcode.substring(0, 4);
				xsql+=" and code like '"+dqcode+"%' and depth in (1,2)";
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				dqcode=distcode.substring(0, 6);
				xsql+=" and code like '"+dqcode+"%' and depth in (2,3)";
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				dqcode=distcode.substring(0, 9);
				xsql+=" and code like '"+dqcode+"%' and depth in (3,4)";
			}else{
				xsql+=" and code like '"+distcode+"%' and depth in (4)";
				
			}
			sqlc+=" and distcode like '"+dqcode+"%'";
			//xsql+=" and code like '"+distcode+"%'";
		}else{
			if(dis.indexOf("00000000")>=0){
				distcode=dis.substring(0, 4);
				xsql+=" and code like '"+distcode+"%' and depth in (1,2)";
			}else if(dis.indexOf("000000")>=0&&dis.indexOf("00000000")<0){
				distcode=dis.substring(0, 6);
				xsql+=" and code like '"+distcode+"%' and depth in (2,3)";
			}else if(dis.indexOf("000000")<0&&dis.indexOf("00000000")<0&&dis.indexOf("000")>=0){
				distcode=dis.substring(0, 9);
				xsql+=" and code like '"+distcode+"%' and depth in (3,4)";
			}else{
				xsql+=" and code like '"+distcode+"%' and depth in (4)";
				
			}
			sqlc+=" and distcode like '"+distcode+"%'";
			//xsql+=" and code like '"+distcode+"%'";
		}
		
		if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
			sqlc+=" and qyjbqk.enterno in (select qyjbqk.enterno from qyjbqk where hyfl like '"+hylb+"%')";
		}
		
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			sqlc+=" and qyjbqk.corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
		}
		
		
		ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		DatabaseConnection dcc = cmm.get();
		
//		List<PtenudetailBean> rows=new ArrayList<PtenudetailBean>();
//		PtenudetailBean pt=new PtenudetailBean();
		List<OrganizationBean> rows=new ArrayList<OrganizationBean>();
		OrganizationBean pt=new OrganizationBean();
		try {
			rows=pt.find(" where 1=1 "+xsql+" order by ordernum");
			//System.out.println(" where enutype='DISTCODE'  "+xsql);
			table=new DataTable(rows.size(),32);
			for(int i=0;i<rows.size();i++){
				OrganizationBean pb=rows.get(i);
				table.addRow(pb.getCode(), pb.getName(), i+1);
			}
			//table.addCol("AA", "小计",0);
			table.addCol("AA", "企业数量", 1);
			table.addCol("A", "从业人数", 2);
			table.addCol("B", "合计", 3);
			table.addCol("C", "小计", 4);
			table.addCol("FC1", "矽尘", 5);
			table.addCol("FC3", "石棉尘", 6);
			table.addCol("F", "小计", 7);
			table.addCol("G", "高毒和极度、高度危害化学物质", 8);
			table.addCol("H", "小计", 9);
			table.addCol("WL9", "电离辐射", 10);
			table.addCol("WL3", "噪声", 11);
			table.addCol("K", "小计", 12);
			table.addCol("QT4", "炭疽杆菌", 13);
			
			table.addCol("M", "合计", 14);
			table.addCol("N", "小计", 15);
			table.addCol("O", "矽尘", 16);
			table.addCol("P", "石棉尘", 17);
			table.addCol("PQ", "小计", 18);
			table.addCol("Q", "高毒和极度、高度危害化学物质", 19);
			table.addCol("R", "小计", 20);
			table.addCol("S", "电离辐射", 21);
			table.addCol("T", "噪声", 22);
			table.addCol("U", "小计", 23);
			table.addCol("V", "炭疽杆菌", 24);
			
			table.addCol("W", "申报职业病危害企业数", 25);
			table.addCol("X", "职业病危害申报率", 26);
			table.addCol("Y", "应职业病危害预评价项目数", 27);
			table.addCol("YZ", "实际职业病危害预评价项目数", 28);
			table.addCol("Z", "实际职业病危害预评价率", 29);
			table.addCol("AB", "应职业病危害控制效果项目数", 30);
			table.addCol("AC", "实际职业病危害控制效果项目数", 31);
			table.addCol("AD", "建设项目职业病危害控制效果评价率", 32);
			
			
			
			
			//1、对企业的统计
			String sql="select count(*) as num,distcode from qyjbqk where 1=1 "+sqlc+"  group by distcode ";
			System.out.println(sql);
			RecordSet rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "AA", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
//			2、对企业人数的统计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "A", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
//			3、对粉尘接触人数的统计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk  where 1=1 "+sqlc+" and whys like 'FC1%' and whys not like 'FC11%'  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                
                 if (!table.addCellValue(distcode, "FC1", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
	
			
//			4、对石棉尘人数的统计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  and whys like 'FC3%'   group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "FC3", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
	
			
//			5、对化学因素人数的统计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  and whys like 'HX%'  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "G", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
//			6、对电离辐射人数的统计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  and whys like 'WL9%'  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "WL9", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
//			7、对噪声人数的统计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  and whys like 'WL2%'  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "WL2", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
//			8、对炭疽杆菌人数的统计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  and whys like 'QT4%'  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "QT4", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
//			9、人数合计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  and (whys like 'QT4%' or whys like 'WL2%' or whys like 'WL9%' or whys like 'HX%' or whys like 'FC3%' or (whys like 'FC1%' and whys not like 'FC11%' ))  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "B", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}	
//			10、粉尘人数小计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  and (whys like 'FC3%' or (whys like 'FC1%' and whys not like 'FC11%' ))  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "C", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}	
//			11、化学毒物人数小计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  and whys like 'HX%'  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "F", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}	
//			12、物理因素人数小计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  and (whys like 'WL2%' or whys like 'WL9%')   group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "H", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}	
//			13、生物因素人数小计
			sql="select sum(nmzgrs) as num,distcode from qyjbqk where 1=1 "+sqlc+"  and whys like 'QT4%'   group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "K", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
//			14、申报企业数
			sql="select count(*) as num,distcode from qyjbqk where 1=1 "+sqlc+"  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "W", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}	
//			15、应预评价项目数
			sql="select count(*) as num,distcode from jcxmxx where 1=1 "+sqlc+"  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "Y", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}	
//			16、实际预评价项目数
			sql="select count(*) as num,distcode from jcxmxx where 1=1 "+sqlc+"  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "YZ", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
//			17、应控制效果评价项目数
			sql="select count(*) as num,distcode from jcxmxx where 1=1 "+sqlc+"  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "AB", Integer.parseInt(num))) {
                	 table.addCellValue(distcode, table.getColMeta(table.getCols() - 1), Integer.parseInt(num));
                 }
			}
			
//			18、实际控制效果评价数
			sql="select count(*) as num,distcode from jcxmxx where 1=1 "+sqlc+"  group by distcode ";
			System.out.println(sql);
			rs = dcc.executeQuery(sql);
			while(rs.next()){
				 String distcode= rs.getString("distcode");
//				 if(distcode.length()>6){
//					 distcode=distcode.substring(0, 6);
//				 }
				 distcode=distcode.substring(0, 6)+"000000";
                 String num = rs.getString("num");
                 if (!table.addCellValue(distcode, "AC", Integer.parseInt(num))) {
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
