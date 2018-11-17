package com.kfi.jyi.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommPhotoVo;

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
	
}
