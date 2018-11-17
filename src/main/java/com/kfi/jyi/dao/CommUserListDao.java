package com.kfi.jyi.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommUserListVo;

@Repository
public class CommUserListDao {
	@Autowired
	private SqlSession session;
	private final static String NAMESPACE = "com.kfi.mybatis.jyi.CommUserListMapper";

	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}

	public int insert(CommUserListVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}

	public int delete(HashMap<String, Object> map) {
		return session.delete(NAMESPACE + ".delete", map);
	}

	public int update(HashMap<String, Object> map) {
		return session.update(NAMESPACE + ".update", map);
	}

	public int getCul_status(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".getCul_status", map);
	}
}
