package com.kfi.ldk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.MyBoardDao;
import com.kfi.ldk.vo.MyBoardVo;

@Service
public class MyBoardService implements CommonService{
	@Autowired private MyBoardDao dao;
	public int addHit(int mb_num) {
		return dao.addHit(mb_num);
	}
	@Override
	public int getMaxNum() {
		return dao.getMaxNum();
	}
	@Override
	public int getCount(Object data) {
		return dao.getCount();
	}
	@Override
	public int insert(Object data) {
		MyBoardVo vo=(MyBoardVo)data;
		return dao.insert(new MyBoardVo(getMaxNum(), vo.getUser_num(),
				vo.getMb_title(), vo.getMb_content(), null, 0));
	}
	@Override
	public int update(Object data) {
		MyBoardVo vo=(MyBoardVo)data;
		return dao.update(vo);
	}
	@Override
	public int delete(Object data) {
		int mb_num=(Integer)data;
		return dao.delete(mb_num);
	}
	@Override
	public Object select(Object data) {
		int mb_num=(Integer)data;
		return dao.select(mb_num);
	}
	@Override
	public List<Object> list(Object data) {
		return dao.list();
	}
}
