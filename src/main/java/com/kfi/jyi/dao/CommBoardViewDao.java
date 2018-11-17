package com.kfi.jyi.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommBoardViewVo;

@Repository
public class CommBoardViewDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommBoardViewMapper";
	
	//해당 커뮤니티의 선택한 게시물 불러오기
	public CommBoardViewVo select(HashMap<String, Object> map){
		return session.selectOne(NAMESPACE+".select_Community",map);
	}
	
	//해당 커뮤니티 전체 게시물 불러오기
	public List<CommBoardViewVo> list(HashMap<String, Object> map){
		return session.selectList(NAMESPACE+".select_Community",map);
	}
	
	
}
