package com.kfi.dgl.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.dgl.vo.CertiMailVo;
import com.kfi.dgl.vo.MembersVo;
@Repository
public class MembersDao {
	@Autowired private SqlSession sqlSession;
	private final static String
	NAMESPACE="com.kfi.mybatis.dgl.MembersMapper";
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insert(MembersVo vo) {
		return sqlSession.insert(NAMESPACE +".insert", vo);
	}
	
	public int delete(int num) {
		return sqlSession.delete(NAMESPACE +".delete",num);
	}
	
	/*public MembersVo select(int num) {
		return sqlSession.selectList(NAMESPACE + ".select");
	}*/
	public int update(MembersVo vo) {
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	//로그인
	public MembersVo login(HashMap<String,Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".login",map);
	}
	//마지막 유저번호
	public int getMaxnum() {
		return sqlSession.selectOne(NAMESPACE + ".getMaxnum");
	}
	//유저번호
	public int getCtn() {
		return sqlSession.selectOne(NAMESPACE + ".getCount");
	}
	//id 체크
	public int idCheck() {
		return sqlSession.selectOne(NAMESPACE + ".idCheck");
	}
	//사용자 인증 상태 변경
	public int verify(MembersVo vo) {
		return sqlSession.update(NAMESPACE + ".getVerify");
	}
	//인증코드(키) 생성
	public int createKey(String user_email) {
		return sqlSession.insert(NAMESPACE + ".createKey", user_email);
	}
	//동일 이메일 찾기
	public int findEmail(MembersVo vo) {
		return sqlSession.selectOne(NAMESPACE + ".findEmail", vo);
	}
	////////////////////////////admin에서 사용
	public List<MembersVo> list() {
		return sqlSession.selectList(NAMESPACE +".list");
	}
	public MembersVo select(int user_num) {
		return sqlSession.selectOne(NAMESPACE+".select",user_num);
	}

}
