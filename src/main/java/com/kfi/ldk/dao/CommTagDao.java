package com.kfi.ldk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.CommTagVo;

@Repository
public class CommTagDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.CommTagMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".getCount", map);
	}
	public int insert(CommTagVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int update(CommTagVo vo) {
		return session.update(NAMESPACE + ".update", vo);
	}
	public int delete(int user_num) {
		return session.delete(NAMESPACE + ".delete", user_num);
	}
	public List<Object> list(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".list", map);
	}
	public CommTagVo select(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".select", map);
	}
}
