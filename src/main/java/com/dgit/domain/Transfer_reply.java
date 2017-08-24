package com.dgit.domain;

import java.util.Date;

public class Transfer_reply {
	private int trno;
	private String trcontext;
	private int tno;
	private String mid;
	private Date trdate;
	
	public int getTrno() {
		return trno;
	}
	public void setTrno(int trno) {
		this.trno = trno;
	}
	public String getTrcontext() {
		return trcontext;
	}
	public void setTrcontext(String trcontext) {
		this.trcontext = trcontext;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public Date getTrdate() {
		return trdate;
	}
	public void setTrdate(Date trdate) {
		this.trdate = trdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return String.format("Transfer_reply [trno=%s, trcontext=%s, tno=%s, mid=%s, trdate=%s]", trno, trcontext, tno,
				mid, trdate);
	}
}
