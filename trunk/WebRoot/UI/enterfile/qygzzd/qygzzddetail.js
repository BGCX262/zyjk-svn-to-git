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
           uploadImage();
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
               actionurl=webpath+"/UI/action/qygzzd/QygzzdAction_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
               $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"/UI/action/qygzzd/QygzzdAction_update.action";
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
        
      function uploadImage() {
				document.getElementById("form").action=actionurl;

                document.getElementById("form").submit();
            	
		}       
      
