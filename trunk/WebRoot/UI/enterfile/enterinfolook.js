/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-19    孙雁斌           新規作成 ;
 ****************************************************/
var actionurl;
var openWidth="980";
var openHeight="650";

         /* 提交*/
         function submitHandler() {
 
 
	                 $("#subButton").attr("disabled", true);
			      $.post(actionurl,$("form:first").serialize(),function(data){
			      $("#subButton").removeAttr('disabled'); 
			      if(data.checkFlag==MSG_SUCCESS)
				  {
				  		 parent.flag.value='2';	
				  		 parent.mainkey.value=data.widgetValue;		  		 
				  		 actionurl=webpath+"UI/action/enter/EnterMain_update.action";
				  		 $("#enterno").val(data.widgetValue);
				       $.ligerDialog.success(data.checkMessage); 	
				   }else{
				       	$.ligerDialog.error(data.checkMessage);
				   }
					},"json").error(function() { 
					$("#subButton").removeAttr('disabled'); 
					$.ligerDialog.error(MSG_LOAD_FALL);
					});
	             
	         
		          
		       } 
 
         function editCorp(){
              var method=parent.isMethod();
              if(method=="add"){
                  window.location.href=webpath+"/UI/action/enter/EnterMain_editByKey.action?messageBean.method=add&strSysno="+$("#strSysno").val(); 
              }else if(method=="update"){
                  window.location.href=webpath+"/UI/action/enter/EnterMain_editByKey.action?messageBean.method=update&strSysno="+$("#strSysno").val();
              }
          
         }
         
         /*当主管单位选其他时增加input框*/
        function addTd(_obj){
          if(_obj.value=="05"){
            document.getElementById("othertype").style.display="block"; 
          }
        }
 
        $(function () {
        try {
             
             /*主管单位类型如为05，则隐藏input框*/
           //if(document.getElementById("zhuguan").value=="05"){          
           //   document.getElementById("othertype").style.display="block"; 
           //} 
             
             var method = $("#method").val();  
             if(method=="add"){
               /*当从zform.jsp传的showButton参数为1时隐藏提交按钮*/
              var showButton=$("#showButton").val();
              if(showButton=='1'){
                 $("#subButton").hide();
                 $("#editButton").hide();
              }
              actionurl=webpath+"UI/action/enter/EnterMain_insert.action";
             }else if(method=="look"){
               $("#subButton").hide();
               $("#colButton").hide();
             }else if(method=="update"){
                actionurl=webpath+"UI/action/enter/EnterMain_update.action";
                
             } 
         
             
         /*返回信息状态*/
         var strFlag = $("#flag").val();
         var strMessage = $("#message").val();
         if(strFlag!=MSG_SUCCESS)
         {  
             $.ligerDialog.error(strMessage);
          }
           
         
          
          /*验证样式提交*/
          var v = Form();
          $("form").ligerForm();
             
          }catch (e) {
            $("#subButton").removeAttr('disabled'); 
                $.ligerDialog.error(e.message);
       }
        }); 