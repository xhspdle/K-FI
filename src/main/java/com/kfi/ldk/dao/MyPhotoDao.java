package com.kfi.ldk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.MyPhotoVo;

@Repository
public class MyPhotoDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.MyPhotoMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount() {
		return session.selectOne(NAMESPACE + ".getCount");
	}
	public int insert(MyPhotoVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int update(MyPhotoVo vo) {
		return session.update(NAMESPACE + ".update", vo);
	}
	public int delete(int mp_num) {
		return session.delete(NAMESPACE + ".delete", mp_num);
	}
	public List<Object> list() {
		return session.selectList(NAMESPACE + ".list");
	}
	public List<Object> select(int mb_num) {
		return session.selectList(NAMESPACE + ".select", mb_num);
	}
}
