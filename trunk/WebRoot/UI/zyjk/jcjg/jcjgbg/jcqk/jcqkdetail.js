/****************************************************
 * <p>处理内容：劳动者从业史</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-05-29   新規作成 ;
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
        /* 下拉框选择事件*/
        function onChange(obj){
           var objid=obj.value;
           //alert(objid);
           if(objid=="05"||objid=="02"){
                 objid="0205";
           }else if(objid=="03"||objid=="04"||objid=="06"){
                 objid="030406";
           }
           //alert(objid);
           if(null!=document.getElementById(objid)){
              document.getElementById("01").style.display="none";
              document.getElementById("0205").style.display="none";
              document.getElementById("030406").style.display="none";
              document.getElementById("07").style.display="none";
              document.getElementById("08").style.display="none";
              document.getElementById("09").style.display="none";
              document.getElementById("10").style.display="none";
              document.getElementById("11").style.display="none";           
              document.getElementById(objid).style.display="block"; 
           } 
        }
 
        $(function () {
        try {
             
            /*初始判断下拉框 */ 
           var objid=$("#jclb").val();
           //alert(objid);
           if(objid=="05"||objid=="02"){
                 objid="0205";
           }else if(objid=="03"||objid=="04"||objid=="06"){
                 objid="030406";
           }
           if(null!=document.getElementById(objid)){
              document.getElementById("01").style.display="none";
              document.getElementById("0205").style.display="none";
              document.getElementById("030406").style.display="none";
              document.getElementById("07").style.display="none";
              document.getElementById("08").style.display="none";
              document.getElementById("09").style.display="none";
              document.getElementById("10").style.display="none";
              document.getElementById("11").style.display="none";           
              document.getElementById(objid).style.display="block"; 
           } 
             
             
             var method = $("#method").val();  
             if(method=="add"){
               actionurl=webpath+"/UI/action/jcqk/JcqkAction_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
               $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"/UI/action/jcqk/JcqkAction_update.action";
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
        
         
      
