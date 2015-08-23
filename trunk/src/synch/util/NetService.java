package synch.util;

public interface NetService {
	
	String Z_cor_ba(String dqid,String st,String et,String col,String page,String userpwd);//备案数据主表的下载接口
	
	String Z_cor_ba_of(String oftablename,String dqid,String st,String et,String colstr,String page,String userpwd);//备案数据附表数据的下载
	
	String Z_cor_dscba(String dqid,String st,String et,String col,String page,String userpwd);//Z表中待审查数据主表的下载接口
	
	String Z_cor_dscba_of(String oftablename,String dqid,String st,String et,String colstr,String page,String userpwd);//Z表中待审查数据附表数据的下载
	
	String Z_cor_wsb(String dqid,String st,String et,String col,String page,String userpwd);//Z表中未上报数据主表的下载接口
	
	String Z_cor_wsb_of(String oftablename,String dqid,String st,String et,String colstr,String page,String userpwd);//Z表中未上报数据附表数据的下载
	
	String T_cor_dscba(String dqid,String st,String et,String col,String page,String userpwd);//T表中待审查数据主表的下载接口
	
	String T_cor_dscba_of(String oftablename,String dqid,String st,String et,String colstr,String page,String userpwd);//T表中待审查数据附表数据的下载
	
	String T_cor_wsb(String dqid,String st,String et,String col,String page,String userpwd);//T表中未上报数据主表的下载接口
	
	String T_cor_wsb_of(String oftablename,String dqid,String st,String et,String colstr,String page,String userpwd);//T表中未上报数据附表数据的下载
	
	String Z_corStr(String col,String whereStr,String userpwd);
	
	String T_corStr(String col,String whereStr,String userpwd);
	
	String msgstate(String msgstr,String userpwd);//错误处理
	
	String helloword(String dqid,String userpwd);
	
	String test();
	
	String updatedb(String tablename,String xmlValue,String userpwd);//主表数据的上传
	
	String updatedbs(String xmlValue,String userpwd);//主表数据的上传

}
