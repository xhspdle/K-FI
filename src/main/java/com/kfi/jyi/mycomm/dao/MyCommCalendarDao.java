package com.kfi.jyi.mycomm.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.mycomm.vo.CommCalendarVo;

@Repository
public class MyCommCalendarDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.MyCommCalendarMapper";
	
	//유저가 속한 모임의 일정 가져오기 
	public List<CommCalendarVo> myCommCalendar(String user_id){
		return session.selectList(NAMESPACE+".MyCommCalList",user_id);
	}
	
}
