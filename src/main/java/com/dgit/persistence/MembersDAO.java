package com.dgit.persistence;

import com.dgit.domain.Members;

public interface MembersDAO {
	
	public String readTime() throws Exception;
	public void createMember(Members members) throws Exception;
	public Members readMember(String mid) throws Exception;
	public Members login(String mid, String mpass) throws Exception;
	public Members listAll() throws Exception;
	public void delete(String mid) throws Exception;
	public void update(Members members)throws Exception;
	public Members list(String mid) throws Exception;
	
	
}
