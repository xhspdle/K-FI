package com.kfi.ysy.admin.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.ysy.util.AdminPageUtil;




@Controller
public class AdminMembersController {
	@Autowired private MembersService mbservice;
	@RequestMapping(value = "/mblist", method = RequestMethod.GET)
	public String mblist( Model model) {
		

		List<MembersVo> mblist = mbservice.list();
		if(mblist!=null) {
			model.addAttribute("mblist", mblist);
			return ".admin.mblist";
		}else {
			return ".error";
		}
	}
/*	@RequestMapping(value="/mbdelete", method=RequestMethod.GET)
	public String mbdelete(int user_num) {
		System.out.println(user_num);
		int result=mbservice.mbdelete(user_num);
		if(result>0) {
			System.out.println("사용불가능한 아이디입니다!!!!");
		}else{
			System.out.println("사용가능한 아이디입니다.");	
		}
		return "redirect:/mblist";
	}
	@RequestMapping(value="/mbgetinfo", method=RequestMethod.GET)
	public String mbgetinfo(int user_num, Model model) {
		MembersVo vo=mbservice.mbgetinfo(user_num);
		model.addAttribute("mbinfo", vo);
		return "redirect:/mblist";
	}
	@RequestMapping(value="/mbgetinfo", produces="application/json;charset=utf-8")
	@ResponseBody
	public String mbgetinfo(int user_num) {
		MembersVo vo=mbservice.mbgetinfo(user_num);
		JSONObject obj=new JSONObject();
		obj.put("acc_id", vo.getUser_id());
		obj.put("acc_nick", vo.getUser_nickname());
		obj.put("acc_stat",vo.getUser_status());
		obj.put("acc_email", vo.getUser_email());
		obj.put("acc_date",vo.getUser_regdate());
		System.out.println(obj.toString());
		return obj.toString();
	}*/
}
