package UI.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;
import st.system.dao.PtenudetailBean;


public class CommenUtil {
	
	public static String getYear(String date){
		String year="";
		if(date!=null){
			String[] strs=date.split("-");
			
			if(strs.length>1){
				year=strs[0];
			}
		}else{
			year="";
		}
		
		return year;
	}
	
	public static String getMonth(String date){
		String mon="";
		if(date!=null){
			String[] strs=date.split("-");
			
			if(strs.length>1){
				mon=strs[1];
			}
		}else{
			mon="";
		}
		return mon;
	}
	
	public static String getDay(String date){
		String day="";
		if(date!=null){
			String[] strs=date.split("-");
			
			if(strs.length>1){
				day=strs[2];
			}
		}else{
			day="";
		}
		return day;
	}
	
	public static String getValue(String type,String name){
		String value="";
		String sql="select ENUITEMVALUE from ptenudetail where ENUTYPE='"+type+"' and ENUITEMLABEL='"+name+"'";
		 ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		try {
			DatabaseConnection dcc = cmm.get();
			//RecordSet pst=dcc.executeQuery(sql);
			RecordSet rs=dcc.executeQuery(sql);
			while(rs.next()){
				value=rs.getString("ENUITEMVALUE");
			}
			//pst.close();
			//conn.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			cmm.release();
		}
		
		return value;
	}
	
	public static String getEnuName(String type,String value){
		String name="";
		String sql="select ENUITEMLABEL from ptenudetail where ENUTYPE='"+type+"' and ENUITEMVALUE='"+value+"'";
		 ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
		try {
			DatabaseConnection dcc = cmm.get();
			//RecordSet pst=dcc.executeQuery(sql);
			RecordSet rs=dcc.executeQuery(sql);
			while(rs.next()){
				name=rs.getString("ENUITEMLABEL");
			}
			//pst.close();
			//conn.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return name;
	}
	
	public static String getZycs(String value){
		String name="";
		String sql="select sysno from shbdwczzhybwhdzychs where zycsmc='"+value+"'";
		 ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
			try {
			DatabaseConnection dcc = cmm.get();
				//RecordSet pst=dcc.executeQuery(sql);
				RecordSet rs=dcc.executeQuery(sql);
			while(rs.next()){
				name=rs.getString("sysno");
			}
			//pst.close();
			//conn.close();
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			cmm.release();
		}
		return name;
	}
	
	 /**
     * ��clobת����String����
     * @param clob
     * @return
     * @throws SQLException
     * @throws IOException
     */
	public static String ClobToString(Clob clob) { 
		String reString = ""; 
		if(null!=clob){
			try {
				
				Reader is = clob.getCharacterStream();
			
				BufferedReader br = new BufferedReader(is); 
				String s = br.readLine(); 
				StringBuffer sb = new StringBuffer(); 
				while (s != null) {// ִ��ѭ�����ַ�ȫ��ȡ��ֵ��StringBuffer��StringBufferת��STRING 
				sb.append(s); 
				s = br.readLine(); 
				} 
				if (null != is){
					is.close();
				}
				if (null != br){
				      br.close();
				}
				reString = sb.toString(); 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// �õ��� 
		}
		
			
			return reString; 
	} 

	 /**
     * ��Blobת����String����
     * @param clob
     * @return
     * @throws SQLException
     * @throws IOException
     */
	public static String BlobToString(Blob blob) { 
		StringBuffer sb=new StringBuffer();
		byte[] data=null;
		if(null!=blob){
			try {
				BufferedReader bf=new BufferedReader(new InputStreamReader(blob.getBinaryStream()));
				String temp="";
				//
				while((temp=bf.readLine())!=null)
				{
					sb.append(temp);	
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// �õ��� 
		}
		
			
			return sb.toString(); 
	} 
	public static String numTurn(float num){
		java.text.DecimalFormat  df  =  new  java.text.DecimalFormat("#0.00%");  
		return ""+df.format(num);
	}
	
	public static String getCheckBox(String enumMain,String value,String name,String id){
		String str="";
		PtenudetailBean pt=new PtenudetailBean();
		try {
			List<PtenudetailBean> list=pt.findByWhere(" where ENUTYPE='"+enumMain+"'  order by dispno ");
			for(int i=0;i<list.size();i++){
				PtenudetailBean p=list.get(i);
				if(value.equals(p.getEnuitemvalue())){
					str+="<input type=\"checkbox\" name='"+name+"' id='"+id+"' value='"+p.getEnuitemvalue()+"' checked=\"checked\"/>"+p.getEnuitemlabel()+"&nbsp;&nbsp;&nbsp;";
				}else{
					str+="<input type=\"checkbox\" name='"+name+"' id='"+id+"' value='"+p.getEnuitemvalue()+"' />"+p.getEnuitemlabel()+"&nbsp;&nbsp;&nbsp;";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	/**
	 * 计算百分比
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static String getPercent(String num1,String num2){
		if(num1==null||num1.equals("")){
			num1="0";
		}
		if(num2==null||num2.equals("")){
			num2="0";
		}
		
		float percent=(float) 0.00000;
		if(num2.equals("0")){
			percent=(float) 0.00000;
		}else {
			percent=Float.parseFloat(num1)/Float.parseFloat(num2);
		}
		DecimalFormat format = new DecimalFormat("#0.00");
        
        String s = format.format(percent); 
        if(s.equals("0.00")){
        	s="";
        }
		return s;
	}
}
