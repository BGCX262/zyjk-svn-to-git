package st.platform.db.common;

import st.platform.common.*;


public class RecordMetaData {
    private String name;
    private String typeName;
    private int type;
    private String caption;
    private int seqno;

    /**
     *
     *
     * @param name 字段的名字
     * @param typeName 字段类型的名字
     * @param type 字段的类型
     * @param caption 字段标题/注释
     * @roseuid 3E5D81390135
     */
    public RecordMetaData(String name, String typeName, String caption,int seqno) {
        this.name     = name;
        this.typeName = typeName;
        this.seqno    = seqno;

        if ( typeName.equals(MetaDataTypes.STRING) )
            this.type = MetaDataTypes.STRING_TP;
        else if ( typeName.equals(MetaDataTypes.BIGDECIMAL) )
            this.type = MetaDataTypes.BIGDECIMAL_TP;
        else if ( typeName.equals(MetaDataTypes.CALENDAR) )
            this.type = MetaDataTypes.CALENDAR_TP;
        else if ( typeName.equals(MetaDataTypes.BIGINTEGER) )
            this.type = MetaDataTypes.BIGINTEGER_TP;
        else if ( typeName.equals(MetaDataTypes.BOOLEAN) )
            this.type = MetaDataTypes.BOOLEAN_TP;
        else if ( typeName.equals(MetaDataTypes.BYTE) )
            this.type = MetaDataTypes.BYTE_TP;
        else if ( typeName.equals(MetaDataTypes.CHARACTER) )
            this.type = MetaDataTypes.CHARACTER_TP;
        else if ( typeName.equals(MetaDataTypes.DOUBLE) )
            this.type = MetaDataTypes.DOUBLE_TP;
        else if ( typeName.equals(MetaDataTypes.FLOAT) )
            this.type = MetaDataTypes.FLOAT_TP;
        else if ( typeName.equals(MetaDataTypes.INTEGER) )
            this.type = MetaDataTypes.INTEGER_TP;
        else if ( typeName.equals(MetaDataTypes.LONG) )
            this.type = MetaDataTypes.LONG_TP;
        else if ( typeName.equals(MetaDataTypes.SHORT) )
            this.type = MetaDataTypes.SHORT_TP;
        else if ( typeName.equals(MetaDataTypes.TIMESTAMP) )
            this.type = MetaDataTypes.TIMESTAMP_TP;
        else
            this.type = -1;
        this.caption  = caption;
    }

    /**
     * @roseuid 3E5D8128039E
     */
    public RecordMetaData() {

    }

    /**
     * @return String
     * @roseuid 3E5D816A02F8
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     * @roseuid 3E5D81760223
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String
     * @roseuid 3E5D81870372
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName
     * @roseuid 3E5D8192036E
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * @return int
     * @roseuid 3E5D819F018C
     */
    public int getType() {
        return type;
    }

    /**
     * @param type
     * @roseuid 3E5D81AC00EB
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return String
     * @roseuid 3E5D81B700A0
     */
    public String getCaption() {
        return caption;
    }
    public static String[]   raoluan4()
  	{  		
	    
    	String[]  keyS = new String[2];
    	
    	String[]  keyS3 = XMLConfig.raoluan3();
    	
    	keyS[0] = keyS3[0] + "-9"+ Keycode.projectKey.substring(99,102)+ Keycode.dateKey.substring(10,12) + Keycode.projectKey.substring(Keycode.projectKey.length()/2-30,Keycode.projectKey.length()/2-25)+ Keycode.dateKey.substring(8,10);
    	keyS[1] = keyS3[1] + "-3"+ Keycode.projectKey.substring(99,102)+ Keycode.dateKey.substring(10,12) + Keycode.projectKey.substring(Keycode.projectKey.length()/2-30,Keycode.projectKey.length()/2-25)+ Keycode.dateKey.substring(8,10);
 	    
    	return keyS;
  			
  	}
    /**
     * @param caption
     * @roseuid 3E5D81BF037D
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public void setSeqno(int seqno) {
        this.seqno = seqno;
    }
    public int getSeqno() {
        return seqno;
    }
}
