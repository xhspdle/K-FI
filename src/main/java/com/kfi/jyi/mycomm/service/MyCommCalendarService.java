package com.kfi.jyi.mycomm.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.jyi.mycomm.dao.MyCommCalendarDao;
import com.kfi.jyi.mycomm.vo.CommCalendarVo;

@Service
public class MyCommCalendarService {
	@Autowired private MyCommCalendarDao dao;
	
	//유저가 속한 모임의 일정 가져오기 
	public List<CommCalendarVo> myCommCalendar(HashMap<String, Object> hm){
		return dao.myCommCalendar(hm);
	}
	
	
}
