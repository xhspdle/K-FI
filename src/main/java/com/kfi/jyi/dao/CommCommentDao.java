package com.kfi.jyi.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommCommentVo;

@Repository
public class CommCommentDao {
	@Autowired SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommCommentMapper";
	
	public int select_CommentNum(int cb_num) {
		return session.selectOne(NAMESPACE+".select_CommentNum", cb_num);
	}
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	public int insert(CommCommentVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public List<CommCommentVo> list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".list",map);
	}
	
}
