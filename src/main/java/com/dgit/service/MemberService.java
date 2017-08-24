package com.dgit.service;

import com.dgit.domain.Members;

public interface MemberService {
	public void delete(String mid) throws Exception;
	
	public void update(Members members)throws Exception;
	
	public Members list(String mid) throws Exception;
	
	public Members login(String mid, String mpass) throws Exception;
	
	public void createMember(Members members) throws Exception;
}

