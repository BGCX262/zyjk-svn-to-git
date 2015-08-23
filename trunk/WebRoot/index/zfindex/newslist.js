/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-07-05               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="1000";
var openHeight="700"; 
var sqlc="";
//初始;
$(function (){
try{
 /*布局*/
 $("#layout").ligerLayout({leftWidth: 200 });
 /*grid*/    
 var toolbar; 
 if(getUrlParam("type")=='01'){
 	grid =  sub_Grid('qynewsGrid','工作动态',""," and MESSAGETYPE='01' ");  
 }else if(getUrlParam("type")=='02'){
 	grid =  sub_Grid('lawsGrid','法律法规',""," ");  
 }else{
 	var distcode=document.getElementById("distcode").value;

	  if(distcode!=null&&distcode.length>0){
	  		if(distcode.indexOf("00000000")>=0){
					distcode=distcode.substring(0, 4);
				}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
					distcode=distcode.substring(0, 6);
				}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
					distcode=distcode.substring(0, 9);
				}
				sqlc+=" and ditcode like '"+distcode+"%'";
	  }
   
 	grid =  sub_Grid('ZczjGrid','自查自纠列表',toolbar," and bak1 in ('1','3') "+sqlc);   
 }
  $("#isscuedate").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
 
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
 	if(getUrlParam("type")=='01'){
  			myWindow = top.$.ligerDialog.open({url:webpath+"index/zfindex/newslookinfo.jsp?sysno="+data.sysno+"&type=01", width: openWidth,height:openHeight, title:"新闻列表",
 				showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
  		}else {
  			myWindow = top.$.ligerDialog.open({url:webpath+"index/zfindex/newslookinfo.jsp?sysno="+data.sysno+"&type=02", width: openWidth,height:openHeight, title:"法律法规",
 				showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
  		}
  }catch (e) {
$.ligerDialog.error(e.message);
    }
    }
      
        /*Grid查看*/
        function f_look()
        {
          try {
            var manager = $("#mainGrid").ligerGetGridManager(); 
            var selected = manager.getSelectedRow(); 
           if (selected==null||selected.length == 0) {
                    $.ligerDialog.warn(MSG_NORECORD_SELECT);
             }else{
                 myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/news/NewsAction_findByKey.action?messageBean.method=look&strSysno="+selected.sysno, width: openWidth,height:openHeight, title: '新闻列表',
                 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }
  function openDetail(sysno){
  		if(getUrlParam("type")=='01'){
  			myWindow = top.$.ligerDialog.open({url:webpath+"index/zfindex/newslookinfo.jsp?sysno="+sysno+"&type=01", width: openWidth,height:openHeight, title:"新闻列表",
 				showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
  		}else {
  			myWindow = top.$.ligerDialog.open({url:webpath+"index/zfindex/newslookinfo.jsp?sysno="+sysno+"&type=02", width: openWidth,height:openHeight, title:"法律法规",
 				showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
  		}
  
  }