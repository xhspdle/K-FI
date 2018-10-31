package com.kfi.jyi.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.jyi.dao.MyCommCalendarDao;
import com.kfi.jyi.vo.CommCalendarVo;
import com.kfi.jyi.vo.CommunityVo;

@Service
public class MyCommCalendarService {
	@Autowired private MyCommCalendarDao dao;
	
	//유저가 가입한 모든 모임의 정보 가져오기
	public List<CommunityVo> getMyCommunityList(int user_num){
		return dao.getMyCommunityList(user_num);
	}
	
	//유저의 참석유무 및 커뮤니티 선택에 따른 일정 불러오기
	public List<CommCalendarVo> getheringCalendar(HashMap<String, Object> hm){
		return dao.getheringCalendar(hm);
	}
	
}
