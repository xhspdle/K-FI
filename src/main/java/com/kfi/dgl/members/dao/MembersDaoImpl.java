package com.kfi.dgl.members.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.dgl.members.vo.MembersVo;

@Repository
public class MembersDaoImpl implements MembersDaoInterface{
	@Autowired
	SqlSession sqlSession;

	@Override
	public MembersVo login(HashMap<String, Object> map) {
		return sqlSession.selectOne("com.kfi.mybatis.dgl.MembersMapper.login",map);
	}
}
