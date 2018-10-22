package com.kfi.ldk.dao;

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
	public int insert(MyBoardVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
}
