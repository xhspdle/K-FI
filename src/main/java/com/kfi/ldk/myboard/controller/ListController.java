package com.kfi.ldk.myboard.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.util.PageUtil;

@Controller(value="MyBoardListController")
public class ListController {
	@Autowired 
	@Qualifier("myBoardServiceImpl") private CommonService service;//Qualifier("앞문자소문자")
	@Autowired
	@Qualifier("mySkinServiceImpl") private CommonService mySkinService;
	@RequestMapping(value="/mypage/myboard/list",method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> list(@RequestParam(value="pageNum",defaultValue="1")int pageNum,
			@RequestParam(value="selectedUserNum",defaultValue="0")int selectedUserNum,
			String keyword,HttpServletRequest request,HttpSession session) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("keyword", keyword);
		int admin_num=0;
		int user_num=0;
		Object session_admin_num=session.getAttribute("admin_num");
		if(session_admin_num!=null && session_admin_num!="") {
			admin_num=(Integer)session_admin_num;
		}
		if(admin_num!=0) {
			String user_numm=request.getParameter("user_num");
			if(user_numm!=null) {
				user_num=Integer.parseInt(user_numm);
			}
		}else if(selectedUserNum!=0){
			user_num=selectedUserNum;
		}else {
			Object session_num=session.getAttribute("user_num");
			if(session_num!=null && session_num!="") {
				user_num=(Integer)session_num;
			}
		}
		map.put("user_num", user_num);
		int totalRowCount=service.getCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		map.put("pu", pu);
		map.put("list", service.list(map));
		return map;
	}
	@RequestMapping(value="/mypage/myboard/list",method=RequestMethod.POST)
	public String searchList(@RequestParam(value="pageNum",defaultValue="1")
			int pageNum,String keyword,Model model){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("keyword", keyword);
		int totalRowCount=service.getCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		model.addAttribute("pu", pu);
		model.addAttribute("keyword", keyword);
		model.addAttribute("list", service.list(map));
		return ".mypage.myboard.searchMain";
	}
	@RequestMapping(value="/mypage/myboard/selectList",method=RequestMethod.GET)
	public String selectList(@RequestParam(value="pageNum",defaultValue="1")int pageNum,
			@RequestParam(value="selectedUserNum",defaultValue="0")int selectedUserNum,Model model){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("user_num", selectedUserNum);
		int totalRowCount=service.getCount(map);
		PageUtil pu=new PageUtil(pageNum, totalRowCount, 5, 5);
		map.put("startRow", pu.getStartRow());
		map.put("endRow", pu.getEndRow());
		model.addAttribute("pu", pu);
		model.addAttribute("selectedUserNum", selectedUserNum);
		model.addAttribute("list", service.list(map));
		return ".mypage.myboard.searchMain";
	}
	@SuppressWarnings("unchecked")
	@ModelAttribute("msv")
	public MySkinViewVo myskin(HttpSession session,
			@RequestParam(value="selectedUserNum",defaultValue="0")int selectedUserNum){
		int user_num=0;
		if(selectedUserNum!=0) {
			user_num=selectedUserNum;
		}else {
			user_num=(Integer)session.getAttribute("user_num");
		}
		MySkinViewVo msv=new MySkinViewVo(0,user_num, "기본", "#00cee8","", 0, 0, "default-profile.png", "default-profile.png", 0,"logo2.png", "logo2.png","");
		HashMap<String, Object> map=new HashMap<>();
		map.put("list", "ms_using");
		map.put("user_num", user_num);
		MySkinViewVo vo=(MySkinViewVo)service.select(map);
		if(vo!=null) {
				msv=vo;
		}
		return msv;
	}
}
