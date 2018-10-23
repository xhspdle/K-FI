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
	public int getMaxnum() {
		return session.selectOne(NAMESPACE + ".getMaxnum");
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
	public List<MyBoardVo> list(){
		return session.selectList(NAMESPACE + ".list");
	}
	public MyBoardVo getinfo(int mb_num) {
		return session.selectOne(NAMESPACE + ".getinfo", mb_num);
	}
}
