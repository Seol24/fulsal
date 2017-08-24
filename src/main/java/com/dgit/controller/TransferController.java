package com.dgit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.Criteria;
import com.dgit.domain.PageMaker;
import com.dgit.domain.Transfer;
import com.dgit.service.TransferService;

@Controller
public class TransferController {
	
	@Autowired
	private TransferService service;
	
	@RequestMapping(value = "/listTransfer", method = RequestMethod.GET)
	public String transfer(Criteria cri, Model model) throws Exception {
		List<Transfer> list =service.transferListCriteria(cri);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCount());
		
		System.out.println("---------------------pageMaker----------------------");
		System.out.println(pageMaker.toString());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "listTransfer";
	}
	@RequestMapping(value = "/readTransfer", method = RequestMethod.GET)
	public String read(int tno,Model model) throws Exception {
		System.out.println("------read-------");
		System.out.println(tno);
		Transfer transfer = service.transferRead(tno);
		
		model.addAttribute("transfer", transfer);
		return "readTransfer";
	}
	@RequestMapping(value = "/insertTransfer", method = RequestMethod.GET)
	public String getInsertTransfer(Model model) throws Exception {
		return "insertTransfer";
	}
	@RequestMapping(value = "/insertTransfer", method = RequestMethod.POST)
	public String postInsertTransfer(Transfer transfer,Model model) throws Exception {
		service.transferInsert(transfer);
		return "redirect:listTransfer";
	}
	@RequestMapping(value = "/deleteTransfer", method = RequestMethod.POST)
	public String deleteTransfer(String tno) throws Exception {
		System.out.println("---------------deleteTransfer-----------------");
		System.out.println(tno);
		int res = Integer.parseInt(tno); 
		service.transferDelete(res);
		return "redirect:listTransfer";
	}
	@RequestMapping(value = "/modifyTransfer", method = RequestMethod.GET)
	public String getModifyTransfer(int tno, Model model) throws Exception {
		System.out.println("---------------);getModifyBoard-----------------");
		Transfer transfer = service.transferRead(tno);
		model.addAttribute("transfer", transfer);
		return "modifyTransfer";
	}
	@RequestMapping(value = "/modifyTransfer", method = RequestMethod.POST)
	public String posttModifyBoard(Transfer transfer) throws Exception {
		System.out.println("---------------postModifyTransfer-----------------");
		System.out.println(transfer);
		service.transferModify(transfer);
		return "redirect:readTransfer?tno=" + transfer.getTno();
	}
}
