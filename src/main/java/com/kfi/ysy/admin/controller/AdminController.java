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
	public String loginForm() {
		return ".admin.login";
	}
	@RequestMapping(value="/adlogin", method=RequestMethod.POST)
	public String login(HttpServletRequest request) {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		AdminVo vo=service.login(map);
		if(vo!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("admininfo", vo);
			return ".admin.adminpage";
		}else {
			return ".admin.login";
		}
			
	}
	@RequestMapping("/adlogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return ".main";
	}
	
	@RequestMapping(value="/checkid", produces="application/json;charset=utf-8" )
	@ResponseBody
	public String checkid(String id) {	
		int result=service.checkid(id);
		JSONObject obj=new JSONObject();
		if(result>0) {
			obj.put("msg","사용불가능한 아이디입니다!!!!");
		}else{
			obj.put("msg","사용가능한 아이디입니다.");	
		}
		return obj.toString();
	}	
	
	@RequestMapping(value = "/adjoin", method = RequestMethod.GET)
	public String joinForm() {
		return ".admin.join";
	}
	@RequestMapping(value = "/adjoin", method = RequestMethod.POST)
	public String join(AdminVo vo) {
		int result=service.join(vo);
		if(result>0) {
			return ".admin.result";
		}else{
			return ".admin.error";
		}
	}
}
	

