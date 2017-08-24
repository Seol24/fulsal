package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.Criteria;
import com.dgit.domain.Transfer_reply;

public interface TransferReplyDAO {
	public List<Transfer_reply> list(Integer tno) throws Exception;

	public void create(Transfer_reply reply) throws Exception;

	public void update(Transfer_reply reply) throws Exception;

	public void delete(Integer trno) throws Exception;
	
	public List<Transfer_reply> listPage(Integer tno, Criteria cri) throws Exception;
	
	public int count(int tno) throws Exception;
	public int getTno(int trno) throws Exception;
}
