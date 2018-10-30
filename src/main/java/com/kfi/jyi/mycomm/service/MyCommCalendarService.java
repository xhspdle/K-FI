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
	
	//������ ���� ������ ���� �������� 
	public List<CommCalendarVo> myCommCalendar(int user_num){
		return dao.myCommCalendar(user_num);
	}
	
	//������ ������ ��� ������ ���� ��������
	public List<CommunityVo> getMyCommunityList(int user_num){
		return dao.getMyCommunityList(user_num);
	}
	
	/* ������ ���� ��� Ŀ�´�Ƽ ��� �ҷ����� */
	public List<CommCalendarVo> selectedCommCalList(int comm_num){
		return dao.selectedCommCalList(comm_num);
	}
}
