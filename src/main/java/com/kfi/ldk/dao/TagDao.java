package com.kfi.ldk.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.TagVo;

@Repository
public class TagDao {
	@Autowired private SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.TagMapper";
	public int getMaxNum() {
		return session.selectOne(NAMESPACE + ".getMaxNum");
	}
	public int getCount(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE + ".getCount", map);
	}
	public int insert(TagVo vo) {
		return session.insert(NAMESPACE + ".insert", vo);
	}
	public int update(TagVo vo) {
		return session.update(NAMESPACE + ".update", vo);
	}
	public int delete(int user_num) {
		return session.delete(NAMESPACE + ".delete", user_num);
	}
	public List<Object> list(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE + ".list", map);
	}
	public TagVo select(String tag_name) {
		return session.selectOne(NAMESPACE + ".select", tag_name);
	}
}
