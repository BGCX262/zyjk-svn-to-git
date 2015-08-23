package synch.util;

import java.util.ArrayList;
import java.util.List;

import st.platform.utils.Config;
import synch.beans.CountBean;
import synch.beans.Process;
import synch.beans.Result;
import synch.dao.B_corBean;
import synch.dao.B_pxtjBean;
import synch.dao.B_scclBean;
import synch.dao.B_sccpBean;
import synch.dao.B_sczjBean;
import synch.dao.B_siteBean;
import synch.dao.B_whBean;
import synch.dao.T_corBean;
import synch.dao.T_pxtjBean;
import synch.dao.T_scclBean;
import synch.dao.T_sccpBean;
import synch.dao.T_sczjBean;
import synch.dao.T_siteBean;
import synch.dao.T_whBean;
import synch.dao.Z_corBean;
import synch.dao.Z_pxtjBean;
import synch.dao.Z_scclBean;
import synch.dao.Z_sccpBean;
import synch.dao.Z_sczjBean;
import synch.dao.Z_siteBean;
import synch.dao.Z_whBean;

public class SearchUtil {
	
	public static CountBean handle(String table,String sql){
		
		CountBean cb=new CountBean();
		boolean state=false;
		String[] params={"tb","col","whereStr","page","userpwd"};
		String userpwd=Config.getProperty("userpwd");
		Object[] oos={table+"_cor","",sql,"",userpwd};
		
		Result rs=BDownUtil.downBcor("cor", params, oos);
		 int pxtjCount=0;
			
		 int sccpCount=0;
		
		 int scclCount=0;
		
		 int sczjCount=0;
		
		 int siteCount=0;
		
		 int whCount=0;
		if(table.equals("B")){
			String xml=BDownUtil.resultHandle(rs);//处理第一批数据，并返回错误的xml格式
			Process pro=rs.getProcess();
			String number=pro.getNumber();
			int num=0;
			if(null!=number&&!"".equals(number)&&!"null".equals(number)){
				num=Integer.parseInt(number);
			}
			//System.out.println("备案数据开始下载--------");
			for(int i=0;i<=num;i++){
				//System.out.println("开始处理第"+i+"页数据");
				if(i>0){
					String[] oo={table+"_cor","",sql,i+"",userpwd};
					rs=BDownUtil.downBcor("cor", params, oo);
					xml=BDownUtil.resultHandle(rs);//处理第num批数据，并返回错误的xml格式
					String[] empams={"msgstr","userpwd"};
					String[] empoos={xml,userpwd};
					Result ers=BDownUtil.downBcor("msgstate", empams, empoos);
				}
			}
			
			/** 处理附属表 **/
			
			B_corBean bc=new B_corBean();
			List<B_corBean> list=new ArrayList<B_corBean>();
			
			
			try {
				list=bc.find(" where "+sql);
				cb.setCorCount(list.size()+"");
				for(int i=0;i<list.size();i++){
					B_corBean b=list.get(i);
					String fsql=" corpkey='"+b.getCorpkey()+"'";
					Object[] pxoos={table+"_pxtj","",fsql,"",userpwd};
					rs=BDownUtil.downBcor("cor", params, pxoos);
					xml=BDownUtil.resultHandle_of_B_pxtj(rs);
					B_pxtjBean bb=new B_pxtjBean();
					List<B_pxtjBean> bbs=bb.find(" where "+fsql);
					pxtjCount+=bbs.size();
					
					Object[] scoos={table+"_sccp","",fsql,"",userpwd};
					rs=BDownUtil.downBcor("cor", params, scoos);
					xml=BDownUtil.resultHandle_of_B_sccp(rs);
					B_sccpBean bs=new B_sccpBean();
					List<B_sccpBean> bss=bs.find(" where "+fsql);
					sccpCount+=bss.size();
					
					Object[] scloos={table+"_sccl","",fsql,"",userpwd};
					rs=BDownUtil.downBcor("cor", params, scloos);
					xml=BDownUtil.resultHandle_of_B_sccl(rs);
					B_scclBean bsl=new B_scclBean();
					List<B_scclBean> bsls=bsl.find(" where "+fsql);
					scclCount+=bsls.size();
					
					Object[] sczoos={table+"_sczj","",fsql,"",userpwd};
					rs=BDownUtil.downBcor("cor", params, sczoos);
					xml=BDownUtil.resultHandle_of_B_sczj(rs);
					B_sczjBean bsb=new B_sczjBean();
					List<B_sczjBean> bsbs=bsb.find(" where "+fsql);
					sczjCount+=bsbs.size();
					
					Object[] sioos={table+"_site","",fsql,"",userpwd};
					rs=BDownUtil.downBcor("cor", params, sioos);
					xml=BDownUtil.resultHandle_of_B_site(rs);
					B_siteBean bst=new B_siteBean();
					List<B_siteBean> bsts=bst.find(" where "+fsql);
					siteCount+=bsts.size();
					
					Object[] whoos={table+"_wh","",fsql,"",userpwd};
					rs=BDownUtil.downBcor("cor", params, whoos);
					xml=BDownUtil.resultHandle_of_B_wh(rs);
					B_whBean bw=new B_whBean();
					List<B_whBean> bws=bw.find(" where "+fsql);
					whCount+=bws.size();
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state=true;
		}else if(table.equals("Z")){
			String xml=DownUtil.resultHandle(rs);//处理第一批数据，并返回错误的xml格式
			Process pro=rs.getProcess();
			String number=pro.getNumber();
			int num=0;
			if(null!=number&&!"".equals(number)&&!"null".equals(number)){
				num=Integer.parseInt(number);
			}
			//System.out.println("备案数据开始下载--------");
			for(int i=0;i<=num;i++){
				//System.out.println("开始处理第"+i+"页数据");
				if(i>0){
					String[] oo={table+"_cor","",sql,i+"",userpwd};
					rs=DownUtil.downZcor("cor", params, oo);
					xml=DownUtil.resultHandle(rs);//处理第num批数据，并返回错误的xml格式
					String[] empams={"msgstr","userpwd"};
					String[] empoos={xml,userpwd};
					Result ers=DownUtil.downZcor("msgstate", empams, empoos);
				}
			}
	/** 处理附属表 **/
			
			Z_corBean bc=new Z_corBean();
			List<Z_corBean> list=new ArrayList<Z_corBean>();
			
			try {
				list=bc.find(" where "+sql);
				cb.setCorCount(list.size()+"");
				for(int i=0;i<list.size();i++){
					Z_corBean b=list.get(i);
					String fsql=" corpkey='"+b.getCorpkey()+"'";
					Object[] pxoos={table+"_pxtj","",fsql,"",userpwd};
					rs=DownUtil.downZcor("cor", params, pxoos);
					xml=DownUtil.resultHandle_of_Z_pxtj(rs);
					Z_pxtjBean bb=new Z_pxtjBean();
					List<Z_pxtjBean> bbs=bb.find(" where "+fsql);
					pxtjCount+=bbs.size();
					
					Object[] scoos={table+"_sccp","",fsql,"",userpwd};
					rs=DownUtil.downZcor("cor", params, scoos);
					xml=DownUtil.resultHandle_of_Z_sccp(rs);
					Z_sccpBean bs=new Z_sccpBean();
					List<Z_sccpBean> bss=bs.find(" where "+fsql);
					sccpCount+=bss.size();
					
					Object[] scloos={table+"_sccl","",fsql,"",userpwd};
					rs=DownUtil.downZcor("cor", params, scloos);
					xml=DownUtil.resultHandle_of_Z_sccl(rs);
					Z_scclBean bsl=new Z_scclBean();
					List<Z_scclBean> bsls=bsl.find(" where "+fsql);
					scclCount+=bsls.size();
					
					Object[] sczoos={table+"_sczj","",fsql,"",userpwd};
					rs=DownUtil.downZcor("cor", params, sczoos);
					xml=DownUtil.resultHandle_of_Z_sczj(rs);
					Z_sczjBean bsb=new Z_sczjBean();
					List<Z_sczjBean> bsbs=bsb.find(" where "+fsql);
					sczjCount+=bsbs.size();
					
					Object[] sioos={table+"_site","",fsql,"",userpwd};
					rs=DownUtil.downZcor("cor", params, sioos);
					xml=DownUtil.resultHandle_of_Z_site(rs);
					Z_siteBean bst=new Z_siteBean();
					List<Z_siteBean> bsts=bst.find(" where "+fsql);
					siteCount+=bsts.size();
					
					Object[] whoos={table+"_wh","",fsql,"",userpwd};
					rs=DownUtil.downZcor("cor", params, whoos);
					xml=DownUtil.resultHandle_of_Z_wh(rs);
					Z_whBean bw=new Z_whBean();
					List<Z_whBean> bws=bw.find(" where "+fsql);
					whCount+=bws.size();
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state=true;
		}else if(table.equals("T")){
			String xml=TDownUtil.resultHandle(rs);//处理第一批数据，并返回错误的xml格式
			Process pro=rs.getProcess();
			String number=pro.getNumber();
			int num=0;
			if(null!=number&&!"".equals(number)&&!"null".equals(number)){
				num=Integer.parseInt(number);
			}
			//System.out.println("备案数据开始下载--------");
			for(int i=0;i<=num;i++){
				//System.out.println("开始处理第"+i+"页数据");
				if(i>0){
					String[] oo={table+"_cor","",sql,i+"",userpwd};
					rs=TDownUtil.downTcor("cor", params, oo);
					xml=TDownUtil.resultHandle(rs);//处理第num批数据，并返回错误的xml格式
					String[] empams={"msgstr","userpwd"};
					String[] empoos={xml,userpwd};
					Result ers=TDownUtil.downTcor("msgstate", empams, empoos);
				}
			}
			/** 处理附属表 **/
			
			T_corBean bc=new T_corBean();
			List<T_corBean> list=new ArrayList<T_corBean>();
		
			try {
				list=bc.find(" where "+sql);
				cb.setCorCount(list.size()+"");
				for(int i=0;i<list.size();i++){
					T_corBean b=list.get(i);
					String fsql=" corpkey='"+b.getCorpkey()+"'";
					Object[] pxoos={table+"_pxtj","",fsql,"",userpwd};
					rs=TDownUtil.downTcor("cor", params, pxoos);
					xml=TDownUtil.resultHandle_of_T_pxtj(rs);
					T_pxtjBean bb=new T_pxtjBean();
					List<T_pxtjBean> bbs=bb.find(" where "+fsql);
					pxtjCount+=bbs.size();
					
					Object[] scoos={table+"_sccp","",fsql,"",userpwd};
					rs=TDownUtil.downTcor("cor", params, scoos);
					xml=TDownUtil.resultHandle_of_T_sccp(rs);
					T_sccpBean bs=new T_sccpBean();
					List<T_sccpBean> bss=bs.find(" where "+fsql);
					sccpCount+=bss.size();
					
					Object[] scloos={table+"_sccl","",fsql,"",userpwd};
					rs=TDownUtil.downTcor("cor", params, scloos);
					xml=TDownUtil.resultHandle_of_T_sccl(rs);
					T_scclBean bsl=new T_scclBean();
					List<T_scclBean> bsls=bsl.find(" where "+fsql);
					scclCount+=bsls.size();
					
					Object[] sczoos={table+"_sczj","",fsql,"",userpwd};
					rs=TDownUtil.downTcor("cor", params, sczoos);
					xml=TDownUtil.resultHandle_of_T_sczj(rs);
					T_sczjBean bsb=new T_sczjBean();
					List<T_sczjBean> bsbs=bsb.find(" where "+fsql);
					sczjCount+=bsbs.size();
					
					Object[] sioos={table+"_site","",fsql,"",userpwd};
					rs=TDownUtil.downTcor("cor", params, sioos);
					xml=TDownUtil.resultHandle_of_T_site(rs);
					T_siteBean bst=new T_siteBean();
					List<T_siteBean> bsts=bst.find(" where "+fsql);
					siteCount+=bsts.size();
					
					Object[] whoos={table+"_wh","",fsql,"",userpwd};
					rs=TDownUtil.downTcor("cor", params, whoos);
					xml=TDownUtil.resultHandle_of_T_wh(rs);
					T_whBean bw=new T_whBean();
					List<T_whBean> bws=bw.find(" where "+fsql);
					whCount+=bws.size();
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			state=true;
		}
		cb.setPxtjCount(pxtjCount+"");
		cb.setScclCount(scclCount+"");
		cb.setSccpCount(sccpCount+"");
		cb.setSczjCount(sczjCount+"");
		cb.setSiteCount(siteCount+"");
		cb.setWhCount(whCount+"");
		cb.setState(state);
		return cb;
	}
	

}
