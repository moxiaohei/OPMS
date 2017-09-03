package com.opms.entity;

/**
 * @author mengyongfei
 * @date 2017年7月27日 下午5:20:35
 * 简历中的学历实体类
 */
public enum PmsResumesEducation {

	EMPTY(0,"请选择学历"),PRIMARY(1,"小学"),SECONDARY(2,"中专"),JUNIOR_HIGH(3,"初中"),SENIOR(4,"高中"),TECHNICAL(5,"技校"),
	JUNIOR_COLLEGUE(6,"大专"),REGULAR(7,"本科"),MASTER(8,"硕士"),DOCTOR(9,"博士"),POSTDOCTOR(10,"博士后");
	
	private int pmsResumesEducationindex;
	private String pmsResumesEducationname;
	
	private PmsResumesEducation(int pmsResumesEducationindex, String pmsResumesEducationname) {
		this.pmsResumesEducationindex = pmsResumesEducationindex;
		this.pmsResumesEducationname = pmsResumesEducationname;
	}

	public int getPmsResumesEducationindex() {
		return pmsResumesEducationindex;
	}

	public void setPmsResumesEducationindex(int pmsResumesEducationindex) {
		this.pmsResumesEducationindex = pmsResumesEducationindex;
	}

	public String getPmsResumesEducationname() {
		return pmsResumesEducationname;
	}

	public void setPmsResumesEducationname(String pmsResumesEducationname) {
		this.pmsResumesEducationname = pmsResumesEducationname;
	}

}
