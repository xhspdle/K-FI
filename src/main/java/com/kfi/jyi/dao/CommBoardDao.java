package com.kfi.jyi.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommBoardCntVo;
import com.kfi.jyi.vo.CommBoardProfileVo;
import com.kfi.jyi.vo.CommBoardVo;

@Repository
public class CommBoardDao {
	@Autowired private SqlSession session;
	private final static String NAMESPACE="com.kfi.mybatis.jyi.CommBoardMapper";
		
	public int getMaxNum() {
		return session.selectOne(NAMESPACE+".getMaxNum");
	}
	
	public int insert(CommBoardVo vo) {
		return session.insert(NAMESPACE+".insert",vo);
	}
	
	public List<CommBoardVo> getNotice(int comm_num) {
		return session.selectList(NAMESPACE+".getNotice",comm_num);
	}
	
	public CommBoardVo select(int cb_num) {
		return session.selectOne(NAMESPACE+".select",cb_num);
	}
	
	
	public List<CommBoardVo> list(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE+".list",map);
	}
	
	
	public List<CommBoardVo> list_Views(HashMap<String, Object> map) {
		return session.selectList(NAMESPACE+".list_Views",map);
	}
	
	
	public CommBoardCntVo getBoardCnt(int cb_num) {
		return session.selectOne(NAMESPACE+".getBoardCnt",cb_num);
	}
	
	public int delete(int cb_num) {
		return session.delete(NAMESPACE+".delete",cb_num);
	}
	
	public int commBoard_checkPwd(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".commBoard_checkPwd", map);
	}
	
	public int updateViews(int cb_num) {
		return session.update(NAMESPACE+".updateViews", cb_num);
	}
	
	public int getViews(int cb_num) {
		return session.selectOne(NAMESPACE+".getViews",cb_num);
	}
	
	public CommBoardProfileVo getCommBoardProfile(int cb_num) {
		return session.selectOne(NAMESPACE+".getCommBoardProfile",cb_num);
	}
	
	public int prevCbNum(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".prevCbNum",map);
	}
	
	public int nextCbNum(HashMap<String, Object> map) {
		return session.selectOne(NAMESPACE+".nextCbNum",map);
	}
	
	public int totalRowCount_commBoardList(int comm_num) {
		return session.selectOne(NAMESPACE+".totalRowCount_commBoardList",comm_num);
	}
	
	public int update(CommBoardVo vo) {
		return session.update(NAMESPACE+".update",vo);
	}
	
}
