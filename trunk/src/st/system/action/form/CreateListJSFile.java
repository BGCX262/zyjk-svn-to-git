package st.system.action.form;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import st.platform.utils.BusinessDate;
import st.platform.utils.Config;
import st.system.dao.PtablecolumnBean;
import st.system.dao.PtactionsBean;
import st.system.dao.PtgridsBean;
import st.system.dao.PtgridscolumnBean;

/**
 * <p>处理内容：创建jsp文件 主要有添加function 修改function 查询function 
 * </p>
 * <p>Copyright: Copyright (c) 2010</p>
 * @author  方立文
 * 改版履历
 * Rev - Date ------- Name ---------- Note --------------------------------
 * 1.0   2010.9.17    方立文           新規作成 
 */
public class CreateListJSFile extends CreateCommonFileUtil {
   
   
    private OutputStreamWriter  fos;
    
    /**
     * 头文件的信息
     * @throws Exception 
     *
     */
    public void createImport() throws Exception{
        
        fos.write(("/****************************************************\n"));
        fos.write((" * <p>处理内容：</p>\n"));
        fos.write((" * <p>Copyright: Copyright (c) "+ BusinessDate.getToday().substring(0, 4)+"</p>;\n"));
        fos.write((" * @author  ;\n"));
        fos.write((" * 改版履历;\n"));
        fos.write((" * Rev - Date ------- Name ---------- Note -------------------\n"));
        fos.write((" * 1.0  "+BusinessDate.getToday()+"               新規作成 ;\n"));
        fos.write((" ****************************************************/\n"));
       
    }
    
    /**
     * js参数
     * @throws Exception
     */
    public void getParam() throws Exception
    {
        fos.write(("var grid = null;\n"));
        fos.write(("var tree = null;\n"));
        fos.write(("var myWindow = null;\n"));
        fos.write(("var menu=null; \n"));
        fos.write(("var openWidth=\"630\";\n"));
        fos.write(("var openHeight=\"300\"; \n"));
    }
    
    //初始代码
    public void getInit(PtgridsBean grid) throws Exception{
        fos.write(("//初始;\n"));
        fos.write(("$(function (){\n"));
        fos.write(("try{\n"));
        fos.write((" /*布局*/\n"));
        fos.write((" $(\"#layout\").ligerLayout({leftWidth: 200 });\n"));
        fos.write((" /*grid*/    \n"));
        
        /*GRID*/ 
        fos.write((" var toolbar =   [\n"));
        fos.write((" { text: '新建', click:f_add,icon: 'add' }, \n"));
        fos.write((" { line: true },\n"));
        fos.write((" { text: '修改', click:f_update,icon: 'modify' },\n"));
        fos.write((" { line: true },\n"));
        fos.write((" { text: '删除', click:f_remove,icon:'delete' }, \n"));
        fos.write((" { line: true }, \n"));
        fos.write((" { text: '查看', click:f_look,  icon:'pager' } \n"));
        fos.write(("   ]; \n"));
        fos.write((" grid =  Grid('"+grid.getGridname()+"','"+grid.getGriddesc()+"',toolbar);  \n"));
        
        //判断是否有树
        if(grid.getIstree().equals("1"))
        {
            fos.write((" /*TREE*/         \n"));
            fos.write(("  $(\"#tree\").ligerTree({     \n"));    
            fos.write(("   data:[{id:'1',pid:'0',children:[],text:'"+grid.getGriddesc()+"',isexpand:'false'}], \n"));
            fos.write(("   idFieldName :'id',\n")); 
            fos.write(("   parentIDFieldName :'pid', \n"));
            fos.write(("   nodeWidth : 200,\n")); 
            fos.write(("   checkbox: false,\n"));
            fos.write(("   slide: false,  \n")); 
            fos.write(("   onBeforeExpand: onBeforeExpand,\n"));
            fos.write(("   onSelect: function (node){           \n")); 
            fos.write(("   var nodeid=node.data.id;   \n"));
            fos.write(("   t_enter(nodeid); \n")); 
            fos.write((" }, \n"));
            fos.write(("  onContextmenu: function (node, e) { \n")); 
            fos.write((" actionNodeID = node.data.text; \n"));
            fos.write((" menu.show({ top: e.pageY, left: e.pageX }); \n")); 
            fos.write((" return false;\n"));
            fos.write((" }\n"));
            fos.write((" }); \n")); 
            
            fos.write(("tree = $(\"#tree\").ligerGetTreeManager(); \n")); 
            fos.write("            /*右键菜单*/\n");
            fos.write("             menu = $.ligerMenu({ top: 100, left: 100, width: 120, items:\n");
            fos.write("            [\n");
            fos.write("            { text: '增加', click: f_add,  icon: 'add' },\n");
            fos.write("            { text: '修改', click: f_update, icon: 'modify' },\n");
            fos.write("            { line: true },\n");
            fos.write("            { text: '删除', click: f_remove, icon: 'delete' }\n");
            fos.write("            ]\n");
            fos.write("              });\n");
        }
        fos.write("        }catch (e) {\n");
        fos.write("           $.ligerDialog.error(e.message);\n");
        fos.write("        }    \n");
        fos.write("     });\n");
        fos.write("        \n");
    }
    
