package com.kfi.jyi.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommCommentLikeVo;

@Repository
public class CommCommentLikeDao {
	@Autowired SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommCommentLikeMapper";
	
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	public int insert(CommCommentLikeVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	public int delete(HashMap<String, Object> map) {
		return session.delete(NAMESPACE+".delete",map);
	}
	
	public int checkUserNum(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".checkUserNum",map);
	}
	
}
