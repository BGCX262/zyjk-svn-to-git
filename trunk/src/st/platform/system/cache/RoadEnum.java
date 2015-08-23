
package st.platform.system.cache;

import java.util.*;
import st.platform.db.*;

public class RoadEnum {
    private static Map types;

    static {
        init();
    }

    public static void main(String[] args) {
         System.out.print(getOneRoadName("2"));

    }

    /**
     *  得到枚举类型type的实例 可以访问每个枚举值
     *
     *@param  type
     *@return       zt.platform.form.config.EnumerationBean
     *@roseuid      3F7165A503D7
     */
    public static String getword(String ChWord) {
        if(types.get(ChWord)==null)
               return "";
          else
               return (String)types.get(ChWord);
    }

    public static String getRoadName ( String spellS ) {
         try {
              PolyChWord polyChWord = new PolyChWord () ;

              Iterator keys = types.keySet ().iterator () ;
              StringBuffer StrBuf = new StringBuffer () ;

              StrBuf.append ( "<table id='Road_dropDown' class=\"gridHead\"  width='100%' border='0'  cellspacing='1' cellpadding='1' >" ) ;

              while ( keys.hasNext () ) {
                   Object key = keys.next () ;

                   String keyStrS = ( String )key ;
                   String[] keyArr = keyStrS.split ( "," ) ;
                   String keyStr = keyArr[3] ;

                   if ( keyStr.length () >= spellS.length () ) {
                        if ( spellS.equals ( keyStr.substring ( 0 , spellS.length () ) ) ) {
                             StrBuf.append ( "<tr  onclick=\"TRloadClick(this)\" height='20' class=\"gridEvenRow\">" ) ;
                             String enumStr = ( String )types.get ( key ) ;

                             String[] keyArrName = enumStr.split(",");

                             StrBuf.append ( "<td attr=\"" + keyArr[2] + "\" citycode=\"" + keyArr[0] + "\" distcode=\"" + keyArr[1] + "\"  cityname=\"" + keyArrName[1] + "\" distname=\"" + keyArrName[2] + "\" >" + keyArrName[0] + "</td>" ) ;
                             StrBuf.append ( "</tr>" ) ;
                        }
                   }
              }

              StrBuf.append ( "</table>" ) ;

              return StrBuf.toString () ;
         } catch ( Exception e ) {
              e.printStackTrace () ;
         }
         return "" ;
    }
    /////输出路的一个中文名称

    public static String getOneRoadName(String roadCode) {

         String[] keyArr = new String[2];
         try{
          String enumStr ="";

          PolyChWord  polyChWord = new PolyChWord();

          Iterator keys=types.keySet().iterator();

          while(keys.hasNext()){
                Object key=keys.next();

                String keyStrS= (String) key;
                keyArr = keyStrS.split(",");
                String keyStr =keyArr[2];

                if(keyStr.length()== roadCode.length()){
                     if(roadCode.equals(keyStr)) {
                           enumStr = (String)types.get(key);
                           keyArr = enumStr.split(",");
                           break;
                     }
                }
           }


           return keyArr[0];
     }catch(Exception e){
          e.printStackTrace();
     }

     return "";
   }

    /**
     *  Description of the Method
     */
    public static void init() {

        types = new HashMap();


        ConnectionManager manager = ConnectionManager.getInstance();
        DatabaseConnection con = manager.get();
        try
        {
              String str = "select CityCode,DistCode,RoadCode,RoadSpell ,RoadName from PTRoad";
    
              RecordSet rs = con.executeQuery(str);
    
              while (rs.next()) {
                String PolyChWord = rs.getString("CityCode")+","+rs.getString("DistCode")+","+rs.getString("RoadCode")+","+rs.getString("RoadSpell");
                String enuDesc    = rs.getString("RoadName")+","+EnumerationType.getEnu("citycode",rs.getString("CityCode"))+","+EnumerationType.getEnu("distcode",rs.getString("DistCode"));
               
                types.put(PolyChWord, enuDesc);
              }
              rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        manager.release();
    }
}