    /**
     * grid的双击
     * @throws Exception
     */
    public void getGridDb(String id,PtgridsBean ptgrid) throws Exception{
        String namespace = ptgrid.getActionname()+"_"+"findByKey.action?messageBean.method=look&strSysno=";
        fos.write(" /*grid双击事件*/  \n");
        fos.write(" function onDblClickRow (data, rowindex, rowobj){\n");
        fos.write(" try {\n");
        fos.write("  myWindow = $.ligerDialog.open({url:webpath+\""+namespace+"\"+data."+id+", width: openWidth,height:openHeight, title:\""+ptgrid.getGriddesc()+"\",\n");
        fos.write(" showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); \n");
        fos.write("  }catch (e) {\n");
        fos.write("$.ligerDialog.error(e.message);\n");
        fos.write("    }\n");
        fos.write("    }\n");
    }
    
    /**
     * 树形
     * @param gridname
     * @throws IOException 
     */
    public void getTREE(String treeName) throws IOException
    {
        fos.write("       /*Tree展开事件*/ \n");
        fos.write("      function onBeforeExpand(node){\n");
        fos.write("            var nodeid=node.data.id;\n");
        fos.write("            if(node.data.children && node.data.children.length == 0){\n");
        fos.write("               tree.loadData(node.target,webpath+\"/st/system/action/tree/tree_getTree.action?strTreeName="+treeName+"\");\n");
        fos.write("            }  \n");
        fos.write("        }         \n");
        fos.write("        \n");
        fos.write("     /*Tree查看*/\n");
        fos.write("        function t_enter(nodeid){\n");
        fos.write("        try{           \n");
        fos.write("          var strWhere = \" \";           \n");
        fos.write("             if(nodeid.length>0){          \n");
        fos.write("                 strWhere = \" and parentmenuid = '\"+nodeid+\"' or menuid='\"+nodeid+\"'\";  \n");
        fos.write("             }         \n");
        fos.write("             var manager = $(\"#mainGrid\").ligerGetGridManager();  \n");
        fos.write("             //初始化查询起始页\n");
        fos.write("              manager.set(\"newPage\",1);\n");
        fos.write("              //初始化查询条件\n");
        fos.write("              manager.set(\"parms\",{\"strWhere\":strWhere});\n");
        fos.write("              manager.loadData(true);\n");
        fos.write("        }catch (e) {\n");
        fos.write("                $.ligerDialog.error(e.message);\n");
        fos.write("         }\n");
        fos.write("                 \n");
        fos.write("        } \n");
        fos.write("\n");
      
    }
    
   /**
    * 查询条件
    * @throws IOException
    */
    public void getSearch(List<PtgridscolumnBean>list) throws IOException
    {
        fos.write("        /*根据条件查询*/\n");
        fos.write("     function f_search(){\n");
        fos.write("         try{\n");
        fos.write("              var strWhere = \" \";           \n");
        
        PtgridscolumnBean gridcolumn;
         //初始化查询条件
        for(int i=0;i<list.size();i++)
        {
            gridcolumn = list.get(i);
            fos.write("     //"+gridcolumn.getColumndesc()+"\n");
            fos.write("     var "+gridcolumn.getColumnname()+" = $(\"#"+gridcolumn.getColumnname()+"\").val();\n");
            fos.write("     if("+gridcolumn.getColumnname()+".length>0) {\n");
            fos.write("       strWhere = \" and "+gridcolumn.getColumnname()+" like '%\"+"+gridcolumn.getColumnname()+"+\"%' \";\n");
            fos.write("     }\n");
        }
        fos.write("             var manager = $(\"#mainGrid\").ligerGetGridManager();  \n");
        fos.write("              //manager.loadServerData({strWhere:strWhere},function (countmain) {\n");
        fos.write("             //   alert(countmain);\n");
        fos.write("              //});\n");
        fos.write("              //初始化查询起始页\n");
        fos.write("              manager.set(\"newPage\",1);\n");
        fos.write("              //初始化查询条件\n");
        fos.write("              manager.set(\"parms\",{\"strWhere\":strWhere});\n");
        fos.write("              manager.loadData(true);\n");
        fos.write("             }catch (e) {\n");
        fos.write("                $.ligerDialog.error(e.message);\n");
        fos.write("         }\n");
        fos.write("        }\n");
        fos.write("        \n");
    }
    
