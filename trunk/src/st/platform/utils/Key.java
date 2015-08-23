package st.platform.utils;

import java.io.PrintStream;

public class Key
{

    public Key()
    {
    }

    public static void main(String args[])
    {
        byte abyte0[] = "20070101".getBytes();
        for(int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (byte)((abyte0[i] * 2) / 3 + i + i / 2 + 40);
        }

        //System.out.println((new String(abyte0)).toLowerCase());
        Key key = new Key();
        key.createKey();
    }

    private String o00000()
    {
        byte abyte0[] = "20070101".getBytes();
        for(int i = 0; i < abyte0.length; i++)
        {
            abyte0[i] = (byte)((abyte0[i] * 2) / 3 + i + i / 2 + 40);
        }

        //return (new String(abyte0)).toLowerCase();
        return "ttt";
    }

    public void createKey()
    {
        String s = "\u7531\u76DB\u5929\u79D1\u6280\u6709\u9650\u8D23\u4EFB\u516C\u53F8\u5F00\u53D1\u7684" +
":"
 + Config.getProperty("project") + "\u9879\u76EE\u73B0\u6388\u4E88:" + Config.getProperty("copyright") + "\u7248\u6743.";
        char ac[] = s.toCharArray();
        String s1 = "";
        for(int i = 0; i < ac.length; i++)
        {
            s1 = s1 + Long.toHexString(ac[i]);
        }

        //System.out.println(s1);
        ac = s1.toCharArray();
        s1 = "";
        for(int j = 0; j < ac.length; j++)
        {
            s1 = s1 + (char)(ac[j] / 2 + j / 2);
        }

        ac = s1.toCharArray();
        s1 = "";
        for(int k = 0; k < ac.length; k++)
        {
            s1 = s1 + Long.toHexString(ac[k]);
        }

        ac = o00000().toCharArray();
        String s2 = "";
        for(int l = 0; l < ac.length; l++)
        {
            s2 = s2 + Long.toHexString(ac[l]);
        }

        String s3 = "";
        s3 = s1.substring(8, 12) + s2.substring(14, 16) + "-" + s1.substring(s1.length() / 2, s1.length() / 2 + 4) + s2.substring(6, 8) + s1.substring(s1.length() - 50, s1.length() - 44) + s2.substring(0, 2);
        s3 = s3 + "-" + s1.substring(99, 102) + s2.substring(10, 12) + s1.substring(s1.length() / 2 - 30, s1.length() / 2 - 25) + s2.substring(8, 10) + "-" + s1.substring(66, 71) + s2.substring(4, 7) + s1.substring(s1.length() / 3 + 2, s1.length() / 3 + 5) + s2.substring(12, 15);
        s3 = s3 + "-" + s1.substring(s1.length() / 4, s1.length() / 4 + 3) + s2.substring(2, 7) + s1.substring(s1.length() - 50, s1.length() - 47);
        //System.out.println(s3.toUpperCase());
    }
}
