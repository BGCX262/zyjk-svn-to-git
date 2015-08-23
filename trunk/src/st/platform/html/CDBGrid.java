package st.platform.html;

import st.platform.db.control.DBGrid;

public class CDBGrid
{
	DBGrid dbGrid;
    public CDBGrid()
    {
    	dbGrid = new DBGrid();
    }

    public void setGridID(String gridID)
    {
    	dbGrid.setGridID(gridID);
    }

    public void setDictID(String dictID)
    {
    	dbGrid.setDictID(dictID);
    }
    
    public void setSQLStr(String sqlStr){
    	dbGrid.setSQLStr(sqlStr);

    }
    public void setWhereStr(String WhereStr){
    	dbGrid.setWhereStr(WhereStr);

    }
    
    public void setbuttons(String buttons)
    {
    	dbGrid.setbuttons(buttons);
    }

    public String getDBGrid()
    {
        return dbGrid.getDBGrid();
    }

    public String getDataPilot()
    {
        return dbGrid.getDataPilot();
    }

    
}