    /**
     * 删除方法
     * @throws IOException
     */
    public void getDelete(String id,PtgridsBean ptgrid) throws IOException{
        String namespace = ptgrid.getActionname()+"_"+"delete.action";
        fos.write("        /*删除*/\n");
        fos.write("        function f_remove(){ \n");
        fos.write("        try {\n");
        fos.write("           var node = tree.getSelected(); \n");
        fos.write("           var strId =\"''\";\n");
        fos.write("        var manager = $(\"#mainGrid\").ligerGetGridManager(); \n");
        fos.write("        var selected = manager.getSelectedRows(); \n");
        fos.write("        if (selected==null&&node==null) {\n");
        fos.write("            $.ligerDialog.warn(MSG_NORECORD_SELECT);\n");
        fos.write("        }else{              \n");
        fos.write("            $.ligerDialog.confirm(MSG_DELETE_CONFRIM, function (state)\n");
        fos.write("              {\n");
        fos.write("               if(state)\n");
        fos.write("               {    \n");
        fos.write("                    if(selected!=null&&selected.length>0){\n");
        fos.write("                       for(var i=0;i<selected.length;i++){\n");
        fos.write("                         strId = strId+\",'\"+selected[i]."+id+"+\"'\";\n");
        fos.write("                       }\n");
        fos.write("                    }else{\n");
        fos.write("                       strId = strId+\",'\"+node.data.id+\"'\";\n");
        fos.write("                    }\n");
        fos.write("                    $.post(webpath+\""+namespace+"\",{strSysno:strId},function(data){\n");
        fos.write("                       if(data.checkFlag==MSG_SUCCESS){\n");
        fos.write("                         f_search();                        \n");
        fos.write("                         $.ligerDialog.success(data.checkMessage);\n");
        fos.write("                       }else{\n");
        fos.write("                         $.ligerDialog.error(data.checkMessage);\n");
        fos.write("                       }\n");
        fos.write("                   },\"json\").error(function() { \n");
        fos.write("                             $.ligerDialog.error(MSG_LOAD_FALL)});\n");
        fos.write("                   //去掉节点\n");
        fos.write("                   tree.remove(node.target);\n");
        fos.write("               }\n");
        fos.write("               });                 \n");
        fos.write("        }          \n");
        fos.write("        }catch (e) {\n");
        fos.write("                $.ligerDialog.error(e.message);\n");
        fos.write("         }\n");
        fos.write("        }\n");
        fos.write("        \n");
    }
    
    /**
     * 新建方法
     * @throws IOException
     */
    public void getAdd(String id,PtgridsBean ptgrid)throws IOException{
        String namespace = ptgrid.getActionname()+"_"+"findByKey.action?messageBean.method=add&strSysno=";
        fos.write("        /*新建*/\n");
        fos.write("        function f_add(){\n");
        fos.write("           try {\n");
        fos.write("\n");
        fos.write("           var node = tree.getSelected();\n");
        fos.write("           var manager = $(\"#mainGrid\").ligerGetGridManager(); \n");
        fos.write("        var selected = manager.getSelectedRow(); \n");
        fos.write("        \n");
        fos.write("        var strId;\n");
        fos.write("        \n");
        fos.write("        if(node==null&&selected==null){\n");
        fos.write("         $.ligerDialog.warn(MSG_NORECORD_SELECT);\n");
        fos.write("        }else if(selected !=null){\n");
        fos.write("          strId=selected."+id+";\n");
        fos.write("        }else{\n");
        fos.write("          strId=node.data.id;\n");
        fos.write("        }\n");
        fos.write("        myWindow = $.ligerDialog.open({ url: webpath+\""+namespace+"\"+strId,  width: openWidth,height:openHeight, title: '"+ptgrid.getGriddesc()+"',\n");
        fos.write("        showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); \n");
        fos.write("           f_search();   \n");
        fos.write("        }catch (e) {\n");
        fos.write("                $.ligerDialog.error(e.message);\n");
        fos.write("         }  \n");
        fos.write("        }\n");
        fos.write("        \n");
    }
    
