package com.dgit.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Board {
	private int bno;
	private String btitle;
	private String bcontext;
	private String mid;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date bdate;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontext() {
		return bcontext;
	}
	public void setBcontext(String bcontext) {
		this.bcontext = bcontext;
	}

	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	@Override
	public String toString() {
		return String.format("Board [bno=%s, btitle=%s, bcontext=%s, mid=%s, bdate=%s]", bno, btitle, bcontext, mid,
				bdate);
	}
	
	
	
}
