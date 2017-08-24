package com.dgit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dgit.domain.Board;
import com.dgit.domain.Criteria;
import com.dgit.domain.PageMaker;
import com.dgit.service.BoardService;

@Controller
public class FulsalController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "main";
	}
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String back() {
		return "main";
	}

	@RequestMapping(value = "/listBoard", method = RequestMethod.GET)
	public String board(Criteria cri, Model model) throws Exception {
		List<Board> list = service.boardListCriteria(cri);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCount());
		
		System.out.println("---------------------pageMaker----------------------");
		System.out.println(pageMaker.toString());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "listBoard";
	}
	@RequestMapping(value = "/readBoard", method = RequestMethod.GET)
	public String read(int bno,Model model) throws Exception {
		System.out.println("------read-------");
		System.out.println(bno);
		Board board = service.boardRead(bno);
		
		model.addAttribute("board", board);
		return "readBoard";
	}
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public String getInsertBoard(Model model) throws Exception {
		return "insertBoard";
	}
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public String postInsertBoard(Board board,Model model) throws Exception {
		service.boardInsert(board);
		return "redirect:listBoard";
	}
	@RequestMapping(value = "/deleteBoard", method = RequestMethod.POST)
	public String deleteBoard(String bno) throws Exception {
		System.out.println("---------------deleteBoard-----------------");
		System.out.println(bno);
		int res = Integer.parseInt(bno); 
		service.boardDelete(res);
		return "redirect:listBoard";
	}
	@RequestMapping(value = "/modifyBoard", method = RequestMethod.GET)
	public String getModifyBoard(int bno, Model model) throws Exception {
		System.out.println("---------------);getModifyBoard-----------------");
		Board board = service.boardRead(bno);
		model.addAttribute("board", board);
		return "modifyBoard";
	}
	@RequestMapping(value = "/modifyBoard", method = RequestMethod.POST)
	public String posttModifyBoard(Board board) throws Exception {
		System.out.println("---------------postModifyBoard-----------------");
		System.out.println(board);
		service.boardModify(board);
		return "redirect:readBoard?bno=" + board.getBno();
	}
}
