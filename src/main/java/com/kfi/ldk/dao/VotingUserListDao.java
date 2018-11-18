package com.kfi.ldk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.VotingOptionVo;

@Repository
public class VotingUserListDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.VotingUserListMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount() {
		return session.selectOne(NAMESPACE + ".getCount");
	}
	public int insert(VotingOptionVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int delete(HashMap<String, Object> map) {
		return session.delete(NAMESPACE + ".delete", map);
	}
	public List<Object> list(int vo_num){
		return session.selectList(NAMESPACE + ".list", vo_num);
	}
}
