package com.kfi.ldk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.CommVoteDao;
import com.kfi.ldk.dao.VotingOptionDao;
import com.kfi.ldk.dao.VotingUserListDao;

@Service
public class CommVoteServiceImpl implements CommonService{
	@Autowired private CommVoteDao cvDao;
	@Autowired private VotingOptionDao voDao;
	@Autowired private VotingUserListDao vuDao;
	@Override
	public int getMaxNum() {
		return cvDao.getMaxNum();
	}
	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		/*
		 * ¿©±âÇÒÂ÷·Ê
		 */
		return 0;
	}
	@Override
	public int insert(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int delete(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object select(Object data) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object list(Object data) {
		// TODO Auto-generated method stub
		return null;
	}
}
