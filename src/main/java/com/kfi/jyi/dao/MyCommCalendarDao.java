package com.kfi.jyi.dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommCalendarVo;
import com.kfi.jyi.vo.CommunityVo;

@Repository
public class MyCommCalendarDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.MyCommCalendarMapper";
	
	//유저가 가입한 모든 모임의 정보 가져오기
	public List<CommunityVo> getMyCommunityList(int user_num){
		return session.selectList(NAMESPACE+".myCommunityList",user_num);
	}
	
	//유저의 참석유무 및 커뮤니티 선택에 따른 일정 불러오기
	public List<CommCalendarVo> getheringCalendar(HashMap<String, Object> hm){
		return session.selectList(NAMESPACE+".getheringCalendar",hm);
	}
	
	
	
	
}
