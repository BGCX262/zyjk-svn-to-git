/*********************************************************************
 *<p>处理内容：后台检查消息封装bean</p>
 *<p>Copyright: Copyright (c) 2011</p>
 * @author 吴业元 改版履历<br>
 * @version Rev - Date ------- Name ---------- Note<br>
 * @------- 1.0 --2011.9.2---- 吴业元 --------- 新规作成<br>
 ***********************************************************************/
package st.portal.action;

public class MessageBean {
    private static final long serialVersionUID = -8324911161163634531L;

    // 成功失败标志位
    private int checkFlag = 1;

    // 检查字段英文名称
    private String widgetName = "";

    // 检查字段汉语名称
    private String widgetLabel = "";

    // widget当前值
    private String widgetValue = "";

    // 警告信息
    private String checkMessage = "";

    // 操作的状态
    private String method = "";

    public int getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(int checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getWidgetValue() {
        return widgetValue;
    }

    public void setWidgetValue(String widgetValue) {
        this.widgetValue = widgetValue;
    }

    public String getCheckMessage() {
        return checkMessage;
    }

    public void setCheckMessage(String checkMessage) {
        this.checkMessage = checkMessage;
    }

    public String getWidgetName() {
        return widgetName;
    }

    public void setWidgetName(String widgetName) {
        this.widgetName = widgetName;
    }

    public String getWidgetLabel() {
        return widgetLabel;
    }

    public void setWidgetLabel(String widgetLabel) {
        this.widgetLabel = widgetLabel;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}