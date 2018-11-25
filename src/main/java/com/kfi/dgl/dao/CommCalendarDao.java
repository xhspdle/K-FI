package com.kfi.dgl.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommCalendarVo;

@Repository
public class CommCalendarDao {
	@Autowired
	private SqlSession sqlSession;
	private final static String NAMESPACE = "com.kfi.mybatis.dgl.CommCalendarMapper";

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public int commgetMaxnum() {
		return sqlSession.selectOne(NAMESPACE + ".commgetMaxnum");
	}

	public int insertEvent(CommCalendarVo vo) {
		return sqlSession.insert(NAMESPACE + ".insertEvent", vo);
	}

	public int updateEvent(CommCalendarVo vo) {
		return sqlSession.update(NAMESPACE + ".updateEvent", vo);
	}

	public int deleteEvent(String cc_name) {
		return sqlSession.delete(NAMESPACE + ".deleteEvent", cc_name);
	}

	public int selectEvent(int comm_num) {
		return sqlSession.selectOne(NAMESPACE + ".selectEvent", comm_num);
	}

	public List<CommCalendarVo> listEvent(int comm_num) {
		return sqlSession.selectList(NAMESPACE + ".listEvent", comm_num);
	}

}
