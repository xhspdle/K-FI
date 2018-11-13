package com.kfi.jyi.mycomm.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kfi.jyi.service.MyCommCalendarService;
import com.kfi.jyi.util.MyCalendar;
import com.kfi.jyi.vo.CommCalendarVo;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;

@Controller(value = "MyCommCalendarController")
public class MyCommCalendarController {
	@Autowired
	private MyCommCalendarService service;
	
	@RequestMapping(value = "/mypage/mycomm/calendar", method = RequestMethod.GET)
	public String mycommcalendar(Model model, HttpSession session,
			@RequestParam(defaultValue = "all", required = false, value = "comm_num") String comm_num, String comm_name,
			@RequestParam(defaultValue = "gathering", required = false, value = "gathering") String gathering) {

		MyCalendar mc = new MyCalendar();
		List<CommCalendarVo> monthlist = null;
		// int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("user_num", 1); // user_num
		if (!(comm_num.equals("all"))) {
			int commNum = Integer.parseInt(comm_num);
			hm.put("comm_num", commNum);
		}else {
			hm.put("comm_num", null);
		}
		hm.put("gatheringOk", gathering);
		monthlist = service.getheringCalendar(hm);
		monthlist = mc.changeEnd(monthlist);
		model.addAttribute("monthlist", monthlist);
		model.addAttribute("comm_name", comm_name);
		model.addAttribute("gathering", gathering);

		/* 유저가 속한 모든 커뮤니티 목록 불러오기 */
		List<CommunityVo> communitylist = service.getMyCommunityList(1);
		model.addAttribute("communitylist", communitylist);
		
		return ".mypage.mycommcalendar.calendar";
	}
}