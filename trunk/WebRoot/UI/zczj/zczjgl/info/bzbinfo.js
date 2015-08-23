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
           $("#subButton").attr("disabled", true);
           $.post(actionurl,$("form:first").serialize(),function(data){
           $("#subButton").removeAttr('disabled'); 
           if(data.checkFlag==MSG_SUCCESS)
           {
                $.ligerDialog.success(data.checkMessage);
                top.tab.refresh(top.tab.getSelectedTabItemID());
            }else{
                 $.ligerDialog.error(data.checkMessage);
            }
             },"json").error(function() { 
             $("#subButton").removeAttr('disabled'); 
             $.ligerDialog.error(MSG_LOAD_FALL);
             });
        } 
        
        
   function clicksel(obj){
        if(obj.value=="1"){
            document.getElementById("seltb").style.display="block";
            document.getElementById("pdnr").isNull="false";
            document.getElementById("pdnr").check="isString('#',1000)";
            document.getElementById("ckyj").check="isString('#',200)";
            document.getElementById("ckyj").isNull="false";
            document.getElementById("bzmcTr").style.display="none";
            document.getElementById("bzmc").isNull="true";
            document.getElementById("moji").value="1";
        }else{
            document.getElementById("seltb").style.display="none";
            document.getElementById("pdnr").check="";
            document.getElementById("ckyj").check="";
            document.getElementById("bzmc").isNull="false";
            document.getElementById("pdnr").isNull="true";
            document.getElementById("ckyj").isNull="true";
            document.getElementById("bzmcTr").style.display="block";
            document.getElementById("moji").value="0";
            
        }
    }
        
 
        $(function () {
        try { 
        //alert("是否叶子结点:"+$("#mj").val());
           //  if($("#mj").val()=='1')
           //  {
           //      document.getElementById("moji").checked="true";
                //$("#moji").attr("checked", true);
           //  }else if($("#mj").val()=='0')
           //  {
           //      document.getElementById("notmoji").checked="true";
                 //$("#notmoji").checked="checked"
                 //$("#notmoji").attr("checked", true);
           //  }
             
        if(document.getElementById("moji").value=="1"){
            document.getElementById("seltb").style.display="block";
            document.getElementById("pdnr").isNull="false";
            document.getElementById("pdnr").check="isString('#',1000)";
            document.getElementById("ckyj").check="isString('#',200)";
            document.getElementById("ckyj").isNull="false";
            document.getElementById("bzmcTr").style.display="none";
            document.getElementById("bzmc").isNull="true";
        }else
        {
            
            document.getElementById("seltb").style.display="none";
            document.getElementById("pdnr").check="";
            document.getElementById("ckyj").check="";
            document.getElementById("bzmc").isNull="false";
            document.getElementById("pdnr").isNull="true";
            document.getElementById("ckyj").isNull="true";
            document.getElementById("bzmcTr").style.display="block";
            
        }
             
             
             var method = $("#method").val();  
             if(method=="add"){
               actionurl=webpath+"/UI/action/zyjkbzb/BzbAction_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
               $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"/UI/action/zyjkbzb/BzbAction_update.action";
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
        
         
      
