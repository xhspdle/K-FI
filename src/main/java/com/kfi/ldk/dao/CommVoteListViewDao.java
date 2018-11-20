package com.kfi.ldk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.CommVoteList;

@Repository
public class CommVoteListViewDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.CommVoteListViewMapper";
	public int getCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".getCount", map);
	}
/*	public List<CommVoteList> list(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".list", map);
	}*/
	public List<CommVoteList> list(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".voteList", map);
	}
}
