package synch.util;

public interface NetService {
	
	String Z_cor_ba(String dqid,String st,String et,String col,String page,String userpwd);//����������������ؽӿ�
	
	String Z_cor_ba_of(String oftablename,String dqid,String st,String et,String colstr,String page,String userpwd);//�������ݸ������ݵ�����
	
	String Z_cor_dscba(String dqid,String st,String et,String col,String page,String userpwd);//Z���д����������������ؽӿ�
	
	String Z_cor_dscba_of(String oftablename,String dqid,String st,String et,String colstr,String page,String userpwd);//Z���д�������ݸ������ݵ�����
	
	String Z_cor_wsb(String dqid,String st,String et,String col,String page,String userpwd);//Z����δ�ϱ�������������ؽӿ�
	
	String Z_cor_wsb_of(String oftablename,String dqid,String st,String et,String colstr,String page,String userpwd);//Z����δ�ϱ����ݸ������ݵ�����
	
	String T_cor_dscba(String dqid,String st,String et,String col,String page,String userpwd);//T���д����������������ؽӿ�
	
	String T_cor_dscba_of(String oftablename,String dqid,String st,String et,String colstr,String page,String userpwd);//T���д�������ݸ������ݵ�����
	
	String T_cor_wsb(String dqid,String st,String et,String col,String page,String userpwd);//T����δ�ϱ�������������ؽӿ�
	
	String T_cor_wsb_of(String oftablename,String dqid,String st,String et,String colstr,String page,String userpwd);//T����δ�ϱ����ݸ������ݵ�����
	
	String Z_corStr(String col,String whereStr,String userpwd);
	
	String T_corStr(String col,String whereStr,String userpwd);
	
	String msgstate(String msgstr,String userpwd);//������
	
	String helloword(String dqid,String userpwd);
	
	String test();
	
	String updatedb(String tablename,String xmlValue,String userpwd);//�������ݵ��ϴ�
	
	String updatedbs(String xmlValue,String userpwd);//�������ݵ��ϴ�

}
