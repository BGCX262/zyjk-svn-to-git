/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-06               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="1000";
var openHeight="650"; 
var zbid;
//初始;
$(function (){
try{
 /*布局*/
 $("#layout").ligerLayout({leftWidth: 200 });
 /*grid*/    
 var toolbar =   [
 
 { text: '查看', click:f_look,  icon:'pager' },
 { line: true } 
   ]; 
   
  zbid=getUrlParam("zbid"); 
  
   
 grid =  sub_Grid('ZczjGrid','自查自纠',toolbar," and (enterno='"+ getUrlParam("enterno") +"' or corpkey='"+ getUrlParam("enterno") +"' )and zbid='" + getUrlParam("zbid") + "'");  
 document.getElementById("zbid").value=zbid;

 

        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/action/zyjk/ZczjAction_getZczjList.action?messageBean.method=look&strSysno="+data.sysno+"&zbid="+zbid, width: openWidth,height:openHeight, title:"自查自纠",
 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
  }catch (e) {
	$.ligerDialog.error(e.message);
    }
    }
    
    /*展开事件*/ 
      function onExpand(node){
            var nodeid=node.data.id;

       }
       /*Tree展开事件*/ 
      function onBeforeExpand(node){
            var nodeid=node.data.id;
            if(node.data.children && node.data.children.length == 0){
               tree.loadData(node.target,webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree");
            }  
        }         
        
     /*Tree查看*/
        function t_enter(nodeid){
        try{           
                 
          var strWhere = " ";           
			if(nodeid.indexOf("00000000")>=0){
				nodeid=nodeid.substring(0, 4);
			}else if(nodeid.indexOf("000000")>=0&&nodeid.indexOf("00000000")<0){
				nodeid=nodeid.substring(0, 6);
			}else if(nodeid.indexOf("000000")<0&&nodeid.indexOf("00000000")<0&&nodeid.indexOf("000")>=0){
				nodeid=nodeid.substring(0, 9);
			}
			strWhere+=" and ditcode like '"+nodeid+"%'";	
			//alert(strWhere);	
             var manager = $("#mainGrid").ligerGetGridManager();  
             //初始化查询起始页
              manager.set("newPage",1);
              //初始化查询条件
              manager.set("parms",{"strWhere":strWhere});
              manager.loadData(true);
        }catch (e) {
                $.ligerDialog.error(e.message);
         }
                 
        } 

        /*根据条件查询*/
     function f_search(){
         try{
              var strWhere = " and bak1<>'0' and zbid='" + getUrlParam("zbid") + "'";           
    
     //单位名称
     var dwmc = $("#dwmc").val();
     if(dwmc.length>0) {
       strWhere = " and dwmc like '%"+dwmc+"%' ";
     }
    
     //区划
    // var ditcode = $("#ditcode").val();
    // if(ditcode.length>0) {
    //   strWhere = " and ditcode like '%"+ditcode+"%' ";
   //  }
   
     //自查时间
     var zcsj = $("#zcsj").val();
     if(zcsj.length>0) {
       strWhere = " and zcsj like '%"+zcsj+"%' ";
     }
             var manager = $("#mainGrid").ligerGetGridManager();  
              //manager.loadServerData({strWhere:strWhere},function (countmain) {
             //   alert(countmain);
              //});
              //初始化查询起始页
              manager.set("newPage",1);
              //初始化查询条件
              manager.set("parms",{"strWhere":strWhere});
              manager.loadData(true);
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
             //alert("Grid查看");
                 myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/ZczjAction_getZczjList.action?messageBean.method=look&strSysno="+selected.sysno+"&zbid="+zbid, width: openWidth,height:openHeight, title: '自查自纠',
                 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }