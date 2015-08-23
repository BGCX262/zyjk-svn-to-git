/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-02   孙雁斌            新規作成 ;
 ****************************************************/
 
        var actionurl;

         /* 提交*/
         function submitHandler() {
         	var oEditor = FCKeditorAPI.GetInstance("contentx");
         	$("#content").val(oEditor.GetXHTML(true));
         	uploadImage();
         //  $("#subButton").attr("disabled", true);
          // uploadImage();
          // $.post(actionurl,$("form:first").serialize(),function(data){
          // $("#subButton").removeAttr('disabled'); 
         ///  if(data.checkFlag==MSG_SUCCESS)
         //  {
          //      $.ligerDialog.success(data.checkMessage);
          //      top.tab.reload(top.tab.getSelectedTabItemID());
          //  }else{
          //       $.ligerDialog.error(data.checkMessage);
          //  }
           //  },"json").error(function() { 
          //   $("#subButton").removeAttr('disabled'); 
           //  $.ligerDialog.error(MSG_LOAD_FALL);
           //  });
        } 
 
        $(function () {
        try {
             var method = $("#method").val();  
             if(method=="add"){
               actionurl=webpath+"/UI/action/news/NewsAction_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
               $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"/UI/action/news/NewsAction_update.action";
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
       function uploadImagexx() {
		   
		                        $("#form").ajaxSubmit( {  
		                           // url : webpath+"/UI/action/photo/PhotoService_uploadImage.action",
		                            target:    '#UpIframe', 
		                           	url : actionurl,  
		                            //type : "POST",  
		                            datatype : "script",  
		                            success : function(returnData) {
		                            		alert(returnData);
		                            	 if(returnData.checkFlag==MSG_SUCCESS)
								           {
								                $.ligerDialog.success(returnData.checkMessage);
								               top.tab.reload(top.tab.getSelectedTabItemID());
								            }else{
								                $.ligerDialog.error(returnData.checkMessage);
								           }
		                            } ,
		                            error:function(returnData){
		                            	alert(returnData);
		                            }
		                        });  
		                     
		               
		}   
		
		 function uploadImage() {
				document.getElementById("form").action=actionurl;

                document.getElementById("form").submit();
            	top.tab.reload(top.tab.getSelectedTabItemID());
		}   
         
      
