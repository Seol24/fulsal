package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.Criteria;
import com.dgit.domain.Transfer_reply;
import com.dgit.persistence.TransferReplyDAO;

@Service
public class TransferReplyServiceImpl implements TransferReplyService {
	
	@Autowired
	private TransferReplyDAO dao;

	@Override
	public List<Transfer_reply> list(Integer tno) throws Exception {
		return dao.list(tno);
	}

	@Override
	public void create(Transfer_reply reply) throws Exception {
		dao.create(reply);
	}

	@Override
	public void update(Transfer_reply reply) throws Exception {
		dao.update(reply);
	}

	@Override
	public void delete(Integer trno) throws Exception {
		dao.delete(trno);
	}

	@Override
	public List<Transfer_reply> listPage(Integer tno, Criteria cri) throws Exception {
		return dao.listPage(tno, cri);
	}

	@Override
	public int count(int tno) throws Exception {
		return dao.count(tno);
	}

	@Override
	public int getTno(int trno) throws Exception {
		return dao.getTno(trno);
	}

}
