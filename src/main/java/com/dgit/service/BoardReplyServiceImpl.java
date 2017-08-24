package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.Board_reply;
import com.dgit.domain.Criteria;
import com.dgit.persistence.BoardReplyDAO;

@Service
public class BoardReplyServiceImpl implements BoardReplyService {
	
	@Autowired
	private BoardReplyDAO dao;
	
	@Override
	public List<Board_reply> list(Integer bno) throws Exception {
		System.out.println("888888888888*************************8");
		return dao.list(bno);
	}

	@Override
	public void create(Board_reply reply) throws Exception {
		dao.create(reply);
	}

	@Override
	public void update(Board_reply reply) throws Exception {
		dao.update(reply);
	}

	@Override
	public void delete(Integer brno) throws Exception {
		dao.delete(brno);
	}

	@Override
	public List<Board_reply> listPage(Integer bno, Criteria cri) throws Exception {
		return dao.listPage(bno, cri);
	}

	@Override
	public int count(int bno) throws Exception {
		return dao.count(bno);
	}

	@Override
	public int getBno(int brno) throws Exception {
		return dao.getBno(brno);
	}

}
