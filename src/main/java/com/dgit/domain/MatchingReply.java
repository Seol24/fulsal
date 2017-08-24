package com.dgit.domain;

import java.sql.Date;

public class MatchingReply {
	private int mrno;
	private int rno;
	private String mrcontext;
	private Date mrdate;
	private String mid;
	public int getMrno() {
		return mrno;
	}
	public void setMrno(int mrno) {
		this.mrno = mrno;
	}
	public String getMrcontext() {
		return mrcontext;
	}
	public void setMrcontext(String mrcontext) {
		this.mrcontext = mrcontext;
	}
	public Date getMrdate() {
		return mrdate;
	}
	public void setMrdate(Date mrdate) {
		this.mrdate = mrdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	@Override
	public String toString() {
		return String.format("MatchingReply [mrno=%s, rno=%s, mrcontext=%s, mrdate=%s, mid=%s]", mrno, rno, mrcontext,
				mrdate, mid);
	}
	
	
	
}
