package com.opms.unti;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringDate {
	//时间戳+随机数
	public String getTimeStampStringDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String format = dateFormat.format(new Date());
		format = format + new Random().nextInt(1000);
		return format;
	}
	//获取当前字符串时间
	public String getNowStringDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = dateFormat.format(new Date());
		return format;
	}

	//日期格式转换为字符串时间戳日期
	public String getStringTimeStampDate(Date date){
		if(date==null){
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	//日期格式转换为字符串日期
	public String getStringDate(Date date){
		if(date==null){
			return null;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}
}
