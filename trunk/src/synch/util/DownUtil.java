package synch.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import st.platform.utils.Config;
import synch.beans.Element;
import synch.beans.Error;
import synch.beans.Process;
import synch.beans.Record;
import synch.beans.Result;
import synch.dao.Z_corBean;
import synch.dao.Z_pxtjBean;
import synch.dao.Z_scclBean;
import synch.dao.Z_sccpBean;
import synch.dao.Z_sczjBean;
import synch.dao.Z_siteBean;
import synch.dao.Z_whBean;

public class DownUtil {
	/**
	 * 想webservice发送请求
	 * @param method
	 * @param params
	 * @param oos
	 * @return
	 */
	public static Result downZcor(String method,String[] params ,Object[] oos){
		String code=Config.getProperty("serviceDiscode");
		//String result=WebService.service( method,params,oos);
		String result=WebService.xfireService( method,params,oos);
		Result rs=null;
		try{
			//System.out.println("result:"+result);
			rs= (Result)XmlToObject.xmlToOb(result);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return rs;
	}
	/**
	 * Z_cor将Result中得记录存入数据库
	 * @param rs
	 * @return
	 */
	public static String resultHandle(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("Z_cor", es);
			Z_corBean zb=(Z_corBean)oo;
			try {
				Z_corBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
	/**
	 * 对于Z_pxjg的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_Z_pxtj(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("Z_pxtj", es);
			Z_pxtjBean zb=(Z_pxtjBean)oo;
			try {
				Z_pxtjBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and whDM='"+zb.getWhdm()+"' and ID='"+zb.getId()+"' and jcrenshu='"+zb.getJcrenshu()+"'" +
						" and pxrenshu="+zb.getPxrenshu()+" and tjrenshu="+zb.getTjrenshu()+" and zybrenshu="+zb.getZybrenshu()+" and jcnongmin="+zb.getJcnongmin()+
						" and jcwomen="+zb.getJcwomen()+" and dlrenshu="+zb.getDlrenshu()+" and tjrenshu2="+zb.getTjrenshu2()+" and tjrenshu3="+zb.getTjrenshu3()+"");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and whDM='"+zb.getWhdm()+"' and ID='"+zb.getId()+"' and jcrenshu='"+zb.getJcrenshu()+"'" +
							" and pxrenshu="+zb.getPxrenshu()+" and tjrenshu="+zb.getTjrenshu()+" and zybrenshu="+zb.getZybrenshu()+" and jcnongmin="+zb.getJcnongmin()+
							" and jcwomen="+zb.getJcwomen()+" and dlrenshu="+zb.getDlrenshu()+" and tjrenshu2="+zb.getTjrenshu2()+" and tjrenshu3="+zb.getTjrenshu3()+"")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}

	/**
	 * 对于Z_sccp的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_Z_sccp(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("Z_sccp", es);
			Z_sccpBean zb=(Z_sccpBean)oo;
			try {
				Z_sccpBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
	/**
	 * 对于Z_sccl的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_Z_sccl(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("Z_sccl", es);
			Z_scclBean zb=(Z_scclBean)oo;
			try {
				Z_scclBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
	
	/**
	 * 对于Z_sczj的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_Z_sczj(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("Z_sczj", es);
			Z_sczjBean zb=(Z_sczjBean)oo;
			try {
				Z_sczjBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
	
	/**
	 * 对于Z_site的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_Z_site(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("Z_site", es);
			Z_siteBean zb=(Z_siteBean)oo;
			try {
				Z_siteBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
	/**
	 * 对于Z_wh的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_Z_wh(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("Z_wh", es);
			Z_whBean zb=(Z_whBean)oo;
			try {
				Z_whBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and whDM='"+zb.getWhdm()+"' and ID='"+zb.getId()+"'");
				if(null==cor){
					if(zb.insert()<1){
						errors.add(zb);
					};
				}else{
					if(zb.updateByWhere(" where corpkey='"+zb.getCorpkey()+"' and whDM='"+zb.getWhdm()+"' and ID='"+zb.getId()+"'")<1){
						errors.add(zb);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			////System.out.println("corkey====="+zb.getCorpkey());
		}
		//处理出现错误的数据
		String xml=Util.createErrorResult(errors, "", "");
		
		return xml;
	}
}
