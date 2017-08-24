package com.dgit.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dgit.domain.Members;

@Repository
public class MembersDAOImpl implements MembersDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "com.dgit.mappers.MemberMapper";

	@Override
	public String readTime() throws Exception {
		// TODO Auto-generated method stub
		return (String)session.selectOne(namespace + ".getTime");
	}

	@Override
	public void createMember(Members members) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".createMember", members);
	}

	@Override
	public Members readMember(String mid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".readMember");
	}

	@Override
	public Members login(String mid, String mpass) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("mid", mid);
		map.put("mpass", mpass);
		
		return session.selectOne(namespace + ".readWithPW", map);
	}

	@Override
	public Members listAll() throws Exception {
		// TODO Auto-generated method stub
		return (Members)session.selectList(namespace + ".listAll");
	}

	@Override
	public void delete(String mid) throws Exception {
		// TODO Auto-generated method stub
		session.delete(namespace + ".delete", mid);
	}

	@Override
	public void update(Members members) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace + ".update", members);
	}

	@Override
	public Members list(String mid) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".list", mid);
	}

	
}
