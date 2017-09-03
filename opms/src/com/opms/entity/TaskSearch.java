package com.opms.entity;

public class TaskSearch {

	private Integer taskStatus;
	
	private Integer taskType;
	
	private Long taskAcceptid;
	
	private String keywords;
	
	private Long projectid;

	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	public Integer getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Long getTaskAcceptid() {
		return taskAcceptid;
	}

	public void setTaskAcceptid(Long taskAcceptid) {
		this.taskAcceptid = taskAcceptid;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
}
