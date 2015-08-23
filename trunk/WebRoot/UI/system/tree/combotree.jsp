<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<%@ include file="/global.jsp"%>
	<head>
	 <script type="text/javascript">
	 var selecttree = null;
	 var manger = null;
        $(function ()
        {
        	//select tree2
            $("#txt2").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=MenuTree', checkbox: false,
                        textFieldName:'text',
                        idFieldName:'id',
                        parentIDFieldName:'pid'
                       
                        }
            });
            
           selecttree=$("#txt1").ligerComboBox({
                width: 180,
                selectBoxWidth: 180,
                selectBoxHeight: 200, 
                textField:'text',
                treeLeafOnly:false,
                tree: { 
	                url: webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=MenuTree&strTreeID=1',
	                idFieldName :'id',
	                parentIDFieldName :'pid', 
	                textFieldName:'text',
	                nodeWidth :100,
	                checkbox: false,
	                slide: false,
	                onBeforeExpand:onBeforeExpand
					}
            });
            
            
            
             getGridOptions(false);
            
     
         manger  =selecttree.tree.ligerGetTreeManager();
            
        }); 
        function onBeforeExpand(node){

            var nodeid=node.data.id;
            var cb  = manger.getParent(node);
            var flag=1;
            var length=node.data.children.length;

            if(node.data.children && node.data.children.length == 0){
             manger.loadData(node.target,webpath+'/st/system/action/tree/tree_getTree.action?strTreeName=MenuTree&strTreeID='+nodeid);
            }  
        }
        
       function getGridOptions(checkbox)
        {
            var grid ;
            $.post(webpath+"/st/system/action/table/table_getColumn.action",{key:"DemoTable"},function(data){
	 		 grid ={checkbox: checkbox, 
			 columns:data,pageSizeOptions:[15,20,30,40,50], 
			 rownumbers:true,parms:"",
			 dataAction: 'server',url: webpath+"/UI/action/demo/demo_findList.action",
			 width: '100%',height:'100%',root:'dataSet',record:'total',usePager:'true',method:'post',resizable :false,pageParmName:'pageBean.page',pagesizeParmName:'pageBean.pageSize',
			pageSize:15,
			 onError:function(){
				$.ligerDialog.error(MSG_LOAD_FALL);		 
			 },
			};
			
			 $("#txt3").ligerComboBox({
                width: 250,
                slide: false,
                selectBoxWidth: 500,
                selectBoxHeight: 240, valueField: 'customerid', textField: 'customerid'
                , grid: grid
            });
			
			
	 		  },"json");
            return grid;
        }  
    </script>
	
	</head>

<body style="margin: 100px">
<div id="layout">
<div    position="left"> 
   select tree 全部展示<br/>
   <input type="text" id="txt2"/>
   <br />
 </div>
 <div >
   select tree 点击展示<br/>
   <input type="text" id="txt1"/>
   <br />
 </div>
 <div  position="center">
 <br/>
 	select grid<br/>
 	 <input type="text" id="txt3"/>
   <br />
 </div>
 </div>
</body>
</html>
