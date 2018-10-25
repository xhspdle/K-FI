package com.kfi.ysy.admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ysy.admin.vo.AdminBoardVo;


@Repository
public class AdminBoardDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kfi.mybatis.ysy.AdminBoardMapper.";
	public List<AdminBoardVo> ablist(HashMap<String, Object> map){
		return sqlSession.selectList(NAMESPACE+"ablist", map);
	}
	public int abmaxcnt() {
		return sqlSession.selectOne(NAMESPACE+"abmaxcnt");
	}
	public int abinsert(AdminBoardVo vo) {
		return sqlSession.insert(NAMESPACE+"abinsert", vo);
	}
	public int abdelete(int ab_num) {
		return sqlSession.delete(NAMESPACE+"abdelete", ab_num);
	}
	public AdminBoardVo abdetail(int ab_num) {
		return sqlSession.selectOne(NAMESPACE+"abdetail", ab_num);
	}
	public int abgetcnt(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE+"abgetcnt", map);
	}
}
