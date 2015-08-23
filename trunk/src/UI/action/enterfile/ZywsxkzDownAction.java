/****************************************************
 * <p>处理内容：</p>
 * <p>Copyright: Copyright (c) 2013</p>;
 * @author  孙雁斌;
 * 改版履历;
 * Rev - Date ------- Name ---------- Note -------------------
 * 1.0  2013-06-08     孙雁斌          新規作成 ;
 ****************************************************/
package UI.action.enterfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;

/**
 * 所下载文件相关的的几个属性:文件格式 contentType, 
 * 获取文件名的方法inputName,
 * 文件内容（显示的）属性contentDisposition, 
 * 限定下载文件 缓冲区的值bufferSize
 * */
@ParentPackage("struts-filter")
@Namespace("/down")
@Action("download")
@Results({ @Result(name = "success", type = "stream", params = { "contentType",
		"application/octet-stream;charset=ISO8859-1", "inputName",
		"inputStream", "contentDisposition",
		"attachment;filename=\"Readme.txt\"", "bufferSize", "4096" }) })
public class ZywsxkzDownAction extends ActionSupport {

	private static final long serialVersionUID = 8784555891643520648L;
	private String STORAGEPATH = "/upload/Readme.txt";

	private String fileName;// 初始的通过param指定的文件名属性
	private String storageId;
	private String inputPath;// 指定要被下载的文件路径

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	// 如果下载文件名为中文，进行字符编码转换
	public String getDownloadFileName() {
		String downloadFileName = fileName;

		try {
			downloadFileName = new String(downloadFileName.getBytes(),
					"ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return downloadFileName;
	}

	public InputStream getInputStream() throws Exception {
		/**
		 * 下载用的Action应该返回一个InputStream实例， 
		 * 该方法对应在result里的inputName属性值为targetFile
		 **/
		return ServletActionContext.getServletContext().getResourceAsStream(
				STORAGEPATH);
	}

	public String execute() throws Exception {
		return SUCCESS;
	}

}
