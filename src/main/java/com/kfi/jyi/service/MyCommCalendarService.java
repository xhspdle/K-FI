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
	
	//������ ������ ��� ������ ���� ��������
	public List<CommunityVo> getMyCommunityList(int user_num){
		return dao.getMyCommunityList(user_num);
	}
	
	//������ �������� �� Ŀ�´�Ƽ ���ÿ� ���� ���� �ҷ�����
	public List<CommCalendarVo> getheringCalendar(HashMap<String, Object> hm){
		return dao.getheringCalendar(hm);
	}
	
}
