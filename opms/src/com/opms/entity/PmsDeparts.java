package com.opms.entity;

/**
 * 
 * description:部门的实体类
 * @author liyanpeng
 * @date 2017年7月28日
 */
public class PmsDeparts {
    private Long departid;//部门ID

    private String name;//部门名称

    private String description;//部门的描述信息

    private Integer status;//部门状态，正常还是屏蔽

    /**
     * description:获取部门ID
     * @author liyanpeng
     * @date 2017年7月28日
     */
    public Long getDepartid() {
        return departid;
    }

    /**
     * description:设置部门ID
     * @author liyanpeng
     * @date 2017年7月28日
     */
    public void setDepartid(Long departid) {
        this.departid = departid;
    }

    /**
     * description:获取部门名称
     * @author liyanpeng
     * @date 2017年7月28日
     */
    public String getName() {
        return name;
    }

    /**
     * description:设置部门名称
     * @author liyanpeng
     * @date 2017年7月28日
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * description:获取状态
     * @author liyanpeng
     * @date 2017年7月28日
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * description:获取描述信息
     * @author liyanpeng
     * @date 2017年7月28日
     */
    
    public String getDescription() {
		return description;
	}
    /**
     * description:设置描述信息
     * @author liyanpeng
     * @date 2017年7月28日
     */
    
	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * description:设置状态
     * @author liyanpeng
     * @date 2017年7月28日
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}