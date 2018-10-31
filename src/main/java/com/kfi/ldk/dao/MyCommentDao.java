package com.kfi.ldk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.MyCommentVo;

@Repository
public class MyCommentDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.MyCommentMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount(int mb_num) {
		return session.selectOne(NAMESPACE + ".getCount", mb_num);
	}
	public int insert(MyCommentVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int update(MyCommentVo vo) {
		return session.update(NAMESPACE + ".update", vo);
	}
	public int delete(int myc_num) {
		return session.delete(NAMESPACE + ".delete", myc_num);
	}
	public List<Object> list(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".list", map);
	}
	public List<Object> select(int user_num) {
		return session.selectList(NAMESPACE + ".select", user_num);
	}
}
