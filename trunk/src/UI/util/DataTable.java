package UI.util;

import java.util.HashMap;
import java.util.Map;

public class DataTable {
	private Integer[][] rec;//数据
    private String[] colMeta;//列枚举值
    private String[] rowMeta;//行头枚举值
    private String[] colMetaCaption;//列头标题
    private String[] rowMetaCaption;//行头标题
	private Map colIdx = new HashMap();//列值-索引
	private Map rowIdx = new HashMap();//行值-索引
	
	private int sumColIdx = 0;//小计列 索引
	private int sumRowIdx = 0;//总计行 索引

	private int rows;//总行数
	private int cols;//总列数
	
	private Map otherValue = new HashMap();
	

	public DataTable(int rows,int cols) {
		rows += 1;
		cols += 1;
		rec = new Integer[rows][cols];
		for ( int i = 0 ; i < rows ; i++ ) {
			for ( int j = 0 ; j < cols ; j++ ) {
				rec[i][j] = new Integer(0);
			}
		}
	    colMeta = new String[cols];
	    rowMeta = new String[rows];
	    colMetaCaption = new String[cols];
	    rowMetaCaption = new String[rows];
	    colMetaCaption[sumColIdx] = "小计";
	    rowMetaCaption[sumRowIdx] = "合计";
	    colMeta[sumColIdx] = "";
	    rowMeta[sumRowIdx] = "";
	    this.rows = rows;
	    this.cols = cols;
	}
    public void setSumRowMetaCaption(String caption) {
    	this.rowMetaCaption[sumRowIdx] = caption;
    }
    public void setSumColMetaCaption(String caption) {
    	this.colMetaCaption[sumColIdx] = caption;
    }
	public boolean setCellValue(String rowKey,String colKey,int value) {
        if ( rowIdx.get(rowKey) == null || colIdx.get(colKey) == null ) {
        	return false;
        }
		int row = ((Integer)rowIdx.get(rowKey)).intValue();
		int col = ((Integer)colIdx.get(colKey)).intValue();
		int oldValue = rec[row][col] ;
		rec[row][col] = new Integer(value);
		
		
		rec[row][sumColIdx] = new Integer(rec[row][sumColIdx].intValue()+value-oldValue);
		rec[sumRowIdx][col] = new Integer(rec[sumRowIdx][col].intValue()+value-oldValue);  
		rec[sumRowIdx][sumColIdx] = new Integer(rec[sumRowIdx][sumColIdx].intValue()+value-oldValue); 
		return true;
	}
	
	public boolean setCellValue(String rowKey,String colKey,int value,boolean isAddRow,boolean isAddCol ) {
        if ( rowIdx.get(rowKey) == null || colIdx.get(colKey) == null ) {
        	return false;
        }
		int row = ((Integer)rowIdx.get(rowKey)).intValue();
		int col = ((Integer)colIdx.get(colKey)).intValue();
		int oldValue = rec[row][col] ;
		rec[row][col] = new Integer(value);
		
		if ( isAddRow )//行要合计
			rec[row][sumColIdx] = new Integer(rec[row][sumColIdx].intValue()+value-oldValue);
		if ( isAddCol )//列要合计
			rec[sumRowIdx][col] = new Integer(rec[sumRowIdx][col].intValue()+value-oldValue);  
		
		return true;
	}
	public boolean addCellValue(String rowKey,String colKey,int value,boolean isAddRow,boolean isAddCol) {
        if ( rowIdx.get(rowKey) == null || colIdx.get(colKey) == null ) {
        	return false;
        }
		int row = ((Integer)rowIdx.get(rowKey)).intValue();
		int col = ((Integer)colIdx.get(colKey)).intValue();
		rec[row][col] = new Integer(rec[row][col]+value);
		if ( isAddRow )
			rec[row][sumColIdx] = new Integer(rec[row][sumColIdx].intValue()+value);
		if ( isAddCol )
			rec[sumRowIdx][col] = new Integer(rec[sumRowIdx][col].intValue()+value);  
		
		return true;
	}
	public boolean addCellValue(String rowKey,String colKey,int value) {
        if ( rowIdx.get(rowKey) == null || colIdx.get(colKey) == null ) {
        	return false;
        }
		int row = ((Integer)rowIdx.get(rowKey)).intValue();
		int col = ((Integer)colIdx.get(colKey)).intValue();
		rec[row][col] = new Integer(rec[row][col]+value);
		
		rec[row][sumColIdx] = new Integer(rec[row][sumColIdx].intValue()+value);
		rec[sumRowIdx][col] = new Integer(rec[sumRowIdx][col].intValue()+value);  
		rec[sumRowIdx][sumColIdx] = new Integer(rec[sumRowIdx][sumColIdx].intValue()+value); 
		return true;
	}
	public boolean addLastRowCellValue(String colKey,int value) {
        if ( colIdx.get(colKey) == null ) {
        	return false;
        }
		int row = rows-1;
		int col = ((Integer)colIdx.get(colKey)).intValue();
		rec[row][col] = new Integer(rec[row][col]+value);
		
		rec[row][sumColIdx] = new Integer(rec[row][sumColIdx].intValue()+value);
		rec[sumRowIdx][col] = new Integer(rec[sumRowIdx][col].intValue()+value);  
		rec[sumRowIdx][sumColIdx] = new Integer(rec[sumRowIdx][sumColIdx].intValue()+value); 
		return true;
	}
	public String getCellValue(int rowIdx,int colIdx) {
		if ( rec[rowIdx][colIdx].intValue() == 0 )
			return "";
		else
			return ""+rec[rowIdx][colIdx].intValue();
	}
	public int getCellIntValue(int rowIdx,int colIdx){
	    return rec[rowIdx][colIdx].intValue();
	}
	public void addRow(String rowKey,String rowHeaderCaption,int index) {
		rowIdx.put(rowKey, new Integer(index));
		rowMeta[index] = rowKey;
		rowMetaCaption[index] = rowHeaderCaption;
	}
    public void addCol(String colKey,String colHeaderCaption,int index) {
    	colIdx.put(colKey, new Integer(index));
    	colMeta[index] = colKey;
    	colMetaCaption[index] = colHeaderCaption;
	}
	public String getColMeta(int colIdx){
		return colMeta[colIdx];
	}
    public String getRowMeta(int rowIdx){
    	return rowMeta[rowIdx];
	}
    public String getColMetaCaption(int colIdx){
		return colMetaCaption[colIdx];
	}
    public String getRowMetaCaption(int rowIdx){
    	return rowMetaCaption[rowIdx];
	}
    
	
	public void setSumColIdx(int sumColIdx,String caption) {
		this.sumColIdx = sumColIdx;
		colMeta[sumColIdx] = "";
		colMetaCaption[sumColIdx] = caption;
	}

	public void setSumRowIdx(int sumRowIdx,String caption) {
		this.sumRowIdx = sumRowIdx;
		rowMeta[sumRowIdx] = "";
	    rowMetaCaption[sumRowIdx] = caption;
	}
	
	
	
	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
	
	public boolean isSumRow(int rowIdx) {
		return rowIdx == sumRowIdx;
	}
	public boolean isSumCol(int colIdx) {
		return colIdx == sumColIdx;
	}

	public int getSumColIdx() {
		return sumColIdx;
	}

	public int getSumRowIdx() {
		return sumRowIdx;
	}
	public void putOtherValue(String key,String value) {
		this.otherValue.put(key, value);
	}
	public Object getOtherValue(String key) {
		return otherValue.get(key);
	}
}
