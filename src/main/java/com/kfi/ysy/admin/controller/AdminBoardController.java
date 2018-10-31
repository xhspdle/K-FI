package com.kfi.ysy.admin.controller;


import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ysy.service.AdminBoardService;
import com.kfi.ysy.util.AdminPageUtil;
import com.kfi.ysy.vo.AdminBoardVo;



@Controller
public class AdminBoardController {
	@Autowired 
	private AdminBoardService abservice;
	//관리자 게시판 리스트조회
	@RequestMapping("/ablist")
	public String ablist(@RequestParam(value="pagenum",defaultValue="1")int pagenum, 
			String field,String keyword, Model model) {	
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("field", field);
		map.put("keyword", keyword);
		int totalrowcnt=abservice.abgetcnt(map);
		AdminPageUtil apu=new AdminPageUtil(totalrowcnt, pagenum, 5, 5);
		map.put("startrow", apu.getStartrow());
		map.put("endrow", apu.getEndrow());
		List<AdminBoardVo> ablist = abservice.ablist(map);
		if(ablist!=null) {
			model.addAttribute("ablist", ablist);
			model.addAttribute("apu", apu);
			model.addAttribute("field",field);
			model.addAttribute("keyword",keyword);
			return ".admin.adminboard";
		}else{
			return ".main.error";
		}
	}
	//관리자 게시글 양식
	@RequestMapping(value="/abinsert", method=RequestMethod.GET)
	public String abinsertForm() {
		return ".admin.abinsert";
	}
	//관리자 게시글 등록
	@RequestMapping(value="/abinsert", method=RequestMethod.POST)
	public String abinsert(AdminBoardVo vo) {
		int ab_num=abservice.abmaxnum()+1;
		vo.setAb_num(ab_num);
		int result=abservice.abinsert(vo);
		if (result>0){
			return "redirect:/ablist";		
		}else {
			return ".admin.error";
		}
	}
	//관리자 게시글 삭제
	@RequestMapping(value="/abdelete" ,method=RequestMethod.GET)
	public String abdelete(int ab_num) {
		int result = abservice.abdelete(ab_num);
		if (result>0){
			return "redirect:/ablist";		
		}else {
			return ".admin.error";
		}
	}
	//게시글 수정
	@RequestMapping(value="/abdetail" , produces="application/json;charset=utf-8")
	@ResponseBody
	public String abdetail(int ab_num) {
		AdminBoardVo vo=abservice.abdetail(ab_num);		
		JSONObject obj=new JSONObject();
	/*	
		String ab_content=vo.getAb_content();
		Date ab_date=vo.getAb_date();
		int ab_notice=vo.getAb_notice();
		String ab_title=vo.getAb_title();
		int ab_admin_num=vo.getAdmin_num();
		*/	
		if (vo!=null){
			obj.put("ab_num", ab_num);
			obj.put("ab_title", vo.getAb_title());
			obj.put("ab_content", vo.getAb_content());
			obj.put("ab_admin_num", vo.getAdmin_num());
			obj.put("ab_notice", vo.getAb_notice());
			obj.put("ab_date", vo.getAb_date());		
		}else {
			obj.put("msg","사용가능한 아이디입니다.");	
		}
		return obj.toString();
	}
}

