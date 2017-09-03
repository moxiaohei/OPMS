package com.opms.unti;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IntDate {
    public Long getTimeStampLongDate(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
		String format = dateFormat.format(new Date());
		format=format+new Random().nextInt(1000);
		return Long.parseLong(format);
    }
    public int getNowIntDate(){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		String format = dateFormat.format(new Date());
		return Integer.parseInt(format);
    }
    public int getIntDate(String date){
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		String format = dateFormat.format(date);
		return Integer.parseInt(format);
    }
}
