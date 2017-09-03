package com.opms.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class PmsExpenses {
    @Override
	public String toString() {
		return "PmsExpenses [expenseid=" + expenseid + ", userid=" + userid + ", amounts=" + amounts + ", types="
				+ types + ", contents=" + contents + ", total=" + total + ", picture=" + picture + ", result=" + result
				+ ", status=" + status + ", approverids=" + approverids + ", created=" + created + ", changed="
				+ changed + "]";
	}

	private Long expenseid;

    private Long userid;

    private String amounts;

    private String types;

    private String contents;

    private String total;

    private String picture;

    private Integer result;

    private Integer status;

    private String approverids;

    private Timestamp created;

    private Timestamp changed;

    public Long getExpenseid() {
        return expenseid;
    }

    public void setExpenseid(Long expenseid) {
        this.expenseid = expenseid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getAmounts() {
        return amounts;
    }

    public void setAmounts(String amounts) {
        this.amounts = amounts;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
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

    public String getApproverids() {
        return approverids;
    }

    public void setApproverids(String approverids) {
        this.approverids = approverids;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getChanged() {
        return changed;
    }

    public void setChanged(Timestamp changed) {
        this.changed = changed;
    }
}