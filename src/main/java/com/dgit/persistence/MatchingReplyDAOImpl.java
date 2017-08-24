package com.dgit.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dgit.domain.Criteria;
import com.dgit.domain.MatchingReply;

@Repository
public class MatchingReplyDAOImpl implements MatchingReplyDAO {
	
	@Inject
	private SqlSession session;

	private static String namespace = "com.dgit.mappers.MatchingReplyMapper";

	@Override
	public List<MatchingReply> list(int rno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list", rno);
	}

	@Override
	public void create(MatchingReply reply) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", reply);
	}

	@Override
	public void update(MatchingReply reply) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", reply);
	}

	@Override
	public void delete(int mrno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", mrno);
	}

	@Override
	public List<MatchingReply> listPage(int rno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("rno",  rno);
		map.put("cri", cri);
		return session.selectList(namespace + ".listPage", map);
	}

	@Override
	public int count(int rno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace +".count", rno);
	}

	@Override
	public int getBno(int mrno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace +".getBno", mrno);
	}

}
