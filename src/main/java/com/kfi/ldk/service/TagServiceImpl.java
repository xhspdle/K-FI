package com.kfi.ldk.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.TagDao;

@Service
public class TagServiceImpl implements CommonService{
	@Autowired private TagDao tagDao;
	@Override
	public int getMaxNum() {
		return 0;
	}
	@Override
	public int getCount(Object data) {
		return 0;
	}
	@Override
	public int insert(Object data) {
		return 0;
	}
	@Override
	public int update(Object data) {
		return 0;
	}
	@Override
	public int delete(Object data) {
		return 0;
	}
	@Override
	public Object select(Object data) {
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object list(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		System.out.println("TagServiceImpl List¸Þ¼Òµå" + map);
		return tagDao.list(map);
	}
}
