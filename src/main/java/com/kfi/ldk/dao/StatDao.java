package com.kfi.ldk.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ldk.vo.StatCommMemCntVo;
import com.kfi.ldk.vo.StatCommViewSumVo;
import com.kfi.ldk.vo.StatPeriodCommBoardCntVo;
import com.kfi.ldk.vo.StatPeriodCommViewSumVo;
import com.kfi.ldk.vo.StatPeriodMemCntVo;
import com.kfi.ldk.vo.StatPeriodMyBoardCntVo;
import com.kfi.ldk.vo.StatPeriodMyViewSumVo;

@Repository
public class StatDao {
	@Autowired SqlSession session;
	private static final String NAMESPACE="com.kfi.mybatis.ldk.StatMapper";
	public int totalMemCnt() {
		return session.selectOne(NAMESPACE + ".totalMemCnt");
	}
	public int totalCommCnt() {
		return session.selectOne(NAMESPACE + ".totalCommCnt");
	}
	public List<StatCommMemCntVo> commMemCnt() {
		return session.selectList(NAMESPACE + ".commMemCnt");
	}
	public List<StatCommViewSumVo> commViewSum(){
		return session.selectList(NAMESPACE + ".commViewSum");
	}
	public List<StatPeriodMemCntVo> periodMemCnt(int period){
		return session.selectList(NAMESPACE + ".periodMemCnt", period);
	}
	public List<StatPeriodMyBoardCntVo> periodMyBoardCnt(int period){
		return session.selectList(NAMESPACE + ".periodMyBoardCnt", period);
	}
	public List<StatPeriodCommBoardCntVo> periodCommBoardCnt(int period){
		return session.selectList(NAMESPACE + ".periodCommBoardCnt", period);
	}
	public List<StatPeriodMyViewSumVo> periodMyViewSum(int period){
		return session.selectList(NAMESPACE + ".periodMyViewSum", period);
	}
	public List<StatPeriodCommViewSumVo> periodCommViewSum(int period){
		return session.selectList(NAMESPACE + ".periodCommViewSum", period);
	}
}
