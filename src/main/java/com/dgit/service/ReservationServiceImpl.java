package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dgit.domain.Kujang;
import com.dgit.domain.Members;
import com.dgit.domain.Reservation;
import com.dgit.domain.Today;
import com.dgit.persistence.ReservationDAO;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDAO dao;
	
	@Override
	public List<Reservation> listReservation() throws Exception {
		return dao.listReservation();
	}

	@Transactional
	@Override
	public void insertReservation(Reservation reservation, String rdate) throws Exception {
		dao.insertReservation(reservation);
	}


	@Override
	public List<Reservation> viewReservation(String rdate) throws Exception {
		// TODO Auto-generated method stub
		return dao.viewReservation(rdate);
	}


	@Override
	public List<Kujang> viewKujang() throws Exception {
		// TODO Auto-generated method stub
		return dao.viewKujang();
	}


	@Override
	public List<Today> viewToday() throws Exception {
		// TODO Auto-generated method stub
		return dao.viewToday();
	}


	@Override
	public Today selectToday(int todaytime) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectToday(todaytime);
	}

	@Override
	public Kujang selectKujang(String kno) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectKujang(kno);
	}

	@Override
	public Members selectMembers(String mid) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectMembers(mid);
	}

	@Override
	public void deleteReservation(int rno) throws Exception {
		dao.deleteReservation(rno);
	}

	@Override
	public void modifyReservation(int rno) throws Exception {
		dao.modifyReservation(rno);
	}



}
