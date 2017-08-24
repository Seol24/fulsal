package com.dgit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dgit.domain.Kujang;
import com.dgit.domain.Members;
import com.dgit.domain.Reservation;
import com.dgit.domain.Today;
import com.dgit.service.ReservationService;


@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService service;
	
	@RequestMapping(value = "/cal", method = RequestMethod.GET)
	public String cal() {
		
		return "cal";
	}
/*	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public String Schedule(Model model) throws Exception {
		System.out.println("------------Schedule");
		List<Kujang> listKujang = service.listKujang();
		List<Reservation> listReservation = service.listReservation();
		for(int i = 0; i<listReservation.size(); i++){
			if(listReservation.get(i).equals("")){
				listReservation.remove(i);
			}
		}
		
		System.out.println(listKujang.toString());
		System.out.println(listReservation.toString());
		model.addAttribute("kujang", listKujang);
		model.addAttribute("reservation", listReservation);
		
		return "schedule";
	}*/
	@RequestMapping(value = "/insertReservation", method = RequestMethod.GET)
	public String getInsertReservation(String rdate,int todaytime,String kno, Model model) throws Exception {
		System.out.println("--------getInsertReservation--------");
		Today today = service.selectToday(todaytime);
		Kujang kujang = service.selectKujang(kno);
		System.out.println("kujang : " +kujang);
		System.out.println("rdate : " +rdate);
		System.out.println("today : " +today);
		model.addAttribute("kujang", kujang);
		model.addAttribute("rdate", rdate);
		model.addAttribute("today", today);
		return "insertReservation";
	}
	
	@RequestMapping(value = "/insertReservation", method = RequestMethod.POST)
	public String postInsertReservation(String rdate, Reservation reservation, Model model, RedirectAttributes rttr) throws Exception {
		System.out.println("--------postInsertReservation--------");
		System.out.println("rdate : " +rdate);
		System.out.println("reservation : " + reservation.toString());
		if(reservation.isRmatching()==true){
			reservation.setRmatching(true);
		}else if(reservation.isRmatching()==false){
			reservation.setRmatching(false);
		}
		service.insertReservation(reservation,rdate);
		System.out.println("------------------------------------------");
		System.out.println("getRno = " + reservation.getRno());
		
		rttr.addAttribute("rdate", rdate);
		return "redirect:schedule";
	}
	
	@Transactional
	@RequestMapping(value="/schedule", method= RequestMethod.GET)
	public String schedule(String rdate, Model model) throws Exception{
		List<Kujang> kujang = service.viewKujang();
		List<Today> today = service.viewToday();
		List<Reservation> reservation = service.viewReservation(rdate);
		System.out.println("reservation : "+ reservation);
		System.out.println("kujang : "+ kujang);
		System.out.println("today : "+ today);
		
		model.addAttribute("reservation", reservation);
		model.addAttribute("kujang", kujang);
		model.addAttribute("today", today);
		model.addAttribute("rdate", rdate);
		
		return "schedule";
	}
	@RequestMapping(value="/readReservation", method=RequestMethod.GET)
	public String readReservation(String mid, Reservation reservation,String rdate, Model model)throws Exception{
		Members members = service.selectMembers(mid);
		model.addAttribute("rdate", rdate);
		model.addAttribute("members", members);
		model.addAttribute("reservation", reservation);
		System.out.println("--------------resdReservation--------------");
		System.out.println("mid : " + mid);
		System.out.println("members : " + members);
		System.out.println("reservation : " + reservation);
		return "readReservation";
	}
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String readReservation(String rno, String rdate)throws Exception{
		System.out.println("----------------delete-----------------");
		System.out.println("rno : " + rno);
		int res = Integer.parseInt(rno);
		service.deleteReservation(res);
		System.out.println("-------------------------------"+ rno);
		return "redirect:schedule?rdate=" + rdate;
	}
	@RequestMapping(value = "/modify", method = { RequestMethod.GET, RequestMethod.POST })
	public String updateReservation(String rno, String rdate)throws Exception{
		System.out.println("----------------update-----------------");
		System.out.println("rno : " + rno);
		int res = Integer.parseInt(rno);
		service.modifyReservation(res);
		System.out.println("-------------------------------"+ rno);
		return "redirect:schedule?rdate=" + rdate;
	}
}
