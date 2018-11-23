package com.kfi.ldk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ldk.dao.StatDao;
import com.kfi.ldk.vo.StatCommMemCntVo;
import com.kfi.ldk.vo.StatCommViewSumVo;
import com.kfi.ldk.vo.StatPeriodCommBoardCntVo;
import com.kfi.ldk.vo.StatPeriodCommViewSumVo;
import com.kfi.ldk.vo.StatPeriodMemCntVo;
import com.kfi.ldk.vo.StatPeriodMyBoardCntVo;
import com.kfi.ldk.vo.StatPeriodMyViewSumVo;

@Service
public class StatService {
	@Autowired private StatDao dao;
	public int totalMemCnt() {
		return dao.totalMemCnt();
	}
	public int totalCommCnt() {
		return dao.totalCommCnt();
	}
	public List<StatCommMemCntVo> commMemCnt(){
		return dao.commMemCnt();
	}
	public List<StatCommViewSumVo> commViewSum(){
		return dao.commViewSum();
	}
	public List<StatPeriodMemCntVo> periodMemCnt(int period){
		return dao.periodMemCnt(period);
	}
	public List<StatPeriodMyBoardCntVo> periodMyBoardCnt(int period){
		return dao.periodMyBoardCnt(period);
	}
	public List<StatPeriodCommBoardCntVo> periodCommBoardCnt(int period){
		return dao.periodCommBoardCnt(period);
	}
	public List<StatPeriodMyViewSumVo> periodMyViewSum(int period){
		return dao.periodMyViewSum(period);
	}
	public List<StatPeriodCommViewSumVo> periodCommViewSum(int period){
		return dao.periodCommViewSum(period);
	}
}