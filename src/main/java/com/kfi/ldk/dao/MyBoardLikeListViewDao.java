package com.kfi.ldk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBoardLikeListViewDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.MyBoardLikeListViewMapper";
	public int getCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".getCount", map);
	}
	public List<Object> list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE + ".list", map);
	}
	public List<Object> select(int mb_num) {
		return session.selectList(NAMESPACE + ".select", mb_num);
	}
}
