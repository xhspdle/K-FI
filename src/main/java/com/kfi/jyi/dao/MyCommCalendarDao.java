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
	
	//������ ������ ��� ������ ���� ��������
	public List<CommunityVo> getMyCommunityList(int user_num){
		return session.selectList(NAMESPACE+".myCommunityList",user_num);
	}
	
	//������ �������� �� Ŀ�´�Ƽ ���ÿ� ���� ���� �ҷ�����
	public List<CommCalendarVo> getheringCalendar(HashMap<String, Object> hm){
		return session.selectList(NAMESPACE+".getheringCalendar",hm);
	}
	
	
	
	
}
