package com.opms.entity;

import java.util.Date;

public class PmsUsersProfile {
	private Long user_id;

    private String realname;

    private int sex;

    private String birth;
    
	private String email;

    private String webchat;

    private String qq;

    private String phone;

    private String tel;

    private String address;

    private String emercontact;

    private String emerphone;

    private Long departid;

    private Long positionid;

    private Integer lognum;
    
    private String ip;

    private Date lasted;

	

	

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebchat() {
		return webchat;
	}

	public void setWebchat(String webchat) {
		this.webchat = webchat;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmercontact() {
		return emercontact;
	}

	public void setEmercontact(String emercontact) {
		this.emercontact = emercontact;
	}

	public String getEmerphone() {
		return emerphone;
	}

	public void setEmerphone(String emerphone) {
		this.emerphone = emerphone;
	}

	public Long getDepartid() {
		return departid;
	}

	public void setDepartid(Long departid) {
		this.departid = departid;
	}

	public Long getPositionid() {
		return positionid;
	}

	public void setPositionid(Long positionid) {
		this.positionid = positionid;
	}

	public Integer getLognum() {
		return lognum;
	}

	public void setLognum(Integer lognum) {
		this.lognum = lognum;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLasted() {
		return lasted;
	}

	public void setLasted(Date lasted) {
		this.lasted = lasted;
	}

	@Override
	public String toString() {
		return "PmsUsersProfile [user_id=" + user_id + ", realname=" + realname + ", sex=" + sex + ", birth=" + birth
				+ ", email=" + email + ", webchat=" + webchat + ", qq=" + qq + ", phone=" + phone + ", tel=" + tel
				+ ", address=" + address + ", emercontact=" + emercontact + ", emerphone=" + emerphone + ", departid="
				+ departid + ", positionid=" + positionid + ", lognum=" + lognum + ", ip=" + ip + ", lasted=" + lasted
				+ "]";
	}
    
}