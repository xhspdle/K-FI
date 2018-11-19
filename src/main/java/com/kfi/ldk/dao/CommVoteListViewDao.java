package com.kfi.ldk.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommVoteListViewDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.CommVoteListView";
}
