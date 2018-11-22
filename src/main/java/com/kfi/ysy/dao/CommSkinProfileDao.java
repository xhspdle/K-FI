package com.kfi.ysy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.strategy.SerializingInstantiatorStrategy;
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

	public CommSkinProfileVo select_usingProfile(int comm_num) {
		return session.selectOne(NAMESPACE+".select_usingProfile",comm_num);
	}
	
	public CommSkinProfileVo select(int comm_num) {
		return session.selectOne(NAMESPACE+".select",comm_num);
	}
	public int update(CommSkinProfileVo vo) {
		return session.update(NAMESPACE+".update",vo);
	}
}
