package com.kfi.jyi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.MySkinProfileVo;

@Repository
public class MySkinProfileDao {
	@Autowired
	private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.MySkinProfileMapper";
	
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum_myskinprofile");
	}
	
	public int insert(MySkinProfileVo vo) {
		return session.insert(NAMESPACE + ".insert_myskin_profile", vo);
	}
	
	
}
