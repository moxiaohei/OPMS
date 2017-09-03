package com.opms.entity;

/**
 * @author mengyongfei
 * @date 2017年7月27日 下午5:20:35
 * 简历中的学历实体类
 */
public enum PmsResumesState {

	PART(1,"入档"),INTERVIEW(2,"通知面试"),VIOLATION(3,"违约"),EMOLOYMENT(4,"录用"),NOHIRE(5,"不录用");
	
	private int pmsResumesStateindex;
	private String pmsResumesStatename;
	
	private PmsResumesState(int pmsResumesStateindex, String pmsResumesStatename) {
		this.pmsResumesStateindex = pmsResumesStateindex;
		this.pmsResumesStatename = pmsResumesStatename;
	}
	public int getPmsResumesStateindex() {
		return pmsResumesStateindex;
	}
	public void setPmsResumesStateindex(int pmsResumesStateindex) {
		this.pmsResumesStateindex = pmsResumesStateindex;
	}
	public String getPmsResumesStatename() {
		return pmsResumesStatename;
	}
	public void setPmsResumesStatename(String pmsResumesStatename) {
		this.pmsResumesStatename = pmsResumesStatename;
	}
	
}
