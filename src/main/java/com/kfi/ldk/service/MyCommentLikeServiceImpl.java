package com.kfi.ldk.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.MyCommentLikeDao;
import com.kfi.ldk.vo.MyCommentLikeVo;

@Service
public class MyCommentLikeServiceImpl implements CommonService{
	@Autowired private MyCommentLikeDao mclDao;
	@Override
	public int getMaxNum() {
		return mclDao.getMaxNum();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getCount(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mclDao.getCount(map);
	}
	@Override
	public int insert(Object data) {
		MyCommentLikeVo vo=(MyCommentLikeVo)data;
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("user_num", vo.getUser_num());
		map.put("myc_num", vo.getMyc_num());
		if(mclDao.select(map)!=null) {
			delete(vo.getUser_num());
			return -1;//ม฿บน
		}else {
			return mclDao.insert(new MyCommentLikeVo(getMaxNum()+1, vo.getMyc_num(), vo.getUser_num()));
		}
	}
	@Override
	public int update(Object data) {
		MyCommentLikeVo vo=(MyCommentLikeVo)data;
		return mclDao.update(vo);
	}
	@Override
	public int delete(Object data) {
		int user_num=(Integer)data;
		return mclDao.delete(user_num);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object select(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mclDao.select(map);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object list(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mclDao.list(map);
	}
	
}
