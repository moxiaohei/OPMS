package com.opms.entity;

public class PmsUserPms {
	private PmsUsers pmsUsers;
	private PmsUsersProfile pmsUsersProfile;
	public PmsUsers getPmsUsers() {
		return pmsUsers;
	}
	public void setPmsUsers(PmsUsers pmsUsers) {
		this.pmsUsers = pmsUsers;
	}
	public PmsUsersProfile getPmsUsersProfile() {
		return pmsUsersProfile;
	}
	public void setPmsUsersProfile(PmsUsersProfile pmsUsersProfile) {
		this.pmsUsersProfile = pmsUsersProfile;
	}
	@Override
	public String toString() {
		return "PmsUserPms [pmsUsers=" + pmsUsers + ", pmsUsersProfile=" + pmsUsersProfile + "]";
	}
	

}
