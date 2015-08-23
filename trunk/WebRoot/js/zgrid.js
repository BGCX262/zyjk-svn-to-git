/*********************************************************************
 *<p>处理内容：平台  公共JAVASCRIPT GRID </p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/

/*GRID 封装事件  _keyTable column字段 ,grid 路径*/
function Grid(_keyTable,_name,_toolbar)
    {
      var _grid;
       try {
       $.post(webpath+"/st/system/action/table/table_getColumn.action",{key:_keyTable},function(data){
	 		 _grid = $("#mainGrid").ligerGrid({ checkbox: true, 
			 columns:data,pageSizeOptions:[15,20,30,40,50], 
			 rownumbers:true,parms:"",
			 checkbox: false,
			 dataAction: 'server',url: webpath+"/st/system/action/grid/Grid_findList.action?strSysno="+_keyTable,
			 width: '100%',height:'100%',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :false,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			 onDblClickRow:onDblClickRow,
			 pageSize:15,toolbar: {items:_toolbar},
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 }
			 
			});
			if(_grid!=null)
			{
				return _grid;
		    }
	 		},"json").error(function() { 
				$.ligerDialog.error(MSG_LOAD_FALL)});
		    			
	 	}catch (e) {
     		   $.ligerDialog.error(e.message);
    		}	     
    }
    
    
    
 /*GRID 封装事件  _keyTable column字段 ,grid 路径*/
/*strWhere 查询条件*/
function sub_Grid(_keyTable,_name,_toolbar,_strWhere)
    {
      var _grid;
       try {
       //alert(_strWhere);
       $.post(webpath+"/st/system/action/table/table_getColumn.action",{key:_keyTable},function(data){
	 		 _grid = $("#mainGrid").ligerGrid({ checkbox: true, 
			 columns:data,pageSizeOptions:[15,20,30,40,50], 
			 rownumbers:true,parms:"",
			 checkbox: false,
			 dataAction: 'server',url: webpath+"/st/system/action/grid/Grid_findList.action?strSysno="+_keyTable,
			 width: '100%',height:'100%',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :false,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			 onDblClickRow:onDblClickRow,
			 pageSize:15,toolbar: {items:_toolbar},parms:{"strWhere":_strWhere},
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 }
			 
			});
			if(_grid!=null)
			{
				return _grid;
		    }
	 		},"json").error(function() { 
				$.ligerDialog.error(MSG_LOAD_FALL)});
		    			
	 	}catch (e) {
     		   $.ligerDialog.error(e.message);
    		}	     
    }    