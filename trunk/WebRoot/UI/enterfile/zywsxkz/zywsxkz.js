/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-04-27               新規作成 ;
 ****************************************************/
 
       
         function submitHandler() {
         
         document.getElementById("form").submit(); 
        } 
 	
 		function bodyload(){
 			var mess=$("#message").val();
           if(mess!=null&&mess!=""&&mess.length>0){
           		alert(mess);
           }
 		}
 
        $(function () {
        try {
          
          /*验证样式提交*/
          var v = Form();
          $("form").ligerForm();
             
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
                $.ligerDialog.error(e.message);
       }
        }); 
        
      
      
