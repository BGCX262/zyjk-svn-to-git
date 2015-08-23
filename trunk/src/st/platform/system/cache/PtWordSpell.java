
package st.platform.system.cache;

import java.util.*;
import st.platform.db.*;

public class PtWordSpell {
    private static Map types;



    static {
        init();
    }


    public static void main(String[] args) {
         PtWordSpell PtWord =  new PtWordSpell();
         System.out.println(PtWord.getChSpellS("重长南路（"));
    }


    /**
     *  得到枚举类型type的实例 可以访问每个枚举值
     *
     *@param  type
     *@return       zt.platform.form.config.EnumerationBean
     *@roseuid      3F7165A503D7
     */
    public static String getChSpell(String ChWord) {
        if(types.get(ChWord)==null)
            return "";
        else
            return (String)types.get(ChWord);
    }


     public static String getChSpellS(String ChWordS) {
           String spellStr="<root>";
           String SpellS  = "";
           String Spell   = "";
           String expSpell = "0";
           String polyCh   = "0";

        for(int i=0 ; i< ChWordS.length();i++){
            String ChWord= ChWordS.substring(i,i+1);
            Spell =  getChSpell(ChWord);
               if (Spell.equals("")){
                    expSpell = "1";
                    break;
               }

               if (PolyChWord.getChWord(ChWord))
                    polyCh ="1";

               SpellS += Spell;

        }
          spellStr += "<field spells=\""+SpellS.toUpperCase()+"\" exspell=\""+expSpell+"\" polych=\""+polyCh+"\" /></root>";
          return spellStr;
    }

    /**
     *  Description of the Method
     */
    public static void init() {

        types = new HashMap();
        ConnectionManager manager = ConnectionManager.getInstance();
        DatabaseConnection con = manager.get();

        String str = "select ChWord ,ChWordSpell from PtWordSpell";
        try
        {
            RecordSet rs = con.executeQuery(str);
    
            while (rs.next()) {
                String PolyChWord = rs.getString("ChWord");
                String enuDesc    = rs.getString("ChWordSpell");
    
                types.put(PolyChWord, enuDesc);
    
            }
            rs.close();
        }catch(Exception e)
         {
             e.printStackTrace();
         }

       
        manager.release();


    }
}
