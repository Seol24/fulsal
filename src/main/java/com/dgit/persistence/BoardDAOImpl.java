package com.dgit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dgit.domain.Board;
import com.dgit.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {


	@Inject
	private SqlSession session;
	
	private static String  namespace = "com.dgit.mapper.BoardMapper";
	

	@Override
	public List<Board> boardList() throws Exception {
		return session.selectList(namespace + ".boardList");
	}


	@Override
	public Board boardRead(int bno) throws Exception {
		return session.selectOne(namespace + ".boardRead", bno);
	}


	@Override
	public void boardInsert(Board board) throws Exception {
		session.insert(namespace + ".boardInsert", board);
	}


	@Override
	public void boardDelete(int bno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".boardDelete", bno);
	}


	@Override
	public void boardModify(Board board) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".boardModify", board);
	}


	@Override
	public List<Board> boardListCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace +".boardListCriteria", cri);
	}

	@Override
	public int totalCount() throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".totalCount");
	}

}
