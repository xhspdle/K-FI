package com.kfi.ysy.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ysy.vo.CommSkinProfileVo;

@Repository
public class CommSkinProfileDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.ysy.CommSkinProfileMapper";
	
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	
	public int insert(CommSkinProfileVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}

	
	
}
