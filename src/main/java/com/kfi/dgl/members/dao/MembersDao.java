package com.kfi.dgl.members.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kfi.dgl.members.vo.MembersVo;

public class MembersDao {
	private SqlSession sqlSession;
	private final static String
	NAMESPACE="com.kfi.mybatis.dgl.MembersMapper";
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	public int insert(MembersVo vo) {
		return sqlSession.insert(NAMESPACE +".insert", vo);
	}
	public List<MembersVo> list() {
		return sqlSession.selectList(NAMESPACE +".list");
	}
	public int delete(int num) {
		return sqlSession.delete(NAMESPACE +".delete",num);
	}
	/*
	 * public MembersVo select(int num) {
		return sqlSession.selectList(NAMESPACE + ".select");
	}*/
	public int update(MembersVo vo) {
		return sqlSession.update(NAMESPACE + ".update", vo);
	}
}
