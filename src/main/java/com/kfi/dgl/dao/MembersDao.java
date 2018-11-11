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
	
	//����
	public int join(MembersVo vo) {
		return sqlSession.insert(NAMESPACE +".join", vo);
	}
	//�α���
	public MembersVo login(HashMap<String,Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".login",map);
	}
	//������ ������ȣ
	public int getMaxnum() {
		return sqlSession.selectOne(NAMESPACE + ".getMaxnum");
	}
	//������ȣ
	public int getCnt(HashMap<String, Object> map) {
		return sqlSession.selectOne(NAMESPACE + ".getCount",map);
	}
	//id üũ
	public int idCheck(String user_id) {
		return sqlSession.selectOne(NAMESPACE + ".idCheck", user_id);
	}
	//�г��� üũ
	public int nickCheck(String user_nickname) {
		return sqlSession.selectOne(NAMESPACE + ".nickCheck", user_nickname);
	}
	//�̸��� üũ
	public int emailCheck(String user_email) {
		return sqlSession.selectOne(NAMESPACE + ".emailCheck", user_email);
	}
	//����� ���� ���� ����
	public int verify(String user_email) {
		return sqlSession.update(NAMESPACE + ".getVerify");
	}
	//�����ڵ�(Ű) ����
	public int createKey(String user_email, String cm_key) {
		CertiMailVo vo = new CertiMailVo();
		vo.setCm_key(cm_key);
		vo.setUser_email(user_email);
		return sqlSession.selectOne(NAMESPACE + ".createKey", vo);
	}
	//���� �̸��� ã��
	public int findEmail(MembersVo vo) {
		return sqlSession.selectOne(NAMESPACE + ".findEmail", vo);
	}
	//���̵� ã��
	public void findId(String user_email) {
		sqlSession.update(NAMESPACE + ".findId", user_email);
	}
	//��й�ȣ ã�� (�缳��)
	public int findPwd(String user_id) {
		return sqlSession.update(NAMESPACE + ".findPWD", user_id);
	}
	////////////////////////////admin���� ���
	public List<MembersVo> list(HashMap<String, Object> map) {
		return sqlSession.selectList(NAMESPACE +".list",map);
	}
	public MembersVo select(int user_num) {
		return sqlSession.selectOne(NAMESPACE+".select",user_num);
	}
	public int update(MembersVo vo) {
		return sqlSession.update(NAMESPACE + ".update",vo);
	}
	public int delete(int user_num) {
		return sqlSession.delete(NAMESPACE +".delete",user_num);
	}
}
