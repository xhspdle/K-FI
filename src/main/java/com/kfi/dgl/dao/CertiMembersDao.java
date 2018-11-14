package com.kfi.dgl.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.dgl.vo.CertiMembersVo;

@Repository
public class CertiMembersDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.dgl.CertiMembersMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	//인증코드(키) 생성
	public int insert(CertiMembersVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int delete(int cm_num) {
		return session.delete(NAMESPACE + ".delete", cm_num);
	}
	public CertiMembersVo select(int user_num) {
		return session.selectOne(NAMESPACE + ".select", user_num);
	}
	public int selectCode(String cm_key) {
		return session.selectOne(NAMESPACE + ".selectCode", cm_key);
	}
	
}
