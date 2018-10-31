package com.kfi.ldk.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.MyCommentDao;
import com.kfi.ldk.vo.MyCommentVo;

@Service
public class MyCommentServiceImpl implements CommonService{
	@Autowired private MyCommentDao mcDao;
	@Override
	public int getMaxNum() {
		return mcDao.getMaxNum();
	}
	@Override
	public int getCount(Object data) {
		int mb_num=(Integer)data;
		return mcDao.getCount(mb_num);
	}
	@Override
	public int insert(Object data) {
		MyCommentVo vo=(MyCommentVo)data;
		return mcDao.insert(new MyCommentVo(getMaxNum() +1,
				vo.getMb_num(), vo.getUser_num(), vo.getMyc_content(), null));
	}
	@Override
	public int update(Object data) {
		MyCommentVo vo=(MyCommentVo)data;
		return mcDao.update(vo);
	}
	@Override
	public int delete(Object data) {
		int myc_num=(Integer)data;
		return mcDao.delete(myc_num);
	}
	@Override
	public Object select(Object data) {
		int user_num=(Integer)data;
		return mcDao.select(user_num);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> list(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mcDao.list(map);
	}
}
