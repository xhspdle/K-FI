package com.kfi.ysy.faq.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.ysy.faq.dao.FaqDao;
import com.kfi.ysy.faq.vo.FaqVo;
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
}
