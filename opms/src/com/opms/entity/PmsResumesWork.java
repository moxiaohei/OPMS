package com.opms.entity;

/**
 * @author mengyongfei
 * @date 2017年7月28日 上午9:48:49
 * 简历中的工作年限
 */
public enum PmsResumesWork {
	
	EMPTY(0,"请选择工作年限"),GRADUATE(1,"应届毕业生"),ONEYEAR(2, "一年以下"),TWOYEAR(3,"1-2年"),FIVEYEAR(4,"3-5年"),SEVENYEAR(5,"6-7年"),TENYEAR(6,"8-10年"),ABOVETEN(7,"10年以上");
	private int pmsResumesWorkindex;
	private String pmsResumesWorkname;
	
	private PmsResumesWork(int pmsResumesWorkindex, String pmsResumesWorkname) {
		this.pmsResumesWorkindex = pmsResumesWorkindex;
		this.pmsResumesWorkname = pmsResumesWorkname;
	}
	public int getPmsResumesWorkindex() {
		return pmsResumesWorkindex;
	}
	public void setPmsResumesWorkindex(int pmsResumesWorkindex) {
		this.pmsResumesWorkindex = pmsResumesWorkindex;
	}
	public String getPmsResumesWorkname() {
		return pmsResumesWorkname;
	}
	public void setPmsResumesWorkname(String pmsResumesWorkname) {
		this.pmsResumesWorkname = pmsResumesWorkname;
	}
	
}
