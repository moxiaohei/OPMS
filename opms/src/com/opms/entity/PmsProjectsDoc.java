package com.opms.entity;

import java.util.Date;

public class PmsProjectsDoc {
    private Long docid;

    private Long projectid;

    private Long userid;

    private String title;

    private String keyword;

    private Integer sort;

    private String url;

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

	public Long getDocid() {
        return docid;
    }

    public void setDocid(Long docid) {
        this.docid = docid;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
		return "PmsProjectsDoc [docid=" + docid + ", projectid=" + projectid + ", userid=" + userid + ", title=" + title
				+ ", keyword=" + keyword + ", sort=" + sort + ", url=" + url + ", attachment=" + attachment
				+ ", created=" + created + ", changed=" + changed + ", content=" + content + ", username=" + username
				+ "]";
	}
    
}