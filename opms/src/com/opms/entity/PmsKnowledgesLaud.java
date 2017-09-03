package com.opms.entity;

import java.util.Date;

public class PmsKnowledgesLaud {
    private Long laudid;

    private Long userid;

    private Long knowid;

    private Date created;

    private Integer status;

    public Long getLaudid() {
        return laudid;
    }

    public void setLaudid(Long laudid) {
        this.laudid = laudid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getKnowid() {
        return knowid;
    }

    public void setKnowid(Long knowid) {
        this.knowid = knowid;
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