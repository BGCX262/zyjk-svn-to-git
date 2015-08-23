/*********************************************************************
 *<p>处理内容:时间工具类</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package UI.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class BusinessDate {
    @SuppressWarnings("unused")
    private static String toDay = "2004-3-11";

    public BusinessDate() {
    }

    static {
        toDay = (new Date()).toString();
    }

    public static String getNowDay() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Calendar cl = new GregorianCalendar();
        try {
            // return sdf.format(CMCodeManager.getDate("KEY_D1_1_1")) ;
            return sdf.format(cl.getTime());
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getSubtrationMon(int num) {
        Date d = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        gc.setTime(d);
        gc.add(3, num);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));
        return sf.format(gc.getTime()).substring(5, 7);
    }

    public static String getSubtrationDay(int num) {
        Date d = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        gc.setTime(d);
        gc.add(5, num);
        gc.set(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), gc.get(Calendar.DATE));

        return sf.format(gc.getTime());

    }

    public static String getToday() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        Calendar cl = new GregorianCalendar();
        try {
            // return sdf.format(CMCodeManager.getDate("KEY_D1_1_1")) ;
            return sdf.format(cl.getTime());
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getTodaytime() {
        Calendar cl = new GregorianCalendar();
        return getToday() + " " + cl.get(Calendar.HOUR_OF_DAY) + ":" + cl.get(Calendar.MINUTE) + ":"
                        + cl.get(Calendar.SECOND) + " ";
    }

    public static String getTodaytime(String bussDate) {
        Calendar cl = new GregorianCalendar();
        return bussDate + " " + cl.get(Calendar.HOUR_OF_DAY) + ":" + cl.get(Calendar.MINUTE) + ":"
                        + cl.get(Calendar.SECOND) + " ";
    }

    public static String getTime() {
        Calendar cl = new GregorianCalendar();
        return cl.get(Calendar.HOUR_OF_DAY) + ":" + cl.get(Calendar.MINUTE) + ":" + cl.get(Calendar.SECOND) + " ";
    }

    public static int gethour() {
        Calendar cl = new GregorianCalendar();
        return cl.get(Calendar.HOUR_OF_DAY);
    }

    public static String getNoFormatToday() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMdd");
        Calendar cl = new GregorianCalendar();
        try {
            // return sdf.format(CMCodeManager.getDate("KEY_D1_1_1")) ;
            return sdf.format(cl.getTime());
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getNoFormatTime() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HHmmss");
        Calendar cl = new GregorianCalendar();
        try {

            return sdf.format(cl.getTime());
        } catch (Exception ex) {
            return null;
        }

        // Calendar cl = new GregorianCalendar();
        // return
        // cl.get(Calendar.HOUR_OF_DAY)+""+cl.get(Calendar.MINUTE)+""+cl.get(Calendar.SECOND)+"";

    }

    public static String getYear() {
        // return CMCodeManager.getString("KEY_D1_1_1").substring(0,4);
        return BusinessDate.getNowDay().substring(0, 4);
    }

    public static String getMonth() {
        return BusinessDate.getNowDay().substring(5, 7);
    }

    public static String getDay() {
        return BusinessDate.getNowDay().substring(8, 10);
    }

    public static String getYesterday() throws Exception {
        String strYesterday = "";
        Calendar cale = null;
        try {
            // cale = CMCodeManager.getCalendar("KEY_D1_1_1");
            cale = new GregorianCalendar();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        cale.add(Calendar.DATE, -1);
        strYesterday = BusinessDate.getStrByCalendar(cale);
        return strYesterday;
    }

    public static String getFirstDayOfMonth() {
        Calendar cale = null;
        try {
            cale = new GregorianCalendar();
            cale.set(Calendar.DATE, 1);
        } catch (Exception ex) {
        }

        return getStrByCalendar(cale);
    }

    public static String getLastDayOfMonth() {
        Calendar cale = null;
        try {
            cale = new GregorianCalendar();
            cale.add(Calendar.MONTH, 1);
            cale.set(Calendar.DATE, 1);
            cale.add(Calendar.DATE, -1);
        } catch (Exception ex) {
        }

        return getStrByCalendar(cale);
    }

    public static String getStrByCalendar(Calendar cale) {
        return (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(cale.getTime());
    }

    public static String getChnDateString(String sDate) {
        if (sDate == null)
            return null;
        sDate = sDate.trim();
        if (sDate.length() == 7) {
            sDate += "-01";
        }
        StringTokenizer st = new StringTokenizer(sDate, "-");
        int year = 2100;
        int month = 0;
        int day = 1;
        try {
            year = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken()) - 1;
            day = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            return "";
        }
        Calendar cl = new GregorianCalendar(year, month, day);
        return cl.get(Calendar.YEAR) + "年" + cl.get(Calendar.MONTH) + "月" + cl.get(Calendar.DATE) + "日";
    }

    public static String getChnDayString(String sDate) {
        if (sDate == null)
            return null;
        sDate = sDate.trim();
        if (sDate.length() == 7) {
            sDate += "-01";
        }
        StringTokenizer st = new StringTokenizer(sDate, "-");
        int year = 2100;
        int month = 0;
        int day = 1;
        try {
            year = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken()) - 1;
            day = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            return "";
        }
        Calendar cl = new GregorianCalendar(year, month, day);
        return cl.get(Calendar.DATE) + "日";
    }

    public static String getDateStringAfterAddMonth(String sDate, int addMonth) {
        if (sDate == null)
            return null;
        sDate = sDate.trim();
        if (sDate.length() == 7) {
            sDate += "-01";
        }
        StringTokenizer st = new StringTokenizer(sDate, "-");
        int year = 2100;
        int month = 0;
        int day = 1;
        try {
            year = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken()) - 1;
            day = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            return "";
        }
        Calendar cl = new GregorianCalendar(year, month, day);
        cl.add(Calendar.MONTH, addMonth);
        cl.add(Calendar.DATE, -1);
        return getStrByCalendar(cl);
    }

    public static String getYear(String sDate) {

        // System.out.println(" __________ "+sDate);
        if (sDate == null)
            return null;
        sDate = sDate.trim();
        if (sDate.length() == 7) {
            sDate += "-01";
        }
        StringTokenizer st = new StringTokenizer(sDate, "-");
        int year = 2100;
        int month = 0;
        int day = 1;
        try {
            year = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken()) - 1;
            day = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            return getYear();
        }
        Calendar cl = new GregorianCalendar(year, month, day);

        // System.out.println(getYear());
        return cl.get(Calendar.YEAR) + "";
    }

    public static String getMon(String sDate) {
        if (sDate == null)
            return null;
        sDate = sDate.trim();
        if (sDate.length() == 7) {
            sDate += "-01";
        }
        StringTokenizer st = new StringTokenizer(sDate, "-");
        int year = 2100;
        int month = 0;
        int day = 1;
        try {
            year = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            day = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            return getMonth();
        }
        Calendar cl = new GregorianCalendar(year, month, day);
        String tmp = cl.get(Calendar.MONTH) + "";
        if (tmp.length() < 2) {
            if (tmp.equals("0")) {
                tmp = "12";
            } else {
                tmp = "0" + tmp;
            }
        }
        return tmp;
    }

    public static String getDay(String sDate) {
        if (sDate == null)
            return null;
        sDate = sDate.trim();
        if (sDate.length() == 7) {
            sDate += "-01";
        }
        StringTokenizer st = new StringTokenizer(sDate, "-");
        int year = 2100;
        int month = 0;
        int day = 1;
        try {
            year = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken()) - 1;
            day = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            return "";
        }
        Calendar cl = new GregorianCalendar(year, month, day);
        String tmp = cl.get(Calendar.DATE) + "";
        if (tmp.length() < 2) {
            tmp = "0" + tmp;
        }
        return tmp;
    }

    public static String getHour(String time) {
        if (time == null) {
            return time;
        }
        String st[] = time.split(":");
        if (st.length > 0) {
            return st[0];
        }
        return "";
    }

    public static String getSend(String time) {

        if (time == null) {
            return time;
        }
        String st[] = time.split(":");
        if (st.length > 1) {
            return st[1];
        }
        return "";
    }

    public static String getChnDateString1(String sDate) {
        if (sDate == null)
            return null;
        sDate = sDate.trim();
        if (sDate.length() == 7) {
            sDate += "-01";
        }
        StringTokenizer st = new StringTokenizer(sDate, "-");
        int year = 2100;
        int month = 0;
        int day = 1;
        try {
            year = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken()) - 1;
            day = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            return "";
        }
        Calendar cl = new GregorianCalendar(year, month, day);
        return cl.get(Calendar.YEAR) + "年" + (cl.get(Calendar.MONTH) + 1) + "月" + cl.get(Calendar.DATE) + "日";
    }

    public static String MonthAdd(int days, String nowdata) throws Exception {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date cc = form.parse(nowdata);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cc);

        int day = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, day + days);

        return form.format(calendar.getTime());
    }
    
    //季度
    public static String getQuarter(String month){
        if (null==month||month.length()==0||month.length()>2) {
            return "";
        }
        String quarter="";
        if (month.length()==1) {
            month="0"+month;
        }
        try {
            int monthInt=Integer.parseInt(month);
            if (monthInt>=1&&monthInt<=3) {
                quarter="1";
            }else if (monthInt>=4&&monthInt<=6) {
                quarter="2";
            }else if (monthInt>=7&&monthInt<=9) {
                quarter="3";
            }else if (monthInt>=10&&monthInt<=12) {
                quarter="4";
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return quarter;
    }
    //季度阿拉伯数字转为大写
    public static String quarterFormat(String quarter){
        String formatQ="";
        String[] qua={"一","二","三","四"};
        try {
            if (null==quarter||quarter.length()==0||quarter.length()>1) {
                return formatQ;
            }
            int quarterInt=Integer.parseInt(quarter);
            formatQ=qua[quarterInt-1];
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return formatQ;
    }
    
    public static void main(String[] ar) throws Exception {
        // System.out.println(BusinessDate.MonthAdd(4, "2008-03-10"));
    }
}
