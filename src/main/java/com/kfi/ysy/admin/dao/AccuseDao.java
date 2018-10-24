package com.kfi.ysy.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ysy.admin.vo.AccuseVo;



@Repository
public class AccuseDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kfi.mybatis.ysy.AccuseMapper.";
	public List<AccuseVo> aclist(){
		return sqlSession.selectList(NAMESPACE+"aclist");
	}
}