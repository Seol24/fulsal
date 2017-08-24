package com.dgit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dgit.domain.Criteria;
import com.dgit.domain.Transfer;

@Repository
public class TransferDAOImpl implements TransferDAO {
	
	@Inject
	private SqlSession session;
	
	private static String  namespace = "com.dgit.mapper.TransferMapper";
	@Override
	public List<Transfer> transferList() throws Exception {
		return session.selectList(namespace + ".transferList");
	}

	@Override
	public Transfer transferRead(int tno) throws Exception {
		return session.selectOne(namespace +".transferRead", tno);
	}

	@Override
	public void transferInsert(Transfer transfer) throws Exception {
		session.insert(namespace + ".transferInsert", transfer);
	}

	@Override
	public void transferDelete(int tno) throws Exception {
		session.delete(namespace + ".transferDelete", tno);
	}

	@Override
	public void transferModify(Transfer transfer) throws Exception {
		session.update(namespace + ".transferModify", transfer);
	}

	@Override
	public List<Transfer> transferListCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".transferListCriteria", cri);
	}

	@Override
	public int totalCount() throws Exception {
		return session.selectOne(namespace + ".totalCount");
	}

}
