package com.opms.entity;

public class PmsPermissions {
    private Long permissionid;

    private Long parentid;

    private String name;
    
    private String parentName;

	private String ename;

    private String icon;

    private Integer nav;

    private Integer type;

    private Integer weight;
    
    public Integer isexist;
    
    public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

    public Long getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEname() {
        return ename;
    }

    public Integer getIsexist() {
		return isexist;
	}

	public void setIsexist(Integer isexist) {
		this.isexist = isexist;
	}

	public void setEname(String ename) {
        this.ename = ename;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getNav() {
        return nav;
    }

    public void setNav(Integer nav) {
        this.nav = nav;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

	@Override
	public String toString() {
//		return "PmsPermissions [permissionid=" + permissionid + ", parentid=" + parentid + ", name=" + name
//				+ ", parentName=" + parentName + ", ename=" + ename + ", icon=" + icon + ", nav=" + nav + ", type="
//				+ type + ", weight=" + weight + "]";
		return "{"+name+","+isexist+"}";
	}
    
}