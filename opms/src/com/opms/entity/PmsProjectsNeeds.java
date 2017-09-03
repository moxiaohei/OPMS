package com.opms.entity;

import java.util.Date;

public class PmsProjectsNeeds {
    private Long needsid;

    private Long projectid;

    private Long userid;

    private String name;

    private Long acceptid;

    private Integer source;

    private Integer level;

    private Integer tasktime;

    private String attachment;

    private Date created;
    
    private String createTime;
    
    private String changeTime;
    
    private String username;

    private String acceptname;
    
    private Date changed;

    private Integer stage;

    private Integer status;
    
    private String description;

    private String acceptance;
    
    private String needStatus;
    
    private String needStage;
    
    private String needSource;
    
    private String projectName;
    
    
   
	@Override
	public String toString() {
		return "PmsProjectsNeeds [needsid=" + needsid + ", projectid="
				+ projectid + ", userid=" + userid + ", name=" + name
				+ ", acceptid=" + acceptid + ", source=" + source + ", level="
				+ level + ", tasktime=" + tasktime + ", attachment="
				+ attachment + ", created=" + created + ", createTime="
				+ createTime + ", changeTime=" + changeTime + ", username="
				+ username + ", acceptname=" + acceptname + ", changed="
				+ changed + ", stage=" + stage + ", status=" + status
				+ ", description=" + description + ", acceptance=" + acceptance
				+ ", needStatus=" + needStatus + ", needStage=" + needStage
				+ ", needSource=" + needSource + ", projectName=" + projectName
				+ "]";
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getNeedSource() {
		return needSource;
	}

	public void setNeedSource(String needSource) {
		this.needSource = needSource;
	}

	public void setNeedStatus(String needStatus) {
		this.needStatus = needStatus;
	}

	public String getNeedStatus() {
		return needStatus;
	}

	public void setNeedSatus(String needStatus) {
		this.needStatus = needStatus;
	}

	public String getNeedStage() {
		return needStage;
	}

	public void setNeedStage(String needStage) {
		this.needStage = needStage;
	}

	public String getAcceptname() {
		return acceptname;
	}

	public void setAcceptname(String acceptname) {
		this.acceptname = acceptname;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		this.changeTime = changeTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAcceptance() {
		return acceptance;
	}

	public void setAcceptance(String acceptance) {
		this.acceptance = acceptance;
	}

	public Long getNeedsid() {
        return needsid;
    }

    public void setNeedsid(Long needsid) {
        this.needsid = needsid;
    }

    public Long getProjectid() {
        return projectid;
    }

    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getAcceptid() {
        return acceptid;
    }

    public void setAcceptid(Long acceptid) {
        this.acceptid = acceptid;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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
        this.attachment = attachment == null ? null : attachment.trim();
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

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}