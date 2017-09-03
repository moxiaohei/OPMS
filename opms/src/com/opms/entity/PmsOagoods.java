package com.opms.entity;

import java.sql.Timestamp;
import java.util.Date;

public class PmsOagoods {
    private Long oagoodid;

    private Long userid;

    private String purpose;

    private String names;

    private String quantitys;

    private String content;

    private String picture;

    private Integer result;

    private Integer status;

    private String approverid;

    private Timestamp created;

    private Timestamp changed;

    public Long getOagoodid() {
        return oagoodid;
    }

    public void setOagoodid(Long oagoodid) {
        this.oagoodid = oagoodid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getQuantitys() {
        return quantitys;
    }

    public void setQuantitys(String quantitys) {
        this.quantitys = quantitys;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

   

  

	public Date getCreated() {
        return created;
    }

    

    public Date getChanged() {
        return changed;
    }

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public void setChanged(Timestamp changed) {
		this.changed = changed;
	}

	@Override
	public String toString() {
		return "PmsOagoods [oagoodid=" + oagoodid + ", userid=" + userid
				+ ", purpose=" + purpose + ", names=" + names + ", quantitys="
				+ quantitys + ", content=" + content + ", picture=" + picture
				+ ", result=" + result + ", status=" + status
				+ ", approverid=" + approverid + ", created=" + created
				+ ", changed=" + changed + "]";
	}

	public String getApproverid() {
		return approverid;
	}

	public void setApproverid(String approverid) {
		this.approverid = approverid;
	}

	

	

   
}