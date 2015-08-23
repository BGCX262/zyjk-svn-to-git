/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27               新規作成 ;
 ****************************************************/
 
        var actionurl;
		var _grid;
         /* 提交*/
         function submitHandler() {
           $("#subButton").attr("disabled", true);
           $.post(actionurl,$("form:first").serialize(),function(data){
           $("#subButton").removeAttr('disabled'); 
           if(data.checkFlag==MSG_SUCCESS)
           {
                $.ligerDialog.success(data.checkMessage);
                top.tab.reload(top.tab.getSelectedTabItemID());
            }else{
                 $.ligerDialog.error(data.checkMessage);
            }
             },"json").error(function() { 
             $("#subButton").removeAttr('disabled'); 
             $.ligerDialog.error(MSG_LOAD_FALL);
             });
        } 
 
        $(function () {
        try {

        	 //初始化培训机构表格
           $.post(webpath+"/st/system/action/table/table_getColumn.action",{key:'cxpxjgGrid'},function(data){
	 		_grid = $("#_mainGrid").ligerGrid({checkbox: true,
			 columns:data,pageSizeOptions:[15,20,30,40,50], 
			 rownumbers:true,
			 checkbox: false,
			 //parms:{strWhere:" and dwmc like '%"+name+"%'"},
			 dataAction: 'server',url: webpath+"/st/system/action/grid/Grid_findList.action?strSysno=cxpxjgGrid",
			 width: '200',height:'350',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :false,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			
			 pageSize:15,
			  onSelectRow:function (data, rowindex, rowobj)
                {      
                       $("#pxjgno").val(data.sysno);
                       $("#pxjgmc").val(data.pxjgmc);
                      // $("#dwdz").val(data.zcdz);
                       //$("#sex").val(data.sex);
                     
                      document.getElementById("_mainGrid").style.display="none";
                },
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 }
			 
			});
			document.getElementById("_mainGrid").style.display="none";
			if(_grid!=null)
			{
				return _grid;
		    }
	 		},"json").error(function() { 
				$.ligerDialog.error(MSG_LOAD_FALL)});
            //初始化表格结束 
             
             $.post(webpath+"/st/system/action/table/table_getColumn.action",{key:"qyryxxGrid"},function(data){
	 		 grid = colselect.grid.ligerGrid({ checkbox: false, 
			 columns:data,pageSizeOptions:[15,20,30,40,50], 
			 parms:{strWhere:" and enterno like '%"+ $("#enterno").val() +"%' and zw like '%"+ getUrlParam("zw") +"%' "},
			 dataAction: 'server',url: webpath+"/st/system/action/grid/Grid_findList.action?strSysno=qyryxxGrid",
			 width: '100%',height:'100%',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :true,
			 pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			 pageSize:10,isScroll: true,
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 },			 
			 onSelectRow:function (data, rowindex, rowobj)
                {      
                       $("#ryxm").val(data.name);
                       $("#gz").val(data.gz);
                       $("#rybh").val(data.sysno);
                       colselect.selectBox.hide();
                }
			});
	 		  },"json").error(function() { 
								$.ligerDialog.error(MSG_LOAD_FALL)});
           
           
           var colselect = $("#ryxm").ligerComboBox({
                width: 250,
                slide: false,
                selectBoxWidth: 500,
                selectBoxHeight: 240, 
                valueField: 'name', 
                textField: 'name',
                grid: {
                   
                }
          });        
          var columntree  =colselect.grid.ligerGetGridManager();  
             
        
             var method = $("#method").val();  
             if(method=="add"){
               actionurl=webpath+"/UI/action/qypxjl/QypxjlAction_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
               $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"/UI/action/qypxjl/QypxjlAction_update.action";
             } 
             
         /*返回信息状态*/
         var strFlag = $("#flag").val();
         var strMessage = $("#message").val();
         if(strFlag!=MSG_SUCCESS)
         {  
             $.ligerDialog.error(strMessage);
          }
        
         
         /*关闭按钮*/
          $("#colButton").click(function () {
                 top.$.ligerDialog.close(); 
                 top.$.ligerDialog.hide();         
             });
          
          /*验证样式提交*/
          var v = Form();
          $("form").ligerForm();
             
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
                $.ligerDialog.error(e.message);
       }
        }); 
        
             
      function getEnterinfo(name){
     	document.getElementById("_mainGrid").style.display="";
	     	try{           
	     	var strWhere = " ";           
	        if(name.length>0){          
	            strWhere = " and pxjgmc like '%"+name+"%'";  
	        }         
	        var manager = $("#_mainGrid").ligerGetGridManager();  
	        //初始化查询起始页
	         manager.set("newPage",1);
	         //初始化查询条件
	         manager.set("parms",{"strWhere":strWhere});
	         manager.loadData(true);
	   }catch (e) {
	           $.ligerDialog.error(e.message);
	    }
     }    
        
      
