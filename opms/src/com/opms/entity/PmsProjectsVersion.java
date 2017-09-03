package com.opms.entity;

import java.util.Date;

public class PmsProjectsVersion {
    private Long versionid;

    private Long projectid;

    private Long userid;

    private String title;

    private Date versioned;

    private String sourceurl;

    private String downurl;

    private String attachment;

    private Date created;

    private Date changed;

    private String content;
    
    private String username;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getVersionid() {
        return versionid;
    }

    public void setVersionid(Long versionid) {
        this.versionid = versionid;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getVersioned() {
		return versioned;
	}

	public void setVersioned(Date versioned) {
		this.versioned = versioned;
	}

	public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }

    public String getDownurl() {
        return downurl;
    }

    public void setDownurl(String downurl) {
        this.downurl = downurl;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	@Override
	public String toString() {
		return "PmsProjectsVersion [versionid=" + versionid + ", projectid=" + projectid + ", userid=" + userid
				+ ", title=" + title + ", versioned=" + versioned + ", sourceurl=" + sourceurl + ", downurl=" + downurl
				+ ", attachment=" + attachment + ", created=" + created + ", changed=" + changed + ", content="
				+ content + ", username=" + username + "]";
	}
}