package com.kfi.jyi.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.MySkinCoverVo;
import com.kfi.jyi.vo.MySkinVo;

@Repository
public class MySkinDao {
	@Autowired
	private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.MySkinMapper";

	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum_myskin");
	}
	
	public int insert(MySkinVo vo) {
		return session.insert(NAMESPACE + ".insert_myskin", vo);
	}

	public int delete(int ms_num) {
		return session.delete(NAMESPACE+".delete_myskin",ms_num);
	}
	
	public int update(MySkinVo vo) {
		return session.update(NAMESPACE+".update_myskin",vo);
	}
	
	public int getCount_like_Skin(int user_num) {
		return session.selectOne(NAMESPACE+".getCount_like_Skin",user_num);
	}
}
