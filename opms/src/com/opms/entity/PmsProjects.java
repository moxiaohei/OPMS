package com.opms.entity;

import java.util.Date;

import com.opms.unti.StringDate;
import com.opms.unti.TimeDate;

public class PmsProjects {
	private Long projectid;

	private Long userid;

	private String name;

	private String aliasname;

	private Date started;

	private Date ended;

	private Date created;

	private Integer status;

	private Long projuserid;

	private Long produserid;

	private Long testuserid;

	private Long publuserid;

	private String projectdescribe;
	// 发布负责人
	private String publishResponsePeople;
	// 测试负责人
	private String testResponsePeople;
	// 产品负责人
	private String productResponsePeople;
	// 项目负责人
	private String projectResponsePeople;
	// 创建人
	private String createPeople;

	// 起始日期
	private String startdate;
	// 结束日期
	private String enddate;
	
	public int datebetween(){
		int days = (int)((ended.getTime() - started.getTime())/86400000);
		return days;
	}
	
	public void setStartdate(String startdate) {
		started = new TimeDate().getDate(startdate);
	}

	public void setEnddate(String enddate) {
		ended = new TimeDate().getDate(enddate);
	}

	public void setPublishResponsePeople(String publishResponsePeople) {
		this.publishResponsePeople = publishResponsePeople;
	}

	public void setTestResponsePeople(String testResponsePeople) {
		this.testResponsePeople = testResponsePeople;
	}

	public void setProductResponsePeople(String productResponsePeople) {
		this.productResponsePeople = productResponsePeople;
	}

	public void setProjectResponsePeople(String projectResponsePeople) {
		this.projectResponsePeople = projectResponsePeople;
	}

	public void setCreatePeople(String createPeople) {
		this.createPeople = createPeople;
	}

	/**
	 * <p>
	 * : 获取产品负责人 </>
	 * 
	 * @author quanhuan
	 * @time 2017年7月27日上午10:23:13
	 */
	public String getPublishResponsePeople() {
		return publishResponsePeople;
	}

	/**
	 * <p>
	 * : 获取测试负责人 </>
	 * 
	 * @author quanhuan
	 * @time 2017年7月27日上午10:23:13
	 */
	public String getTestResponsePeople() {
		return testResponsePeople;
	}

	/**
	 * <p>
	 * : 获取产品负责人 </>
	 * 
	 * @author quanhuan
	 * @time 2017年7月27日上午10:23:13
	 */
	public String getProductResponsePeople() {
		return productResponsePeople;
	}

	/**
	 * <p>
	 * : 获取项目负责人 </>
	 * 
	 * @author quanhuan
	 * @time 2017年7月27日上午10:23:13
	 */
	public String getProjectResponsePeople() {
		return projectResponsePeople;
	}

	/**
	 * <p>
	 * : 获取创建人 </>
	 * 
	 * @author quanhuan
	 * @time 2017年7月27日上午10:13:06
	 */
	public String getCreatePeople() {
		return createPeople;
	}

	/**
	 * <p>
	 * : 获取结束时间 </>
	 * 
	 * @author quanhuan
	 * @time 2017年7月27日上午10:26:13
	 */
	public String getStringEndDate() {
		String date = new StringDate().getStringDate(ended);
		return date;
	}

	/**
	 * <p>
	 * : 设置结束时间 </>
	 * 
	 * @author quanhuan
	 * @time 2017年7月27日上午10:26:13
	 */
	public void setStringEndDate(String end) {
		ended = new TimeDate().getDate(end);
	}

	/**
	 * <p>
	 * : 获取起始时间 </>
	 * 
	 * @author quanhuan
	 * @time 2017年7月27日上午10:26:13
	 */
	public String getStringStartDate() {
		String date = new StringDate().getStringDate(started);
		return date;
	}

	/**
	 * <p>
	 * : 设置起始时间 </>
	 * 
	 * @author quanhuan
	 * @time 2017年7月27日上午10:26:13
	 */
	public void setStringStartDate(String start) {
		started = new TimeDate().getDate(start);
	}

	public Long getProjectid() {
		return projectid;
	}

	public void setProjectid(Long projectid) {
		this.projectid = projectid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAliasname() {
		return aliasname;
	}

	public void setAliasname(String aliasname) {
		this.aliasname = aliasname;
	}

	public Date getStarted() {
		return started;
	}

	public void setStarted(Date started) {
		this.started = started;
	}

	public Date getEnded() {
		return ended;
	}

	public void setEnded(Date ended) {
		this.ended = ended;
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

	public Long getProjuserid() {
		return projuserid;
	}

	public void setProjuserid(Long projuserid) {
		this.projuserid = projuserid;
	}

	public Long getProduserid() {
		return produserid;
	}

	public void setProduserid(Long produserid) {
		this.produserid = produserid;
	}

	public Long getTestuserid() {
		return testuserid;
	}

	public void setTestuserid(Long testuserid) {
		this.testuserid = testuserid;
	}

	public Long getPubluserid() {
		return publuserid;
	}

	public void setPubluserid(Long publuserid) {
		this.publuserid = publuserid;
	}

	public String getProjectdescribe() {
		return projectdescribe;
	}

	public void setProjectdescribe(String projectdescribe) {
		this.projectdescribe = projectdescribe;
	}

}