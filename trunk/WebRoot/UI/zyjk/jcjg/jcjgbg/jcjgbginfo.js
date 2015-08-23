/****************************************************
 * <p>处理内容：评价报告基本情况</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-14    新規作成 ;
 ****************************************************/
 
        var actionurl;
      
		var  _grid ;
       

         /* 提交*/
         function submitHandler() {
         	uploadImage();
        } 
        
        
        function sss(){
        
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
      
      function bodyload(){
 			var mess=$("#message").val();
           if(mess!=null&&mess!=""&&mess.length>0){
           		alert(mess);
           		top.tab.reload(top.tab.getSelectedTabItemID());
           }
 		}
         
     $(function () {
        
        try {
             
             var method = $("#method").val();  
             if(method=="add"){
               actionurl=webpath+"/UI/action/zyjk/JcjgbgAction_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
                $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"//UI/action/zyjk/JcjgbgAction_update.action";
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
          
          $.post(webpath+"/st/system/action/table/table_getColumn.action",{key:'cxqyGrid'},function(data){
	 		_grid = $("#_mainGrid").ligerGrid({checkbox: true,
			 columns:data,pageSizeOptions:[15,20,30,40,50], 
			 rownumbers:true,
			 checkbox: false,
			 //parms:{strWhere:" and dwmc like '%"+name+"%'"},
			 dataAction: 'server',url: webpath+"/st/system/action/grid/Grid_findList.action?strSysno=cxqyGrid",
			 width: '200',height:'350',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :false,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			
			 pageSize:15,
			  onSelectRow:function (data, rowindex, rowobj)
                {      
                       $("#jsdwbh").val(data.enterno);
                       $("#jsdwmc").val(data.dwmc);
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
             
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
                $.ligerDialog.error(e.message);
       }
        }); 
        
     function getEnterinfo(name){
     	document.getElementById("_mainGrid").style.display="";
	     	try{           
	     	//parent.document.getElementById("dwbh").value=name;
	     	
	     	var strWhere = " ";           
	        if(name.length>0){          
	            strWhere = " and dwmc like '%"+name+"%'";  
	        }         
	        var manager = $("#_mainGrid").ligerGetGridManager();  
	        //初始化查询起始页
	         manager.set("newPage",1);
	         //初始化查询条件
	         manager.set("parms",{"strWhere":strWhere});
	         manager.loadData(true);
	         //alert("name:"+name);
	   }catch (e) {
	           $.ligerDialog.error(e.message);
	    }
     }    
    
 function uploadImage() {
				document.getElementById("form").action=actionurl;

                document.getElementById("form").submit();
            	
		}       