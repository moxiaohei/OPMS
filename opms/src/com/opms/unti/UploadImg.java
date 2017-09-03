package com.opms.unti;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadImg {
	public static String uploadImg(MultipartFile imgFile,String img_name){  
		if(imgFile.isEmpty()){
			return null;
		}
	    //涓婁紶鐨勫浘鐗囩殑鍘熷鍚嶇О  
	    String originalFilename=imgFile.getOriginalFilename(); 
	    String imgFormat = originalFilename.substring(originalFilename.lastIndexOf("."));
	    String img_path=null;
	    String pic_path=null;
	    //涓婁紶鍥剧墖  
	    if(imgFile!=null&&originalFilename!=null&&originalFilename.length()>0){  
	        //瀛樺偍鍥剧墖鐨勭墿鐞嗚矾寰� 
	        pic_path="D:/javacode/MyOPMS/WebRoot/attachment/"; 
	        //鍥剧墖璺緞
	        img_path=img_name+imgFormat;
	        //鏂扮殑鍥剧墖鍚嶇О  
	        File newFile=new File(pic_path+img_name+imgFormat);  
	        //灏嗗唴瀛樹腑鐨勬暟鎹啓鍏ョ鐩� 
	        try {
				imgFile.transferTo(newFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	    }  
	    return pic_path+img_path;
	}  
}
