package worksynch.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FileDowmUtil {
	/**
	 * Description: 从FTP服务器下载文件
	 * @Version1.0 jmx
	 * @param url FTP服务器hostname
	 * @param port FTP服务器端口
	 * @param username FTP登录账号
	 * @param password FTP登录密码
	 * @param remotePath FTP服务器上的相对路径
	 * @param fileName 要下载的文件名
	 * @param localPath 下载后保存到本地的路径
	 * @param newfilename 新文件名字
	 * @return
	 */
	public static boolean downFile(String url, int port,String username, String password, String remotePath,String fileName,String localPath,String newfilename) {
		boolean success = false;
		FTPClient ftp = new FTPClient();
		try {
			int reply;
			//ftp.connect(url, port);
			ftp.connect(url);
			//如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);//登录
			reply = ftp.getReplyCode();
			System.out.println(reply);
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
//			ftp.changeWorkingDirectory(remotePath);//转移到FTP服务器目录
//			FTPFile[] fs = ftp.listFiles();
//			for(FTPFile ff:fs){
//				if(ff.getName().equals(fileName)){
//					File localFile = new File(localPath+"/"+newfilename);
//					System.out.println("wwwwwwwwwwww:"+newfilename);
//					OutputStream is = new FileOutputStream(localFile); 
//					ftp.retrieveFile(ff.getName(), is);
//					is.close();
//				}
//			}
//			
			String remoteFileName=remotePath+fileName;
			OutputStream fos = new FileOutputStream(localPath+newfilename);
            //ftpClient.setControlEncoding("GB18030");
			ftp.setBufferSize(1024);
            //设置文件类型（二进制）
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.retrieveFile(remoteFileName, fos);
			ftp.logout();
			success = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return success;
	}
	
	public static String getImagePath(String path){
		String newpath="";
		String[] vals={};
		if(path.length()>0){
			vals=path.split("-");
			if(vals.length>1){
				newpath=vals[0]+"/"+vals[1];
			}
		}
		return newpath;
	}
}
