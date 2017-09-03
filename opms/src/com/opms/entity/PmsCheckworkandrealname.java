package com.opms.entity;

import java.sql.Date;

public class PmsCheckworkandrealname {
	  private Long checkid;//考勤id

	    private Long userid;//用户id

	    private String clock;//打卡时间

	    private Integer type;//状态  1.正常  2.迟到 3.早退 4.加班

	    private String ip;//浏览器ip

	    private Date created;//创建时间
	    
	    private String realname;//姓名

		public Long getCheckid() {
			return checkid;
		}

		public void setCheckid(Long checkid) {
			this.checkid = checkid;
		}

		public Long getUserid() {
			return userid;
		}

		public void setUserid(Long userid) {
			this.userid = userid;
		}

		public String getClock() {
			return clock;
		}

		public void setClock(String clock) {
			this.clock = clock;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public String getIp() {
			return ip;
		}

		public void setIp(String ip) {
			this.ip = ip;
		}

		public Date getCreated() {
			return created;
		}

		public void setCreated(Date created) {
			this.created = created;
		}

		public String getRealname() {
			return realname;
		}

		public void setRealname(String realname) {
			this.realname = realname;
		}

}
