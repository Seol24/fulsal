package com.dgit.service;

import java.util.List;

import com.dgit.domain.Board_reply;
import com.dgit.domain.Criteria;

public interface BoardReplyService {
	public List<Board_reply> list(Integer bno) throws Exception;

	public void create(Board_reply reply) throws Exception;

	public void update(Board_reply reply) throws Exception;

	public void delete(Integer brno) throws Exception;
	
	public List<Board_reply> listPage(Integer bno, Criteria cri) throws Exception;
	
	public int count(int bno) throws Exception;
	public int getBno(int brno) throws Exception;
	
}
