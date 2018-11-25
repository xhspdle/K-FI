package com.kfi.ldk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.MainCommunitySearchDao;
import com.kfi.ldk.vo.MainCommunitySearchJoinVo;

@Service
public class MainCommunitySearchService {
	@Autowired private MainCommunitySearchDao mcsDao;
	public int getCount(String keyword) {
		return mcsDao.getCount(keyword);
	}
	public List<MainCommunitySearchJoinVo> list(String keyword){
		return mcsDao.list(keyword);
	}
}
