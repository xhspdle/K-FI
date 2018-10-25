package com.kfi.ldk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.MyBoardVo;

@Repository
public class MyBoardDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.MyBoardMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount() {
		return session.selectOne(NAMESPACE + ".getCount");
	}
	public int insert(MyBoardVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int addHit(int mb_num) {
		return session.update(NAMESPACE + ".addHit", mb_num);
	}
	public int update(MyBoardVo vo) {
		return session.update(NAMESPACE + ".update", vo);
	}
	public int delete(int mb_num) {
		return session.delete(NAMESPACE + ".delete", mb_num);
	}
	public List<Object> list(){
		return session.selectList(NAMESPACE + ".list");
	}
	public MyBoardVo select(int mb_num) {
		return session.selectOne(NAMESPACE + ".select", mb_num);
	}
}
