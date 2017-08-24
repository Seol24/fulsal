package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.Board;
import com.dgit.domain.Criteria;
import com.dgit.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public List<Board> boardList() throws Exception {
		return dao.boardList();
	}

	@Override
	public Board boardRead(int bno) throws Exception {
		return dao.boardRead(bno);
	}

	@Override
	public void boardInsert(Board board) throws Exception {
		// TODO Auto-generated method stub
		dao.boardInsert(board);
	}

	@Override
	public void boardDelete(int bno) throws Exception {
		// TODO Auto-generated method stub
		dao.boardDelete(bno);
	}

	@Override
	public void boardModify(Board board) throws Exception {
		// TODO Auto-generated method stub
		dao.boardModify(board);
	}

	@Override
	public List<Board> boardListCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.boardListCriteria(cri);
	}

	@Override
	public int totalCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}

}
