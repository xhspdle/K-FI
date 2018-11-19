package com.kfi.jyi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommBoardVo;

@Repository
public class CommBoardDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommBoardMapper";
		
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	
	public int insert(CommBoardVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public List<CommBoardVo> getNotice(int comm_num) {
		return session.selectList(NAMESPACE+".getNotice",comm_num);
	}
}
