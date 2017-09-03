package com.opms.entity;

import java.util.Date;

public class PmsProjectsTask {
    private Long taskid;

    private Long needsid;

    private Long userid;

    private Long projectid;

    private Long acceptid;

    private String ccid;

    private Long completeid;

    private String name;

    private Integer type;

    private Integer level;

    private Integer tasktime;

    private Date ended;

    private Date started;

    private String attachment;

    private Date created;

    private Date changed;

    private Integer status;

    private Long closeid;

    private Long cancelid;
    
    private String taskStatus;
    
    private String endDate;
    
    private String userName;
    
    private String acceptName;
    
    private String finishName;
    
    private String needName;
    
    private String description;
    
    private String note;
    
    private String projectName;
    
    private String taskType;
    
    private String startDate;
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	@Override
	public String toString() {
		return "PmsProjectsTask [taskid=" + taskid + ", needsid=" + needsid
				+ ", userid=" + userid + ", projectid=" + projectid
				+ ", acceptid=" + acceptid + ", ccid=" + ccid + ", completeid="
				+ completeid + ", name=" + name + ", type=" + type + ", level="
				+ level + ", tasktime=" + tasktime + ", ended=" + ended
				+ ", started=" + started + ", attachment=" + attachment
				+ ", created=" + created + ", changed=" + changed + ", status="
				+ status + ", closeid=" + closeid + ", cancelid=" + cancelid
				+ ", taskStatus=" + taskStatus + ", endDate=" + endDate
				+ ", userName=" + userName + ", acceptName=" + acceptName
				+ ", finishName=" + finishName + ", needName=" + needName
				+ ", description=" + description + ", note=" + note
				+ ", projectName=" + projectName + ", taskType=" + taskType
				+ ", startDate=" + startDate + "]";
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getNeedName() {
		return needName;
	}

	public void setNeedName(String needName) {
		this.needName = needName;
	}

	public Date getEnded() {
		return ended;
	}

	public void setEnded(Date ended) {
		this.ended = ended;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getChanged() {
		return changed;
	}

	public void setChanged(Date changed) {
		this.changed = changed;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAcceptName() {
		return acceptName;
	}

	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
	}

	public String getFinishName() {
		return finishName;
	}

	public void setFinishName(String finishName) {
		this.finishName = finishName;
	}

	public Long getTaskid() {
        return taskid;
    }

    public void setTaskid(Long taskid) {
        this.taskid = taskid;
    }

    public Long getNeedsid() {
        return needsid;
    }

    public void setNeedsid(Long needsid) {
        this.needsid = needsid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public Long getAcceptid() {
        return acceptid;
    }

    public void setAcceptid(Long acceptid) {
        this.acceptid = acceptid;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public Long getCompleteid() {
        return completeid;
    }

    public void setCompleteid(Long completeid) {
        this.completeid = completeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getTasktime() {
        return tasktime;
    }

    public void setTasktime(Integer tasktime) {
        this.tasktime = tasktime;
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

    public Long getCloseid() {
        return closeid;
    }

    public void setCloseid(Long closeid) {
        this.closeid = closeid;
    }

    public Long getCancelid() {
        return cancelid;
    }

    public void setCancelid(Long cancelid) {
        this.cancelid = cancelid;
    }
}