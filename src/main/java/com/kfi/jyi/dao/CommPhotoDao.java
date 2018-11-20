package com.kfi.jyi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.jyi.vo.HotPhoto3Vo;

@Repository
public class CommPhotoDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommPhotoMapper";
		
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	
	public int insert(CommPhotoVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public List<CommPhotoVo> select(int cb_num){
		return session.selectList(NAMESPACE+".select",cb_num);
	}
	
	public List<HotPhoto3Vo> hotPhoto3(){
		return session.selectList(NAMESPACE+".hotPhoto3");
	}
	
	
}
