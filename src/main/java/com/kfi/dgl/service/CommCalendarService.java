package com.kfi.dgl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.dgl.dao.CommCalendarDao;
import com.kfi.jyi.vo.CommCalendarVo;
import com.kfi.jyi.vo.CommCalendarVo2;

@Service
public class CommCalendarService {

	@Autowired CommCalendarDao ccdao;
	
	public int getMaxnum() {
		return ccdao.commgetMaxnum();
	}
	public int addEvent(CommCalendarVo2 vo) {
		return ccdao.insertEvent(vo);
	}
	public int updateEvent(CommCalendarVo2 vo) {
		return ccdao.updateEvent(vo);
	}
	public int deleteEvent(int cc_num) {
		return ccdao.deleteEvent(cc_num);
	}
	public CommCalendarVo2 selectEvent(int cc_num) {
		return ccdao.selectEvent(cc_num);
	}
	public List<CommCalendarVo> listEvent(int comm_num) {
		return ccdao.listEvent(comm_num);
	}
}
