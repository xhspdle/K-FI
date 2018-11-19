package com.kfi.ysy.admin.controller;

import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.MyBoardVo;
import com.kfi.ysy.service.AccuseService;
import com.kfi.ysy.util.AdminPageUtil;
import com.kfi.ysy.vo.AccuseVo;

//�Ű�Խ���
@Controller
public class AccuseController {
	@Autowired 
	private AccuseService acservice;
	@Autowired
	@Qualifier("myBoardServiceImpl") private CommonService mbService;
	//�Ű�Խ��� ����Ʈ
	@RequestMapping("/aclist")
	public String aclist(@RequestParam(value="pagenum", defaultValue="1")int pagenum,String field, String keyword, Model model) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("field", field);
		map.put("keyword",keyword);
		int totalrowcnt=acservice.acgetcnt(map);
		AdminPageUtil apu=new AdminPageUtil(totalrowcnt, pagenum, 6, 5);
		map.put("startrow",apu.getStartrow());	
		map.put("endrow",apu.getEndrow());
		List<AccuseVo> aclist = acservice.aclist(map);
		if(aclist!=null) {
			model.addAttribute("aclist", aclist);
			model.addAttribute("apu",apu);
			model.addAttribute("field",field);
			model.addAttribute("keyword",keyword);
			return ".admin.accuseboard";
		}else {
			return ".admin.error";
		}
	}
	@RequestMapping(value="/acdelete", method=RequestMethod.GET)
	public String acdelete(int ac_num) {
		int result=acservice.acdelete(ac_num);
		if(result>0) {
			return "redirect:/aclist";
		}else {
			return null;
		}	
	}
//�Ű� ���뺸��

	/*	@RequestMapping(value="/acdetail", produces="application/json;charset=utf-8")
	@ResponseBody
	public String acdetail(int ac_num) {
		AccuseVo vo=acservice.acdetail(ac_num);
		JSONObject obj=new JSONObject();
		if(vo!=null) {
			obj.put("user_id", vo.getUser_id());
			obj.put("user_pwd", vo.getUser_pwd());
			obj.put("user_nick", vo.getUser_nickname());
			obj.put("user_stat",vo.getUser_status());
			obj.put("user_email", vo.getUser_email());
			obj.put("user_date",vo.getUser_regdate());
		}
	}*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/acinsert", method=RequestMethod.GET)
	public String acinsertForm(@RequestParam(value="mb_num",defaultValue="0")int mb_num,
			@RequestParam(value="cb_num",defaultValue="0")int cb_num,Model model) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		if(mb_num!=0) {
			map.put("mb_num", mb_num);
			map=(HashMap<String, Object>)mbService.select(map);
			model.addAttribute("vo", map.get("boardVo"));
		}else if(cb_num!=0) {
			map.put("cb_num", cb_num);
			//map=(HashMap<String, Object>)cbService.select(map);
			//model.addAttribute("vo", map.get("commBoardVo"));
		}
		return ".admin.accuseinsert";
	}
	@RequestMapping(value="/acinsert", method=RequestMethod.POST)
	public String acinsert(AccuseVo vo) {
		vo.setAc_num(acservice.acgetcnt()+1);
		acservice.acinsert(vo);
		return ".admin.accuseinsert";
	}
}
