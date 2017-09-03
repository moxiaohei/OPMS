package com.opms.entity;







public class PmsKnowledgesUser {
	private Long knowid;

    private Long userid;

    private Long sortid;

    private String title;

    private String tag;

    private String summary;

    private String url;

    private String color;

    private Integer viewnum;

    private Integer comtnum;

    private Integer laudnum;

    private Integer ispublis;

    private Integer status;

    private String created;

    private String  changed;

    private String content;
    private String username;
	public Long getKnowid() {
		return knowid;
	}
	public void setKnowid(Long knowid) {
		this.knowid = knowid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getSortid() {
		return sortid;
	}
	public void setSortid(Long sortid) {
		this.sortid = sortid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getViewnum() {
		return viewnum;
	}
	public void setViewnum(Integer viewnum) {
		this.viewnum = viewnum;
	}
	public Integer getComtnum() {
		return comtnum;
	}
	public void setComtnum(Integer comtnum) {
		this.comtnum = comtnum;
	}
	public Integer getLaudnum() {
		return laudnum;
	}
	public void setLaudnum(Integer laudnum) {
		this.laudnum = laudnum;
	}
	public Integer getIspublis() {
		return ispublis;
	}
	public void setIspublis(Integer ispublis) {
		this.ispublis = ispublis;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getChanged() {
		return changed;
	}
	public void setChanged(String changed) {
		this.changed = changed;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "PmsKnowledgesUser [knowid=" + knowid + ", userid=" + userid
				+ ", sortid=" + sortid + ", title=" + title + ", tag=" + tag
				+ ", summary=" + summary + ", url=" + url + ", color=" + color
				+ ", viewnum=" + viewnum + ", comtnum=" + comtnum
				+ ", laudnum=" + laudnum + ", ispublis=" + ispublis
				+ ", status=" + status + ", created=" + created + ", changed="
				+ changed + ", content=" + content + ", username=" + username
				+ "]";
	}
    
}
