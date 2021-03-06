package com.kfi.ysy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ysy.dao.FaqDao;
import com.kfi.ysy.vo.FaqVo;
@Service
public class FaqService {
	@Autowired
	private FaqDao dao;
	public int faqmaxnum(){
		return dao.faqmaxnum();
	}
	public List<FaqVo> faqlist(){
		return dao.faqlist();
	}
	public FaqVo faqdetail(int qa_num) {
		return dao.faqdetail(qa_num);
	}
	public int faqinsert(FaqVo vo) {
		return dao.faqinsert(vo);
	}
	public List<FaqVo> faqcomment(int qa_num){
		return dao.faqcomment(qa_num);
	}
	public int faqdelete(int qa_num) {
		return dao.faqdelete(qa_num);
	}
}
