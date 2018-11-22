package com.kfi.jyi.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommunityVo;

@Repository
public class CommunityDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommunityMapper";
	
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	
	public int insert(CommunityVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}

	public List<CommunityVo> select_mycommlist(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".select_mycommlist",map);
	}
	
	public List<CommunityVo> bestSix(){
		return session.selectList(NAMESPACE+".bestSix");
	}
	
	public List<CommunityVo> list(){
		return session.selectList(NAMESPACE+".list");
	}	

	public int select_adminNum(int comm_num) {
		return session.selectOne(NAMESPACE+".select_adminNum", comm_num);
	}
	//커뮤니티 관리자에서 사용
	public CommunityVo select_comm(int comm_num) {
		return session.selectOne(NAMESPACE+".select_comm", comm_num);
	}
	public int update(CommunityVo vo) {
		return session.update(NAMESPACE+".update", vo);
	}

}
