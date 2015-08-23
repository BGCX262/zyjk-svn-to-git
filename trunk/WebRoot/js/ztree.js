/*********************************************************************
 *<p>处理内容：平台  公共JAVASCRIPT Tree </p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
 function Tree(tree,_name){
 
 	/*TREE*/         
            $("#tree").ligerTree({         
                data:[{id:'1',pid:'0',children:[],text:'菜单管理',isexpand:'false'}],
                idFieldName :'id',
                parentIDFieldName :'pid', 
                nodeWidth : 200,
                checkbox: false,
                slide: false,                        
                onExpand:onExpand,
                onBeforeExpand: onBeforeExpand,
                onSelect: function (node){                       
                       var nodeid=node.data.id;                                      
                       t_enter(nodeid);
                   },
                onContextmenu: function (node, e) { 
                    actionNodeID = node.data.text;
                    menu.show({ top: e.pageY, left: e.pageX });
                    return false;
                    }
            });
 
 }