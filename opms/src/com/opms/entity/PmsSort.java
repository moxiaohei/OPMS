package com.opms.entity;

public enum PmsSort {
	culture(1,"企业文化"),knowledge(2,"管理知识"),money(3,"财务知识"),show(4,"技术分享"),server(5,"服务器"),marketing(6,"市场营销"),operative(7,"运营"),essay(8,"随笔");
	private int index;
	private String name;
	private PmsSort(int i,String names)
	{
		index=i;
		name=names;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}                     
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
 
}
