package com.kfi.ldk.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.MyBoardLikeDao;
import com.kfi.ldk.dao.MyBoardLikeListViewDao;
import com.kfi.ldk.vo.MyBoardLikeVo;

@Service
public class MyBoardLikeServiceImpl implements CommonService{
	@Autowired private MyBoardLikeDao mblDao;
	@Autowired private MyBoardLikeListViewDao mblViewDao;
	@Override
	public int getMaxNum() {
		return mblDao.getMaxNum();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getCount(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mblDao.getCount(map);
	}
	@Override
	public int insert(Object data) {
		MyBoardLikeVo vo=(MyBoardLikeVo)data;
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("user_num", vo.getUser_num());
		map.put("mb_num", vo.getMb_num());
		if(mblDao.select(map)!=null) {
			delete(map);
			return -1;//�ߺ�
		}else {
			return mblDao.insert(new MyBoardLikeVo(getMaxNum() + 1, vo.getMb_num(), vo.getUser_num()));
		}
	}
	@Override
	public int update(Object data) {
		MyBoardLikeVo vo=(MyBoardLikeVo)data;
		return mblDao.update(vo);
	}
	@SuppressWarnings("unchecked")
	@Override
	public int delete(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mblDao.delete(map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object select(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mblDao.select(map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object list(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mblViewDao.list(map);
	}
}
