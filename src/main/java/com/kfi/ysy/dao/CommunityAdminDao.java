package com.kfi.ysy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CommunityAdminDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.ysy.CommunityAdminMapper.";
	public List<CommunityAdminDao> list(Object data){
		return session.selectList(NAMESPACE+"list");
	}
}
