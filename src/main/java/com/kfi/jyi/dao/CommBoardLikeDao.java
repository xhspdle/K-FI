package com.kfi.jyi.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommBoardLikeVo;

@Repository
public class CommBoardLikeDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommBoardLikeMapper";
	
	public List<CommBoardLikeVo> select(int cb_num){
		return session.selectList(NAMESPACE+".select",cb_num);
	}
	
	public int getBoardLikeUserNum(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".getBoardLikeUserNum",map);
	}
	
	public int insert(CommBoardLikeVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public int delete(HashMap<String, Object> map) {
		return session.delete(NAMESPACE+".delete",map);
	}
	
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
}
