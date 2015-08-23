/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  ;
 * 改版履历;
 * Rev - Date ------- jmx ---------- Note -------------------
 * 1.0  2013-06-06               新規作成 ;
 ****************************************************/
var grid = null;
var tree = null;
var myWindow = null;
var menu=null; 
var openWidth="1000";
var openHeight="650"; 
var zbid;
var depth=4;
var distcode;
//初始;
$(function (){
try{
 /*布局*/
 $("#layout").ligerLayout({leftWidth: 200 });
 /*grid*/    
 var toolbar =   [
 { text: '新建', click:f_add,icon: 'add' }, 
 { line: true },
 { text: '修改', click:f_update,icon: 'modify' },
 { line: true },
 { text: '删除', click:f_remove,icon:'delete' }, 
 { line: true }, 
 { text: '查看', click:f_look,  icon:'pager' },
 { line: true },
 { text: '核查', click:f_check,  icon:'msn' }  
   ]; 
   
  zbid=getUrlParam("zbid"); 
  distcode=getUrlParam("distcode");
  var lx= getUrlParam("lx");
  var hyfl=getUrlParam("hylb");
  var whys=getUrlParam("whys");
  var qygm=getUrlParam("qygm");
 var zclx=getUrlParam("zclx");
  var sqlc=" and bak1='1'";
  var xsql=" and 1=1";
  if(distcode!=null&&distcode.length>0){
  		if(distcode.indexOf("00000000")>=0){
				distcode=distcode.substring(0, 4);
				depth=1;
				xsql+=" and code like '"+distcode+"%' and depth in (1,2)";
			}else if(distcode.indexOf("000000")>=0&&distcode.indexOf("00000000")<0){
				distcode=distcode.substring(0, 6);
				xsql+=" and code like '"+distcode+"%' and depth in (2,3)";
				depth=2;
			}else if(distcode.indexOf("000000")<0&&distcode.indexOf("00000000")<0&&distcode.indexOf("000")>=0){
				distcode=distcode.substring(0, 9);
				xsql+=" and code like '"+distcode+"%' and depth in (3,4)";
				depth=3;
			}
			sqlc+=" and ditcode like '"+distcode+"%'";
  }
  if(lx==1){
  		sqlc+=" and hgx>30";
  }else if(lx==2){
  		sqlc+=" and hgx<=30";
  }else if(lx==0){
  		sqlc+=" and 1=1 ";
  }
  //危害分类
  if(hyfl!=null&&hyfl.length>0){
  	sqlc+=" and a.enterno in (select qyjbqk.enterno from qyjbqk where hyfl like '"+hyfl+"%')";
  }
  //危害因素
  if(whys!=null&&whys.length>0){
  	sqlc+=" and a.corpkey in (select Z_wh.corpkey from Z_wh where whDM like '"+whys+"%' )";
  }
  //企业规模
  if(qygm!=null&&qygm.length>0){
  	sqlc+=" and a.enterno in (select qyjbqk.enterno from qyjbqk where chanzhi ='"+qygm+"')";
  }
   //注册类型
  if(zclx!=null&&zclx.length>0){
  	sqlc+=" and a.enterno in (select qyjbqk.enterno from qyjbqk where zclx ='"+zclx+"')";
  }
 grid =  sub_Grid('ZczjGrid','自查自纠',toolbar," and zbid='" + getUrlParam("zbid") + "'"+sqlc);  
 document.getElementById("zbid").value=zbid;
  /*TREE*/
 $("#tree").ligerTree({         
             //data:[{id:'1',pid:'0',children:[],text:'行政区划',isexpand:'false'}],
             idFieldName :'id',
             parentIDFieldName :'pid', 
             url:webpath+"/st/system/action/tree/tree_getTree.action?strTreeName=DistCodeTree&strWhere="+xsql,
             nodeWidth : 200,
             checkbox: false,
             slide: false,                        
          //   onExpand:onExpand,
            // onBeforeExpand: onBeforeExpand,
            onClick: function(node)
                  {
                    
                  }, 
             onSelect: function (node)
                 {                                                          
                   var nodeid=node.data.id;                                      
                    t_enter(nodeid);
                }
         });
         
         tree = $("#tree").ligerGetTreeManager(); 
         
         $("#zcsj").ligerDateEditor({label: '', labelWidth: 100, labelAlign: 'center' });
        }catch (e) {
           $.ligerDialog.error(e.message);
        }    
     });
        
 /*grid双击事件*/  
 function onDblClickRow (data, rowindex, rowobj){
 try {
  myWindow = top.$.ligerDialog.open({url:webpath+"/UI/action/zczj/ZczjAction_getZczjList.action?messageBean.method=look&strSysno="+data.sysno+"&zbid="+zbid, width: openWidth,height:openHeight, title:"自查自纠",
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
              var strWhere = " ";           
    
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
        
        /*删除*/
        function f_remove(){ 
        try {
           
           var strId ="''";
        var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRows(); 
        if (selected==null) {
            $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{              
            $.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state)
              {
               if(state)
               {    
                    if(selected!=null&&selected.length>0){
                       for(var i=0;i<selected.length;i++){
                         strId = strId+",'"+selected[i].sysno+"'";
                       }
                    }
                    $.post(webpath+"/UI/action/zyjk/ZczjAction_delete.action",{strSysno:strId},function(data){
                       if(data.checkFlag==MSG_SUCCESS){
                         f_search();                        
                         $.ligerDialog.success(data.checkMessage);
                       }else{
                         $.ligerDialog.error(data.checkMessage);
                       }
                   },"json").error(function() { 
                             $.ligerDialog.error(MSG_LOAD_FALL)});
                  
               }
               });                 
        }          
        }catch (e) {
                $.ligerDialog.error(e.message);
         }
        }
        
        /*新建*/
        function f_add(){
           try {

          
           var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        
        var strId;
        
        myWindow = top.$.ligerDialog.open({ url: webpath+"/UI/action/zyjk/ZczjAction_getZczjList.action?messageBean.method=add&strSysno="+strId+"&zbid="+zbid,  width: openWidth,height:openHeight, title: '自查自纠',
        showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
          // f_search();   
        }catch (e) {
                $.ligerDialog.error(e.message);
         }  
        }
        
        /*修改*/
        function f_update(){ 
         try {
          
        var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        var strId;
        if(selected==null){
         $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else if(selected !=null){
          strId=selected.sysno;
        }
        
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/ZczjAction_getZczjList.action?messageBean.method=update&strSysno="+strId+"&zbid="+zbid, width: openWidth,height:openHeight, title: '自查自纠',
         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
         //f_search(); 
        }
        }catch (e) {
                 $.ligerDialog.error(e.message);
       } 
        } 
        
        
        /*核查*/
        function f_check(){
           
                 try {
          
        var manager = $("#mainGrid").ligerGetGridManager(); 
        var selected = manager.getSelectedRow(); 
        var strId;
        if(selected==null){
         $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else if(selected !=null){
          strId=selected.sysno;
        }
        
        if (strId==null||strId.length == 0) {
             $.ligerDialog.warn(MSG_NORECORD_SELECT);
        }else{
         myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjkck/ZczjAction_getZczjList.action?messageBean.method=update&strSysno="+strId+"&zbid="+zbid, width: openWidth,height:openHeight, title: '自查自纠',
         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); 
         //f_search(); 
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
                 myWindow = top.$.ligerDialog.open({url: webpath+"/UI/action/zyjk/ZczjAction_getZczjList.action?messageBean.method=look&strSysno="+selected.sysno+"&zbid="+zbid, width: openWidth,height:openHeight, title: '自查自纠',
                 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); 
             }
       }catch (e) {
                 $.ligerDialog.error(e.message);
       }
        }