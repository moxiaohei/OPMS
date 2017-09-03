package com.opms.entity;

import java.util.Date;

public class PmsCommentUser {
	 private Long comtid;

	    private Long userid;

	    private Long knowid;

	    private String content;

	    private String created;

	    private Integer status;
	    private String username;
		public Long getComtid() {
			return comtid;
		}
		public void setComtid(Long comtid) {
			this.comtid = comtid;
		}
		public Long getUserid() {
			return userid;
		}
		public void setUserid(Long userid) {
			this.userid = userid;
		}
		public Long getKnowid() {
			return knowid;
		}
		public void setKnowid(Long knowid) {
			this.knowid = knowid;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		public String getCreated() {
			return created;
		}
		public void setCreated(String created) {
			this.created = created;
		}
		public Integer getStatus() {
			return status;
		}
		public void setStatus(Integer status) {
			this.status = status;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		@Override
		public String toString() {
			return "PmsCommentUser [comtid=" + comtid + ", userid=" + userid
					+ ", knowid=" + knowid + ", content=" + content
					+ ", created=" + created + ", status=" + status
					+ ", username=" + username + "]";
		}
		
}
