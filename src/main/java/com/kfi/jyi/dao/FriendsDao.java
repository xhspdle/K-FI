package com.kfi.jyi.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.FriendsVo;

@Repository
public class FriendsDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.FriendsMapper";
	
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	
	public int insert(FriendsVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public int delete(HashMap<String, Object> map) {
		return session.delete(NAMESPACE+".delete",map);
	}
	
	public List<FriendsVo> list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".list",map);
	}
	
	
	
}
