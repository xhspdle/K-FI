package com.kfi.jyi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.MySkinCoverVo;

@Repository
public class MySkinCoverDao {
	@Autowired
	private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.MySkinCoverMapper";

	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum_myskincover");
	}
	
	public int insert(MySkinCoverVo vo) {
		return session.insert(NAMESPACE + ".insert_myskin_cover", vo);
	}
	
	public int delete(int ms_num) {
		return session.delete(NAMESPACE+".delete_myskin_cover",ms_num);
	}

	public int update(MySkinCoverVo vo) {
		return session.update(NAMESPACE+".update_myskin_cover",vo);
	}
	
}