    /**
     * 修改方法
     * @throws IOException
     */
    public void getUpdate(String id,PtgridsBean ptgrid)throws IOException{
        String namespace = ptgrid.getActionname()+"_"+"findByKey.action?messageBean.method=update&strSysno=";
        fos.write("        /*修改*/\n");
        fos.write("        function f_update(){ \n");
        fos.write("         try {\n");
        fos.write("           var node = tree.getSelected(); \n");
        fos.write("           var parent=tree.getParent(node); \n");
        fos.write("        var manager = $(\"#mainGrid\").ligerGetGridManager(); \n");
        fos.write("        var selected = manager.getSelectedRow(); \n");
        fos.write("        var strId;\n");
        fos.write("        if(node==null&&selected==null){\n");
        fos.write("         $.ligerDialog.warn(MSG_NORECORD_SELECT);\n");
        fos.write("        }else if(selected !=null){\n");
        fos.write("          strId=selected.menuid;\n");
        fos.write("        }else{\n");
        fos.write("          strId=node.data.id;\n");
        fos.write("        }\n");
        fos.write("        \n");
        fos.write("        if (strId==null||strId.length == 0) {\n");
        fos.write("             $.ligerDialog.warn(MSG_NORECORD_SELECT);\n");
        fos.write("        }else{\n");
        fos.write("         myWindow = $.ligerDialog.open({url: webpath+\""+namespace+"\"+strId, width: openWidth,height:openHeight, title: '"+ptgrid.getGriddesc()+"',\n");
        fos.write("         showMax: true, showToggle: true, showMin: false, isResize: false, slide: false }); \n");
        fos.write("         f_search(); \n");
        fos.write("        }\n");
        fos.write("        }catch (e) {\n");
        fos.write("                 $.ligerDialog.error(e.message);\n");
        fos.write("       } \n");
        fos.write("        } \n");
        fos.write("        \n");
    }
    
    /**
     * 查看方法
     * @throws IOException
     */
    public void getLOOK(String id,PtgridsBean ptgrid)throws IOException{
        String namespace = ptgrid.getActionname()+"_"+"findByKey.action?messageBean.method=look&strSysno=";
        fos.write("        /*Grid查看*/\n");
        fos.write("        function f_look()\n");
        fos.write("        {\n");
        fos.write("          try {\n");
        fos.write("            var manager = $(\"#mainGrid\").ligerGetGridManager(); \n");
        fos.write("            var selected = manager.getSelectedRow(); \n");
        fos.write("           if (selected==null||selected.length == 0) {\n");
        fos.write("                    $.ligerDialog.warn(MSG_NORECORD_SELECT);\n");
        fos.write("             }else{\n");
        fos.write("                 myWindow = $.ligerDialog.open({url: webpath+\""+namespace+"\"+selected."+id+", width: openWidth,height:openHeight, title: '"+ptgrid.getGriddesc()+"',\n");
        fos.write("                 showMax: true, showToggle: true, showMin: false, isResize: true, slide: false }); \n");
        fos.write("             }\n");
        fos.write("       }catch (e) {\n");
        fos.write("                 $.ligerDialog.error(e.message);\n");
        fos.write("       }\n");
        fos.write("        }\n");
    }
    
