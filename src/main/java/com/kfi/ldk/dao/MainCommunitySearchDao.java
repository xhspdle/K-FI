package com.kfi.ldk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.MainCommunitySearchJoinVo;

@Repository
public class MainCommunitySearchDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.MainCommunitySearchMapper";
	public int getCount(String keyword) {
		return session.selectOne(NAMESPACE + ".getCount", keyword);
	}
	public List<MainCommunitySearchJoinVo> list(String keyword){
		return session.selectList(NAMESPACE + ".list", keyword);
	}
}
