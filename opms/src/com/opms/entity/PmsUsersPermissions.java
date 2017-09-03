package com.opms.entity;

public class PmsUsersPermissions {
    private Long userid;

    private String permission;

    private String model;

    private String modelc;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelc() {
        return modelc;
    }

    public void setModelc(String modelc) {
        this.modelc = modelc;
    }
}