package com.kfi.ldk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.MyBoardLikeVo;

@Repository
public class MyBoardLikeDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.MyBoardLikeMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".getCount", map);
	}
	public int insert(MyBoardLikeVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int update(MyBoardLikeVo vo) {
		return session.update(NAMESPACE + ".update", vo);
	}
	public int delete(HashMap<String, Object> map) {
		return session.delete(NAMESPACE + ".delete", map);
	}
	public List<Object> list(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".list", map);
	}
	public MyBoardLikeVo select(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".select", map);
	}
}
