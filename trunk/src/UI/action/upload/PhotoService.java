package UI.action.upload;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import st.portal.action.BasicAction;
@ParentPackage("struts-filter")
@Namespace("/UI/action/photo") 
public class PhotoService extends BasicAction{

	private File file;

	private String fileFileName;
	
	private String timeseria;
	
	
	public String getTimeseria() {
		return timeseria;
	}

	public void setTimeseria(String timeseria) {
		this.timeseria = timeseria;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	 @Action(value = "PhotoService_uploadImage") 
	public String uploadImage(){
			 if (file != null) {
				//if(Config.getProperty("photoState").equals("1")){
			         FileUploadService fs = new FileUploadService();
			             try {
							String path = fs.uploadHeadIcon(file, fileFileName, timeseria, "");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					
				}
			// } 
			 return null;
	}
}
