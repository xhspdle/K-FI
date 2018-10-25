package com.kfi.ldk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.MyVideoDao;
import com.kfi.ldk.vo.MyVideoVo;
@Service
public class MyVideoService {
	@Autowired private MyVideoDao dao;
	public int getMaxNum() {
		return dao.getMaxNum();
	}
	public int getCount(Object data) {
		return dao.getCount();
	}
	public int insert(Object data) {
		MyVideoVo vo=(MyVideoVo)data;
		return dao.insert(vo);
	}
	public int update(Object data) {
		MyVideoVo vo=(MyVideoVo)data;
		return dao.update(vo);
	}
	public int delete(Object data) {
		int mp_num=(Integer)data;
		return dao.delete(mp_num);
	}
	public Object select(Object data) {
		int mp_num=(Integer)data;
		return dao.select(mp_num);
	}
	public List<Object> list(Object data) {
		return dao.list();
	}

}
