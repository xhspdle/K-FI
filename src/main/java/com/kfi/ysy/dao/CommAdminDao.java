package com.kfi.ysy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class CommAdminDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.ysy.CommAdminMapper.";
	public List<CommAdminDao> list(int comm_num){
		return session.selectList(NAMESPACE+"list", comm_num);
	}
}
