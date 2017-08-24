package com.dgit.domain;

import java.util.Date;

public class Transfer {
	private int tno;
	private String ttitle;
	private String tcontext;
	private String tname;
	private String mid;
	private Date tdate;
	
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTcontext() {
		return tcontext;
	}
	public void setTcontext(String tcontext) {
		this.tcontext = tcontext;
	}
	public Date getTdate() {
		return tdate;
	}
	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}
	public String getTtitle() {
		return ttitle;
	}
	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return String.format("Transfer [tno=%s, ttitle=%s, tcontext=%s, tname=%s, mid=%s, tdate=%s]", tno, ttitle,
				tcontext, tname, mid, tdate);
	}
	
}
