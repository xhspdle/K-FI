package com.kfi.ysy.faq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.ysy.faq.service.FaqService;
import com.kfi.ysy.faq.vo.FaqVo;

@Controller
public class FaqController {
	@Autowired
	private FaqService faqservice;
	@RequestMapping(value="/faqlist",method=RequestMethod.GET)
	public String faqlist(Model model) {
		List<FaqVo> faqlist=faqservice.faqlist();
		model.addAttribute("faqlist",faqlist);
		return ".faq.faqlist";
	}
	@RequestMapping(value="/faqdetail",method=RequestMethod.GET)
	public String faqdetail(int qa_num,Model model) {
		FaqVo vo=faqservice.faqdetail(qa_num);
		model.addAttribute("faqinfo", vo);
		return ".faq.faqdetail";
	}
}
