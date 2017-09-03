package com.opms.entity;

import java.io.Serializable;

public class PmsUsers implements Serializable{
    private Long userid;

    private Long profileId;

    private String username;

    private String password;

    private String avatar;

    private int status;
    private String oldpwd;
	private String newpwd;

	public String getOldpwd() {
		return oldpwd;
	}

	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

	public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    
    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "PmsUsers [userid=" + userid + ", profileId=" + profileId + ", username=" + username + ", password="
				+ password + ", avatar=" + avatar + ", status=" + status + ", oldpwd=" + oldpwd + ", newpwd=" + newpwd
				+ "]";
	}
}