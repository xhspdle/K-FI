package com.kfi.ldk.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.kfi.ldk.dao.MyBoardLikeDao;
import com.kfi.ldk.dao.MyCommentDao;
import com.kfi.ldk.dao.MyCommentLikeDao;
import com.kfi.ldk.dao.MyCommentListViewDao;
import com.kfi.ldk.vo.MyCommentLikeVo;
import com.kfi.ldk.vo.MyCommentVo;

@Service
public class MyCommentServiceImpl implements CommonService{
	@Autowired private MyCommentDao mcDao;
	@Autowired private MyCommentListViewDao mcViewDao;
	@Autowired private MyBoardLikeDao mblDao;
	@Autowired private MyCommentLikeDao mclDao;
	@Override
	public int getMaxNum() {
		return mcDao.getMaxNum();
	}
	@SuppressWarnings("unchecked")
	@Override
	public int getCount(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mcDao.getCount(map);
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
	@Transactional
	@Override
	public int delete(Object data) {
		int myc_num=(Integer)data;
		try {
			mclDao.delete(myc_num);
			mcDao.delete(myc_num);
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}
	@Override
	public Object select(Object data) {
		int user_num=(Integer)data;
		return mcDao.select(user_num);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Object list(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		map.put("boardLikeCnt", mblDao.getCount(map));
		map.put("commentCnt", mcDao.getCount(map));
		map.put("commentList", mcViewDao.list(map));
		return map;
	}
}
