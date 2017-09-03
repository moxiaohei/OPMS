package com.opms.entity;

import java.util.Date;

public class PmsProjectsTeam {
    private Long id;

    private Long projectid;

    private Long userid;

    private Date created;
    
    private String username;

    private String deptname;
    
    private String joinTime;
	public String getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(String joinTime) {
		this.joinTime = joinTime;
	}

	@Override
	public String toString() {
		return "PmsProjectsTeam [id=" + id + ", projectid=" + projectid
				+ ", userid=" + userid + ", created=" + created + ", username="
				+ username + ", deptname=" + deptname + "]";
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}