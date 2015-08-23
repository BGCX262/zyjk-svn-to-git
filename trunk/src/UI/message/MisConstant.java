/*********************************************************************
 *<p>处理内容：系统常量类</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 方立文 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2013.3.2---- 方立文 --------- 新规作成<br>
 ***********************************************************************/
package UI.message;
public class MisConstant {
   
    // -----------------------------系統提示消息----------------------------------------
    public static final String MSG_NO_DATA = "无取得数据!";
    public static final String MSG_LOADING = "正在加载…";

    public static final String MSG_DELETE_SUCCESS = "删除成功！";
    public static final String MSG_DELETE_FAIL = "删除失败！";
    
    public static final String MSG_VERI_FAIL = "验证码输入有误！";
    
    public static final String MSG_OPERATE_FAIL = "操作失败！";
    public static final String MSG_OPERATE_SUCCESS = "操作成功！";

    // -----------------------------Struts返回状态----------------------------------------
    
    //返回操作的状态
    public static final String RETMESSAGE = "RETMESSAGE";
    //查询返回列表集合
    public static final String FINDLIST = "FINDLIST";
    //返回查询页面
    public static final String FINDBYKEY = "FINDBYKEY";
    //返回查询json
    public static final String FINDOBJSON = "FINDOBJSON";
    //
    public static final String TIME_OUT = "TIME_OUT";
    
    
    //返回树的状态
    public static final String TREELIST = "TREELIST";
    

    //返回table标题
    public static final String TABLECOLUMN="TABLECOLUMN";
    
    // 成功返回常数
    public static final int MSG_SUCCESS = 1;
    // 失败返回常数
    public static final int MSG_FAIL = 0;
    
    // CZZT操作状态(0:添加，1:修改，2:删除)
    public static final String FIELD_CZZT_ADD = "0";
    public static final String FIELD_CZZT_UPDATE = "1";
    public static final String FIELD_CZZT_DELETE = "2";

    // ----------------------------------警告消息------------------------------------
    // 检查重复值消息
    public static final String WARN_UPDATE_DUPLICATE = "该记录已存在，请确认！";
    // 检查重复值消息
    public static final String WARN_REG_DUPLICATE = "该企业已注册，请确认！";
    // 企业自查某月重复值消息
    public static final String WARN_ZCMONTH_DUPLICATE = "当前月已填写自查信息，请直接修改！";
    // 无对应的执法检查记录
    public static final String WARN_ZFJC_NULL = "无对应的执法检查记录！";
    // 无对应的督察督办记录
    public static final String WARN_DCDB_NULL = "无对应的挂牌督办记录！";
    // 无对应的企业自查记录
    public static final String WARN_QYZC_NULL = "无对应的企业自查记录！";
    // 乐观锁检查
    public static final String WARN_UPDATE_CONFLICT = "该记录已由其他终端更新，请重新加载本页面进行修改！";
    // 节点删除检查
    public static final String WARN_DELETE_PARENT = "该记录存在下级节点，请先对下级节点进行删除！";

    // ----------------------------------错误消息------------------------------------

    // ----------------------------- 系统中常量字段名称------------------------------

    public static final String FIELD_LABEL_WGHNAME = "网格名称";
    public static final String FIELD_LABEL_WGHCODE = "网格编号";
    public static final String FIELD_LABEL_DWMC = "单位名称";
    public static final String FIELD_LABEL_GSZCH = "单位工商注册号";
    public static final String FIELD_LABEL_DWZZDM = "单位组织代码";
    public static final String FIELD_LABEL_ZGZNUMBER = "许可证编号";
    public static final String FIELD_LABEL_XH = "序号";

    public static final String FIELD_LABEL_ZGHBH = "资格证编号";

    public static final String FIELD_LABEL_DEPTNUMBER = "部门编号";

    public static final String FIELD_LABEL_DEPTENAME = "监管部门名称";

    public static final String FIELD_LABEL_PEOPLE = "监管部门名称";

    public static final String FIELD_LABEL_MJZ = "枚举值";

    public static final String FIELD_LABEL_MJWZ = "枚举文字";

    public static final String FIELD_LABEL_MJNUMBER = "枚举编号";

    public static final String FIELD_LABEL_MJNAME = "枚举名称";

    public static final String FIELD_LABEL_SJJID = "数据集ID";
    
    public static final String FIELD_LABEL_SJJZD = "字段";

    public static final String FIELD_LABEL_ZYNAME = "资源名称";

    public static final String FIELD_LABEL_ZYPATH = "资源路径";

    public static final String FIELD_LABEL_ROLENAME = "角色名称";

    public static final String FIELD_LABEL_USERNAME = "用户名";
}
