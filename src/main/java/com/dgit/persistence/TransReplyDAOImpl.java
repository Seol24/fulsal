package com.dgit.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dgit.domain.Board_reply;
import com.dgit.domain.Criteria;
import com.dgit.domain.Transfer;
import com.dgit.domain.Transfer_reply;

@Repository
public class TransReplyDAOImpl implements TransferReplyDAO {
	
	@Inject
	private SqlSession session;
	
	private String namespace = "com.dgit.mappers.TransferReplyMapper";

	@Override
	public List<Transfer_reply> list(Integer tno) throws Exception {
		// TODO Auto-generated method stub
		List<Transfer_reply> list = session.selectList(namespace+".list", tno);
		System.out.println("-------------service");
		for(Transfer_reply s : list){
			System.out.println(s);
		}
		return list;
	}

	@Override
	public void create(Transfer_reply reply) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", reply);
	}

	@Override
	public void update(Transfer_reply reply) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace +".update", reply);
	}

	@Override
	public void delete(Integer trno) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", trno); 
	}

	@Override
	public List<Transfer_reply> listPage(Integer tno, Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("tno", tno);
		map.put("cri", cri);
		return session.selectList(namespace + ".listPage", map);
	}

	@Override
	public int count(int tno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".count", tno);
	}

	@Override
	public int getTno(int trno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace +".getTno", trno);
	}
}
