package com.dgit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.Members;
import com.dgit.persistence.MembersDAO;

@Service
public class MembersServiceImpl implements MemberService {
	
	@Autowired
	private MembersDAO dao;

	@Override
	public void delete(String mid) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(mid);
	}

	@Override
	public void update(Members members) throws Exception {
		// TODO Auto-generated method stub
		dao.update(members);
	}

	@Override
	public Members list(String mid) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(mid);
	}

	@Override
	public Members login(String mid, String mpass) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(mid, mpass);
	}

	@Override
	public void createMember(Members members) throws Exception {
		// TODO Auto-generated method stub
		dao.createMember(members);
	}
	
	

}
