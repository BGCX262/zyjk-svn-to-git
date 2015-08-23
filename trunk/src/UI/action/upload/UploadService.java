package UI.action.upload;

import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import UI.util.BusinessDate;

import st.platform.db.ConnectionManager;
import st.platform.db.DatabaseConnection;
import st.platform.db.SerialNumber;
import st.platform.utils.Config;

/**
 * @author closewubq
 */
public class UploadService {



	
	/**
	 * 
	 * @param file
	 *            主要上传的文件对象，也包括图片类型
	 * @param fileFileName
	 *            文件名称
	 * @param key
	 * @param type
	 *            1:图片 0：文件
	 * @return String 返回文件存放的实际路径,并删除原文件
	 * @throws Exception
	 */
	public String uploadFile(File file, String fileFileName, String type,String ssbm,String keyname,String keyvalue, String oldFile,ConnectionManager cmm){
		int count=0;
		DatabaseConnection dcc = cmm.get();
		dcc.begin();
		
		
		ServletContext context = ServletActionContext.getServletContext();
		String oldFilePath = "";
		String targetDirectory = null;
		String filetype = fileFileName.substring(fileFileName.lastIndexOf("."));// 附件后缀名
		String filename = System.currentTimeMillis() + filetype;
		// String filename=System.currentTimeMillis()+fileFileName;
		String path = Config.getProperty("zywsxkz");
		try {
			if ("1".equals(type)) {
				path = Config.getProperty("jcbg");
			} else if ("3".equals(type)) {
				path = Config.getProperty("userimage");
			}else if ("4".equals(type)) {
				path = Config.getProperty("gylc");
			}else if ("5".equals(type)) {
				path = Config.getProperty("jcbdt");
			}
			targetDirectory = context.getRealPath(path);
			File target = new File(targetDirectory, filename);
			FileUtils.copyFile(file, target);
			path += "/" + filename;
			// 删除原文件
			if (!oldFile.equals("/images/none.jpg")) {
				oldFilePath = context.getRealPath(oldFile);
				File oldFile2 = new File(oldFilePath);
				if (oldFile2.exists()) {
					oldFile2.delete();
				}

			}
			//保存数据库
			//取得文件流
		   FileInputStream fis = new FileInputStream(file);  
		   String number = Config.getProperty("distcode")+"-"+BusinessDate.getNoFormatToday() + "-" + SerialNumber.getNextSerialNo("180");
		   
		   String sql="insert into filetable (synso,fjlx,wjgs,ssbm,keyname,keyvalue,filecontent,cflj) values(?,?,?,?,?,?,?,?)";
		   PreparedStatement pst=dcc.getPreparedStatement(sql);
		   pst.setString(1, number);
		   pst.setString(2, type);
		   pst.setString(3, filetype);
		   pst.setString(4, ssbm);
		   pst.setString(5, keyname);
		   pst.setString(6, keyvalue);
		   pst.setBlob(7, fis, fis.available());
		   pst.setString(8, path);
		   count=pst.executeUpdate();
		   
		   return path;// 保存文件的存放路径
		} catch (Exception e) {
			return "";
		}finally{
			if(count>0){
				dcc.commit();
			}else{
				dcc.rollback();
			}
		}

	}

	/**
	 * 
	 * @param file 用于更新
	 *            主要上传的文件对象，也包括图片类型
	 * @param fileFileName
	 *            文件名称
	 * @param key
	 * @param type
	 *            1:图片 0：文件
	 * @return String 返回文件存放的实际路径,并删除原文件
	 * @throws Exception
	 */
	public String uploadUpdateFile(File file, String fileFileName, String type,String ssbm,String keyname,String keyvalue, String oldFile,ConnectionManager cmm){
		int count=0;
		DatabaseConnection dcc = cmm.get();
		dcc.begin();
		
		
		ServletContext context = ServletActionContext.getServletContext();
		String oldFilePath = "";
		String targetDirectory = null;
		String filetype = fileFileName.substring(fileFileName.lastIndexOf("."));// 附件后缀名
		String filename = System.currentTimeMillis() + filetype;
		// String filename=System.currentTimeMillis()+fileFileName;
		String path = Config.getProperty("zywsxkz");
		try {
			if ("1".equals(type)) {
				path = Config.getProperty("jcbg");
			} else if ("3".equals(type)) {
				path = Config.getProperty("userimage");
			}else if ("4".equals(type)) {
				path = Config.getProperty("gylc");
			}else if ("5".equals(type)) {
				path = Config.getProperty("jcbdt");
			}
			targetDirectory = context.getRealPath(path);
			File target = new File(targetDirectory, filename);
			FileUtils.copyFile(file, target);
			path += "/" + filename;
			// 删除原文件
			if (!oldFile.equals("/images/none.jpg")) {
				oldFilePath = context.getRealPath(oldFile);
				File oldFile2 = new File(oldFilePath);
				if (oldFile2.exists()) {
					oldFile2.delete();
				}

			}
			//保存数据库
			//取得文件流
		   FileInputStream fis = new FileInputStream(file);  
		   
		  // String sql="insert into filetable (synso,fjlx,wjgs,ssbm,filecontent,cflj) values(?,?,?,?,?,?)";
		   String sql="update filetable set fjlx=?,wjgs=?,filecontent=?,cflj=? where ssbm='"+ssbm+"' and keyname='"+keyname+"' and keyvalue='"+keyvalue+"'";
		   PreparedStatement pst=dcc.getPreparedStatement(sql);
		   //pst.setString(1, number);
		   pst.setString(1, type);
		   pst.setString(2, filetype);
		   pst.setBlob(3, fis, fis.available());
		   pst.setString(4, path);
		   count=pst.executeUpdate();
		   
		   return path;// 保存文件的存放路径
		} catch (Exception e) {
			return "";
		}finally{
			if(count>0){
				dcc.commit();
			}else{
				dcc.rollback();
			}
		}

	}
	/**
	 * 
	 * TODO上传文件大小限制
	 * 
	 * @param file
	 *            上传文件
	 * @param maxSize
	 *            限制大小
	 * @return 返回长度大于零为返回信息
	 */
	public static String valFileSize(File file, int maxSize) {
		String returnStr = "";
		DecimalFormat df = new DecimalFormat("#.##");
		try {
			// FileInputStream fis= new FileInputStream(file);
			long fileSize = file.length();
			// maxSize单位为KB
			if (fileSize > maxSize * 1024) {
				double lFileSize = fileSize / 1024.0 / 1024.0;
				double lMaxSize = maxSize / 1024.0;
				returnStr = "上传文件不得超过" + df.format(lMaxSize) + "M,当前大小为" + df.format(lFileSize)
						+ "M!";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return returnStr;
	}

}
