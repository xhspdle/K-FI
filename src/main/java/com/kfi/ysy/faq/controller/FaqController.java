package com.kfi.ysy.faq.controller;

import java.util.HashMap;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ysy.service.FaqService;
import com.kfi.ysy.vo.AdminVo;
import com.kfi.ysy.vo.FaqVo;

@Controller
public class FaqController {
	@Autowired
	private FaqService faqservice;
	//Q&A 리스트조회
	@RequestMapping(value="/faqlist",method=RequestMethod.GET)
	public String faqlist(Model model) {
		List<FaqVo> faqlist=faqservice.faqlist();
/*		for(int i=0;i<faqlist.size();i++) {
			FaqVo vo=faqlist.get(i);
			System.out.println("////////////content"+vo.getQa_num());
			System.out.println("////////////content"+vo.getUser_num());
			System.out.println("////////////content"+vo.getQa_title());
			System.out.println("////////////content"+vo.getQa_content());
			System.out.println("////////////content"+vo.getRef());
			System.out.println("////////////content"+vo.getLev());
			System.out.println("////////////content"+vo.getStep());
			System.out.println("////////////admin_num"+vo.getAdmin_num());
		}	*/	
		System.out.println(faqlist);
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

	//Q&A 게시글 답글 리스트
	@RequestMapping(value="/faqcomment",produces="application/json;charset=utf-8")
	@ResponseBody
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
	@RequestMapping(value="/faqcomminsert", method=RequestMethod.POST, produces="application/json;charset=utf-8")
/*	@RequestMapping(value="/faqcomminsert", method=RequestMethod.POST)*/
	
	public @ResponseBody void faqcomminsert(FaqVo vo,HttpServletRequest request) {
		HttpSession session=request.getSession();
		AdminVo adminvo=(AdminVo)session.getAttribute("admininfo");
		int qa_num = faqservice.faqmaxnum()+1;
		vo.setQa_num(qa_num);
		vo.setAdmin_num(adminvo.getAdmin_num());
		vo.setLev(vo.getLev()+1);
		faqservice.faqinsert(vo);
		
/*		vo.setQa_content("이거되냐?");
		vo.setQa_title("욕나오네");
		vo.setUser_num(1);
		System.out.println("////////////content"+vo.getQa_num());
		System.out.println("////////////content"+vo.getUser_num());
		System.out.println("////////////content"+vo.getQa_title());
		System.out.println("////////////content"+vo.getQa_content());
		System.out.println("/////////////////////ref"+vo.getRef());
		System.out.println("////////////content"+vo.getLev());
		System.out.println("////////////content"+vo.getStep());
		System.out.println("////////////admin_num"+vo.getAdmin_num());
	
		System.out.println("////////////////////"+result);*/

	}
	//Q&A 게시물 작성
	@RequestMapping(value="/faqinsert",method=RequestMethod.POST)
	public String faqinsert(FaqVo vo) {		
		int qa_num = faqservice.faqmaxnum()+1;
		vo.setQa_num(qa_num);
		vo.setRef(qa_num);
		vo.setRef(vo.getRef());
		vo.setLev(vo.getLev());
		vo.setStep(vo.getStep());
		int result=faqservice.faqinsert(vo);
		if(result>0) {
			return "redirect:/faqlist";
		}else {
			return ".faq.error";
		}
	}
}
