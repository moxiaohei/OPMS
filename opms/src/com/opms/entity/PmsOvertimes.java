package com.opms.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class PmsOvertimes {




	@Override
	public String toString() {
		return "PmsOvertimes [overtimeid=" + overtimeid + ", userid=" + userid + ", started=" + started + ", ended="
				+ ended + ", longtime=" + longtime + ", holiday=" + holiday + ", way=" + way + ", reason=" + reason
				+ ", result=" + result + ", status=" + status + ", approverids=" + approverids + ", created=" + created
				+ ", changed=" + changed + "]";
	}

	private Long overtimeid;

    private Long userid;

    private String started;

    private String ended;
    
    private Integer longtime;

    private Integer holiday;

    private Integer way;

    private String reason;

    private Integer result;

    private Integer status;

    private String approverids;

    private Timestamp created;

    private Timestamp changed;
    
    public String getStarted() {
		return started;
	}

	public void setStarted(String started) {
		this.started = started;
	}

	public String getEnded() {
		return ended;
	}

	public void setEnded(String ended) {
		this.ended = ended;
	}
    
    public Long getOvertimeid() {
        return overtimeid;
    }

    public void setOvertimeid(Long overtimeid) {
        this.overtimeid = overtimeid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

   
    public Integer getLongtime() {
        return longtime;
    }

    public void setLongtime(Integer longtime) {
        this.longtime = longtime;
    }

    public Integer getHoliday() {
        return holiday;
    }

    public void setHoliday(Integer holiday) {
        this.holiday = holiday;
    }

    public Integer getWay() {
        return way;
    }

    public void setWay(Integer way) {
        this.way = way;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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