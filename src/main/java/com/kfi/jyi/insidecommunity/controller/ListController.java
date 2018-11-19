package com.kfi.jyi.insidecommunity.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;

@Controller("insideCommunityListController")
public class ListController {
	@Autowired 
	@Qualifier("commBoardServiceImpl") private CommonService commBoardservice;

	@Autowired 
	@Qualifier("insideCommunityServiceImpl") private CommonService insideCommService;
	
	@Autowired
	@Qualifier("mySkinServiceImpl")
	private CommonService mySkinService;
	
	@Autowired
	private MembersService membersSerivce;
	
	// model attribute annotation - 프로필, 커버 사진 넣기

	// 가입한 유저인지, 강퇴당한 유저인지 확인하기 (글쓰기 disabled)
	/*@ModelAttribute("checkUser")
	public int checkUser(Model model, HttpSession session, String comm_num) {
		int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> map=new HashMap<>();
		int commNum=0;
		if(comm_num!=null) {
			commNum=Integer.parseInt(comm_num);
		}
		map.put("comm_num",commNum);  
		map.put("user_num", user_num);
		int cul_status=(Integer)insideCommService.select(map);
		model.addAttribute("cul_status", cul_status);
		return cul_status;
	}*/
	
	//해당 커뮤니티의 선택한 게시물 불러오기
	@RequestMapping(value="/community/board/select",method=RequestMethod.GET)
	public String selectCommBoard(HttpSession session,String cb_num, Model model) {
		int comm_num=(Integer)session.getAttribute("comm_num");
		HashMap<String, Object> map=new HashMap<>();
		map.put("list","select");
		map.put("comm_num",comm_num);
		map.put("cb_num", Integer.parseInt(cb_num));

		List<CommBoardViewVo> list=(List<CommBoardViewVo>)commBoardservice.select(map);
		model.addAttribute("list",list);
		
		//글쓴이 프로필
		int writer=list.get(0).getUser_num();
		System.out.println(writer+"!!!!!!!!writer");
		HashMap<String, Object> skinMap=new HashMap<>();
		skinMap.put("list", "ms_using");
		skinMap.put("user_num", writer);
		MySkinViewVo msvo=(MySkinViewVo)mySkinService.select(skinMap);
		model.addAttribute("msvo",msvo);

		MembersVo vo=membersSerivce.select(writer);
		model.addAttribute("vo",vo);
		
		//tag
		
		
		
		
		//like
		
			
		
		return ".community.board.select";
	}
	
}
