package com.opms.entity;

import java.sql.Timestamp;
import java.util.Date;

public class PmsBusinesstrips {
    private Long businesstripid;

    private Long userid;

    private String destinations;

    private String starteds;

    private String endeds;

    private Integer days;

    private String reason;

    private String picture;

    private Integer result;

    private Integer status;

    private String approverids;

    private Timestamp created;

    private Timestamp changed;

    public Long getBusinesstripid() {
        return businesstripid;
    }

    public void setBusinesstripid(Long businesstripid) {
        this.businesstripid = businesstripid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getDestinations() {
        return destinations;
    }

    public void setDestinations(String destinations) {
        this.destinations = destinations;
    }

    public String getStarteds() {
        return starteds;
    }

    public void setStarteds(String starteds) {
        this.starteds = starteds;
    }

    public String getEndeds() {
        return endeds;
    }

    public void setEndeds(String endeds) {
        this.endeds = endeds;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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