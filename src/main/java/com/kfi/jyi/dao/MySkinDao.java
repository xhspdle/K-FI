package com.kfi.jyi.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.MySkinVo;

@Repository
public class MySkinDao {
	@Autowired
	private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.MySkinMapper";

	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum_myskin");
	}
	
	public int insert(MySkinVo vo) {
		return session.insert(NAMESPACE + ".insert_myskin", vo);
	}



}