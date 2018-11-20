package com.kfi.ldk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.VotingOptionVo;

@Repository
public class VotingOptionDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.VotingOptionMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".getCount", map);
	}
	public int insert(VotingOptionVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int update(VotingOptionVo vo) {
		return session.update(NAMESPACE + ".update", vo);
	}
	public int delete(int vo_num) {
		return session.delete(NAMESPACE + ".delete", vo_num);
	}
	public List<Object> list(int vote_num){
		return session.selectList(NAMESPACE + ".list", vote_num);
	}
}
