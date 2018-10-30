package com.kfi.jyi.mycomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.mycomm.service.MyCommCalendarService;
import com.kfi.jyi.mycomm.vo.CommCalendarVo;
import com.kfi.jyi.mycomm.vo.CommunityVo;
import com.kfi.jyi.util.MyCalendar;

@Controller(value = "MyCommCalendarController")
public class MyCommCalendarController {
	@Autowired private MyCommCalendarService service;
	
	@RequestMapping(value = "/mypage/mycommcalendar", method = RequestMethod.GET)
	public String mycommcalendar(Model model, HttpSession session, String comm_num, String comm_name) {
		MyCalendar mc=new MyCalendar();
		List<CommCalendarVo> monthlist=null;
		//int user_num=(Integer)session.getAttribute("user_num");
		if(comm_num==null || comm_num.equals("all")) {
			/* 유저가 속한 모든 커뮤니티의 월별 일정 불러오기 */
			monthlist=service.myCommCalendar(1); 
		}else {
			/* 유저가 달력에서 선택한 해당 커뮤니티의 일정목록 불러오기  */
			int commNum=Integer.parseInt(comm_num);
			monthlist=service.selectedCommCalList(commNum);
			model.addAttribute("comm_name",comm_name);
		}
		monthlist=mc.changeEnd(monthlist);
		model.addAttribute("monthlist",monthlist);

		/* 유저가 속한 모든 커뮤니티 목록 불러오기 */
		List<CommunityVo> communitylist =service.getMyCommunityList(1);
		model.addAttribute("communitylist", communitylist);

		return ".mypage.mycommcalendar.calendar";
	}
}
