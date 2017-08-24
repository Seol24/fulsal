package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.Board_reply;
import com.dgit.domain.Criteria;
import com.dgit.domain.MatchingReply;

public interface MatchingReplyDAO {
	public List<MatchingReply> list(int rno) throws Exception;

	public void create(MatchingReply reply) throws Exception;

	public void update(MatchingReply reply) throws Exception;

	public void delete(int mrno) throws Exception;
	
	public List<MatchingReply> listPage(int rno, Criteria cri) throws Exception;
	
	public int count(int rno) throws Exception;
	
	public int getBno(int mrno) throws Exception;
}
