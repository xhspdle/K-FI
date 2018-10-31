package com.kfi.jyi.mycomm.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfi.jyi.service.MyCommCalendarService;
import com.kfi.jyi.util.MyCalendar;
import com.kfi.jyi.vo.CommCalendarVo;
import com.kfi.jyi.vo.CommunityVo;

@Controller(value = "MyCommCalendarController")
public class MyCommCalendarController {
	@Autowired private MyCommCalendarService service;
	
	@RequestMapping(value = "/mypage/mycommcalendar", method = RequestMethod.GET)
	public String mycommcalendar(Model model, HttpSession session, 
			@RequestParam(defaultValue="all",required=false,value="comm_num") String comm_num, 
			String comm_name, 
			@RequestParam(defaultValue="gathering",required=false,value="gathering") String gathering) {
	
		MyCalendar mc=new MyCalendar();
		List<CommCalendarVo> monthlist=null;
		//int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> hm=new HashMap<>();
		if(comm_num.equals("all") && gathering.equals("gathering")) {
			 monthlist=service.myCommCalendar(1);//user_num
			 System.out.println("??");
		}else{
			 System.out.println("!!");
			hm.put("user_num", 1);//user_num
			hm.put("selected","x");
			if(!(comm_num.equals("all"))) {
				hm.put("selected","selected");
			}
			int commNum=Integer.parseInt(comm_num);
			hm.put("comm_num",commNum);
			hm.put("gatheringOk","x");
			if(!(gathering.equals("gathering"))) {
				hm.put("gatheringOk","gatheringOk");
			}
			monthlist=service.getheringCalendar(hm);
		}
		monthlist=mc.changeEnd(monthlist);
		model.addAttribute("monthlist",monthlist);

		/* 유저가 속한 모든 커뮤니티 목록 불러오기 */
		List<CommunityVo> communitylist =service.getMyCommunityList(1);
		model.addAttribute("communitylist", communitylist);

		return ".mypage.mycommcalendar.calendar";
	}
}