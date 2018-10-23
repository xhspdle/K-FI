package com.kfi.ysy.admin.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ysy.admin.vo.AdminVo;



@Repository
public class AdminDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kfi.mybatis.ysy.AdminMapper.";
	public AdminVo login(HashMap<String, String> map) {
		return sqlSession.selectOne(NAMESPACE+"login", map);
	}
	public int checkid(String id) {
		return sqlSession.selectOne(NAMESPACE+"checkid", id);
	}
	public int join(AdminVo vo) {
		return sqlSession.insert(NAMESPACE+"join", vo);
	}
}
