package com.dgit.service;

import java.util.List;

import com.dgit.domain.Board;
import com.dgit.domain.Criteria;
import com.dgit.domain.Transfer;

public interface TransferService {
	public List<Transfer> transferList() throws Exception;
	public Transfer transferRead(int tno) throws Exception;
	public void transferInsert(Transfer transfer) throws Exception;
	public void transferDelete(int tno) throws Exception;
	public void transferModify(Transfer transfer) throws Exception;
	public List<Transfer> transferListCriteria(Criteria cri) throws Exception;
	
	public int totalCount() throws Exception;
}
