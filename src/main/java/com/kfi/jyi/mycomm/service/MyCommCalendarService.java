package com.kfi.jyi.mycomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.jyi.mycomm.dao.MyCommCalendarDao;
import com.kfi.jyi.mycomm.vo.CommCalendarVo;
import com.kfi.jyi.mycomm.vo.CommunityVo;

@Service
public class MyCommCalendarService {
	@Autowired private MyCommCalendarDao dao;
	
	//유저가 속한 모임의 일정 가져오기 
	public List<CommCalendarVo> myCommCalendar(int user_num){
		return dao.myCommCalendar(user_num);
	}
	
	//유저가 가입한 모든 모임의 정보 가져오기
	public List<CommunityVo> getMyCommunityList(int user_num){
		return dao.getMyCommunityList(user_num);
	}
	
	/* 유저가 속한 모든 커뮤니티 목록 불러오기 */
	public List<CommCalendarVo> selectedCommCalList(int comm_num){
		return dao.selectedCommCalList(comm_num);
	}
}
