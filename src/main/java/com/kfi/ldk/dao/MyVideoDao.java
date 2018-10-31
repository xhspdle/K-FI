package com.kfi.ldk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.MyVideoVo;

@Repository
public class MyVideoDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.MyVideoMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount() {
		return session.selectOne(NAMESPACE + ".getCount");
	}
	public int insert(MyVideoVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int update(MyVideoVo vo) {
		return session.update(NAMESPACE + ".update", vo);
	}
	public int delete(int mv_num) {
		return session.delete(NAMESPACE + ".delete", mv_num);
	}
	public List<Object> list() {
		return session.selectList(NAMESPACE + ".list");
	}
	public List<Object> select(int mb_num) {
		return session.selectList(NAMESPACE + ".select", mb_num);
	}
}
