package com.kfi.jyi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.MySkinViewVo;

@Repository
public class MySkinViewDao {
	@Autowired
	private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.MySkinViewMapper";

	public List<MySkinViewVo> list(int user_num){
		return session.selectList(NAMESPACE+".list",user_num);
	}
	
	
	
}
