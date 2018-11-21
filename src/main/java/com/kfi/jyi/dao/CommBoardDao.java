package com.kfi.jyi.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.jyi.vo.CommBoardCntVo;
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
	
}
