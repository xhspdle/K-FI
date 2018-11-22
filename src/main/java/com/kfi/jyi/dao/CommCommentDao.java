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
	
	public int update_CommcLike(int commc_num) {
		return session.update(NAMESPACE+".update_CommcLike",commc_num);
	}
	
	public int update_disCommcLike(int commc_num) {
		return session.update(NAMESPACE+".update_disCommcLike",commc_num);
	}
	
	public int getCommcLikeCnt(int commc_num) {
		return session.selectOne(NAMESPACE+".getCommcLikeCnt",commc_num);
	}
	
	public int delete(int commc_num) {
		return session.delete(NAMESPACE+".delete",commc_num);
	}
	
	public int update(HashMap<String, Object> map) {
		return session.update(NAMESPACE+".update",map);
	}
	
}
