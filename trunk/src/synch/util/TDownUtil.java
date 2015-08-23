package synch.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import st.platform.utils.Config;
import synch.beans.Element;
import synch.beans.Record;
import synch.beans.Result;
import synch.dao.T_corBean;
import synch.dao.T_pxtjBean;
import synch.dao.T_scclBean;
import synch.dao.T_sccpBean;
import synch.dao.T_sczjBean;
import synch.dao.T_siteBean;
import synch.dao.T_whBean;
import synch.dao.Z_pxtjBean;

public class TDownUtil {
	/**
	 * 想webservice发送请求
	 * @param method
	 * @param params
	 * @param oos
	 * @return
	 */
	public static Result downTcor(String method,String[] params ,Object[] oos){
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
	 * T_cor将Result中得记录存入数据库
	 * @param rs
	 * @return
	 */
	public static String resultHandle(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("T_cor", es);
			T_corBean zb=(T_corBean)oo;
			try {
				T_corBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"'");
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
	 * 对于T_pxjg的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_T_pxtj(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("T_pxtj", es);
			T_pxtjBean zb=(T_pxtjBean)oo;
			try {
				T_pxtjBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and whDM='"+zb.getWhdm()+"' and ID='"+zb.getId()+"' and jcrenshu='"+zb.getJcrenshu()+"'" +
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
	 * 对于T_sccp的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_T_sccp(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("T_sccp", es);
			T_sccpBean zb=(T_sccpBean)oo;
			try {
				T_sccpBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'");
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
	 * 对于T_sccl的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_T_sccl(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("T_sccl", es);
			T_scclBean zb=(T_scclBean)oo;
			try {
				T_scclBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'");
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
	 * 对于T_sczj的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_T_sczj(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("T_sczj", es);
			T_sczjBean zb=(T_sczjBean)oo;
			try {
				T_sczjBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'");
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
	 * 对于T_site的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_T_site(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("T_site", es);
			T_siteBean zb=(T_siteBean)oo;
			try {
				T_siteBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and ID='"+zb.getId()+"'");
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
	 * 对于T_wh的下载
	 * @param rs
	 * @return
	 */
	public static String resultHandle_of_T_wh(Result rs){
		List<Record> list=rs.getRecords();
		List errors=new ArrayList();
		for(int i=0;i<list.size();i++){
			Record r=list.get(i);
			List<Element> es=r.getElements();
			Object oo=Reflect.creatObject("T_wh", es);
			T_whBean zb=(T_whBean)oo;
			try {
				T_whBean cor=zb.findFirst(" where corpkey='"+zb.getCorpkey()+"' and whDM='"+zb.getWhdm()+"' and ID='"+zb.getId()+"'");
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
