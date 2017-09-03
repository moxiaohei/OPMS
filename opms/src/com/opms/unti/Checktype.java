package com.opms.unti;

public enum Checktype {
	clock(0,"打卡状态"),normal(1,"正常"),late(2,"迟到"),early(3,"早退"),overtime(4,"加班");
	private int index;
	private String type;
	private  Checktype(int _index,String _type){
		index=_index;
		type=_type;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
