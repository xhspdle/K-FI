package com.kfi.jyi.mycomm.dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.mycomm.vo.CommCalendarVo;
import com.kfi.jyi.mycomm.vo.CommunityVo;

@Repository
public class MyCommCalendarDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.MyCommCalendarMapper";
	
	//유저가 속한 모임의 일정 가져오기 
	public List<CommCalendarVo> myCommCalendar(int user_num){
		return session.selectList(NAMESPACE+".MyCommCalList",user_num);
	}
	
	//유저가 속한 모임의 일별 일정 가져오기
	public List<CommCalendarVo> findMyCommCal(HashMap<String, Object> hm){
		return session.selectList(NAMESPACE+".findMyCommCal",hm);
	}
	
	//유저가 가입한 모든 모임의 정보 가져오기
	public List<CommunityVo> getMyCommunityList(int user_num){
		return session.selectList(NAMESPACE+".myCommunityList",user_num);
	}
}
