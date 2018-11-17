package com.kfi.jyi.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommRefuseVo;

@Repository
public class CommRefuseDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommRefuseMapper";
	
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	
	public int insert(CommRefuseVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
}
