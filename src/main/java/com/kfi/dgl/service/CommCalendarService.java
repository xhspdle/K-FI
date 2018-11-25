package com.kfi.dgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.dgl.dao.CommCalendarDao;
import com.kfi.jyi.vo.CommCalendarVo;

@Service
public class CommCalendarService {

	@Autowired CommCalendarDao ccdao;
	
	public int getMaxnum() {
		return ccdao.commgetMaxnum();
	}
	public int addEvent(CommCalendarVo vo) {
		return ccdao.insertEvent(vo);
	}
	public int updateEvent(CommCalendarVo vo) {
		return ccdao.updateEvent(vo);
	}
	public int deleteEvent(String cc_name) {
		return ccdao.deleteEvent(cc_name);
	}
	public int selectEvent(int comm_num) {
		return ccdao.selectEvent(comm_num);
	}
	public List<CommCalendarVo> listEvent(int comm_num) {
		return ccdao.listEvent(comm_num);
	}
}
