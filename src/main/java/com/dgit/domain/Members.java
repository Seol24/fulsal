package com.dgit.domain;

import java.util.Date;

public class Members {
	private String mid;
	private String mpass;
	private String mphone;
	private String memail;
	private String mname;
	private Date mdate;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return String.format("Members [mid=%s, mpass=%s, mphone=%s, memail=%s, mname=%s, mdate=%s]", mid, mpass, mphone,
				memail, mname, mdate);
	}


	
	
	

}
