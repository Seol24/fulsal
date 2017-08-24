package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.Board;
import com.dgit.domain.Criteria;

public interface BoardDAO {
	public List<Board> boardList() throws Exception;
	public Board boardRead(int bno) throws Exception;
	public void boardInsert(Board board) throws Exception;
	public void boardDelete(int bno) throws Exception;
	public void boardModify(Board board) throws Exception;
	public List<Board> boardListCriteria(Criteria cri) throws Exception;
	
	public int totalCount() throws Exception;
	
}
