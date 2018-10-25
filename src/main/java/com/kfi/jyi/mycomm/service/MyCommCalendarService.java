package com.kfi.jyi.mycomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.jyi.mycomm.dao.MyCommCalendarDao;
import com.kfi.jyi.mycomm.vo.CommCalendarVo;

@Service
public class MyCommCalendarService {
	@Autowired private MyCommCalendarDao dao;
	
	//������ ���� ������ ���� �������� 
	public List<CommCalendarVo> myCommCalendar(String user_id){
		return dao.myCommCalendar(user_id);
	}
	
	
}