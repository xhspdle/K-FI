package com.kfi.ldk.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.VotingOptionDao;
import com.kfi.ldk.dao.VotingUserListDao;
import com.kfi.ldk.vo.VotingUserListVo;

@Service
public class VotingUserListServiceImpl implements CommonService{
	@Autowired private VotingUserListDao vulDao;
	@Autowired private VotingOptionDao voDao;
	@Override
	public int getMaxNum() {
		return vulDao.getMaxNum();
	}
	@Override
	public int getCount(Object data) {
		return vulDao.getCount();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int insert(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		int user_num=(Integer)map.get("user_num");
		int vo_num=(Integer)map.get("vo_num");
		if(select(map)!=null) {
			delete(map);
			return -1;//ม฿บน
		}else {
			return vulDao.insert(new VotingUserListVo(getMaxNum() + 1, vo_num, user_num));
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
		return vulDao.delete(map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object select(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return vulDao.select(map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object list(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		int vote_num=(Integer)map.get("vote_num");
		map.put("votedOptionList", voDao.list(vote_num));
		map.put("totalVoteCnt", voDao.getCount(map));
		return map;
	}
}
