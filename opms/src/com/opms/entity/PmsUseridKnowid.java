package com.opms.entity;

public class PmsUseridKnowid {
	private long knowid;
	private long userid;
	public long getKnowid() {
			return knowid;
		}
		public void setKnowid(long knowid) {
			this.knowid = knowid;
		}
		public long getUserid() {
			return userid;
		}
		public void setUserid(long userid) {
			this.userid = userid;
		}
		@Override
		public String toString() {
			return "PmsUseridKnowid [knowid=" + knowid + ", userid=" + userid + "]";
		}


}
