package ITzy.OTT.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ITzy.OTT.dao.PdsDao;
import ITzy.OTT.dto.BbsParam;
import ITzy.OTT.dto.PdsDto;
@Repository
public class PdsDaoImpl implements PdsDao{
	@Autowired
	SqlSessionTemplate session;
	
	String ns = "Pds.";

	@Override
	public List<PdsDto> pdslist(BbsParam pds) {
		return session.selectList(ns + "pdslist", pds);
	}

	@Override
	public int uploadPds(PdsDto dto) {
		return session.insert(ns + "uploadPds", dto);
	}

	@Override
	public void downcount(int seq) {
		session.update(ns + "downcount", seq);
	}

	@Override
	public PdsDto getPds(int seq) {
		return session.selectOne(ns + "getPds", seq);
	}


	@Override
	public int getAllPds(BbsParam pds) {
		return session.selectOne(ns + "getAllPds", pds);
	}

	@Override
	public int updatePds(PdsDto dto) {
		return session.update(ns + "updatePds", dto);
	}

	@Override
	public PdsDto deletePds(int seq) {
		return session.selectOne(ns + "deletePds", seq);
	}

	
}
