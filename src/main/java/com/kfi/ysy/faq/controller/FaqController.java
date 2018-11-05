package com.kfi.ysy.faq.controller;

import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ysy.service.FaqService;
import com.kfi.ysy.vo.FaqVo;

@Controller
public class FaqController {
	@Autowired
	private FaqService faqservice;
	//Q&A ����Ʈ��ȸ
	@RequestMapping(value="/faqlist",method=RequestMethod.GET)
	public String faqlist(Model model) {
		List<FaqVo> faqlist=faqservice.faqlist();
		for(int i=0;i<faqlist.size();i++) {
			FaqVo vo=faqlist.get(i);
			
		}
		
		
		System.out.println(faqlist);
		model.addAttribute("faqlist",faqlist);
		return ".faq.faqlist";
	}
	//Q&A ��������
	@RequestMapping(value="/faqdetail",method=RequestMethod.GET)
	public String faqdetail(int qa_num,Model model) {
		FaqVo vo=faqservice.faqdetail(qa_num);
		model.addAttribute("faqinfo", vo);
		return ".faq.faqdetail";
	}
	//Q&A �Խù��ۼ����
	@RequestMapping(value="/faqinsert",method=RequestMethod.GET)
	public String faqinsertForm() {
		return ".faq.faqinsert";
	}
	//Q&A �Խù� �ۼ�
	@RequestMapping(value="/faqinsert",method=RequestMethod.POST)
	public String faqinsert(FaqVo vo) {		
		if(vo.getQa_num()==0) {
			int qa_num = faqservice.faqmaxnum()+1;
			vo.setQa_num(qa_num);
			vo.setRef(qa_num);
		}else {
			vo.setRef(vo.getRef());
			vo.setLev(vo.getLev());
			vo.setStep(vo.getStep());

			System.out.println("ref1///"+vo.getRef());
			System.out.println("lev1///"+vo.getLev());
			System.out.println("step1///"+vo.getStep());
		}
		System.out.println("ref"+vo.getRef());
		System.out.println("lev"+vo.getLev());
		System.out.println("step"+vo.getStep());
		int result=faqservice.faqinsert(vo);
		if(result>0) {
			return "redirect:/faqlist";
		}else {
			return ".faq.error";
		}
	}
	//Q&A �Խñ� ���
	@RequestMapping(value="/faqcomment",produces="application/json;charset=utf-8")
	@ResponseBody()
	public String faqcomment(int qa_num) {
		List<FaqVo> list=faqservice.faqcomment(qa_num);
		JSONArray arr=new JSONArray();
		for(FaqVo vo:list) {
			JSONObject obj=new JSONObject();
			obj.put("qa_num", vo.getQa_num());
			obj.put("user_num", vo.getUser_num());
			obj.put("qa_title", vo.getQa_title());
			obj.put("qa_content", vo.getQa_content());
			obj.put("qa_date", vo.getQa_date());
			obj.put("ref", vo.getRef());
			obj.put("lev", vo.getLev());
			obj.put("step", vo.getStep());
			obj.put("admin_num", vo.getAdmin_num());
			arr.put(obj);
		}
		System.out.println(arr);
		return arr.toString();
	}
}
