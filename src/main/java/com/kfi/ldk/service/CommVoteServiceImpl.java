package com.kfi.ldk.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.kfi.ldk.dao.CommVoteDao;
import com.kfi.ldk.dao.CommVoteListViewDao;
import com.kfi.ldk.dao.VotingOptionDao;
import com.kfi.ldk.vo.CommVoteConfirmDelVo;
import com.kfi.ldk.vo.CommVoteVo;
import com.kfi.ldk.vo.VotingOptionVo;

@Service
public class CommVoteServiceImpl implements CommonService{
	@Autowired private CommVoteDao cvDao;
	@Autowired private VotingOptionDao voDao;
	@Autowired private CommVoteListViewDao cvViewDao;
	@Override
	public int getMaxNum() {
		return cvDao.getMaxNum();
	}
	@Override
	public int getCount(Object data) {
		return cvDao.getCount();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public int insert(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		CommVoteVo cvVo=(CommVoteVo)map.get("CommVoteVo");
		String[] vo_content=(String[])map.get("vo_content");
		try {
			int vote_num=getMaxNum() + 1;
			cvVo.setVote_num(vote_num);
			cvDao.insert(cvVo);
			for(int i=0;i<vo_content.length;i++) {
				voDao.insert(new VotingOptionVo(voDao.getMaxNum()+1, vote_num, i+1, vo_content[i]));
			}
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}
	@Override
	public int update(Object data) {
		return 0;
	}
	@SuppressWarnings("unchecked")
	@Override
	public int delete(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		int vote_num=(Integer)map.get("vote_num");
		CommVoteConfirmDelVo vo=cvDao.confirmDel(map);
		if(vo!=null) {
			return cvDao.delete(vote_num);
		}else {
			return -1;
		}
	}
	@Override
	public Object select(Object data) {
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object list(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return cvViewDao.list(map);
	}
}
