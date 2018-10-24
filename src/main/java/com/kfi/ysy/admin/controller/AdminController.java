package com.kfi.ysy.admin.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ysy.admin.service.AdminService;
import com.kfi.ysy.admin.vo.AdminVo;


@Controller
public class AdminController {
	@Autowired private AdminService service;
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminmain() {
		return ".admin";
	}
	@RequestMapping(value="/adlogin", method=RequestMethod.GET)
	public String adloginForm() {
		return ".admin.login";
	}
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
	@RequestMapping("/adlogout")
	public String adlogout(HttpSession session) {
		session.invalidate();
		return ".admin";
	}
	
	@RequestMapping(value="/adcheckid", produces="application/json;charset=utf-8" )
	@ResponseBody
	public String adcheckid(String admin_id) {	
		int result=service.adcheckid(admin_id);
		JSONObject obj=new JSONObject();
		if(result>0) {
			obj.put("msg","사용불가능한 아이디입니다!!!!");
		}else{
			obj.put("msg","사용가능한 아이디입니다.");	
		}
		return obj.toString();
	}	
	
	@RequestMapping(value = "/adjoin", method = RequestMethod.GET)
	public String adjoinForm() {
		return ".admin.join";
	}
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
	
}
	

