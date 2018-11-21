package com.kfi.ldk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.CommVoteConfirmDelVo;
import com.kfi.ldk.vo.CommVoteVo;

@Repository
public class CommVoteDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.CommVoteMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount() {
		return session.selectOne(NAMESPACE + ".getCount");
	}
	public int insert(CommVoteVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int update(CommVoteVo vo) {
		return session.update(NAMESPACE + ".update", vo);
	}
	public int delete(int vote_num) {
		return session.delete(NAMESPACE + ".delete", vote_num);
	}
	public List<Object> list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE + ".list",map);
	}
	public CommVoteVo select(int vote_num) {
		return session.selectOne(NAMESPACE + ".select", vote_num);
	}
	public CommVoteConfirmDelVo confirmDel(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".confirmDel", map);
	}
}
