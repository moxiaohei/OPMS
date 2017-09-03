package com.opms.unti;

public class ProjectTask {
	
	public static String getType(Integer type){
		int t = type.intValue();
		switch(t){
		case(1):
			return "设计";
		case(2):
			return "开发";
		case(3):
			return "测试";
		case(4):
			return "研究";
		case(5):
			return "讨论";
		case(6):
			return "界面";
		case(7):
			return "事务";
		case(8):
			return "其他";
		default:
			return "无";
		}
	}
	
	public static String getStatus(Integer status){
		int s = status.intValue();
		switch(s){
		case(1):
			return "未开始";
		case(2):
			return "进行中";
		case(3):
			return "已完成";
		case(4):
			return "已暂停";
		case(5):
			return "已取消";
		case(6):
			return "已关闭";
		default:
			return "无";
		}
	}
}
