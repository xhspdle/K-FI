package com.kfi.ysy.admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ysy.admin.vo.AdminVo;



@Repository
public class AdminDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kfi.mybatis.ysy.AdminMapper.";
	public int abmaxnum() {
		return sqlSession.selectOne(NAMESPACE+"abmaxnum");
	}
	public AdminVo adlogin(HashMap<String, String> map) {
		return sqlSession.selectOne(NAMESPACE+"adlogin", map);
	}
	public int adcheckid(String id) {
		return sqlSession.selectOne(NAMESPACE+"adcheckid", id);
	}
	public int adjoin(AdminVo vo) {
		return sqlSession.insert(NAMESPACE+"adjoin", vo);
	}
	public List<AdminVo> adminlist(){
		return sqlSession.selectList(NAMESPACE+"adminlist");
	}
}
