package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.Criteria;
import com.dgit.domain.MatchingReply;
import com.dgit.persistence.MatchingReplyDAO;

@Service
public class MatchingReplyServiceImpl implements MatchingReplyService {
	
	@Autowired
	private MatchingReplyDAO dao;

	@Override
	public List<MatchingReply> list(int rno) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(rno);
	}

	@Override
	public void create(MatchingReply reply) throws Exception {
		// TODO Auto-generated method stub
		dao.create(reply);
	}

	@Override
	public void update(MatchingReply reply) throws Exception {
		// TODO Auto-generated method stub
		dao.update(reply);
	}

	@Override
	public void delete(int mrno) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(mrno);
	}

	@Override
	public List<MatchingReply> listPage(int rno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listPage(rno, cri);
	}

	@Override
	public int count(int rno) throws Exception {
		// TODO Auto-generated method stub
		return dao.count(rno);
	}

	@Override
	public int getBno(int mrno) throws Exception {
		// TODO Auto-generated method stub
		return dao.getBno(mrno);
	}

}