    /**
     * tree 添加节点
     * @throws IOException
     */
    public void getTreeAdd(PtgridsBean ptgrid)throws IOException{
        fos.write("       \n");
        fos.write("        /*增加结点*/ \n");
        fos.write("        function node_add(strId){\n");
        fos.write("        try{\n");
        fos.write("         var node = tree.getSelected();\n");
        fos.write("          var nodes = [];         \n");
        fos.write("            $.post(webpath+\"/st/system/action/tree/tree_getTree.action\",{strTreeName:\""+ptgrid.getTreename()+"\",strTreeID:strId},function(data){\n");
        fos.write("                             \n");
        fos.write("               if (node){\n");
        fos.write("               var nodedata = data\n");
        fos.write("               var i=data.length-1;\n");
        fos.write("               nodes.push(data[i]);                \n");
        fos.write("                  tree.append(node.target, nodes);  \n");
        fos.write("                  }  \n");
        fos.write("         },\"json\").error(function() { \n");
        fos.write("                             $.ligerDialog.error(MSG_LOAD_FALL)});\n");
        fos.write("         }catch (e) {\n");
        fos.write("                 $.ligerDialog.error(e.message);\n");
        fos.write("       }\n");
        fos.write("        }\n");
        fos.write("        \n");
    }
    
    
    /**
     * tree 修改节点
     * @throws IOException
     */
    public void getTreeUpate(PtgridsBean ptgrid)throws IOException{
        fos.write("         /*修改结点*/\n");
        fos.write("        function node_modi(strId){\n");
        fos.write("          try{\n");
        fos.write("        var node = tree.getSelected(); \n");
        fos.write("          var nodes = [];     \n");
        fos.write("             $.post(webpath+\"/st/system/action/tree/tree_getTree.action\",{strTreeName:\""+ptgrid.getTreename()+"\",strTreeID:strId,isFlag:\"leafpoint\"},function(data){           \n");
        fos.write("               if (node){\n");
        fos.write("               var nodedata = data;\n");
        fos.write("                      tree.update(node.target,data[0]); \n");
        fos.write("                  }  \n");
        fos.write("              },\"json\").error(function() { \n");
        fos.write("                             $.ligerDialog.error(MSG_LOAD_FALL)});\n");
        fos.write("        }catch (e) {\n");
        fos.write("                 $.ligerDialog.error(e.message);\n");
        fos.write("       }\n");
        fos.write("        }\n");
    }
    
    
    /**
     * 
     * @param ptgrid
     * @throws Exception
     */
    
    
    public void createJS(String  ptgridName)throws Exception
    {
        
        
        
        PtgridsBean ptgrid = new PtgridsBean();
        ptgrid = (PtgridsBean) ptgrid.findFirstByWhere(" where gridname='"+ptgridName+"'");
        
        PtactionsBean ptactions = new PtactionsBean();
        ptactions =  (PtactionsBean) ptactions.findFirstByWhere(" where actionname='"+ptgrid.getActionname()+"'");
        
        
        
        System.out.println(ptgrid.getActionname());
        //查询主键
        String keyid ="";
        PtgridscolumnBean ptgridscolumn=new PtgridscolumnBean();
        List<PtgridscolumnBean> list = ptgridscolumn.findByWhere(" where gridname='"+ptgridName+"'");
        
        
        for(int i=0;i<list.size();i++)
        {
            PtgridscolumnBean gridcolumn = list.get(i);
            PtablecolumnBean ptcolumn = new PtablecolumnBean();
            ptcolumn = (PtablecolumnBean) ptcolumn.findFirstByWhere(" where tablename='"+gridcolumn.getTablename()+"' and iskey='PRI' ");
            //查找id 
            if(ptcolumn!=null)
            {
                keyid = ptcolumn.getColumnname();
            }
        }
        
        
        String gridName = ptgrid.getGridname();
        String jspName = ptgrid.getFieldname();
        String namespace = ptgrid.getFieldpath();
        
        String engPath = Config.getProperty("file");
        String filepath = engPath+"/WebRoot/"+namespace+"/"+jspName;
        
     
       FileOutputStream  stream = new FileOutputStream(filepath+".js"); 

       
       fos = new OutputStreamWriter(stream,"UTF-8"); 
       ptgrid.setActionname(ptactions.getNamespace()+"/"+ptactions.getActionname());
       //创建头文件
       createImport();
       //js参数
       getParam();
       //初始化
       getInit(ptgrid);
       //双击
       getGridDb(keyid,ptgrid);
       //树查询
       getTREE(ptgrid.getTreename());
       //查询
       getSearch(list);
       //删除
       getDelete(keyid, ptgrid);
       //添加
       getAdd(keyid,ptgrid);
       //修改
       getUpdate(keyid,ptgrid);
       //查看
       getLOOK(keyid,ptgrid);
       //tree添加
       getTreeAdd(ptgrid);
       //tree修改
       getTreeUpate(ptgrid);
       fos.write((""));

        
    

       fos.flush();  
        fos.close(); 
     
    }
    
    
   
    }

