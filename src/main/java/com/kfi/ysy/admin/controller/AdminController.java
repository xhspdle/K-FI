package com.kfi.ysy.admin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ysy.admin.service.AdminService;
import com.kfi.ysy.admin.vo.AdminVo;


@Controller
//관리자 페이지
public class AdminController {
	@Autowired private AdminService service;
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminmain() {
		return ".admin";
	}
//관리자로그인양식
	@RequestMapping(value="/adlogin", method=RequestMethod.GET)
	public String adloginForm() {
		return ".admin.login";
	}
//관리자로그인
	@RequestMapping(value="/adlogin", method=RequestMethod.POST)
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
	@RequestMapping("/adlogout")
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
	@RequestMapping(value = "/adjoin", method = RequestMethod.GET)
	public String adjoinForm() {
		return ".admin.join";
	}
//관리자 등록
	@RequestMapping(value = "/adjoin", method = RequestMethod.POST)
	public String adjoin(AdminVo vo) {
		int admin_num=service.admaxcnt()+1;
		vo.setAdmin_num(admin_num);
		int result=service.adjoin(vo);
		if(result>0) {
			return ".admin";
		}else{
			return ".admin";
		}
	}
//관리자 목록
	@RequestMapping(value="/adminlist", produces="application/json;charset=utf-8")
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
	}
/*	
	@RequestMapping(value="/adminlist", method=RequestMethod.GET)
	public String adminlist(Model model) {
		List<AdminVo> adminlist=service.adminlist();
		model.addAttribute("adminlist", adminlist);
		if(adminlist!=null) {
			return ".admin.mblist";
		}else{
			return ".admin";
		}	
	}*/
}
	

