package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.Criteria;
import com.dgit.domain.Transfer;
import com.dgit.persistence.TransferDAO;

@Service
public class TransferServiceImpl implements TransferService {

	@Autowired
	private TransferDAO dao;
	
	@Override
	public List<Transfer> transferList() throws Exception {
		// TODO Auto-generated method stub
		return dao.transferList();
	}

	@Override
	public Transfer transferRead(int tno) throws Exception {
		// TODO Auto-generated method stub
		return dao.transferRead(tno);
	}

	@Override
	public void transferInsert(Transfer transfer) throws Exception {
		// TODO Auto-generated method stub
		dao.transferInsert(transfer);
	}

	@Override
	public void transferDelete(int tno) throws Exception {
		// TODO Auto-generated method stub
		dao.transferDelete(tno);
	}

	@Override
	public void transferModify(Transfer transfer) throws Exception {
		// TODO Auto-generated method stub
		dao.transferModify(transfer);
	}

	@Override
	public List<Transfer> transferListCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.transferListCriteria(cri);
	}

	@Override
	public int totalCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}

}
