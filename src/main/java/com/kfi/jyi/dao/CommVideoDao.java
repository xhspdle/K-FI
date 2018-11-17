package com.kfi.jyi.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.jyi.vo.CommVideoVo;

@Repository
public class CommVideoDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommVideoMapper";
		
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	
	public int insert(CommVideoVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
}
