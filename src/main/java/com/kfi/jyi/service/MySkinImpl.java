package com.kfi.jyi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.jyi.dao.MySkinCoverDao;
import com.kfi.jyi.dao.MySkinDao;
import com.kfi.jyi.dao.MySkinProfileDao;

@Service
public class MySkinImpl implements MySkinService {
	@Autowired private MySkinDao msdao;
	@Autowired private MySkinCoverDao mscdao;
	@Autowired private MySkinProfileDao mspdao;
	
	@Override
	public int insert(Object obj) {
		
		
		return 0;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object select(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
