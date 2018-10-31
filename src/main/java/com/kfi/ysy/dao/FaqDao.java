package com.kfi.ysy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfi.ysy.vo.FaqVo;
@Repository
public class FaqDao {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.kfi.mybatis.ysy.FaqMapper.";
	public int faqmaxnum() {
		return sqlSession.selectOne(NAMESPACE+"faqmaxnum");
	};
	public List<FaqVo> faqlist(){
		return sqlSession.selectList(NAMESPACE+"faqlist");
	};
	public FaqVo faqdetail(int qa_num) {
		return sqlSession.selectOne(NAMESPACE+"faqdetail", qa_num);
	};
	public int faqinsert(FaqVo vo) {
		return sqlSession.insert(NAMESPACE+"faqinsert", vo);
	}
}
