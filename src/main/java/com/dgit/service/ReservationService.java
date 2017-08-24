package com.dgit.service;

import java.util.List;

import com.dgit.domain.Kujang;
import com.dgit.domain.Members;
import com.dgit.domain.Reservation;
import com.dgit.domain.Today;

public interface ReservationService {
	public List<Reservation> listReservation() throws Exception;
	
	public void insertReservation(Reservation reservation, String rdate) throws Exception;
	
	public List<Reservation> viewReservation(String rdate) throws Exception;
	
	public List<Kujang> viewKujang() throws Exception;
	
	public List<Today> viewToday() throws Exception;
	
	public Today selectToday(int todaytime) throws Exception;
	
	public Kujang selectKujang(String kno) throws Exception;
	
	public Members selectMembers(String mid) throws Exception;
	
	public void deleteReservation(int rno) throws Exception;
	
	public void modifyReservation(int rno) throws Exception;
}
