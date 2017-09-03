package com.opms.unti;

import java.util.HashMap;
import java.util.Map;

public class BugState {
	public static Map map = new HashMap<>();
	static {
		map.put(1, "设计如此");
		map.put(2, "重复Bug");
		map.put(3, "外部原因");
		map.put(4, "已解决");
		map.put(5, "无法重现");
		map.put(6, "延期处理");
		map.put(7, "不予解决");
	}
	public static String getState(int s){
		return (String) map.get(s);
	}
}
