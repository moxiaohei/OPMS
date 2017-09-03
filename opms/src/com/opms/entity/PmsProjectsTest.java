package com.opms.entity;

import java.util.Date;

import com.opms.unti.StringDate;
import com.opms.unti.TimeDate;

public class PmsProjectsTest {
	private Long testid;

	private Long taskid;

	private Long needsid;

	private Long userid;

	private Long projectid;

	private Long acceptid;

	private Long completeid;

	private Long ccid;

	private String name;

	private Integer level;

	private String os;

	private String browser;

	private String attachment;

	private Date completed;

	private Date created;

	private Date changed;

	private Integer status;

	private String bugdesc;
	// 创建人
	private String createUser;
	// 任务接受人
	private String acceptPeople;
	// 完成人
	private String completePeople;
	//抄送人
	private String cPeople;
    //关联需求
	private String needname;
	//关联任务
	private String taskname;
	// 创建日期
	private String createDate;
	// 完成日期
	private String completeDate;
    //修改日期
	private String changeDate;
	//bug状态
	private String state;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getcPeople() {
		return cPeople;
	}

	public void setcPeople(String cPeople) {
		this.cPeople = cPeople;
	}

	public String getNeedname() {
		return needname;
	}

	public void setNeedname(String needname) {
		this.needname = needname;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getChangeDate() {
		return new StringDate().getStringDate(changed);
	}

	public void setChangeDate(String changed) {
		this.changed=new TimeDate().getDate(changed);
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getAcceptPeople() {
		return acceptPeople;
	}

	public void setAcceptPeople(String acceptPeople) {
		this.acceptPeople = acceptPeople;
	}

	public String getCompletePeople() {
		return completePeople;
	}

	public void setCompletePeople(String completePeople) {
		this.completePeople = completePeople;
	}

	public String getCreateDate() {
		return new StringDate().getStringDate(created);
	}

	public void setCreateDate(String createDate) {
		Date date = new TimeDate().getDate(createDate);
		created=new TimeDate().getDate(createDate);
	}

	public String getCompleteDate() {
		return new StringDate().getStringDate(completed);
	}

	public void setCompleteDate(String completeDate) {
		completed=new TimeDate().getDate(completeDate);
	}

	public Long getTestid() {
		return testid;
	}

	public void setTestid(Long testid) {
		this.testid = testid;
	}

	public Long getTaskid() {
		return taskid;
	}

	public void setTaskid(Long taskid) {
		this.taskid = taskid;
	}

	public Long getNeedsid() {
		return needsid;
	}

	public void setNeedsid(Long needsid) {
		this.needsid = needsid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	public Long getAcceptid() {
		return acceptid;
	}

	public void setAcceptid(Long acceptid) {
		this.acceptid = acceptid;
	}

	public Long getCompleteid() {
		return completeid;
	}

	public void setCompleteid(Long completeid) {
		this.completeid = completeid;
	}

	public Long getCcid() {
		return ccid;
	}

	public void setCcid(Long ccid) {
		this.ccid = ccid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public Date getCompleted() {
		return completed;
	}

	public void setCompleted(Date completed) {
		this.completed = completed;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getChanged() {
		return changed;
	}

	public void setChanged(Date changed) {
		this.changed = changed;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBugdesc() {
		return bugdesc;
	}

	public void setBugdesc(String bugdesc) {
		this.bugdesc = bugdesc;
	}

}