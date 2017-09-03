package com.opms.entity;

public class PmsProjectsNeedsWithBLOBs extends PmsProjectsNeeds {
    private String desc;

    private String acceptance;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(String acceptance) {
        this.acceptance = acceptance;
    }
}