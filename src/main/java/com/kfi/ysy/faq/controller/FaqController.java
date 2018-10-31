package com.kfi.ysy.faq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

import com.kfi.ysy.service.FaqService;
import com.kfi.ysy.vo.FaqVo;

@Controller
public class FaqController {
	@Autowired
	private FaqService faqservice;
	//Q&A 리스트조회
	@RequestMapping(value="/faqlist",method=RequestMethod.GET)
	public String faqlist(Model model) {
		List<FaqVo> faqlist=faqservice.faqlist();
		model.addAttribute("faqlist",faqlist);
		return ".faq.faqlist";
	}
	//Q&A 세부정보
	@RequestMapping(value="/faqdetail",method=RequestMethod.GET)
	public String faqdetail(int qa_num,Model model) {
		FaqVo vo=faqservice.faqdetail(qa_num);
		model.addAttribute("faqinfo", vo);
		return ".faq.faqdetail";
	}
	//Q&A 게시물작성양식
	@RequestMapping(value="/faqinsert",method=RequestMethod.GET)
	public String faqinsertForm() {
		return ".faq.faqinsert";
	}
	//Q&A 게시물 작성
	@RequestMapping(value="/faqinsert",method=RequestMethod.POST)
	public String faqinsert(FaqVo vo) {
		int qa_num = faqservice.faqmaxnum()+1;
		vo.setQa_num(qa_num);
		int pnum =vo.getRef();
		System.out.println("ref"+vo.getRef());
		System.out.println("lev"+vo.getLev());
		System.out.println("step"+vo.getStep());
		if(pnum!=0) {
			vo.setRef(pnum);
			vo.setLev(vo.getLev());
			vo.setStep(vo.getStep());
			System.out.println("ref1///"+vo.getRef());
			System.out.println("lev1///"+vo.getLev());
			System.out.println("step1///"+vo.getStep());
		}
		int result=faqservice.faqinsert(vo);
		if(result>0) {
			return "redirect:/faqlist";
		}else {
			return ".faq.error";
		}
	}
	//Q&A 게시글 답글
	@RequestMapping(value="/faqcomment",produces="application/json;charset=utf-8")
	@ResponseBody
	public String faqcomment(FaqVo vo) {
		
		return "redirect:/faqlist";
	}
}
