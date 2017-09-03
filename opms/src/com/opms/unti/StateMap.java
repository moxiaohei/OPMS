package com.opms.unti;

import java.util.HashMap;
import java.util.Map;

public class StateMap {
    public static Map m=new HashMap<String,String>();
    static{
    	m.put("1", "挂起中");
    	m.put("2", "延迟");
    	m.put("3", "进行");
    	m.put("4", "结束");
    }
    public static String getState(String i){
    	System.out.println(i+".................");
    	return (String) m.get(i);
    }
}
