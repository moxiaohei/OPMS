/**
 * 
 */
package com.opms.entity;

/**
 * description:
 * @author liyanpeng
 * @date 2017Äê8ÔÂ5ÈÕ
 */
public class PmsUsersname {
	private long userid;
	private String username;
	private String realname;
	
	public PmsUsersname() {
		// TODO Auto-generated constructor stub
	}
	
	public PmsUsersname(long userid,String username,String realname) {
		// TODO Auto-generated constructor stub
		this.userid=userid;
		this.username=username;
		this.realname=realname;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	
}
