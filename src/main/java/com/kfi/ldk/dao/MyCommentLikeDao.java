package com.kfi.ldk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.MyCommentLikeVo;

@Repository
public class MyCommentLikeDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.MyCommentLikeMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".getCount", map);
	}
	public int insert(MyCommentLikeVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int update(MyCommentLikeVo vo) {
		return session.update(NAMESPACE + ".update", vo);
	}
	public int delete(int mcl_num) {
		return session.delete(NAMESPACE + ".delete", mcl_num);
	}
	public List<Object> list(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".list", map);
	}
	public MyCommentLikeVo select(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".select", map);
	}
}
