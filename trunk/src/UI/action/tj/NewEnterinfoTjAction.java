package UI.action.tj;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import st.platform.utils.Config;
import st.system.dao.PtenudetailBean;

import UI.message.MisConstant;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 职业健康监管统计
 * @author jmx
 *
 */
@ParentPackage("struts-filter")
@Namespace("/UI/action/enterinfotj") 
public class NewEnterinfoTjAction extends ActionSupport {
	
	private String discode;
	
	private String hylb;
	
	private String whys;
	
	private String kind;
	
	private String type;
	
	private List lista;
	
	private List listb;
	
	private List listc;
	
	private List listd;
	
	private List liste;
	private List listf;
	private List listg;
	private List listh;
	private List listj;
	
	private List list;
	
	private List xcode;
	
	private List xname;
	
	private List ycode;
	
	private List yname;
	/**
	 * 存在职业健康危害因素的企业和职工人数的分布情况
	 * @return
	 * @throws Exception 
	 */
	 @Action(value = "NewEnterinfoTjAction_enterPerCount", results = { 
			   @Result(name = MisConstant.FINDBYKEY, location = "/UI/zyjk/cor/tongji/newEnterCount.jsp") }) 
	public String enterPerCount() throws Exception{
		String sql="";
		String sql_1="";
		String sql_2="";
		String sql1="";
		String sql1_1="";
		String sql1_2="";
		String sql2="";
		String sql2_1="";
		String sql2_2="";
		String sql3="";
		String sql3_1="";
		String sql3_2="";
		String sql4="";
		String sql4_1="";
		String sql4_2="";
		String sql5="";
		String sql5_1="";
		String sql5_2="";
		String sql6="";
		String sql6_1="";
		String sql6_2="";
		String sql7="";
		String sql7_1="";
		String sql7_2="";
		String sql8="";
		String sql8_1="";
		String sql8_2="";
		String sqltj="";
		String sql1tj="";
		String sql2tj="";
		String sql3tj="";
		String sql4tj="";
		String sql5tj="";
		String sql6tj="";
		String sql7tj="";
		String sql8tj="";
		ycode=new ArrayList();
		yname=new ArrayList();
		String hql=" where 1=1";
		list=new ArrayList();
		if(null!=discode&&!"".equals(discode)&&!"null".equals(discode)){
			if(discode.equals("370200")){
				discode="3702";
			}
			hql+=" and DQ3 like '"+discode+"%'";
		}else{
			hql+=" and DQ3 like '3702%'";
		}
		if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
			hql+=" and hyfl like '"+hylb+"%'";
		}
		if(null!=type&&!"".equals(type)&&!"null".equals(type)){
			hql+=" and zclx like '"+type+"%'";
		}
//		if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
//			hql+=" and substring(hyfl,1,2) like '%"+hylb+"%'";
//		}
		if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
			hql+=" and a.corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
		}
		
		//按行政区划对之职业危害因素进行统计
		if(kind.equals("1111")){
			//查询所有的企业数
			sql="select DQ3 as ycode,'aa' as xcode,count(*) as sl from Z_cor a "+hql+" group by DQ3";
			//查询所有的职工人数
			sql1="select DQ3 as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a "+hql+" group by DQ3";
			//累计职业病人数
			sql2="select DQ3 as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a "+hql+"  group by DQ3";
//			危害人数
			sql3="select DQ3 as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a  "+hql+"  group by DQ3";
			//职业病危害种类人数
			//sql4="select DQ3 as ycode, 'nmg' as xcode, sum(CONVERT(int,jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by DQ3";
			sql4="select DQ3 as ycode, 'nmg' as xcode, sum(convert(int,jcfcren)) as sl from Z_cor a "+hql+" group by DQ3";
			sql5="select DQ3 as ycode, 'ff' as xcode, sum(convert(int,jchxren)) as sl from Z_cor a "+hql+" group by DQ3";
			sql6="select DQ3 as ycode,	'gqtjrs' as xcode,sum(convert(int,jcwlren)) as sl from Z_cor a "+hql+" group by DQ3";
			sql7="select DQ3 as ycode,	'gztjrs' as xcode,sum(convert(int,jcfsren)) as sl from Z_cor a "+hql+" group by DQ3";
			sql8="select DQ3 as ycode,	'lgtjrs' as xcode,sum(convert(int,jcqtren)) as sl from Z_cor a "+hql+" group by DQ3";
//			查询所有的企业数
			sqltj="select 'hj' as ycode,'aa' as xcode,count(*) as sl from Z_cor a"+hql+" ";
			//查询所有的职工人数
			sql1tj="select 'hj' as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a "+hql+"";
			//累计职业病人数
			sql2tj="select 'hj' as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a "+hql+"";
			//危害总数
			sql3tj="select 'hj' as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a "+hql+" ";
			//职业病危害种类人数
			//sql4tj="select 'hj' as ycode, 'nmg' as xcode, sum(CONVERT(int,jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			sql4tj="select 'hj' as ycode, 'nmg' as xcode, sum(convert(int,jcfcren)) as sl from Z_cor a "+hql+" ";
			sql5tj="select 'hj' as ycode, 'ff' as xcode, sum(convert(int,jchxren)) as sl from Z_cor a "+hql+" ";
			sql6tj="select 'hj' as ycode, 'gqtjrs' as xcode, sum(convert(int,jcwlren)) as sl from Z_cor a "+hql+" ";
			sql7tj="select 'hj' as ycode,	'gztjrs' as xcode,sum(convert(int,jcfsren)) as sl from Z_cor a "+hql+"";
			sql8tj="select 'hj' as ycode,	'lgtjrs' as xcode,sum(convert(int,jcqtren)) as sl from Z_cor a "+hql+"";
			try {
				//List listxs= Enumer.getPtenudetaillist("DISTCODE", " and enuitemvalue  like '3702%'");
				PtenudetailBean bean = new PtenudetailBean();
				String ysql=" where 1=1";
				if(null!=discode&&!"".equals(discode)&&!"null".equals(discode)){
					ysql+=" and enuitemvalue like '"+discode+"%'";
				}else{
					ysql+=" and enuitemvalue  like '3702%'";
				}
				
				List listxs= bean.findByWhere(ysql+ " and enutype='DISTCODE' order by dispno");
				for(int i=0;i<listxs.size();i++){
					PtenudetailBean pb=(PtenudetailBean)listxs.get(i);
					ycode.add(pb.getEnuitemvalue());
					yname.add(pb.getEnuitemlabel());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//按行业类别对职业危害因素进行统计
		if(kind.equals("2222")){
//			查询所有的企业数
			sql="select substring(hyfl,1,2) as ycode,'aa' as xcode,count(*) as sl from Z_cor a "+hql+" group by substring(hyfl,1,2)";
			sql_1="select substring(hyfl,1,3) as ycode,'aa' as xcode,count(*) as sl from Z_cor a "+hql+" group by substring(hyfl,1,3)";
			sql_2="select hyfl as ycode,'aa' as xcode,count(*) as sl from Z_cor a "+hql+" group by hyfl";
			//查询所有的职工人数
			sql1="select substring(hyfl,1,2) as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,2)";
			sql1_1="select substring(hyfl,1,3) as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,3)";
			sql1_2="select hyfl as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a "+hql+" group by hyfl";
			////累计职业病人数
			sql2="select substring(hyfl,1,2) as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a "+hql+"  group by substring(hyfl,1,2)";
			sql2_1="select substring(hyfl,1,3) as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a "+hql+"  group by substring(hyfl,1,3)";
			sql2_2="select hyfl as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a "+hql+"  group by hyfl";
			//危害人数
			sql3="select substring(hyfl,1,2) as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a  "+hql+"  group by substring(hyfl,1,2)";
			sql3_1="select substring(hyfl,1,3) as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a  "+hql+"  group by substring(hyfl,1,3)";
			sql3_2="select hyfl as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a  "+hql+"  group by hyfl";
			//危害分类人数
			//sql4="select substring(hyfl,1,2) as ycode, 'nmg' as xcode, sum(CONVERT(int,jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey  group by substring(hyfl,1,2)";
			//sql4_1="select substring(hyfl,1,3) as ycode, 'nmg' as xcode, sum(CONVERT(int,jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey  group by substring(hyfl,1,3)";
			//sql4_2="select hyfl as ycode, 'nmg' as xcode, sum(CONVERT(int,jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey  group by hyfl";
			sql4="select substring(hyfl,1,2) as ycode, 'nmg' as xcode, sum(convert(int,jcfcren)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,2)";
			sql4_1="select substring(hyfl,1,3) as ycode, 'nmg' as xcode, sum(convert(int,jcfcren)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,3)";
			sql4_2="select hyfl as ycode, 'nmg' as xcode, sum(convert(int,jcfcren)) as sl from Z_cor a "+hql+" group by hyfl";
			
			sql5="select substring(hyfl,1,2) as ycode, 'ff' as xcode, sum(convert(int,jchxren)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,2)";
			sql5_1="select substring(hyfl,1,3) as ycode, 'ff' as xcode, sum(convert(int,jchxren)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,3)";
			sql5_2="select hyfl as ycode, 'ff' as xcode, sum(convert(int,jchxren)) as sl from Z_cor a "+hql+" group by hyfl";
			
			sql6="select substring(hyfl,1,2) as ycode, 'gqtjrs' as xcode, sum(convert(int,jcwlren)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,2)";
			sql6_1="select substring(hyfl,1,3) as ycode, 'gqtjrs' as xcode, sum(convert(int,jcwlren)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,3)";
			sql6_2="select hyfl as ycode, 'gqtjrs' as xcode, sum(convert(int,jcwlren)) as sl from Z_cor a "+hql+" group by hyfl";
			
			sql7="select substring(hyfl,1,2) as ycode,	'gztjrs' as xcode,sum(convert(int,jcfsren)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,2)";
			sql7_1="select substring(hyfl,1,3) as ycode,	'gztjrs' as xcode,sum(convert(int,jcfsren)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,3)";
			sql7_2="select hyfl as ycode,	'gztjrs' as xcode,sum(convert(int,jcfsren)) as sl from Z_cor a "+hql+" group by hyfl";
			
			sql8="select substring(hyfl,1,2) as ycode,	'lgtjrs' as xcode,sum(convert(int,jcqtren)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,2)";
			sql8_1="select substring(hyfl,1,3) as ycode,	'lgtjrs' as xcode,sum(convert(int,jcqtren)) as sl from Z_cor a "+hql+" group by substring(hyfl,1,3)";
			sql8_2="select hyfl as ycode,	'lgtjrs' as xcode,sum(convert(int,jcqtren)) as sl from Z_cor a "+hql+" group by hyfl";
			
			
//			查询所有的企业数
			sqltj="select 'hj' as ycode,'aa' as xcode,count(*) as sl from Z_cor a "+hql+" ";
			//查询所有的职工人数
			sql1tj="select 'hj' as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a "+hql+" ";
			//查询接触职工数：总数，女工，农民工
			sql2tj="select 'hj' as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a "+hql+"  ";
			sql3tj="select 'hj' as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a "+hql+"  ";
			//sql4tj="select 'hj' as ycode, 'nmg' as xcode, sum(CONVERT(int,jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			sql4tj="select 'hj' as ycode, 'nmg' as xcode, sum(convert(int,jcfcren)) as sl from Z_cor a "+hql+" ";
			sql5tj="select 'hj' as ycode, 'ff' as xcode, sum(convert(int,jchxren)) as sl from Z_cor a "+hql+" ";
			sql6tj="select 'hj' as ycode, 'gqtjrs' as xcode, sum(convert(int,jcwlren)) as sl from Z_cor a "+hql+" ";
			sql7tj="select 'hj' as ycode,	'gztjrs' as xcode,sum(convert(int,jcfsren)) as sl from Z_cor a "+hql+" ";
			sql8tj="select 'hj' as ycode,	'lgtjrs' as xcode,sum(convert(int,jcqtren)) as sl from Z_cor a "+hql+" ";
			try {
				PtenudetailBean bean = new PtenudetailBean();
				String ysql=" where 1=1";
				if(null!=hylb&&!"".equals(hylb)&&!"null".equals(hylb)){
					ysql+=" and enuitemvalue like '"+hylb+"%'";
				}else{
					ysql+=" and len(ENUITEMVALUE)<3";
				}
				System.out.println(ysql);
				List listxs= bean.findByWhere(ysql+ " and enutype='HYLB' order by dispno");
				for(int i=0;i<listxs.size();i++){
					PtenudetailBean pb=(PtenudetailBean)listxs.get(i);
					ycode.add(pb.getEnuitemvalue());
					yname.add(pb.getEnuitemlabel());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//按职业危害因素进行统计
		if(kind.equals("3333")){
//			查询所有的企业数
			sql="select substring(b.whDM,1,2) as ycode,'aa' as xcode,count(*) as sl from Z_cor a,Z_pxtj b  "+hql+" and a.corpkey=b.corpkey  group by  substring(b.whDM,1,2)";
			sql_1="select b.whDM as ycode,'aa' as xcode,count(*) as sl from Z_cor a,Z_pxtj b  "+hql+" and a.corpkey=b.corpkey  group by whDM";
			//查询所有的职工人数
			sql1="select substring(b.whDM,1,2) as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey  group by substring(b.whDM,1,2)";
			sql1_1="select b.whDM as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey  group by b.whDM";
			//职业病累计人数
			sql2="select substring(b.whDM,1,2) as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by substring(b.whDM,1,2)";
			sql2_1="select b.whDM as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by b.whDM";
			//危害人数
			sql3="select substring(b.whDM,1,2) as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by substring(b.whDM,1,2)";
			sql3_1="select b.whDM as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by b.whDM";
			//危害分类
			sql4="select substring(b.whDM,1,2) as ycode, 'nmg' as xcode, sum(CONVERT(int,a.jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by substring(b.whDM,1,2)";
			sql4_1="select b.whDM as ycode, 'nmg' as xcode, sum(CONVERT(int,a.jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by b.whDM";
			
			sql5="select substring(b.whDM,1,2) as ycode, 'ff' as xcode, sum(CONVERT(int,a.jchxren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by substring(b.whDM,1,2)";
			sql5_1="select b.whDM as ycode, 'ff' as xcode, sum(CONVERT(int,a.jchxren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by b.whDM";
			
			sql6="select substring(b.whDM,1,2) as ycode, 'gqtjrs' as xcode, sum(convert(int,a.jcwlren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by substring(b.whDM,1,2)";
			sql6_1="select b.whDM as ycode, 'gqtjrs' as xcode, sum(convert(int,a.jcwlren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by b.whDM";
			
			sql7="select substring(b.whDM,1,2) as ycode, 'gztjrs' as xcode,sum(convert(int,a.jcfsren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by substring(b.whDM,1,2)";
			sql7_1="select b.whDM as ycode, 'gztjrs' as xcode,sum(convert(int,a.jcfsren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by b.whDM";
			
			sql8="select substring(b.whDM,1,2) as ycode, 'lgtjrs' as xcode,sum(convert(int,a.jcqtren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by substring(b.whDM,1,2)";
			sql8_1="select b.whDM as ycode, 'lgtjrs' as xcode,sum(convert(int,a.jcqtren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by b.whDM";
			
//			查询所有的企业数
			sqltj="select 'hj' as ycode,'aa' as xcode,count(*) as sl from Z_cor a,Z_pxtj b  "+hql+" and a.corpkey=b.corpkey  ";
			
			sql1tj="select 'hj' as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			
			sql2tj="select 'hj' as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			sql3tj="select 'hj' as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			sql4tj="select 'hj' as ycode, 'nmg' as xcode, sum(CONVERT(int,a.jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			
			sql5tj="select 'hj' as ycode, 'ff' as xcode, sum(convert(int,a.jchxren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			
			sql6tj="select 'hj' as ycode, 'gqtjrs' as xcode, sum(convert(int,a.jcwlren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			sql7tj="select 'hj' as ycode, 'gztjrs' as xcode,sum(convert(int,a.jcfsren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			sql8tj="select 'hj' as ycode, 'lgtjrs' as xcode,sum(convert(int,a.jcqtren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			
			try {
				PtenudetailBean bean = new PtenudetailBean();
				String ysql=" where 1=1";
				if(null!=whys&&!"".equals(whys)&&!"null".equals(whys)){
					ysql+=" and enuitemvalue like '"+whys+"%'";
				}else{
					ysql+=" and len(ENUITEMVALUE)<3";
				}
				
				List listxs= bean.findByWhere(ysql+ " and enutype='WHYS' order by dispno");
				for(int i=0;i<listxs.size();i++){
					PtenudetailBean pb=(PtenudetailBean)listxs.get(i);
					ycode.add(pb.getEnuitemvalue());
					yname.add(pb.getEnuitemlabel());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//按企业规模对企业进行职业危害因素统计
		if(kind.equals("4444")){
				String min=Config.getProperty("qygmzbmin");
				if(null==min||"".equals(min)||"null".equals(min)){
					min="2000";
				}
				String max=Config.getProperty("qygmzbmax");
				if(null==max||"".equals(max)||"null".equals(max)){
					max="5000";
				}
				//查询所有的企业数
				sql="select chanzhi as ycode,'aa' as xcode,count(*) as sl from Z_cor a "+hql+" group by chanzhi";
				//查询所有的职工人数
				sql1="select chanzhi as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a "+hql+" group by chanzhi";
				//累计危害人数
				sql2="select chanzhi as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a "+hql+"  group by chanzhi";
				//危害人数
				sql3="select chanzhi as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a  "+hql+"  group by chanzhi";
				//危害分类
				//sql4="select chanzhi as ycode, 'nmg' as xcode, sum(CONVERT(int,jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by chanzhi";
				sql4="select chanzhi as ycode, 'nmg' as xcode, sum(convert(int,jcfcren)) as sl from Z_cor a "+hql+" group by chanzhi";
				sql5="select chanzhi as ycode, 'ff' as xcode, sum(convert(int,jchxren)) as sl from Z_cor a "+hql+" group by chanzhi";
			
				sql6="select chanzhi as ycode, 'gqtjrs' as xcode, sum(convert(int,jcwlren)) as sl from Z_cor a "+hql+" group by chanzhi";
				sql7="select chanzhi as ycode,	'gztjrs' as xcode,sum(convert(int,jcfsren)) as sl from Z_cor a "+hql+" group by chanzhi";
				sql8="select chanzhi as ycode,	'lgtjrs' as xcode,sum(convert(int,jcqtren)) as sl from Z_cor a "+hql+" group by chanzhi";
				
	//			查询所有的企业数
				sqltj="select 'hj' as ycode,'aa' as xcode,count(*) as sl from Z_cor a "+hql+" ";
				
				sql1tj="select 'hj' as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a "+hql+"";
				
				sql2tj="select 'hj' as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a "+hql+" ";
				sql3tj="select 'hj' as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a "+hql+" ";
				//sql4tj="select 'hj' as ycode, 'nmg' as xcode, sum(CONVERT(int,jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
				sql4tj="select 'hj' as ycode, 'nmg' as xcode, sum(convert(int,jcfcren)) as sl from Z_cor a "+hql+" ";
				sql5tj="select 'hj' as ycode, 'ff' as xcode, sum(convert(int,jchxren)) as sl from Z_cor a "+hql+" ";
				
				sql6tj="select 'hj' as ycode, 'gqtjrs' as xcode, sum(convert(int,jcwlren)) as sl from Z_cor a "+hql+" ";
				sql7tj="select 'hj' as ycode,	'gztjrs' as xcode,sum(convert(int,jcfsren)) as sl from Z_cor a "+hql+"";
				sql8tj="select 'hj' as ycode,	'lgtjrs' as xcode,sum(convert(int,jcqtren)) as sl from Z_cor a "+hql+"";
				try {
					//List listxs= Enumer.getPtenudetaillist("DISTCODE", " and enuitemvalue  like '3702%'");
					PtenudetailBean bean = new PtenudetailBean();
					String ysql=" where 1=1";
//					if(null!=discode&&!"".equals(discode)&&!"null".equals(discode)){
//						ysql+=" and enuitemvalue like '"+discode+"%'";
//					}else{
//						ysql+=" and enuitemvalue  like '3702%'";
//					}
					
					List listxs= bean.findByWhere(ysql+ " and enutype='QYGM' order by dispno");
					for(int i=0;i<listxs.size();i++){
						PtenudetailBean pb=(PtenudetailBean)listxs.get(i);
						ycode.add(pb.getEnuitemvalue());
						yname.add(pb.getEnuitemlabel());
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		if(kind.equals("5555")){
			
			//查询所有的企业数
			sql="select zclx as ycode,'aa' as xcode,count(*) as sl from Z_cor a "+hql+" group by zclx";
			//查询所有的职工人数
			sql1="select zclx as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a "+hql+" group by zclx";
			//累计危害人数
			sql2="select zclx as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a "+hql+"  group by zclx";
			//危害人数
			sql3="select zclx as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a  "+hql+"  group by zclx";
			//危害分类
			//sql4="select chanzhi as ycode, 'nmg' as xcode, sum(CONVERT(int,jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey group by chanzhi";
			sql4="select zclx as ycode, 'nmg' as xcode, sum(convert(int,jcfcren)) as sl from Z_cor a "+hql+" group by zclx";
			sql5="select zclx as ycode, 'ff' as xcode, sum(convert(int,jchxren)) as sl from Z_cor a "+hql+" group by zclx";
		
			sql6="select zclx as ycode, 'gqtjrs' as xcode, sum(convert(int,jcwlren)) as sl from Z_cor a "+hql+" group by zclx";
			sql7="select zclx as ycode,	'gztjrs' as xcode,sum(convert(int,jcfsren)) as sl from Z_cor a "+hql+" group by zclx";
			sql8="select zclx as ycode,	'lgtjrs' as xcode,sum(convert(int,jcqtren)) as sl from Z_cor a "+hql+" group by zclx";
			
//			查询所有的企业数
			sqltj="select 'hj' as ycode,'aa' as xcode,count(*) as sl from Z_cor a "+hql+" ";
			
			sql1tj="select 'hj' as ycode,'bb' as xcode,sum(CONVERT(int,nmzgrs)) as sl from Z_cor a "+hql+"";
			
			sql2tj="select 'hj' as ycode,'zrs' as xcode,sum(CONVERT(int,a.zybrenshu)) as sl from Z_cor a "+hql+" ";
			sql3tj="select 'hj' as ycode,'ng' as xcode,sum(CONVERT(int,a.whrenshu)) as sl from Z_cor a "+hql+" ";
			//sql4tj="select 'hj' as ycode, 'nmg' as xcode, sum(CONVERT(int,jcfcren)) as sl from Z_cor a,Z_pxtj b "+hql+" and a.corpkey=b.corpkey ";
			sql4tj="select 'hj' as ycode, 'nmg' as xcode, sum(convert(int,jcfcren)) as sl from Z_cor a "+hql+" ";
			sql5tj="select 'hj' as ycode, 'ff' as xcode, sum(convert(int,jchxren)) as sl from Z_cor a "+hql+" ";
			
			sql6tj="select 'hj' as ycode, 'gqtjrs' as xcode, sum(convert(int,jcwlren)) as sl from Z_cor a "+hql+" ";
			sql7tj="select 'hj' as ycode,	'gztjrs' as xcode,sum(convert(int,jcfsren)) as sl from Z_cor a "+hql+"";
			sql8tj="select 'hj' as ycode,	'lgtjrs' as xcode,sum(convert(int,jcqtren)) as sl from Z_cor a "+hql+"";
			try {
				//List listxs= Enumer.getPtenudetaillist("DISTCODE", " and enuitemvalue  like '3702%'");
				PtenudetailBean bean = new PtenudetailBean();
				String ysql=" where 1=1";
//				if(null!=discode&&!"".equals(discode)&&!"null".equals(discode)){
//					ysql+=" and enuitemvalue like '"+discode+"%'";
//				}else{
//					ysql+=" and enuitemvalue  like '3702%'";
//				}
				
				List listxs= bean.findByWhere(ysql+ " and enutype='ZCLX' order by dispno");
				for(int i=0;i<listxs.size();i++){
					PtenudetailBean pb=(PtenudetailBean)listxs.get(i);
					ycode.add(pb.getEnuitemvalue());
					yname.add(pb.getEnuitemlabel());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("sql:"+sql);
		System.out.println("sql1:"+sql1);
		System.out.println("sql2:"+sql2);
		System.out.println("sql3:"+sql3);
		System.out.println("sql4:"+sql4);
		System.out.println("sql5:"+sql5);
		System.out.println("sql6:"+sql6);
		System.out.println("sql7:"+sql7);
		System.out.println("sql8:"+sql8);
		System.out.println("sql:"+sqltj);
		System.out.println("sql1:"+sql1tj);
		System.out.println("sql2:"+sql2tj);
		System.out.println("sql3:"+sql3tj);
		System.out.println("sql4:"+sql4tj);
		System.out.println("sql5:"+sql5tj);
		System.out.println("sql6:"+sql6tj);
		System.out.println("sql7:"+sql7tj);
		System.out.println("sql8:"+sql8tj);
		List listTj=new ArrayList();
		listTj.add("hj");
		List listhj=new ArrayList();
		//企业统计
		List listxa=new ArrayList();
		listxa.add("aa");
		String [] sqls={sql_2,sql_1,sql};
		 lista = TjAction.getQhTjlist(listxa, ycode, sqls);
		 listhj=TjAction.getTjlist(listxa, listTj, sqltj);
		 if(null!=listhj&&null!=lista){
			 lista.addAll(listhj);
		 }
		 //人数
		 List listxb=new ArrayList();
		 listxb.add("bb");
		 String [] sql1s={sql1_2,sql1_1,sql1};
		 listb = TjAction.getQhTjlist(listxb, ycode, sql1s);
		 listhj=TjAction.getTjlist(listxb, listTj, sql1tj);
		 if(null!=listhj&&null!=listb){
			 listb.addAll(listhj);
		 }
		 //接触人数统计
		 List listxc=new ArrayList();
		 listxc.add("zrs");
		 String [] sql2s={sql2_2,sql2_1,sql2};
		 listc= TjAction.getQhTjlist(listxc, ycode, sql2s);
		 listhj=TjAction.getTjlist(listxc, listTj, sql2tj);
		 if(null!=listhj&&null!=listc){
			 listc.addAll(listhj);
		 }
		 
		 //接触人数女工统计
		 List listxd=new ArrayList();
		 listxd.add("ng");
		 String [] sql3s={sql3_2,sql3_1,sql3};
		 listd= TjAction.getQhTjlist(listxd, ycode, sql3s);
		 listhj=TjAction.getTjlist(listxd, listTj, sql3tj);
		 if(null!=listhj&&null!=listd){
			 listd.addAll(listhj);
		 }
		 //接触人数女工统计
		 List listxe=new ArrayList();
		 listxe.add("nmg");
		 String [] sql4s={sql4_2,sql4_1,sql4};
		 liste= TjAction.getQhTjlist(listxe, ycode, sql4s);
		 listhj=TjAction.getTjlist(listxe, listTj, sql4tj);
		 if(null!=listhj&&null!=liste){
			 liste.addAll(listhj);
		 }
		 //体检的企业
		 List listxf=new ArrayList();
		 listxf.add("ff");
		 String [] sql5s={sql5_2,sql5_1,sql5};
		 listf= TjAction.getQhTjlist(listxf, ycode, sql5s);
		 listhj=TjAction.getTjlist(listxf, listTj, sql5tj);
		 if(null!=listhj&&null!=listf){
			 listf.addAll(listhj);
		 }
		 //体检的岗前，岗中，离岗
		 List listxg=new ArrayList();
		 listxg.add("gqtjrs");
		 String [] sql6s={sql6_2,sql6_1,sql6};
		 listg= TjAction.getQhTjlist(listxg, ycode, sql6s);
		 listhj=TjAction.getTjlist(listxg, listTj, sql6tj);
		 if(null!=listhj&&null!=listg){
			 listg.addAll(listhj);
		 }
		 //
		 List listxh=new ArrayList();
		 listxh.add("gztjrs");
		 String [] sql7s={sql7_2,sql7_1,sql7};
		 listh= TjAction.getQhTjlist(listxh, ycode, sql7s);
		 listhj=TjAction.getTjlist(listxh, listTj, sql7tj);
		 if(null!=listhj&&null!=listh){
			 listh.addAll(listhj);
		 }
		 //
		 List listxj=new ArrayList();
		 listxj.add("lgtjrs");
		 String [] sql8s={sql8_2,sql8_1,sql8};
		 listj= TjAction.getQhTjlist(listxj, ycode, sql8s);
		 listhj=TjAction.getTjlist(listxj, listTj, sql8tj);
		 if(null!=listhj&&null!=listj){
			 listj.addAll(listhj);
			 
		 }
		 yname.add("合计：");
		 ycode.add("hj");
		if(kind.equals("3333")){
			return  MisConstant.FINDBYKEY;
		} else{
			return  MisConstant.FINDBYKEY;
		}
		
	}

	
	
	
	
	public String getDiscode() {
		return discode;
	}

	public void setDiscode(String discode) {
		this.discode = discode;
	}

	public String getHylb() {
		return hylb;
	}

	public void setHylb(String hylb) {
		this.hylb = hylb;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWhys() {
		return whys;
	}

	public void setWhys(String whys) {
		this.whys = whys;
	}

	public List getLista() {
		return lista;
	}

	public void setLista(List lista) {
		this.lista = lista;
	}

	public List getListb() {
		return listb;
	}

	public void setListb(List listb) {
		this.listb = listb;
	}

	public List getListc() {
		return listc;
	}

	public void setListc(List listc) {
		this.listc = listc;
	}

	public List getListd() {
		return listd;
	}

	public void setListd(List listd) {
		this.listd = listd;
	}

	public List getListe() {
		return liste;
	}

	public void setListe(List liste) {
		this.liste = liste;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List getXcode() {
		return xcode;
	}

	public void setXcode(List xcode) {
		this.xcode = xcode;
	}

	public List getXname() {
		return xname;
	}

	public void setXname(List xname) {
		this.xname = xname;
	}

	public List getYcode() {
		return ycode;
	}

	public void setYcode(List ycode) {
		this.ycode = ycode;
	}

	public List getYname() {
		return yname;
	}

	public void setYname(List yname) {
		this.yname = yname;
	}

	public List getListf() {
		return listf;
	}

	public void setListf(List listf) {
		this.listf = listf;
	}

	public List getListg() {
		return listg;
	}

	public void setListg(List listg) {
		this.listg = listg;
	}

	public List getListh() {
		return listh;
	}

	public void setListh(List listh) {
		this.listh = listh;
	}

	public List getListj() {
		return listj;
	}

	public void setListj(List listj) {
		this.listj = listj;
	}

}
