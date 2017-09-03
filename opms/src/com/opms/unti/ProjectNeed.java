package com.opms.unti;

public class ProjectNeed {
	
	public static String getStatus(Integer status){
		int s = status.intValue();
		if(s == 1){
			return "草稿";
		}
		if(s == 2){
			return "激活";
		}
		if(s == 3){
			return "已变更";
		}
		if(s == 4){
			return "待关闭";
		}
		if(s == 5){
			return "已关闭";
		}
		return "无";
	}
	
	public static String getStage(Integer stage){
		int s = stage.intValue();
		switch(s){
		case(1):
			return "未开始";
		case(2):
			return "已计划";
		case(3):
			return "已立项";
		case(4):
			return "研发中";
		case(5):
			return "研发完毕";
		case(6):
			return "测试中";
		case(7):
			return "测试完毕";
		case(8):
			return "已验收";
		case(9):
			return "已发布";
		default:
			return "无";
		}
	}
	public static String getSource(Integer source){
		int s = source.intValue();
		switch(s){
		case(1):
			return "客户";
		case(2):
			return "用户";
		case(3):
			return "产品经理";
		case(4):
			return "市场";
		case(5):
			return "客服";
		case(6):
			return "竞争对手";
		case(7):
			return "合作伙伴";
		case(8):
			return "开发人员";
		case(9):
			return "测试人员";
		case(10):
			return "其他";
		default:
			return "无";
		}
	}
}
