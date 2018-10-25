package com.kfi.ldk.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.kfi.ldk.dao.MyBoardDao;
import com.kfi.ldk.dao.MyPhotoDao;
import com.kfi.ldk.dao.MyVideoDao;
import com.kfi.ldk.vo.MyBoardVo;
import com.kfi.ldk.vo.MyPhotoVo;
import com.kfi.ldk.vo.MyVideoVo;

@Service
public class MyBoardServiceImpl implements CommonService{
	@Autowired private MyBoardDao mbDao;
	@Autowired private MyPhotoDao mpDao;
	@Autowired private MyVideoDao mvDao;
	public int addHit(int mb_num) {
		return mbDao.addHit(mb_num);
	}
	@Override
	public int getMaxNum() {
		return mbDao.getMaxNum();
	}
	@Override
	public int getCount(Object data) {
		return mbDao.getCount();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public int insert(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		MyBoardVo mbVo=(MyBoardVo)map.get("mbVo");
		int mpVoLength=(Integer)map.get("mpVoLength");
		int mvVoLength=(Integer)map.get("mvVoLength");
		int mb_num=getMaxNum();
		int mp_num=mpDao.getMaxNum();
		int mv_num=mvDao.getMaxNum();
		try {
			System.out.println(mbVo.getMb_title());
			mbDao.insert(new MyBoardVo(mb_num, mbVo.getUser_num(),
					mbVo.getMb_title(), mbVo.getMb_content(), null, 0));
			for(int i=0;i<mpVoLength;i++) {
				MyPhotoVo mpVo=(MyPhotoVo)map.get("mpVo");
				mpDao.insert(new MyPhotoVo(mp_num + i, mb_num, mpVo.getMp_orgimg(),mpVo.getMp_savimg()));
			}
			for(int i=0;i<mvVoLength;i++) {
				MyVideoVo mvVo=(MyVideoVo)map.get("mvVo");
				mvDao.insert(new MyVideoVo(mv_num + i, mb_num, mvVo.getMv_orgvid(), mvVo.getMv_savvid()));
			}
			return 1;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}
	@Transactional
	@Override
	public int update(Object data) {
		MyBoardVo vo=(MyBoardVo)data;
		return mbDao.update(vo);
	}
	@Transactional
	@Override
	public int delete(Object data) {
		int mb_num=(Integer)data;
		return mbDao.delete(mb_num);
	}
	@Override
	public Object select(Object data) {
		int mb_num=(Integer)data;
		return mbDao.select(mb_num);
	}
	@Override
	public List<Object> list(Object data) {
		@SuppressWarnings("unchecked")
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		return mbDao.list(map);
	}
}
