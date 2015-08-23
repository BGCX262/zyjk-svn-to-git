/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27               新規作成 ;
 ****************************************************/
 
        var actionurl;

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
             var method = $("#method").val();  
             if(method=="add"){
               actionurl=webpath+"/UI/action/qyryxx/QyryxxAction_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
               $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"/UI/action/qyryxx/QyryxxAction_update.action";
             }
          /*危害因素树形*/    
         $("#whysname").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 250, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=WHYSTree', checkbox: true,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid',
                        onClick: function (node)
                    	{                          
                    		 var data = this.getChecked(); 
                    		 var ids="";
                    		 var nm="";
				            for (var i = 0; i < data.length; i++)
				            {
				                ids+=data[i]['data']['id']+";";
				                nm+=data[i]['data']['text']+";";
				            }                    		
                       		$("#whysname").val(nm);
                       		$("#whys").val(ids);
                   		}
                       
                    }
            });      
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
        
         
      
