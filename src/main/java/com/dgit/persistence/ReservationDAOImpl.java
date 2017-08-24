package com.dgit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dgit.domain.Kujang;
import com.dgit.domain.Members;
import com.dgit.domain.Reservation;
import com.dgit.domain.Today;


@Repository
public class ReservationDAOImpl implements ReservationDAO {
	
	@Inject
	private SqlSession session;
	
	private static String  namespace = "com.dgit.mappers.ReservationMapper";
	
	@Override
	public List<Reservation> listReservation() throws Exception {
		return session.selectList(namespace+ ".listReservation");
	}

	@Override
	public void insertReservation(Reservation reservation) throws Exception {
		session.insert(namespace+".insertReservation",reservation);
	}

	@Override
	public List<Reservation> viewReservation(String rdate) throws Exception {
		return session.selectList(namespace+".viewReseervation", rdate);
	}

	@Override
	public List<Kujang> viewKujang() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".viewKujang" );
	}

	@Override
	public List<Today> viewToday() throws Exception {
		return session.selectList(namespace + ".viewToday");
	}

	@Override
	public Today selectToday(int todaytime) throws Exception {
		return session.selectOne(namespace + ".selectToday", todaytime);
	}

	@Override
	public Kujang selectKujang(String kno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".selectKujang", kno);
	}

	@Override
	public Members selectMembers(String mid) throws Exception {
		return session.selectOne(namespace + ".selectMembers", mid);
	}

	@Override
	public void deleteReservation(int rno) throws Exception {
		session.delete(namespace + ".deleteReservation", rno);
	}

	@Override
	public void modifyReservation(int rno) throws Exception {
		session.update(namespace + ".modifyReservation", rno);
	}



	

}
