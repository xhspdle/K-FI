package com.kfi.ldk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.MyBoardDao;
import com.kfi.ldk.vo.MyBoardVo;

@Service
public class MyBoardService {
	@Autowired private MyBoardDao dao;
	public int getMaxnum() {
		return dao.getMaxnum();
	}
	public int getCount() {
		return dao.getCount();
	}
	public int insert(MyBoardVo vo) {
		return dao.insert(new MyBoardVo(getMaxnum(), vo.getUser_num(),
				vo.getMb_title(), vo.getMb_content(), null, 0));
	}
	public int addHit(int mb_num) {
		return dao.addHit(mb_num);
	}
	public int update(MyBoardVo vo) {
		return dao.update(vo);
	}
	public int delete(int mb_num) {
		return dao.delete(mb_num);
	}
	public List<MyBoardVo> list(){
		return dao.list();
	}
	public MyBoardVo getinfo(int mb_num) {
		return dao.getinfo(mb_num);
	}
}
