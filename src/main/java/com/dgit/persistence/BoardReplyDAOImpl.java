package com.dgit.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dgit.domain.Board_reply;
import com.dgit.domain.Criteria;

@Repository
public class BoardReplyDAOImpl implements BoardReplyDAO {
	
	@Inject
	private SqlSession session;
	
	private static String  namespace = "com.dgit.mappers.BoardReplyMapper";
	
	
	@Override
	public List<Board_reply> list(Integer bno) throws Exception {
		List<Board_reply> list = session.selectList(namespace+".list", bno);
		System.out.println("-------------service");
		for(Board_reply s : list){
			System.out.println(s);
		}
		return list;
	}

	@Override
	public void create(Board_reply reply) throws Exception {
		session.insert(namespace + ".create", reply);
	}

	@Override
	public void update(Board_reply reply) throws Exception {
		session.update(namespace + ".update", reply);
	}

	@Override
	public void delete(Integer brno) throws Exception {
		session.delete(namespace + ".delete", brno);
	}

	@Override
	public List<Board_reply> listPage(Integer bno, Criteria cri) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("cri", cri);
		return session.selectList(namespace + ".listPage", map);
	}

	@Override
	public int count(int bno) throws Exception {
		return session.selectOne(namespace + ".count", bno);
	}

	@Override
	public int getBno(int brno) throws Exception {
		return session.selectOne(namespace +".getBno", brno);
	}

}
