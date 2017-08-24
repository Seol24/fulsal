package com.dgit.domain;


public class Reservation {
	private int rno;
	private int startdate;
	private String enddate;
	private String rdate;
	private boolean rmatching;
	private String mid;
	private int todaytime;
	private String kno;
	

	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getKno() {
		return kno;
	}
	public void setKno(String kno) {
		this.kno = kno;
	}
	public int getStartdate() {
		return startdate;
	}
	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public boolean isRmatching() {
		return rmatching;
	}
	public void setRmatching(boolean rmatching) {
		this.rmatching = rmatching;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public int getTodaytime() {
		return todaytime;
	}
	public void setTodaytime(int todaytime) {
		this.todaytime = todaytime;
	}
	@Override
	public String toString() {
		return String.format(
				"Reservation [rno=%s, startdate=%s, enddate=%s, rdate=%s, rmatching=%s, mid=%s, todaytime=%s, kno=%s]",
				rno, startdate, enddate, rdate, rmatching, mid, todaytime, kno);
	}
	
	
	
	
}
