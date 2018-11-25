package com.kfi.ysy.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommAdminDao;

import com.kfi.ysy.vo.CommSkinCoverVo;
import com.kfi.ysy.vo.CommSkinProfileVo;

@Controller

public class CommAdminController {
	@Autowired 
	@Qualifier("commAdminServiceImpl") private CommonService service;
	@Autowired 
	@Qualifier("commSkinProfileServiceImpl") private CommonService cspservice;
	@Autowired 
	@Qualifier("commSkinCoverServiceImpl") private CommonService cscservice;
	@Autowired
	@Qualifier("communityServiceImpl") private CommonService cservice;
//////////////////////////////////////////////////////////////////////////////////////////////////
	//커뮤니티 가입회원 정보
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/community/commadmin/commuserlist", method=RequestMethod.GET)
	public String commuserlist(int comm_num,Model model) {	
		List<CommAdminDao> list=(List<CommAdminDao>)service.list(comm_num);
		int admin_num=(Integer)cservice.select(comm_num);
		if(list!=null) {
			model.addAttribute("commuserlist", list);
			model.addAttribute("comm_num",comm_num);
			model.addAttribute("commadmin_num",admin_num);
			return ".community.commadmin.commuserlist";
		}else {
			return "fail";
		}
	}
	@RequestMapping(value="/community/commadmin/commadminauth", method=RequestMethod.POST )
	public String commadminauth(CommunityVo vo, Model model) {
		int comm_num=vo.getComm_num();
		int result = cservice.update(vo);
		if(result>0) {	
			return "redirect:/mypage/mycomm/list";
		}
		return "fail";	
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////	
	//커뮤니티 스킨 변경
	@RequestMapping(value="/community/commadmin/commskin", method=RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public String commskinForm(int comm_num, Model model) {
		HashMap<String, Object> map =(HashMap<String, Object>)cscservice.list(comm_num);
		CommunityVo vo = (CommunityVo)map.get("cvo");
		List<CommSkinCoverVo> list = (List<CommSkinCoverVo>)map.get("csclist");
		model.addAttribute("commvo",vo);
		model.addAttribute("commskinlist",list);
		return ".community.commadmin.commskin";
	}
	//커뮤니티 스킨추가
	@RequestMapping(value="/community/commadmin/commskininsert", method=RequestMethod.POST)
	public String commskininsrt(int comm_num,MultipartHttpServletRequest multirequest) {
		int result=cscservice.insert(multirequest);
		if(result>0) {
			return "redirect:/community/commadmin/commskin?comm_num="+comm_num;
		}else {
			return "fail";
		}
	}
	//커뮤니티 스킨삭제
	@RequestMapping(value="/community/commadmin/commskindelete", method=RequestMethod.GET)
	public String commskindelete(int csc_num,int comm_num,HttpSession session) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		map.put("csc_num",csc_num);
		int result=cscservice.delete(map);
		if(result>0) {
			return "redirect:/community/commadmin/commskin?comm_num="+comm_num;
		}else {
			return "fail";
		}	
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////	
	//커뮤니티 프로필 
	@RequestMapping(value="/community/commadmin/commprofile", method=RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public String commprofileForm(int comm_num, Model model) {
		HashMap<String, Object> map=(HashMap<String, Object>)cspservice.select(comm_num);
		CommSkinProfileVo cspvo=(CommSkinProfileVo)map.get("cspvo");
		MembersVo mvo=(MembersVo)map.get("mvo");
		CommunityVo cvo=(CommunityVo)map.get("cvo");
		model.addAttribute("commprofile",cspvo);
		model.addAttribute("commadmininfo",mvo);
		model.addAttribute("comminfo",cvo);
		return ".community.commadmin.commprofile";
	}
	//커뮤니티 프로필 변경
	@RequestMapping(value="/community/commadmin/commprofileupdate", method=RequestMethod.POST, produces="application/json;charset=utf-8")
	@ResponseBody
	public String commprofileupdate(MultipartHttpServletRequest multirequest) {
		int result=cspservice.update(multirequest);	
		if(result>0) {
			return "success";
		}else {
			return "fail";
		}
	}
}
