package UI.action.tj;

import java.util.ArrayList;
import java.util.List;
import st.platform.control.business.Action;
import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.RecordSet;

public class TjAction extends Action {

    private static final long serialVersionUID = 1L;
    private static final String NOT_DATA_INFO = "�������";

    /** �÷�������ȡ��ͳ���б?listxָ������룬sqlָͳ��sql��sql��ִ�н��Ӧ����sl��xcode */

    public static List<TjBean> getTjlist(List<String> listx, String sql) throws Exception {

        List<TjBean> list = new ArrayList<TjBean>();
        ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
        DatabaseConnection dcc = cmm.get();
        try {
            RecordSet rs = dcc.executeQuery(sql);// ����sqlִ�н����xcode�������,sl��

            if (rs == null || !rs.next()) { // ��ݿ���û�д˼�¼
                for (int i = 0; i < listx.size(); i++) {
                    TjBean bean = new TjBean();
                    // bean.setSl("0");
                    list.add(i, bean);
                }
                return list;
            }
            rs.beforeFirst();
            for (int i = 0; i < listx.size(); i++) {
                TjBean bean = new TjBean();
                // bean.setSl("0");
                list.add(bean);

            }
            while (rs.next()) {
                TjBean bean = new TjBean();
                bean.setXcode(rs.getString("xcode"));
                bean.setSl(rs.getString("sl"));
                for (int i = 0; i < listx.size(); i++) {

                    if (rs.getString("xcode").equals(listx.get(i))) {
                        list.remove(i);
                        list.add(i, bean);
                        break;
                    }

                }
            }
            rs.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            cmm.release();
        }
        return list;

    }

    /**
     * �÷�������ȡ��ͳ���б?listxָ������룬listyָ�������,sqlָͳ��sql�� sql��ִ�н��Ӧ����sl��xcode��ycode
     */
    @SuppressWarnings("unchecked")
    public static List getTjlist(List listx, List listy, String sql) {
        List<TjBean> list = new ArrayList<TjBean>();// ����ͳ���б�
        List listlist = new ArrayList();// ����ͳ���б���list����ʽ���

        String ycode = "";// ��ʱ���յ����������
        int i = 0;
        ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
        try {
            DatabaseConnection dcc = cmm.get();
            RecordSet rs = dcc.executeQuery(sql);// ����sqlִ�н����xcode������룬ycode�������,sl��,
          //  System.out.println("sql+++++++++++++++++++++++++"+sql);
            if (rs == null) { // ��ݿ����м�¼����δȡ��
                // setError(YjzhMsgMisc.SELECT_RESULT_NULL);
                return null;
            } else if (!rs.next()) { // ��ݿ���û�д˼�¼
                // setError(NOT_DATA_INFO);
                return null;

            }
            rs.beforeFirst();
            while (rs.next()) {

                TjBean bean = new TjBean();// ����ÿ��ͳ�Ƽ�¼
                bean.setXcode(rs.getString("xcode"));// �������ʹ���
                bean.setYcode(rs.getString("ycode"));
                bean.setSl(rs.getString("sl"));
                list.add(i, bean);
                i++;
            }

            for (i = 0; i < listy.size(); i++) {

                ycode = (String) listy.get(i);
                List<TjBean> listls = new ArrayList<TjBean>();
                TjBean beanold = new TjBean();
                beanold.setYcode(ycode);
                for (int k = 0; k < listx.size(); k++) {
                    beanold = new TjBean();
                    beanold.setSl("");
                    listls.add(beanold);
                }

                for (int j = 0; j < list.size(); j++) {

                    if (ycode.equals(list.get(j).getYcode())) {
                        TjBean newbean = new TjBean();

                        for (int m = 0; m < listx.size(); m++) {

                            if (listx.get(m).equals(list.get(j).getXcode())) {
                                newbean.setSl(list.get(j).getSl());
                                newbean.setXcode(list.get(j).getXcode());
                                newbean.setYcode(list.get(j).getYcode());
                                listls.remove(m);
                                listls.add(m, newbean);
                                break;

                            }
                        }

                    }

                }
                listlist.add(i, listls);

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("......................");
            // TODO: handle exception
        } finally {
            cmm.release();
        }
        return listlist;
    }

    /**
     * �÷�������ȡ��ͳ���б?listxָ������룬listyָ�������,sqlָͳ��sql�� sql��ִ�н��Ӧ����sl��xcode��ycode
     */
    @SuppressWarnings("unchecked")
    public static List getQhTjlist(List listx, List listy, String sqls[]) throws Exception {
        List<TjBean> list = new ArrayList<TjBean>();// ����ͳ���б�
        List listlist = new ArrayList();// ����ͳ���б���list����ʽ���

        String ycode = "";// ��ʱ���յ����������
        int i = 0;
        ConnectionManager cmm = st.platform.db.ConnectionManager.getInstance();
        DatabaseConnection dcc = cmm.get();
        try {
            RecordSet rs = null;

            for (int k = 0; k < sqls.length; k++) {

                rs = dcc.executeQuery(sqls[k]);// ����sqlִ�н����xcode������룬ycode�������,sl��,
                if (rs == null) { // ��ݿ����м�¼����δȡ��
                    // setError(YjzhMsgMisc.SELECT_RESULT_NULL);
                    continue;
                }
                rs.beforeFirst();
                while (rs.next()) {

                    TjBean bean = new TjBean();// ����ÿ��ͳ�Ƽ�¼
                    bean.setXcode(rs.getString("xcode"));// �������ʹ���
                    bean.setYcode(rs.getString("ycode"));
                    bean.setSl(rs.getString("sl"));
                    list.add(i, bean);
                    i++;
                }
            }

            for (i = 0; i < listy.size(); i++) {

                ycode = (String) listy.get(i);
                List<TjBean> listls = new ArrayList<TjBean>();
                TjBean beanold = new TjBean();
                beanold.setYcode(ycode);
                for (int k = 0; k < listx.size(); k++) {
                    beanold = new TjBean();
                    beanold.setSl("");
                    listls.add(beanold);
                }

                for (int j = 0; j < list.size(); j++) {

                    if (ycode.equals(list.get(j).getYcode())) {
                        TjBean newbean = new TjBean();

                        for (int m = 0; m < listx.size(); m++) {

                            if (listx.get(m).equals(list.get(j).getXcode())) {
                                newbean.setSl(list.get(j).getSl());
                                newbean.setXcode(list.get(j).getXcode());
                                newbean.setYcode(list.get(j).getYcode());
                                listls.remove(m);
                                listls.add(m, newbean);
                                break;

                            }
                        }

                    }

                }
                listlist.add(i, listls);

            }
            rs.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            cmm.release();
        }
        return listlist;
    }

}
