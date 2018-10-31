package com.kfi.ysy.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ysy.vo.AccuseVo;



@Repository
public class AccuseDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kfi.mybatis.ysy.AccuseMapper.";
	public List<AccuseVo> aclist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+"aclist", map);
	}
	public int acgetcnt(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+"acgetcnt" ,map);
	}
}
