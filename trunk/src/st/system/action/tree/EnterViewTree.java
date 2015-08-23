/*********************************************************************
 *<p>处理内容：MENU TREE</p>
 *<p>Copyright: Copyright (c) 2013</p>
 * @author 孙雁斌 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.1 --2013.06.16---- 孙雁斌 --------- 新规作成<br>
 ***********************************************************************/
package st.system.action.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import st.platform.db.RecordSet;
import st.system.action.tree.TreeBasic;

public class EnterViewTree extends TreeBasic {

	/**
	 * 取得SQL语句
	 * 
	 * @param accpet
	 * @param syncmodel
	 * @return
	 */
	public String getSQL(String strWhere, String strTreeID, String isFlag) {

		return "";

	}

	/**
	 * 对结果集合进行处理
	 * 
	 * @param accpet
	 * @param syncmodel
	 * @return
	 */
	public List<Map<String, Object>> getTree(RecordSet rs) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "1");
		map.put("pid", "0");
		map.put("text", "用人单位基本信息");
		map.put("url", "/UI/action/enter/EnterMain_findByKey.action");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "2");
		map.put("pid", "0");
		map.put("text", "职业卫生管理机构");
		map.put("url", "/UI/enterfile/zywsgljg/zywsgljgmain.jsp");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "3");
		map.put("pid", "0");
		map.put("text", "接害人员名单");
		map.put("url", "/UI/enterfile/qyryxx/qyryxx.jsp");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "4");
		map.put("pid", "0");
		map.put("text", "职业卫生档案");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "5");
		map.put("pid", "4");
		map.put("text", "规章制度、操作规程");
		map.put("url", "/UI/enterfile/qygzzd/qygzzd.jsp");
		list.add(map);
		
//		map = new HashMap<String, Object>();
//		map.put("id", "6");
//		map.put("pid", "4");
//		map.put("text", "培训信息");
//		map.put("url", "/UI/enterfile/qypxjl/qypxjl.jsp");
//		list.add(map);
        //企业负责人培训
		map = new HashMap<String, Object>();
		map.put("id", "24");
		map.put("pid", "4");
		map.put("text", "企业负责人培训");
		map.put("url", "/UI/enterfile/qypxjl/qypxjl.jsp?zw=01");
		list.add(map);
		//从业人员培训
		map = new HashMap<String, Object>();
		map.put("id", "25");
		map.put("pid", "4");
		map.put("text", "从业人员培训");
		map.put("url", "/UI/enterfile/qypxjl/qypxjl.jsp?zw=02");
		list.add(map);
		
		
		map = new HashMap<String, Object>();
		map.put("id", "7");
		map.put("pid", "4");
		map.put("text", "劳动者职业健康监护档案");
		map.put("url", "/UI/enterfile/ldzjbxx/ldzjbxx.jsp");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("id", "8");
		map.put("pid", "4");
		map.put("text", "新发职业病");
		map.put("url", "/UI/enterfile/qyxfzybxx/qyxfzybxx.jsp");
		list.add(map);
//		 map = new HashMap<String, Object>();
//		 map.put("id", "9");
//		 map.put("pid", "4");
//		 map.put("text", "工作场所职业危害种类清单");
//		 map.put("url", "/UI/enterfile/zywsgljg/zzywsgljg.jsp");
//		 list.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "10");
		map.put("pid", "4");
		map.put("text", "检测、评价报告与记录");
		map.put("url", "/UI/enterfile/jcjgpjbgjbqk/jcjgpjbgjbqk.jsp");
		list.add(map);
		
		
		map = new HashMap<String, Object>();
		map.put("id", "11");
		map.put("pid", "4");
		map.put("text", "职业病危害申报情况");
		map.put("url", "/UI/zyjk/cor/info/enterinfomain.jsp");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "12");
		map.put("pid", "4");
		map.put("text", "职业病防护用品管理");
		map.put("url", "/UI/enterfile/zybfhypgl/zybfhypgl.jsp");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "13");
		map.put("pid", "4");
		map.put("text", "职业病防护用品发放管理");
		map.put("url", "/UI/enterfile/fhypffgl/fhypffgl.jsp");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "15");
		map.put("pid", "4");
		map.put("text", "职业病防护设施");
		map.put("url", "/UI/enterfile/zybfhss/zybfhss.jsp");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("id", "16");
		map.put("pid", "4");
		map.put("text", "职业病危害事故报告与应急处置记录");
		map.put("url", "/UI/enterfile/qyzybsgczjl/qyzybsgczjl.jsp");
		list.add(map);


		map = new HashMap<String, Object>();
		map.put("id", "18");
		map.put("pid", "4");
		map.put("text", "职业卫生安全许可证");
		map.put("url", "/UI/enterfile/zywsxkz/ZywsxkzUpAction_findByKey.action");
		list.add(map);

		//
		 map = new HashMap<String, Object>();
		 map.put("id", "17");
		 map.put("pid", "0");
		 map.put("text", "建设项目三同时");
		 map.put("url", "/UI/zyjk/jsxmsts/qyjsxmlist.jsp");
		 list.add(map);
		 
		map = new HashMap<String, Object>();
		map.put("id", "19");
		map.put("pid", "0");
		map.put("text", "基础建设");
		//map.put("url","");
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("id", "20");
		map.put("pid", "19");
		map.put("text", "自查自纠填报");
		map.put("url","/UI/action/zyjk/ZczjAction_getTBZczjList.action?messageBean.method=add&zbid=T_YHZC_BZZB370000130605000001");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("id", "23");
		map.put("pid", "19");
		map.put("text", "历史查询");
		map.put("url","/UI/zczj/qyzczjlist.jsp?zbid=T_YHZC_BZZB370000130605000001");
		list.add(map);
		
		
		map = new HashMap<String, Object>();
		map.put("id", "21");
		map.put("pid", "19");
		map.put("text", "整改情况");
		map.put("url","/UI/zczj/bhglist.jsp");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("id", "22");
		map.put("pid", "0");
		map.put("text", "密码修改");
		map.put("url","/UI/system/user/qymodifypass.jsp");
		list.add(map);

		return list;
	}

}
