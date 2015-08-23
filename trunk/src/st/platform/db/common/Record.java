package st.platform.db.common;

import java.util.List;
import java.util.ArrayList;


public class Record {
    private List fields;

    /**
     * @param records
     * @roseuid 3E5D82BD0332
     */
    public Record(java.util.List fields) {
        this.fields = fields;
    }

    /**
     * @roseuid 3E5D82A700F5
     */
    public Record() {
        fields = new ArrayList();
    }

    /**
     * @param idx
     * @return boolean
     * @roseuid 3E5D80E102D3
     */
    public void insert(int idx) {
        fields.add(idx,null);
    }

    /**
     * @param idx
     * @return boolean
     * @roseuid 3E5D80F6017F
     */
    public void delete(int idx) {
        fields.remove(idx);
    }

    /**
     * @param idx
     * @return Object
     * @roseuid 3E5D82640208
     */
    public Object get(int idx) {
        return fields.get(idx);
    }

    /**
     * @param idx
     * @param value
     * @roseuid 3E5D828F010F
     */
    public void set(int idx, Object value) {
        fields.set(idx,value);
    }
}
