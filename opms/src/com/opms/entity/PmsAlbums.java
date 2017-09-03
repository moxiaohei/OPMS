package com.opms.entity;

import java.util.Date;

public class PmsAlbums {
    private Long albumid;

    private Long userid;

    private String title;

    private String picture;

    private String keywords;

    private String summary;

    private Integer viewnum;

    private Integer comtnum;

    private Integer laudnum;

    private Date created;

    private Integer status;

    public Long getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Long albumid) {
        this.albumid = albumid;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}