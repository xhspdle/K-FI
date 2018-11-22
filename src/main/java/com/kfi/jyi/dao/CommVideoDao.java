package com.kfi.jyi.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.jyi.vo.CommVideoVo;
import com.kfi.jyi.vo.HotVideoVo;

@Repository
public class CommVideoDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommVideoMapper";
		
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	
	public int insert(CommVideoVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public List<CommVideoVo> select(int cb_num){
		return session.selectList(NAMESPACE+".select",cb_num);
	}
	
	public HotVideoVo hotVideo() {
		return session.selectOne(NAMESPACE+".hotVideo");
	}
	
	public CommVideoVo getCommVideo1(int cb_num) {
		return session.selectOne(NAMESPACE+".getCommVideo1",cb_num);
	}
	
}
