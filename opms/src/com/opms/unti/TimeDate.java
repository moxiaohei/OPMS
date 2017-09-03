package com.opms.unti;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.aspectj.apache.bcel.generic.ATHROW;

public class TimeDate {
	//获取时间戳+随机数
    public Long getTimeStampLongDate(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = dateFormat.format(new Date());
		format=format+new Random().nextInt(1000);
		return Long.parseLong(format);
    }
    //将字符串日期转换为Date类型
    public Date getTimeStampDate(String date){
    	Date date2=null;
    	if(date.equals("")||date==null){
    		return null;
    	}
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 date2 = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;
    }
    
  //将字符串日期转换为Date类型
    public Date getDate(String date){
    	Date date2=null;
    	if(date==null || date.equals("")){
    		return null;
    	}
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 date2 = dateFormat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date2;
    }
    //转换日期
    public String changeDate(String Sdate) throws ParseException{
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
   	Date date = sdf.parse(Sdate);	
  	  return (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(date);     
      
    }  
}
