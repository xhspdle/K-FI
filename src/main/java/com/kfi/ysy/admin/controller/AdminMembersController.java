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

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.ysy.util.AdminPageUtil;




@Controller
public class AdminMembersController {
	//ȸ������Ʈ ��ȸ
	@Autowired private MembersService mbservice;
	@RequestMapping(value = "/admin/mblist", method = RequestMethod.GET)
	public String mblist(@RequestParam(value="pagenum", defaultValue="1")int pagenum,Model model,String field, String keyword) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("field", field);
		map.put("keyword",keyword);
		int totalrowcnt=mbservice.getCnt(map);
		AdminPageUtil apu=new AdminPageUtil(totalrowcnt, pagenum, 5, 5);
		map.put("startrow",	apu.getStartrow());
		map.put("endrow", apu.getEndrow());
		List<MembersVo> mblist = mbservice.list(map);
		if(mblist!=null) {
			model.addAttribute("mblist", mblist);
			model.addAttribute("apu", apu);
			model.addAttribute("field",field);
			model.addAttribute("keyword",keyword);
			return ".admin.mblist";
		}else {
			return "fail";
		}
	}
	//ȸ�� ����
	@RequestMapping(value="/admin/mbdelete", method=RequestMethod.GET)
	public String mbdelete(int user_num) {
		int result=mbservice.delete(user_num);
		if(result>0) {
			System.out.println("��������!!!!");
		}else{
			System.out.println("�ȵ�.");	
		}
		return "redirect:/admin/mblist";
	}
/*	@RequestMapping(value="/mbgetinfo", method=RequestMethod.GET)
	public String mbgetinfo(int user_num, Model model) {
		MembersVo vo=mbservice.mbgetinfo(user_num);
		model.addAttribute("mbinfo", vo);
		return "redirect:/mblist";
	}*/
	//����� ����Ȯ��
	@RequestMapping(value="/admin/mbgetinfo", produces="application/json;charset=utf-8")
	@ResponseBody
	public String mbgetinfo(int user_num) {
		MembersVo vo=mbservice.select(user_num);
		JSONObject obj=new JSONObject();
		obj.put("user_id", vo.getUser_id());
		obj.put("user_pwd", vo.getUser_pwd());
		obj.put("user_nick", vo.getUser_nickname());
		obj.put("user_stat",vo.getUser_status());
		obj.put("user_email", vo.getUser_email());
		obj.put("user_date",vo.getUser_regdate());
		return obj.toString();
	}
	//����� �߰�
	@RequestMapping(value="/admin/mbinsert",method=RequestMethod.POST)
	public String mbinsert(MembersVo vo) {
		int user_num = mbservice.getMaxnum()+1;
		vo.setUser_num(user_num);
		int result= mbservice.join(vo);
		if(result>0) {
			return "redirect:/admin/mblist";
		}else {
			return "fail";
		}
	}
	@RequestMapping(value="/admin/mbupdate",method=RequestMethod.POST)
	public String mbupdate(MembersVo vo) {
		int result=mbservice.update(vo);
		if(result>0) {
			return "redirect:/admin/mblist";
		}else {
			return "fail";
		}
	}
}
