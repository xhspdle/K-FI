package com.kfi.ysy.admin.controller;

import java.util.HashMap;
import java.util.List;

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

import com.kfi.ysy.service.AdminService;
import com.kfi.ysy.vo.AdminVo;


@Controller
//관리자 페이지
public class AdminController {
	@Autowired private AdminService service;
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminmain() {
		return ".admin";
	}
//관리자로그인양식
	@RequestMapping(value="/admin/adlogin", method=RequestMethod.GET)
	public String adloginForm() {
		return ".admin.login";
	}
//관리자로그인
	@RequestMapping(value="/admin/adlogin", method=RequestMethod.POST)
	public String adlogin(HttpServletRequest request) {
		String admin_id=request.getParameter("admin_id");
		String admin_pwd=request.getParameter("admin_pwd");
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("admin_id", admin_id);
		map.put("admin_pwd", admin_pwd);
		AdminVo vo=service.adlogin(map);
		if(vo!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("admininfo", vo);
			return ".admin.adminpage";
		}else {
			return ".main.error";
		}
	}
//관리자 로그아웃
	@RequestMapping("/admin/adlogout")
	public String adlogout(HttpSession session) {
		session.invalidate();
		return ".admin";
	}
//관리자 등록 id 체크	
	@RequestMapping(value="/adcheckid", produces="application/json;charset=utf-8" )
	@ResponseBody
	public String adcheckid(String admin_id) {	
		int result=service.adcheckid(admin_id);
		JSONObject obj=new JSONObject();
		if(result>0) {
			obj.put("msg","fail");
		}else{
			obj.put("msg","success");	
		}
		return obj.toString();
	}	
//관리자 가입 양식
	@RequestMapping(value = "/admin/adjoin", method = RequestMethod.GET)
	public String adjoinForm() {
		return ".admin.join";
	}
//관리자 등록
	@RequestMapping(value = "/admin/adjoin", method = RequestMethod.POST)
	public String adjoin(AdminVo vo) {
		int admin_num=service.abmaxnum()+1;
		vo.setAdmin_num(admin_num);
		int result=service.adjoin(vo);
		if(result>0) {
			return ".admin";
		}else{
			return ".admin";
		}
	}
//관리자 목록
/*	@RequestMapping(value="/adminlist", produces="application/json;charset=utf-8")
	@ResponseBody
	public String adminlist() {
		List<AdminVo> adminlist=service.adminlist();
		JSONArray jsonarr=new JSONArray();
		for(int i=0;i<adminlist.size();i++) {
			JSONObject json=new JSONObject();
			AdminVo vo=adminlist.get(i);
			json.put("admin_num", vo.getAdmin_num());
			json.put("admin_id", vo.getAdmin_id());
			json.put("admin_pwd", vo.getAdmin_pwd());
			json.put("admin_nick", vo.getAdmin_nick());
			json.put("admin_email", vo.getAdmin_email());
			json.put("admin_regdate", vo.getAdmin_regdate());
			jsonarr.put(json);
		}
		return jsonarr.toString();	
	}*/
	
	@RequestMapping(value="/admin/adminlist", method=RequestMethod.GET)
	public String adminlist(Model model) {	
		List<AdminVo> adminlist=service.adminlist();
		if(adminlist!=null) {
			model.addAttribute("adminlist", adminlist);
			return ".admin.adminlist";
		}else{
			return ".admin";
		}	
	}
//관리자 정보보기
	@RequestMapping(value="/admin/addetail", produces="application/json;charset=utf-8")
	@ResponseBody
	public String addetail(int admin_num) {
		AdminVo adminvo=service.addetail(admin_num);
		JSONObject json=new JSONObject();
		json.put("admin_num", adminvo.getAdmin_num());
		json.put("admin_id", adminvo.getAdmin_id());
		json.put("admin_pwd", adminvo.getAdmin_pwd());
		json.put("admin_nick", adminvo.getAdmin_nick());
		json.put("admin_email", adminvo.getAdmin_email());
		json.put("admin_regdate", adminvo.getAdmin_regdate());
		return json.toString(); 
	}
//관리자 수정	
/*	@RequestMapping(value="/admodify", method=RequestMethod.POST)
	public String admodify(HttpServletRequest request, AdminVo vo) {	
		HttpSession session=request.getSession();
		AdminVo adminvo=(AdminVo)session.getAttribute("admininfo");
		String admin_id=vo.getAdmin_id();
		String admin_pwd=vo.getAdmin_pwd();
		if(adminvo.getAdmin_id().equals(admin_id)) {
			System.out.println(adminvo.getAdmin_id());
			service.admodify(vo);
			session.invalidate();
			HashMap<String, String> map=new HashMap<String, String>();
			map.put("admin_id", admin_id);
			map.put("admin_pwd", admin_pwd);
			AdminVo newvo=service.adlogin(map);
			if(newvo!=null) {
				session.setAttribute("admininfo", newvo);
				return ".admin.adminlist";
			}else {
				return ".admin.adminlist";
			}
		}
	}*/
	//관리자 수정
	@RequestMapping(value="/admin/admodify", method=RequestMethod.POST)
	public String admodify(AdminVo vo) {
		int result=service.admodify(vo);
		if(result>0) {
			return "redirect:/admin/adminlist";
		}else {
			return null;
		}
	}
	//관리자 삭제
	@RequestMapping(value="/admin/addelete", method=RequestMethod.GET)
	public String addelete(int admin_num, HttpSession session) {
		int result = service.addelete(admin_num);
		if(result>0) {
			session.invalidate();
			return "redirect:/admin/content";
		}else {
			return null;
		}
	}
	//관리자 정보 및 스킨
	@RequestMapping(value="/admin/admindetail", method=RequestMethod.GET)
	public String admindetailForm() {
		return ".admin.admindetail";
	}
}
	

