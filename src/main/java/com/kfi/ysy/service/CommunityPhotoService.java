package com.kfi.ysy.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.ysy.dao.CommnityPhotoDao;

@Service
public class CommunityPhotoService{
	@Autowired
	private CommnityPhotoDao cpdao;

	public int getMaxNum() {	
		return cpdao.getMaxNum();
	}

	public int insert(Object data) {	
		return cpdao.insert((CommPhotoVo)data);
	}

}