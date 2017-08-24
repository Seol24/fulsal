package com.dgit.domain;

public class Today {
	private int todaytime;

	public int getTodaytime() {
		return todaytime;
	}

	public void setTodaytime(int todaytime) {
		this.todaytime = todaytime;
	}

	@Override
	public String toString() {
		return String.format("Today [todaytime=%s]", todaytime);
	}
	
	
}
