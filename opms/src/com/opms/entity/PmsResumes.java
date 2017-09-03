package com.opms.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class PmsResumes {
    private Long resumeid;//??

    private String realname;//

    private Integer sex;//

    private Date birth;//??

    private Integer edu;//

    private Integer work;//

    private String attachment;//??

    private Integer status;//

    private String note;//

    private String phone;//
    
    private Timestamp created;//
    
	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Long getResumeid() {
        return resumeid;
    }

    public void setResumeid(Long resumeid) {
        this.resumeid = resumeid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getEdu() {
        return edu;
    }

    public void setEdu(Integer edu) {
        this.edu = edu;
    }

    public Integer getWork() {
        return work;
    }

    public void setWork(Integer work) {
        this.work = work;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

	@Override
	public String toString() {
		return "PmsResumes [resumeid=" + resumeid + ", realname=" + realname + ", sex=" + sex + ", birth=" + birth
				+ ", edu=" + edu + ", work=" + work + ", attachment=" + attachment + ", status=" + status + ", note="
				+ note + ", phone=" + phone + ", created=" + created + "]";
	}

}