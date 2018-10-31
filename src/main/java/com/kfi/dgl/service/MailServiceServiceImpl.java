package com.kfi.dgl.service;
/*package com.kfi.dgl.members.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfi.dgl.certiMembers.util.CreatekeyService;
import com.kfi.dgl.members.dao.MembersDao;
import com.kfi.dgl.members.vo.CertiMailVo;
import com.kfi.dgl.members.vo.MembersVo;

@Service
public class MailServiceServiceImpl implements CreatekeyService{
	@Autowired private MembersDao mbDao;
	
	@Transactional
	@Override
	public Object select(Object data) {
		MembersVo vo = (MembersVo)data;
		mbDao.findEmail(vo);
		return mbDao.findEmail(vo);
	}
	
	@Override
	public int insert(Object data) {
		CertiMailVo vo = (CertiMailVo)data;
		mbDao.createKey(vo);

	}
	
	
	
}
*/