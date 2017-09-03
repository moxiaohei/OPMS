package com.opms.entity;

public class PmsProjectsTaskWithBLOBs extends PmsProjectsTask {
    private String description;

    private String note;

    public String getDesc() {
        return description;
    }

    public void setDesc(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}