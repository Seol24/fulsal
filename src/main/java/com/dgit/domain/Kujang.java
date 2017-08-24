package com.dgit.domain;

public class Kujang {
	private String kno;

	public String getKno() {
		return kno;
	}

	public void setKno(String kno) {
		this.kno = kno;
	}

	@Override
	public String toString() {
		return String.format("Kujang [kno=%s]", kno);
	}
	
	
}
