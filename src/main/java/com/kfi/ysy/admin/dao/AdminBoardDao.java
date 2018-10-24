package com.kfi.ysy.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ysy.admin.vo.AdminBoardVo;


@Repository
public class AdminBoardDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kfi.mybatis.ysy.AdminBoardMapper.";
	public List<AdminBoardVo> ablist(){
		return sqlSession.selectList(NAMESPACE+"ablist");
	}
	public int abmaxcnt() {
		return sqlSession.selectOne(NAMESPACE+"abmaxcnt");
	}
	public int abinsert(AdminBoardVo vo) {
		return sqlSession.insert(NAMESPACE+"abinsert", vo);
	}
}
