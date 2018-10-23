package com.kfi.ysy.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ysy.admin.vo.MembersVo;

@Repository
public class MembersDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kfi.mybatis.ysy.MembersMapper.";
	public List<MembersVo> mblist(){
		return sqlSession.selectList(NAMESPACE+"mblist");
	}
	public MembersVo mbgetinfo(int user_num) {
		return sqlSession.selectOne(NAMESPACE+"mbgetinfo", user_num);
	}
	public int mbdelete(int user_num) {
		return sqlSession.delete(NAMESPACE+"mbdelete", user_num);
	}
}
