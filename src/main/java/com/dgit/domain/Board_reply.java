package com.dgit.domain;

import java.util.Date;

public class Board_reply {
	private int brno;
	private String brcontext;
	private int bno;
	private String mid;
	private Date brdate;
	
	public int getBrno() {
		return brno;
	}
	public void setBrno(int brno) {
		this.brno = brno;
	}
	public String getBrcontext() {
		return brcontext;
	}
	public void setBrcontext(String brcontext) {
		this.brcontext = brcontext;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	public Date getBrdate() {
		return brdate;
	}
	public void setBrdate(Date brdate) {
		this.brdate = brdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return String.format("Board_reply [brno=%s, brcontext=%s, bno=%s, mid=%s, brdate=%s]", brno, brcontext, bno,
				mid, brdate);
	}
	
	
	
	
}
