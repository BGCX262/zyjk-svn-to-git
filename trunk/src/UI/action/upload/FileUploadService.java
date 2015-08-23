package UI.action.upload;

import java.io.File;
import java.text.DecimalFormat;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import st.platform.utils.Config;

/**
 * @author closewubq
 */
public class FileUploadService {

	

	/**
	 * 
	 * @param file
	 *            上传的文件对象
	 * @param fileFileName
	 *            文件名称
	 * @param key
	 * @param type
	 *            1:图片 0：文件
	 * @return String 返回文件存放的实际路径
	 * @throws Exception
	 */
	public String uploadFile(File file, String fileFileName, String type) throws Exception {

		ServletContext context = ServletActionContext.getServletContext();
		String targetDirectory = null;
		String filetype = fileFileName.substring(fileFileName.lastIndexOf("."));// 附件后缀名
		String filename = System.currentTimeMillis() + filetype;
		// String filename=System.currentTimeMillis()+fileFileName;
		String path = Config.getProperty("fjuppath");
		try {
			if ("0".equals(type)) {
				path = Config.getProperty("fjuppath");
			} else if ("1".equals(type)) {
				path = Config.getProperty("picuppath");
			} else if ("3".equals(type)) {
				path = Config.getProperty("userimage");
			}
			targetDirectory = context.getRealPath(path);
			// File target = new File(targetDirectory, System.currentTimeMillis()+fileFileName);
			File target = new File(targetDirectory, filename);
			FileUtils.copyFile(file, target);
			path += "/" + filename;
			// return target.getPath();// 保存文件的存放路径
			return path;// 保存文件的存放路径
		} catch (Exception e) {
			return "";
		}

	}

	public String uploadJar(File file, String fileFileName, String filedir) throws Exception {

		ServletContext context = ServletActionContext.getServletContext();
		String targetDirectory = null;
		String filename = System.currentTimeMillis() + fileFileName;

		try {
			File dir = new File(filedir);
			if (dir.isDirectory()) {
				if (!dir.exists()) {
					dir.mkdir();
				}
			}

			targetDirectory = context.getRealPath(filedir);
			// File target = new File(targetDirectory, System.currentTimeMillis()+fileFileName);
			File target = new File(targetDirectory, filename);
			FileUtils.copyFile(file, target);
			filedir += "/" + filename;
			// return target.getPath();// 保存文件的存放路径
			return filedir;// 保存文件的存放路径
		} catch (Exception e) {
			return "";
		}

	}

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
	public String uploadFile(File file, String fileFileName, String type, String oldFile)
			throws Exception {

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

			return path;// 保存文件的存放路径
		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * 
	 * @param file
	 *            主要上传的图片对象，也包括其他类型
	 * @param fileFileName
	 *            文件名称
	 * @param key
	 * @param type
	 *            1:图片 0：文件
	 * @return String 返回文件存放的实际路径,并删除原文件
	 * @throws Exception
	 */
	public String uploadImage(File file, String fileFileName, String type, String oldFile)
			throws Exception {

		ServletContext context = ServletActionContext.getServletContext();
		String oldFilePath = "";
		String targetDirectory = null;
		String filetype = fileFileName.substring(fileFileName.lastIndexOf("."));
		String filename = System.currentTimeMillis() + filetype;
		String path = Config.getProperty("gzzd");
		try {
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
			return path;// 保存文件的存放路径
		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * 上传头像
	 * 
	 * @param file
	 *            主要上传的图片对象
	 * @param fileFileName
	 *            文件名称
	 * @param timeseria 时间序列号，用于作为文件名
	 * @param oldFile 原文件名，当上传新的图片时，删除原来的
	 * @return String 返回文件存放的实际路径,并删除原文件
	 * @throws Exception
	 */
	public String uploadHeadIcon(File file, String fileFileName, String timeseria, String oldFile)
			throws Exception {

		ServletContext context = ServletActionContext.getServletContext();
		String oldFilePath = "";
		String targetDirectory = null;
		String filetype = fileFileName.substring(fileFileName.lastIndexOf("."));
		String filename = timeseria + filetype;
		String path = Config.getProperty("image");
		try {

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
			return path;// 保存文件的存放路径
		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * 
	 * @param file
	 *            上传的文件对象,主要上传图片，以便预览
	 * @param fileFileName
	 *            文件名称
	 * @param key
	 * @return String 返回文件存放的实际路径
	 * @throws Exception
	 */
	public String uploadImage(File file, String fileFileName, String type) throws Exception {

		ServletContext context = ServletActionContext.getServletContext();
		String targetDirectory = null;
		String filetype = fileFileName.substring(fileFileName.lastIndexOf("."));// 后去后缀名
		String filename = System.currentTimeMillis() + filetype;
		String path = Config.getProperty("picuppath");
		try {
			if ("1".equals(type)) {
				path = Config.getProperty("fjuppath");
			} else if ("3".equals(type)) {
				path = Config.getProperty("userimage");
			}
			targetDirectory = context.getRealPath(path);
			File target = new File(targetDirectory, filename);
			FileUtils.copyFile(file, target);
			path += "/" + filename;
			return path;// 保存文件的存放路径
		} catch (Exception e) {
			return "";
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
